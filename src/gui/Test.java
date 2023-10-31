package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import commons.GradientPanel;
import commons.MyButton;
import commons.PanelButton;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import java.awt.Component;

/**
 * 
 * @author Nguyễn Gia Bảo, Ngô Quốc Đạt, Nguyễn Nhất Dương, Võ Văn Nghĩa Hiệp
 * @version 1.0
 *
 */

public class Test extends JFrame implements ActionListener{
	
	private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private JPanel contentPane;
	private PanelButton btnTrangChu;
	private GradientPanel panelWest;
	private PanelButton btnHoTro;
	private PanelButton btnNhanVien;
	private PanelButton btnCongNhan;
	private MyButton btnTaiKhoan;
	private int viTriButtonHienTai;
	private ArrayList<PanelButton> listItem;
	private JPanel listButton;
	private JLabel lblTenNhanVien;
	private JPanel panelCenter;
	private JPanel panelCNort;
	private static Test mainFrame = new Test();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			mainFrame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openMain_GUI() {
		mainFrame.setVisible(true);
//		resize();
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		int w = WIDTH;
		int h = HEIGHT;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 800);
		setExtendedState(Frame.MAXIMIZED_BOTH);
//		setSize(Toolkit.getDefaultToolkit().getScreenSize());
//		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		panelWest = new GradientPanel();
		panelWest.setLayout(new BorderLayout());
		panelWest.setSize(new Dimension((int)(w*0.18), this.getHeight()));
		panelWest.setPreferredSize(new Dimension((int)(w*0.18), h));
		panelWest.setkStartColor(Color.decode("#3494E6"));
		panelWest.setkGradientFocus(200);
		panelWest.setkEndColor(Color.decode("#EC6EAD"));
		contentPane.add(panelWest, BorderLayout.WEST);
		
		listButton = new JPanel();
		listButton.setOpaque(false);
		listButton.setLayout(new GridLayout(10, 1, 0, 10));
		panelWest.add(listButton, BorderLayout.CENTER);
		
		Image logo = new ImageIcon(Test.class.getResource("/icon/logo.png")).getImage().getScaledInstance((int)(w*0.1), (int)(w*0.1), Image.SCALE_SMOOTH);
		ImageIcon logoIcon = new ImageIcon(logo);
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(new Color(255, 255, 255));
		panelLogo.setSize(new Dimension((int) (w*0.14), (int) (w*0.14)));
		panelLogo.setPreferredSize(new Dimension((int) (w*0.18), (int) (w*0.1)));
		panelLogo.setOpaque(false);
		panelLogo.setLayout(new BorderLayout());
		panelWest.add(panelLogo, BorderLayout.NORTH);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(logoIcon);
//		lblLogo.setHorizontalAlignment(h)
		panelLogo.add(lblLogo);
		
		panelCenter = new JPanel();
		panelCenter.setSize(new Dimension((int) (w*0.82), h));
		
		panelCenter.setLayout(new BorderLayout());
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		panelCNort = new JPanel();
		panelCNort.setBorder(null);
		panelCNort.setBackground(new Color(228, 228, 228));
		panelCNort.setSize(panelCenter.getWidth(), (int)(h*0.06));
		panelCNort.setPreferredSize(new Dimension(panelCenter.getWidth(), (int)(h*0.06)));
		panelCenter.add(panelCNort, BorderLayout.NORTH);
		panelCNort.setLayout(new BorderLayout());
		
		// avt nhân viên
		
		// Nơi hiển thị tên nhân viên và chức vụ
//		lblTenNhanVien = new JLabel("-");
//		lblTenNhanVien.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
//		lblTenNhanVien.setPreferredSize(new Dimension((int)(panelCNort.getWidth()*0.3), panelCNort.getHeight()));
//		lblTenNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
//		panelCNort.add(lblTenNhanVien, BorderLayout.EAST);
		
		// Panel chứa nội dung 
		JPanel panelContent = new JPanel();
		panelContent.setSize(panelCenter.getWidth(), panelCenter.getHeight() - panelCNort.getHeight());
		panelCenter.add(panelContent, BorderLayout.CENTER);
		
