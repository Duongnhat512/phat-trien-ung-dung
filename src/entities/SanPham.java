package entities;

import java.util.Objects;

public class SanPham {
       private String idSanPham;
       private String tenSanPham;
       private double donGia;
       private String donViTinh;
       private int soLuong;
       private HopDongSanPham hopDongSanPham;
       private String ghiChu;
	public SanPham(String idSanPham, String tenSanPham, double donGia, String donViTinh, int soLuong,
			HopDongSanPham hopDongSanPham, String ghiChu) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.hopDongSanPham = hopDongSanPham;
		this.ghiChu = ghiChu;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(String idSanPham) {
		super();
		this.idSanPham = idSanPham;
	}
	public String getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public HopDongSanPham getHopDongSanPham() {
		return hopDongSanPham;
	}
	public void setHopDongSanPham(HopDongSanPham hopDongSanPham) {
		this.hopDongSanPham = hopDongSanPham;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(idSanPham, other.idSanPham);
	}
       
}
