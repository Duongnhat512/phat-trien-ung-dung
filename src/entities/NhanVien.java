package entities;

import java.time.LocalDate;

public class NhanVien {
	private String idNhanVien;
	private String hoTen;
	private boolean phai;
	private LocalDate ngaySinh;
	private LocalDate ngayBatDauCongTac;
	private LocalDate ngayKetThucCongTac;
	private String email;
	private String soDienThoai;
	private ChucVu chucVu;
	private final double HESOBAOHIEMXAHOI = 0.05;
	private final double LUONGCOBAN = 8000000;
	private TaiKhoan taiKhoan;
	private PhongBan phongBan;
	private double phuCap;
	public NhanVien() {
		super();
	}
	public NhanVien(String idNhanVien, String hoTen, boolean phai, LocalDate ngaySinh, LocalDate ngayBatDauCongTac,
			LocalDate ngayKetThucCongTac, String email, String soDienThoai, ChucVu chucVu, TaiKhoan taiKhoan,
			PhongBan phongBan, double phuCap) {
		super();
		this.idNhanVien = idNhanVien;
		this.hoTen = hoTen;
		this.phai = phai;
		this.ngaySinh = ngaySinh;
		this.ngayBatDauCongTac = ngayBatDauCongTac;
		this.ngayKetThucCongTac = ngayKetThucCongTac;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.chucVu = chucVu;
		this.taiKhoan = taiKhoan;
		this.phongBan = phongBan;
		this.phuCap = phuCap;
	}
	
	public NhanVien(String idNhanVien, String hoTen, boolean phai, PhongBan phongBan, double phuCap) {
		super();
		this.idNhanVien = idNhanVien;
		this.hoTen = hoTen;
		this.phai = phai;
		this.phongBan = phongBan;
		this.phuCap = phuCap;
	}
	public String getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(String idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	
	public NhanVien(String idNhanVien) {
		super();
		this.idNhanVien = idNhanVien;
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
	public ChucVu getChucVu() {
		return chucVu;
	}
	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	public double getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}
	@Override
	public String toString() {
		return "NhanVien [idNhanVien=" + idNhanVien + ", hoTen=" + hoTen + ", phai=" + phai + ", ngaySinh=" + ngaySinh
				+ ", ngayBatDauCongTac=" + ngayBatDauCongTac + ", ngayKetThucCongTac=" + ngayKetThucCongTac + ", email="
				+ email + ", soDienThoai=" + soDienThoai + ", chucVu=" + chucVu + ", HESOBAOHIEMXAHOI="
				+ HESOBAOHIEMXAHOI + ", LUONGCOBAN=" + LUONGCOBAN + ", taiKhoan=" + taiKhoan + ", phongBan=" + phongBan
				+ ", phuCap=" + phuCap + "]";
	}

	
}
