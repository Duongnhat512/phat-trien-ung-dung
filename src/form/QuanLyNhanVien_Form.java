package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

/**
 * 
 * @author Nguyễn Gia Bảo, Ngô Quốc Đạt, Nguyễn Nhất Dương, Võ Văn Nghĩa Hiệp
 * @version 1.0
 *
 */

public class QuanLyNhanVien_Form extends JPanel implements ActionListener{

	private JTable table;
	private DefaultTableModel model;

	private JTextField textTimKiem;
	private JTextField textField;
	private JTextField txt_HienThiHoTen;
	private JTextField txt_HienThiPhai;
	private JTextField txt_HienThiSDT;
	private JTextField txt_HienThiNgaySinh;
	private JTextField txt_HienThiLuongCB;
	private JTextField txt_HienThiChucVu;
	private JTextField txt_HienThiPhongBan;
	private JTextField txt_HienThiEmail;
	private JTextField textField_1;
	private  int width = 1250;
	private  int height = 725;
	private JButton btnChonAnh;
	private Container panel_Them_SuaNhanVien;
	private JButton btnThemNhanVien;
	private JButton btnHuyThem;
	private JButton btnCapNhatNhanVien;
	private JTextField txt_ID;
	private JTextField txtTrangThai;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JDateChooser dateChooser_NgaySinh;
	private JRadioButton rbtn_Nam;
	private Container rbtnNu;
	private JDateChooser dateChooser_NCT;
	private JComboBox cb_PhongBan;
	private ImageIcon themAvatar;
	private JButton btnthem;
	private JButton btnCapNhat;
	private JPanel panel_NhanVien;
	private JTextField txt_HeSoBHXH;
	private JTextField txt_PhuCap;
	private JLabel lbl_CCCD;
	private JTextField txt_CCCD;
	private JLabel lbl_LuongCB;
	private JTextField txt_LuongCB;




