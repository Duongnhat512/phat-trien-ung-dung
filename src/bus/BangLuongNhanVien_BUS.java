package bus;

import entities.LuongNhanVien;
import entities.PhongBan;

import java.util.ArrayList;

import dao.BangLuongNhanVien_DAO;
public class BangLuongNhanVien_BUS {
	private BangLuongNhanVien_DAO bl_dao = new BangLuongNhanVien_DAO();
	public LuongNhanVien getLuongNhanVien(String idNhanVien,int thang,int nam) {
		return bl_dao.getAllTableTinhLuong(idNhanVien,thang,nam);
	}
	public int[] getChiTietLuong(String idNhanVien,int thang,int nam){
		return bl_dao.getChiTietLuongNhanVien(idNhanVien, thang,nam);
	}
	public ArrayList<LuongNhanVien> getAllTableTinhLuongTheoThang(String phongBan, int thang, int nam) {
		return bl_dao.getAllTableTinhLuongTheoThang(phongBan, thang, nam);
	}
	public boolean kiemTraTonTaiLuongNhanVien(String idBangLuong) {
		return bl_dao.kiemTraTonTaiLuongNhanVien(idBangLuong);
	}
	public boolean themBangLuongNhanVien(LuongNhanVien luong, int thang, int nam) {
		return bl_dao.themBangLuongNhanVien(luong, thang, nam);
	}
}
