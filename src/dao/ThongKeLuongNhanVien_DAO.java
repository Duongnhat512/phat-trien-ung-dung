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
 			String sql = "SELECT\r\n"
 					+ "    pb.idPhongBan as idPb,\r\n"
 					+ "    pb.tenPhongBan AS tenPB,\r\n"
 					+ "	 COALESCE(count(nv.idNhanVien),0) as soLuongNV,\r\n"
 					+ "    COALESCE(SUM(blnv.thucLanh),0) as bangLuongPB\r\n"
 					+ "FROM\r\n"
 					+ "    PhongBan pb\r\n"
 					+ "LEFT JOIN\r\n"
 					+ "    NhanVien nv ON pb.idPhongBan = nv.idPhongBan\r\n"
 					+ "left join BangLuongNhanVien blnv on blnv.idNhanVien=nv.idNhanVien\r\n"
 					+ "where thang = ?  and nam = ? \r\n"
 					+ "GROUP BY\r\n"
 					+ "     pb.idPhongBan,pb.tenPhongBan";
 			PreparedStatement stmt = con.prepareStatement(sql);
 			stmt.setInt(1, month);
 			stmt.setInt(2, year);
 			ResultSet r = stmt.executeQuery();
 			while(r.next())
 			{
 				String idpb = r.getString(1);
 				String tenpb = r.getString(2);
 				
 				int soluongNV = r.getInt(3);
 				int TongLuong = r.getInt(4);
 				
 				String data = idpb+";"+tenpb+";"+soluongNV+";"+TongLuong+";";
 				listLuongPB.add(data);
 			}
 		} catch (Exception e) {
 			// TODO: handle exception
 		}
     	 return listLuongPB;
      }
}
