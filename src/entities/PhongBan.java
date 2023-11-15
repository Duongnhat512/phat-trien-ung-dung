package entities;

import java.util.Objects;

public class PhongBan {
      private String idPhongBan;
      private String tenPhongBan;
	  public PhongBan(String idPhongBan, String tenPhongBan) {
		super();
		this.idPhongBan = idPhongBan;
		this.tenPhongBan = tenPhongBan;
	}
	public PhongBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhongBan(String idPhongBan) {
		super();
		this.idPhongBan = idPhongBan;
	}
	public String getIdPhongBan() {
		return idPhongBan;
	}
	public void setIdPhongBan(String idPhongBan) {
		this.idPhongBan = idPhongBan;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPhongBan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		return Objects.equals(idPhongBan, other.idPhongBan);
	}
      
}
