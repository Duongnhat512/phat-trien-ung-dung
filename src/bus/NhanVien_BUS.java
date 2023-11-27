package bus;

import java.util.ArrayList;

import dao.NhanVien_DAO;
import entities.NhanVien;

public class NhanVien_BUS {
	private NhanVien_DAO nv_DAO = new NhanVien_DAO();
	
	public ArrayList<NhanVien> getdsNV() {
		return nv_DAO.getdsNhanVien(); 
	}
	public ArrayList<NhanVien> getdsNVDangLam() {
		return nv_DAO.getdsNhanVienDangLam(); 
	}
	public NhanVien getNV(String id) {
		return nv_DAO.getNhanVienTheoID(id); 
	}
	public boolean create(NhanVien nv) {
		
		return nv_DAO.create(nv); 
	}
	public boolean update(NhanVien nv) {
		return nv_DAO.update(nv); 
	}
	public NhanVien getNhanVienTheoID(String id) {
		return nv_DAO.getNhanVienTheoID(id);
	}
	public NhanVien getNhanVienDangLamTheoID(String id) {
		return nv_DAO.getNhanVienDangLamTheoID(id);
	}
	public ArrayList<NhanVien> getDanHSachNhanVienTheoChucVu(String idChucVu){
		return nv_DAO.getDanhSachNhanVienTheoChucVu(idChucVu);
	}
}
