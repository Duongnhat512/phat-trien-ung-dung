package bus;

import java.util.ArrayList;

import dao.ChamCongNhanVien_DAO;
import entities.BangChamCongNhanVien;
import entities.NhanVien;

public class ChamCongNhanVien_BUS {
	private ChamCongNhanVien_DAO cc_dao = new ChamCongNhanVien_DAO();
	private int ma;
	public ArrayList<BangChamCongNhanVien> getDSChamCongNhanVien() {
		return cc_dao.getListChamCong();
	}
	public ArrayList<BangChamCongNhanVien> getListChamCong(String ngay)
	{
		return cc_dao.getListChamCOngTrongNgay(ngay);
	}
	public ArrayList<NhanVien> getListNVchuaChamCong(String date)
	{
		return cc_dao.getListNhanVienChuaChamCongTheoNgay(date);
				
	}
	public boolean themChamCong(BangChamCongNhanVien bcc)
	{
		ma = cc_dao.getListChamCong().size()+1;
		String maCC = "CNVHC" + String.format("%04d",ma);
		while(getDSChamCongNhanVien().contains(new BangChamCongNhanVien(maCC)))
		{
			ma++;
			maCC = "CNVHC"+String.format("%04d", ma);
		}
		bcc.setIdChamCongNVHC(maCC);
		if(cc_dao.themChamCong(bcc))
		{
			return true;
		}
		return false;
	}
	public boolean update(BangChamCongNhanVien bcc)
	{
		if(cc_dao.update(bcc))
		{
			return true;
		}
		return false;
	}
	public ArrayList<NhanVien> getDSChamCongNhanVien(int thang,int nam,String tenpb) {
		return cc_dao.getAllTableChamCong(thang,nam,tenpb);
	}
}
