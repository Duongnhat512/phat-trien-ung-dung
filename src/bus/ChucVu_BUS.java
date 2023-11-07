package bus;

import dao.ChucVu_DAO;
import entities.ChucVu;

public class ChucVu_BUS {
	private ChucVu_DAO  chucVu_DAO = new ChucVu_DAO();
	
	public ChucVu getChucVuTheoID(String id) {
		return chucVu_DAO.getChucVuTheoID(id);
	}
}
