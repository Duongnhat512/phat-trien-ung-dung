package entities;

import java.util.Objects;

public class ChiTietHopDong {
	private HopDongSanPham hopDongSanPham;
	private SanPham sanPham;
	private int soLuong;
	private double thanhTien;
	public ChiTietHopDong(HopDongSanPham hopDongSanPham, SanPham sanPham, int soLuong) {
		super();
		this.hopDongSanPham = hopDongSanPham;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		tinhThanhTien();
	}
	
	public ChiTietHopDong(HopDongSanPham hopDongSanPham, SanPham sanPham, int soLuong, boolean trangThai) {
		super();
		this.hopDongSanPham = hopDongSanPham;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		tinhThanhTien();
	}
	public ChiTietHopDong() {
		super();
	}
	public HopDongSanPham getHopDongSanPham() {
		return hopDongSanPham;
	}
	public void setHopDongSanPham(HopDongSanPham hopDongSanPham) {
		this.hopDongSanPham = hopDongSanPham;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void tinhThanhTien() {
		this.thanhTien = this.soLuong * this.sanPham.getDonGia();
	}
	@Override
	public int hashCode() {
		return Objects.hash(hopDongSanPham, sanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHopDong other = (ChiTietHopDong) obj;
		return Objects.equals(hopDongSanPham, other.hopDongSanPham) && Objects.equals(sanPham, other.sanPham);
	}
	
}
