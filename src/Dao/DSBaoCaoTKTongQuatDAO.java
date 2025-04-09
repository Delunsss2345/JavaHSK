/* Người làm: Nguyễn Tuấn Phát */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.ConectDatabase;
import entities.ThongKeBaoCaoTQ;

public class DSBaoCaoTKTongQuatDAO {
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	public DSBaoCaoTKTongQuatDAO() {}

	public List<String> getAllNgayLapHoaDon() throws Exception {
		List<String> result = new ArrayList<>();
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT NgayLap FROM HoaDon";
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				result.add(rs.getString("NgayLap"));
			}
		} finally {
			if (rs != null) rs.close();
			if (pre != null) pre.close();
		}
		return result;
	}

	public double tinhTongDoanhThuTheoThang(int thang, int nam) throws Exception {
		double tongTien = 0;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = """
				SELECT SUM(ct.SoLuong * ct.DonGia) AS TongTien
				FROM HoaDon hd JOIN CT_HoaDon ct ON hd.MaHoaDon = ct.MaHoaDon
				WHERE MONTH(NgayLap) = ? AND YEAR(NgayLap) = ?
			""";
			pre = con.prepareStatement(sql);
			pre.setInt(1, thang);
			pre.setInt(2, nam);
			rs = pre.executeQuery();
			if (rs.next()) {
				tongTien = rs.getDouble("TongTien");
			}
		} finally {
			if (rs != null) rs.close();
			if (pre != null) pre.close();
		}
		return tongTien;
	}

	public double tinhTongChiNhapNguyenLieuTheoThang(int thang, int nam) throws Exception {
		double tongTienNhap = 0;
		try {
			con = ConectDatabase.getInstance().getConnection();
			String sql = """
				SELECT SUM(ct.SoLuong * nl.GiaNhap) AS TongTienNhap
				FROM CT_HoaDon ct
				JOIN Mon nl ON ct.MaMon = nl.MaMon
				JOIN HoaDon hd ON ct.MaHoaDon = hd.MaHoaDon
				WHERE MONTH(hd.NgayLap) = ? AND YEAR(hd.NgayLap) = ?
			""";
			pre = con.prepareStatement(sql);
			pre.setInt(1, thang);
			pre.setInt(2, nam);
			rs = pre.executeQuery();
			if (rs.next()) {
				tongTienNhap = rs.getDouble("TongTienNhap");
			}
		} finally {
			if (rs != null) rs.close();
			if (pre != null) pre.close();
		}
		return tongTienNhap;
	}

	public List<ThongKeBaoCaoTQ> thongKeMonDaBan_TheoThang(int thang, int nam, int caLam) throws Exception {
		List<ThongKeBaoCaoTQ> dsMon = new ArrayList<>();
		try {
			con = ConectDatabase.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("""
				SELECT m.MaMon, m.TenMon, m.DonGia, m.GiaNhap,
				       CONVERT(NVARCHAR(10), hd.NgayLap, 103) AS NgayBan,
				       SUM(ct.SoLuong) AS SoLuongBan,
				       SUM(ct.SoLuong * ct.DonGia) AS DoanhThu,
				       SUM(ct.SoLuong * m.GiaNhap) AS ChiPhi
				FROM CT_HoaDon ct
				JOIN Mon m ON ct.MaMon = m.MaMon
				JOIN HoaDon hd ON ct.MaHoaDon = hd.MaHoaDon
			""");

			if (caLam != 0) {
				sql.append("JOIN NhanVien nv ON hd.MaNhanVien = nv.MaNhanVien ")
				   .append("WHERE MONTH(hd.NgayLap) = ? AND YEAR(hd.NgayLap) = ? AND nv.CaLamViec = ? ");
			} else {
				sql.append("WHERE MONTH(hd.NgayLap) = ? AND YEAR(hd.NgayLap) = ? ");
			}

			sql.append("GROUP BY m.MaMon, m.TenMon, m.DonGia, m.GiaNhap, CONVERT(NVARCHAR(10), hd.NgayLap, 103)");

			pre = con.prepareStatement(sql.toString());
			pre.setInt(1, thang);
			pre.setInt(2, nam);
			if (caLam != 0) pre.setInt(3, caLam);

			rs = pre.executeQuery();
			while (rs.next()) {
				ThongKeBaoCaoTQ mon = new ThongKeBaoCaoTQ();
				mon.setMaMon(rs.getString("MaMon"));
				mon.setTenMon(rs.getString("TenMon"));
				mon.setDonGia(rs.getDouble("DonGia"));
				mon.setDonGiaNhap(rs.getDouble("GiaNhap"));
				mon.setNgay(rs.getString("NgayBan"));
				mon.setSoLuongBan(rs.getInt("SoLuongBan"));
				mon.setDoanhThu(rs.getDouble("DoanhThu"));
				mon.setChiPhiNhap(rs.getDouble("ChiPhi"));
				dsMon.add(mon);
			}
		} finally {
			if (rs != null) rs.close();
			if (pre != null) pre.close();
		}
		return dsMon;
	}
}
