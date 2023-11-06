package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CaLam;

public class CaLam_DAO {
	public ArrayList<CaLam> getDanhSachCaLam() {
		ArrayList<CaLam> danhSachCaLam = new ArrayList<CaLam>();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from CaLam");
			while(rs.next()) {
				int idCaLam = rs.getInt(1);
				LocalTime thoiGianBatDau = LocalTime.parse(rs.getString(3));
				LocalTime thoiGianKetThuc = LocalTime.parse(rs.getString(4));
				CaLam caLam = new CaLam(idCaLam, thoiGianBatDau, thoiGianKetThuc, idCaLam);
				danhSachCaLam.add(caLam);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return danhSachCaLam;
		
	}
	
	public CaLam getCaLamTheoID(int id) {
		CaLam caLam = null;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from CaLam where idCaLam = ?");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				int idCaLam = rs.getInt(1);
				String tenCaLam = rs.getString(2);
				LocalTime thoiGianBatDau = LocalTime.parse(rs.getString(3));
				LocalTime thoiGianKetThuc = LocalTime.parse(rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return caLam;
	}
}
