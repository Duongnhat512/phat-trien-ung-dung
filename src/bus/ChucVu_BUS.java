package bus;

import java.util.ArrayList;

import dao.ChucVu_DAO;
import entities.ChucVu;

public class ChucVu_BUS {
	private ChucVu_DAO cv_dao = new ChucVu_DAO();
	
	public ArrayList<ChucVu> getDSCV(){
		return cv_dao.getdsCV();
	}
	public ChucVu getCV(String id){
		return cv_dao.getChucVuTheoID(id);
	}
	public ChucVu getCVTheoTen(String ten){
		return cv_dao.getChucVuTheoTen(ten);
	}
}
