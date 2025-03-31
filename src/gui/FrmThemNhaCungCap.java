/* Người làm: Nguyễn Minh Thuận*/
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.NhaCungCapDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

public class FrmThemNhaCungCap extends JFrame  {

	private JPanel contentPane;
	public static JTextField txtTen;
	public static JTextField txtSDT;
	public static JTextField txtEmail;
	private JButton btnThem;
	private NhaCungCapDAO dao = new NhaCungCapDAO();
	private List<String> listDiaChi= new ArrayList<String>();
	private DefaultComboBoxModel cboModleDiaChi= new DefaultComboBoxModel();
	private JTextField txtSoNha;
	private JTextField txtTenDuong;
	private JTextField txtPhuong;
	private JTextField txtQuan;
	private JTextField txtThanhPho;
	private JTextField txtQuocGia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThemNhaCungCap frame = new FrmThemNhaCungCap();
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
	public FrmThemNhaCungCap() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 500, 650);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135,210,250));
		panel.setBounds(0, 0, 500, 70);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("NHÀ CUNG CẤP");
		lblNewLabel.setForeground(new Color(0, 0, 200));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		panel.add(lblNewLabel);
		
		JLabel lblTen = new JLabel("Nhà cung cấp:");
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTen.setBounds(10, 90, 140, 30);
		contentPane.add(lblTen);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSDT.setBounds(10, 140, 140, 30);
		contentPane.add(lblSDT);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmail.setBounds(10, 195, 90, 30);
		contentPane.add(lblEmail);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDiaChi.setBounds(10, 245, 90, 30);
		contentPane.add(lblDiaChi);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTen.setBounds(160, 96, 270, 20);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(160, 148, 270, 20);
		contentPane.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(160, 200, 270, 20);
		contentPane.add(txtEmail);
		
		btnThem = new JButton("");
		
		btnThem.setBackground(Color.WHITE);
		btnThem.setForeground(Color.BLACK);
		btnThem.setIcon(new ImageIcon("Hinh\\iconSave.png"));
		btnThem.setBounds(114, 531, 90, 35);
		contentPane.add(btnThem);
		
		JLabel lblSoNha = new JLabel("Số Nhà :");
		lblSoNha.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSoNha.setBounds(10, 285, 90, 30);
		contentPane.add(lblSoNha);
		
		txtSoNha = new JTextField();
		txtSoNha.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoNha.setColumns(10);
		txtSoNha.setBounds(160, 290, 270, 20);
		contentPane.add(txtSoNha);
		
		JLabel lblTenDuong = new JLabel("Tên đường :");
		lblTenDuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenDuong.setBounds(10, 325, 90, 30);
		contentPane.add(lblTenDuong);
		
		txtTenDuong = new JTextField();
		txtTenDuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenDuong.setColumns(10);
		txtTenDuong.setBounds(160, 330, 270, 20);
		contentPane.add(txtTenDuong);
		
		JLabel lblPhuong = new JLabel("Phường/xã :");
		lblPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPhuong.setBounds(10, 365, 90, 30);
		contentPane.add(lblPhuong);
		
		txtPhuong = new JTextField();
		txtPhuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhuong.setColumns(10);
		txtPhuong.setBounds(160, 370, 270, 20);
		contentPane.add(txtPhuong);
		
		JLabel lblQuan = new JLabel("Quận/huyện:");
		lblQuan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuan.setBounds(10, 405, 140, 30);
		contentPane.add(lblQuan);
		
		txtQuan = new JTextField();
		txtQuan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtQuan.setColumns(10);
		txtQuan.setBounds(160, 410, 270, 20);
		contentPane.add(txtQuan);
		
		JLabel lblThanhPho = new JLabel("Thành phố :");
		lblThanhPho.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblThanhPho.setBounds(10, 445, 140, 30);
		contentPane.add(lblThanhPho);
		
		txtThanhPho = new JTextField();
		txtThanhPho.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtThanhPho.setColumns(10);
		txtThanhPho.setBounds(160, 450, 270, 20);
		contentPane.add(txtThanhPho);
		
		JLabel lblQuocGia = new JLabel("Quốc gia :");
		lblQuocGia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuocGia.setBounds(10, 485, 90, 30);
		contentPane.add(lblQuocGia);
		
		txtQuocGia = new JTextField();
		txtQuocGia.setHorizontalAlignment(SwingConstants.LEFT);
		txtQuocGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtQuocGia.setColumns(10);
		txtQuocGia.setBounds(160, 490, 270, 20);
		contentPane.add(txtQuocGia);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(Color.BLACK);
		btnThoat.setBackground(Color.WHITE);
		btnThoat.setBounds(270, 550, 90, 35);
		btnThem.setBounds(160, 550, 90, 35);
		contentPane.add(btnThoat);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				them();
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}
	/**
	 * Dùng để lấy dự liệu vào thêm vào cơ sở dữ liệu
	 */
	public void them() {
		if(kiemTra()==true) {
			String soNha =txtSoNha.getText();
			System.out.println(soNha);
			String tenDuong = txtTenDuong.getText();
			System.out.println(tenDuong);
			String phuong =txtPhuong.getText();
			String quan =txtQuan.getText();
			String thanhPho =txtQuan.getText();
			String quocGia =txtQuocGia.getText();
			dao.themDiaChi(soNha, tenDuong, phuong, quan, thanhPho, quocGia);
			List<Integer> maDC= dao.getMaDiaChi(soNha, tenDuong, phuong, quan, thanhPho, quocGia);
			String ten=txtTen.getText();
			String soDienThoai = txtSDT.getText();
			String email= txtEmail.getText();
			System.out.println(maDC);
			System.out.println(maDC.get(0));
			dao.them(ten, soDienThoai, email, maDC.get(0));
			JOptionPane.showMessageDialog(this , "Thêm nhà cung cấp thành công");
			setVisible(false);
			FrmThuoc.cmbNCC.setSelectedItem(ten);
		}
		else 
			return;
	}
	/**
	 * Kiểm tra các dữ liệu
	 * @return true nếu dữ liệu nhập đúng
	 * @return false nếu dữ liệu sai
	 */
	public boolean kiemTra() {
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtTen.requestFocus();
			txtTen.selectAll();
			return false;
		}
		else if (txtSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		else if (txtSDT.getText().matches("^[0]\\d{9}$") == false) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại nhà cung cấp bằng số và gồm 10 chữ số bất đầu bằng số 0 !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return false;
		}
		else if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập email nhà cung cấp ! ", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		}
        else if (txtEmail.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") == false) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng email nhà cung cấp !\\n ví dụ:quoc@gmail.com ", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		}
		else if (txtSoNha.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtSoNha.requestFocus();
			txtSoNha.selectAll();
			return false;
		}
		else if (txtTenDuong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtTenDuong.requestFocus();
			txtTenDuong.selectAll();
			return false;
		}
		else if (txtPhuong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtPhuong.requestFocus();
			txtPhuong.selectAll();
			return false;
		}
		
		else if (txtQuan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtQuan.requestFocus();
			txtQuan.selectAll();
			return false;
		}
		else if (txtThanhPho.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtQuan.requestFocus();
			txtQuan.selectAll();
			return false;
		}
		else if (txtQuocGia.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhà cung cấp !", "Thông báo !", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("Hinh\\warning.png"));
			txtQuan.requestFocus();
			txtQuan.selectAll();
			return false;
		}
		return true;
	}
}
