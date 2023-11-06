package bus;

import entities.LuongNhanVien;
import entities.PhongBan;

import java.util.ArrayList;

import dao.BangLuongNhanVien_DAO;
public class BangLuongNhanVien_BUS {
	private BangLuongNhanVien_DAO bl_dao = new BangLuongNhanVien_DAO();
	public LuongNhanVien getLuongNhanVien(String idNhanVien,int thang,int nam,String pb) {
		return bl_dao.getAllTableTinhLuong(idNhanVien,thang,nam,pb);
	}
	public ArrayList<PhongBan> getAllPhongBan() {
		return bl_dao.getAllTablePhongBan();
	}
}
