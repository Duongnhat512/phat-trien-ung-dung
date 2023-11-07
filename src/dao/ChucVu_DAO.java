package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entities.ChucVu;

public class ChucVu_DAO {
	public ChucVu getChucVuTheoID(String id) {
		ChucVu chucVu = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from ChucVu where idChucVu = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idChucVu = rs.getString(1);
				String tenChucVu = rs.getString(2);
				double heSoLuong = rs.getDouble(3);
				chucVu = new ChucVu(idChucVu, tenChucVu, heSoLuong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return chucVu;
	}
}
