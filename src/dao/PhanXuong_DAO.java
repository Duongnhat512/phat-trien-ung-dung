	package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CaLam;
import entities.PhanXuong;

public class PhanXuong_DAO {
	public ArrayList<PhanXuong> getDanhSachPhanXuong() {
		ArrayList<PhanXuong> danhSachPhanXuong = new ArrayList<PhanXuong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from PhanXuong");
			while(rs.next()) {
				String idPhanXuong = rs.getString(1);
				String tenPhanxuong = rs.getString(2);
				PhanXuong phanXuong = new PhanXuong(idPhanXuong, tenPhanxuong);
				danhSachPhanXuong.add(phanXuong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return danhSachPhanXuong;
	}
	
	public PhanXuong getPhanXuongTheoID(String id) {
		PhanXuong phanXuong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from PhanXuong where idPhanXuong = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idPhanXuong = rs.getString(1);
				String tenPhanXuong = rs.getString(2);
				phanXuong = new PhanXuong(idPhanXuong, tenPhanXuong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phanXuong;
	}
	public PhanXuong getPhanXuongTheoTen(String ten) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {	
			String sql = "Select * from PhanXuong where tenPhanXuong = ?";	
			statement = con.prepareStatement(sql);
			statement.setString(1,ten);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String idpx = rs.getString(1);
				String tenpx = rs.getString(2);
				PhanXuong px = new PhanXuong(idpx, tenpx);
				return px;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			return null;
	}
}
