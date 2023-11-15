package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectDB;
import entities.TaiKhoanNganHang;

public class TaiKhoanNganHang_DAO {
	public TaiKhoanNganHang getTaiKhoanNganHangTheoSTK(String stk) {
		TaiKhoanNganHang tk = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from TaiKhoanNganHang where soTaiKhoan = ?");
			stm.setString(1, stk);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String soTaiKhoan = rs.getString(1);
				String tenNganHang = rs.getString(2);
				String chuTaiKhoan = rs.getString(3);
				String chiNhanh = rs.getString(4);
				tk = new TaiKhoanNganHang(soTaiKhoan, tenNganHang, chiNhanh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}
	public TaiKhoanNganHang getTaiKhoanNganHangTheoIDCongNhan(String idCongNhan) {
		TaiKhoanNganHang tk = null;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select tk.soTaiKhoan,tk.tenNganHang,tk.chiNhanh,tk.chuTaiKhoan from CongNhan c join TaiKhoan t on c.tenTaiKhoan=t.tenTaiKhoan join TaiKhoanNganHang tk on t.soTaiKhoan=tk.soTaiKhoan where c.idCongNhan= ?");
			stm.setString(1, idCongNhan);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String soTaiKhoan = rs.getString(1);
				String tenNganHang = rs.getString(2);
				String chiNhanh = rs.getString(3);
				String chuTaiKhoan = rs.getString(4);
				tk = new TaiKhoanNganHang(soTaiKhoan, tenNganHang, chiNhanh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}
}