		themButton();
	}
	
	/**
	 * Khởi tạo và thêm các button vào trong menu
	 */
	public void themButton() {
		btnTrangChu = new PanelButton();
		btnTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setButtonColor(0);
			}
		});
		listButton.add(btnTrangChu);
		
		btnCongNhan = new PanelButton();
		btnCongNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setButtonColor(1);
			}
		});
		listButton.add(btnCongNhan);
		
		btnNhanVien = new PanelButton();
		btnNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setButtonColor(2);
			}
		});
		listButton.add(btnNhanVien);
		
		btnHoTro = new PanelButton();
		btnHoTro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setButtonColor(3);
			}
		});
		listButton.add(btnHoTro);
		// Nút trang chủ
		JLabel lblTrangChuIcon = new JLabel();
		lblTrangChuIcon.setIcon(new ImageIcon(Test.class.getResource("/icon/home.png")));
		lblTrangChuIcon.setBounds(20, 8, 40, 40);
		btnTrangChu.add(lblTrangChuIcon);
		
		JLabel lblTrangChu = new JLabel("Trang chủ");
		lblTrangChu.setForeground(Color.WHITE);
		lblTrangChu.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblTrangChu.setBounds(100, 14, 122, 27);
		btnTrangChu.add(lblTrangChu);
		
		// Nút công nhân
		JLabel lblCongNhanIcon = new JLabel();
		lblCongNhanIcon.setIcon(new ImageIcon(Test.class.getResource("/icon/worker.png")));
		lblCongNhanIcon.setBounds(20, 8, 40, 40);
		btnCongNhan.add(lblCongNhanIcon);
		
		JLabel lblCongNhan = new JLabel("Công nhân");
		lblCongNhan.setForeground(Color.WHITE);
		lblCongNhan.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblCongNhan.setBounds(100, 14, 122, 27);
		btnCongNhan.add(lblCongNhan);
		
		// Nút nhân viên
		JLabel lblNhanVienIcon = new JLabel();
		lblNhanVienIcon.setIcon(new ImageIcon(Test.class.getResource("/icon/person.png")));
		lblNhanVienIcon.setBounds(20, 8, 40, 40);
		btnNhanVien.add(lblNhanVienIcon);
		
		JLabel lblNhanVien = new JLabel("Nhân viên");
		lblNhanVien.setForeground(Color.WHITE);
		lblNhanVien.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblNhanVien.setBounds(100, 14, 122, 27);
		btnNhanVien.add(lblNhanVien);
		
		// Nút hỗ trợ
		JLabel lblHoTroIcon = new JLabel();
		lblHoTroIcon.setIcon(new ImageIcon(Test.class.getResource("/icon/icons8_help_40px.png")));
		lblHoTroIcon.setBounds(20, 8, 40, 40);
		btnHoTro.add(lblHoTroIcon);
		
		JLabel lblHoTro = new JLabel("Hỗ trợ");
		lblHoTro.setForeground(Color.WHITE);
		lblHoTro.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblHoTro.setBounds(100, 14, 122, 27);
		btnHoTro.add(lblHoTro);
		
		// List button
		listItem = new ArrayList<PanelButton>();
		listItem.add(btnTrangChu);
		listItem.add(btnCongNhan);
		listItem.add(btnNhanVien);
		listItem.add(btnHoTro);

		viTriButtonHienTai = -1;
		
		//Nút tài khoản
		btnTaiKhoan = new MyButton();
		btnTaiKhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTaiKhoan.setFocusPainted(false);
		btnTaiKhoan.setRadius(50);
		btnTaiKhoan.setPreferredSize(new Dimension(panelCNort.getHeight(), panelCNort.getHeight()));
		Image avt = new ImageIcon(Test.class.getResource("/images/profile.png")).getImage().getScaledInstance(panelCNort.getHeight(), panelCNort.getHeight(), Image.SCALE_SMOOTH);
		btnTaiKhoan.setIcon(new ImageIcon(avt));
		panelCNort.add(btnTaiKhoan, BorderLayout.EAST);
	}
	
	/**
	 * Mở login ui
	 */
	private void openLogin_GUI() {
		Login_GUI.openLogin_GUI();
	}
	
	private void setButtonColor(int viTri) {
		PanelButton menuItem = new PanelButton();
		if(viTriButtonHienTai != -1) {
			menuItem = listItem.get(viTriButtonHienTai);
			menuItem.setSelected(false);
			repaint();
		}
		viTriButtonHienTai = viTri;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}