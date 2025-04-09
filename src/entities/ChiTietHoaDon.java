/* Người làm: Nguyễn Tuấn Phát */
package entities;

public class ChiTietHoaDon {
	private String maHoaDon;
	private int maMon; 
	private float donGia;
	private float giamGia;
	private int soLuong;
	private String donViTinh;

	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public int getMaMon() {
		return maMon;
	}
	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public float getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(float giamGia) {
		this.giamGia = giamGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public float tinhThanhTien() {
		return soLuong * donGia * (1 - giamGia);
	}

	public ChiTietHoaDon(String maHoaDon, int maMon, float donGia, float giamGia, int soLuong, String donViTinh) {
		super();
		this.maHoaDon = maHoaDon;
		this.maMon = maMon;
		this.donGia = donGia;
		this.giamGia = giamGia;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
	}

	public ChiTietHoaDon() {
		super();
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", maMon=" + maMon + ", donGia=" + donGia + ", giamGia="
				+ giamGia + ", soLuong=" + soLuong + ", donViTinh=" + donViTinh + "]";
	}
}
