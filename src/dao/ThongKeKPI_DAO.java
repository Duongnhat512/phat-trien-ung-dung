package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CongNhan;
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
     public ArrayList<String> getDoanhSoCongNhan(String maCN)
     {
    	 ConnectDB.getInstance();
    	 Connection con = ConnectDB.getConnection();
    	 ArrayList<String> listKPIcn = new ArrayList<String>();
    	 try {
			String sql = "select cn.idCongNhan,hoTen,MONTH(ngayChamCong),sum(soLuongHoanThanh) as soht,sum(soLuongSPDuocGiao) as sldg from BangChamCongCongNhan bcc join CongDoanPhanCong pc on pc.idPhanCong=bcc.idPhanCong join CongNhan cn on cn.idCongNhan=pc.idCongNhan\r\n"
					+ "where cn.idCongNhan = ? and YEAR(ngayChamCong) = ? \r\n"
					+ "group by MONTH(ngayChamCong),hoTen,cn.idCongNhan";
			PreparedStatement pps = con.prepareStatement(sql);
			pps.setString(1, maCN);
			pps.setInt(2, LocalDate.now().getYear());
			ResultSet r = pps.executeQuery();
			while(r.next())
			{
				String idCN = r.getString(1);
				String tenCN = r.getString(2);
				int thang = r.getInt(3);
				int slht = r.getInt(4);
				int sldg = r.getInt(5);
				String data = idCN+";"+tenCN+";"+thang+";"+slht+";"+sldg+";";
				listKPIcn.add(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	 return listKPIcn;
     }
    
}
