/*
 * Người làm: Nguyễn Tuấn Phát
 * 			 
 *
 * Chức năng: tạo hóa đơn bán món cho chương trình
 * */
package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.multisplitpane.DefaultSplitPaneModel;

import database.*;
import entities.ChiTietHoaDon;
import entities.KhachHang;
import entities.Mon;

import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

import Dao.LapHoaDonDAO;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import javax.swing.JMenuItem;

public class FrmLapHoaDon extends JFrame implements ActionListener,MouseListener,TableModelListener,KeyListener{

	JTabbedPane tabbedPane;
	public static JPanel jp1,pnTab2,pnTab3,pnTab4;
	JLabel lblThongTinKhachHang,lblDiaChi,lblMaHD,lblTenKH,lblSDT,lblNN,lblMakh,lblLHD ;
	JTextField txtHD;
	JButton btnTim,btnThem;

	public static DefaultTableModel tablemodel;
	public static JTextField txtNgay;
	private JLabel lblNhanVien;
	public static JTextField txtNhanVien;
	public static JRadioButton radKeDon;
	public static JRadioButton radKhongKeDon;
	public static JTextField txtHoKh;
	public static JTextField txtTenkh;
	public static JTextField txtCCCD;
	private JLabel lblDC;
	public static JTextField txtDChi;
	private JLabel lblSdt;
	public static JTextField txtSdt;
	private JTable table;
	private JLabel lblTongTienMon;
	public static JTextField txtTongTienMon;
	private JLabel lblGiamGia;
	private JLabel lblTongThanhToan;
	private JTextField txtThue;
	public static JTextField txtTongThanhToan;
	private JLabel lblMHd;
	private JPanel jp2;
	private JComboBox cboDVT;
	private JComboBox<Integer> cboSoLuong;
	private JComboBox cboGiamGia;
	public static JComboBox cboTimKiemMon ;
	private JButton btnThemMonTim;
	private JButton btnInHd;
	private JButton btnXoa;
	public static DefaultComboBoxModel cboModeTimKiemMon= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModelTableMon = new DefaultComboBoxModel();
	private JSpinner spinner = new JSpinner(new SpinnerNumberModel(new Integer(1),new Integer(1),null,new Integer(1)));
	public static int i =0;
	private JTextField txtTienNhan;
	private JTextField txtTienThoiLai;
	private JButton btnMayTinh;
	private static JComboBox cboGiamGia1;
	public static JTextField txtSoLuong;
	public static JLabel lblThongBao;
	private static float tongThanhToan=0;
	public static String setLoaiMon = "";
	private JButton btnThemHoaDon;
	private JMenuItem mntmSoLuong;
	private JMenuItem mntmXoa;
	public static JComboBox cboGioiTinh ;
	public static JDateChooser txtNgaySinh ;
	private JButton btnThemDiaChi;
	private	FrmXuatHD frmXuatHD = new FrmXuatHD();
	private FrmThemDiaChiKhachHang frmThemDiaChiKhachHang = new FrmThemDiaChiKhachHang();
	private FrmChonMon frmChonMon = new FrmChonMon();
	private static LapHoaDonDAO lapHoaDonDAO = new LapHoaDonDAO();
	
	public FrmLapHoaDon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Hinh\\D01014613-p1.jpg"));

		setTitle("QUẢN LÍ QUÁN CAFE");
		setSize(700, 733);

		setLocationRelativeTo(null);
		setResizable(true);
		tabbedPane=new JTabbedPane();
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));

		jp1=new JPanel();
		jp1.setBackground(new Color(176, 224, 230));
		pnTab2=new JPanel();


		ImageIcon icon=new ImageIcon("leaves-icon.png");
		tabbedPane.addTab("Lập hóa đơn",(Icon) null,jp1);



		jp1.add(lblLHD = new JLabel("LẬP HÓA ĐƠN CAFE"));
		lblLHD.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLHD.setForeground(Color.RED);


		jp1.add(lblMaHD = new JLabel("Mã HD:"));
		lblMaHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMaHD.setForeground(new Color(0, 0, 0));
		jp1.add(lblMakh=new JLabel("Nhập mã khách hàng:"));



		jp1.add(txtHD = new JTextField());
		txtHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));


		lblLHD.setBounds(480, 11, 247, 38);
		lblMaHD.setBounds(10,55 , 74, 20);


		txtHD.setBounds(105,55, 150, 20);
		txtHD.setEditable(false);






		JLabel lblNgay = new JLabel("Ngày:");
		lblNgay.setForeground(new Color(0, 0, 0));
		lblNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgay.setBounds(270, 55, 74, 20);
		jp1.add(lblNgay);

		txtNgay = new JTextField();
		txtNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtNgay.setEditable(false);
		txtNgay.setBounds(343, 54, 150, 20);
		jp1.add(txtNgay);

		lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setForeground(new Color(0, 0, 0));
		lblNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNhanVien.setBounds(510, 55, 147, 20);
		jp1.add(lblNhanVien);

		txtNhanVien = new JTextField();
		txtNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtNhanVien.setEditable(false);
		txtNhanVien.setBounds(608, 54, 150, 20);
		jp1.add(txtNhanVien);

		radKeDon = new JRadioButton("Kê Đơn");
		radKeDon.setEnabled(false);
		radKeDon.setForeground(new Color(0, 0, 0));
		radKeDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radKeDon.setBounds(770, 54, 85, 23);
		jp1.add(radKeDon);

		radKhongKeDon = new JRadioButton("Không Kê Đơn");
		radKhongKeDon.setEnabled(false);
		radKhongKeDon.setForeground(new Color(0, 0, 0));
		radKhongKeDon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radKhongKeDon.setBounds(870, 54, 161, 23);
		jp1.add(radKhongKeDon);


		JLabel lblTnKh = new JLabel("Họ KH:");
		lblTnKh.setForeground(new Color(0, 0, 0));
		lblTnKh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTnKh.setBounds(270, 86, 79, 20);
		jp1.add(lblTnKh);

		txtHoKh = new JTextField();
		txtHoKh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtHoKh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txtSdt.getText().equalsIgnoreCase("")) {
					txtSdt.requestFocus();
					lblThongBao.setText("Nhập số điện thoại khách hàng!");
				}
				else {
					lblThongBao.setText("");
				}

			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtHoKh.setBounds(343, 86, 150, 20);
		jp1.add(txtHoKh);

		JLabel lblTenkh = new JLabel("Tên KH:");
		lblTenkh.setForeground(new Color(0, 0, 0));
		lblTenkh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenkh.setBounds(510, 86, 147, 20);
		jp1.add(lblTenkh);

		txtTenkh = new JTextField();
		txtTenkh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtTenkh.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtTenkh.setBounds(608, 86, 150, 20);
		jp1.add(txtTenkh);

		JLabel lblCCCD = new JLabel("Số CCCD:");
		lblCCCD.setForeground(new Color(0, 0, 0));
		lblCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCCCD.setBounds(770, 159, 105, 20);
		jp1.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtCCCD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtCCCD.setBounds(862, 159, 150, 20);
		jp1.add(txtCCCD);

		lblDC = new JLabel("Địa Chỉ:");
		lblDC.setForeground(new Color(0, 0, 0));
		lblDC.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDC.setBounds(10, 120, 85, 20);
		jp1.add(lblDC);

		txtDChi = new JTextField();
		txtDChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDChi.setEditable(false);
		txtDChi.setBounds(105, 119, 600, 20);

		jp1.add(txtDChi);
		
	/////
			btnThemDiaChi = new JButton("Thêm");
			btnThemDiaChi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmThemDiaChiKhachHang.setVisible(true);
					frmThemDiaChiKhachHang.setLocationRelativeTo(null);
				}
			});
			btnThemDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
