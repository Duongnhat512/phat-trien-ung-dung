package entities;

import java.util.Objects;

public class CongDoanSanPham {
	private String idCongDoan;
	private String tenCongDoan;
	private int soLuongSanPham;
	private double luongCongDoan;
	private int soLuongCongNhan;
	private SanPham sanPham;
	private String thiTuUuTien;
	
	public CongDoanSanPham() {
		super();
	}
	public CongDoanSanPham(String idCongDoan, String tenCongDoan, int soLuongSanPham, double luongCongDoan,
			int soLuongCongNhan, SanPham sanPham, String thiTuUuTien) {
		super();
		this.idCongDoan = idCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.soLuongSanPham = soLuongSanPham;
		this.luongCongDoan = luongCongDoan;
		this.soLuongCongNhan = soLuongCongNhan;
		this.sanPham = sanPham;
		this.thiTuUuTien = thiTuUuTien;
	}
	
	public String getIdCongDoan() {
		return idCongDoan;
	}
	public void setIdCongDoan(String idCongDoan) {
		this.idCongDoan = idCongDoan;
	}
	public String getTenCongDoan() {
		return tenCongDoan;
	}
	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
	public double getLuongCongDoan() {
		return luongCongDoan;
	}
	public void setLuongCongDoan(double luongCongDoan) {
		this.luongCongDoan = luongCongDoan;
	}
	public int getSoLuongCongNhan() {
		return soLuongCongNhan;
	}
	public void setSoLuongCongNhan(int soLuongCongNhan) {
		this.soLuongCongNhan = soLuongCongNhan;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public String getThiTuUuTien() {
		return thiTuUuTien;
	}
	public void setThiTuUuTien(String thiTuUuTien) {
		this.thiTuUuTien = thiTuUuTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCongDoan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongDoanSanPham other = (CongDoanSanPham) obj;
		return Objects.equals(idCongDoan, other.idCongDoan);
	}
	
}
