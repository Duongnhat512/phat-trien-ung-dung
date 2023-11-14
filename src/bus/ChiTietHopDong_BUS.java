package bus;

import java.util.ArrayList;

import dao.ChiTietHopDong_DAO;
import entities.ChiTietHopDong;

public class ChiTietHopDong_BUS {
	private ChiTietHopDong_DAO chiTietHopDong_DAO = new ChiTietHopDong_DAO();
	
	public ArrayList<ChiTietHopDong> getChiTietHopDongTheoIDHopDong(String id){
		return chiTietHopDong_DAO.getChiTietHopDongTheoIDHopDong(id);
	}
	public boolean themCTHopDong(ChiTietHopDong chiTietHopDong) {
		return chiTietHopDong_DAO.themCTHopDong(chiTietHopDong);
	}
}
