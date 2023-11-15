package entities;

import java.time.LocalDate;
import java.util.Objects;

public class BangChamCongNhanVien {
	    
        private String idChamCongNVHC ;
        private LocalDate ngayChamCong;
        private String trangThai;
		private NhanVien nhanVien;
		public BangChamCongNhanVien(String idChamCongNVHC, LocalDate ngayChamCong, String trangThai,
				NhanVien nhanVien) {
			super();
			this.idChamCongNVHC = idChamCongNVHC;
			this.ngayChamCong = ngayChamCong;
			this.trangThai = trangThai;
			this.nhanVien = nhanVien;
		}
		public BangChamCongNhanVien() {
			super();
			// TODO Auto-generated constructor stub
		}
		public BangChamCongNhanVien(String idChamCongNVHC) {
			super();
			this.idChamCongNVHC = idChamCongNVHC;
		}
		public String getIdChamCongNVHC() {
			return idChamCongNVHC;
		}
		public void setIdChamCongNVHC(String idChamCongNVHC) {
			this.idChamCongNVHC = idChamCongNVHC;
		}
		public LocalDate getNgayChamCong() {
			return ngayChamCong;
		}
		public void setNgayChamCong(LocalDate ngayChamCong) {
			this.ngayChamCong = ngayChamCong;
		}
		public String getTrangThai() {
			return trangThai;
		}
		public void setTrangThai(String trangThai) {
			this.trangThai = trangThai;
		}
		public NhanVien getNhanVien() {
			return nhanVien;
		}
		public void setNhanVien(NhanVien nhanVien) {
			this.nhanVien = nhanVien;
		}
		@Override
		public int hashCode() {
			return Objects.hash(idChamCongNVHC);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BangChamCongNhanVien other = (BangChamCongNhanVien) obj;
			return Objects.equals(idChamCongNVHC, other.idChamCongNVHC);
		}
		
}
