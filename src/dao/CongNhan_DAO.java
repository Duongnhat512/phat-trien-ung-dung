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
				String ngayKetThucCongTacStr = rs.getString(6);
				LocalDate ngayKetThucCongTac = (ngayKetThucCongTacStr != null) ? LocalDate.parse(ngayKetThucCongTacStr) : null;
				PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
				String email = rs.getString(8);
				String soDienThoai = rs.getString(9);
				double phuCap = rs.getDouble(10);
				String tayNghe = rs.getString(11);
				TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
				String anhDaiDien = rs.getString(13);
				String cccd = rs.getString(14);
				CongNhan congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, phanXuong, email, soDienThoai, tayNghe, taiKhoan, anhDaiDien, cccd, phuCap);
				danhSachCongNhan.add(congNhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSachCongNhan;
	}
	public ArrayList<CongNhan> getDanhSachCongNhanDangLam() {
		ArrayList<CongNhan> danhSachCongNhan = new ArrayList<CongNhan>();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from CongNhan where ngayKetThucCongTac IS NULL");
			while(rs.next()) {
				String idCongNhan = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean phai = true;
				if(!rs.getBoolean(3)) phai = false;
				LocalDate ngaySinh = LocalDate.parse(rs.getString(4));
				LocalDate ngayBatDauCongTac = LocalDate.parse(rs.getString(5));
				String ngayKetThucCongTacStr = rs.getString(6);
				LocalDate ngayKetThucCongTac = (ngayKetThucCongTacStr != null) ? LocalDate.parse(ngayKetThucCongTacStr) : null;
				PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
				String email = rs.getString(8);
				String soDienThoai = rs.getString(9);
				double phuCap = rs.getDouble(10);
				String tayNghe = rs.getString(11);
				TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
				String anhDaiDien = rs.getString(13);
				String cccd = rs.getString(14);
				CongNhan congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, phanXuong, email, soDienThoai, tayNghe, taiKhoan, anhDaiDien, cccd, phuCap);
				danhSachCongNhan.add(congNhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSachCongNhan;
	}
	public ArrayList<CongNhan> getDanhSachCongNhanDangLamTheoPX(String idPhanXuong) {
		ArrayList<CongNhan> danhSachCongNhan = new ArrayList<CongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from CongNhan where idPhanXuong = ? and ngayKetThucCongTac IS NULL");
			stm.setString(1, idPhanXuong);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idCongNhan = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean phai = true;
				if(!rs.getBoolean(3)) phai = false;
				LocalDate ngaySinh = LocalDate.parse(rs.getString(4));
				LocalDate ngayBatDauCongTac = LocalDate.parse(rs.getString(5));
				String ngayKetThucCongTacStr = rs.getString(6);
				LocalDate ngayKetThucCongTac = (ngayKetThucCongTacStr != null) ? LocalDate.parse(ngayKetThucCongTacStr) : null;
				PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
				String email = rs.getString(8);
				String soDienThoai = rs.getString(9);
				double phuCap = rs.getDouble(10);
				String tayNghe = rs.getString(11);
				TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
				String anhDaiDien = rs.getString(13);
				String cccd = rs.getString(14);
				CongNhan congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, phanXuong, email, soDienThoai, tayNghe, taiKhoan, anhDaiDien, cccd, phuCap);
				danhSachCongNhan.add(congNhan);
			}
			return danhSachCongNhan;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
public CongNhan getCongNhanTheoID(String id) {
	CongNhan congNhan = new CongNhan();
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
			String ngayKetThucCongTacStr = rs.getString(6);
			LocalDate ngayKetThucCongTac = (ngayKetThucCongTacStr != null) ? LocalDate.parse(ngayKetThucCongTacStr) : null;
			PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
			String email = rs.getString(8);
			String soDienThoai = rs.getString(9);
			double phuCap = rs.getDouble(10);
			String tayNghe = rs.getString(11);
			TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
			String anhDaiDien = rs.getString(13);
			String cccd = rs.getString(14);
			congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, phanXuong, email, soDienThoai, tayNghe, taiKhoan, anhDaiDien, cccd, phuCap);
			return congNhan;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}
public CongNhan getCongNhanDangLamTheoID(String id) {
	CongNhan congNhan = new CongNhan();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement stm = null;
	try {
		stm = con.prepareStatement("select * from CongNhan where idCongNhan = ? and ngayKetThucCongTac IS NULL");
		stm.setString(1, id);
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			String idCongNhan = rs.getString(1);
			String hoTen = rs.getString(2);
			boolean phai = true;
			if(!rs.getBoolean(3)) phai = false;
			LocalDate ngaySinh = LocalDate.parse(rs.getString(4));
			LocalDate ngayBatDauCongTac = LocalDate.parse(rs.getString(5));
			String ngayKetThucCongTacStr = rs.getString(6);
			LocalDate ngayKetThucCongTac = (ngayKetThucCongTacStr != null) ? LocalDate.parse(ngayKetThucCongTacStr) : null;
			PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
			String email = rs.getString(8);
			String soDienThoai = rs.getString(9);
			double phuCap = rs.getDouble(10);
			String tayNghe = rs.getString(11);
			TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
			String anhDaiDien = rs.getString(13);
			String cccd = rs.getString(14);
			congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, phanXuong, email, soDienThoai, tayNghe, taiKhoan, anhDaiDien, cccd, phuCap);
			return congNhan;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
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
			String ngayKetThucCongTacStr = rs.getString(6);
			LocalDate ngayKetThucCongTac = (ngayKetThucCongTacStr != null) ? LocalDate.parse(ngayKetThucCongTacStr) : null;
			PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
			String email = rs.getString(8);
			String soDienThoai = rs.getString(9);
			double phuCap = rs.getDouble(10);
			String tayNghe = rs.getString(11);
			TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
			String anhDaiDien = rs.getString(13);
			String cccd = rs.getString(14);
			CongNhan congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, phanXuong, email, soDienThoai, tayNghe, taiKhoan, anhDaiDien, cccd, phuCap);
			danhSachCongNhan.add(congNhan);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return danhSachCongNhan;
}

