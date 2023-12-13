package entities;

import java.util.Objects;

public class CongDoanSanPham {
	private String idCongDoan;
	private String tenCongDoan;
	private int soLuongSanPham;
	private double luongCongDoan;
	private SanPham sanPham;

	
	public CongDoanSanPham() {
		super();
	}
	

	
	
	public CongDoanSanPham(String idCongDoan, String tenCongDoan, int soLuongSanPham, double luongCongDoan,
			SanPham sanPham) {
		super();
		this.idCongDoan = idCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.soLuongSanPham = soLuongSanPham;
		this.luongCongDoan = luongCongDoan;
		this.sanPham = sanPham;
	
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
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
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