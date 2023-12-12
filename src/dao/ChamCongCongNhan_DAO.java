package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.BangChamCongCongNhan;
import entities.BangChamCongNhanVien;
import entities.ChucVu;
import entities.CongDoanPhanCong;
import entities.CongNhan;
import entities.NhanVien;
import entities.PhanXuong;
import entities.PhongBan;
import entities.TaiKhoan;

public class ChamCongCongNhan_DAO {
	private CongDoanPhanCong_DAO congDoanPhanCong_DAO = new CongDoanPhanCong_DAO();
	public ArrayList<CongNhan> getAllTableChamCong(int thang, int nam, String tenpb) {
		ArrayList<CongNhan> dscn = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT CN.idCongNhan, CN.hoTen, CN.phai, CN.ngaySinh, CN.ngayBatDauCongTac, CN.ngayKetThucCongTac, CN.idPhanXuong, CN.email, CN.soDienThoai, CN.tayNghe, CN.anhDaiDien, CN.phuCap, CN.tenTaiKhoan "
				+ "FROM CongNhan CN "
				+ "JOIN PhanXuong PX ON CN.idPhanXuong = PX.idPhanXuong "
				+ "JOIN CongDoanPhanCong PC ON CN.idCongNhan = PC.idCongNhan "
				+ "JOIN BangChamCongCongNhan BC ON PC.idPhanCong = BC.idPhanCong "
				+ "JOIN CongDoanSP CDSP ON PC.idCongDoan = CDSP.idCongDoan "
				+ "JOIN CaLam CL ON PC.idCaLam = CL.idCaLam "
				+ "WHERE MONTH(BC.ngayChamCong) = ? AND YEAR(BC.ngayChamCong) = ? AND PX.tenPhanXuong = ? "
				+ "GROUP BY CN.idCongNhan, CN.hoTen, CN.phai, CN.ngaySinh, CN.ngayBatDauCongTac, CN.ngayKetThucCongTac, CN.idPhanXuong, CN.email, CN.soDienThoai, CN.tayNghe, CN.anhDaiDien, CN.phuCap, CN.tenTaiKhoan ";
		if(tenpb.equals("Tất cả")) {
			sql = "SELECT CN.idCongNhan, CN.hoTen, CN.phai, CN.ngaySinh, CN.ngayBatDauCongTac, CN.ngayKetThucCongTac, CN.idPhanXuong, CN.email, CN.soDienThoai, CN.tayNghe, CN.anhDaiDien, CN.phuCap, CN.tenTaiKhoan\r\n"
					+ "	FROM CongNhan CN\r\n"
					+ "	JOIN PhanXuong PX ON CN.idPhanXuong = PX.idPhanXuong\r\n"
					+ "	JOIN CongDoanPhanCong PC ON CN.idCongNhan = PC.idCongNhan\r\n"
					+ "	JOIN BangChamCongCongNhan BC ON PC.idPhanCong = BC.idPhanCong\r\n"
					+ " JOIN CongDoanSP CDSP ON PC.idCongDoan = CDSP.idCongDoan\r\n"
					+ "	JOIN CaLam CL ON PC.idCaLam = CL.idCaLam\r\n"
					+ "	WHERE MONTH(BC.ngayChamCong) = ? AND YEAR(BC.ngayChamCong) = ? \r\n"
					+ "	GROUP BY CN.idCongNhan, CN.hoTen, CN.phai, CN.ngaySinh, CN.ngayBatDauCongTac, CN.ngayKetThucCongTac, CN.idPhanXuong, CN.email, CN.soDienThoai, CN.tayNghe, CN.anhDaiDien, CN.phuCap, CN.tenTaiKhoan";
		}
		try {
			PreparedStatement st = null;
			st = con.prepareStatement(sql);
			st.setInt(1, thang);
			st.setInt(2, nam);
			if(!tenpb.equals("Tất cả")) {
				st.setString(3, tenpb);				
			}
			ResultSet r = st.executeQuery();
			while (r.next()) {
				String id = r.getString(1);
				String tenCN = r.getString(2);
				boolean phai = r.getBoolean(3);
				LocalDate ngaySinh = r.getDate(4).toLocalDate();
				LocalDate ngayBatDauCongTac = r.getDate(5).toLocalDate();
				LocalDate ngayKetThucCongTac = r.getDate(6) != null ? r.getDate(6).toLocalDate() : null;
				String idPhanXuong = r.getString(7);
				String email = r.getString(8);
				String soDienThoai = r.getString(9);
				String tayNghe = r.getString(10);
				String anhDaiDien = r.getString(11);
				double phuCap = r.getDouble(12);
				String taiKhoan = r.getString(13);
				PhanXuong p = new PhanXuong(idPhanXuong);
				TaiKhoan t = new TaiKhoan(taiKhoan);
				String cccd = "";
				// Tạo đối tượng CongNhan và thêm vào danh sách
				CongNhan n = new CongNhan(id, tenCN, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, p, email, soDienThoai, tayNghe, t, anhDaiDien, cccd, phuCap);
				dscn.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dscn;
	}
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCong(){
		ArrayList<BangChamCongCongNhan> list = new ArrayList<BangChamCongCongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from BangChamCongCongNhan");
			while(rs.next()) {
				String idNgayChamCong = rs.getString(1);
				LocalDate ngayChamCong = LocalDate.parse(rs.getString(2));
				int soLuongHoanThanh = rs.getInt(3);
				CongDoanPhanCong congDoanPhanCong = congDoanPhanCong_DAO.getPhanCongTheoID(rs.getString(4));
				double heSoNgayLam = rs.getDouble(5);
				BangChamCongCongNhan bangChamCongCongNhan = new BangChamCongCongNhan(idNgayChamCong, ngayChamCong, soLuongHoanThanh, congDoanPhanCong, heSoNgayLam);
				list.add(bangChamCongCongNhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getSoLuongChamCong() {
		int sl = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select count(idNgayChamCong) from BangChamCongCongNhan");
			while(rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sl;
	}
	
	/**
	 * Lấy danh sách chấm công theo ngày, tháng, năm
	 * @param ngay
	 * @param thang
	 * @param nam
	 * @return
	 */
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCongTheoNgay(int ngay, int thang, int nam){
		ArrayList<BangChamCongCongNhan> list = new ArrayList<BangChamCongCongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from BangChamCongCongNhan where day(ngayChamCong) = ? and month(ngayChamCong) = ? and year(ngayChamCong) = ?");
			stm.setInt(1, ngay);
			stm.setInt(2, thang);
			stm.setInt(3, nam);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idNgayChamCong = rs.getString(1);
				LocalDate ngayChamCong = LocalDate.parse(rs.getString(2));
				int soLuongHoanThanh = rs.getInt(3);
				CongDoanPhanCong congDoanPhanCong = congDoanPhanCong_DAO.getPhanCongTheoID(rs.getString(4));
				double heSoNgayLam = rs.getDouble(5);
				BangChamCongCongNhan bangChamCongCongNhan = new BangChamCongCongNhan(idNgayChamCong, ngayChamCong, soLuongHoanThanh, congDoanPhanCong, heSoNgayLam);
				list.add(bangChamCongCongNhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Thêm chấm công
	 * @param ngayCong
	 * @return
	 */
	public boolean themChamCong(BangChamCongCongNhan ngayCong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("insert into BangChamCongCongNhan values(?, ?, ?, ?, ?)");
			stm.setString(1, ngayCong.getIdNgayChamCong());
			stm.setString(2, ngayCong.getNgayChamCong().toString());
			stm.setInt(3, ngayCong.getSoLuongHoanThanh());
			stm.setString(4, ngayCong.getCongDoanPhanCong().getIdPhanCong());
			stm.setDouble(5, ngayCong.getHeSoNgayLam());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	
	/**
	 * Cập nhật số lượng hoàn thành
	 * @param bangCC
	 * @return
	 */
	public boolean capNhatSoLuongHoanThanh(BangChamCongCongNhan bangCC) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("update BangChamCongCongNhan set soLuongHoanThanh = ? where idNgayChamCong = ?");
			stm.setInt(1, bangCC.getSoLuongHoanThanh());
			stm.setString(2, bangCC.getIdNgayChamCong());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}

}
