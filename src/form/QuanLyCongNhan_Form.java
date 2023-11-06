package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import commons.GradientPanel;
import commons.PanelButton;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
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
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.Container;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

/**
 * 
 * @author Nguyễn Gia Bảo, Ngô Quốc Đạt, Nguyễn Nhất Dương, Võ Văn Nghĩa Hiệp
 * @version 1.0
 *
 */

public class QuanLyCongNhan_Form extends JPanel implements ActionListener{

	private int viTriButtonHienTai;
	private ArrayList<PanelButton> listItem;
	private JTable table;
	private DefaultTableModel model;

	private JTextField textTimKiem;
	private JTextField textField;
	private JTextField txthHienThiHoTen;
	private JTextField txthHienThiPhai;
	private JTextField txtHienThiTayNghe;
	private JTextField txtHienThiNgaySinh;
	private JTextField txtHienThiCaLam;
	private JTextField txtHienThiPhanXuong;
	private JTextField txtHienThiSDT;
	private JTextField txtHienThiEmail;
	private JTextField txtHienThiTrangThai;
	  private  int width = 1250;
	    private  int height = 725;
		private JPanel panel_CongNhan;
		private JButton btnthem;
		private JButton btnCapNhat;
		private JComboBox cb_Ca;
		private JButton btnLocCa;
		private JButton btnTimKiem;
		private JPanel panel_Them_SuaCongNhan;
		private JTextField txtTrangThai;
		private JTextField txtHoTen;
		private JTextField txtEmail;
		private JTextField txtSDT;
		private JLabel lbl_NgaySinh;
		private JLabel lbl_PhanXuong;
		private JLabel lbl_CaLam;
		private JLabel lbl_TayNghe;
		private JLabel lbl_NgayCongTac;
		private JDateChooser dateChooser_NgaySinh;
		private JComboBox cb_TayNghe;
		private JComboBox comboBox_2;
		private JPanel panel_ThemAvt;
		private ImageIcon themAvatar;
		private JLabel avatarImage;
		private JButton btnThemCongNhan;
		private JButton btnHuyThem;
		private JTextField txtHienThiID;
		private JButton btnCapNhatCongNhan;
		private JLabel lbl_ID;
		private JTextField txt_ID;
		private JComboBox cb_CaLam;
		private JButton btnChonAnh;
		private JDateChooser dateChooser_NCT;
		private JRadioButton rbtnNu;
		private Container rbtn_Nam;

	/**
	 * Launch the application.
	 */
    

	/**
	 * Create the frame.
	 */
		
