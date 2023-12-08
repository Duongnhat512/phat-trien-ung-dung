package bus;

import dao.TaiKhoan_DAO;
import entities.TaiKhoan;

public class TaiKhoan_BUS {
	private TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
	public TaiKhoan getTaiKhoan(String tenTaiKhoan) {
		return taiKhoan_DAO.getTaiKhoan(tenTaiKhoan);
	}
	public boolean 	updatePassword(String tenTaiKhoan,String matKhau) {
		return taiKhoan_DAO.updatePassword(tenTaiKhoan,matKhau);
	}
}
