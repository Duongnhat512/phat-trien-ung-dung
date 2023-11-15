package bus;

import java.util.ArrayList;

import dao.SanPham_DAO;
import entities.SanPham;

public class SanPham_BUS {
	private SanPham_DAO sanPham_DAO = new SanPham_DAO();
	
	public ArrayList<SanPham> getAllSanPham(){
		return sanPham_DAO.getAllSanPham();
	}
	public SanPham getSanPhamTheoID(String id){
		return sanPham_DAO.getSanPhamTheoID(id);
	}
}
