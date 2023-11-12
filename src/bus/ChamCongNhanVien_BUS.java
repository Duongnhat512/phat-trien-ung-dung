package bus;

import java.util.ArrayList;

import dao.BangChamCongNhanVien_DAO;
import entities.NhanVien;

public class ChamCongNhanVien_BUS {
	private BangChamCongNhanVien_DAO cc_dao = new BangChamCongNhanVien_DAO();
	
	public ArrayList<NhanVien> getDSChamCongNhanVien(int thang,int nam,String tenpb) {
		return cc_dao.getAllTableChamCong(thang,nam,tenpb);
	}
}
