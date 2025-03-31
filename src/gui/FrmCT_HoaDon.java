/* Người làm: Phạm Đăng Khôi*/
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dialog.ModalExclusionType;

public class FrmCT_HoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHD;
	private JTextField txtDonGia;
	private JTextField txtGiamGia;
	private JTextField txtMaThuoc;
	private JTextField txtDonViTinh;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel tablemodel2 = new DefaultTableModel();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCT_HoaDon frame = new FrmCT_HoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrmCT_HoaDon() {
		setTitle("THÔNG TIN CHI TIẾT HOÁ ĐƠN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 814, 550);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 794, 71);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(255, 250, 255));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN CHI TIẾT HOÁ ĐƠN");
		lblNewLabel.setForeground(new Color(0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(268, 11, 356, 49);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 93, 794, 178);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new TitledBorder(null, "Thông tin chi tiết hoá đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 11, 761, 156);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblMaHD = new JLabel("Mã hoá đơn");
		lblMaHD.setBounds(31, 37, 69, 14);
		panel_3.add(lblMaHD);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(120, 34, 141, 31);
		panel_3.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		JLabel lblMThuc = new JLabel("Mã thuốc");
		lblMThuc.setBounds(271, 37, 88, 14);
		panel_3.add(lblMThuc);
		
		JLabel lblSLng = new JLabel("Số Lượng");
		lblSLng.setBounds(497, 37, 88, 14);
		panel_3.add(lblSLng);
		
		JLabel lblnGi = new JLabel("Đơn Giá");
		lblnGi.setBounds(31, 104, 69, 14);
		panel_3.add(lblnGi);
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(120, 96, 141, 31);
		panel_3.add(txtDonGia);
		
		JLabel lblGimGi = new JLabel("Giảm Giá");
		lblGimGi.setBounds(271, 104, 88, 14);
		panel_3.add(lblGimGi);
		
		JLabel lblnVTnh = new JLabel("Đơn Vị Tính");
		lblnVTnh.setBounds(484, 104, 88, 14);
		panel_3.add(lblnVTnh);
		
		txtGiamGia = new JTextField();
		txtGiamGia.setColumns(10);
		txtGiamGia.setBounds(327, 96, 141, 31);
		panel_3.add(txtGiamGia);
		
		txtMaThuoc = new JTextField();
		txtMaThuoc.setColumns(10);
		txtMaThuoc.setBounds(327, 34, 141, 31);
		panel_3.add(txtMaThuoc);
		
		txtDonViTinh = new JTextField();
		txtDonViTinh.setColumns(10);
		txtDonViTinh.setBounds(568, 96, 141, 31);
		panel_3.add(txtDonViTinh);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(568, 34, 141, 31);
		panel_3.add(textField);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 282, 794, 257);
		panel.add(scrollPane);
		
		table = new JTable();
		String[] tq = new String[] {"STT","Mã Hóa Đơn","Mã Thuốc","Đơn Giá","Giảm Giá","Số Lượng","Đơn Vị Tính"};
		tablemodel2 = new DefaultTableModel(tq, 0);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã Hóa Đơn", "Mã Thuốc","Đơn Giá","Giảm Giá","Số Lượng","Đơn Vị Tính"
			}
		));
		scrollPane.setViewportView(table);
	}
}
