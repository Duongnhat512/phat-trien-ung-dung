package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CaLam;
import entities.CongNhan;
import entities.PhanXuong;
import entities.TaiKhoan;

public class CongNhan_DAO {
	private PhanXuong_DAO phanXuong_DAO = new PhanXuong_DAO();
	private CaLam_DAO  caLam_DAO = new CaLam_DAO();
	private TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
	
	public ArrayList<CongNhan> getDanhSachCongNhan() {
		ArrayList<CongNhan> danhSachCongNhan = new ArrayList<CongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from CongNhan");
			while(rs.next()) {
				String idCongNhan = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean phai = true;
				if(!rs.getBoolean(3)) phai = false;
				LocalDate ngaySinh = LocalDate.parse(rs.getString(4));
				LocalDate ngayBatDauCongTac = LocalDate.parse(rs.getString(5));
				LocalDate ngayKetThucCongTac = null;
				if (rs.getString(6) != null) {
					ngayKetThucCongTac = LocalDate.parse(rs.getString(6));
				}
				PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
				String email = rs.getString(8);
				String soDienThoai = rs.getString(9);
				CaLam caLam = caLam_DAO.getCaLamTheoID(rs.getInt(10));
				String tayNghe = rs.getString(11);
				TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
				String anhDaiDien = rs.getString(12);
				CongNhan congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, phanXuong, email, soDienThoai, caLam, tayNghe, taiKhoan, anhDaiDien);
				danhSachCongNhan.add(congNhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSachCongNhan;
	}
	
	public CongNhan getCongNhanTheoID(String id) {
		CongNhan congNhan = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from CongNhan where idCongNhan = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idCongNhan = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean phai = true;
				if(!rs.getBoolean(3)) phai = false;
				LocalDate ngaySinh = LocalDate.parse(rs.getString(4));
				LocalDate ngayBatDauCongTac = LocalDate.parse(rs.getString(5));
				LocalDate ngayKetThucCongTac = null;
				if (rs.getString(6) != null) {
					ngayKetThucCongTac = LocalDate.parse(rs.getString(6));
				}
				PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
				String email = rs.getString(8);
				String soDienThoai = rs.getString(9);
				CaLam caLam = caLam_DAO.getCaLamTheoID(rs.getInt(10));
				String tayNghe = rs.getString(11);
				TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
				String anhDaiDien = rs.getString(12);
				congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, phanXuong, email, soDienThoai, caLam, tayNghe, taiKhoan, anhDaiDien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return congNhan;
	}
	
	public ArrayList<CongNhan> getDanhSachCongNhanTheoCa(int idCaLam){
		ArrayList<CongNhan> danhSachCongNhan = new ArrayList<CongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from CongNhan where idCaLam = ?");
			stm.setInt(1, idCaLam);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idCongNhan = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean phai = true;
				if(!rs.getBoolean(3)) phai = false;
				LocalDate ngaySinh = LocalDate.parse(rs.getString(4));
				LocalDate ngayBatDauCongTac = LocalDate.parse(rs.getString(5));
				LocalDate ngayKetThucCongTac = null;
				if (rs.getString(6) != null) {
					ngayKetThucCongTac = LocalDate.parse(rs.getString(6));
				}
				PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
				String email = rs.getString(8);
				String soDienThoai = rs.getString(9);
				CaLam caLam = caLam_DAO.getCaLamTheoID(rs.getInt(10));
				String tayNghe = rs.getString(11);
				TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
				String anhDaiDien = rs.getString(12);
				CongNhan congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, phanXuong, email, soDienThoai, caLam, tayNghe, taiKhoan, anhDaiDien);
				danhSachCongNhan.add(congNhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSachCongNhan;
	}

//	public ArrayList<CongNhan> getDanhSachCongNhanPhanXuong(String idPhanXuong){
//		
//	}
}
