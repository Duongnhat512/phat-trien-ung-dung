package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;

import entities.CongNhan;
import entities.PhanXuong;
import entities.TaiKhoan;

public class CongNhan_DAO {
	private PhanXuong_DAO phanXuong_DAO = new PhanXuong_DAO();
	private TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
	
	public ArrayList<CongNhan> getDanhSachCongNhan() {
		ArrayList<CongNhan> danhSachCongNhan = new ArrayList<CongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from CongNhan");
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
				String px = rs.getString(7);
				PhanXuong phanXuong = new PhanXuong(px);
				String email = rs.getString(8);
				String sdt = rs.getString(9);
				String tayNghe = rs.getString(10);
				String idTK = rs.getString(11);
				TaiKhoan tk = new TaiKhoan(idTK);
				String avatar = rs.getString(12);
				String cccd = rs.getString(13);
				
				CongNhan congNhan = new CongNhan(id, hoTen, phai, ngaySinh, ngayCT, ngayKTCT, phanXuong, email, sdt, tayNghe, tk, avatar, cccd);
				danhSachCongNhan.add(congNhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSachCongNhan;
	}
	
	public CongNhan getCongNhanTheoID(String id) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from CongNhan where idCongNhan = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idCN = rs.getString(1);
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
				String px = rs.getString(7);
				PhanXuong phanXuong = new PhanXuong(px);
				String email = rs.getString(8);
				String sdt = rs.getString(9);
				String tayNghe = rs.getString(10);
				String idTK = rs.getString(11);
				TaiKhoan tk = new TaiKhoan(idTK);
				String avatar = rs.getString(12);
				String cccd = rs.getString(13);
				
				CongNhan congNhan = new CongNhan(idCN, hoTen, phai, ngaySinh, ngayCT, ngayKTCT, phanXuong, email, sdt, tayNghe, tk, avatar, cccd);
				return congNhan;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public boolean 	create(CongNhan cn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt =con.prepareStatement("insert into"+" CongNhan values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, cn.getIdCongNhan());
			stmt.setString(2, cn.getHoTen());
			stmt.setBoolean(3, cn.isPhai());
			stmt.setString(4, cn.getNgaySinh()+"");
			stmt.setString(5, cn.getNgayBatDauCongTac()+"");
			stmt.setDate(6, null);
			stmt.setString(7, cn.getPhanXuong().getIdPhanXuong());
			stmt.setString(8, cn.getEmail());
			stmt.setString(9,cn.getSoDienThoai());
			stmt.setString(10, cn.getTayNghe());
			stmt.setString(11, null);
			stmt.setString(12, cn.getAnhDaiDien());
			stmt.setString(13, cn.getcCCD());
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
			stmt =con.prepareStatement("update CongNhan set heTen = ?, phai = ?, "
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

	
}
