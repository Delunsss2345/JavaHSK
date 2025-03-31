/* Người làm: Nguyễn Minh Thuận*/
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrmThemDiaChiKhachHang extends JFrame implements ActionListener,KeyListener {

	private JPanel contentPane;
	public static JTextField txtSoNha;
	public static JTextField txtTenDuong;
	public static JTextField txtPhuong;
	public static JTextField txtQuan;
	public static JTextField txtThanhPho;
	public static JTextField txtQuocGia;
	private JButton btnThemDiaChi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThemDiaChiKhachHang frame = new FrmThemDiaChiKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmThemDiaChiKhachHang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 500, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(135,210,250));
		panel.setBounds(0, 0, 488, 75);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Địa Chỉ Khách Hàng");
		lblNewLabel.setForeground(new Color(0, 0, 200));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		
		panel.add(lblNewLabel);

		JLabel lblSNh = new JLabel("Số Nhà :");
		lblSNh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSNh.setBounds(10, 90, 90, 30);
		contentPane.add(lblSNh);

		JLabel lblTnng = new JLabel("Tên đường:");
		lblTnng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTnng.setBounds(10, 142, 90, 30);
		contentPane.add(lblTnng);

		JLabel lblPhng = new JLabel("Phường/Xã:");
		lblPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPhng.setBounds(10, 195, 100, 30);
		contentPane.add(lblPhng);

		JLabel lblQun = new JLabel("Quận/Huyện:");
		lblQun.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQun.setBounds(10, 245, 100, 30);
		contentPane.add(lblQun);

		JLabel lblThnhPh = new JLabel("Thành phố:");
		lblThnhPh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblThnhPh.setBounds(10, 300, 90, 30);
		contentPane.add(lblThnhPh);

		JLabel lblQucGia = new JLabel("Quốc gia:");
		lblQucGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQucGia.setBounds(10, 350, 90, 30);
		contentPane.add(lblQucGia);

		txtSoNha = new JTextField();
		txtSoNha.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtSoNha.setBounds(120, 96, 330, 20);
		contentPane.add(txtSoNha);
		txtSoNha.setColumns(10);

		txtTenDuong = new JTextField();
		txtTenDuong.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtTenDuong.setColumns(10);
		txtTenDuong.setBounds(120, 150, 330, 20);
		contentPane.add(txtTenDuong);

		txtPhuong = new JTextField();
		txtPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtPhuong.setColumns(10);
		txtPhuong.setBounds(120, 200, 330, 20);
		contentPane.add(txtPhuong);

		txtQuan = new JTextField();
		txtQuan.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtQuan.setColumns(10);
		txtQuan.setBounds(120, 250, 330, 20);
		contentPane.add(txtQuan);

		txtThanhPho = new JTextField();
		txtThanhPho.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtThanhPho.setColumns(10);
		txtThanhPho.setBounds(120, 305, 330, 20);
		contentPane.add(txtThanhPho);

		txtQuocGia = new JTextField();
		txtQuocGia.setHorizontalAlignment(SwingConstants.LEFT);
		txtQuocGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtQuocGia.setColumns(10);
		txtQuocGia.setBounds(120, 355, 330, 20);
		contentPane.add(txtQuocGia);

		btnThemDiaChi = new JButton("");

		btnThemDiaChi.setBackground(new Color(255, 255, 255));
		btnThemDiaChi.setForeground(new Color(50, 205, 50));
		btnThemDiaChi.setIcon(new ImageIcon("Hinh\\iconSave.png"));
		btnThemDiaChi.setBounds(220, 400, 100, 50);
		contentPane.add(btnThemDiaChi);
		btnThemDiaChi.addActionListener(this);
		contentPane.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnThemDiaChi)) {
			String soNha = txtSoNha.getText();
			String duong = txtTenDuong.getText();
			String phuong = txtPhuong.getText();
			String quan = txtQuan.getText();
			String thanhPho = txtThanhPho.getText();
			String quocGia = txtQuocGia.getText();
			String diaChi = soNha+" " + duong+"," +phuong+","+quan+","+thanhPho+","+quocGia;
			FrmLapHoaDon.txtDChi.setText(diaChi);
			this.setVisible(false);
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
}
