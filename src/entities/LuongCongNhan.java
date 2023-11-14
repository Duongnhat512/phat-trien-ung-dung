package entities;

import java.time.LocalDate;
import java.util.Objects;

public class LuongCongNhan {
    private String idLuongCN;
    private LocalDate ngayTinhLuong;
    private CongNhan congNhan;
	public LuongCongNhan(String idLuongCN, LocalDate ngayTinhLuong, CongNhan congNhan) {
		super();
		this.idLuongCN = idLuongCN;
		this.ngayTinhLuong = ngayTinhLuong;
		this.congNhan = congNhan;
	}
	public LuongCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LuongCongNhan(String idLuongCN) {
		super();
		this.idLuongCN = idLuongCN;
	}
	public String getIdLuongCN() {
		return idLuongCN;
	}
	public void setIdLuongCN(String idLuongCN) {
		this.idLuongCN = idLuongCN;
	}
	public LocalDate getNgayTinhLuong() {
		return ngayTinhLuong;
	}
	public void setNgayTinhLuong(LocalDate ngayTinhLuong) {
		this.ngayTinhLuong = ngayTinhLuong;
	}
	public CongNhan getCongNhan() {
		return congNhan;
	}
	public void setCongNhan(CongNhan congNhan) {
		this.congNhan = congNhan;
	}
	
    @Override
	public int hashCode() {
		return Objects.hash(idLuongCN);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LuongCongNhan other = (LuongCongNhan) obj;
		return Objects.equals(idLuongCN, other.idLuongCN);
	}
	private void tinhTongLuongCongNhan()
    {
    	
    }
}
