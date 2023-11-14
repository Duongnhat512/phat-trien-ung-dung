package bus;

import java.util.ArrayList;

import dao.HopDongSanPham_DAO;
import entities.HopDongSanPham;

public class HopDongSanPham_BUS {
	private HopDongSanPham_DAO hopDongSanPham_DAO = new HopDongSanPham_DAO();
	
	public HopDongSanPham getHopDongSanPhamTheoID(String id) {
		return hopDongSanPham_DAO.getHopDongSanPhamTheoID(id);
	}
	public ArrayList<HopDongSanPham> getAllHopDongSanPham(){
		return hopDongSanPham_DAO.getAllHopDongSanPham();
	}
	public boolean themHopDong(HopDongSanPham hopDongSanPham) {
		return hopDongSanPham_DAO.themHopDong(hopDongSanPham);
	}
}
