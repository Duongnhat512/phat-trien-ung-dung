package entities;

import java.time.LocalDate;
import java.util.Objects;

public class LuongNhanVien {
    private String idLuong;
    private LocalDate ngayTinhLuong;
    private NhanVien nhanVien;
    private double tongLuong;
    private double thueLaoDong;
    private double thueBHXH;
	private double thucLanh;

	public LuongNhanVien(String idLuong, LocalDate ngayTinhLuong, NhanVien nhanVien, double tongLuong,
			double thueLaoDong, double thueBHXH, double thucLanh) {
		super();
		this.idLuong = idLuong;
		this.ngayTinhLuong = ngayTinhLuong;
		this.nhanVien = nhanVien;
		this.tongLuong = tongLuong;
		this.thueLaoDong = thueLaoDong;
		this.thueBHXH = thueBHXH;
		this.thucLanh = thucLanh;
	}
	public LuongNhanVien() {
		super();
	}
	public LuongNhanVien(String idLuong) {
		super();
		this.idLuong = idLuong;
	}
	public String getIdLuong() {
		return idLuong;
	}
	public void setIdLuong(String idLuong) {
		this.idLuong = idLuong;
	}
	public LocalDate getNgayTinhLuong() {
		return ngayTinhLuong;
	}
	public void setNgayTinhLuong(LocalDate ngayTinhLuong) {
		this.ngayTinhLuong = ngayTinhLuong;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public double getTongLuong() {
		return tongLuong;
	}
	public void setTongLuong(double tongLuong) {
		this.tongLuong = tongLuong;
	}
	public double getThueLaoDong() {
		return thueLaoDong;
	}
	public void setThueLaoDong(double thueLaoDong) {
		this.thueLaoDong = thueLaoDong;
	}
	
	public double getThueBHXH() {
		return thueBHXH;
	}
	public void setThueBHXH(double thueBHXH) {
		this.thueBHXH = thueBHXH;
	}
	public double getThucLanh() {
		return thucLanh;
	}
	public void setThucLanh(double thucLanh) {
		this.thucLanh = thucLanh;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idLuong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LuongNhanVien other = (LuongNhanVien) obj;
		return Objects.equals(idLuong, other.idLuong);
	}
	@Override
	public String toString() {
		return "LuongNhanVien [idLuong=" + idLuong + ", ngayTinhLuong=" + ngayTinhLuong + ", nhanVien=" + nhanVien
				+ ", tongLuong=" + tongLuong + ", thueLaoDong=" + thueLaoDong + ", thueBHXH=" + thueBHXH
				+ ", thucLanh=" + thucLanh + "]";
	}

    
        
}
