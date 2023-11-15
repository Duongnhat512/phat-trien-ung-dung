package gui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bus.CongDoanPhanCong_BUS;
import bus.SanPham_BUS;
import connectDB.ConnectDB;
import dao.CongDoanPhanCong_DAO;
import dao.CongDoanSanPham_DAO;
import entities.CongDoanPhanCong;
import entities.CongDoanSanPham;
import entities.SanPham;
import form.ThongKeKPI_Form;

public class Test{
	private static CongDoanPhanCong_DAO congDoanPhanCong_DAO = new CongDoanPhanCong_DAO();

	public static void main(String[] args) {
		try {
			ConnectDB.getInstance().connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CongDoanSanPham_DAO congDoanSanPham_DAO = new CongDoanSanPham_DAO();
		ArrayList<CongDoanSanPham> list = congDoanSanPham_DAO.getCongDoanTheoSP("SP0001");
		System.out.println(list.get(0).getSanPham().getTenSanPham());
		
		CongDoanPhanCong_BUS cong_BUS = new CongDoanPhanCong_BUS();
		ArrayList<CongDoanPhanCong> listPC = cong_BUS.getDanhSachPhanCong();
		System.out.println(listPC.get(0).getCongDoanSP().getSanPham());
	}
}