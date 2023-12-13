package bus;

import java.util.ArrayList;

import dao.SanPham_DAO;
import entities.SanPham;

public class SanPham_BUS {
	private SanPham_DAO sanPham_DAO = new SanPham_DAO();
	
	public ArrayList<SanPham> getAllSanPham(){
		return sanPham_DAO.getAllSanPham();
	}
	public ArrayList<SanPham> getAllSanPhamMoi(){
		return sanPham_DAO.getAllSanPhamMoi();
	}
	public ArrayList<SanPham> getAllSanPhamCu(){
		return sanPham_DAO.getAllSanPhamCu();
	}
	public ArrayList<SanPham> getListSanPhamMoiTheoID(String id){
		return sanPham_DAO.getListSanPhamMoiTheoID(id);
	}
	public ArrayList<SanPham> getListSanPhamCuTheoID(String id){
		return sanPham_DAO.getListSanPhamCuTheoID(id);
	}
	public ArrayList<SanPham> getListSanPhamTheoID(String id){
		return sanPham_DAO.getListSanPhamTheoID(id);
	}
	public SanPham getSanPhamTheoID(String id){
		return sanPham_DAO.getSanPhamTheoID(id);
	}
	public boolean themSanPham(SanPham sanPham) {
		return sanPham_DAO.themSanPham(sanPham);
	}
	public boolean capNhatSanPham(SanPham sanPham) {
		return sanPham_DAO.capNhatSanPham(sanPham);
	}
	public int getTongSoLuongDatSanPhamTheoID(String id) {
		return sanPham_DAO.getTongSoLongDatSanPhamTheoID(id);
	}

}