//			btnThemDiaChi.setBackground(new Color(32, 178, 170));
			btnThemDiaChi.setBounds(720, 119, 36, 20);

		lblSdt = new JLabel("SDT:");
		lblSdt.setForeground(new Color(0, 0, 0));
		lblSdt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSdt.setBounds(10, 86, 62, 20);
		jp1.add(lblSdt);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					//System.out.println(e.isConsumed());
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						if(txtSdt.getText().length() >= 9 ) {
							timKhachHangBySDT(txtSdt.getText());
						}
						else
							JOptionPane.showMessageDialog(null,"Số điện thoại phải có ít nhất 9 số!");
					}
				}
				if(lapHoaDonDAO.timKhachHangBySDT(txtSdt.getText()).isEmpty()) {
					txtHoKh.setText("");
					txtTenkh.setText("");
					txtDChi.setText("");
					txtCCCD.setText("");
				}
				timKhachHangBySDT(txtSdt.getText());
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtSdt.setBounds(105, 86, 150, 20);
		jp1.add(txtSdt);


		javax.swing.border.Border southborder=BorderFactory.createLineBorder(Color.black,Font.BOLD);
		TitledBorder southTitleBorder=new TitledBorder(southborder,"Thông tin chung");
		southTitleBorder.setTitleColor(Color.black);


		JScrollPane scroll = new  JScrollPane();
		String[] tb = new String[] {"STT","Mã","Tên Món","Loại Món","Đơn Vị Tính","Hàm Lượng","Đơn Giá(VNĐ)","Số Lượng","Giảm Giá(%)","Thành Tiền(VNĐ)"};

		tablemodel = new DefaultTableModel(tb, 0) ;


		table = new JTable(tablemodel);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		scroll.setViewportView(table);
		//getContentPane().add(scroll);
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		mntmSoLuong = new JMenuItem("Sửa số lượng");
		popupMenu.add(mntmSoLuong);

		mntmXoa = new JMenuItem("Xóa");
		popupMenu.add(mntmXoa);

		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(7).setPreferredWidth(10);
		table.getColumnModel().getColumn(8).setPreferredWidth(10);
		tablemodel.addTableModelListener(this);






		// disable edit trong table
		table.setDefaultEditor(Object.class, null);

		txtSoLuong = new JTextField();
		txtSoLuong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtSoLuong.setEditable(false);
		DefaultCellEditor colSoLuong = new DefaultCellEditor(txtSoLuong);
		//		table.getColumnModel().getColumn(6).setCellEditor(col6);
		table.getColumnModel().getColumn(7).setCellEditor(colSoLuong);



		cboGiamGia = new JComboBox();
		cboGiamGia.addItem("0");
		cboGiamGia.addItem("5");
		cboGiamGia.addItem("10");
		cboGiamGia.addItem("15");
		cboGiamGia.addItem("20");
		cboGiamGia.addItem("25");
		cboGiamGia.addItem("30");
		cboGiamGia.addItem("35");
		cboGiamGia.addItem("40");
		cboGiamGia.addItem("45");
		cboGiamGia.addItem("50");
		cboGiamGia.addItem("55");
		cboGiamGia.addItem("60");
		cboGiamGia.addItem("65");
		cboGiamGia.addItem("70");
		cboGiamGia.addItem("75");
		cboGiamGia.addItem("80");
		cboGiamGia.addItem("85");
		cboGiamGia.addItem("90");
		cboGiamGia.addItem("95");
		cboGiamGia.addItem("100");
		DefaultCellEditor col7 = new DefaultCellEditor(cboGiamGia);
		table.getColumnModel().getColumn(8).setCellEditor(col7);

		javax.swing.border.Border southborder2=BorderFactory.createLineBorder(Color.black);
		TitledBorder southTitleBorder2=new TitledBorder(southborder2,"Thông tin hóa đơn");
		southTitleBorder2.setTitleColor(Color.black);
		scroll.setBorder(southTitleBorder2);

		jp1.add(scroll);
		scroll.setPreferredSize(new Dimension(0,250));
		jp1.setLayout(null);

		scroll.setBounds(10, 370, 1140, 248);
		getContentPane().add(tabbedPane);

		btnThemMonTim = new JButton("Thêm");
		btnThemMonTim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThemMonTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnThemMonTim.setIcon(new ImageIcon("Hinh\\search.png"));
		btnThemMonTim.setBounds(507, 158, 120, 23);
		jp1.add(btnThemMonTim);

		btnXoa = new JButton("Xóa ");
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		btnXoa.setBackground(new Color(90, 140, 242));
		btnXoa.setIcon(new ImageIcon("Hinh\\iconDeleteRow.png"));
		btnXoa.setBounds(637, 158, 120, 23);
		jp1.add(btnXoa);

		
		cboTimKiemMon = new JComboBox();
		cboTimKiemMon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboTimKiemMon.setEditable(true);
		cboTimKiemMon.setBounds(105, 158, 390, 23);
		jp1.add(cboTimKiemMon);

		lblMHd = new JLabel("Tên Món:");
		lblMHd.setForeground(new Color(0, 0, 0));
		lblMHd.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMHd.setBounds(10, 159, 113, 20);
		jp1.add(lblMHd);

		jp2 = new JPanel();
		jp2.setForeground(Color.black);
		jp2.setBounds(10, 202, 1140, 166);
		jp1.add(jp2);

		javax.swing.border.Border southborder3=BorderFactory.createLineBorder(Color.black);
		TitledBorder southTitleBorder3=new TitledBorder(southborder3,"Thanh toan");
		southTitleBorder3.setTitleColor(Color.black);
		jp2.setBorder(southTitleBorder3);
		jp1.add(jp2);
		jp2.setLayout(null);

		btnThemHoaDon = new JButton("Mới");
