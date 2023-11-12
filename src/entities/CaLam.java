package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class CaLam {
      private int idCaLam;
      private String tenCaLam;
      private LocalTime thoiGianBatDau;
      private LocalTime thoiGianKetThuc;
      private double heSoLuong;
//	public CaLam(int idCaLam, TenCaLam tenCaLam, LocalTime thoiGianBatDau, LocalTime thoiGianKetThuc,
//			double heSoLuong) {
//		super();
//		this.idCaLam = idCaLam;
//		this.tenCaLam = tenCaLam;
//		this.thoiGianBatDau = thoiGianBatDau;
//		this.thoiGianKetThuc = thoiGianKetThuc;
//		this.heSoLuong = heSoLuong;
//	}
	
	public CaLam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaLam(int idCaLam, String tenCaLam, LocalTime thoiGianBatDau, LocalTime thoiGianKetThuc, double heSoLuong) {
	super();
	this.idCaLam = idCaLam;
	this.tenCaLam = tenCaLam;
	this.thoiGianBatDau = thoiGianBatDau;
	this.thoiGianKetThuc = thoiGianKetThuc;
	this.heSoLuong = heSoLuong;
}
	public CaLam(int idCaLam) {
		super();
		this.idCaLam = idCaLam;
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
	public int hashCode() {
		return Objects.hash(idCaLam);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaLam other = (CaLam) obj;
		return Objects.equals(idCaLam, other.idCaLam);
	}
      
      
      
}  
