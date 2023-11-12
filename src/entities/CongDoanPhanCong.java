package entities;

import java.util.Objects;

public class CongDoanPhanCong {
	private String idPhanCong;
    private CongDoanSanPham congDoanSP;
    private CongNhan congNhan;
    private int soLuongSanPhamDuocGiao;
	private CaLam caLam;
	private int soLuongConLai;
	public CongDoanPhanCong(String idPhanCong, CongDoanSanPham congDoanSP, CongNhan congNhan,
			int soLuongSanPhamDuocGiao, CaLam caLam, int soLuongConLai) {
		super();
		this.idPhanCong = idPhanCong;
		this.congDoanSP = congDoanSP;
		this.congNhan = congNhan;
		this.soLuongSanPhamDuocGiao = soLuongSanPhamDuocGiao;
		this.caLam = caLam;
		this.soLuongConLai = soLuongConLai;
	}
	public CongDoanPhanCong() {
		super();
	}
	public String getIdPhanCong() {
		return idPhanCong;
	}
	public void setIdPhanCong(String idPhanCong) {
		this.idPhanCong = idPhanCong;
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
	public CaLam getCaLam() {
		return caLam;
	}
	public void setCaLam(CaLam caLam) {
		this.caLam = caLam;
	}
	public int getSoLuongConLai() {
		return soLuongConLai;
	}
	public void setSoLuongConLai(int soLuongConLai) {
		this.soLuongConLai = soLuongConLai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPhanCong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongDoanPhanCong other = (CongDoanPhanCong) obj;
		return Objects.equals(idPhanCong, other.idPhanCong);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
    
        
}
