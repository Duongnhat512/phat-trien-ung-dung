package entities;

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
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
