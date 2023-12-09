package gui;

/**
 * 
 * @author Nguyễn Gia Bảo, Ngô Quốc Đạt, Nguyễn Nhất Dương, Võ Văn Nghĩa Hiệp
 * @version 1.0
 *
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import bus.TaiKhoan_BUS;
import commons.GradientPanel;
import commons.RoundPanel;
import connectDB.ConnectDB;
import entities.TaiKhoan;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class Login_GUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel pRight;
	private JButton btnDangNhap;
	private GradientPanel panel;
	private JTextField textTenDangNhap;
	private JPasswordField passwordField;
	private JLabel lblThongBao;
	private TaiKhoan_BUS taiKhoan_BUS = new TaiKhoan_BUS();
	private BufferedImage visibleImage;
	private BufferedImage hiddenImage;
	private JButton btnToggleIcon;
	private boolean passwordVisible;
	protected static Login_GUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		openLogin_GUI();
	}
	
	public static void openLogin_GUI() {
		frame = new Login_GUI();
		frame.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public Login_GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login_GUI.class.getResource("/icon/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1163, 711);
		setLocationRelativeTo(null);
//		setUndecorated(true);
		setTitle("Phầm mềm quản lý lương sản phẩm");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new GradientPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBorder(null);
		panel.setBounds(0, 0, 1149, 674);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setkStartColor(Color.decode("#00d2ff"));
		panel.setkGradientFocus(50);
		panel.setkEndColor(Color.decode("#928DAB"));
		contentPane.add(panel);
		
		RoundPanel panel_2 = new RoundPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setRound(40);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBounds(597, 129, 517, 377);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		pRight = new JPanel();
		
		pRight.setBackground(new Color(255, 255, 255));
//		panel_1.setBackground(new Color(255, 255, 255));
		pRight.setBorder(new LineBorder(Color.WHITE));
		pRight.setOpaque(true);
		panel_2.add(pRight);
		pRight.setLayout(null);
		
		JLabel lbLogin = new JLabel("Đăng nhập");
		lbLogin.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lbLogin.setBounds(191, 27, 156, 44);
		pRight.add(lbLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 130, 108, 21);
		pRight.add(lblNewLabel_1);
		
		JLabel lbMatKhau = new JLabel("Mật khẩu:");
		lbMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbMatKhau.setBounds(30, 174, 94, 21);
		pRight.add(lbMatKhau);
		
		textTenDangNhap = new JTextField();
		textTenDangNhap.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textTenDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textTenDangNhap.setBounds(152, 128, 279, 30);
		
		pRight.add(textTenDangNhap);
		textTenDangNhap.setColumns(10);
		
		btnDangNhap = new JButton();
		btnDangNhap.setText("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon(Login_GUI.class.getResource("/icon/icons8_enter_25px.png")));
		btnDangNhap.setOpaque(true);
		btnDangNhap.setBackground(new Color(23, 191, 86));
		btnDangNhap.setBorder(null);
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnDangNhap.setBounds(152, 251, 279, 38);
		btnDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pRight.add(btnDangNhap);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(152, 172, 279, 30);
		pRight.add(passwordField);
		
		btnToggleIcon = new JButton("");
		btnToggleIcon.setBackground(null);
		btnToggleIcon.setBorder(null);
		btnToggleIcon.setBounds(433, 172, 36, 30);
		pRight.add(btnToggleIcon);
		
		JLabel lbQMK = new JLabel("Quên mật khẩu?\r\n");
		lbQMK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbQMK.setForeground(new Color(255, 0, 0));
		lbQMK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbQMK.setBounds(314, 311, 125, 21);
		pRight.add(lbQMK);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(Login_GUI.class.getResource("/icon/logo_Login.png")));
		lbLogo.setBounds(161, 143, 412, 363);
		panel.add(lbLogo);
<<<<<<< HEAD
		
		
		textTenDangNhap.setText("admin");
		passwordField.setText("1111");
		
=======
		String projectDirectory = System.getProperty("user.dir");
        try {
             visibleImage = ImageIO.read(new File(projectDirectory+"\\src\\icon\\icons8_eye_25px.png")); // Đường dẫn hình ảnh mắt mở
             hiddenImage = ImageIO.read(new File(projectDirectory+"\\src\\icon\\hidden_eye.png")); // Đường dẫn hình ảnh mắt đóng

            btnToggleIcon.setIcon(new ImageIcon(resizeImage(hiddenImage, 36, 30))); // Đặt kích thước cho hình ảnh mắt mở
            btnToggleIcon.setDisabledIcon(new ImageIcon(resizeImage(visibleImage, 36, 30))); // Đặt kích thước cho hình ảnh mắt đóng
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        passwordVisible = false;
        btnToggleIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	passwordVisible = !passwordVisible;
            	if (passwordVisible) {
            		passwordField.setEchoChar((char) 0); // Hiện password
                    btnToggleIcon.setIcon(new ImageIcon(resizeImage(visibleImage,36, 30)));
                } else {
                	passwordField.setEchoChar('\u2022'); // Ẩn password
                	btnToggleIcon.setIcon(new ImageIcon(resizeImage(hiddenImage, 36, 30)));
                }
            }
        });
		
		//
>>>>>>> 3424301e5ed6b6fcaaabd3d21cbee7e10f4612fb
		try {
			ConnectDB.getInstance().connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Đăng ký sự kiện
		btnDangNhap.addActionListener(this);
		btnDangNhap.addActionListener(this);
	}
    private static Image resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return resultingImage;
    }
	private boolean kiemTraDangNhap() {
		String tenTaiKhoan = textTenDangNhap.getText();
		@SuppressWarnings("deprecation")
		String matKhau = passwordField.getText();
		if(tenTaiKhoan.trim().length() == 0) {
			lblThongBao.setText("Vui lòng điền tên đăng nhập!");
			return false;
		}
		else if (matKhau.trim().length() == 0) {
			lblThongBao.setText("Vui lòng điền mật khẩu!");
			return false;
		}
		TaiKhoan tk = taiKhoan_BUS.getTaiKhoan(tenTaiKhoan);
		if(tk == null || matKhau.compareTo(tk.getMatKhau()) != 0) {
			lblThongBao.setText("Thông tin tài khoản hoặc mật khẩu không chính xác!");
			return false;
		}
		return true;
	}
	
	private void moTrangChu() {
		Main_GUI main_GUI = new Main_GUI();
		main_GUI.openMain_GUI();;
		frame.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDangNhap)) {
			if(kiemTraDangNhap()) {
<<<<<<< HEAD
				moTrangChu();
=======
			moTrangChu();
>>>>>>> 3424301e5ed6b6fcaaabd3d21cbee7e10f4612fb
			}
		}
	}
}
