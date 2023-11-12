package entities;

import java.util.Objects;

public class SanPham {
       private String idSanPham;
       private String tenSanPham;
       private double donGia;
       private String chatLieu;
       private String donViTinh;
       private String ghiChu;
       private String anhSanPham;
       
       
	public SanPham() {
		super();
	}
	public SanPham(String idSanPham, String tenSanPham, double donGia, String chatLieu, String donViTinh, String ghiChu,
			String anhSanPham) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.chatLieu = chatLieu;
		this.donViTinh = donViTinh;
		this.ghiChu = ghiChu;
		this.anhSanPham = anhSanPham;
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
	public String getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getAnhSanPham() {
		return anhSanPham;
	}
	public void setAnhSanPham(String anhSanPham) {
		this.anhSanPham = anhSanPham;
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
