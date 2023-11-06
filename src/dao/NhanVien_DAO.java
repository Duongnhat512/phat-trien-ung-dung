package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entities.NhanVien;

public class NhanVien_DAO {
	public NhanVien getNhanVienTheoID(String id) {
		NhanVien nhanVien = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from NhanVien");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idNhanVien = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean phai = true;
				if(rs.getInt(3) == 0) {
					phai = false;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVien;
	}
}
