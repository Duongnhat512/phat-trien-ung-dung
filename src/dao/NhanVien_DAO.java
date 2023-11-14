package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.ChucVu;
import entities.NhanVien;
import entities.PhongBan;
import entities.TaiKhoan;

public class NhanVien_DAO {
	private ChucVu_DAO chucVu_DAO = new ChucVu_DAO();
	private TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
	private PhongBan_DAO phongBan_DAO = new PhongBan_DAO();
	
	public NhanVien getNhanVienTheoID(String id) {
		NhanVien nhanVien = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from NhanVien where idNhanVien = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean phai = true;
				if(rs.getBoolean(3)) {
					phai = false;
				}
				LocalDate ngaySinh = LocalDate.parse(rs.getString(4));
				LocalDate ngayBatDauCongTac = LocalDate.parse(rs.getString(5));
				LocalDate ngayKetThucCongTac = null;
				if (rs.getString(6) != null) {
					ngayKetThucCongTac = LocalDate.parse(rs.getString(6));
				}
				String email = rs.getString(7);
				String soDienThoai = rs.getString(8);
				ChucVu chucVu = chucVu_DAO.getChucVuTheoID(rs.getString(9));
				TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idNhanVien);
				PhongBan phongBan = phongBan_DAO.getPhongBanTheoID(rs.getString(13));
				double phuCap = rs.getDouble(14);
				String anhDaiDien = rs.getString(15);
				String cCCD = rs.getString(16);
				nhanVien = new NhanVien(idNhanVien, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, email, soDienThoai, chucVu, taiKhoan, phongBan, phuCap, anhDaiDien, cCCD);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVien;
	}
	
	public ArrayList<NhanVien> getDanhSachNhanVienTheoChucVu(String idChucVu){
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from NhanVien where idChucVu = ?");
			stm.setString(1, idChucVu);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean phai = true;
				if(rs.getBoolean(3)) {
					phai = false;
				}
				LocalDate ngaySinh = LocalDate.parse(rs.getString(4));
				LocalDate ngayBatDauCongTac = LocalDate.parse(rs.getString(5));
				LocalDate ngayKetThucCongTac = null;
				if (rs.getString(6) != null) {
					ngayKetThucCongTac = LocalDate.parse(rs.getString(6));
				}
				String email = rs.getString(7);
				String soDienThoai = rs.getString(8);
				ChucVu chucVu = chucVu_DAO.getChucVuTheoID(rs.getString(9));
				TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idNhanVien);
				PhongBan phongBan = phongBan_DAO.getPhongBanTheoID(rs.getString(13));
				double phuCap = rs.getDouble(14);
				String anhDaiDien = rs.getString(15);
				String cCCD = rs.getString(16);
				NhanVien nhanVien = new NhanVien(idNhanVien, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, email, soDienThoai, chucVu, taiKhoan, phongBan, phuCap, anhDaiDien, cCCD);
				list.add(nhanVien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
