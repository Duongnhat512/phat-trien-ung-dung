package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectDB.ConnectDB;

public class ThongKeLuongCongNhan_DAO {
      public ArrayList<String> getListLuongCNtheoPhanXuong(int month, int year)
      {
    	 ConnectDB.getInstance();
    	 Connection con =  ConnectDB.getConnection();
    	  ArrayList<String> listLuong = new ArrayList<String>();
    	  try {
			String sql = "Select cn.idCongNhan,hoTen,tenPhanXuong,thang,sum(soLuongHoanThanh) as soLuongHT ,thucLanh\r\n"
					+ "from CongNhan cn join PhanXuong px on cn.idPhanXuong=px.idPhanXuong join BangLuongCongNhan bl on bl.idCongNhan=cn.idCongNhan\r\n"
					+ "join CongDoanPhanCong cd on cd.idCongNhan=cn.idCongNhan join BangChamCongCongNhan bcc on bcc.idPhanCong=cd.idPhanCong\r\n"
					+ "where thang = ? and nam =  ? \r\n"
					+ "GROUP BY cn.idCongNhan,hoTen,tenPhanXuong,thang,thucLanh";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, month);
			stmt.setInt(2, year);
			ResultSet r = stmt.executeQuery();
			while(r.next())
 			{
 				String idcn = r.getString(1);
 				String tencn = r.getString(2);
 				String tenppx = r.getString(3);
 				int thang = r.getInt(4);
 				int soluongHT = r.getInt(5);
 				double TongLuong = r.getDouble(6);
 				String data = idcn+";"+tencn+";"+tenppx+";"+thang+";"+soluongHT+";"+TongLuong+";";
 				listLuong.add(data);
 			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	  return listLuong;
      }
      public ArrayList<String> getListLuongCNtheoCongNhan(String maCN , int year)
      {
    	  ConnectDB.getInstance(); 
    	 Connection con =  ConnectDB.getConnection();
    	  ArrayList<String> listLuong = new ArrayList<String>();
    	  try {
			String sql = "Select cn.idCongNhan,hoTen,tenPhanXuong,thang,sum(soLuongHoanThanh) as soLuongHT ,thucLanh\r\n"
					+ "from CongNhan cn join PhanXuong px on cn.idPhanXuong=px.idPhanXuong join BangLuongCongNhan bl on bl.idCongNhan=cn.idCongNhan\r\n"
					+ "join CongDoanPhanCong cd on cd.idCongNhan=cn.idCongNhan join BangChamCongCongNhan bcc on bcc.idPhanCong=cd.idPhanCong\r\n"
					+ "where nam = ? and CN.idCongNhan = ? \r\n"
					+ "GROUP BY cn.idCongNhan,hoTen,tenPhanXuong,thang,thucLanh";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, year);
			stmt.setString(2, maCN);
			ResultSet r = stmt.executeQuery();
			while(r.next())
 			{
 				String idcn = r.getString(1);
 				String tencn = r.getString(2);
 				String tenppx = r.getString(3);
 				int thang = r.getInt(4);
 				int soluongHT = r.getInt(5);
 				double TongLuong = r.getDouble(6);
 				String data = idcn+";"+tencn+";"+tenppx+";"+thang+";"+soluongHT+";"+TongLuong+";";
 				listLuong.add(data);
 			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	  return listLuong;
      }
      
} 
