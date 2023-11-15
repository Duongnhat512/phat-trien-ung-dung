package bus;

import entities.LuongCongNhan;
import entities.LuongNhanVien;
import entities.PhongBan;

import java.util.ArrayList;

import dao.BangLuongCongNhan_DAO;
import dao.BangLuongNhanVien_DAO;
public class BangLuongCongNhan_BUS {
	private BangLuongCongNhan_DAO bl_dao = new BangLuongCongNhan_DAO();
	public LuongCongNhan  getLuongCongNhan(String idCongNhan,int thang,int nam) {
		return bl_dao.getAllTableTinhLuong(idCongNhan,thang,nam);
	}
	public int[] TinhTongSanLuongVaThoiGianLamViec(String idCongNhan,int thang,int nam) {
		return bl_dao.TinhTongSanLuongVaThoiGianLamViec(idCongNhan, thang, nam);
	}
	public boolean themBangLuongCongNhan(LuongCongNhan luong,int thang,int nam) {
		return bl_dao.themBangLuongCongNhan(luong, thang, nam);		
	}
	public boolean kiemTraTonTaiLuongCongNhan(String idBangLuong) {
		return bl_dao.kiemTraTonTaiLuongCongNhan(idBangLuong);
	}
	 public ArrayList<LuongCongNhan> getAllTableTinhLuongTheoThang(String phanXuong,int thang,int nam){
		 return bl_dao.getAllTableTinhLuongTheoThang(phanXuong, thang, nam);
	 }
	 public ArrayList<String[]> getChiTietLuong(String idCongNhan, int thang, int nam) {
		 return bl_dao.getChiTietLuong(idCongNhan, thang, nam);
	 }
}

