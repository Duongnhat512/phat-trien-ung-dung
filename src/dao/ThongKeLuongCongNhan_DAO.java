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
			String sql = "SELECT \r\n"
					+ "px.idPhanXuong As maphanXuong,\r\n"
					+ "px.idPhanXuong AS tenPX,\r\n"
					+ " COALESCE(count(cn.idCongNhan),0) as soLuongCN,\r\n"
					+ "COALESCE(SUM(blcn.thucLanh),0) as bangLuongPX\r\n"
					+ "FROM PhanXuong px LEFT JOIN CongNhan cn ON px.idPhanXuong = cn.idPhanXuong left join BangLuongCongNhan blcn on blcn.idCongNhan=cn.idCongNhan\r\n"
					+ "where thang = ?  and nam = ? \r\n"
					+ " GROUP BY px.idPhanXuong,px.tenPhanXuong";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, month);
			stmt.setInt(2, year);
			ResultSet r = stmt.executeQuery();
			while(r.next())
 			{
 				String idpx = r.getString(1);
 				String tenpx = r.getString(2);
 				
 				int soluongCN = r.getInt(3);
 				int TongLuong = r.getInt(4);
 				String data = idpx+";"+tenpx+";"+soluongCN+";"+TongLuong+";";
 				listLuong.add(data);
 			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	  return listLuong;
      }
} 
