package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CaLam;
import entities.CongNhan;
import entities.PhanXuong;

public class CongNhan_DAO {
	PhanXuong_DAO phanXuong_DAO = new PhanXuong_DAO();
	
	public ArrayList<CongNhan> getDanhSachCongNhan() {
		ArrayList<CongNhan> danhSachCongNhan = null;
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
				LocalDate ngayKetThucCongTac = LocalDate.parse(rs.getString(6));
				PhanXuong phanXuong = phanXuong_DAO.getPhanXuongTheoID(rs.getString(7));
				String email = rs.getString(8);
				String soDienThoai = rs.getString(9);
				CaLam caLam = 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return danhSachCongNhan;
	}
}
