package gui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import connectDB.ConnectDB;
import dao.CongDoanPhanCong_DAO;
import entities.CongDoanPhanCong;
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
		ArrayList<CongDoanPhanCong> list = congDoanPhanCong_DAO.getDanhSachPhanCong();
		for (CongDoanPhanCong congDoanPhanCong : list) {
			System.out.println(congDoanPhanCong.getCongNhan().getHoTen());
		}
	}
}