package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.ChiTietHopDong;
import entities.HopDongSanPham;
import entities.SanPham;

public class ChiTietHopDong_DAO {
	private HopDongSanPham_DAO hopDongSanPham_DAO = new HopDongSanPham_DAO();
	private SanPham_DAO sanPham_DAO = new SanPham_DAO();
	
	/**
	 * Lấy danh sách chi tiết hợp đồng dựa trên idHopDong
	 * @param id
	 * @return
	 */
	public ArrayList<ChiTietHopDong> getChiTietHopDongTheoIDHopDong(String id){
		ArrayList<ChiTietHopDong> list = new ArrayList<ChiTietHopDong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("Select * from ChiTietHopDong where idHopDong = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				HopDongSanPham hd = hopDongSanPham_DAO.getHopDongSanPhamTheoID(id);
				SanPham sp = sanPham_DAO.getSanPhamTheoID(rs.getString(2));
				int soLuong = rs.getInt(3);
				ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hd, sp, soLuong);
				list.add(chiTietHopDong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * Thêm chi tiết hợp đồng
	 * @param chiTietHopDong
	 * @return
	 */
	public boolean themCTHopDong(ChiTietHopDong chiTietHopDong) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("insert into ChiTietHopDong values(?, ?, ?, ?)");
			stm.setString(1, chiTietHopDong.getHopDongSanPham().getIdHopDong());
			stm.setString(2, chiTietHopDong.getSanPham().getIdSanPham());
			stm.setInt(3, chiTietHopDong.getSoLuong());
			stm.setDouble(4, chiTietHopDong.getThanhTien());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n > 0;
	}
	
	/**
	 * Lấy danh sách các sản phẩm trong hợp đồng chưa được làm xong
	 * @return
	 */
	public ArrayList<ChiTietHopDong> getChiTietHopDongChuaHoanThanh() {
		ArrayList<ChiTietHopDong> list = new ArrayList<ChiTietHopDong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from ChiTietHopDong where trangThai = 0");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				HopDongSanPham hd = hopDongSanPham_DAO.getHopDongSanPhamTheoID(rs.getString(1));
				SanPham sp = sanPham_DAO.getSanPhamTheoID(rs.getString(2));
				int soLuong = rs.getInt(3);
				ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hd, sp, soLuong);
				list.add(chiTietHopDong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
