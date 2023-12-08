package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CongNhan;
import entities.TaiKhoan;
import entities.TaiKhoanNganHang;

public class TaiKhoan_DAO {
	TaiKhoanNganHang_DAO taiKhoanNganHang_DAO = new TaiKhoanNganHang_DAO();

	public TaiKhoan getTaiKhoan(String tenTaiKhoan) {
		TaiKhoan tk = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from TaiKhoan where tenTaiKhoan = ?");
			stm.setString(1, tenTaiKhoan);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String taiKhoan = rs.getString(1);
				String matKhai = rs.getString(2);
				String loaiTaiKhoan = rs.getString(3);
				TaiKhoanNganHang taiKhoanNganHang = taiKhoanNganHang_DAO.getTaiKhoanNganHangTheoSTK(rs.getString(4));
				tk = new TaiKhoan(taiKhoan, matKhai, loaiTaiKhoan, taiKhoanNganHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}

	public boolean updatePassword(String tenTaiKhoan, String matKhau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set matKhau = ? where tenTaiKhoan = ?");
			stmt.setString(1, matKhau); 
			stmt.setString(2, tenTaiKhoan); 
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
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
