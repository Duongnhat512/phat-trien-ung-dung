package bus;

import java.util.ArrayList;

import dao.PhanXuong_DAO;
import entities.PhanXuong;

public class PhanXuong_BUS {
	private PhanXuong_DAO px_dao = new PhanXuong_DAO();
	public ArrayList<PhanXuong> getDanhSachPhanXuong(){
		return px_dao.getDanhSachPhanXuong();
	}
	public PhanXuong getdsPXtheoID(String id){
		return px_dao.getPhanXuongTheoID(id);
	}
	public PhanXuong getPXtheoTen(String Ten){
		return px_dao.getPhanXuongTheoTen(Ten);
	}
}
