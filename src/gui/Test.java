package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import commons.GradientPanel;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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

	private JPanel contentPane;
	private PanelButton btnTrangChu;
	private GradientPanel panelWest;
	private PanelButton btnDangXuat;
	private PanelButton btnHoTro;
	private PanelButton btnTaiKhoan;
	private PanelButton btnNhanVien;
	private PanelButton btnCongNhan;
	private int viTriButtonHienTai;
	private ArrayList<PanelButton> listItem;
	private JLabel lblLogo;
	private JPanel listButton;
	private JLabel lblTenNhanVien;
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
		panelWest.setSize(new Dimension(282, 871));
		panelWest.setPreferredSize(new Dimension(282, 871));
		panelWest.setkStartColor(Color.decode("#3494E6"));
		panelWest.setkGradientFocus(200);
		panelWest.setkEndColor(Color.decode("#EC6EAD"));
		contentPane.add(panelWest, BorderLayout.WEST);
		
		listButton = new JPanel();
		listButton.setOpaque(false);
		listButton.setLayout(new GridLayout(10, 1, 0, 10));
		panelWest.add(listButton, BorderLayout.CENTER);
		
		lblLogo = new JLabel();
		Image logo = new ImageIcon(Test.class.getResource("/icon/logo.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon logoIcon = new ImageIcon(logo);
		lblLogo.setIcon(logoIcon);
//		lblLogo.setBounds(10, 10, 100, 100);
//		lblLogo.setPreferredSize(new Dimension(282, 150));
		lblLogo.setPreferredSize(new Dimension(panelWest.getWidth(), (int)(panelWest.getHeight()*0.2)));
		panelWest.add(lblLogo, BorderLayout.NORTH);
		btnTrangChu = new PanelButton();
		btnTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setButtonColor(0);
			}
		});
//		btnTrangChu.setBounds(0, 205, 282, 55);
		listButton.add(btnTrangChu);
		
		btnCongNhan = new PanelButton();
		btnCongNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setButtonColor(1);
			}
		});
//		btnCongNhan.setBounds(0, 270, 282, 55);
		listButton.add(btnCongNhan);
		
		btnNhanVien = new PanelButton();
		btnNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setButtonColor(2);
			}
		});
//		btnNhanVien.setBounds(0, 335, 282, 55);
		listButton.add(btnNhanVien);
		
//		btnTaiKhoan = new PanelButton();
//		btnTaiKhoan.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				setButtonColor(3);
//			}
//		});
//		listButton.add(btnTaiKhoan);
		
		btnHoTro = new PanelButton();
		btnHoTro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setButtonColor(3);
			}
		});
//		btnHoTro.setBounds(0, 465, 282, 55);
		listButton.add(btnHoTro);
		
//		btnDangXuat = new PanelButton();
//		btnDangXuat.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if((JOptionPane.showConfirmDialog(mainFrame, "Bạn có muốn thoát không?", "Hỏi nhắc", JOptionPane.YES_NO_OPTION))== JOptionPane.YES_NO_OPTION) {
//					openLogin_GUI();
//					mainFrame.dispose();
//				}
//				btnDangXuat.setSelected(false);
//			}
//		});
//		btnDangXuat.setBounds(0, 695, 282, 55);
//		panelButton.add(btnDangXuat);
//		
//		JLabel lblDangXuat = new JLabel("Đăng xuất");
//		lblDangXuat.setBounds(98, 14, 122, 27);
//		lblDangXuat.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
//		lblDangXuat.setForeground(new Color(255, 255, 255));
//		btnDangXuat.add(lblDangXuat);
//		
//		JLabel lblDangXuatIcon = new JLabel();
//		lblDangXuatIcon.setIcon(new ImageIcon(Test.class.getResource("/icon/icons8_exit_40px_1.png")));
//		lblDangXuatIcon.setBounds(25, 8, 40, 40);
//		btnDangXuat.add(lblDangXuatIcon);
		
		
		JPanel panelCenter = new JPanel();
		panelCenter.setSize(new Dimension(1252, 763));
		
		panelCenter.setLayout(new BorderLayout());
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		JPanel panelCNort = new JPanel();
		panelCNort.setBorder(null);
		panelCNort.setBackground(new Color(228, 228, 228));
		panelCNort.setSize(1266, 40);
//		panel_1_1.setSize(panel_1.getMaximumSize().width, 40);
		panelCNort.setPreferredSize(new Dimension(panelCenter.getWidth(), (int)(panelCenter.getHeight()*0.06)));
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
		panelContent.setBounds(0, 38, 1250, 725);
		panelCenter.add(panelContent, BorderLayout.CENTER);
		
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
		
		// Nút tài khoản
//		JLabel lblTaiKhoanIcon = new JLabel();
//		lblTaiKhoanIcon.setIcon(new ImageIcon(Test.class.getResource("/icon/user.png")));
//		lblTaiKhoanIcon.setBounds(20, 8, 40, 40);
//		btnTaiKhoan.add(lblTaiKhoanIcon);
//		
//		JLabel lblTaiKhoan = new JLabel("Tài khoản");
//		lblTaiKhoan.setForeground(Color.WHITE);
//		lblTaiKhoan.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
//		lblTaiKhoan.setBounds(100, 14, 122, 27);
//		btnTaiKhoan.add(lblTaiKhoan);
		
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
//		listItem.add(btnTaiKhoan);
		listItem.add(btnHoTro);
		

		viTriButtonHienTai = -1;
		
		
		// Đăng ký sự kiện

		
	}
	
//	public void resize() {
//		panelWest.setSize(new Dimension((int)(mainFrame.getWidth()*0.18), mainFrame.getHeight()));
//		lblLogo.setPreferredSize(new Dimension(panelWest.getWidth(), (int)(panelWest.getHeight()*0.4)));
//		repaint();
//	}
	
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
