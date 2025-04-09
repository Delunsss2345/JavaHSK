/* Người làm: Nguyễn Tuấn Phát*/
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;


public class FrmXuatHD extends JFrame implements Printable,ActionListener {

	 private static JPanel contentPane;
	    public static JTable table;
	    public static JLabel lblQLT;
	    public static JLabel lblMSThue;
	    public static JLabel lblDiaChi;
	    public static JLabel lblDienThoai;
	    public static JLabel lblGPKD;
	    public static JLabel lblMHDon;
	    public static JLabel lblLoaiHD;
	    public static JLabel lblHD;
	    public static JLabel lblNgayLap;
	    public static JLabel lblHoTenKH;
	    public static JLabel lblDiaChiKH;
	    public static JLabel lblSDTKH;
	    public static JLabel lblTenKH1;
	    public static JLabel lblLoaiHD1;
	    public static JLabel lblMaHD;
	    public static JLabel lblNgayLap1;
	    public static JLabel lblDCKH1;
	    public static JLabel lblsdtkh1;
	    public static JLabel lblSL;
	    public static JLabel lblTongTMon;
	    public static JLabel lblTongT;
	    public static JLabel lblNguoiBan;
	    public static JLabel lblNguoiMuaHang1;
	    private static JPanel panel;
	    public static DefaultTableModel tableModel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXuatHD frame = new FrmXuatHD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrmXuatHD() {
		setTitle("HÓA ĐƠN QUÁN CAFE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setSize( 1199, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.setBounds(432, 11, 616, 724);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		lblQLT = new JLabel("HÓA ĐƠN QUÁN CAFE");
		lblQLT.setBounds(149, 11, 301, 27);
		lblQLT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQLT.setForeground(new Color(255, 0, 0));
		panel.add(lblQLT);
		
		lblMSThue = new JLabel("Mã số thuế:");
		lblMSThue.setBounds(33, 38, 75, 14);
		lblMSThue.setForeground(new Color(0, 0, 255));
		lblMSThue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblMSThue);
		
		lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(33, 93, 58, 14);
		lblDiaChi.setForeground(Color.BLUE);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblDiaChi);
		
