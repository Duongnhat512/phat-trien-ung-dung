package entities;

import java.time.LocalTime;

public class CaLam {
	private int idCaLam;
	private String tenCaLam;
	private LocalTime thoiGianBatDau;
	private LocalTime thoiGianKetThuc;
	private double heSoLuong;
	public CaLam(int idCaLam, String tenCaLam, LocalTime thoiGianBatDau, LocalTime thoiGianKetThuc, double heSoLuong) {
		super();
		this.idCaLam = idCaLam;
		this.tenCaLam = tenCaLam;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.heSoLuong = heSoLuong;
	}
	public CaLam() {
		super();
	}
	public int getIdCaLam() {
		return idCaLam;
	}
	public void setIdCaLam(int idCaLam) {
		this.idCaLam = idCaLam;
	}
	public String getTenCaLam() {
		return tenCaLam;
	}
	public void setTenCaLam(String tenCaLam) {
		this.tenCaLam = tenCaLam;
	}
	public LocalTime getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(LocalTime thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public LocalTime getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(LocalTime thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