public boolean 	create(CongNhan cn) {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement stmt = null;
	int n= 0;
	try {
		stmt =con.prepareStatement("insert into"+" CongNhan values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		stmt.setString(1, cn.getIdCongNhan());
		stmt.setString(2, cn.getHoTen());
		stmt.setBoolean(3, cn.isPhai());
		stmt.setString(4, cn.getNgaySinh()+"");
		stmt.setString(5, cn.getNgayBatDauCongTac()+"");
		stmt.setDate(6, null);
		stmt.setString(7, cn.getPhanXuong().getIdPhanXuong());
		stmt.setString(8, cn.getEmail());
		stmt.setString(9,cn.getSoDienThoai());
		stmt.setDouble(10, cn.getPhuCap());
		stmt.setString(11, cn.getTayNghe());
		stmt.setString(12, cn.getTaiKhoan().getTenTaiKhoan());
		stmt.setString(13, cn.getAnhDaiDien());
		stmt.setString(14, cn.getcCCD());
		n = stmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		try {
			stmt.close();
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	return n > 0;
}
public boolean 	update(CongNhan cn) {
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	PreparedStatement stmt = null;
	int n= 0;
	try {
		stmt =con.prepareStatement("update CongNhan set hoTen = ?, phai = ?, "
				+ "ngaySinh = ?, ngayBatDauCongTac = ?, ngayKetThucCongTac = ?,idPhanXuong = ?,email = ?,soDienThoai = ?, "
				+ "tayNghe = ?, anhDaiDien =  ?,"
				+ " CCCD = ? where idCongNhan = ?");
		
		
		stmt.setString(1, cn.getHoTen());
		stmt.setBoolean(2, cn.isPhai());
		stmt.setString(3, cn.getNgaySinh()+"");
		stmt.setString(4, cn.getNgayBatDauCongTac()+"");
		if(cn.getNgayKetThucCongTac()!=null) {
			stmt.setString(5, cn.getNgayKetThucCongTac()+"");
		}
		else {
			stmt.setString(5, null);
		}
		stmt.setString(6,cn.getPhanXuong().getIdPhanXuong());
		stmt.setString(7,cn.getEmail());
		stmt.setString(8,cn.getSoDienThoai());
		stmt.setString(9, cn.getTayNghe());
		stmt.setString(10, cn.getAnhDaiDien());
	
		stmt.setString(11, cn.getcCCD());
		stmt.setString(12, cn.getIdCongNhan());
		n = stmt.executeUpdate();

	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		try {
			stmt.close();
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	return n > 0;
}
public ArrayList<CongNhan> getDanhSachCongNhanChuaPhanCong(){
	ArrayList<CongNhan> list = new ArrayList<CongNhan>();
	ConnectDB.getInstance();
	Connection con = ConnectDB.getConnection();
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from CongNhan "
				+ "where idCongNhan not in "
				+ "(select idCongNhan from CongDoanPhanCong where soLuongConLai > 0)");
		while (rs.next()) {
			String idCongNhan = rs.getString(1);
			String hoTen = rs.getString(2);
			boolean phai = true;
			if (!rs.getBoolean(3))
				phai = false;
			LocalDate ngaySinh = LocalDate.parse(rs.getString(4));
			LocalDate ngayBatDauCongTac = LocalDate.parse(rs.getString(5));
			String ngayKetThucCongTacStr = rs.getString(6);
			LocalDate ngayKetThucCongTac = (ngayKetThucCongTacStr != null) ? LocalDate.parse(ngayKetThucCongTacStr)
					: null;
			PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
			String email = rs.getString(8);
			String soDienThoai = rs.getString(9);
			double phuCap = rs.getDouble(10);
			String tayNghe = rs.getString(11);
			TaiKhoan taiKhoan = taiKhoan_DAO.getTaiKhoan(idCongNhan);
			String anhDaiDien = rs.getString(13);
			String cccd = rs.getString(14);
			CongNhan congNhan = new CongNhan(idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac,
					ngayKetThucCongTac, phanXuong, email, soDienThoai, tayNghe, taiKhoan, anhDaiDien, cccd, phuCap);
			list.add(congNhan);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	
}
}
