/* Người làm: Nguyễn Tuấn Phát */

package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConectDatabase;
import entities.ChiTietHoaDon;
import entities.HoaDon;

public class HoaDonDAO {
	public HoaDonDAO() {
		ConectDatabase.getInstance().connect();
	}

	public List<HoaDon> getHoaDons() {
		List<HoaDon> list= new ArrayList<>();
		try {
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql="SELECT MaHoaDon, NgayLap, TongTien, MaNhanVien, MaKhachHang FROM HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				double tongTien = rs.getDouble(3);
				int nhanVien = rs.getInt(4);
				int khachHang = rs.getInt(5);
				HoaDon hd = new HoaDon(ma, ngayLap, tongTien, nhanVien, khachHang);
				list.add(hd);
			}
		} catch (Exception e) {}
		return list;
	}

	public List<ChiTietHoaDon> getChiTiets(String ma){
		List<ChiTietHoaDon> list = new ArrayList<>();
		try {
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql="SELECT MaHoaDon, MaCaPhe, DonViTinh, DonGia, GiamGia, SoLuong FROM CT_HoaDon WHERE MaHoaDon LIKE '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString(1);
				int caPhe = rs.getInt(2);
				String dvt = rs.getString(3);
				float donGia = rs.getFloat(4);
				float giamGia = rs.getFloat(5);
				int soLuong = rs.getInt(6);

				ChiTietHoaDon ct = new ChiTietHoaDon(maHD, caPhe, donGia, giamGia, soLuong, dvt);
				list.add(ct);
			}
		} catch (Exception e) {}
		return list;
	}

	public String getTenKH(int ma){
		String ten = "";
		try {
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT Ten FROM KhachHang WHERE MaKhachHang = " + ma;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				ten = rs.getString(1);
			}
		} catch (Exception e) {}
		return ten;
	}

	public HoaDon getHoaDonByMa(String ma) {
		HoaDon hd = new HoaDon();
		try {
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql="SELECT NgayLap, TongTien, MaNhanVien, MaKhachHang FROM HoaDon WHERE MaHoaDon LIKE '"+ma+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				Date ngayLap = rs.getDate(1);
				double tongTien = rs.getDouble(2);
				int nhanVien = rs.getInt(3);
				int khachHang = rs.getInt(4);
				hd = new HoaDon(ma, ngayLap, tongTien, nhanVien, khachHang);
			}
		} catch (Exception e) {}
		return hd;
	}

	public List<HoaDon> getHoaDonsByNhanVien(String ten) {
		List<HoaDon> list = new ArrayList<>();
		try {
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT MaHoaDon, NgayLap, TongTien, nv.MaNhanVien, MaKhachHang " +
						 "FROM HoaDon hd JOIN NhanVien nv ON hd.MaNhanVien = nv.MaNhanVien " +
						 "WHERE nv.Ten LIKE N'" + ten + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				double tongTien = rs.getDouble(3);
				int nhanVien = rs.getInt(4);
				int khachHang = rs.getInt(5);
				list.add(new HoaDon(ma, ngayLap, tongTien, nhanVien, khachHang));
			}
		} catch (Exception e) {}
		return list;
	}

	public List<HoaDon> getHoaDonsByNgayLap(int ngay, int thang, int nam) {
		List<HoaDon> list = new ArrayList<>();
		try {
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT MaHoaDon, NgayLap, TongTien, MaNhanVien, MaKhachHang FROM HoaDon " +
						 "WHERE DAY(NgayLap) = "+ngay+" AND MONTH(NgayLap) = "+thang+" AND YEAR(NgayLap) = "+nam;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				double tongTien = rs.getDouble(3);
				int nhanVien = rs.getInt(4);
				int khachHang = rs.getInt(5);
				list.add(new HoaDon(ma, ngayLap, tongTien, nhanVien, khachHang));
			}
		} catch (Exception e) {}
		return list;
	}

	public List<HoaDon> getHoaDonsByKhachHang(String ten) {
		List<HoaDon> list = new ArrayList<>();
		try {
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT MaHoaDon, NgayLap, TongTien, MaNhanVien, kh.MaKhachHang " +
						 "FROM HoaDon hd JOIN KhachHang kh ON hd.MaKhachHang = kh.MaKhachHang " +
						 "WHERE kh.Ten LIKE N'" + ten + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				double tongTien = rs.getDouble(3);
				int nhanVien = rs.getInt(4);
				int khachHang = rs.getInt(5);
				list.add(new HoaDon(ma, ngayLap, tongTien, nhanVien, khachHang));
			}
		} catch (Exception e) {}
		return list;
	}

	public String getTenNV(int ma){
		String ten = "";
		try {
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT Ten FROM NhanVien WHERE MaNhanVien = " + ma;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				ten = rs.getString(1);
			}
		} catch (Exception e) {}
		return ten;
	}

	public String getTenCaPhe(int ma){
		String ten = "";
		try {
			Connection con = ConectDatabase.getInstance().getConnection();
			String sql = "SELECT TenCaPhe FROM CaPhe WHERE MaCaPhe = " + ma;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				ten = rs.getString(1);
			}
		} catch (Exception e) {}
		return ten;
	}
}
