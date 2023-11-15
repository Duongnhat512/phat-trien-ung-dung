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
import entities.PhanXuong;
import entities.PhongBan;
import entities.TaiKhoan;

public class BangLuongCongNhan_DAO {
	public LuongCongNhan getAllTableTinhLuong(String idCongNhan, int thang, int nam) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		CallableStatement cs = null;
		LuongCongNhan lcn = null;
		try {

			cs = con.prepareCall("{call ThongTinLuongCongNhan(?, ?, ?, ?,?)}");

			// Thiết lập giá trị cho các tham số
			cs.setInt(1, thang);
			cs.setInt(2, nam);
			cs.setString(3, idCongNhan);
			cs.registerOutParameter(4, Types.DECIMAL);
			cs.registerOutParameter(5, Types.DECIMAL);
			// Gọi stored procedure
			cs.execute();
			double thucLanh = cs.getDouble(4);
			double luongHanhChanh = cs.getDouble(5);
			lcn = new LuongCongNhan("LCN0001", LocalDate.now(), new CongNhan(idCongNhan), thucLanh, luongHanhChanh,thang,nam);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lcn;
	}

	public int[] TinhTongSanLuongVaThoiGianLamViec(String idCongNhan, int thang, int nam) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		CallableStatement cs = null;
		LuongCongNhan lcn = null;
		int[] values = new int[2];
		try {

			cs = con.prepareCall("{call TinhTongSanLuongVaThoiGianLamViec(?, ?, ?, ?,?)}");

			// Thiết lập giá trị cho các tham số
			cs.setInt(1, thang);
			cs.setInt(2, nam);
			cs.setString(3, idCongNhan);
			cs.registerOutParameter(4, Types.DECIMAL);
			cs.registerOutParameter(5, Types.DECIMAL);
			// Gọi stored procedure
			cs.execute();
			values[0] = cs.getInt(4); // soNgayCongTrongThang
			values[1] = cs.getInt(5); // soNgayDiLamThucTe
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public boolean themBangLuongCongNhan(LuongCongNhan luong, int thang, int nam) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "INSERT INTO BangLuongCongNhan (idLuongCN, ngayTinhLuong, idCongNhan, tongLuong,thucLanh,thang,nam) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement st;
		DecimalFormat a = new DecimalFormat("#");
		int r = 0;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, luong.getIdLuongCN());
			st.setString(2, luong.getNgayTinhLuong().toString());
			st.setString(3, luong.getCongNhan().getIdCongNhan());
			st.setDouble(4, luong.getTongLuong());
			st.setDouble(5, luong.getThucLanh());
			st.setInt(6, thang);
			st.setInt(7, nam);
			r = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r > 0;
	}

	public boolean kiemTraTonTaiLuongCongNhan(String idBangLuong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select idLuongCN from BangLuongCongNhan where idLuongCN=?";
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

	public ArrayList<LuongCongNhan> getAllTableTinhLuongTheoThang(String phanXuong, int thang, int nam) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<LuongCongNhan> dslcn = new ArrayList<>();

		try {
			String sql = "SELECT bl.idLuongCN, bl.ngayTinhLuong, bl.idCongNhan, bl.tongLuong, bl.thucLanh, bl.thang, bl.nam "
					+ "FROM CongNhan CN " + "JOIN PhanXuong PX ON CN.idPhanXuong = PX.idPhanXuong "
					+ "join BangLuongCongNhan bl on bl.idCongNhan = cn.idCongNhan " + "WHERE thang = ?"
					+ "    AND nam = ?" + "    AND PX.tenPhanXuong = ?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, thang);
			st.setInt(2, nam);
			st.setString(3, phanXuong);
			ResultSet r = st.executeQuery();

			while (r.next()) {
				String idBangLuong = r.getString(1);
				LocalDate ngayTinhLuong = LocalDate.parse(r.getString(2));
				String idCongNhan = r.getString(3);
				double tongLuong = r.getDouble(4);
				double thucLanh = r.getDouble(5);
				int thangg = r.getInt(6);
				int namm = r.getInt(7);

				LuongCongNhan l = new LuongCongNhan(idBangLuong, ngayTinhLuong, new CongNhan(idCongNhan), tongLuong,
						thucLanh,thangg,namm);
				dslcn.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dslcn;
	}

	public ArrayList<String[]> getChiTietLuong(String idCongNhan, int thang, int nam) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    ArrayList<String[]> list = new ArrayList<>();
	    try {
	    	String sql = "SELECT SP.idSanPham, SP.tenSanPham, CDSP.tenCongDoan, " +
	                "SUM(4) AS TongSoLuong, " +
	                "SUM(BC.soLuongHoanThanh) AS TongSoLuongHoanThanh, " +
	                "SUM(BC.soLuongHoanThanh * CDSP.luongCongDoan * CL.heSoLuong * BC.heSoNgayLam) AS TongTien " +
	                "FROM CongNhan CN JOIN CongDoanPhanCong PC ON CN.idCongNhan = PC.idCongNhan " +
	                "JOIN BangChamCongCongNhan BC ON PC.idPhanCong = BC.idPhanCong " +
	                "JOIN CongDoanSP CDSP ON PC.idCongDoan = CDSP.idCongDoan " +
	                "JOIN SanPham SP ON CDSP.idSanPham = SP.idSanPham " +
	                "JOIN CaLam CL ON PC.idCaLam = CL.idCaLam " +
	                "WHERE MONTH(BC.ngayChamCong) = ? AND YEAR(BC.ngayChamCong) = ? AND CN.idCongNhan = ? " +
	                "GROUP BY SP.idSanPham, SP.tenSanPham, CDSP.tenCongDoan order by  SP.idSanPham,SP.tenSanPham, CDSP.tenCongDoan";

	        PreparedStatement st = con.prepareStatement(sql);
	        st.setInt(1, thang);
	        st.setInt(2, nam);
	        st.setString(3, idCongNhan);
	        ResultSet r = st.executeQuery();

	        while (r.next()) {
	            String[] values = new String[6];
	            values[0] = r.getString(1);
	            values[1] = r.getString(2);
	            values[2] = r.getString(3);
	            values[3] = r.getInt(4) + "";
	            values[4] = r.getInt(5) + "";
	            values[5] = r.getDouble(6)+"";
	            list.add(values);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}


}
