package entities;

import java.util.Objects;

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
		public int hashCode() {
			return Objects.hash(soTaiKhoan, tenNganHang);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TaiKhoanNganHang other = (TaiKhoanNganHang) obj;
			return Objects.equals(soTaiKhoan, other.soTaiKhoan) && Objects.equals(tenNganHang, other.tenNganHang);
		}
		@Override
		public String toString() {
			return "TaiKhoanNganHang [soTaiKhoan=" + soTaiKhoan + ", tenNganHang=" + tenNganHang + ", chiNhanh="
					+ chiNhanh + "]";
		}
		
}
