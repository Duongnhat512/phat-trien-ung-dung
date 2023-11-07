package dao;

import java.sql.Connection;
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
				String ghiChu = rs.getString(6);
				HopDongSanPham hopDongSanPham = new HopDongSanPham(idHopDong, tenHopDong, ngayBatDau, ngayKetThuc, nguoiQuanLy, ghiChu);
				danhSachHopDongSanPham.add(hopDongSanPham);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return danhSachHopDongSanPham;
	}
}
