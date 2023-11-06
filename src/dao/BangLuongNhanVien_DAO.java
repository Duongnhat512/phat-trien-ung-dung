package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.LuongNhanVien;
import entities.NhanVien;
import entities.PhongBan;

public class BangLuongNhanVien_DAO {
	public LuongNhanVien getAllTableTinhLuong(String idNhanVien,int nam,int thang,String pb){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		CallableStatement cs = null;
		LuongNhanVien lnv = null;
		try {
		
			cs = con.prepareCall("{call TinhLuongNhanVien_proc(?, ?, ?, ?,?,?,?)}");

            // Thiết lập giá trị cho các tham số
			cs.setString(1, idNhanVien);
			cs.setInt(2, nam);
			cs.setInt(3, thang);
			cs.setString(4, pb);
		    cs.registerOutParameter(4, Types.DECIMAL);
		    cs.registerOutParameter(5, Types.DECIMAL);
		    cs.registerOutParameter(6, Types.DECIMAL);
		    cs.registerOutParameter(7, Types.DECIMAL);
            // Gọi stored procedure
            cs.execute();
            double thue = cs.getDouble(4);
            double 	bhxh = cs.getDouble(5);
            double thuclanh = cs.getDouble(6);
            double tongTienLuong = cs.getDouble(7);
            lnv = new LuongNhanVien(idNhanVien,LocalDate.now() ,new NhanVien(idNhanVien), tongTienLuong, thue,bhxh,thuclanh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lnv;
	}
	public ArrayList<PhongBan> getAllTablePhongBan(){
		ArrayList<PhongBan> dspb = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from PhongBan";
		try {
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(sql);
			while(r.next()) {
				String idPb = r.getString(1);
				String ten = r.getString(2);
				PhongBan p = new PhongBan(idPb, ten);
				dspb.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dspb;
	}
}
