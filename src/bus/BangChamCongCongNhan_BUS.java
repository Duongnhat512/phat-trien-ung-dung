package bus;

import java.util.ArrayList;

import dao.BangChamCongCongNhan_DAO;
import entities.BangChamCongCongNhan;
import entities.CongNhan;

public class BangChamCongCongNhan_BUS {
	private BangChamCongCongNhan_DAO bangChamCongCongNhan_DAO = new BangChamCongCongNhan_DAO();
	
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCong(){
		return bangChamCongCongNhan_DAO.getDanhSachChamCong();
	}
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCongTheoNgay(int ngay, int thang, int nam){
		return bangChamCongCongNhan_DAO.getDanhSachChamCongTheoNgay(ngay, thang, nam);
	}
	public boolean themChamCong(BangChamCongCongNhan ngayCong) {
		return bangChamCongCongNhan_DAO.themChamCong(ngayCong);
	}
	public boolean capNhatSoLuongHoanThanh(BangChamCongCongNhan bangCC) {
		return bangChamCongCongNhan_DAO.capNhatSoLuongHoanThanh(bangCC);
	}
	public ArrayList<CongNhan> getAllTableChamCong(int thang, int nam, String tenpb) {
		return bangChamCongCongNhan_DAO.getAllTableChamCong(thang, nam, tenpb);
	}
}
