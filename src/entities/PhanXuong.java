package entities;

import java.util.Objects;

public class PhanXuong {
       private String idPhanXuong;
       private String tenPhanXuong;
	public PhanXuong(String idPhanXuong, String tenPhanXuong) {
		super();
		this.idPhanXuong = idPhanXuong;
		this.tenPhanXuong = tenPhanXuong;
	}
	public PhanXuong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PhanXuong(String idPhanXuong) {
		super();
		this.idPhanXuong = idPhanXuong;
	}
	public String getIdPhanXuong() {
		return idPhanXuong;
	}
	public void setIdPhanXuong(String idPhanXuong) {
		this.idPhanXuong = idPhanXuong;
	}
	public String getTenPhanXuong() {
		return tenPhanXuong;
	}
	public void setTenPhanXuong(String tenPhanXuong) {
		this.tenPhanXuong = tenPhanXuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPhanXuong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhanXuong other = (PhanXuong) obj;
		return Objects.equals(idPhanXuong, other.idPhanXuong);
	}
	
       
}
