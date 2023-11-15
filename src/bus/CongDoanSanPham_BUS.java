package bus;

import java.util.ArrayList;

import dao.CongDoanSanPham_DAO;
import entities.CongDoanSanPham;

public class CongDoanSanPham_BUS {
	private  CongDoanSanPham_DAO cdsp_dao = new CongDoanSanPham_DAO();
	
	public ArrayList<CongDoanSanPham> getCongDoanTheoSP(String idSanPham){
		return cdsp_dao.getCongDoanTheoSP(idSanPham);
	}
	public CongDoanSanPham getCongDoanTheoID(String idCongDoan) {
		return cdsp_dao.getCongDoanTheoID(idCongDoan);
	}
	public ArrayList<CongDoanSanPham> getDSCongDoan(){
		return cdsp_dao.getDSCongDoan();
	}
	public boolean create(CongDoanSanPham cdsp){
		return cdsp_dao.create(cdsp);
	}
	public boolean update(CongDoanSanPham cdsp){
		return cdsp_dao.update(cdsp);
	}
}
