package entities;

public class TaiKhoanNganHang {
	private String soTaiKhoan;
	private String tenTaiKhoan;
	private String chuTaiKhoan;
	private String chiNhanh;
	public TaiKhoanNganHang(String soTaiKhoan, String tenTaiKhoan, String chuTaiKhoan, String chiNhanh) {
		super();
		this.soTaiKhoan = soTaiKhoan;
		this.tenTaiKhoan = tenTaiKhoan;
		this.chuTaiKhoan = chuTaiKhoan;
		this.chiNhanh = chiNhanh;
	}
	public TaiKhoanNganHang() {
		super();
	}
	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}
	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getChuTaiKhoan() {
		return chuTaiKhoan;
	}
	public void setChuTaiKhoan(String chuTaiKhoan) {
		this.chuTaiKhoan = chuTaiKhoan;
	}
	public String getChiNhanh() {
		return chiNhanh;
	}
	public void setChiNhanh(String chiNhanh) {
		this.chiNhanh = chiNhanh;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
