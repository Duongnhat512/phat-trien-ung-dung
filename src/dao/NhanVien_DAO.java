package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entities.ChucVu;
import entities.NhanVien;
import entities.PhongBan;

import entities.TaiKhoan;

public class NhanVien_DAO {

	public ArrayList<NhanVien> getdsNhanVien() {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select*from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
				String id = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean phai = rs.getBoolean(3);
				
				LocalDate ngaySinh =LocalDate.parse(rs.getString(4));
				LocalDate ngayCT =LocalDate.parse(rs.getString(5));	
				LocalDate ngayKTCT;
				if(rs.getString(6)!=null) {
					ngayKTCT =LocalDate.parse(rs.getString(6));
				}
				else {
					ngayKTCT = null;
				}
				String email = rs.getString(7);
				String sdt = rs.getString(8);
				String chucVu = rs.getString(9);
				ChucVu cv = new ChucVu(chucVu);
				String idTK = rs.getString(12);
				TaiKhoan tk = new TaiKhoan(idTK);
				String pB = rs.getString(13);
				PhongBan phongBan = new PhongBan(pB);
				String avatar = rs.getString(15);
				String cccd = rs.getString(16);
				NhanVien nv = new NhanVien(id, hoTen, phai, ngaySinh, ngayCT, ngayKTCT, email, sdt, cv, tk, phongBan, avatar,cccd);
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public NhanVien getNhanVienTheoID(String id) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {	
			String sql = "Select * from NhanVien where idNhanVien = ?";	
			statement = con.prepareStatement(sql);
			statement.setString(1,id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String idnv = rs.getString(1);
				String hoTen = rs.getString(2);
				Boolean phai = rs.getBoolean(3);
				
				LocalDate ngaySinh =LocalDate.parse(rs.getString(4));
				LocalDate ngayCT =LocalDate.parse(rs.getString(5));	
				LocalDate ngayKTCT;
				if(rs.getString(6)!=null) {
					ngayKTCT =LocalDate.parse(rs.getString(6));
				}
				else {
					ngayKTCT = null;
				}
				String email = rs.getString(7);
				String sdt = rs.getString(8);
				String chucVu = rs.getString(9);
				ChucVu cv = new ChucVu(chucVu);
				String idTK = rs.getString(12);
				TaiKhoan tk = new TaiKhoan(idTK);
				String pB = rs.getString(13);
				PhongBan phongBan = new PhongBan(pB);
			
				String avatar = rs.getString(15);
				String cccd = rs.getString(16);
				NhanVien nv  = new NhanVien(idnv, hoTen, phai, ngaySinh, ngayCT, ngayKTCT, email, sdt, cv, tk, phongBan, avatar,cccd);
				return nv;
				}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
			return null;
			
	}
	public boolean 	create(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt =con.prepareStatement("insert into"+" NhanVien values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, nv.getIdNhanVien());
			stmt.setString(2, nv.getHoTen());
			stmt.setBoolean(3, nv.isPhai());
			stmt.setString(4, nv.getNgaySinh()+"");
			stmt.setString(5, nv.getNgayBatDauCongTac()+"");
			stmt.setDate(6, null);
			stmt.setString(7, nv.getEmail());
			stmt.setString(8, nv.getSoDienThoai());
			stmt.setString(9,nv.getChucVu().getIdChucVu());
			stmt.setDouble(10, nv.getHESOBAOHIEMXAHOI());
			stmt.setDouble(11, nv.getLUONGCOBAN());
			stmt.setString(12, null);
			stmt.setString(13, nv.getPhongBan().getIdPhongBan());
			stmt.setDouble(14, nv.tinhPhuCap(nv.getChucVu()));
			stmt.setString(15, nv.getAnhDaiDien());
			stmt.setString(16, nv.getcCCD());
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
	public boolean 	update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt =con.prepareStatement("update NhanVien set hoTen = ?, phai = ?, "
					+ "ngaySinh = ?, ngayBatDauCongTac = ?, ngayKetThucCongTac = ?,email = ?,soDienThoai = ?, "
					+ "idChucVu = ?, idPhongBan = ?, phuCap = ? , anhDaiDien =  ?,"
					+ " CCCD = ? where idNhanVien = ?");
			
			
			stmt.setString(1, nv.getHoTen());
			stmt.setBoolean(2, nv.isPhai());
			stmt.setString(3, nv.getNgaySinh()+"");
			stmt.setString(4, nv.getNgayBatDauCongTac()+"");
			if(nv.getNgayKetThucCongTac()!=null) {
				stmt.setString(5, nv.getNgayKetThucCongTac()+"");
			}
			else {
				stmt.setString(5, null);
			}
			
			stmt.setString(6,nv.getEmail());
			stmt.setString(7,nv.getSoDienThoai());
			stmt.setString(8, nv.getChucVu().getIdChucVu());
			stmt.setString(9, nv.getPhongBan().getIdPhongBan());
			double phuCap = nv.tinhPhuCap(nv.getChucVu());
			stmt.setDouble(10, phuCap);
			if(nv.getAnhDaiDien()!=null) {
				stmt.setString(11, nv.getAnhDaiDien());
			}
			else {
				stmt.setString(11,null);
			}
			stmt.setString(12, nv.getcCCD());
			stmt.setString(13, nv.getIdNhanVien());
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
}