//		btnThemHoaDon.setBackground(new Color(32, 178, 170));
		btnThemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnThemHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnThemHoaDon.setIcon(new ImageIcon("Hinh\\hoadon.png"));
		btnThemHoaDon.setBounds(820, 109, 129, 46);
		jp2.add(btnThemHoaDon);



		lblTongThanhToan = new JLabel("Tổng tiền thanh toán (VNĐ):");
		lblTongThanhToan.setBounds(20, 135, 215, 20);
		jp2.add(lblTongThanhToan);
		lblTongThanhToan.setForeground(Color.BLACK);
		lblTongThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtThue = new JTextField();
		txtThue.setHorizontalAlignment(SwingConstants.RIGHT);
		txtThue.setBounds(245, 72, 355, 20);
		jp2.add(txtThue);
		txtThue.setText("5%");
		txtThue.setEditable(false);
		txtThue.setColumns(10);

		txtTongThanhToan = new JTextField();
		txtTongThanhToan.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTongThanhToan.setBounds(245, 134, 355, 20);
		jp2.add(txtTongThanhToan);
		txtTongThanhToan.setEditable(false);
		txtTongThanhToan.setColumns(10);

		JLabel lblThue = new JLabel("Thuế GTGT (%):");
		lblThue.setBounds(20, 73, 181, 25);
		jp2.add(lblThue);
		lblThue.setForeground(Color.BLACK);
		lblThue.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblTienNhan = new JLabel("Tiền nhận (VNĐ) :");
		lblTienNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTienNhan.setBounds(687, 41, 120, 20);
		jp2.add(lblTienNhan);

		JLabel lblTienThoiLai = new JLabel("Tiền thừa (VNĐ):");
		lblTienThoiLai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTienThoiLai.setBounds(687, 73, 120, 20);
		jp2.add(lblTienThoiLai);

		txtTienNhan = new JTextField();
		//	txtTienNhan.setText("0");
		DecimalFormat tien = new DecimalFormat("#,##0.00");

		// tien khach dua nhap vao

		txtTienNhan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//
				try {
					if(txtTienNhan.getText()=="") {
						double tienNhan = Double.parseDouble("0");
						txtTienNhan.setText("0");
						double tienThoiLai = tienNhan - tongThanhToan;
						txtTienThoiLai.setText(tien.format(tienThoiLai)+" VNĐ");
					}
					else {
						double tienNhan = Double.parseDouble(txtTienNhan.getText());
						double tienThoiLai = tienNhan - tongThanhToan;
						txtTienThoiLai.setText(tien.format(tienThoiLai)+" VNĐ");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}


			}
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(txtTienNhan.getText()=="") {
						double tienNhan = Double.parseDouble("0");
						txtTienNhan.setText("0");
						double tienThoiLai = tienNhan - tongThanhToan;
						txtTienThoiLai.setText(tien.format(tienThoiLai)+" VNĐ");
					}
					else {
						double tienNhan = Double.parseDouble(txtTienNhan.getText());
						double tienThoiLai = tienNhan - tongThanhToan;
						txtTienThoiLai.setText(tien.format(tienThoiLai)+" VNĐ");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(!((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8)) {
					e.consume();
				}
			}
		});
		txtTienNhan.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTienNhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTienNhan.setBounds(820, 39, 270, 28);
		jp2.add(txtTienNhan);
		txtTienNhan.setColumns(20);

		txtTienThoiLai = new JTextField();
		txtTienThoiLai.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTienThoiLai.setEditable(false);
		txtTienThoiLai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTienThoiLai.setColumns(10);
		txtTienThoiLai.setBounds(820, 73, 270, 28);
		jp2.add(txtTienThoiLai);
		lblTongTienMon = new JLabel("Tổng tiền Món (VNĐ):");
		lblTongTienMon.setForeground(Color.BLACK);
		lblTongTienMon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongTienMon.setBounds(20, 34, 355, 20);
		jp2.add(lblTongTienMon);

		txtTongTienMon = new JTextField();
		txtTongTienMon.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTongTienMon.setBounds(245, 34, 355, 20);
		jp2.add(txtTongTienMon);
		txtTongTienMon.setEditable(false);
		txtTongTienMon.setColumns(10);


		btnInHd = new JButton("In HD");
		btnInHd.setHorizontalAlignment(SwingConstants.LEFT);
		btnInHd.setBounds(960, 109, 129, 46);
		jp2.add(btnInHd);
		btnInHd.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnInHd.setBackground(new Color(32, 178, 170));
		btnInHd.setIcon(new ImageIcon("Hinh\\iconPrinter.png"));

		lblGiamGia = new JLabel("Giảm Giá (%):");
		lblGiamGia.setBounds(20, 104, 181, 25);
		jp2.add(lblGiamGia);
		lblGiamGia.setForeground(Color.BLACK);
		lblGiamGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		cboGiamGia1 = new JComboBox();

		cboGiamGia1.setEditable(true);
		cboGiamGia1.setBounds(245, 103, 355, 20);
		cboGiamGia1.addItem("0");
		cboGiamGia1.addItem("5");
		cboGiamGia1.addItem("10");
		cboGiamGia1.addItem("15");
		cboGiamGia1.addItem("20");
		cboGiamGia1.addItem("25");
		cboGiamGia1.addItem("30");
		cboGiamGia1.addItem("35");
		cboGiamGia1.addItem("40");
		cboGiamGia1.addItem("45");
		cboGiamGia1.addItem("50");
		cboGiamGia1.addItem("55");
		cboGiamGia1.addItem("60");
		cboGiamGia1.addItem("65");
		cboGiamGia1.addItem("70");
		cboGiamGia1.addItem("75");
		cboGiamGia1.addItem("80");
		cboGiamGia1.addItem("85");
		cboGiamGia1.addItem("90");
		cboGiamGia1.addItem("95");
		cboGiamGia1.addItem("100");

		cboGiamGia1.setEditable(false);
		jp2.add(cboGiamGia1);
		btnInHd.addActionListener(this);

		getContentPane().add(tabbedPane);
		cboTimKiemMon.addActionListener(this);
		btnThemMonTim.addActionListener(this);
		btnXoa.addActionListener(this);
		table.addMouseListener(this);
		cboGiamGia1.addActionListener(this);
		btnThemHoaDon.addActionListener(this);
		AutoCompleteDecorator.decorate(cboTimKiemMon);
		lblThongBao = new JLabel("");
		lblThongBao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setBackground(Color.RED);
		lblThongBao.setBounds(10, 143, 436, 20);

		jp1.add(lblThongBao);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy , hh:mm");
		txtNgay.setText(LocalDateTime.now().format(formatter));

		txtNhanVien.setText(lapHoaDonDAO.tenNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
		
		
		

		

		/*
		 * 
		 * ngay
		 * 
		 * 
		 * */
		


		

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setBounds(510, 620, 129, 40);
		jp1.add(btnThoat);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmManHinhChinh.tabbedPane.remove(jp1);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnThoat.setBackground(new Color(32, 178, 170));
		btnThoat.setIcon(new ImageIcon("Hinh\\iconDelete.png"));
		jp1.add(btnThemDiaChi);
		txtSdt.addKeyListener(this);
		cboGiamGia1.addKeyListener(this);
		mntmSoLuong.addActionListener(this);
		mntmXoa.addActionListener(this);
		cboTimKiemMon.removeAllItems();
		updateComboxTenMon();
		//System.out.println(maMonTheoTenVaDonViTinh("PARACETAMOL 500 mg", "Vỉ"));
	}
	//
	//
	public void themHoaDonKeDon() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


		String soNha = frmThemDiaChiKhachHang.txtSoNha.getText();
		String tenDuong = frmThemDiaChiKhachHang.txtTenDuong.getText();
		String phuong = frmThemDiaChiKhachHang.txtPhuong.getText();
		String Quan =frmThemDiaChiKhachHang.txtQuan.getText();
		String thanhPho = frmThemDiaChiKhachHang.txtThanhPho.getText();
		String quocGia =frmThemDiaChiKhachHang.txtQuocGia.getText();
		String ten=txtTenkh.getText();
		String ho=txtHoKh.getText();
		String name = ho + " "+ten;
		String ngaySinhtxt = simpleDateFormat.format(txtNgaySinh.getDate());
		System.out.println(ngaySinhtxt);
		Date ngaySinhSQL = null;
		try {
			java.util.Date ngaySinh = simpleDateFormat.parse(ngaySinhtxt);
			ngaySinhSQL = new Date(ngaySinh.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String gioiTinh = cboGioiTinh.getSelectedItem().toString();
		String cmnd= txtCCCD.getText();
		String soDienThoai=txtSdt.getText();
		// ma nhan vien
		int maNhanVien = Integer.parseInt(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));

		// tim ma khach hang boi so dien thoai
		int maKhachHang = lapHoaDonDAO.maKhachHangBySDT(soDienThoai);
		//them dia chi cua khach hang moi dat
		lapHoaDonDAO.addDiaChi(soNha, tenDuong, phuong, Quan, thanhPho, quocGia);
		//them khach hang moi lap hoa don
		Connection con = ConectDatabase.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet n = null;
		try {
			stmt = con.prepareStatement("select CMND from KhachHang where CMND like ?");
			stmt.setString(1,cmnd);
			n = stmt.executeQuery();
			if(!n.next())
			{
				lapHoaDonDAO.addKhachHang(ten, ho, ngaySinhSQL, gioiTinh, cmnd, soDienThoai, lapHoaDonDAO.maDiaChiMax());
			}
		} catch (Exception e3) {
			// TODO: handle exception
		}	
		// get tong tien tu form 
		float tongTien = 0;
		tongTien = tongThanhToan;
		// them hoa don loai mon ke don
		lapHoaDonDAO.addHoaDonLoaiKeDon(maNhanVien, maKhachHang, tongTien);
		// them frm xuathd
		String loaiHoaDon="";
		if(radKeDon.isSelected()) {
			loaiHoaDon = "Món kê đơn";
		}
		else if(radKhongKeDon.isSelected()) {
			loaiHoaDon = "Không kê đơn";
		}

		setDuLieuFrmInHd(lapHoaDonDAO.maHoaDon(String.valueOf(maNhanVien)),loaiHoaDon , txtNgay.getText(), name, ngaySinhtxt,gioiTinh, soDienThoai,txtDChi.getText(),"", txtTongTienMon.getText(), txtTongThanhToan.getText(), txtNhanVien.getText(), ten);
		frmXuatHD.lblSL.setText(i +"");
	}


	public void timKhachHangBySDT(String sdt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			for(KhachHang khachHang : lapHoaDonDAO.timKhachHangBySDT(sdt)) {
				String ho = khachHang.getHo();
				String ten = khachHang.getTen();
				String gioiTinh = khachHang.getGioiTinh();
				String CMND = khachHang.getCmnd();
				String ngaySinh = khachHang.getNgaySinh().toString();
				String soNha = khachHang.getDiaChi().getSoNha();
				String tenDuong = khachHang.getDiaChi().getTenDuong();
				String phuong = khachHang.getDiaChi().getPhuong();
				String quan = khachHang.getDiaChi().getQuan();
				String thanhPho = khachHang.getDiaChi().getThanhPho();
				String quocGia = khachHang.getDiaChi().getQuocGia();

				frmThemDiaChiKhachHang.txtSoNha.setText(soNha);
				frmThemDiaChiKhachHang.txtTenDuong.setText(tenDuong);
				frmThemDiaChiKhachHang.txtPhuong.setText(phuong);
				frmThemDiaChiKhachHang.txtQuan.setText(quan);
				frmThemDiaChiKhachHang.txtQuocGia.setText(quocGia);
				txtHoKh.setText(ho);
				txtTenkh.setText(ten);
				cboGioiTinh.setSelectedItem(gioiTinh);
				txtCCCD.setText(CMND);
				txtDChi.setText(soNha+" " +tenDuong+","+phuong+","+quan+","+thanhPho+","+quocGia);
				Date date = Date.valueOf(ngaySinh);
				txtNgaySinh.setDate(date);

			}  
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*
	 * update cbo mon tim kiem
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	//
	String tenMonSoSanh="";
	public  void updateComboxTenMon() {
		cboTimKiemMon.removeAllItems();
		try {
			cboModeTimKiemMon.addElement(null);
			String tenMon ="";
			for(Mon mon : lapHoaDonDAO.updateComboxTenMon()) {
				if(mon.getTenMon().equalsIgnoreCase(tenMonSoSanh)==false) {
					tenMon = mon.getTenMon();
					cboModeTimKiemMon.addElement(tenMon);
					cboTimKiemMon.setModel(cboModeTimKiemMon);
				}
				tenMonSoSanh = tenMon;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	

	public boolean addHoaDon() {
		int maNhanVien = Integer.parseInt(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
		float tongTien = 0;
		tongTien = tongThanhToan;
		Connection con = ConectDatabase.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			stmt = con.prepareStatement("insert into dbo.HoaDon(MaNhanVien,TongTien) values\r\n" + 
					"(?,?)");
			stmt.setInt(1,maNhanVien);
			stmt.setFloat(2, tongThanhToan);
			n= stmt.executeUpdate();
		} catch (Exception e3) {
			// TODO: handle exception
		}
		return n>0;
	}

	
	public static void danhSachMonTheoMaMon(int maMon) {
		if(lapHoaDonDAO.soLuongMonDaBan(maMon) > lapHoaDonDAO.soLuongNhap(maMon)) {
			JOptionPane.showMessageDialog(jp1, "Món đã tạm hết món trong kho ! \n Vui lòng chọn loại món khác");
		}
		else {
			try {
				Mon mon = new Mon();
				mon = lapHoaDonDAO.MonTheoMa(maMon);
				if(mon != null) {
					int maMonInt = mon.getMaMon();
					String tenMons = mon.getTenMon();
					String loaiMon = mon.getPhanLoai();
					String donViTinhs = mon.getDonViTinh();
					String hamLuong = mon.getHamLuong();
					String donGia = mon.getDonGia() + "";
					double thanhTien = Integer.parseInt(txtSoLuong.getText()) * Double.parseDouble(donGia);
					if(loaiMon.equalsIgnoreCase("Món kê đơn")) {
						radKeDon.setSelected(true);
						radKhongKeDon.setSelected(false);
						setLoaiMon = "Món kê đơn";
						lblThongBao.setText("Món kê đơn vui lòng nhập thông tin khách hàng!");
						txtSdt.requestFocus();

					}
					else if(loaiMon.equalsIgnoreCase("Không kê đơn") && setLoaiMon.equalsIgnoreCase("Món kê đơn")==false) {
						radKhongKeDon.setSelected(true);
						radKeDon.setSelected(false);
						lblThongBao.setText("");
					}
					tablemodel.addRow(new Object[] {
							++i,maMonInt,tenMons,loaiMon,donViTinhs,hamLuong,donGia,txtSoLuong.getText(),0,thanhTien
					});
					updateTongTien();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	// update table chon mon

	public boolean updateTableChonMon(String tenMon) {
		try {
			frmChonMon.xoaDuLieuTableModel();
			frmChonMon.lblMonCoTen.setText("Món "+tenMon);
			if(lapHoaDonDAO.danhSachMonTimKiemTheoTen_TimKiemTuongDoi(tenMon).isEmpty() == false) {
				for(Mon mon: lapHoaDonDAO.danhSachMonTimKiemTheoTen_TimKiemTuongDoi(tenMon)) {
					frmChonMon.tableModel.addRow(new Object[] {
							mon.getMaMon(),mon.getNhomMon(),mon.getTenMon(),mon.getPhanLoai(),mon.getHamLuong(),mon.getDangBaoChe(),mon.getDonViTinh(),mon.getDonGia(),mon.getNhaCungcap().getTenNCC()
					});
					frmChonMon.table.setModel(frmChonMon.tableModel);
				}
				frmChonMon.table.setRowSelectionInterval(0, 0);
				return true;
			}
			else
				JOptionPane.showMessageDialog(null, "Không có dữ liệu!");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean kiemTraThongTinKhachHang() {
		if(txtSdt.getText().equalsIgnoreCase("")) {
			txtSdt.requestFocus();
			lblThongBao.setText("Vui lòng nhập số điện thoại!");
			return false;
		}
		else if(txtTenkh.getText().equalsIgnoreCase("")) {
			txtTenkh.requestFocus();
			lblThongBao.setText("Vui lòng nhập vào tên khách hàng!");
			return false;
		}
		else if(txtHoKh.getText().equalsIgnoreCase("")) {
			txtHoKh.requestFocus();
			lblThongBao.setText("Vui lòng nhập vào họ khách hàng!");
			return false;
		}
		else if(txtDChi.getText().equalsIgnoreCase("")) {
			txtDChi.requestFocus();
			lblThongBao.setText("Vui lòng nhập vào địa chỉ!");
			return false;
		}
		return true;
	}
	public boolean kiemTraMonKeDon() {
		List data = tablemodel.getDataVector();
		Object[] list1 = data.toArray();
		for(int k=0;k<list1.length;k++) {
			String loaiMon = tablemodel.getValueAt(k, 3).toString();
			if(loaiMon.equalsIgnoreCase("Món kê đơn")) {
				radKeDon.setSelected(true);
				radKhongKeDon.setSelected(false);
				lblThongBao.setText("Món kê đơn vui lòng nhập thông tin khách hàng!");
				return true;
			}
		}
		return false;
	}
	public boolean kiemTraTrungMon(String tenMon) {
		List data = tablemodel.getDataVector();
		Object[] list1 = data.toArray();
		for(int k=0;k<list1.length;k++) {
			String tenMonTable = tablemodel.getValueAt(k, 2).toString();

			if(tenMon.equalsIgnoreCase(tenMonTable)) {
				table.setRowSelectionInterval(k, k);
				return true;
			}
		}
		return false;
	}
	public boolean kiemTraNhapKhachHangMonKeDon() {
		if(radKeDon.isSelected()) {
			if(txtSdt.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Nhập số điện thoại của khách hàng.");
				txtSdt.requestFocus();
				return false;
			}
			else if(txtTenkh.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Nhập tên của khách hàng.");
				txtTenkh.requestFocus();
				return false;
			}
			else if(txtDChi.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this,"Nhập địa chỉ của khách hàng.");
				txtDChi.requestFocus();
				return false;
			}
		}
		else if(radKeDon.isSelected()==false) {
			return false;
		}
		return true;
	}
	public void xoaHetDuLieuTrenTableModel() {
		tablemodel.addRow(new Object[] {

		});
		tablemodel = (DefaultTableModel) table.getModel();
		tablemodel.getDataVector().removeAllElements();
	}
	public void xoaTrangTxt() {
		txtSdt.setText("");
		txtHoKh.setText("");
		txtTenkh.setText("");
		txtDChi.setText("");
		txtCCCD.setText("");
	}
	public void setDuLieuFrmInHd(String maHoaDon,String loaiHoaDon,String ngayLap,String hoTenKh,String namSinh,String gioiTinh,String soDT,String diaChi,String soLuong,String tongTienMon,String tongTienThanhToan,String tenNguoiBan,String tenKhachHang) {

		frmXuatHD.lblMaHD.setText(maHoaDon);
		frmXuatHD.lblLoaiHD1.setText(loaiHoaDon);
		frmXuatHD.lblNgayLap1.setText(ngayLap);
		frmXuatHD.lblTenKH1.setText(hoTenKh);
		frmXuatHD.lblGTinh1.setText(gioiTinh);
		frmXuatHD.lblDCKH1.setText(diaChi);
		frmXuatHD.lblNamSinh1.setText(namSinh);
		frmXuatHD.lblsdtkh1.setText(soDT);
		frmXuatHD.lblTongTMon.setText(tongTienMon);
		frmXuatHD.lblTongT.setText(tongTienThanhToan);
		frmXuatHD.lblNguoiBan.setText(tenNguoiBan);
		frmXuatHD.lblNguoiMuaHang1.setText(tenKhachHang);
	}
	public void themHoaDonVaChiTietHoaDonKeDon() {
		themHoaDonKeDon();
		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
		ArrayList<ChiTietHoaDon> listCT_HD = new ArrayList<ChiTietHoaDon>();
		List data = tablemodel.getDataVector();
		Object[] list1 = data.toArray();
		String maHoaDon =lapHoaDonDAO.maHoaDon(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
		int stt=0;
		for(int k=0;k<list1.length;k++) {

			try {
				chiTietHoaDon = new ChiTietHoaDon(maHoaDon,Integer.parseInt(tablemodel.getValueAt(k,1).toString()),Float.parseFloat(tablemodel.getValueAt(k, 6).toString()),Float.parseFloat(tablemodel.getValueAt(k, 8).toString()),Integer.parseInt(tablemodel.getValueAt(k, 7).toString()),tablemodel.getValueAt(k, 4).toString());
				listCT_HD.add(chiTietHoaDon);
				//

				frmXuatHD.tableModel.addRow(new Object[] {
						++stt,tablemodel.getValueAt(k, 2).toString(),tablemodel.getValueAt(k,4),tablemodel.getValueAt(k, 6),tablemodel.getValueAt(k, 7),tablemodel.getValueAt(k, 8),tablemodel.getValueAt(k, 9)
				});
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		for(ChiTietHoaDon hoaDon: listCT_HD) {
			lapHoaDonDAO.addCT_HoaDon(hoaDon.getMaHoaDon(), hoaDon.getMaMon(), hoaDon.getDonGia(), hoaDon.getGiamGia(), hoaDon.getSoLuong(), hoaDon.getDonViTinh());
		}
		btnInHd.setEnabled(false);
		//	frmXuatHD.setVisible(true);

		// set table chi tiet hoa don

		this.frmXuatHD.setVisible(true);
		frmXuatHD.setLocationRelativeTo(null);
		// ham in hoa don
		frmXuatHD.printingHoaDon();
	}
	public void themHoaDonVaChiTietHoaDonKhongKeDon() {
		addHoaDon();
		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
		ArrayList<ChiTietHoaDon> listCT_HD = new ArrayList<ChiTietHoaDon>();
		List data = tablemodel.getDataVector();
		Object[] list1 = data.toArray();
		String maHoaDon =lapHoaDonDAO.maHoaDon(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
		System.out.println(list1.length);
		int stt=0;
		for(int k=0;k<list1.length;k++) {

			try {
				chiTietHoaDon = new ChiTietHoaDon(maHoaDon,Integer.parseInt(tablemodel.getValueAt(k,1).toString()),Float.parseFloat(tablemodel.getValueAt(k, 6).toString()),Float.parseFloat(tablemodel.getValueAt(k, 8).toString()),Integer.parseInt(tablemodel.getValueAt(k, 7).toString()),tablemodel.getValueAt(k, 4).toString());
				listCT_HD.add(chiTietHoaDon);

				frmXuatHD.tableModel.addRow(new Object[] {
						++stt,tablemodel.getValueAt(k, 2).toString(),tablemodel.getValueAt(k,4),tablemodel.getValueAt(k, 6),tablemodel.getValueAt(k, 7),tablemodel.getValueAt(k, 8),tablemodel.getValueAt(k, 9)
				});
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		for(ChiTietHoaDon hoaDon: listCT_HD) {
			lapHoaDonDAO.addCT_HoaDon(hoaDon.getMaHoaDon(), hoaDon.getMaMon(), hoaDon.getDonGia(), hoaDon.getGiamGia(), hoaDon.getSoLuong(), hoaDon.getDonViTinh());
		}
		btnInHd.setEnabled(false);
		int maNhanVien = Integer.parseInt(lapHoaDonDAO.maNhanVien(FrmDangNhap.taiKhoan.getTenTaiKhoan()));
		setDuLieuFrmInHd(lapHoaDonDAO.maHoaDon(String.valueOf(maNhanVien)),"Không kê đơn", txtNgay.getText(), "", "", "", "", "", "", txtTongTienMon.getText(),txtTongThanhToan.getText(), lapHoaDonDAO.tenNhanVien(txtNhanVien.getText()), "");
		frmXuatHD.lblSL.setText(i + "");
		this.frmXuatHD.setVisible(true);
		frmXuatHD.setLocationRelativeTo(null);
		// ham in hoa don 
		frmXuatHD.printingHoaDon();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
		ArrayList<ChiTietHoaDon> listCT_HD = new ArrayList<ChiTietHoaDon>();
		if(obj.equals(btnThemMonTim)) {
			Object objTenMon = cboTimKiemMon.getSelectedItem();
			String tenMon = String.valueOf(objTenMon);
			System.out.println(tenMon);
			if(kiemTraTrungMon(tenMon)==false) {
				//hien frmChonMon
				if(updateTableChonMon(tenMon)==true) {
					frmChonMon.setVisible(true);
					frmChonMon.setLocationRelativeTo(null);
				}
				//	timKiemMonTheoTen(tenMon);

			}
			else {
				JOptionPane.showMessageDialog(this, "Món đã có trong bảng ! Vui lòng nhập số lượng.");
				boolean check = true;
				int row = table.getSelectedRow();
				
				int maMon = (int) table.getValueAt(row, 1);
				while(check) {
					try {
						String soLuongMonObj = JOptionPane.showInputDialog("Nhập số lượng món mua.",JOptionPane.YES_NO_CANCEL_OPTION);
						if(soLuongMonObj == null) {
							check = false;
						}
						else if(soLuongMonObj != null) {
							if(soLuongMonObj.matches("^[0-9]+$")) {
								int soLuongMonMoi = Integer.parseInt(soLuongMonObj.toString());
								int soLuongMonCu = Integer.parseInt(table.getValueAt(row, 7).toString());
								if((lapHoaDonDAO.soLuongMonDaBan(maMon) + (soLuongMonMoi+soLuongMonCu)) <= lapHoaDonDAO.soLuongNhap(maMon)) {

									int soLuongMonCuMoi = soLuongMonMoi + soLuongMonCu;
									table.setValueAt(soLuongMonCuMoi, row, 7);

									check = false;
								}
								else
									JOptionPane.showMessageDialog(this, "Số Lượng Món Cần Mua Vượt Giới Hạn Món Trong Kho!\n Nhập Số Lượng Ít Hơn "+(lapHoaDonDAO.soLuongNhap(maMon)-(lapHoaDonDAO.soLuongMonDaBan(maMon)+soLuongMonCu)));
							}
							else {
								JOptionPane.showMessageDialog(null, "Số Lượng Phải Nhập Bằng Chữ!");
								check = true;
							}
						}
					} catch (NullPointerException e2) {
						// TODO: handle exception

					}catch (NumberFormatException e3) {
						// TODO: handle exception
						e3.printStackTrace();
						JOptionPane.showMessageDialog(null, "Số Lượng Nhập Quá Lớn!");
						//					check = true;
					}
				}
			}
		}
		else if(obj.equals(btnInHd)) {
			Object o =JOptionPane.showConfirmDialog(this, "Bạn có chăc chắn in hóa đơn?");
			String chon = o.toString();
			if(chon.equalsIgnoreCase("0")) {
				if(kiemTraNhapKhachHangMonKeDon()) {
					themHoaDonVaChiTietHoaDonKeDon();
				}
				else if(radKhongKeDon.isSelected() && txtSdt.getText().equalsIgnoreCase("")==false) {
					themHoaDonVaChiTietHoaDonKeDon();
				}
				else if(radKhongKeDon.isSelected() && txtSdt.getText().equalsIgnoreCase("")) {
					themHoaDonVaChiTietHoaDonKhongKeDon();
				}
			}
		}
		else if(obj.equals(btnXoa)) {
			try {
				int row = table.getSelectedRow();
				if(row != -1) {
					tablemodel.removeRow(row);
					i--;
					//
					if(kiemTraMonKeDon()==false) {
						radKhongKeDon.setSelected(true);
						radKeDon.setSelected(false);
						lblThongBao.setText("");
					}
					//
					double tongTien =0;
					List data = tablemodel.getDataVector();
					Object[] list1 = data.toArray();
					for(int k=0;k<list1.length;k++) {
						double tong =Double.parseDouble(tablemodel.getValueAt(k, 9).toString());
						tongTien += tong;
					}
					txtTongTienMon.setText(String.valueOf(tongTien));
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		else if(obj.equals(cboGiamGia1)) {
			DecimalFormat tien = new DecimalFormat("#,##0");
			double tongTien =Double.parseDouble(txtTongTienMon.getText());
			int giamGia1 =Integer.parseInt(cboGiamGia1.getSelectedItem().toString());
			if(giamGia1==0) {
				tongThanhToan = (float) (tongTien + (tongTien*(0.05)));
				txtTongThanhToan.setText(tien.format(tongThanhToan)+" VNĐ");
			}
			else if(giamGia1!=0) {
				tongThanhToan = (float) ((tongTien - (tongTien*giamGia1/100)) + ((tongTien - (tongTien*giamGia1/100))*(0.05))) ;
				txtTongThanhToan.setText(tien.format(tongThanhToan)+" VNĐ");
			}

		}
		else if(obj.equals(btnThemHoaDon)) {
			tablemodel.addRow(new Object[] {

			});
			tablemodel = (DefaultTableModel) table.getModel();
			tablemodel.getDataVector().removeAllElements();
			btnInHd.setEnabled(true);
			radKeDon.setSelected(false);
			radKhongKeDon.setSelected(false);
			xoaTrangTxt();
			frmXuatHD.lblMaHD.setText("");
			frmXuatHD.lblLoaiHD1.setText("");
			frmXuatHD.lblNgayLap1.setText("");
			frmXuatHD.lblTenKH1.setText("");
			frmXuatHD.lblGioiTinh.setText("");
			frmXuatHD.lblDCKH1.setText("");
			frmXuatHD.lblNamSinh1.setText("");
			frmXuatHD.lblsdtkh1.setText("");
			frmXuatHD.lblTongTMon.setText("");
			frmXuatHD.lblTongT.setText("");
			frmXuatHD.lblNguoiBan.setText("");
			frmXuatHD.lblNguoiMuaHang1.setText("");
			frmXuatHD.tableModel.addRow(new Object[] {

			});
			frmXuatHD.tableModel = (DefaultTableModel) frmXuatHD.table.getModel();
			frmXuatHD.tableModel.getDataVector().removeAllElements();
			i=0;
			
			txtTongTienMon.setText("");
			txtTongThanhToan.setText("");
			setLoaiMon = "";
		}
		else if(obj.equals(mntmSoLuong)) {
			boolean check = true;
			int row = table.getSelectedRow();
			int maMon = (int) table.getValueAt(row, 1);
			while(check) {
				try {
					String soLuongMonObj = JOptionPane.showInputDialog("Nhập số lượng món mua.",JOptionPane.YES_NO_CANCEL_OPTION);
					if(soLuongMonObj == null) {
						check = false;
					}
					else if(soLuongMonObj != null) {
						if(soLuongMonObj.matches("^[0-9]+$")) {
							int soLuongMonMoi = Integer.parseInt(soLuongMonObj.toString());
							int soLuongMonCu = Integer.parseInt(table.getValueAt(row, 7).toString());
							if((lapHoaDonDAO.soLuongMonDaBan(maMon) + (soLuongMonMoi+soLuongMonCu)) <= lapHoaDonDAO.soLuongNhap(maMon)) {

								int soLuongMonCuMoi = soLuongMonMoi + soLuongMonCu;
								table.setValueAt(soLuongMonCuMoi, row, 7);

								check = false;
							}
							else
								JOptionPane.showMessageDialog(this, "Số Lượng Món Cần Mua Vượt Giới Hạn Món Trong Kho!\n Nhập Số Lượng Ít Hơn "+(lapHoaDonDAO.soLuongNhap(maMon)-(lapHoaDonDAO.soLuongMonDaBan(maMon)+soLuongMonCu)));
						}
						else {
							JOptionPane.showMessageDialog(null, "Số Lượng Phải Nhập Bằng Chữ!");
							check = true;
						}
					}
				} catch (NullPointerException e2) {
					// TODO: handle exception

				}catch (NumberFormatException e3) {
					// TODO: handle exception
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "Số Lượng Nhập Quá Lớn!");
					check = true;
				}catch (ArrayIndexOutOfBoundsException e4) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Chọn Vào Món Cần Thêm Số Lượng!");
				}
			}
		}
		else if(obj.equals(mntmXoa)) {
			try {
				int row = table.getSelectedRow();
				if(row != -1) {
					tablemodel.removeRow(row);
					i--;
					//
					if(kiemTraMonKeDon()==false) {
						radKhongKeDon.setSelected(true);
						radKeDon.setSelected(false);
						lblThongBao.setText("");
					}
					//
					double tongTien =0;
					List data = tablemodel.getDataVector();
					Object[] list1 = data.toArray();
					for(int k=0;k<list1.length;k++) {
						double tong =Double.parseDouble(tablemodel.getValueAt(k, 9).toString());
						tongTien += tong;
					}
					txtTongTienMon.setText(String.valueOf(tongTien));
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}
	public static  void updateTongTien() {
		DecimalFormat tien = new DecimalFormat("#,##0");
		int soLuong=0;
		double donGia=0;
		double thanhTien=0 ;

		double tongTien =0;
		int giamGia1 =Integer.parseInt(cboGiamGia1.getSelectedItem().toString());
		List data = tablemodel.getDataVector();
		Object[] list1 = data.toArray();
		for(int k=0;k<list1.length;k++) {
			double tong =Double.parseDouble(tablemodel.getValueAt(k, 9).toString());
			tongTien += tong;
		}
		txtTongTienMon.setText(String.valueOf(tongTien));
		if(giamGia1==0) {
			tongThanhToan = (float) (tongTien + (tongTien*(0.05)));

			txtTongThanhToan.setText(tien.format(tongThanhToan)+" VNĐ");
		}
		else if(giamGia1!=0) {
			tongThanhToan = (float) ((tongTien - (tongTien*giamGia1/100)) + ((tongTien - (tongTien*giamGia1/100))*(0.05))) ;
			txtTongThanhToan.setText(tien.format(tongThanhToan)+" VNĐ");
		}

	}


	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		DecimalFormat tien = new DecimalFormat("#,##0");
		int row = e.getFirstRow();
		int col = e.getColumn();
		int soLuong=0;
		double donGia=0;
		double thanhTien=0 ;


		try {
			int giamGia = Integer.parseInt( tablemodel.getValueAt(row,8).toString());
			if((col==7 || col==8) && giamGia==0) {
				soLuong =Integer.parseInt( tablemodel.getValueAt(row,7).toString());
				donGia = Double.parseDouble( tablemodel.getValueAt(row,6).toString());
				thanhTien = soLuong*donGia;
				tablemodel.setValueAt(thanhTien, row, 9);

			}
			else if((col==7 || col==8) && giamGia!=0){
				soLuong =Integer.parseInt( tablemodel.getValueAt(row,7).toString());
				donGia = Double.parseDouble( tablemodel.getValueAt(row,6).toString());
				thanhTien = soLuong*donGia -(soLuong*donGia*giamGia/100);
				tablemodel.setValueAt(thanhTien, row, 9);
			}
			else if(col==9) {
				double tongTien =0;
				int giamGia1 =Integer.parseInt(cboGiamGia1.getSelectedItem().toString());
				List data = tablemodel.getDataVector();
				Object[] list1 = data.toArray();
				for(int k=0;k<list1.length;k++) {
					double tong =Double.parseDouble(tablemodel.getValueAt(k, 9).toString());
					tongTien += tong;
				}
				txtTongTienMon.setText(String.valueOf(tongTien));
				if(giamGia1==0) {
					tongThanhToan = (float) (tongTien + (tongTien*(0.05)));

					txtTongThanhToan.setText(tien.format(tongThanhToan)+" VNĐ");
				}
				else if(giamGia1!=0) {
					tongThanhToan = (float) ((tongTien - (tongTien*giamGia1/100)) + ((tongTien - (tongTien*giamGia1/100))*(0.05))) ;
					txtTongThanhToan.setText(tien.format(tongThanhToan)+" VNĐ");
				}

			}
		} catch (Exception e2) {
			// TODO: handle exception
			//			table.setRowSelectionInterval(row, row);
			//	JOptionPane.showMessageDialog(this, "Số lượng phải nhập số !");

		}

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
