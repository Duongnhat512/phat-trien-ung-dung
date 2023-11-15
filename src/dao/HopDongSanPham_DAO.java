package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.HopDongSanPham;
import entities.NhanVien;

public class HopDongSanPham_DAO {
	private NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
	
	public ArrayList<HopDongSanPham> getAllHopDongSanPham(){
		ArrayList<HopDongSanPham> danhSachHopDongSanPham = new ArrayList<HopDongSanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from HopDongSanPham");
			while(rs.next()) {
				String idHopDong = rs.getString(1);
				String tenHopDong = rs.getString(2);
				LocalDate ngayBatDau = LocalDate.parse(rs.getString(3));
				LocalDate ngayKetThuc = LocalDate.parse(rs.getString(4));
				NhanVien nguoiQuanLy = nhanVien_DAO.getNhanVienTheoID(rs.getString(5));
				double tongTien = rs.getDouble(6);
				String ghiChu = rs.getString(7);
				HopDongSanPham hopDongSanPham = new HopDongSanPham(idHopDong, tenHopDong, ngayBatDau, ngayKetThuc, nguoiQuanLy, tongTien, ghiChu);
				danhSachHopDongSanPham.add(hopDongSanPham);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return danhSachHopDongSanPham;
	}
	
	public HopDongSanPham getHopDongSanPhamTheoID(String id) {
		HopDongSanPham hd = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from HopDongSanPham where idHopDong = ?");
			stm.setString(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idHopDong = rs.getString(1);
				String tenHopDong = rs.getString(2);
				LocalDate ngayBatDau = LocalDate.parse(rs.getString(3));
				LocalDate ngayKetThuc = LocalDate.parse(rs.getString(4));
				NhanVien nguoiQuanLy = nhanVien_DAO.getNhanVienTheoID(rs.getString(5));
				double tongTien = rs.getDouble(6);
				String ghiChu = rs.getString(7);
				hd = new HopDongSanPham(idHopDong, tenHopDong, ngayBatDau, ngayKetThuc, nguoiQuanLy, tongTien, ghiChu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hd;
	}
	
	public boolean themHopDong(HopDongSanPham hopDongSanPham) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("insert into HopDongSanPham values(?, ?, ?, ?, ?, ?, ?)");
			stm.setString(1, hopDongSanPham.getIdHopDong());
			stm.setString(2, hopDongSanPham.getTenHopDong());
			stm.setString(3, hopDongSanPham.getNgayBatDau().toString());
			stm.setString(4, hopDongSanPham.getNgayKetThuc().toString());
			stm.setString(5, hopDongSanPham.getNguoiQuanLy().getIdNhanVien());
			stm.setDouble(6, hopDongSanPham.getTongTien());
			stm.setString(7, hopDongSanPham.getGhiChu());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
}
