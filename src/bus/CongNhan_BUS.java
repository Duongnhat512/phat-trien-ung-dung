package bus;

import java.util.ArrayList;

import dao.CongNhan_DAO;
import entities.CongNhan;

public class CongNhan_BUS {
	private CongNhan_DAO congNhan_DAO = new CongNhan_DAO();
	
	public ArrayList<CongNhan> getDanhSachCongNhan(){
		return congNhan_DAO.getDanhSachCongNhan();
	}
	public CongNhan getCongNhanTheoID(String id){
		return congNhan_DAO.getCongNhanTheoID(id);
	}
	public ArrayList<CongNhan> getDanhSachCongNhanTheoCa(int idCaLam){
		return congNhan_DAO.getDanhSachCongNhanTheoCa(idCaLam);
	}
	public boolean create(CongNhan cn){
		return congNhan_DAO.create(cn);
	}
	public boolean update(CongNhan cn){
		return congNhan_DAO.update(cn);
	}
	public ArrayList<CongNhan> getDanhSachCongNhanChuaPhanCong(){
		return congNhan_DAO.getDanhSachCongNhanChuaPhanCong();
	}
}
