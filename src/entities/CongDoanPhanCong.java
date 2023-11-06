package entities;

public class CongDoanPhanCong {
        private CongDoanSanPham congDoanSP;
        private CongNhan congNhan;
        private int soLuongSanPhamDuocGiao;
		public CongDoanPhanCong(CongDoanSanPham congDoanSP, CongNhan congNhan, int soLuongSanPhamDuocGiao) {
			super();
			this.congDoanSP = congDoanSP;
			this.congNhan = congNhan;
			this.soLuongSanPhamDuocGiao = soLuongSanPhamDuocGiao;
		}
		public CongDoanPhanCong() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public CongDoanPhanCong(CongDoanSanPham congDoanSP, CongNhan congNhan) {
			super();
			this.congDoanSP = congDoanSP;
			this.congNhan = congNhan;
		}
		public CongDoanSanPham getCongDoanSP() {
			return congDoanSP;
		}
		public void setCongDoanSP(CongDoanSanPham congDoanSP) {
			this.congDoanSP = congDoanSP;
		}
		public CongNhan getCongNhan() {
			return congNhan;
		}
		public void setCongNhan(CongNhan congNhan) {
			this.congNhan = congNhan;
		}
		public int getSoLuongSanPhamDuocGiao() {
			return soLuongSanPhamDuocGiao;
		}
		public void setSoLuongSanPhamDuocGiao(int soLuongSanPhamDuocGiao) {
			this.soLuongSanPhamDuocGiao = soLuongSanPhamDuocGiao;
		}
        
}
