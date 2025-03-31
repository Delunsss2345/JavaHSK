/* Người làm: Huỳnh Hoàng Phúc*/
package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import Dao.KhachHangDAO;
import entities.DiaChi;
import entities.KhachHang;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class FrmKhachHang extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = -4885536806341977801L;
	public static JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtHo;
	private JTextField txtSoCCCD;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTable tblKH;
	private JTextField txtTen;
	private JTextField txtTim;
	private JDateChooser dateCNgaySinh;
	//private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXoaRong;
	private JButton btnTim;
	private JButton btnThoat;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private JRadioButton radMa;
	private JRadioButton radSDT;
	private JRadioButton radTen;
	private JRadioButton radCCCD;
	private DefaultTableModel model;
	KhachHangDAO khDao = new KhachHangDAO();
	private ButtonGroup buttonGroupGioiTinh;
	private JTextField txtMaDiaChi;
	private JLabel lblMaDiaChi;
	private JButton btnLamMoi;
	private ButtonGroup buttonGroupTim;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKhachHang frame = new FrmKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1354, 675);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlKH = new JPanel();
		pnlKH.setBounds(10, 11, 1318, 614);
		contentPane.add(pnlKH);
		pnlKH.setLayout(null);

		JLabel lblKH_Ma = new JLabel("Mã KH:");
		lblKH_Ma.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKH_Ma.setBounds(20, 76, 64, 26);
		pnlKH.add(lblKH_Ma);

		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMa.setBounds(119, 76, 296, 25);
		pnlKH.add(txtMa);
		txtMa.setColumns(10);

		JLabel lblKH_Ho = new JLabel("Họ:");
		lblKH_Ho.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKH_Ho.setBounds(460, 77, 54, 21);
		pnlKH.add(lblKH_Ho);

		txtHo = new JTextField();
		txtHo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtHo.setColumns(10);
		txtHo.setBounds(536, 77, 296, 25);
		pnlKH.add(txtHo);

		JLabel lblKH_NgaySinh = new JLabel("Ngày sinh:");
		lblKH_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKH_NgaySinh.setBounds(20, 113, 89, 26);
		pnlKH.add(lblKH_NgaySinh);

		JLabel lblKH_SoCMND = new JLabel("Số CCCD:");
		lblKH_SoCMND.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKH_SoCMND.setBounds(880, 114, 78, 25); 
		pnlKH.add(lblKH_SoCMND);

		txtSoCCCD = new JTextField();
		txtSoCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSoCCCD.setColumns(10);
		txtSoCCCD.setBounds(956, 113, 270, 25);
		pnlKH.add(txtSoCCCD);

		JLabel lblKH_SDT = new JLabel("Số điện thoại \r\n:");
		lblKH_SDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKH_SDT.setBounds(20, 150, 99, 26);
		pnlKH.add(lblKH_SDT);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(806, 150, 420, 25);
		pnlKH.add(txtDiaChi);

		JLabel lblKH_DiaChi = new JLabel("Địa chỉ:");
		lblKH_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKH_DiaChi.setBounds(730, 152, 54, 21); 
		pnlKH.add(lblKH_DiaChi);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSDT.setColumns(10);
		txtSDT.setBounds(119, 151, 296, 25);
		pnlKH.add(txtSDT);


		btnSua = new JButton("Cập nhật");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSua.setBounds(161, 200, 120, 30);
		pnlKH.add(btnSua);

		JPanel pnlKH1 = new JPanel();
		pnlKH1.setBorder(
				new TitledBorder(null, "Danh sách khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlKH1.setBounds(10, 376, 1238, 236);
		pnlKH.add(pnlKH1);
		pnlKH1.setLayout(null);

		JScrollPane scrKH = new JScrollPane();
		scrKH.setBounds(10, 22, 1218, 203);
		pnlKH1.add(scrKH);

		String[] tb = new String[] { "STT", "Mã KH", "Họ", "Tên", "Ngày Sinh", "Giới Tính", "Số CCCD", "Số ĐT",
				"Mã Địa Chỉ" };
		model = new DefaultTableModel(tb, 0);
		tblKH = new JTable(model);
		tblKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrKH.setViewportView(tblKH);

		JLabel lblKH_GioiTinh = new JLabel("Giới Tính:");
		lblKH_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKH_GioiTinh.setBounds(460, 113, 68, 26);
		pnlKH.add(lblKH_GioiTinh);

		radNam = new JRadioButton("Nam");
		radNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radNam.setBounds(556, 118, 63, 21);
		pnlKH.add(radNam);

		radNu = new JRadioButton("Nữ");
		radNu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radNu.setBounds(634, 118, 63, 21);
		pnlKH.add(radNu);

		buttonGroupGioiTinh = new ButtonGroup();
		buttonGroupGioiTinh.add(radNam);
		buttonGroupGioiTinh.add(radNu);

		JLabel lblNewLabel = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1298, 54);
		pnlKH.add(lblNewLabel);

		dateCNgaySinh = new JDateChooser();
		dateCNgaySinh.setBounds(119, 114, 296, 25);
		pnlKH.add(dateCNgaySinh);
		dateCNgaySinh.setLocale(Locale.forLanguageTag("vi-VN"));
		dateCNgaySinh.setDateFormatString("dd/MM/yyyy");

		JLabel lblKH_Ten = new JLabel("Tên:");
		lblKH_Ten.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKH_Ten.setBounds(880, 76, 54, 26);
		pnlKH.add(lblKH_Ten);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTen.setColumns(10);
		txtTen.setBounds(956, 77, 270, 25);
		pnlKH.add(txtTen);

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnXoaRong.setBounds(295, 200, 120, 30);
		pnlKH.add(btnXoaRong);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tìm kiếm theo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 243, 982, 100);
		pnlKH.add(panel);
		panel.setLayout(null);

		radMa = new JRadioButton("Mã");
		radMa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radMa.setBounds(6, 20, 55, 23);
		panel.add(radMa);

		radSDT = new JRadioButton("SĐT");
		radSDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radSDT.setBounds(6, 60, 65, 23);
		panel.add(radSDT);

		radTen = new JRadioButton("Tên");
		radTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radTen.setBounds(100, 20, 55, 23);
		panel.add(radTen);

		radCCCD = new JRadioButton("Số CCCD");
		radCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		radCCCD.setBounds(100, 60, 106, 23);
		panel.add(radCCCD);

		buttonGroupTim = new ButtonGroup();
		buttonGroupTim.add(radMa);
		buttonGroupTim.add(radSDT);
		buttonGroupTim.add(radTen);
		buttonGroupTim.add(radCCCD);

		JLabel lblNhpThngTin = new JLabel("Nhập thông tin tìm kiếm:");
		lblNhpThngTin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNhpThngTin.setBounds(234, 39, 158, 25);
		panel.add(lblNhpThngTin);

		txtTim = new JTextField();
		txtTim.setBounds(397, 40, 270, 25);
		panel.add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTim.setBounds(690, 39, 120, 30);
		panel.add(btnTim);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLamMoi.setBounds(835, 39, 120, 30);
		panel.add(btnLamMoi);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnThoat.setBounds(1051, 286, 120, 30);
		pnlKH.add(btnThoat);

		txtMaDiaChi = new JTextField();
		txtMaDiaChi.setEditable(false);
		txtMaDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaDiaChi.setColumns(10);
		txtMaDiaChi.setBounds(553, 150, 150, 25);
		pnlKH.add(txtMaDiaChi);

		lblMaDiaChi = new JLabel("Mã đia chỉ:");
		lblMaDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaDiaChi.setBounds(460, 151, 78, 25);
		pnlKH.add(lblMaDiaChi);
		btnSua.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnTim.addActionListener(this);
		btnThoat.addActionListener(this);
		btnLamMoi.addActionListener(this);
		tblKH.addMouseListener(this);
		btnSua.setIcon(new ImageIcon("Hinh\\edit.png"));
		btnXoaRong.setIcon(new ImageIcon("Hinh\\empty.png"));
		btnTim.setIcon(new ImageIcon("Hinh\\search.png"));
		btnLamMoi.setIcon(new ImageIcon("Hinh\\refresh.png"));
		btnThoat.setIcon(new ImageIcon("Hinh\\close.png"));	
		docDuLieu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblKH.getSelectedRow();
		int maKH = Integer.parseInt(model.getValueAt(row, 1).toString());
		try {
			KhachHang kh = khDao.layThongTinKhachHang(maKH);
			txtMa.setText(maKH + "");
			txtTen.setText(kh.getTen());
			txtHo.setText(kh.getHo());
			dateCNgaySinh.setDate(kh.getNgaySinh());
			String gioiTinh = kh.getGioiTinh().toString().trim();
			if (gioiTinh.equalsIgnoreCase("Nam")) {
				radNam.setSelected(true);
				radNu.setSelected(false);
			} else {
				radNu.setSelected(true);
				radNam.setSelected(false);
			}
			txtSoCCCD.setText(kh.getCmnd());
			txtSDT.setText(kh.getSoDienThoai());
			txtMaDiaChi.setText(kh.getDiaChi().getMaDiaChi() + "");

			int maDC = Integer.parseInt(model.getValueAt(row, 8).toString());
			DiaChi dc = khDao.layThongTinDiaChi(maDC);
			String soNha = dc.getSoNha();
			String tenDuong = dc.getTenDuong().trim();
			String phuong = dc.getPhuong().trim();
			String quan = dc.getQuan().trim();
			String thanhPho = dc.getThanhPho().trim();
			String quocGia = dc.getQuocGia().trim();
			String diaChi = "";
			if (!soNha.equalsIgnoreCase("") && !tenDuong.equalsIgnoreCase("")) {
				diaChi = soNha + ", " + tenDuong + ", " + phuong + ", " + quan + ", " + thanhPho + ", " + quocGia;
			} else {
				diaChi = phuong + ", " + quan + ", " + thanhPho + ", " + quocGia;
			}
			txtDiaChi.setText(diaChi);
		} catch (Exception e2) {
			System.out.println("error mouse clicked");
			e2.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThoat)) {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát !") == JOptionPane.YES_OPTION) {
				FrmManHinhChinh.tabbedPane.remove(contentPane);
			}
		} else if (obj.equals(btnXoaRong)) {
			xoaRong();
		}
		else if (obj.equals(btnSua)) {
			int row = tblKH.getSelectedRow();
			try {
				if (row != -1) {
					Date ngaySinhsql = null;
					try {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String ngaySinhtxt = dateFormat.format(dateCNgaySinh.getDate());
						java.util.Date ngaySinh = dateFormat.parse(ngaySinhtxt);
						ngaySinhsql = new Date(ngaySinh.getTime());
					} catch (Exception e2) {
						e2.printStackTrace();
					}

					String gioiTinh = "";
					if (radNam.isSelected()) {
						gioiTinh = "Nam";
					} else if (radNu.isSelected()) {
						gioiTinh = "Nữ";
					}

					String ho = txtHo.getText().trim();
					String ten = txtTen.getText().trim();
					String sdt = txtSDT.getText().trim();
					String cmnd = txtSoCCCD.getText().trim();
					String invalid1 = "";
					if (ho.equalsIgnoreCase("")) {
						invalid1 += "Vui lòng nhập họ !\n";
					} else if (ho.length() > 25) {
						invalid1 += "Họ không hợp lệ !\n";
					}
					if (ten.equalsIgnoreCase("")) {
						invalid1 += "Vui lòng nhập tên !\n";
					} else if (ten.length() > 10) {
						invalid1 += "Tên không hợp lệ !\n";
					}
					String year = ngaySinhsql.toString().substring(0, 4);
					int yearsql = Integer.parseInt(year);
					if (ngaySinhsql.toString().equalsIgnoreCase("")) {
						invalid1 += "Vui lòng nhập ngày sinh !\n";
					}
					if (LocalDate.now().getYear() - yearsql > 60 || LocalDate.now().getYear() - yearsql < 18) {
						invalid1 += "Tuổi phải từ 18->60 !\n";
					}
					if (sdt.equalsIgnoreCase("")) {
						invalid1 += "Vui lòng nhập số điện thoại !\n";
					} else if (!sdt.matches("^0[0-9]{9}$")) {
						invalid1 += "Số điện thoại không hợp lệ !(10 số và bắt là 0)\n";
					}
					if (cmnd.equalsIgnoreCase("")) {
						invalid1 += "Vui lòng nhập CCCD !\n";
					} else if (!cmnd.matches("^[0-9]{12}$")) {
						invalid1 += "Số CCCD không hợp lệ ! (12 số)\n";
					}
					if (invalid1.equalsIgnoreCase("")) {
						if (khDao.capnhatNhanVien(Integer.parseInt(txtMa.getText()), txtTen.getText(), txtHo.getText(),
								ngaySinhsql, gioiTinh, txtSoCCCD.getText(), txtSDT.getText())) {
							JOptionPane.showMessageDialog(this, "Đã cập nhật !", "Thông báo", JOptionPane.CLOSED_OPTION,
									new ImageIcon("Hinh\\yes.png"));
							tblKH.setValueAt(txtTen.getText(), row, 2);
							tblKH.setValueAt(txtHo.getText(), row, 3);
							tblKH.setValueAt(ngaySinhsql, row, 4);
							tblKH.setValueAt(gioiTinh, row, 5);
							tblKH.setValueAt(txtSoCCCD.getText(), row, 6);
							tblKH.setValueAt(txtSDT.getText(), row, 7);
							deleteAllDataTable();
							docDuLieu();
						}
					} else {
						JOptionPane.showMessageDialog(null, invalid1);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để cập nhật !", "Thông báo",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (obj.equals(btnTim)) {
			if (radMa.isSelected() == false && radTen.isSelected() == false && radSDT.isSelected() == false
					&& radCCCD.isSelected() == false && txtTim.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin và chọn loại tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			} else if (txtTim.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			} else if (radMa.isSelected() == false && radTen.isSelected() == false && radSDT.isSelected() == false
					&& radCCCD.isSelected() == false) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn loại tìm kiếm !", "Thông báo",
						JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
			} else {
				if (radMa.isSelected()) {
					try {
						int ma = Integer.parseInt(txtTim.getText().trim());
						getTimKiemKhachHangById(ma);
					} catch (Exception e2) {
						if (!txtMa.getText().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi !", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
							txtTim.requestFocus();
							txtTim.selectAll();
						} else {
							JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên !", "Thông báo",
									JOptionPane.ERROR_MESSAGE, new ImageIcon("Hinh\\warning.png"));
							txtTim.requestFocus();
							txtTim.selectAll();
						}
					}
				} else if (radTen.isSelected()) {
					String ten = txtTim.getText().trim();
					getTimKiemKhachHangByTen(ten);
				} else if (radSDT.isSelected()) {
					String sdt = txtTim.getText().trim();
					getTimKiemKhachHangBySoDT(sdt);
				} else if (radCCCD.isSelected()) {
					String cmnd = txtTim.getText().trim();
					getTimKiemKhachHangByCMND(cmnd);
				}
			}

		} else if (obj.equals(btnLamMoi)) {
			txtTim.selectAll();
			txtTim.requestFocus();
			deleteAllDataTable();
			docDuLieu();
		}
	}

	private void docDuLieu() {
		try {
			List<KhachHang> list = khDao.getAllKhachHang();
			int i = 0;
			for (KhachHang khachHang : list) {
				i++;
				model.addRow(new Object[] { i + "", khachHang.getMaKhachHang(), khachHang.getHo().trim(),
						khachHang.getTen().trim(), khachHang.getNgaySinh(), khachHang.getGioiTinh().trim(),
						khachHang.getCmnd().trim(), khachHang.getSoDienThoai().trim(),
						khachHang.getDiaChi().getMaDiaChi() });
			}
			tblKH.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void xoaRong() {
		txtMa.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");
		txtSoCCCD.setText("");
		txtTim.setText("");
		buttonGroupGioiTinh.clearSelection();
		txtMaDiaChi.setText("");
		dateCNgaySinh.setDate(null);
	}

	public void deleteAllDataTable() {
		model = (DefaultTableModel) tblKH.getModel();
		model.getDataVector().removeAllElements();
	}

	public void getTimKiemKhachHangById(int ma) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khDao.timkiemKhachHangByMa(ma);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) tblKH.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}

	public void getTimKiemKhachHangByTen(String ten) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khDao.timkiemKhachHangByTen(ten);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) tblKH.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}

	public void getTimKiemKhachHangByCMND(String cmnd) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khDao.timkiemKhachHangByCMND(cmnd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) tblKH.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}

	public void getTimKiemKhachHangBySoDT(String sdt) {
		ArrayList<KhachHang> list = null;
		try {
			list = (ArrayList<KhachHang>) khDao.timkiemKhachHangBySDT(sdt);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model = (DefaultTableModel) tblKH.getModel();
		model.setRowCount(0);
		for (KhachHang khachhang : list) {
			model.addRow(khachhang.toVector());
		}
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(i + 1, i, 0);
		}
	}
}
