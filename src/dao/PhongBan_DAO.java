package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entities.PhongBan;

public class PhongBan_DAO {
	public PhongBan getPhongBanTheoID(String id) {
		PhongBan phongBan = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from PhongBan where idPhongBan = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idPhongBan = rs.getString(1);
				String tenPhongBan = rs.getString(2);
				phongBan = new PhongBan(idPhongBan, tenPhongBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return phongBan;
	}
}