	/**
	 * Create the frame.
	 */
	    public QuanLyNhanVien_Form(int width, int height) {
			this.width = width;
			this.height= height;
			giaoDienNV();
//		giaoDienThemCapNhatNV();
			
		}
	  private void giaoDienNV() {
		  	setForeground(new Color(255, 255, 255));
		  	setPreferredSize(new Dimension(1250,750));
			

			
			//Panel danh sách nhan vien
			
			panel_NhanVien = new JPanel();
			panel_NhanVien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_NhanVien.setBounds(0, 0, 1250, 750);
			panel_NhanVien.setLayout(null);
			
			JPanel panel_bangTTNV = new JPanel();
			panel_bangTTNV.setBounds(10, 78, 1230, 312);
			panel_bangTTNV.setBorder(new TitledBorder(null, "B\u1EA3ng th\u00F4ng tin c\u00F4ng nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_NhanVien.add(panel_bangTTNV);
			panel_bangTTNV.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 20, 1210, 282);
			panel_bangTTNV.add(scrollPane);
			table = new JTable();
			table.setModel( new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00E1i", "Ng\u00E0y sinh", "Ph\u00F2ng ban", "Ch\u1EE9c v\u1EE5", "Email", "S\u0110T", "L\u01B0\u01A1ng c\u01A1 b\u1EA3n", "Tr\u1EA1ng th\u00E1i"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(211);
			table.getColumnModel().getColumn(2).setPreferredWidth(52);
			table.getColumnModel().getColumn(3).setPreferredWidth(86);
			table.getColumnModel().getColumn(5).setPreferredWidth(92);
			table.getColumnModel().getColumn(6).setPreferredWidth(158);
			table.getColumnModel().getColumn(7).setPreferredWidth(100);
			table.getColumnModel().getColumn(8).setPreferredWidth(109);
			table.getColumnModel().getColumn(9).setPreferredWidth(80);
			scrollPane.setViewportView(table);
			
			
			
			
			//Panel chi tiet thong tin 1 nhan vien
			JPanel panel_ChiTietNV = new JPanel();
			panel_ChiTietNV.setBounds(10, 400, 1230, 300);
			panel_NhanVien.add(panel_ChiTietNV);
			panel_ChiTietNV.setLayout(null);
			
			JPanel panel_Avt = new JPanel();
			panel_Avt.setBounds(10, 10, 250, 214);
			panel_ChiTietNV.add(panel_Avt);
			
			ImageIcon defaultAvatar = new ImageIcon("abc.jpg"); // Đặt ảnh mặc định
	        panel_Avt.setLayout(null);

	        JLabel avatarImage = new JLabel(defaultAvatar);
	        avatarImage.setBounds(0, 0, 250, 214);
	        panel_Avt.add(avatarImage);
			
			JPanel panel_LyLich = new JPanel();
			panel_LyLich.setBounds(292, 10, 450, 280);
			panel_ChiTietNV.add(panel_LyLich);
			panel_LyLich.setLayout(null);
			
			JLabel lbl_LyLich = new JLabel("Lý lịch nhân viên");
			lbl_LyLich.setOpaque(true); // Đặt `opaque` thành true để cho phép sử dụng màu nền
			lbl_LyLich.setBackground(Color.CYAN);
			lbl_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lbl_LyLich.setBounds(10, 10, 430, 24);
			panel_LyLich.add(lbl_LyLich);
			
			JLabel lbl_HoTen = new JLabel("Họ và tên:");
			lbl_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_HoTen.setBounds(10, 64, 102, 20);
			panel_LyLich.add(lbl_HoTen);
			
			JLabel lbl_SĐT = new JLabel("Số điện thoại:");
			lbl_SĐT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_SĐT.setBounds(10, 244, 102, 20);
			panel_LyLich.add(lbl_SĐT);
			
			JLabel lbl_Phai = new JLabel("Phái:");
			lbl_Phai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_Phai.setBounds(10, 124, 102, 20);
			panel_LyLich.add(lbl_Phai);
			
			JLabel lbl_NgaySinh = new JLabel("Ngày sinh:");
			lbl_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_NgaySinh.setBounds(10, 184, 102, 20);
			panel_LyLich.add(lbl_NgaySinh);
			
			txt_HienThiHoTen = new JTextField();
			txt_HienThiHoTen.setEditable(false);
			txt_HienThiHoTen.setBounds(142, 64, 298, 20);
			panel_LyLich.add(txt_HienThiHoTen);
			txt_HienThiHoTen.setColumns(10);
			
			txt_HienThiPhai = new JTextField();
			txt_HienThiPhai.setEditable(false);
			txt_HienThiPhai.setColumns(10);
			txt_HienThiPhai.setBounds(142, 124, 298, 20);
			panel_LyLich.add(txt_HienThiPhai);
			
			txt_HienThiSDT = new JTextField();
			txt_HienThiSDT.setEditable(false);
			txt_HienThiSDT.setColumns(10);
			txt_HienThiSDT.setBounds(142, 244, 298, 20);
			panel_LyLich.add(txt_HienThiSDT);
			
			txt_HienThiNgaySinh = new JTextField();
			txt_HienThiNgaySinh.setEditable(false);
			txt_HienThiNgaySinh.setColumns(10);
			txt_HienThiNgaySinh.setBounds(142, 184, 298, 20);
			panel_LyLich.add(txt_HienThiNgaySinh);
			
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
			
			txt_HienThiLuongCB = new JTextField();
			txt_HienThiLuongCB.setEditable(false);
			txt_HienThiLuongCB.setColumns(10);
			txt_HienThiLuongCB.setBounds(142, 244, 298, 20);
			panel_TT_Khac.add(txt_HienThiLuongCB);
			
			JLabel lbl_LuongCoBan = new JLabel("Lương cơ bản:");
			lbl_LuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_LuongCoBan.setBounds(10, 244, 102, 20);
			panel_TT_Khac.add(lbl_LuongCoBan);
			
			JLabel lbl_ChucVu = new JLabel("Chức vụ:");
			lbl_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_ChucVu.setBounds(10, 184, 102, 20);
			panel_TT_Khac.add(lbl_ChucVu);
			
			txt_HienThiChucVu = new JTextField();
			txt_HienThiChucVu.setEditable(false);
			txt_HienThiChucVu.setColumns(10);
			txt_HienThiChucVu.setBounds(142, 184, 298, 20);
			panel_TT_Khac.add(txt_HienThiChucVu);
			
			txt_HienThiPhongBan = new JTextField();
			txt_HienThiPhongBan.setEditable(false);
			txt_HienThiPhongBan.setColumns(10);
			txt_HienThiPhongBan.setBounds(142, 124, 298, 20);
			panel_TT_Khac.add(txt_HienThiPhongBan);
			
			JLabel lbl_PhongBan = new JLabel("Phòng ban:");
			lbl_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_PhongBan.setBounds(10, 124, 102, 20);
			panel_TT_Khac.add(lbl_PhongBan);
			
			JLabel lbl_Email = new JLabel("Email:");
			lbl_Email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_Email.setBounds(10, 64, 102, 20);
			panel_TT_Khac.add(lbl_Email);
			
			txt_HienThiEmail = new JTextField();
			txt_HienThiEmail.setEditable(false);
			txt_HienThiEmail.setColumns(10);
			txt_HienThiEmail.setBounds(142, 64, 298, 20);
			panel_TT_Khac.add(txt_HienThiEmail);
			
			JLabel lb_ID = new JLabel("ID:");
			lb_ID.setBounds(10, 234, 61, 20);
			lb_ID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			panel_ChiTietNV.add(lb_ID);
			
			textField = new JTextField();
			textField.setBounds(81, 234, 179, 20);
			textField.setEditable(false);
			panel_ChiTietNV.add(textField);
			textField.setColumns(10);
			
			JLabel lb_TrangThai = new JLabel("Trạng thái:");
			lb_TrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lb_TrangThai.setBounds(10, 263, 70, 20);
			panel_ChiTietNV.add(lb_TrangThai);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(81, 263, 179, 20);
			panel_ChiTietNV.add(textField_1);
			
			btnthem = new JButton("Thêm nhân viên");
			btnthem.setBounds(33, 26, 141, 35);
			btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
			panel_NhanVien.add(btnthem);
			
			btnCapNhat = new JButton("Cập nhật\r\n");
			btnCapNhat.setBounds(206, 26, 141, 35);
			btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	
			setLayout(new BorderLayout(0, 0));
			panel_NhanVien.add(btnCapNhat);
			
			textTimKiem = new JTextField();
			textTimKiem.setBounds(823, 26, 245, 35);
			panel_NhanVien.add(textTimKiem);
			textTimKiem.setColumns(10);
			
			JButton btnTimKiem = new JButton("Tìm kiếm");
			btnTimKiem.setBounds(1070, 26, 127, 35);
			btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			panel_NhanVien.add(btnTimKiem);
			
			btnthem.addActionListener(this);
			btnCapNhat.addActionListener(this);
			this.add(panel_NhanVien);
	  }
	
	  private void giaoDienThemCapNhatNV() {
			setForeground(new Color(255, 255, 255));
			setPreferredSize(new Dimension(1250,750));
			setLayout(new BorderLayout(0, 0));

			
			
			panel_Them_SuaNhanVien = new JPanel();
			panel_Them_SuaNhanVien.setForeground(new Color(255, 255, 255));

			
		
			panel_Them_SuaNhanVien.setLayout(null);
			
			JLabel lbl_TrangThai = new JLabel("Trạng thái:");
			lbl_TrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_TrangThai.setBounds(450, 50, 150, 40);
			panel_Them_SuaNhanVien.add(lbl_TrangThai);
			
			JLabel lbl_HoTen = new JLabel("Họ và tên:");
			lbl_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HoTen.setBounds(30, 50, 110, 40);
			panel_Them_SuaNhanVien.add(lbl_HoTen);
			
			JLabel lbl_Phai = new JLabel("Phái:");
			lbl_Phai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_Phai.setBounds(30, 230, 110, 40);
			panel_Them_SuaNhanVien.add(lbl_Phai);
			
			JLabel lbl_Email = new JLabel("Email:");
			lbl_Email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_Email.setBounds(30, 320, 110, 40);
			panel_Them_SuaNhanVien.add(lbl_Email);
			
			JLabel lbl_SDT = new JLabel("Số điện thoại:");
			lbl_SDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_SDT.setBounds(30, 410, 110, 40);
			panel_Them_SuaNhanVien.add(lbl_SDT);
			
			txtTrangThai = new JTextField();
			txtTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtTrangThai.setBounds(610, 50, 250, 40);
			panel_Them_SuaNhanVien.add(txtTrangThai);
			txtTrangThai.setColumns(10);
			
			txtHoTen = new JTextField();
			txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtHoTen.setColumns(10);
			txtHoTen.setBounds(150, 50, 250, 40);
			panel_Them_SuaNhanVien.add(txtHoTen);
			
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtEmail.setColumns(10);
			txtEmail.setBounds(150, 320, 250, 40);
			panel_Them_SuaNhanVien.add(txtEmail);
			
			txtSDT = new JTextField();
			txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtSDT.setColumns(10);
			txtSDT.setBounds(150, 410, 250, 40);
			panel_Them_SuaNhanVien.add(txtSDT);
			
			JLabel lbl_NgaySinh = new JLabel("Ngày Sinh:");
			lbl_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgaySinh.setBounds(30, 140, 110, 40);
			panel_Them_SuaNhanVien.add(lbl_NgaySinh);
			
			dateChooser_NgaySinh = new JDateChooser();
			dateChooser_NgaySinh.setSize(250, 40);
			dateChooser_NgaySinh.setLocation(150, 140);
	        dateChooser_NgaySinh.setDateFormatString("dd/MM/yyyy"); // Đặt định dạng ngày
	        panel_Them_SuaNhanVien.add(dateChooser_NgaySinh);
			
			JLabel lbl_PhuCap = new JLabel("Phụ Cấp:");
			lbl_PhuCap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_PhuCap.setBounds(450, 410, 150, 40);
			panel_Them_SuaNhanVien.add(lbl_PhuCap);
			
			JLabel lbl_PhongBan = new JLabel("Phòng Ban:");
			lbl_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_PhongBan.setBounds(450, 230, 150, 40);
			panel_Them_SuaNhanVien.add(lbl_PhongBan);
			
			JLabel lbl_TayNghe = new JLabel("Hệ số BHXH:");
			lbl_TayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_TayNghe.setBounds(450, 320, 150, 40);
			panel_Them_SuaNhanVien.add(lbl_TayNghe);
			
			JLabel lbl_NgayCongTac = new JLabel("Ngày công tác:");
			lbl_NgayCongTac.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgayCongTac.setBounds(450, 140, 150, 40);
			panel_Them_SuaNhanVien.add(lbl_NgayCongTac);
			
			rbtn_Nam = new JRadioButton("Nam");
			rbtn_Nam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rbtn_Nam.setBounds(150, 230, 100, 40);
			panel_Them_SuaNhanVien.add(rbtn_Nam);
			
			rbtnNu = new JRadioButton("Nữ");
			rbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rbtnNu.setBounds(300, 230, 100, 40);
			panel_Them_SuaNhanVien.add(rbtnNu);
			
			dateChooser_NCT = new JDateChooser();
			dateChooser_NCT.setDateFormatString("dd/MM/yyyy");
			dateChooser_NCT.setBounds(610, 140, 250, 40);
			panel_Them_SuaNhanVien.add(dateChooser_NCT);
			
			cb_PhongBan = new JComboBox();
			cb_PhongBan.setBounds(610, 230, 250, 40);
			panel_Them_SuaNhanVien.add(cb_PhongBan);
			
		
		
			
			
			themAvatar = new ImageIcon("C:\\Users\\ADMIN\\OneDrive - Industrial University of HoChiMinh City\\Pictures\\Background\\KAZUHA.png"); 
	 

	        JLabel avatarImage = new JLabel(themAvatar);
	        avatarImage.setBounds(940, 150, 250, 214);
	        panel_Them_SuaNhanVien.add(avatarImage);

		
			
			btnChonAnh = new JButton("Chọn ảnh");
			btnChonAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnChonAnh.setBounds(996, 410, 120, 50);
			panel_Them_SuaNhanVien.add(btnChonAnh);
			
			btnThemNhanVien = new JButton("Thêm");
			btnThemNhanVien.setBackground(new Color(0, 255, 0));
			btnThemNhanVien.setForeground(new Color(0, 0, 0));
			btnThemNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnThemNhanVien.setBounds(811, 682, 141, 50);
			panel_Them_SuaNhanVien.add(btnThemNhanVien);
			
			btnHuyThem = new JButton("Hủy");
			btnHuyThem.setForeground(Color.BLACK);
			btnHuyThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnHuyThem.setBackground(new Color(255, 0, 0));
			btnHuyThem.setBounds(1049, 682, 141, 50);
			panel_Them_SuaNhanVien.add(btnHuyThem);
			;
			
			btnCapNhatNhanVien = new JButton("Cập nhật");
			btnCapNhatNhanVien.setForeground(Color.BLACK);
			btnCapNhatNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnCapNhatNhanVien.setBackground(Color.GREEN);
			btnCapNhatNhanVien.setBounds(811, 682, 141, 50);
			panel_Them_SuaNhanVien.add(btnCapNhatNhanVien);
			
			btnHuyThem.addActionListener(this);
			this.add(panel_Them_SuaNhanVien);
			
			JLabel lbl_ID = new JLabel("ID:");
			lbl_ID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_ID.setBounds(986, 374, 25, 30);
			panel_Them_SuaNhanVien.add(lbl_ID);
			
			txt_ID = new JTextField();
			txt_ID.setBorder(null);
			txt_ID.setEditable(false);
			txt_ID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_ID.setBounds(1021, 374, 130, 30);
			panel_Them_SuaNhanVien.add(txt_ID);
			txt_ID.setColumns(10);
			
			txt_HeSoBHXH = new JTextField();
			txt_HeSoBHXH.setBounds(610, 320, 250, 40);
			panel_Them_SuaNhanVien.add(txt_HeSoBHXH);
			txt_HeSoBHXH.setColumns(10);
			
			txt_PhuCap = new JTextField();
			txt_PhuCap.setColumns(10);
			txt_PhuCap.setBounds(610, 410, 250, 40);
			panel_Them_SuaNhanVien.add(txt_PhuCap);
			
			lbl_CCCD = new JLabel("CCCD:");
			lbl_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_CCCD.setBounds(30, 500, 110, 40);
			panel_Them_SuaNhanVien.add(lbl_CCCD);
			
			txt_CCCD = new JTextField();
			txt_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_CCCD.setColumns(10);
			txt_CCCD.setBounds(150, 500, 250, 40);
			panel_Them_SuaNhanVien.add(txt_CCCD);
			
			lbl_LuongCB = new JLabel("Lương cơ bản:");
			lbl_LuongCB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_LuongCB.setBounds(450, 500, 150, 40);
			panel_Them_SuaNhanVien.add(lbl_LuongCB);
			
			txt_LuongCB = new JTextField();
			txt_LuongCB.setColumns(10);
			txt_LuongCB.setBounds(610, 500, 250, 40);
			panel_Them_SuaNhanVien.add(txt_LuongCB);
	
	   
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub'
			Object o = e.getSource();
			if(o.equals(btnthem)){
				panel_NhanVien.setVisible(false);
				giaoDienThemCapNhatNV();
				btnThemNhanVien.setVisible(true);
				btnCapNhatNhanVien.setVisible(false);
				
				
			}
			if(o.equals(btnHuyThem)){
				panel_Them_SuaNhanVien.setVisible(false);
				giaoDienNV();
				
			}
			if(o.equals(btnCapNhat)) {
				panel_NhanVien.setVisible(false);
				giaoDienThemCapNhatNV();
				btnThemNhanVien.setVisible(false);
				btnCapNhatNhanVien.setVisible(true);
				
			}
		}
	
}
