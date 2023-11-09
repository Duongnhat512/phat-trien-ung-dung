package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.ChucVu;
import entities.NhanVien;


public class ChucVu_DAO {
	public ArrayList<ChucVu> getdsCV() {
		ArrayList<ChucVu> list = new ArrayList<ChucVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select*from ChucVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
				String id = rs.getString(1);
				String tenCV = rs.getString(2);
				double heSoLuong = rs.getDouble(3);
				ChucVu cv = new ChucVu(id, tenCV, heSoLuong);	
				list.add(cv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ChucVu getChucVuTheoID(String id) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {	
			String sql = "Select * from ChucVu where idChucVu = ?";	
			statement = con.prepareStatement(sql);
			statement.setString(1,id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String idcv = rs.getString(1);
				String tenCV = rs.getString(2);
				double heSoLuong = rs.getDouble(3);
				ChucVu cv = new ChucVu(idcv, tenCV, heSoLuong);	
				return cv;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			return null;
	}
	public ChucVu getChucVuTheoTen(String ten) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {	
			String sql = "Select * from ChucVu where tenChucVu = ?";	
			statement = con.prepareStatement(sql);
			statement.setString(1,ten);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String idcv = rs.getString(1);
				String tenCV = rs.getString(2);
				double heSoLuong = rs.getDouble(3);
				ChucVu cv = new ChucVu(idcv, tenCV, heSoLuong);	
				return cv;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			return null;
	}
}
