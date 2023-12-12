package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.SanPham;

public class SanPham_DAO {
	public ArrayList<SanPham> getAllSanPham(){
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from SanPham");
			while(rs.next()) {
				String idSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double donGia = rs.getDouble(3);
				String chatLieu = rs.getString(4);
				String donViTinh = rs.getString(5);
				String ghiChu = rs.getString(6);
				String anhSanPham = rs.getString(7);
				SanPham sp = new SanPham(idSanPham, tenSanPham, donGia, chatLieu, donViTinh, ghiChu, anhSanPham);
				list.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public SanPham getSanPhamTheoID(String id){
		SanPham sp = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from SanPham where idSanPham = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				double donGia = rs.getDouble(3);
				String chatLieu = rs.getString(4);
				String donViTinh = rs.getString(5);
				String ghiChu = rs.getString(6);
				String anhSanPham = rs.getString(7);
				sp = new SanPham(idSanPham, tenSanPham, donGia, chatLieu, donViTinh, ghiChu, anhSanPham);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sp;
	}
	
	/**
	 * Thêm sản phẩm
	 * @param sanPham
	 * @return
	 */
	public boolean themSanPham(SanPham sanPham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("insert into SanPham values(?, ?, ?, ?, ?, ?, ?)");
			stm.setString(1, sanPham.getIdSanPham());
			stm.setString(2, sanPham.getTenSanPham());
			stm.setDouble(3, sanPham.getDonGia());
			stm.setString(4, sanPham.getChatLieu());
			stm.setString(5, sanPham.getDonViTinh());
			stm.setString(6, sanPham.getGhiChu());
			stm.setString(7, sanPham.getIdSanPham());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 1;
	}
	
	/**
	 * Cập nhật thông tin sản phẩm
	 * @param sanPham
	 * @return
	 */
	public boolean capNhatSanPham(SanPham sanPham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("update SanPham set donGia = ?, chatLieu = ?, donViTinh = ?, ghiChu = ? where idSanPham = ?");
			stm.setDouble(1, sanPham.getDonGia());
			stm.setString(2, sanPham.getChatLieu());
			stm.setString(3, sanPham.getDonViTinh());
			stm.setString(4, sanPham.getGhiChu());
			stm.setString(5, sanPham.getIdSanPham());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 1;
	}
	
}
