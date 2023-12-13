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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import bus.CongNhan_BUS;
import bus.NhanVien_BUS;
import bus.TaiKhoan_BUS;
import commons.GradientPanel;
import commons.RoundPanel;
import connectDB.ConnectDB;
import entities.CongNhan;
import entities.NhanVien;
import entities.TaiKhoan;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;
import java.awt.Toolkit;

public class Password_GUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pRight;
	private JButton btnDangNhap;
	private GradientPanel panel;
	private JTextField txtEmail;
	private JTextField txtOtp;
	private  JLabel lblThongBao;
	private TaiKhoan_BUS taiKhoan_BUS = new TaiKhoan_BUS();
	private JButton btnOTP;
	private static String otp;
	private TaiKhoan_BUS tk_bus;
	private CongNhan_BUS cn_bus;
	private NhanVien_BUS nv_bus;
	private static final int OTP_DURATION = 60; // Thời gian tồn tại của OTP (giây)
    private static int remainingTime = OTP_DURATION;
	protected static Password_GUI frame;
	private JPasswordField txtPass;
	private JButton btnToggleIcon;
	private boolean passwordVisible;
	private BufferedImage visibleImage;
	private BufferedImage hiddenImage;
	private JButton btnTroVe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		openPassword_GUI();
	}

	public static void openPassword_GUI() {
		frame = new Password_GUI();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Password_GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Password_GUI.class.getResource("/icon/logo.png")));
		tk_bus = new TaiKhoan_BUS();
		cn_bus = new CongNhan_BUS();
		nv_bus = new NhanVien_BUS();
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

		JLabel lbLogin = new JLabel("Quên Mật Khẩu ?");
		lbLogin.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lbLogin.setBounds(130, 26, 279, 44);
		pRight.add(lbLogin);

		JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(21, 245, 117, 21);
		pRight.add(lblNewLabel_1);

		JLabel lbMatKhau = new JLabel("Mã OTP");
		lbMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbMatKhau.setBounds(21, 174, 94, 21);
		pRight.add(lbMatKhau);

		txtEmail = new JTextField();
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtEmail.setBounds(152, 128, 279, 30);

		pRight.add(txtEmail);
		txtEmail.setColumns(10);

		btnDangNhap = new JButton();
		btnDangNhap.setText("Xác Nhận");
		btnDangNhap.setIcon(new ImageIcon(Password_GUI.class.getResource("/icon/icons8_enter_25px.png")));
		btnDangNhap.setOpaque(true);
		btnDangNhap.setBackground(new Color(23, 191, 86));
		btnDangNhap.setBorder(null);
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnDangNhap.setBounds(152, 294, 160, 38);
		btnDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pRight.add(btnDangNhap);

		txtOtp = new JTextField();
		txtOtp.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtOtp.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtOtp.setBounds(152, 172, 134, 30);
		pRight.add(txtOtp);

		lblThongBao = new JLabel("");
		lblThongBao.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setBounds(152, 212, 279, 21);
		pRight.add(lblThongBao);

		btnOTP = new JButton("Gửi Mã OTP");
		btnOTP.setBounds(294, 174, 137, 28);
		pRight.add(btnOTP);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(21, 130, 117, 21);
		pRight.add(lblNewLabel_1_1);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtPass.setColumns(10);
		txtPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPass.setBounds(152, 236, 279, 30);
		pRight.add(txtPass);
		
		btnToggleIcon = new JButton("");
		btnToggleIcon.setBounds(439, 236, 36, 30);
		pRight.add(btnToggleIcon);
		String projectDirectory = System.getProperty("user.dir");
        try {
             visibleImage = ImageIO.read(new File(projectDirectory+"\\src\\icon\\icons8_eye_25px.png")); // Đường dẫn hình ảnh mắt mở
             hiddenImage = ImageIO.read(new File(projectDirectory+"\\src\\icon\\hidden_eye.png")); // Đường dẫn hình ảnh mắt đóng

            btnToggleIcon.setIcon(new ImageIcon(resizeImage(hiddenImage, 36, 30))); // Đặt kích thước cho hình ảnh mắt mở
            btnToggleIcon.setDisabledIcon(new ImageIcon(resizeImage(visibleImage, 36, 30))); // Đặt kích thước cho hình ảnh mắt đóng
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        btnTroVe = new JButton("Trở Về");
        btnTroVe.setBackground(new Color(255, 0, 0));
        btnTroVe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnTroVe.setForeground(new Color(255, 255, 255));
        btnTroVe.setBounds(355, 294, 85, 38);
        pRight.add(btnTroVe);
    	btnToggleIcon.setBackground(null);
		btnToggleIcon.setBorder(null);
        passwordVisible = false;
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(Password_GUI.class.getResource("/icon/logo_Login.png")));
		lbLogo.setBounds(161, 143, 412, 363);
		panel.add(lbLogo);
		//
		try {
			ConnectDB.getInstance().connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Đăng ký sự kiện
		btnDangNhap.addActionListener(this);
		btnOTP.addActionListener(this);
		btnTroVe.addActionListener(this);
		btnToggleIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	passwordVisible = !passwordVisible;
            	if (passwordVisible) {
                    txtPass.setEchoChar((char) 0); // Hiện password
                    btnToggleIcon.setIcon(new ImageIcon(resizeImage(visibleImage, 36, 30)));
                } else {
                	txtPass.setEchoChar('\u2022'); // Ẩn password
                	btnToggleIcon.setIcon(new ImageIcon(resizeImage(hiddenImage,36, 30)));
                }
            }
        });
	}


	private void moLogin() {
		Login_GUI login_GUI = new Login_GUI();
		login_GUI.openLogin_GUI();
		;
		this.dispose();
	}

	public static void sendEmail(String toEmail, String subject, String body) {
		final String username = "ngoquocdat0810@gmail.com"; // Thay bằng địa chỉ email của bạn
		final String password = "ozkc hoyu xosh kkxf"; // Thay bằng mật khẩu của bạn

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // Thay bằng SMTP host của bạn (ví dụ: smtp.gmail.com cho
														// Gmail)
		props.put("mail.smtp.port", "587"); // Port thường là 587 cho TLS

		// Tạo phiên làm việc (session) để gửi email
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		Session session = Session.getInstance(props, auth);


		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);
			System.out.println("Email sent successfully!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static String generateOTP() {
		int length = 6; // Độ dài của OTP
		String numbers = "0123456789"; // Các ký tự có thể có trong OTP
		Random random = new Random();
		StringBuilder otp = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(numbers.length());
			otp.append(numbers.charAt(index));
		}

		return otp.toString();
	}
    private static void startTimer(JButton timerLabel) {
    	Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (remainingTime > 0) {
                    remainingTime--;
                    timerLabel.setText(remainingTime+"(s)");
                } else {
                    timer.cancel(); // Hủy bộ đếm khi thời gian hết
                    timerLabel.setText("0(s) . Gửi lại mã");
                }
            }
        }, 1000L, 1000L); // Sử dụng 'L' để biểu thị kiểu long (1000L = 1 giây)
    }
    private static boolean verifyOTP(String enteredOTP,JLabel messLable) {
        if (remainingTime <= 0) {
        	messLable.setText("Mã OTP đã hết hạn.");
        	return false;
        } else if (enteredOTP.equals(otp)) {
        	messLable.setText("Xác nhận thành công!");
        	return true;
        } else {
        	messLable.setText("Mã OTP không hợp lệ.");
        	return false;
        }
    }
    private static Image resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return resultingImage;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			if(txtEmail.getText().trim().length()<=0) {
				JOptionPane.showMessageDialog(null, "Tên Tài Khoản không được để trống");
				return;
			}
			if(txtOtp.getText().trim().length()<=0) {
				JOptionPane.showMessageDialog(null, "Mã OTP không được để trống");
				return;
			}
			if(txtPass.getText().trim().length()<=0) {
				JOptionPane.showMessageDialog(null, "Password không được để trống");
				return;
			}
			String otpMes = txtOtp.getText();
			boolean check = verifyOTP(otpMes,lblThongBao);
			if(check) {
				String pass = txtPass.getText();
				boolean update = tk_bus.updatePassword(txtEmail.getText(), pass);
				if(update) {
					JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");
					moLogin();
				}
				if(!update) {
					JOptionPane.showMessageDialog(null, "Cập Nhật Thất Bại");
				}
			}
		}
		if (o.equals(btnOTP)) {
			otp = generateOTP();
			System.out.println(1);
			String tk = txtEmail.getText(); 
			String email = "";
			if(tk.contains("NV")) {
				NhanVien n = nv_bus.getNhanVienTheoID(tk);
				if(n.getEmail()!=null) {
					email = n.getEmail();					
				}
			}
			if(tk.contains("CN")) {
				CongNhan n = cn_bus.getCongNhanTheoID(tk);
				if(n.getEmail()!=null) {
					email = n.getEmail();					
				}
			}
			if(email.equals("")) {
				JOptionPane.showMessageDialog(null,"Thông tin tài khoản không tồn tại");
			}else {
				// Gửi OTP qua email
				sendEmail(email, "Your OTP", "Your OTP is: " + otp);

				JOptionPane.showMessageDialog(null, "Đã gửi OTP thành công");
				btnOTP.setText(remainingTime + " (s)");
				startTimer(btnOTP);
			}
		}
		if(o.equals(btnTroVe)) {
			moLogin();
		}
	}
}
