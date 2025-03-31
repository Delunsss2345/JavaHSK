package main;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

import database.*;
import gui.FrmDangNhap;

import gui.FrmLapHoaDon;


public class Main {
	public static void main(String[] args) {
		try {
			ConectDatabase.getInstance().connect();
			FrmDangNhap frmDangNhap = new FrmDangNhap();
			
			frmDangNhap.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
