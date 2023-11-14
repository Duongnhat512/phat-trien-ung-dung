package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.BangChamCongCongNhan;
import entities.CongDoanPhanCong;

public class BangChamCongCongNhan_DAO {
	private CongDoanPhanCong_DAO congDoanPhanCong_DAO = new CongDoanPhanCong_DAO();
	
	/**
	 * Lấy danh sách chấm công
	 * @return
	 */
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCong(){
		ArrayList<BangChamCongCongNhan> list = new ArrayList<BangChamCongCongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("Select * from BangChamCongCongNhan");
			while(rs.next()) {
				String idNgayChamCong = rs.getString(1);
				LocalDate ngayChamCong = LocalDate.parse(rs.getString(2));
				int soLuongHoanThanh = rs.getInt(3);
				CongDoanPhanCong congDoanPhanCong = congDoanPhanCong_DAO.getPhanCongTheoID(rs.getString(4));
				double heSoNgayLam = rs.getDouble(5);
				BangChamCongCongNhan bangChamCongCongNhan = new BangChamCongCongNhan(idNgayChamCong, ngayChamCong, soLuongHoanThanh, congDoanPhanCong, heSoNgayLam);
				list.add(bangChamCongCongNhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * Lấy danh sách chấm công theo ngày, tháng, năm
	 * @param ngay
	 * @param thang
	 * @param nam
	 * @return
	 */
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCongTheoNgay(int ngay, int thang, int nam){
		ArrayList<BangChamCongCongNhan> list = new ArrayList<BangChamCongCongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from BangChamCongCongNhan where day(ngayChamCong) = ? and month(ngayChamCong) = ? and year(ngayChamCong) = ?");
			stm.setInt(1, ngay);
			stm.setInt(2, thang);
			stm.setInt(3, nam);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String idNgayChamCong = rs.getString(1);
				LocalDate ngayChamCong = LocalDate.parse(rs.getString(2));
				int soLuongHoanThanh = rs.getInt(3);
				CongDoanPhanCong congDoanPhanCong = congDoanPhanCong_DAO.getPhanCongTheoID(rs.getString(4));
				double heSoNgayLam = rs.getDouble(5);
				BangChamCongCongNhan bangChamCongCongNhan = new BangChamCongCongNhan(idNgayChamCong, ngayChamCong, soLuongHoanThanh, congDoanPhanCong, heSoNgayLam);
				list.add(bangChamCongCongNhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Thêm chấm công
	 * @param ngayCong
	 * @return
	 */
	public boolean themChamCong(BangChamCongCongNhan ngayCong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("insert into BangChamCongCongNhan values(?, ?, ?, ?, ?)");
			stm.setString(1, ngayCong.getIdNgayChamCong());
			stm.setString(2, ngayCong.getNgayChamCong().toString());
			stm.setInt(3, ngayCong.getSoLuongHoanThanh());
			stm.setString(4, ngayCong.getCongDoanPhanCong().getIdPhanCong());
			stm.setDouble(5, ngayCong.getHeSoNgayLam());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	
	/**
	 * Cập nhật số lượng hoàn thành 
	 * @param bangCC
	 * @return
	 */
	public boolean capNhatSoLuongHoanThanh(BangChamCongCongNhan bangCC) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("update BangChamCongCongNhan set soLuongHoanThanh = ? where idNgayChamCong = ?");
			stm.setInt(1, bangCC.getSoLuongHoanThanh());
			stm.setString(2, bangCC.getIdNgayChamCong());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	
	
}
