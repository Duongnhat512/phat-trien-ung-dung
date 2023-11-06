package entities;

public class TaiKhoanNganHang {
        private String soTaiKhoan;
        private String tenNganHang;
        private String chiNhanh;
		public TaiKhoanNganHang(String soTaiKhoan, String tenNganHang, String chiNhanh) {
			super();
			this.soTaiKhoan = soTaiKhoan;
			this.tenNganHang = tenNganHang;
			this.chiNhanh = chiNhanh;
		}
		public TaiKhoanNganHang() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getSoTaiKhoan() {
			return soTaiKhoan;
		}
		public void setSoTaiKhoan(String soTaiKhoan) {
			this.soTaiKhoan = soTaiKhoan;
		}
		public String getTenNganHang() {
			return tenNganHang;
		}
		public void setTenNganHang(String tenNganHang) {
			this.tenNganHang = tenNganHang;
		}
		public String getChiNhanh() {
			return chiNhanh;
		}
		public void setChiNhanh(String chiNhanh) {
			this.chiNhanh = chiNhanh;
		}
		@Override
		public String toString() {
			return "TaiKhoanNganHang [soTaiKhoan=" + soTaiKhoan + ", tenNganHang=" + tenNganHang + ", chiNhanh="
					+ chiNhanh + "]";
		}
		
}
