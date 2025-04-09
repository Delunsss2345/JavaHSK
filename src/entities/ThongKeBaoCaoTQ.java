/* Người làm: Nguyễn Hoài Phúc */
package entities;

public class ThongKeBaoCaoTQ {

	private String maMon;
	private String tenMon;
	private double donGia;
	private double donGiaNhap;
	private int soLuongNhap;
	private int soLuongBan;
	private double loiNhuan;
	private String ngay;
	private String soDK;
	private double tienNhapMon;
	private double doanhThu;
	private double chiPhiNhap;

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getDonGiaNhap() {
		return donGiaNhap;
	}

	public void setDonGiaNhap(double donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}

	public int getSoLuongNhap() {
		return soLuongNhap;
	}

	public void setSoLuongNhap(int soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}

	public int getSoLuongBan() {
		return soLuongBan;
	}

	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}

	public double getLoiNhuan() {
		return loiNhuan;
	}

	public void setLoiNhuan(double loiNhuan) {
		this.loiNhuan = loiNhuan;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getSoDK() {
		return soDK;
	}

	public void setSoDK(String soDK) {
		this.soDK = soDK;
	}

	public double getTienNhapMon() {
		return tienNhapMon;
	}

	public void setTienNhapMon(double tienNhapMon) {
		this.tienNhapMon = tienNhapMon;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public double getChiPhiNhap() {
		return chiPhiNhap;
	}

	public void setChiPhiNhap(double chiPhiNhap) {
		this.chiPhiNhap = chiPhiNhap;
	}

	public ThongKeBaoCaoTQ() {
		super();
	}

	public ThongKeBaoCaoTQ(String maMon, String tenMon, double donGia, double donGiaNhap, int soLuongNhap,
			int soLuongBan, double loiNhuan, String ngay, String soDK, double tienNhapMon,
			double doanhThu, double chiPhiNhap) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.donGia = donGia;
		this.donGiaNhap = donGiaNhap;
		this.soLuongNhap = soLuongNhap;
		this.soLuongBan = soLuongBan;
		this.loiNhuan = loiNhuan;
		this.ngay = ngay;
		this.soDK = soDK;
		this.tienNhapMon = tienNhapMon;
		this.doanhThu = doanhThu;
		this.chiPhiNhap = chiPhiNhap;
	}

	@Override
	public String toString() {
		return "ThongKeBaoCaoTQ [maMon=" + maMon + ", tenMon=" + tenMon + ", donGia=" + donGia + ", donGiaNhap="
				+ donGiaNhap + ", soLuongNhap=" + soLuongNhap + ", soLuongBan=" + soLuongBan + ", loiNhuan=" + loiNhuan
				+ ", ngay=" + ngay + ", soDK=" + soDK + ", tienNhapMon=" + tienNhapMon + ", doanhThu=" + doanhThu
				+ ", chiPhiNhap=" + chiPhiNhap + "]";
	}
}
