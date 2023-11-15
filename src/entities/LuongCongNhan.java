package entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class LuongCongNhan {
	private String idLuongCN;
	private LocalDate ngayTinhLuong;
	private CongNhan congNhan;
	private double thucLanh;
	private double tongLuong;
    private int thang;
    private int nam;
	public LuongCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public LuongCongNhan(String idLuongCN, LocalDate ngayTinhLuong, CongNhan congNhan, double thucLanh,
			double tongLuong, int thang, int nam) {
		super();
		this.idLuongCN = idLuongCN;
		this.ngayTinhLuong = ngayTinhLuong;
		this.congNhan = congNhan;
		this.thucLanh = thucLanh;
		this.tongLuong = tongLuong;
		this.thang = thang;
		this.nam = nam;
	}
    

	public int getThang() {
		return thang;
	}


	public void setThang(int thang) {
		this.thang = thang;
	}


	public int getNam() {
		return nam;
	}


	public void setNam(int nam) {
		this.nam = nam;
	}


	public double getThucLanh() {
		return thucLanh;
	}

	public void setThucLanh(double thucLanh) {
		this.thucLanh = thucLanh;
	}

	public double getTongLuong() {
		return tongLuong;
	}

	public void setTongLuong(double tongLuong) {
		this.tongLuong = tongLuong;
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

	private void tinhTongLuongCongNhan() {

	}


	@Override
	public String toString() {
		return "LuongCongNhan [idLuongCN=" + idLuongCN + ", ngayTinhLuong=" + ngayTinhLuong + ", congNhan=" + congNhan
				+ ", thucLanh=" + thucLanh + ", tongLuong=" + tongLuong + ", thang=" + thang + ", nam=" + nam
				+ ", getThang()=" + getThang() + ", getNam()=" + getNam() + ", getThucLanh()=" + getThucLanh()
				+ ", getTongLuong()=" + getTongLuong() + ", getIdLuongCN()=" + getIdLuongCN() + ", getNgayTinhLuong()="
				+ getNgayTinhLuong() + ", getCongNhan()=" + getCongNhan() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}


}
