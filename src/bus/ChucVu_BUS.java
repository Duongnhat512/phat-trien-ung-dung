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
	public ArrayList<ChucVu> getDSCVPhongKeToan(){
		return cv_dao.getDsCVPbKeToan();
	}
	public ArrayList<ChucVu> getDSCVPhongNhanSu(){
		return cv_dao.getDsCVPbNhanSu();
	}
	public ArrayList<ChucVu> getDSCVPhongSanXuat(){
		return cv_dao.getDsCVPbSanXuat();
	}
	
}
