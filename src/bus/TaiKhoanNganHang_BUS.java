package bus;

import dao.TaiKhoanNganHang_DAO;
import entities.TaiKhoanNganHang;

public class TaiKhoanNganHang_BUS {
	private TaiKhoanNganHang_DAO tk_dao = new TaiKhoanNganHang_DAO();
	public TaiKhoanNganHang getTaiKhoanNganHangTheoIDCongNhan(String idCongNhan) {
		return tk_dao.getTaiKhoanNganHangTheoIDCongNhan(idCongNhan);
	}
	public boolean create(TaiKhoanNganHang tk) {
		return tk_dao.create(tk);
	}
	public boolean update(TaiKhoanNganHang tk,String stkCu) {
		return tk_dao.updateTaiKhoanNganHang(tk,stkCu);
	}
	
}
