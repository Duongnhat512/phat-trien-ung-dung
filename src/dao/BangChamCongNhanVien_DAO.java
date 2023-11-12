package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.BangChamCongNhanVien;
import entities.NhanVien;
import entities.PhongBan;

public class BangChamCongNhanVien_DAO {
	public ArrayList<NhanVien> getAllTableChamCong(int thang, int nam, String tenpb) {
		ArrayList<NhanVien> dsnv = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
//		String sql = "select n.idNhanVien,n.idPhongBan from BangChamCongNhanVienHC b join NhanVien n on b.idNhanVien=n.idNhanVien join ChucVu c on c.idChucVu=n.idChucVu "
//				+ "where YEAR(ngayChamCong)=? and MONTH(ngayChamCong)=? and c.tenChucVu= N'?' group by n.idNhanVien,n.idPhongBan\r\n";
		String sql = "select  n.idNhanVien, n.idPhongBan,hoTen,phai,luongCoBan,phuCap from BangChamCongNhanVienHC b " +
			    "join NhanVien n on b.idNhanVien = n.idNhanVien " +
			    "join PhongBan c on c.idPhongBan = n.idPhongBan " +
			    "where YEAR(ngayChamCong) = ? and MONTH(ngayChamCong) = ? and " +
			    "LOWER(REPLACE(?, ' ', '')) = LOWER(REPLACE(?, ' ', '')) group by n.idNhanVien, n.idPhongBan,hoTen,phai,luongCoBan,phuCap";
		try {
			PreparedStatement st = null;
			st = con.prepareStatement(sql);
			st.setInt(1, nam);
			st.setInt(2, thang);
			st.setString(3, tenpb);
			st.setString(4, tenpb);
			ResultSet r = st.executeQuery();
			while (r.next()) {
				String id = r.getString(1);
				String idPB = r.getString(2);
				String tenNv = r.getString(3);
				boolean phai = r.getBoolean(4);
				double luongCb = r.getDouble(5);
				double phuCap = r.getDouble(6);
				PhongBan p  =new PhongBan(idPB);
				NhanVien n = new NhanVien(id, tenNv, phai, p, phuCap);
				dsnv.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
}
