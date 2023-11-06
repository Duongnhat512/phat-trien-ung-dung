package entities;

import java.time.LocalDate;
import java.util.Objects;

public class CaLam {
	  enum TenCaLam
	  {
		  CaSang,CaChieu,CaToi;
	  }
      private String idCaLam;
      private TenCaLam tenCaLam;
      private LocalDate thoiGianBatDau;
      private LocalDate thoiGianKetThuc;
      private double heSoLuong;
	public CaLam(String idCaLam, TenCaLam tenCaLam, LocalDate thoiGianBatDau, LocalDate thoiGianKetThuc,
			double heSoLuong) {
		super();
		this.idCaLam = idCaLam;
		this.tenCaLam = tenCaLam;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.heSoLuong = heSoLuong;
	}
	public CaLam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaLam(String idCaLam) {
		super();
		this.idCaLam = idCaLam;
	}
	public String getIdCaLam() {
		return idCaLam;
	}
	public void setIdCaLam(String idCaLam) {
		this.idCaLam = idCaLam;
	}
	public TenCaLam getTenCaLam() {
		return tenCaLam;
	}
	public void setTenCaLam(TenCaLam tenCaLam) {
		this.tenCaLam = tenCaLam;
	}
	public LocalDate getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public LocalDate getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
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
