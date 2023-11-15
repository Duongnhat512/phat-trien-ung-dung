package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectDB.ConnectDB;
import test.Main;

public class ThongKeKPI_DAO {
     public ArrayList<String> getListCongNhanKPI(int month, int year)
     {
    	 ConnectDB.getInstance();
    	 Connection con = ConnectDB.getConnection();
    	 ArrayList<String> listCN = new ArrayList<String>();
    	 try {		
			String sql = "SELECT cn.idCongNhan as idcongNhan,cn.hoTen,px.tenPhanXuong,sum(cdpc.soLuongSPDuocGiao) as TongSoLuongDuocGiao, sum(bcc.soLuongHoanThanh) as TongSoLuongHoanThanh\r\n"
					+ "FROM\r\n"
					+ "    CongNhan cn LEFT JOIN\r\n"
					+ "    CongDoanPhanCong cdpc ON cn.idCongNhan= cdpc.idCongNhan LEFT JOIN\r\n"
					+ "    BangChamCongCongNhan bcc ON cdpc.idPhanCong=bcc.idPhanCong left join PhanXuong px on px.idPhanXuong=cn.idPhanXuong\r\n"
					+ "where MONTH(ngayChamCong) = ?  and YEAR(ngayChamCong) = ? \r\n"
					+ "GROUP BY cn.idCongNhan, cn.hoTen,px.tenPhanXuong\r\n"
					+ "having sum(cdpc.soLuongSPDuocGiao) is not null and sum(bcc.soLuongHoanThanh) is not null;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, month);
			stmt.setInt(2, year);
			ResultSet r = stmt.executeQuery();
			while(r.next())
			{
				String idCongNhan = r.getString(1);
				String tenCN = r.getString(2);
				String tenPX = r.getString(3);
				int TongSLDG = r.getInt(4);
				int TongSLSP = r.getInt(5);
				String data = idCongNhan+";"+tenCN+";"+tenPX+";"+TongSLDG+";"+TongSLSP+";";
				listCN.add(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	 return listCN;
     }
    
}
