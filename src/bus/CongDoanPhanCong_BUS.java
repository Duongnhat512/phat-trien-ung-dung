package bus;

import java.util.ArrayList;

import dao.CongDoanPhanCong_DAO;
import entities.CongDoanPhanCong;

public class CongDoanPhanCong_BUS {
	private CongDoanPhanCong_DAO congDoanPhanCong_DAO = new CongDoanPhanCong_DAO();
	
	public ArrayList<CongDoanPhanCong> getDanhSachPhanCong(){
		return congDoanPhanCong_DAO.getDanhSachPhanCong();
	}
	public ArrayList<CongDoanPhanCong> getDanhSachPhanCongTheoCaLam(int idCaLam){
		return congDoanPhanCong_DAO.getDanhSachPhanCongTheoCaLam(idCaLam);
	}
	public CongDoanPhanCong getPhanCongTheoID(String id) {
		return congDoanPhanCong_DAO.getPhanCongTheoID(id);
	}
	public boolean capNhatSoLuongConLai(CongDoanPhanCong congDoanPhanCong) {
		return congDoanPhanCong_DAO.capNhatSoLuongConLai(congDoanPhanCong);
	}
}
