package entities;

import java.util.Objects;

public class TaiKhoan {
	private String tenTaiKhoan;
	private String matKhau;
	private String loaiTaiKhoan;
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(String tenTaiKhoan, String matKhau, String loaiTaiKhoan) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}
	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}
	public void layLaiMatKhau() {
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tenTaiKhoan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(tenTaiKhoan, other.tenTaiKhoan);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
