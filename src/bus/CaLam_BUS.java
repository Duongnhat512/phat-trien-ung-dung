package bus;

import java.util.ArrayList;

import dao.CaLam_DAO;
import entities.CaLam;

public class CaLam_BUS {
	private CaLam_DAO caLam_DAO = new CaLam_DAO();
	
	public ArrayList<CaLam> getDanhSachCaLam() {
		return caLam_DAO.getDanhSachCaLam();
	}
	public CaLam getCaLamTheoID(int id) {
		return caLam_DAO.getCaLamTheoID(id);
	}
}
