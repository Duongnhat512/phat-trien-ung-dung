package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import connectDB.ConnectDB;

public class ThongKeLuongNhanVien_DAO {
      public ArrayList<String> getListLuongTheoPhongBan(int month , int year)
      {
    	  ConnectDB.getInstance();
     	 Connection con = ConnectDB.getConnection();
     	 ArrayList<String> listLuongPB = new ArrayList<String>();
     	 try {		
 			String sql = "select nv.idNhanVien,nv.hoTen,b.tenPhongBan,thang,nam,tongLuong,thucLanh from nhanvien nv join PhongBan b on b.idPhongBan=nv.idPhongBan\r\n"
 					+ "join BangLuongNhanVien bl on bl.idNhanVien=nv.idNhanVien\r\n"
 					+ "where bl.thang = ? and bl.nam = ? \r\n"
 					+ "group by  nv.idNhanVien,nv.hoTen,b.tenPhongBan,thang,nam,tongLuong,thucLanh";
 			PreparedStatement stmt = con.prepareStatement(sql);
 			stmt.setInt(1, month);
 			stmt.setInt(2, year);
 			ResultSet r = stmt.executeQuery();
 			while(r.next())
 			{
 				String idnv = r.getString(1);
 				String tennv = r.getString(2);
 				String tenPB = r.getString(3);
 				int thang = r.getInt(4);
 				double tongLuong = r.getDouble(6);
 				
 			    double thucLanh = r.getDouble(7);
 				
 				String data = idnv+";"+tennv+";"+tenPB+";"+thang+";"+tongLuong+";"+thucLanh+";";
 				listLuongPB.add(data);
 			}
 		} catch (Exception e) {
 			// TODO: handle exception
 		}
     	 return listLuongPB;
      }
      public ArrayList<String> getListLuongNhanVien(String manv , int year)
      {
    	  ConnectDB.getInstance(); 
    	 Connection con =  ConnectDB.getConnection();
    	  ArrayList<String> listLuong = new ArrayList<String>();
    	  try {
			String sql = "select nv.idNhanVien,nv.hoTen,b.tenPhongBan,thang,nam,tongLuong,thucLanh from nhanvien nv join PhongBan b on b.idPhongBan=nv.idPhongBan\r\n"
					+ "join BangLuongNhanVien bl on bl.idNhanVien=nv.idNhanVien\r\n"
					+ "where  bl.nam = ? and nv.idNhanVien = ? \r\n"
					+ "group by  nv.idNhanVien,nv.hoTen,b.tenPhongBan,thang,nam,tongLuong,thucLanh\r\n"
					+ "";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, year);
			stmt.setString(2, manv);
			ResultSet r = stmt.executeQuery();
			while(r.next())
 			{
 				String idnv = r.getString(1);
 				String tennv = r.getString(2);
 				String tenpb = r.getString(3);
 				int thang = r.getInt(4);
 				double thucThu = r.getDouble(7);
 				String data = idnv+";"+tennv+";"+tenpb+";"+thang+";"+thucThu+";";
 				listLuong.add(data);
 			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	  return listLuong;
      }
}
