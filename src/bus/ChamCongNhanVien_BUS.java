package bus;

import java.util.ArrayList;

import dao.ChamCongNhanVien_DAO;
import entities.NhanVien;

public class ChamCongNhanVien_BUS {
	private ChamCongNhanVien_DAO cc_dao = new ChamCongNhanVien_DAO();
	
	public ArrayList<NhanVien> getDSChamCongNhanVien(int thang,int nam,String tenpb) {
		return cc_dao.getAllTableChamCong(thang,nam,tenpb);
	}
}
