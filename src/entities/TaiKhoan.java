package entities;

public class TaiKhoan {
	private String tenTaiKhoan;
	private String matKhau;
	private String loaiTaiKhoan;
	private TaiKhoanNganHang taiKhoanNganHang;
	public TaiKhoan() {
		super();
	}
	
	
	public TaiKhoan(String tenTaiKhoan, String matKhau, String loaiTaiKhoan, TaiKhoanNganHang taiKhoanNganHang) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.taiKhoanNganHang = taiKhoanNganHang;
	}


	public TaiKhoanNganHang getTaiKhoanNganHang() {
		return taiKhoanNganHang;
	}


	public void setTaiKhoanNganHang(TaiKhoanNganHang taiKhoanNganHang) {
		this.taiKhoanNganHang = taiKhoanNganHang;
	}


	public TaiKhoan(String tenTaiKhoan) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
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
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
