package bus;

import dao.TaiKhoan_DAO;
import entities.TaiKhoan;
import entities.TaiKhoanNganHang;

public class TaiKhoan_BUS {
	private TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
	public TaiKhoan getTaiKhoan(String tenTaiKhoan) {
		return taiKhoan_DAO.getTaiKhoan(tenTaiKhoan);
	}
	public boolean 	updatePassword(String tenTaiKhoan,String matKhau) {
		return taiKhoan_DAO.updatePassword(tenTaiKhoan,matKhau);
	}
	public boolean create(TaiKhoan tk) {
		return taiKhoan_DAO.create(tk);
	}
	public boolean updateTaiKhoan(String id,String loaiTK, String stk) {
		return taiKhoan_DAO.updateTaiKhoan(id, loaiTK, stk);
	}
}
