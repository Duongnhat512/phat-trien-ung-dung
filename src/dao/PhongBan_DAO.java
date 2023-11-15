package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import connectDB.ConnectDB;

import entities.PhongBan;


public class PhongBan_DAO {
	public ArrayList<PhongBan> getdsPB() {
		ArrayList<PhongBan> list = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select*from PhongBan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				
				String id = rs.getString(1);
				String tenPB = rs.getString(2);
				PhongBan pb = new PhongBan(id, tenPB);
				list.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public PhongBan getPhongBanTheoID(String id) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {	
			String sql = "Select * from PhongBan where idPhongBan = ?";	
			statement = con.prepareStatement(sql);
			statement.setString(1,id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String idpb = rs.getString(1);
				String tenpb = rs.getString(2);
				PhongBan pb = new PhongBan(idpb, tenpb);
				return pb;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			return null;
	}
	public PhongBan getPhongBanTheoTen(String ten) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {	
			String sql = "Select * from PhongBan where tenPhongBan = ?";	
			statement = con.prepareStatement(sql);
			statement.setString(1,ten);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String idpb = rs.getString(1);
				String tenpb = rs.getString(2);
				PhongBan pb = new PhongBan(idpb, tenpb);
				return pb;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			return null;
	}

}