		public QuanLyCongNhan_Form(int width, int height) {
			this.width = width;
			this.height= height;
			giaoDienCN();
//			giaoDienThemCapNhatCN();
		}
	private void giaoDienCN() {
		setForeground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1250,750));

		
		
		panel_CongNhan = new JPanel();
		panel_CongNhan.setForeground(new Color(255, 255, 255));
		panel_CongNhan.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_CongNhan.setLayout(null);
		
		//Panel danh sách công nhân
	
		JPanel panel_bangTTCN = new JPanel();
		panel_bangTTCN.setBounds(10, 78, 1230, 312);
		panel_bangTTCN.setBorder(new TitledBorder(null, "B\u1EA3ng th\u00F4ng tin c\u00F4ng nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_CongNhan.add(panel_bangTTCN);
		panel_bangTTCN.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 1210, 282);
		panel_bangTTCN.add(scrollPane);
		table = new JTable();
		table.setModel( new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00E1i", "Ng\u00E0y sinh", "Ph\u00E2n x\u01B0\u1EDFng", "Email", "S\u0110T", "Ca l\u00E0m", "Tay ngh\u1EC1", "Tr\u1EA1ng th\u00E1i"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(182);
		table.getColumnModel().getColumn(2).setPreferredWidth(52);
		table.getColumnModel().getColumn(3).setPreferredWidth(86);
		table.getColumnModel().getColumn(5).setPreferredWidth(158);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(56);
		table.getColumnModel().getColumn(9).setPreferredWidth(80);
		scrollPane.setViewportView(table);


		//Panel thông tin chi tiết 1  công nhân
		
	
		JPanel panel_ChiTietNV = new JPanel();
		panel_ChiTietNV.setBounds(10, 400, 1230, 300);
		panel_CongNhan.add(panel_ChiTietNV);
		panel_ChiTietNV.setLayout(null);
		
		JPanel panel_Avt = new JPanel();
		panel_Avt.setBounds(10, 10, 250, 214);
		panel_ChiTietNV.add(panel_Avt);
		
		ImageIcon defaultAvatar = new ImageIcon("abc.jpg"); 
        panel_Avt.setLayout(null);

        JLabel avatarImage = new JLabel(defaultAvatar);
        avatarImage.setBounds(0, 0, 250, 214);
        panel_Avt.add(avatarImage);
		
		JPanel panel_LyLich = new JPanel();
		panel_LyLich.setBounds(292, 10, 450, 280);
		panel_ChiTietNV.add(panel_LyLich);
		panel_LyLich.setLayout(null);
		
		JLabel lb_LyLich = new JLabel("Lý lịch công nhân");
		lb_LyLich.setOpaque(true); 
		lb_LyLich.setBackground(Color.CYAN);
		lb_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lb_LyLich.setBounds(10, 10, 430, 24);
		panel_LyLich.add(lb_LyLich);
		
		JLabel lb_HoTen = new JLabel("Họ và tên:");
		lb_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_HoTen.setBounds(10, 64, 102, 20);
		panel_LyLich.add(lb_HoTen);
		
		JLabel lb_TayNghe = new JLabel("Tay nghề:");
		lb_TayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_TayNghe.setBounds(10, 244, 102, 20);
		panel_LyLich.add(lb_TayNghe);
		
		JLabel lb_Phai = new JLabel("Phái:");
		lb_Phai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_Phai.setBounds(10, 124, 102, 20);
		panel_LyLich.add(lb_Phai);
		
		JLabel lb_NgaySinh = new JLabel("Ngày sinh:");
		lb_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_NgaySinh.setBounds(10, 184, 102, 20);
		panel_LyLich.add(lb_NgaySinh);
		
		txthHienThiHoTen = new JTextField();
		txthHienThiHoTen.setEditable(false);
		txthHienThiHoTen.setBounds(142, 64, 298, 20);
		panel_LyLich.add(txthHienThiHoTen);
		txthHienThiHoTen.setColumns(10);
		
		txthHienThiPhai = new JTextField();
		txthHienThiPhai.setEditable(false);
		txthHienThiPhai.setColumns(10);
		txthHienThiPhai.setBounds(142, 124, 298, 20);
		panel_LyLich.add(txthHienThiPhai);
		
		txtHienThiTayNghe = new JTextField();
		txtHienThiTayNghe.setEditable(false);
		txtHienThiTayNghe.setColumns(10);
		txtHienThiTayNghe.setBounds(142, 244, 298, 20);
		panel_LyLich.add(txtHienThiTayNghe);
		
		txtHienThiNgaySinh = new JTextField();
		txtHienThiNgaySinh.setEditable(false);
		txtHienThiNgaySinh.setColumns(10);
		txtHienThiNgaySinh.setBounds(142, 184, 298, 20);
		panel_LyLich.add(txtHienThiNgaySinh);
		
		JPanel panel_TT_Khac = new JPanel();
		panel_TT_Khac.setBounds(770, 10, 450, 280);
		panel_ChiTietNV.add(panel_TT_Khac);
		panel_TT_Khac.setLayout(null);
		
		JLabel lb_TT_Khac = new JLabel("Thông tin khác");
		lb_TT_Khac.setBounds(10, 10, 430, 24);
		lb_TT_Khac.setOpaque(true);
		lb_TT_Khac.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lb_TT_Khac.setBackground(Color.CYAN);
		panel_TT_Khac.add(lb_TT_Khac);
		
		txtHienThiCaLam = new JTextField();
		txtHienThiCaLam.setEditable(false);
		txtHienThiCaLam.setColumns(10);
		txtHienThiCaLam.setBounds(142, 244, 298, 20);
		panel_TT_Khac.add(txtHienThiCaLam);
		
		JLabel lb_CaLam = new JLabel("Ca làm:");
		lb_CaLam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_CaLam.setBounds(10, 244, 102, 20);
		panel_TT_Khac.add(lb_CaLam);
		
		JLabel lb_PhanXuong = new JLabel("Phân xưởng:");
		lb_PhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_PhanXuong.setBounds(10, 184, 102, 20);
		panel_TT_Khac.add(lb_PhanXuong);
		
		txtHienThiPhanXuong = new JTextField();
		txtHienThiPhanXuong.setEditable(false);
		txtHienThiPhanXuong.setColumns(10);
		txtHienThiPhanXuong.setBounds(142, 184, 298, 20);
		panel_TT_Khac.add(txtHienThiPhanXuong);
		
		txtHienThiSDT = new JTextField();
		txtHienThiSDT.setEditable(false);
		txtHienThiSDT.setColumns(10);
		txtHienThiSDT.setBounds(142, 124, 298, 20);
		panel_TT_Khac.add(txtHienThiSDT);
		
		JLabel SĐT = new JLabel("Số điện thoại:");
		SĐT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		SĐT.setBounds(10, 124, 102, 20);
		panel_TT_Khac.add(SĐT);
		
		JLabel lb_Email = new JLabel("Email:");
		lb_Email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_Email.setBounds(10, 64, 102, 20);
		panel_TT_Khac.add(lb_Email);
		
		txtHienThiEmail = new JTextField();
		txtHienThiEmail.setEditable(false);
		txtHienThiEmail.setColumns(10);
		txtHienThiEmail.setBounds(142, 64, 298, 20);
		panel_TT_Khac.add(txtHienThiEmail);
		
		JLabel lb_ID = new JLabel("ID:");
		lb_ID.setBounds(10, 234, 61, 20);
		lb_ID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_ChiTietNV.add(lb_ID);
		
		txtHienThiID = new JTextField();
		txtHienThiID.setBounds(81, 234, 179, 20);
		txtHienThiID.setEditable(false);
		panel_ChiTietNV.add(txtHienThiID);
		txtHienThiID.setColumns(10);
		
		JLabel lb_TrangThai = new JLabel("Trạng thái:");
		lb_TrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_TrangThai.setBounds(10, 263, 70, 20);
		panel_ChiTietNV.add(lb_TrangThai);
		
		txtHienThiTrangThai = new JTextField();
		txtHienThiTrangThai.setEditable(false);
		txtHienThiTrangThai.setColumns(10);
		txtHienThiTrangThai.setBounds(81, 263, 179, 20);
		panel_ChiTietNV.add(txtHienThiTrangThai);
		
		btnthem = new JButton("Thêm công nhân");
		btnthem.setBounds(33, 26, 141, 35);
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
		panel_CongNhan.add(btnthem);
		
		btnCapNhat = new JButton("Cập nhật\r\n");
		btnCapNhat.setBounds(206, 26, 141, 35);
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_CongNhan.add(btnCapNhat);
		
		cb_Ca = new JComboBox();
		cb_Ca.setBounds(519, 26, 127, 35);
		panel_CongNhan.add(cb_Ca);
		
		btnLocCa = new JButton("Lọc theo ca");
		btnLocCa.setBounds(656, 26, 127, 35);
		btnLocCa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_CongNhan.add(btnLocCa);
		
		textTimKiem = new JTextField();
		textTimKiem.setBounds(823, 26, 245, 35);
		panel_CongNhan.add(textTimKiem);
		textTimKiem.setColumns(10);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(1070, 26, 127, 35);
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_CongNhan.add(btnTimKiem);
		setLayout(new BorderLayout(0, 0));
		this.add(panel_CongNhan);
		btnthem.addActionListener(this);
		btnCapNhat.addActionListener(this);
	
	}
	
	private void giaoDienThemCapNhatCN() {
		setForeground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1250,750));
		setLayout(new BorderLayout(0, 0));

		
		
		panel_Them_SuaCongNhan = new JPanel();
		panel_Them_SuaCongNhan.setForeground(new Color(255, 255, 255));
		panel_Them_SuaCongNhan.setBorder(null);
		
	
		panel_Them_SuaCongNhan.setLayout(null);
		
		JLabel lbl_TrangThai = new JLabel("Trạng thái:");
		lbl_TrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_TrangThai.setBounds(450, 50, 150, 50);
		panel_Them_SuaCongNhan.add(lbl_TrangThai);
		
		JLabel lbl_HoTen = new JLabel("Họ và tên:");
		lbl_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_HoTen.setBounds(30, 50, 110, 50);
		panel_Them_SuaCongNhan.add(lbl_HoTen);
		
		JLabel lbl_Phai = new JLabel("Phái:");
		lbl_Phai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_Phai.setBounds(30, 290, 110, 50);
		panel_Them_SuaCongNhan.add(lbl_Phai);
		
		JLabel lbl_Email = new JLabel("Email:");
		lbl_Email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_Email.setBounds(30, 410, 110, 50);
		panel_Them_SuaCongNhan.add(lbl_Email);
		
		JLabel lbl_SDT = new JLabel("Số điện thoại:");
		lbl_SDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_SDT.setBounds(30, 530, 110, 50);
		panel_Them_SuaCongNhan.add(lbl_SDT);
		
		txtTrangThai = new JTextField();
		txtTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTrangThai.setBounds(610, 50, 250, 50);
		panel_Them_SuaCongNhan.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(150, 50, 250, 50);
		panel_Them_SuaCongNhan.add(txtHoTen);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(150, 410, 250, 50);
		panel_Them_SuaCongNhan.add(txtEmail);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(150, 530, 250, 50);
		panel_Them_SuaCongNhan.add(txtSDT);
		
		lbl_NgaySinh = new JLabel("Ngày Sinh:");
		lbl_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_NgaySinh.setBounds(30, 170, 110, 50);
		panel_Them_SuaCongNhan.add(lbl_NgaySinh);
		
		dateChooser_NgaySinh = new JDateChooser();
		dateChooser_NgaySinh.setSize(250, 50);
		dateChooser_NgaySinh.setLocation(150, 170);
        dateChooser_NgaySinh.setDateFormatString("dd/MM/yyyy"); // Đặt định dạng ngày
        panel_Them_SuaCongNhan.add(dateChooser_NgaySinh);
		
		lbl_PhanXuong = new JLabel("Phân Xưởng:");
		lbl_PhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_PhanXuong.setBounds(450, 530, 150, 50);
		panel_Them_SuaCongNhan.add(lbl_PhanXuong);
		
		lbl_CaLam = new JLabel("Ca làm:");
		lbl_CaLam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_CaLam.setBounds(450, 290, 150, 50);
		panel_Them_SuaCongNhan.add(lbl_CaLam);
		
		lbl_TayNghe = new JLabel("Tay nghề:");
		lbl_TayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_TayNghe.setBounds(450, 410, 150, 50);
		panel_Them_SuaCongNhan.add(lbl_TayNghe);
		
		lbl_NgayCongTac = new JLabel("Ngày công tác:");
		lbl_NgayCongTac.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_NgayCongTac.setBounds(450, 170, 150, 50);
		panel_Them_SuaCongNhan.add(lbl_NgayCongTac);
		
		rbtn_Nam = new JRadioButton("Nam");
		rbtn_Nam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rbtn_Nam.setBounds(150, 290, 100, 50);
		panel_Them_SuaCongNhan.add(rbtn_Nam);
		
		rbtnNu = new JRadioButton("Nữ");
		rbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rbtnNu.setBounds(300, 287, 100, 50);
		panel_Them_SuaCongNhan.add(rbtnNu);
		
		dateChooser_NCT = new JDateChooser();
		dateChooser_NCT.setDateFormatString("dd/MM/yyyy");
		dateChooser_NCT.setBounds(610, 170, 250, 50);
		panel_Them_SuaCongNhan.add(dateChooser_NCT);
		
		cb_CaLam = new JComboBox();
		cb_CaLam.setBounds(610, 290, 250, 50);
		panel_Them_SuaCongNhan.add(cb_CaLam);
		
		cb_TayNghe = new JComboBox();
		cb_TayNghe.setBounds(610, 410, 250, 50);
		panel_Them_SuaCongNhan.add(cb_TayNghe);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(610, 530, 250, 50);
		panel_Them_SuaCongNhan.add(comboBox_2);
		
	
	
		
		
		themAvatar = new ImageIcon("C:\\Users\\ADMIN\\OneDrive - Industrial University of HoChiMinh City\\Pictures\\Background\\KAZUHA.png"); 
 

        JLabel avatarImage = new JLabel(themAvatar);
        avatarImage.setBounds(940, 150, 250, 214);
        panel_Them_SuaCongNhan.add(avatarImage);

	
		
		btnChonAnh = new JButton("Chọn ảnh");
		btnChonAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnChonAnh.setBounds(996, 410, 120, 50);
		panel_Them_SuaCongNhan.add(btnChonAnh);
		
		btnThemCongNhan = new JButton("Thêm");
		btnThemCongNhan.setBackground(new Color(0, 255, 0));
		btnThemCongNhan.setForeground(new Color(0, 0, 0));
		btnThemCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThemCongNhan.setBounds(811, 682, 141, 50);
		panel_Them_SuaCongNhan.add(btnThemCongNhan);
		
		btnHuyThem = new JButton("Hủy");
		btnHuyThem.setForeground(Color.BLACK);
		btnHuyThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuyThem.setBackground(new Color(255, 0, 0));
		btnHuyThem.setBounds(1049, 682, 141, 50);
		panel_Them_SuaCongNhan.add(btnHuyThem);
		;
		
		btnCapNhatCongNhan = new JButton("Cập nhật");
		btnCapNhatCongNhan.setForeground(Color.BLACK);
		btnCapNhatCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCapNhatCongNhan.setBackground(Color.GREEN);
		btnCapNhatCongNhan.setBounds(811, 682, 141, 50);
		panel_Them_SuaCongNhan.add(btnCapNhatCongNhan);
		
		btnHuyThem.addActionListener(this);
		this.add(panel_Them_SuaCongNhan);
		
		lbl_ID = new JLabel("ID:");
		lbl_ID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_ID.setBounds(986, 374, 25, 30);
		panel_Them_SuaCongNhan.add(lbl_ID);
		
		txt_ID = new JTextField();
		txt_ID.setBorder(null);
		txt_ID.setEditable(false);
		txt_ID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txt_ID.setBounds(1021, 374, 130, 30);
		panel_Them_SuaCongNhan.add(txt_ID);
		txt_ID.setColumns(10);
		
		
   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub'
		Object o = e.getSource();
		if(o.equals(btnthem)){
			panel_CongNhan.setVisible(false);
			giaoDienThemCapNhatCN();
			btnThemCongNhan.setVisible(true);
			btnCapNhatCongNhan.setVisible(false);
			
			
		}
		if(o.equals(btnHuyThem)){
			panel_Them_SuaCongNhan.setVisible(false);
			giaoDienCN();
			
		}
		if(o.equals(btnCapNhat)) {
			panel_CongNhan.setVisible(false);
			giaoDienThemCapNhatCN();
			btnThemCongNhan.setVisible(false);
			btnCapNhatCongNhan.setVisible(true);
			
		}
	}
}
