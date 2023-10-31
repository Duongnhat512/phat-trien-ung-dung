package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import commons.GradientPanel;
import commons.MenuEvent;
import commons.MyButton;
import commons.MyMenu;
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
	private GradientPanel panelWest;
	private MyButton btnTaiKhoan;
	private int viTriButtonHienTai;
	private JLabel lblTenNhanVien;
	private JPanel panelCenter;
	private JPanel panelCNort;
	private MyMenu menu;
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
		
		menu = new MyMenu();
		panelWest.add(menu);
		//Đăng ký sự kiện cho menu
		menu.setEvent(new MenuEvent() {
			@Override
			public void selected(int index, int subIndex) {
				
			}
		});
		
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
		
	}

	
	/**
	 * Mở login ui
	 */
	private void openLogin_GUI() {
		Login_GUI.openLogin_GUI();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}