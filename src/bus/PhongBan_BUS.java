package bus;

import java.util.ArrayList;

import dao.PhongBan_DAO;
import entities.PhongBan;



public class PhongBan_BUS {
	private PhongBan_DAO pb_dao = new PhongBan_DAO();
	
	public ArrayList<PhongBan> getDSPB(){
		return pb_dao.getdsPB();
	}
	public PhongBan getPB(String id){
		return pb_dao.getPhongBanTheoID(id);
	}
	public PhongBan getPBTheoTen(String ten){
		return pb_dao.getPhongBanTheoTen(ten);
	}
	public PhongBan getPBtheoID(String id)
	{
		ArrayList<PhongBan> listPB = pb_dao.getdsPB();
		for (PhongBan phongBan : listPB) {
			if(phongBan.getIdPhongBan().equals(id))
			{
				return phongBan;
			}
		}
		return null;
	}
	public PhongBan getPhongBanTheoIDNhanVien(String idNhanVien) {
		return pb_dao.getPhongBanTheoIDNhanVien(idNhanVien);
	}
}
