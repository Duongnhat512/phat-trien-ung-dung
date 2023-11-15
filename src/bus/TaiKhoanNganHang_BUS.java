package bus;

import dao.TaiKhoanNganHang_DAO;
import entities.TaiKhoanNganHang;

public class TaiKhoanNganHang_BUS {
	private TaiKhoanNganHang_DAO taiKhoanNganHang_DAO = new TaiKhoanNganHang_DAO();
	
	public TaiKhoanNganHang getTaiKhoanNganHangTheoSTK(String stk) {
		return taiKhoanNganHang_DAO.getTaiKhoanNganHangTheoIDCongNhan(stk);
	}
	public TaiKhoanNganHang getTaiKhoanNganHangTheoIDCongNhan(String idCongNhan) {
		return taiKhoanNganHang_DAO.getTaiKhoanNganHangTheoIDCongNhan(idCongNhan);
	}
}
