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
}
