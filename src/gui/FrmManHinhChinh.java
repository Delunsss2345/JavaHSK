/* Người làm: Huỳnh Hoàng Phúc*/
package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

public class FrmManHinhChinh extends JFrame implements ActionListener,MenuListener {

	private JPanel contentPane;
	private FrmLapHoaDon frmLapHoaDon;
	private FrmQuanLyHoaDon frmQuanLyHoaDon = new FrmQuanLyHoaDon();
	private FrmBaoCaoThongKe frmBaoCaoThongKe = new FrmBaoCaoThongKe();
	private FrmQuanLyNhanVien frmQuanLyNhanVien = new FrmQuanLyNhanVien();
	private FrmKhachHang frmKhachHang = new FrmKhachHang();
	private FrmXemThongTinCaNhan frmXemThongTinCaNhan = new FrmXemThongTinCaNhan();
	private FrmThuoc frmThuoc = new FrmThuoc();
	private JMenuItem mntmThemHoaDonMoi;
	private JMenuItem mntmHuyHoaDon;
	public static JTabbedPane tabbedPane;
	private JMenuBar menuBar;
	private JMenu mnAbout;
	private JMenu mnHelp;
	private JMenu mnExit;
	private JMenu mnXemHoaDon;
	private JMenuItem mntmXemThongTinThuoc;
	public static JMenuItem mntmQuanLyThuoc;
	private JMenuItem mntmThongKeHoaDon;
	private JMenuItem mntmThongKeTinhTrangThuoc;
	private JMenuItem mntmThongKeDoanhThu;
	private JMenuItem mntmThongTinKhachHang;
	private JMenuItem mntmDangXuat;
	public static JMenu mnNhanVien ;
	public static JMenu mnThongKe;
	public static JMenuBar menuBar_LapHoaDon;
	public static JMenu mnLapHoaDon;
	
	public FrmManHinhChinh() {
		setTitle("Quản lý Quầy Thuốc Hạnh Phúc");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1361, 720);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
			
