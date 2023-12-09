package entities;

public class TaiKhoanNganHang {
        private String soTaiKhoan;
        private String tenNganHang;
        private String chiNhanh;
        private String chuTaiKhoan;
		public TaiKhoanNganHang(String soTaiKhoan, String tenNganHang,  String chuTaiKhoan,String chiNhanh) {
			super();
			this.soTaiKhoan = soTaiKhoan;
			this.tenNganHang = tenNganHang;
			this.chiNhanh = chiNhanh;
			this.chuTaiKhoan = chuTaiKhoan;
		}
		public TaiKhoanNganHang() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getChuTaiKhoan() {
			return chuTaiKhoan;
		}
		public void setChuTaiKhoan(String chuTaiKhoan) {
			this.chuTaiKhoan = chuTaiKhoan;
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
