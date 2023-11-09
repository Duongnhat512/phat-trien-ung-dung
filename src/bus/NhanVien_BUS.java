package bus;

import java.util.ArrayList;

import dao.NhanVien_DAO;
import entities.NhanVien;

public class NhanVien_BUS {
	private NhanVien_DAO nv_DAO = new NhanVien_DAO();
	public ArrayList<NhanVien> getdsNV() {
		return nv_DAO.getdsNhanVien(); 
	}
	public NhanVien getNV(String id) {
		return nv_DAO.getNhanVienTheoID(id); 
	}
}