		mnExit = new JMenu("Exit");
		mnExit.setIcon(new ImageIcon("Hinh\\exit.png"));
		mnExit.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				Object chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?");
				if(chon.equals(0)) {
					System.exit(0);
				}
			}
		});
		
		menuBar.add(mnExit);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
		toolBar.setBackground(Color.WHITE);
		toolBar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		toolBar.setFloatable(false);
		toolBar.setEnabled(false);
		contentPane.add(toolBar, BorderLayout.WEST);
		UIManager.put("Menu.opaque", true);
		UIManager.put("Menu.selectionBackground", Color.decode("#4ddbff"));
		UIManager.put("Menu.selectionForeground", Color.WHITE);
		menuBar_LapHoaDon = new JMenuBar();
		toolBar.add(menuBar_LapHoaDon);
		
		mnLapHoaDon = new JMenu("Lập Hóa Đơn");
		mnLapHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnLapHoaDon.setPreferredSize(new Dimension(220, 50));
		mnLapHoaDon.setMnemonic(KeyEvent.VK_ENTER);

		menuBar_LapHoaDon.add(mnLapHoaDon);
		
		mntmThemHoaDonMoi = new JMenuItem("Thêm mới hóa đơn");
		mntmThemHoaDonMoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mntmThemHoaDonMoi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,ActionEvent.ALT_MASK));
		
		mnLapHoaDon.add(mntmThemHoaDonMoi);
		
		mntmHuyHoaDon = new JMenuItem("Hủy hóa đơn        Esc");
		mntmHuyHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mntmHuyHoaDon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK));
		mntmHuyHoaDon.setAccelerator(KeyStroke.getKeyStroke((char)KeyEvent.VK_ESCAPE));
		mnLapHoaDon.add(mntmHuyHoaDon);
		
		
		JMenuBar menuBar_2 = new JMenuBar();
		toolBar.add(menuBar_2);
		
		mnXemHoaDon = new JMenu("Xem Hóa Đơn      ");
		mnXemHoaDon.setPreferredSize(new Dimension(220, 50));
		mnXemHoaDon.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmQuanLyHoaDon.contentPane);
				tabbedPane.setSelectedComponent(frmQuanLyHoaDon.contentPane);
			}
		});
		mnXemHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnXemHoaDon.setMnemonic(KeyEvent.VK_F2);
		menuBar_2.add(mnXemHoaDon);
		
		JMenuBar menuThuoc = new JMenuBar();
		menuThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		toolBar.add(menuThuoc);
		
		JMenu mnThuoc = new JMenu("Thuốc      ");
		mnThuoc.setPreferredSize(new Dimension(220, 50));
		mnThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuThuoc.add(mnThuoc);
		/**/
		
		mnThuoc.setEnabled(true);
		mnThuoc.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmThuoc.contentPane);
			}
		});
		mnThuoc.setMnemonic(KeyEvent.VK_F3);
		menuThuoc.add(mnThuoc);
		/**/
		
		JMenuBar menuThongKe = new JMenuBar();
		toolBar.add(menuThongKe);
		
		mnThongKe = new JMenu("Thống Kê       ");
		mnThongKe.setPreferredSize(new Dimension(220, 50));
		mnThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuThongKe.add(mnThongKe);
		
		mntmThongKeHoaDon = new JMenuItem("Thống kê hóa đơn lập theo nhân viên");
		mntmThongKeHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		mntmThongKeHoaDon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,ActionEvent.ALT_MASK));
		mnThongKe.add(mntmThongKeHoaDon);
		
		mntmThongKeTinhTrangThuoc = new JMenuItem("Thống kê tình trạng thuốc");
		mntmThongKeTinhTrangThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		mntmThongKeTinhTrangThuoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,ActionEvent.ALT_MASK));
		mnThongKe.add(mntmThongKeTinhTrangThuoc);
		
		mntmThongKeDoanhThu = new JMenuItem("Thống kê doanh thu");
		mntmThongKeDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		mntmThongKeDoanhThu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7,ActionEvent.ALT_MASK));
		mnThongKe.add(mntmThongKeDoanhThu);
		
		JMenuBar menuKhachHang = new JMenuBar();
		toolBar.add(menuKhachHang);
		JMenuBar menuNhanVien = new JMenuBar();
		toolBar.add(menuNhanVien);
		
		mnNhanVien = new JMenu("Nhân Viên    ");
		mnNhanVien.setPreferredSize(new Dimension(220, 50));
		mnNhanVien.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmQuanLyNhanVien.pnlTabQLNV);
			}
		});
		mnNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnNhanVien.setMnemonic(KeyEvent.VK_F8);
		menuNhanVien.add(mnNhanVien);
		JMenu mnKhachHang = new JMenu("Khách Hàng");
		mnKhachHang.setPreferredSize(new Dimension(220, 50));
		mnKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnKhachHang.setEnabled(true);
		mnKhachHang.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmKhachHang.contentPane);
			}
		});
		mnKhachHang.setMnemonic(KeyEvent.VK_F9);
		menuKhachHang.add(mnKhachHang);
		
		JMenuBar menuThongTinCaNhan = new JMenuBar();
		toolBar.add(menuThongTinCaNhan);
		
		JMenu mnThongTinCaNhan = new JMenu("Thông Tin Cá Nhân");
		mnThongTinCaNhan.setPreferredSize(new Dimension(220, 50));
		mnThongTinCaNhan.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				tabbedPane.remove(tabbedPane.getSelectedComponent());
				tabbedPane.add(frmXemThongTinCaNhan.pnlTabXemThongTinCaNhan);
			}
		});
		mnThongTinCaNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuThongTinCaNhan.add(mnThongTinCaNhan);
		
		mnThongTinCaNhan.setMnemonic(KeyEvent.VK_F10);
		JMenuBar menuDangNhap = new JMenuBar();
		toolBar.add(menuDangNhap);
		
		JMenu mnDangNhap_DangXuat = new JMenu("Đăng xuất");
		mnDangNhap_DangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnDangNhap_DangXuat.setPreferredSize(new Dimension(220, 50));
		menuDangNhap.add(mnDangNhap_DangXuat);
		
		mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		mnDangNhap_DangXuat.setMnemonic(KeyEvent.VK_F11);
		mnDangNhap_DangXuat.add(mntmDangXuat);
		
		tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		mntmThemHoaDonMoi.addActionListener(this);
		mntmHuyHoaDon.addActionListener(this);
		mnXemHoaDon.addActionListener(this);
		mnXemHoaDon.addMenuListener(this);
		mntmThongKeHoaDon.addActionListener(this);
		mntmThongKeTinhTrangThuoc.addActionListener(this);
		mntmThongKeDoanhThu.addActionListener(this);
		
		mntmDangXuat.addActionListener(this);
		//contentPane.add(frmLapHoaDon.jp1, BorderLayout.CENTER);
	}

	private Color setIconImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(mntmThemHoaDonMoi)) {
			try {
				FrmLapHoaDon.cboTimKiemThuoc.removeAllItems();
				
			} catch (Exception e2) {
				// TODO: handle exception
				
			}
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			frmLapHoaDon = new FrmLapHoaDon();
			tabbedPane.add(frmLapHoaDon.jp1);
			
		}
		else if(obj.equals(mntmHuyHoaDon)) {
			tabbedPane.remove(frmLapHoaDon.jp1);
		}
		else if(obj.equals(mntmXemThongTinThuoc)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			FrmThuoc frmThuoc = new FrmThuoc();
			frmThuoc.pnlChucNang.remove(frmThuoc.btnThem);
			frmThuoc.pnlChucNang.remove(frmThuoc.btnLuu);
			frmThuoc.pnlChucNang.remove(frmThuoc.btnXoa);
			frmThuoc.pnlChucNang.remove(frmThuoc.btnSua);
			tabbedPane.add(frmThuoc.contentPane);
			
		}
		else if(obj.equals(mntmQuanLyThuoc)) {
			
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			FrmThuoc frmThuoc = new FrmThuoc();
			tabbedPane.add(frmThuoc.contentPane);
		}
		else if(obj.equals(mntmThongKeHoaDon)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(frmBaoCaoThongKe.pnlToanPhan);
		}
		else if(obj.equals(mntmThongKeTinhTrangThuoc)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(frmBaoCaoThongKe.pnlThongkeTTThuoc);
		}
		else if(obj.equals(mntmThongKeDoanhThu)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(frmBaoCaoThongKe.pnlThongKeBaoCao);
		}
		else if(obj.equals(mntmThongTinKhachHang)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(frmKhachHang.contentPane);
		}
		else if(obj.equals(mntmDangXuat)) {
			this.setVisible(false);
			FrmDangNhap.TrangThaiDangNhapNhanVien = false;
			FrmDangNhap.TrangThaiDangNhapQuanLy = false;
			FrmDangNhap frmDangNhap = new FrmDangNhap();
			frmDangNhap.setVisible(true);
			
			
		}
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}
