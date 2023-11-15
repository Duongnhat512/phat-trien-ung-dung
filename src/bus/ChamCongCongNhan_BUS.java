package bus;

import java.util.ArrayList;

import dao.ChamCongCongNhan_DAO;
import entities.BangChamCongCongNhan;
import entities.CongNhan;
import entities.NhanVien;

public class ChamCongCongNhan_BUS {
	private ChamCongCongNhan_DAO cc_dao = new ChamCongCongNhan_DAO();
	
	public ArrayList<CongNhan> getDSChamCongCongNhan(int thang,int nam,String tenpb) {
		return cc_dao.getAllTableChamCong(thang,nam,tenpb);
	}
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCong(){
		return cc_dao.getDanhSachChamCong();
	}
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCongTheoNgay(int ngay, int thang, int nam){
		return cc_dao.getDanhSachChamCongTheoNgay(ngay, thang, nam);
	}
	public boolean themChamCong(BangChamCongCongNhan ngayCong) {
		return cc_dao.themChamCong(ngayCong);
	}
	public boolean capNhatSoLuongHoanThanh(BangChamCongCongNhan bangCC) {
		return cc_dao.capNhatSoLuongHoanThanh(bangCC);
	}
}
