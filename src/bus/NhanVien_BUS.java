package bus;

import java.util.ArrayList;

import dao.NhanVien_DAO;
import entities.NhanVien;

public class NhanVien_BUS {
	private NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
	
	public NhanVien getNhanVienTheoID(String id) {
		return nhanVien_DAO.getNhanVienTheoID(id);
	}
	public ArrayList<NhanVien> getDanHSachNhanVienTheoChucVu(String idChucVu){
		return nhanVien_DAO.getDanhSachNhanVienTheoChucVu(idChucVu);
	}
}
