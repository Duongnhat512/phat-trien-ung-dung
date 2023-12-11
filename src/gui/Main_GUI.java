package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.CongDoanSanPham_BUS;
import bus.NhanVien_BUS;

import java.awt.BorderLayout;
import java.awt.Color;

import commons.GradientPanel;
import commons.MenuEvent;
import commons.MyButton;
import commons.MyMenu;
import commons.PanelButton;
import connectDB.ConnectDB;
import dao.CongDoanSanPham_DAO;
import entities.NhanVien;
import entities.TaiKhoan;
import form.ChamCongCongNhan_Form;
import form.ChamCongNhanVien_Form;
import form.CongDoanPhanCong_Form;
import form.CongDoanSanPham_Form;
import form.QuanLyCongNhan_Form;
import form.QuanLyNhanVien_Form;
import form.QuanLySanPham_Form;
import form.QuanLyHopDong_Form;

import form.ThongKeKPI_Form;
import form.ThongKeLuongCongNhan_Form;
import form.ThongKeLuongNhanVien_Form;
import form.TinhLuongCongNhan_Form;
import form.TinhLuongNhanVien_Form;
import form.TrangChu_Form;

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
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
import java.awt.Container;
import javax.swing.SwingConstants;

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
	private CongDoanSanPham_Form congDoanSanPham_Form = null;
	private TrangChu_Form trangChu_Form = null;
	private ChamCongCongNhan_Form chamCongCongNhan_Form = null;
	private TinhLuongNhanVien_Form tinhLuongNhanVien_Form = null;
	private TinhLuongCongNhan_Form tinhLuongCongNhan_Form = null;
	private ChamCongNhanVien_Form chamCongNhanVien_Form = null;
	private QuanLyHopDong_Form quanLyHopDong_Form;
	private ThongKeKPI_Form thongKeKPI_form = null;
	private QuanLyCongNhan_Form quanLyCongNhan_Form = null;
	private QuanLyNhanVien_Form quanLyNhanVien_Form = null;
	private QuanLySanPham_Form quanLySanPham_Form = null;
	private ThongKeLuongNhanVien_Form thongKeLuongNhanVien_Form = null;
	private ThongKeLuongCongNhan_Form thongKeLuongCongNhan_Form = null;
	private CongDoanPhanCong_Form congDoanPhanCong_Form = null;
	//
	private JPanel panelContent;
	private MyButton btnAvt;
	private Container panel;
//	private static Main_GUI mainFrame = new Main_GUI();
	private TaiKhoan tk = new TaiKhoan();
	private NhanVien_BUS nv_BUS = new NhanVien_BUS();
	private NhanVien nv = new NhanVien();
	
	//
	private int[] currentIndex = new int[2];
	private JLabel lblTenNV;
	private MyButton btnDangXuat;
	
//	public static void main(String[] args) {
//		mainFrame.setVisible(true);
//	}
	
	public void openMain_GUI(TaiKhoan tk) {
		this.tk = tk;
		Main_GUI mainFrame = new Main_GUI();
		mainFrame.setVisible(true);
		hienThiTenNhanVien();
//		resize();
	}

	/**
	 * Create the frame.
	 */
	public Main_GUI() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main_GUI.class.getResource("/icon/logo.png")));
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
		lblLogo.setBounds(10, 10, 136, 130);
//		panel.add(lblLogo);
		
		panelCenter = new JPanel();
		panelCenter.setSize(new Dimension((int) (w*0.82), h));
		
		panelCenter.setLayout(new BorderLayout());
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		panelCNort = new JPanel();
		panelCNort.setBorder(null);
		panelCNort.setBackground(new Color(255, 255, 255));
		panelCNort.setSize(panelCenter.getWidth(), (int)(h*0.06));
		panelCNort.setPreferredSize(new Dimension(panelCenter.getWidth(), (int)(h*0.06)));
		panelCenter.add(panelCNort, BorderLayout.NORTH);
		panelCNort.setLayout(null);
		
		lblTenNV = new JLabel("");
		lblTenNV.setIcon(new ImageIcon(Main_GUI.class.getResource("/icon/picture_30px.png")));
		lblTenNV.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblTenNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNV.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTenNV.setBounds(668, 10, 518, 31);
		panelCNort.add(lblTenNV);
		
		btnDangXuat = new MyButton();
		btnDangXuat.setFocusPainted(false);
		btnDangXuat.setIcon(new ImageIcon(Main_GUI.class.getResource("/icon/icons8_Logout_30px_4.png")));
		btnDangXuat.setBackground(new Color(255, 0, 0));
		btnDangXuat.setRadius(40);
		btnDangXuat.setOpaque(false);
		btnDangXuat.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDangXuat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnDangXuat.setBounds(1196, 3, 45, 45);
		panelCNort.add(btnDangXuat);
		
