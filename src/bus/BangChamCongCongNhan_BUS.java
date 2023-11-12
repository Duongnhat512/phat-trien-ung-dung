package bus;

import java.util.ArrayList;

import dao.BangChamCongCongNhan_DAO;
import entities.BangChamCongCongNhan;

public class BangChamCongCongNhan_BUS {
	private BangChamCongCongNhan_DAO bangChamCongCongNhan_DAO = new BangChamCongCongNhan_DAO();
	
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCong(){
		return bangChamCongCongNhan_DAO.getDanhSachChamCong();
	}
	public ArrayList<BangChamCongCongNhan> getDanhSachChamCongTheoNgay(int ngay, int thang, int nam){
		return bangChamCongCongNhan_DAO.getDanhSachChamCongTheoNgay(ngay, thang, nam);
	}
}
