package entities;

import java.awt.Image;
import java.time.LocalDate;
import java.util.Objects;

public class CongNhan {
	 
      private String idCongNhan;
      private String hoTen;
      private boolean phai;
      private LocalDate ngaySinh;
      private LocalDate ngayBatDauCongTac;
      private LocalDate ngayKetThucCongTac;
      private PhanXuong phanXuong;
      private String email;
      private String soDienThoai;
      private CaLam caLam;
      private String tayNghe;
      private TaiKhoan taiKhoan;
      private String anhDaiDien;
	public CongNhan(String idCongNhan, String hoTen, boolean phai, LocalDate ngaySinh, LocalDate ngayBatDauCongTac,
			LocalDate ngayKetThucCongTac, PhanXuong phanXuong, String email, String soDienThoai, CaLam caLam,
			String tayNghe, TaiKhoan taiKhoan, String anhDaiDien) {
		super();
		this.idCongNhan = idCongNhan;
		this.hoTen = hoTen;
		this.phai = phai;
		this.ngaySinh = ngaySinh;
		this.ngayBatDauCongTac = ngayBatDauCongTac;
		this.ngayKetThucCongTac = ngayKetThucCongTac;
		this.phanXuong = phanXuong;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.caLam = caLam;
		this.tayNghe = tayNghe;
		this.taiKhoan = taiKhoan;
		this.anhDaiDien = anhDaiDien;
	}
	public CongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CongNhan(String idCongNhan) {
		super();
		this.idCongNhan = idCongNhan;
	}
	public String getIdCongNhan() {
		return idCongNhan;
	}
	public void setIdCongNhan(String idCongNhan) {
		this.idCongNhan = idCongNhan;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public LocalDate getNgayBatDauCongTac() {
		return ngayBatDauCongTac;
	}
	public void setNgayBatDauCongTac(LocalDate ngayBatDauCongTac) {
		this.ngayBatDauCongTac = ngayBatDauCongTac;
	}
	public LocalDate getNgayKetThucCongTac() {
		return ngayKetThucCongTac;
	}
	public void setNgayKetThucCongTac(LocalDate ngayKetThucCongTac) {
		this.ngayKetThucCongTac = ngayKetThucCongTac;
	}
	public PhanXuong getPhanXuong() {
		return phanXuong;
	}
	public void setPhanXuong(PhanXuong phanXuong) {
		this.phanXuong = phanXuong;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public CaLam getCaLam() {
		return caLam;
	}
	public void setCaLam(CaLam caLam) {
		this.caLam = caLam;
	}
	public String getTayNghe() {
		return tayNghe;
	}
	public void setTayNghe(String tayNghe) {
		this.tayNghe = tayNghe;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCongNhan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongNhan other = (CongNhan) obj;
		return Objects.equals(idCongNhan, other.idCongNhan);
	}
      
}
