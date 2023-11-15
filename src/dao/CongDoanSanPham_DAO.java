package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CongDoanSanPham;
import entities.SanPham;

public class CongDoanSanPham_DAO {
	private SanPham_DAO sanPham_DAO = new SanPham_DAO();
	
	/**
	 * Tìm công đoạn theo mã sản phẩm
	 * @param idSanPham
	 * @return
	 */
	public ArrayList<CongDoanSanPham> getCongDoanTheoSP(String idSanPham){
		ArrayList<CongDoanSanPham> list = new ArrayList<CongDoanSanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from CongDoanSP where idSanPham = ?");
			stm.setString(1, idSanPham);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idCongDoan = rs.getString(1);
				String tenCongDoan = rs.getString(2);
				int soLuongSP = rs.getInt(3);
				double luongCongDoan = rs.getDouble(4);
				int soLuongCN = rs.getInt(5);
				SanPham sp = sanPham_DAO.getSanPhamTheoID(rs.getString(6));
				String thuTuUuTien = rs.getString(7); 
				CongDoanSanPham cd = new CongDoanSanPham(idCongDoan, tenCongDoan, soLuongSP, luongCongDoan, soLuongCN, sp, thuTuUuTien);
				list.add(cd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Tìm công đoạn theo mã công đoạn
	 * @param idCongDoan
	 * @return
	 */
	public CongDoanSanPham getCongDoanTheoID(String idCongDoan) {
		CongDoanSanPham cd = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from CongDoanSP where idCongDoan = ?");
			stm.setString(1, idCongDoan);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String tenCongDoan = rs.getString(2);
				int soLuongSP = rs.getInt(3);
				double luongCongDoan = rs.getDouble(4);
				int soLuongCN = rs.getInt(5);
				SanPham sp = sanPham_DAO.getSanPhamTheoID(rs.getString(6));
				String thuTuUuTien = rs.getString(7); 
				cd = new CongDoanSanPham(idCongDoan, tenCongDoan, soLuongSP, luongCongDoan, soLuongCN, sp, thuTuUuTien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cd;
	}
}
