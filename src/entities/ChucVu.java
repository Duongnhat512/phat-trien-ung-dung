package entities;

import java.util.Objects;

public class ChucVu {
	 enum TenChucVu
	 {
		 NhânViênHànhChánh , KếToán, TrưởngPhòngSảnXuất, TrưởngPhòngNhânSự 
	 }
      private String idChucVu;
      private TenChucVu tenChucVu;
      private double heSoLuong;
	public ChucVu(String idChucVu, TenChucVu tenChucVu, double heSoLuong) {
		super();
		this.idChucVu = idChucVu;
		this.tenChucVu = tenChucVu;
		this.heSoLuong = heSoLuong;
	}
	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChucVu(String idChucVu) {
		super();
		this.idChucVu = idChucVu;
	}
	public String getIdChucVu() {
		return idChucVu;
	}
	public void setIdChucVu(String idChucVu) {
		this.idChucVu = idChucVu;
	}
	public TenChucVu getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(TenChucVu tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idChucVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChucVu other = (ChucVu) obj;
		return Objects.equals(idChucVu, other.idChucVu);
	}
    
}
