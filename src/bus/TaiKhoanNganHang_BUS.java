package bus;

import dao.TaiKhoanNganHang_DAO;
import entities.TaiKhoanNganHang;

public class TaiKhoanNganHang_BUS {
	private TaiKhoanNganHang_DAO tk_dao = new TaiKhoanNganHang_DAO();
	public TaiKhoanNganHang getTaiKhoanNganHangTheoIDCongNhan(String idCongNhan) {
		return tk_dao.getTaiKhoanNganHangTheoIDCongNhan(idCongNhan);
	}
}
