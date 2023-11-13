package bus;

import java.util.ArrayList;

import dao.PhanXuong_DAO;
import entities.PhanXuong;

public class PhanXuong_BUS {
	private PhanXuong_DAO phanXuong_Dao = new PhanXuong_DAO();
	
	public ArrayList<PhanXuong> getdsPX(){
		return phanXuong_Dao.getDanhSachPhanXuong();
	}
	public PhanXuong getdsPXtheoID(String id){
		return phanXuong_Dao.getPhanXuongTheoID(id);
	}
	public PhanXuong getPXtheoTen(String Ten){
		return phanXuong_Dao.getPhanXuongTheoTen(Ten);
	}
}
