package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.BangChamCongNhanVien;
import entities.ChucVu;
import entities.NhanVien;
import entities.PhongBan;
import entities.TaiKhoan;

public class ChamCongNhanVien_DAO {
	public ArrayList<BangChamCongNhanVien> getListChamCong()
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<BangChamCongNhanVien> listCC = new ArrayList<BangChamCongNhanVien>();
		try {
			
			String sql = "select * from BangChamCongNhanVienHC";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				String idChamCong = rs.getString(1);
				LocalDate ngayChamCong = LocalDate.parse(rs.getString(2));
				String trangThai = rs.getString(3);
				String idNhanVien = rs.getString(4);
				NhanVien nv= new NhanVien(idNhanVien);
				BangChamCongNhanVien bcc = new BangChamCongNhanVien(idChamCong, ngayChamCong, trangThai, nv);
				listCC.add(bcc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listCC;
	}
	
	public ArrayList<BangChamCongNhanVien> getListChamCOngTrongNgay(String ngay)
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<BangChamCongNhanVien> listCC = new ArrayList<BangChamCongNhanVien>();
		try {
			
			String sql = "select * from BangChamCongNhanVienHC where ngayChamCong = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, ngay);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String idChamCong = rs.getString(1);
				LocalDate ngayChamCong = LocalDate.parse(rs.getString(2));
				String trangThai = rs.getString(3);
				String idNhanVien = rs.getString(4);
				NhanVien nv= new NhanVien(idNhanVien);
				BangChamCongNhanVien bcc = new BangChamCongNhanVien(idChamCong, ngayChamCong, trangThai, nv);
				listCC.add(bcc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listCC;
	}
	public ArrayList<NhanVien> getListNhanVienChuaChamCongTheoNgay(String date)
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
         try {
			
			String sql = "select * from NhanVien nv left join BangChamCongNhanVienHC bcc on nv.idNhanVien=bcc.idNhanVien\r\n"
					+ "and ngayChamCong = ? where bcc.idChamCong is null";
		
			statement = con.prepareStatement(sql);
			statement.setString(1,date);

			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
			{
				
				String idnv = rs.getString(1);
				String hoTen = rs.getString(2);
				boolean phai = rs.getBoolean(3);
				
				LocalDate ngaySinh =LocalDate.parse(rs.getString(4));
				LocalDate ngayCT =LocalDate.parse(rs.getString(5));	
				LocalDate ngayKTCT;
				if(rs.getString(6)!=null) {
					ngayKTCT =LocalDate.parse(rs.getString(6));
				}
				else {
					ngayKTCT = null;
				}
				String email = rs.getString(7);
				String sdt = rs.getString(8);
				String chucVu = rs.getString(9);
				ChucVu cv = new ChucVu(chucVu);
				String idTK = rs.getString(12);
				TaiKhoan tk = new TaiKhoan(idTK);
				String pB = rs.getString(13);
				PhongBan phongBan = new PhongBan(pB);
				double phuCap = rs.getDouble(14);
				String avatar = rs.getString(15);
				String cccd = rs.getString(16);
				NhanVien nv = new NhanVien(idnv, hoTen, phai, ngaySinh, ngayCT, ngayKTCT, email, pB, cv, tk, phongBan, avatar, cccd, phuCap);
				
				listNV.add(nv);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listNV;
	}
	public boolean themChamCong(BangChamCongNhanVien bcc)
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			String sql = "insert into BangChamCongNhanVienHC values (?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bcc.getIdChamCongNVHC());
			stmt.setString(2, bcc.getNgayChamCong().toString());
			stmt.setString(3, bcc.getTrangThai());
			stmt.setString(4, bcc.getNhanVien().getIdNhanVien());
			n = stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean update(BangChamCongNhanVien bcc)
	{

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			String sql = "update BangChamCongNhanVienHC set trangThai = ? where idChamCong = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bcc.getTrangThai());
			stmt.setString(2, bcc.getIdChamCongNVHC());
			n = stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	public ArrayList<NhanVien> getAllTableChamCong(int thang, int nam, String tenpb) {
		ArrayList<NhanVien> dsnv = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
//		String sql = "select n.idNhanVien,n.idPhongBan from BangChamCongNhanVienHC b join NhanVien n on b.idNhanVien=n.idNhanVien join ChucVu c on c.idChucVu=n.idChucVu "
//				+ "where YEAR(ngayChamCong)=? and MONTH(ngayChamCong)=? and c.tenChucVu= N'?' group by n.idNhanVien,n.idPhongBan\r\n";
		String sql = "SELECT n.idNhanVien, n.idPhongBan, hoTen, phai, luongCoBan, phuCap,n.idChucVu FROM BangChamCongNhanVienHC b " +
			    "JOIN NhanVien n ON b.idNhanVien = n.idNhanVien " +
			    "JOIN PhongBan c ON c.idPhongBan = n.idPhongBan " +
			    "WHERE YEAR(ngayChamCong) = ? AND MONTH(ngayChamCong) = ? AND " +
			    "c.tenPhongBan = ? " +
			    "GROUP BY n.idNhanVien, n.idPhongBan, hoTen, phai, luongCoBan, phuCap,n.idChucVu";
		try {
			PreparedStatement st = null;
			st = con.prepareStatement(sql);
			st.setInt(1, nam);
			st.setInt(2, thang);
			st.setString(3, tenpb);
			ResultSet r = st.executeQuery();
			while (r.next()) {
				String id = r.getString(1);
				String idPB = r.getString(2);
				String tenNv = r.getString(3);
				boolean phai = r.getBoolean(4);
				double luongCb = r.getDouble(5);
				double phuCap = r.getDouble(6);
				String chucVu = r.getString(7);
				PhongBan p  =new PhongBan(idPB);
				ChucVu c = new ChucVu(chucVu);
				NhanVien n = new NhanVien(id, tenNv, phai, p, phuCap,c);
				dsnv.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	
}
