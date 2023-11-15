package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CaLam;
import entities.CongDoanPhanCong;
import entities.CongDoanSanPham;
import entities.CongNhan;

public class CongDoanPhanCong_DAO {
	private CaLam_DAO caLam_DAO = new CaLam_DAO();
	private CongNhan_DAO congNhan_DAO = new CongNhan_DAO();
	private CongDoanSanPham_DAO congDoanSanPham_DAO = new CongDoanSanPham_DAO();
	
	/**
	 * Lấy toàn bộ danh sách phân công
	 * @return
	 */
	public ArrayList<CongDoanPhanCong> getDanhSachPhanCong(){
		ArrayList<CongDoanPhanCong> list = new ArrayList<CongDoanPhanCong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from CongDoanPhanCong");
			while(rs.next()) {
				String idPhanCong = rs.getString(1);
				CongDoanSanPham congDoanSanPham = congDoanSanPham_DAO.getCongDoanTheoID(rs.getString(2));
				CongNhan congNhan = congNhan_DAO.getCongNhanTheoID(rs.getString(3));
				int soLuongSPDuocGiao = rs.getInt(4);
				CaLam caLam = caLam_DAO.getCaLamTheoID(rs.getInt(5));
				int soLuongConLai = rs.getInt(6);
				CongDoanPhanCong phanCong = new CongDoanPhanCong(idPhanCong, congDoanSanPham, congNhan, soLuongSPDuocGiao, caLam, soLuongConLai);
				list.add(phanCong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<CongDoanPhanCong> getDanhSachPhanCongTheoCaLam(int idCaLam){
		ArrayList<CongDoanPhanCong> list = new ArrayList<CongDoanPhanCong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("Select * from CongDoanPhanCong where idCaLam = ?");
			stm.setInt(1, idCaLam);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idPhanCong = rs.getString(1);
				CongDoanSanPham congDoanSanPham = congDoanSanPham_DAO.getCongDoanTheoID(rs.getString(2));
				CongNhan congNhan = congNhan_DAO.getCongNhanTheoID(rs.getString(3));
				int soLuongSPDuocGiao = rs.getInt(4);
				CaLam caLam = caLam_DAO.getCaLamTheoID(rs.getInt(5));
				int soLuongConLai = rs.getInt(6);
				CongDoanPhanCong phanCong = new CongDoanPhanCong(idPhanCong, congDoanSanPham, congNhan, soLuongSPDuocGiao, caLam, soLuongConLai);
				list.add(phanCong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Lấy công đoạn phân công theo id
	 * @param id
	 * @return
	 */
	public CongDoanPhanCong getPhanCongTheoID(String id) {
		CongDoanPhanCong phanCong = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from CongDoanPhanCong where idPhanCong = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idPhanCong = rs.getString(1);
				CongDoanSanPham congDoanSanPham = congDoanSanPham_DAO.getCongDoanTheoID(rs.getString(2));
				CongNhan congNhan = congNhan_DAO.getCongNhanTheoID(rs.getString(3));
				int soLuongSPDuocGiao = rs.getInt(4);
				CaLam caLam = caLam_DAO.getCaLamTheoID(rs.getInt(5));
				int soLuongConLai = rs.getInt(6);
				phanCong = new CongDoanPhanCong(idPhanCong, congDoanSanPham, congNhan, soLuongSPDuocGiao, caLam, soLuongConLai);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return phanCong;
	}
	
	/**
	 * Cập nhật số lượng còn lại
	 * @param congDoanPhanCong
	 * @return
	 */
	public boolean capNhatSoLuongConLai(CongDoanPhanCong congDoanPhanCong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("update CongDoanPhanCong set soLuongConLai = ? where idPhanCong = ?");
			stm.setInt(1, congDoanPhanCong.getSoLuongConLai());
			stm.setString(2, congDoanPhanCong.getIdPhanCong());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
}
