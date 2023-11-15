package bus;

import java.util.ArrayList;

import dao.PhanXuong_DAO;
import entities.PhanXuong;

public class PhanXuong_BUS {
	private PhanXuong_DAO phanXuong_DAO = new PhanXuong_DAO();
	
	public ArrayList<PhanXuong> getDanhSachPhanXuong() {
		return phanXuong_DAO.getDanhSachPhanXuong();
	}
	public PhanXuong getPhanXuongTheoID(String id) {
		return phanXuong_DAO.getPhanXuongTheoID(id);
	}
}
