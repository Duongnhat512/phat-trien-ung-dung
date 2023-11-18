package dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CongNhan;
import entities.LuongCongNhan;
import entities.LuongNhanVien;
import entities.NhanVien;
import entities.PhongBan;

public class BangLuongNhanVien_DAO {
	public LuongNhanVien getAllTableTinhLuong(String idNhanVien,int thang,int nam){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		CallableStatement cs = null;
		LuongNhanVien lnv = null;
		try {
		
			cs = con.prepareCall("{call TinhLuongNhanVien_proc(?, ?, ?, ?,?,?,?)}");

            // Thiết lập giá trị cho các tham số
			cs.setString(1, idNhanVien);
			cs.setInt(2, thang);
			cs.setInt(3, nam);
		    cs.registerOutParameter(4, Types.DECIMAL);
		    cs.registerOutParameter(5, Types.DECIMAL);
		    cs.registerOutParameter(6, Types.DECIMAL);
		    cs.registerOutParameter(7, Types.DECIMAL);
            // Gọi stored procedure
            cs.execute();
            double thue = cs.getDouble(4);
            double 	bhxh = cs.getDouble(5);
            double thuclanh = cs.getDouble(6);
            double tongTienLuong = cs.getDouble(7);
            lnv = new LuongNhanVien("LNV0001",LocalDate.now() ,new NhanVien(idNhanVien), tongTienLuong, thue,bhxh,thuclanh, thang,nam);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lnv;
	}
	public int[] getChiTietLuongNhanVien(String idNhanVien,int thang,int nam){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		CallableStatement cs = null;
		int[] values = new int[5];
		try {
		
			cs = con.prepareCall("{call chiTietLuongNhanVien_proc(?, ?, ?, ?,?,?,?,?)}");

            // Thiết lập giá trị cho các tham số
			cs.setString(1, idNhanVien);
			cs.setInt(2, thang);
			cs.setInt(3, nam);
		    cs.registerOutParameter(4, Types.INTEGER);
		    cs.registerOutParameter(5, Types.INTEGER);
		    cs.registerOutParameter(6, Types.INTEGER);
		    cs.registerOutParameter(7, Types.INTEGER);
		    cs.registerOutParameter(8, Types.INTEGER);
            // Gọi stored procedure
		    cs.execute();
//	        if (cs.execute()) {
	            values[0] = cs.getInt(4); // soNgayCongTrongThang
	            values[1] = cs.getInt(5); // soNgayDiLamThucTe
	            values[2] = cs.getInt(6); // soNgayNghiCoPhep
	            values[3] = cs.getInt(7); // soNgayNghiKhongPhep
	            values[4] = cs.getInt(8); // soTienNghiKhongPhep
//	        }
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}
	public ArrayList<PhongBan> getAllTablePhongBan(){
		ArrayList<PhongBan> dspb = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from PhongBan";
		try {
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(sql);
			while(r.next()) {
				String idPb = r.getString(1);
				String ten = r.getString(2);
				PhongBan p = new PhongBan(idPb, ten);
				dspb.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dspb;
	}
	public ArrayList<LuongNhanVien> getAllTableTinhLuongTheoThang(String phongBan, int thang, int nam) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<LuongNhanVien> dslnv = new ArrayList<>();

		try {
			String sql = "select bl.idLuongNVHC,bl.ngayTinhLuong,bl.idNhanVien,bl.thueLaoDong,bl.tienBaoHiemXaHoi,bl.tongLuong,bl.thucLanh,bl.thang,bl.nam \r\n"
					+ "from BangLuongNhanVien bl join NhanVien n on bl.idNhanVien=n.idNhanVien join PhongBan p on p.idPhongBan=n.idPhongBan \r\n"
					+ "where thang = ? and nam = ? and p.tenPhongBan = ?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, thang);
			st.setInt(2, nam);
			st.setString(3, phongBan);
			ResultSet r = st.executeQuery();

			while (r.next()) {
				String idLuong = r.getString(1);
				LocalDate l = LocalDate.parse(r.getString(2));
				String idNhanVien = r.getString(3);
				double thueLaoDong = r.getDouble(4);
				double tienBaoHiemXaHoi = r.getDouble(5);
				double tongLuong = r.getDouble(6);
				double thucLanh = r.getDouble(7);
				int thangg = r.getInt(8);
				int namm = r.getInt(9);
				NhanVien n = new NhanVien(idNhanVien);
				LuongNhanVien lnv =new LuongNhanVien(idLuong, l, n, tongLuong, thueLaoDong, tienBaoHiemXaHoi, thucLanh, thangg, namm);
				dslnv.add(lnv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dslnv;
	}
	public boolean kiemTraTonTaiLuongNhanVien(String idBangLuong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select idLuongNVHC from BangLuongNhanVien where idLuongNVHC=?";
		PreparedStatement st;
		ResultSet resultSet = null;
		boolean tonTai = false;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, idBangLuong);

			resultSet = st.executeQuery();
			// Nếu resultSet có bất kỳ bản ghi nào, tức là bản ghi tồn tại
			tonTai = resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tonTai;
	}
	public boolean themBangLuongNhanVien(LuongNhanVien luong, int thang, int nam) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "INSERT INTO BangLuongNhanVien (idLuongNVHC,ngayTinhLuong,idNhanVien,thueLaoDong,tienBaoHiemXaHoi,tongLuong,thucLanh,thang,nam) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement st;
		DecimalFormat a = new DecimalFormat("#");
		int r = 0;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, luong.getIdLuong());
			st.setString(2, luong.getNgayTinhLuong().toString());
			st.setString(3, luong.getNhanVien().getIdNhanVien());
			st.setDouble(4, luong.getThueLaoDong());
			st.setDouble(5, luong.getThueBHXH());
			st.setDouble(6, luong.getTongLuong());
			st.setDouble(7, luong.getThucLanh());
			st.setInt(8, thang);
			st.setInt(9, nam);
			r = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r > 0;
	}
}
