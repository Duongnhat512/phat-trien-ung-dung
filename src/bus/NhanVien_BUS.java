package bus;

import dao.NhanVien_DAO;
import entities.NhanVien;

public class NhanVien_BUS {
	private NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
	
	public NhanVien getNhanVienTheoID(String id) {
		return nhanVien_DAO.getNhanVienTheoID(id);
	}
}
