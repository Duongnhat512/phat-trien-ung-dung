package entities;

import java.time.LocalDate;
import java.util.Objects;

public class BangChamCongCongNhan {
       private String idNgayChamCong;
       private LocalDate ngayChamCong;
       private int soLuongHoanThanh;
       private CongDoanPhanCong congDoanPhanCong;
       private double heSoNgayLam;
	public BangChamCongCongNhan(String idNgayChamCong, LocalDate ngayChamCong, int soLuongHoanThanh,
			CongDoanPhanCong congDoanPhanCong, double heSoNgayLam) {
		super();
		this.idNgayChamCong = idNgayChamCong;
		this.ngayChamCong = ngayChamCong;
		this.soLuongHoanThanh = soLuongHoanThanh;
		this.congDoanPhanCong = congDoanPhanCong;
		this.heSoNgayLam = heSoNgayLam;
	}
	
	public BangChamCongCongNhan(LocalDate ngayChamCong, CongDoanPhanCong congDoanPhanCong) {
		super();
		this.ngayChamCong = ngayChamCong;
		this.congDoanPhanCong = congDoanPhanCong;
	}

	public BangChamCongCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BangChamCongCongNhan(String idNgayChamCong) {
		super();
		this.idNgayChamCong = idNgayChamCong;
	}
	public String getIdNgayChamCong() {
		return idNgayChamCong;
	}
	public void setIdNgayChamCong(String idNgayChamCong) {
		this.idNgayChamCong = idNgayChamCong;
	}
	public LocalDate getNgayChamCong() {
		return ngayChamCong;
	}
	public void setNgayChamCong(LocalDate ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}
	public int getSoLuongHoanThanh() {
		return soLuongHoanThanh;
	}
	public void setSoLuongHoanThanh(int soLuongHoanThanh) {
		this.soLuongHoanThanh = soLuongHoanThanh;
	}
	public CongDoanPhanCong getCongDoanPhanCong() {
		return congDoanPhanCong;
	}
	public void setCongDoanPhanCong(CongDoanPhanCong congDoanPhanCong) {
		this.congDoanPhanCong = congDoanPhanCong;
	}
	public double getHeSoNgayLam() {
		return heSoNgayLam;
	}
	public void setHeSoNgayLam(double heSoNgayLam) {
		this.heSoNgayLam = heSoNgayLam;
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(idNgayChamCong);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BangChamCongCongNhan other = (BangChamCongCongNhan) obj;
//		return Objects.equals(idNgayChamCong, other.idNgayChamCong);
//	}
	@Override
	public int hashCode() {
		return Objects.hash(congDoanPhanCong, ngayChamCong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangChamCongCongNhan other = (BangChamCongCongNhan) obj;
		return Objects.equals(congDoanPhanCong, other.congDoanPhanCong)
				&& Objects.equals(ngayChamCong, other.ngayChamCong);
	}  
       
}