		lblDienThoai = new JLabel("Số điện thoại:");
		lblDienThoai.setBounds(33, 52, 75, 14);
		lblDienThoai.setForeground(Color.BLUE);
		lblDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblDienThoai);
		
		lblGPKD = new JLabel("GPKD số:");
		lblGPKD.setBounds(33, 67, 75, 20);
		lblGPKD.setForeground(Color.BLUE);
		lblGPKD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblGPKD);
		
		lblMHDon = new JLabel("Mã hóa đơn:");
		lblMHDon.setBounds(365, 38, 75, 14);
		lblMHDon.setForeground(Color.BLUE);
		lblMHDon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblMHDon);
		
		lblLoaiHD = new JLabel("Loại hóa đơn:");
		lblLoaiHD.setBounds(365, 52, 85, 20);
		lblLoaiHD.setForeground(Color.BLUE);
		lblLoaiHD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblLoaiHD);
		
		lblHD = new JLabel("Hóa đơn ");
		lblHD.setBounds(202, 111, 193, 35);
		lblHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblHD.setForeground(new Color(0, 0, 255));
		lblHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblHD);
		
		lblNgayLap = new JLabel("Ngày lập:");
		lblNgayLap.setBounds(365, 67, 75, 20);
		lblNgayLap.setForeground(Color.BLUE);
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblNgayLap);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 176, 596, 84);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblHoTenKH = new JLabel("Họ tên KH:");
		lblHoTenKH.setForeground(new Color(0, 0, 255));
		lblHoTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHoTenKH.setBounds(10, 11, 200, 14);
		panel_1.add(lblHoTenKH);
		
		lblDiaChiKH = new JLabel("Địa chỉ:");
		lblDiaChiKH.setForeground(Color.BLUE);
		lblDiaChiKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChiKH.setBounds(10, 61, 75, 14);
		panel_1.add(lblDiaChiKH);		
		lblSDTKH = new JLabel("Số điện thoại:");
		lblSDTKH.setForeground(Color.BLUE);
		lblSDTKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSDTKH.setBounds(296, 36, 106, 14);
		panel_1.add(lblSDTKH);		lblTenKH1 = new JLabel("");
		lblTenKH1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTenKH1.setBounds(80, 12, 147, 14);
		panel_1.add(lblTenKH1);		lblsdtkh1 = new JLabel("");
		
		lblsdtkh1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblsdtkh1.setBounds(380, 37, 122, 14);
		panel_1.add(lblsdtkh1);
		
		lblDCKH1 = new JLabel("");
		lblDCKH1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDCKH1.setBounds(66, 61, 390, 14);
		panel_1.add(lblDCKH1);		JLabel lblDHTTMon = new JLabel("THANH TOÁN CAFE");
		lblDHTTMon.setBounds(202, 138, 193, 27);
		lblDHTTMon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDHTTMon.setForeground(new Color(0, 0, 255));
		lblDHTTMon.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblDHTTMon);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		scrollPane_1.setBounds(10, 263, 596, 308);
		panel.add(scrollPane_1);
		
		
		String[] tb = new String[] {"STT","Tên Món","ĐVT","Đơn Giá","Số Lượng","Giảm Giá(%)","Thành Tiền"};

		tableModel = new DefaultTableModel(tb,0);
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(63);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNguoiMuaHang = new JLabel("Người mua hàng");
		lblNguoiMuaHang.setBounds(41, 650, 134, 14);
		lblNguoiMuaHang.setForeground(Color.BLUE);
		lblNguoiMuaHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNguoiMuaHang);
		
		JLabel lblkghiRH = new JLabel("(Ký và ghi rõ họ tên)");
		lblkghiRH.setBounds(18, 662, 134, 14);
		lblkghiRH.setHorizontalAlignment(SwingConstants.CENTER);
		lblkghiRH.setForeground(Color.BLUE);
		lblkghiRH.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel.add(lblkghiRH);
		
		JLabel lblNguoiBanHang = new JLabel("Người bán hàng");
		lblNguoiBanHang.setBounds(444, 650, 134, 14);
		lblNguoiBanHang.setForeground(Color.BLUE);
		lblNguoiBanHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNguoiBanHang);
		
		JLabel label_1 = new JLabel("(Ký và ghi rõ họ tên)");
		label_1.setBounds(444, 662, 134, 14);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 572, 596, 35);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTongTienTh = new JLabel("Tổng tiền món:");
		lblTongTienTh.setForeground(Color.BLUE);
		lblTongTienTh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTongTienTh.setBounds(289, 6, 106, 24);
		panel_2.add(lblTongTienTh);
		
		JLabel lblSLuong = new JLabel("Số lượng:");
		lblSLuong.setForeground(Color.BLUE);
		lblSLuong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSLuong.setBounds(10, 11, 66, 19);
		panel_2.add(lblSLuong);
		
		lblSL = new JLabel("");
		lblSL.setHorizontalAlignment(SwingConstants.LEFT);
		lblSL.setBounds(75, 12, 31, 14);
		panel_2.add(lblSL);
		
		lblTongTMon = new JLabel("");
		lblTongTMon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongTMon.setBounds(386, 11, 132, 19);
		panel_2.add(lblTongTMon);
		
		JLabel label_3 = new JLabel("(VND)");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(537, 11, 40, 14);
		panel_2.add(label_3);
		
		JLabel lblThueXuat = new JLabel("Thuế suất(VAT):");
		lblThueXuat.setBounds(104, 11, 106, 14);
		panel_2.add(lblThueXuat);
		lblThueXuat.setForeground(Color.BLUE);
		lblThueXuat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblThue = new JLabel("5");
		lblThue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThue.setBounds(208, 11, 31, 14);
		panel_2.add(lblThue);
		
		JLabel label_2 = new JLabel("%");
		label_2.setBounds(248, 11, 31, 14);
		panel_2.add(label_2);
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_3.setBounds(10, 604, 596, 35);
		panel.add(panel_3);
		
		JLabel lblTongThanhToan = new JLabel("Tổng tiền thanh toán:");
		lblTongThanhToan.setBounds(227, 12, 133, 23);
		panel_3.add(lblTongThanhToan);
		lblTongThanhToan.setForeground(Color.BLUE);
		lblTongThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblTongT = new JLabel("");
		lblTongT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTongT.setBounds(349, 12, 169, 23);
		panel_3.add(lblTongT);
		
		JLabel lblvnd = new JLabel("(VND)");
		lblvnd.setForeground(Color.BLUE);
		lblvnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblvnd.setBounds(539, 12, 38, 14);
		panel_3.add(lblvnd);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(130, 12, 116, 14);
		panel_3.add(label_4);
		
		JLabel lblMaSoThue = new JLabel("0107853191");
		lblMaSoThue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMaSoThue.setBounds(107, 38, 106, 14);
		panel.add(lblMaSoThue);
		
		JLabel lblSDT1 = new JLabel("0368.564.833  - 0333.319.121");
		lblSDT1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDT1.setBounds(107, 54, 199, 14);
		panel.add(lblSDT1);
		
		JLabel lblGPDK1 = new JLabel(" 0111340000029");
		lblGPDK1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGPDK1.setBounds(107, 71, 106, 14);
		panel.add(lblGPDK1);
		
		JLabel lblDiaChi1 = new JLabel("12 Nguyễn Văn Bảo - Phường 4 - Gò Vấp - Thành phố Hồ Chí Minh");
		lblDiaChi1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChi1.setBounds(88, 87, 400, 27);
		panel.add(lblDiaChi1);
		
		lblMaHD = new JLabel("");
		lblMaHD.setBounds(435, 38, 162, 14);
		panel.add(lblMaHD);
		
		lblLoaiHD1 = new JLabel("");
		lblLoaiHD1.setBounds(460, 52, 120, 14);
		panel.add(lblLoaiHD1);
		
		lblNgayLap1 = new JLabel("");
		lblNgayLap1.setBounds(450, 70, 126, 14);
		panel.add(lblNgayLap1);
		
		lblNguoiBan = new JLabel("");
		lblNguoiBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblNguoiBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNguoiBan.setBounds(410, 675, 168, 27);
		panel.add(lblNguoiBan);
		
		lblNguoiMuaHang1 = new JLabel("");
		lblNguoiMuaHang1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNguoiMuaHang1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNguoiMuaHang1.setBounds(18, 675, 157, 30);
		panel.add(lblNguoiMuaHang1);
		
	}
	
	public void printingHoaDon() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if(ok) {
			try {
				job.print();
			} catch (Exception e2) {
					// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
			Graphics2D g2d = (Graphics2D) graphics;
			if(pageIndex>0) {
				return NO_SUCH_PAGE;
			}
			g2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
			panel.printAll(graphics);
			return PAGE_EXISTS;
		}
}
