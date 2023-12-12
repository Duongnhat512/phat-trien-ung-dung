package entities;

public class TaiKhoanNganHang {
        private String soTaiKhoan;
        private  final String tenNganHang = "Sacombank";
        private final String chiNhanh = "Gò Vấp, TP HCM";
        private String chuTaiKhoan;
		public TaiKhoanNganHang(String soTaiKhoan,  String chuTaiKhoan) {
			super();
			this.soTaiKhoan = soTaiKhoan;
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
	
		public String getChiNhanh() {
			return chiNhanh;
		}
		
		@Override
		public String toString() {
			return "TaiKhoanNganHang [soTaiKhoan=" + soTaiKhoan + ", tenNganHang=" + tenNganHang + ", chiNhanh="
					+ chiNhanh + "]";
		}
		
}
