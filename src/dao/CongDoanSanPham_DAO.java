package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CongDoanSanPham;
import entities.SanPham;

public class CongDoanSanPham_DAO {
	private SanPham_DAO sanPham_DAO = new SanPham_DAO();
	
	
	
	public ArrayList<CongDoanSanPham> getDSCongDoan(){
		ArrayList<CongDoanSanPham> list = new ArrayList<CongDoanSanPham>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select*from CongDoanSP";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String idCongDoan = rs.getString(1);
				String tenCongDoan = rs.getString(2);
				int soLuong = rs.getInt(3);
				double luongCongDoan = rs.getDouble(4);
				String idSanPham = rs.getString(5);
				SanPham sp = sanPham_DAO.getSanPhamTheoID(idSanPham);
				
				CongDoanSanPham cd = new CongDoanSanPham(idCongDoan, tenCongDoan,soLuong, luongCongDoan, sp);
				list.add(cd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
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
				SanPham sp = sanPham_DAO.getSanPhamTheoID(rs.getString(5));
			
				CongDoanSanPham cd = new CongDoanSanPham(idCongDoan, tenCongDoan, soLuongSP, luongCongDoan, sp);
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
				SanPham sp = sanPham_DAO.getSanPhamTheoID(rs.getString(5));
			
				cd = new CongDoanSanPham(idCongDoan, tenCongDoan, soLuongSP, luongCongDoan, sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cd;
	}
	public boolean 	create(CongDoanSanPham cdsp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt =con.prepareStatement("insert into"+" CongDoanSP values(?,?,?,?,?)");
			
			stmt.setString(1, cdsp.getIdCongDoan());
			stmt.setString(2, cdsp.getTenCongDoan());
			stmt.setInt(3, cdsp.getSoLuongSanPham());
			stmt.setDouble(4, cdsp.getLuongCongDoan());
			stmt.setString(5, cdsp.getSanPham().getIdSanPham());
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean 	update(CongDoanSanPham cdsp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt =con.prepareStatement("update CongDoanSP set tenCongDoan = ?, luongCongDoan = ?, idSanPham = ? where idCongDoan = ?");
			stmt.setString(1, cdsp.getTenCongDoan());
			stmt.setDouble(2, cdsp.getLuongCongDoan());
			stmt.setString(3, cdsp.getSanPham().getIdSanPham());
			stmt.setString(4, cdsp.getIdCongDoan());
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
	/**
	 * Cập nhật số lượng sản phẩm cho công đoạn
	 * @param idCongDoan
	 * @param soLuongSanPham
	 * @return
	 */
	public boolean updateSoLuongSanPham(String idCongDoan, int soLuongSanPham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt =con.prepareStatement("update CongDoanSP set soLuongSanPham = soLuongSanPham - ? where idCongDoan = ?");
			stmt.setInt(1, soLuongSanPham);
			stmt.setString(2, idCongDoan);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
	/**
	 * Lấy danh sách công đoạn chưa được chia xong
	 * @return
	 */
	public ArrayList<CongDoanSanPham> getDanhSachCongDoanChuaChiaXong(){
		ArrayList<CongDoanSanPham> list = new ArrayList<CongDoanSanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from CongDoanSP where soLuongSanPham > 0");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idCongDoan = rs.getString(1);
				String tenCongDoan = rs.getString(2);
				int soLuongSP = rs.getInt(3);
				double luongCongDoan = rs.getDouble(4);
				SanPham sp = sanPham_DAO.getSanPhamTheoID(rs.getString(5));
				
				CongDoanSanPham cd = new CongDoanSanPham(idCongDoan, tenCongDoan, soLuongSP, luongCongDoan, sp);
				list.add(cd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}