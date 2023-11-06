package entities;

import java.time.LocalDate;
import java.util.Objects;

public class HopDongSanPham {
      private String idHopDong;
      private String tenHopDong;
      private LocalDate ngayBatDau;
      private LocalDate ngayKetThuc;
      private NhanVien nguoiQuanLy;
      private String ghiChu;
	public HopDongSanPham(String idHopDong, String tenHopDong, LocalDate ngayBatDau, LocalDate ngayKetThuc,
			NhanVien nguoiQuanLy, String ghiChu) {
		super();
		this.idHopDong = idHopDong;
		this.tenHopDong = tenHopDong;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.nguoiQuanLy = nguoiQuanLy;
		this.ghiChu = ghiChu;
	}
	public HopDongSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HopDongSanPham(String idHopDong) {
		super();
		this.idHopDong = idHopDong;
	}
	public String getIdHopDong() {
		return idHopDong;
	}
	public void setIdHopDong(String idHopDong) {
		this.idHopDong = idHopDong;
	}
	public String getTenHopDong() {
		return tenHopDong;
	}
	public void setTenHopDong(String tenHopDong) {
		this.tenHopDong = tenHopDong;
	}
	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public NhanVien getNguoiQuanLy() {
		return nguoiQuanLy;
	}
	public void setNguoiQuanLy(NhanVien nguoiQuanLy) {
		this.nguoiQuanLy = nguoiQuanLy;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idHopDong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDongSanPham other = (HopDongSanPham) obj;
		return Objects.equals(idHopDong, other.idHopDong);
	}

	
      
}