//		 avt nhân viên
//		btnAvt = new MyButton();
//		btnAvt.setPreferredSize(new Dimension(panelCNort.getHeight(), panelCNort.getHeight()));
//		Image avtImage = new ImageIcon(Main_GUI.class.getResource("/images/profile.png")).getImage().getScaledInstance(btnAvt.getWidth(), btnAvt.getHeight(), Image.SCALE_SMOOTH);
//		btnAvt.setIcon(logoIcon);
//		panelCNort.add(btnAvt, BorderLayout.EAST);
		
		// Panel chứa nội dung 
		panelContent = new JPanel();
		panelContent.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelCenter.add(panelContent, BorderLayout.CENTER);
		
		// Kết nối đến database 
		try {
			ConnectDB.getInstance().connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		currentIndex[0] = 0;
		currentIndex[1] = 0;
		
		trangChu_Form = new TrangChu_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		quanLyCongNhan_Form = new QuanLyCongNhan_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		chamCongCongNhan_Form = new ChamCongCongNhan_Form(panelCenter.getWidth(), panelCenter.getHeight() - panelCNort.getHeight());
		tinhLuongCongNhan_Form = new TinhLuongCongNhan_Form(panelCenter.getWidth(), panelCenter.getHeight() - panelCNort.getHeight());
		thongKeLuongCongNhan_Form = new ThongKeLuongCongNhan_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		thongKeKPI_form = new ThongKeKPI_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		quanLyNhanVien_Form = new QuanLyNhanVien_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		chamCongNhanVien_Form = new ChamCongNhanVien_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		tinhLuongNhanVien_Form = new TinhLuongNhanVien_Form(panelCenter.getWidth(), panelCenter.getHeight() - panelCNort.getHeight());
		thongKeLuongNhanVien_Form = new ThongKeLuongNhanVien_Form(panelCenter.getWidth(), panelCenter.getHeight() - panelCNort.getHeight());
		quanLyHopDong_Form = new QuanLyHopDong_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		quanLySanPham_Form = new QuanLySanPham_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		congDoanSanPham_Form = new CongDoanSanPham_Form(panelCenter.getWidth(), panelCenter.getHeight()-panelCNort.getHeight());
		congDoanPhanCong_Form = new CongDoanPhanCong_Form();
		setForm(trangChu_Form);
		
		// Đăng ký sự kiện
		btnDangXuat.addActionListener(this);
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
			{"Sản phẩm", "Quản lý sản phẩm", "Chia công đoạn cho sản phẩm", "Phân công cho công nhân"},
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
			setForm(trangChu_Form);
		}
		else if (index == 1) {
			if (subIndex == 1) {
				setForm(quanLyCongNhan_Form);
			}
			else if(subIndex == 2){
				
				setForm(chamCongCongNhan_Form);
			}
			else if(subIndex == 3)
			{
				
				setForm(tinhLuongCongNhan_Form);
			}
			else if(subIndex == 4)
			{
				
				setForm(thongKeLuongCongNhan_Form);
			}
			else if(subIndex == 5)
			{
				
				setForm(thongKeKPI_form);
			}
			
				
		}
		else if(index == 2) {
			if (subIndex == 1) {
				
				setForm(quanLyNhanVien_Form);
			}
			else if(subIndex == 2){
				
				setForm(chamCongNhanVien_Form);
			}else if(subIndex == 3){
				
				setForm(tinhLuongNhanVien_Form);
			}
			else if(subIndex == 4)
			{
				
				setForm(thongKeLuongNhanVien_Form);
			}
		}
		else if(index == 3 && subIndex == 0) {
			
			setForm(quanLyHopDong_Form);
		}
		else if(index == 4){
			if (subIndex == 1) {
				
				setForm(quanLySanPham_Form);
			}
			else if (subIndex == 2) {
				
				setForm(congDoanSanPham_Form);
			}
			else {
				setForm(congDoanPhanCong_Form);
			}
			
		}
		else if(index == 5 && subIndex == 0) {
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
	
	private void hienThiTenNhanVien() {
		if (tk.getLoaiTaiKhoan().equals("admin")) {
			lblTenNV.setText("admin");
		}
		else {
			nv = nv_BUS.getNhanVienTheoID(tk.getTenTaiKhoan());
			lblTenNV.setText(nv.getHoTen() + " - " + nv.getChucVu().getTenChucVu());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDangXuat)) {
			if (JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Hỏi nhắc", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				openLogin_GUI();
				this.dispose();
			}
		}
	}
}