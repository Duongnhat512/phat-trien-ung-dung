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
import form.ChamCongCongNhan_Form;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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

public class Main_GUI extends JFrame implements ActionListener{
	
	private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private JPanel contentPane;
	private GradientPanel panelWest;
	private MyButton btnTaiKhoan;
	private JLabel lblTenNhanVien;
	private JPanel panelCenter;
	private JPanel panelCNort;
	private MyMenu menu;
	//Form
	private ChamCongCongNhan_Form chamCongCongNhan_Form;
	private JPanel panelContent;
	private MyButton btnAvt;
	private static Main_GUI mainFrame = new Main_GUI();
	
	public static void main(String[] args) {
		mainFrame.setVisible(true);
	}
	
	public void openMain_GUI() {
		mainFrame.setVisible(true);
//		resize();
	}

	/**
	 * Create the frame.
	 */
	public Main_GUI() {
		int w = WIDTH;
		int h = HEIGHT;
		
		setTitle("Phần mềm quản lý lương sản phẩm");
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
		panelWest.setkStartColor(Color.decode("#004e92"));
		panelWest.setkGradientFocus(500);
		panelWest.setkEndColor(Color.decode("#000428"));
		contentPane.add(panelWest, BorderLayout.WEST);
		
		// Khởi tạo menu
		initMenu();
		
		//Đăng ký sự kiện cho menu
		menu.setEvent(new MenuEvent() {
			@Override
			public void selected(int index, int subIndex) {
				moForm(index, subIndex);
			}
		});
		
		Image logo = new ImageIcon(Main_GUI.class.getResource("/icon/logo.png")).getImage().getScaledInstance((int)(w*0.1), (int)(w*0.1), Image.SCALE_SMOOTH);
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
//		btnAvt = new MyButton();
//		btnAvt.setPreferredSize(new Dimension(panelCNort.getHeight(), panelCNort.getHeight()));
//		Image avtImage = new ImageIcon(Main_GUI.class.getResource("/images/profile.png")).getImage().getScaledInstance(btnAvt.getWidth(), btnAvt.getHeight(), Image.SCALE_SMOOTH);
//		btnAvt.setIcon(logoIcon);
//		panelCNort.add(btnAvt, BorderLayout.EAST);
		
		// Panel chứa nội dung 
		panelContent = new JPanel();
		panelContent.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelCenter.add(panelContent, BorderLayout.CENTER);
		
		//Khởi tạo các form
		chamCongCongNhan_Form = new ChamCongCongNhan_Form(panelCenter.getWidth(), panelCenter.getHeight() - panelCNort.getHeight());
		
	}

	
	/**
	 * Mở login ui
	 */
	private void openLogin_GUI() {
		Login_GUI.openLogin_GUI();
	}
	
	private void initMenu() {
		String[][] menuAdmin = new String[][]{
			{"Trang chủ"},
			{"Công nhân", "Quản lý công nhân", "Chấm công công nhân", "Tính lương công nhân", "Thống kê lương", "Thống kê KPI"},
			{"Nhân viên", "Quản lý nhân viên", "Chấm công nhân viên", "Tính lương nhân viên", "Thống kê lương"},
			{"Hợp đồng"},
			{"Sản phẩm"},
			{"Hỗ trợ"}
		};
		menu = new MyMenu(menuAdmin);
		panelWest.add(menu);
		
	}
	
	/**
	 * Mở form
	 * @param index
	 * @param subIndex
	 */
	private void moForm(int index, int subIndex) {
		if(index == 0 && subIndex == 0) {
			
		}
		else if (index == 1) {
			if (subIndex == 1) {
				
			}
			else if(subIndex == 2){
				setForm(chamCongCongNhan_Form);
			}
		}
		else if(index == 2) {
			if (subIndex == 1) {
				
			}
			else if(subIndex == 2){
				
			}
		}
		else if(index == 3 && subIndex == 0) {
			moLinkHoTro();
		}
	}
	
	/**
	 * 
	 */
	private void setForm(JComponent component) {
		panelContent.removeAll();
		panelContent.add(component);
		panelContent.repaint();
		panelContent.revalidate();
	}
	
	/**
	 * Mở link hỗ trợ
	 */
	private void moLinkHoTro() {
		// Tạo một đối tượng URL cho link
        URL url = null;
		try {
			url = new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Tạo một đối tượng Desktop
        Desktop desktop = Desktop.getDesktop();

        // Sử dụng phương thức browse() của đối tượng Desktop để mở link
        try {
			desktop.browse(url.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}