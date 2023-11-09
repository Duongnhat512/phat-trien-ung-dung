package form;


import javax.swing.JPanel;
import javax.swing.JRadioButton;


import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import connectDB.ConnectDB;
import entities.ChucVu;
import entities.NhanVien;
import entities.PhongBan;


import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;


import java.awt.Container;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import bus.ChucVu_BUS;
import bus.NhanVien_BUS;
import bus.PhongBan_BUS;
import commons.RoundPanel;
import commons.Table;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Nguyễn Gia Bảo, Ngô Quốc Đạt, Nguyễn Nhất Dương, Võ Văn Nghĩa Hiệp
 * @version 1.0
 *
 */

public class QuanLyNhanVien_Form extends JPanel implements ActionListener, MouseListener{


	private DefaultTableModel model;

	private JTextField textTimKiem;
	private JTextField txt_HienThiID;
	private JTextField txt_HienThiHoTen;
	private JTextField txt_HienThiPhai;
	private JTextField txt_HienThiCCCD;
	private JTextField txt_HienThiNgaySinh;
	private JTextField txt_HienThiCV;
	private JTextField txt_HienThiPB;
	private JTextField txt_HienThiSDT;
	private JTextField txt_HienThiEmail;
	private JTextField txt_HienThiTrangThai;
	private  int width = 1250;
	private  int height = 750;
	private JButton btnChonAnh;
	private RoundPanel panel_Them_SuaNhanVien;
	private JButton btnThemNhanVien;
	private JButton btnHuyThem;
	private JButton btnCapNhatNhanVien;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JDateChooser dateChooser_NgaySinh;
	private JRadioButton rbtn_Nam;
	private JRadioButton rbtnNu;
	private JDateChooser dateChooser_ngayKTCT;
	private JComboBox<String> cb_PhongBan;
	private JButton btnthem;
	private JButton btnCapNhat;
	private JButton btnTimKiem;
	private JPanel panel_NhanVien;
	private JTextField txtHeSoBHXH;
	private JTextField txtPhuCap;
	private JLabel lbl_CCCD;
	private JTextField txtCCCD;
	private JLabel lbl_LuongCB;
	private JTextField txtLuongCB;
	private NhanVien_BUS nv_bus;
	private JTextField txtID;
	private JComboBox<String> cb_ChucVu;
	private RoundPanel panel_bangTTNV;
	private JScrollPane scrollPane;
	private JDateChooser dateChooser_ngayCT;
	private java.sql.Date selectedDate;
	private Table tableNhanVien;

	private JLabel lblChucNang;

	private PhongBan_BUS pb_bus;

	private ChucVu_BUS cv_bus;



	private JLabel avatarImage;

	private JLabel hienThiAvatar;

	private JFileChooser fileChooser;



	
	/**
	 * Create the frame.
	 */
	    public QuanLyNhanVien_Form(int width, int height) {
			this.width = width;
			this.height= height;
			giaoDienNV();
//			giaoDienThemCapNhatNV();
			
		}
	  private void giaoDienNV() {
		  	setForeground(new Color(255, 255, 255));
		  	setPreferredSize(new Dimension(1250,780));
			
		  	try {
				ConnectDB.getInstance().connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Panel danh sách nhan vien
			
			panel_NhanVien = new JPanel();
			panel_NhanVien.setBounds(0, 0, 1250,750);
			panel_NhanVien.setLayout(null);
			
			panel_bangTTNV = new RoundPanel();
			panel_bangTTNV.setRound(20);
			panel_bangTTNV.setBackground(new Color(255, 255, 255));
			panel_bangTTNV.setBounds(10, 78, 1230, 382);
			panel_NhanVien.add(panel_bangTTNV);
			panel_bangTTNV.setLayout(null);
			
			RoundPanel panelTieuDe = new RoundPanel();
			panelTieuDe.setRound(20);
			panelTieuDe.setLayout(new BorderLayout(0, 0));
			JLabel tieuDe = new JLabel("Bảng thông tin nhân viên");
			panelTieuDe.add(tieuDe);
			panelTieuDe.setBounds(10, 10, 1210, 30);
			panelTieuDe.setBackground(new Color(113, 184, 255));
			tieuDe.setHorizontalAlignment(SwingConstants.CENTER);
			tieuDe.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_bangTTNV.add(panelTieuDe);
			String[] headers = {"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00E1i", "Ng\u00E0y sinh", "Ph\u00F2ng ban", "Ch\u1EE9c v\u1EE5", "Email", "S\u0110T", "CCCD", "Ngày công tác","Tr\u1EA1ng th\u00E1i"};
			model = new DefaultTableModel(headers , 0);
		

			tableNhanVien = new Table();
			tableNhanVien.setOpaque(false);
	        // Cài đặt header cho table Chấm công
			tableNhanVien.setModel(model);
			
					
	        
			scrollPane = new JScrollPane();
	        scrollPane.setBackground(new Color(255, 255, 255));
	        scrollPane.setOpaque(false);
	        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        scrollPane.setViewportView(tableNhanVien);
	        scrollPane.setBounds(10, 40, 1210, 332);
	        tableNhanVien.fixTable(scrollPane);
	        panel_bangTTNV.add(scrollPane);
			
			
			
			
//			scrollPane = new JScrollPane(table = new JTable(model));
//			
//
//			scrollPane.setBounds(10, 40, 1210, 612);
//			panel_bangTTNV.add(scrollPane);
//			scrollPane.setViewportView(table);
			
			
			
			
			//Panel chi tiet thong tin 1 nhan vien
		    RoundPanel panel_ChiTietNV = new RoundPanel();
		    panel_ChiTietNV.setRound(20);
			panel_ChiTietNV.setBackground(new Color(240, 240, 240));
			panel_ChiTietNV.setBounds(10, 470, 1230, 300);
			panel_NhanVien.add(panel_ChiTietNV);
			panel_ChiTietNV.setLayout(null);
			
			RoundPanel panel_Avt = new RoundPanel();
			panel_Avt.setRound(20);
			panel_Avt.setBackground(new Color(255, 255, 255));
			panel_Avt.setBounds(0, 10, 205, 280);
			panel_ChiTietNV.add(panel_Avt);
			
		
	        panel_Avt.setLayout(null);

	        hienThiAvatar = new JLabel();
	        hienThiAvatar.setBounds(26, 18, 150, 200);
	        panel_Avt.add(hienThiAvatar);
			
			RoundPanel panel_LyLich = new RoundPanel();
			panel_LyLich.setBackground(new Color(255, 255, 255));
			panel_LyLich.setRound(20);
			panel_LyLich.setBounds(215, 10, 510, 280);
			panel_ChiTietNV.add(panel_LyLich);
			panel_LyLich.setLayout(null);
			
			RoundPanel panelLblLyLich = new RoundPanel();
			panelLblLyLich.setRound(20);
			panelLblLyLich.setLayout(new BorderLayout(0, 0));
			JLabel lb_LyLich = new JLabel("Lý lịch nhân viên");
			lb_LyLich.setHorizontalAlignment(SwingConstants.CENTER);
			lb_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panelLblLyLich.add(lb_LyLich);
			panelLblLyLich.setBounds(10, 10, 490, 24);
			panelLblLyLich.setBackground(new Color(113, 184, 255));

			panel_LyLich.add(panelLblLyLich);
		
			JLabel lbl_HienThiHoTen = new JLabel("Họ và tên:");
			lbl_HienThiHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiHoTen.setBounds(10, 64, 130, 25);
			panel_LyLich.add(lbl_HienThiHoTen);
			
			JLabel lbl_HienThiCCCD = new JLabel("CCCD:");
			lbl_HienThiCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiCCCD.setBounds(10, 244, 130, 25);
			panel_LyLich.add(lbl_HienThiCCCD);
			
			JLabel lbl_HienThiPhai = new JLabel("Phái:");
			lbl_HienThiPhai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiPhai.setBounds(10, 124, 130, 25);
			panel_LyLich.add(lbl_HienThiPhai);
			
			JLabel lbl_HienThiNgaySinh = new JLabel("Ngày sinh:");
			lbl_HienThiNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiNgaySinh.setBounds(10, 184, 130, 25);
			panel_LyLich.add(lbl_HienThiNgaySinh);
			
			txt_HienThiHoTen = new JTextField();
			txt_HienThiHoTen.setEditable(false);
			txt_HienThiHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiHoTen.setBackground(null);
			txt_HienThiHoTen.setBorder(null);
			txt_HienThiHoTen.setBounds(142, 64, 358, 25);
			panel_LyLich.add(txt_HienThiHoTen);
			txt_HienThiHoTen.setColumns(10);
			
			txt_HienThiPhai = new JTextField();
			txt_HienThiPhai.setEditable(false);
			txt_HienThiPhai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiPhai.setBackground(null);
			txt_HienThiPhai.setBorder(null);
			txt_HienThiPhai.setColumns(10);
			txt_HienThiPhai.setBounds(142, 124, 358, 25);
			panel_LyLich.add(txt_HienThiPhai);
			
			txt_HienThiCCCD = new JTextField();
			txt_HienThiCCCD.setEditable(false);
			txt_HienThiCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiCCCD.setBackground(null);
			txt_HienThiCCCD.setBorder(null);
			txt_HienThiCCCD.setColumns(10);
			txt_HienThiCCCD.setBounds(142, 244, 358, 25);
			panel_LyLich.add(txt_HienThiCCCD);
			
			txt_HienThiNgaySinh = new JTextField();
			txt_HienThiNgaySinh.setEditable(false);
			txt_HienThiNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiNgaySinh.setBackground(null);
			txt_HienThiNgaySinh.setBorder(null);
			txt_HienThiNgaySinh.setColumns(10);
			txt_HienThiNgaySinh.setBounds(142, 184, 358, 25);
			panel_LyLich.add(txt_HienThiNgaySinh);
			JLabel lbl_LyLich = new JLabel("Lý lịch nhân viên");
			lbl_LyLich.setBounds(49, 10, 430, 24);
			panel_LyLich.add(lbl_LyLich);
			lbl_LyLich.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			RoundPanel panel_TT_Khac = new RoundPanel();
			panel_TT_Khac.setBackground(new Color(255, 255, 255));
			panel_TT_Khac.setRound(20);
			panel_TT_Khac.setBounds(735, 10, 495, 280);
			panel_ChiTietNV.add(panel_TT_Khac);
			panel_TT_Khac.setLayout(null);
			
			
			
			
			RoundPanel panelLblTTKhac = new RoundPanel();
			panelLblTTKhac.setRound(20);
			panelLblTTKhac.setLayout(new BorderLayout(0, 0));
			JLabel lb_TT_Khac = new JLabel("Thông tin khác");
			panelLblTTKhac.add(lb_TT_Khac);
			panelLblTTKhac.setBounds(10, 10, 475, 24);
			panelLblTTKhac.setBackground(new Color(113, 184, 255));
			lb_TT_Khac.setHorizontalAlignment(SwingConstants.CENTER);
			lb_TT_Khac.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_TT_Khac.add(panelLblTTKhac);
			
			txt_HienThiCV = new JTextField();
			txt_HienThiCV.setEditable(false);
			txt_HienThiCV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiCV.setBackground(null);
			txt_HienThiCV.setBorder(null);
			txt_HienThiCV.setColumns(10);
			txt_HienThiCV.setBounds(142, 244, 343, 25);
			panel_TT_Khac.add(txt_HienThiCV);
			
			JLabel lbl_HienThiChucVu = new JLabel("Chức vụ:");
			lbl_HienThiChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiChucVu.setBounds(10, 244, 130, 25);
			panel_TT_Khac.add(lbl_HienThiChucVu);
			
			JLabel lbl_HienThiPhongBan = new JLabel("Phòng ban:");
			lbl_HienThiPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiPhongBan.setBounds(10, 184, 130, 25);
			panel_TT_Khac.add(lbl_HienThiPhongBan);
			
			txt_HienThiPB = new JTextField();
			txt_HienThiPB.setEditable(false);
			txt_HienThiPB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiPB.setBackground(null);
			txt_HienThiPB.setBorder(null);
			txt_HienThiPB.setColumns(10);
			txt_HienThiPB.setBounds(142, 184, 343, 25);
			panel_TT_Khac.add(txt_HienThiPB);
			
			txt_HienThiSDT = new JTextField();
			txt_HienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiSDT.setBackground(null);
			txt_HienThiSDT.setBorder(null);
			txt_HienThiSDT.setEditable(false);
			txt_HienThiSDT.setColumns(10);
			txt_HienThiSDT.setBounds(142, 124, 343, 25);
			panel_TT_Khac.add(txt_HienThiSDT);
			
			JLabel lbl_HienThiSDT = new JLabel("Số điện thoại:");
			lbl_HienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiSDT.setBounds(10, 124, 130, 25);
			panel_TT_Khac.add(lbl_HienThiSDT);
			
			JLabel lbl_HienThiEmail = new JLabel("Email:");
			lbl_HienThiEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiEmail.setBounds(10, 64, 130, 25);
			panel_TT_Khac.add(lbl_HienThiEmail);
			
			txt_HienThiEmail = new JTextField();
			txt_HienThiEmail.setEditable(false);
			txt_HienThiEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiEmail.setBackground(null);
			txt_HienThiEmail.setBorder(null);
			txt_HienThiEmail.setColumns(10);
			txt_HienThiEmail.setBounds(142, 64, 343, 25);
			panel_TT_Khac.add(txt_HienThiEmail);
			
			JLabel lb_ID = new JLabel("ID:");
			lb_ID.setBounds(10, 228, 89, 20);
			lb_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panel_Avt.add(lb_ID);
			
			txt_HienThiID = new JTextField();
			txt_HienThiID.setEditable(false);
			txt_HienThiID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiID.setBorder(null);
			txt_HienThiID.setBackground(null);
			txt_HienThiID.setBounds(109, 228, 86, 20);
			panel_Avt.add(txt_HienThiID);
			txt_HienThiID.setColumns(10);
			
			JLabel lb_TrangThai = new JLabel("Trạng thái:");
			lb_TrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lb_TrangThai.setBounds(10, 258, 89, 20);
			panel_Avt.add(lb_TrangThai);
			
			txt_HienThiTrangThai = new JTextField();
			txt_HienThiTrangThai.setEditable(false);
			txt_HienThiTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiTrangThai.setBorder(null);
			txt_HienThiTrangThai.setBackground(null);
			txt_HienThiTrangThai.setColumns(10);
			txt_HienThiTrangThai.setBounds(109, 258, 86, 20);
			panel_Avt.add(txt_HienThiTrangThai);
			
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
			
			btnTimKiem = new JButton("Tìm kiếm");
			btnTimKiem.setBounds(1070, 26, 127, 35);
			btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			panel_NhanVien.add(btnTimKiem);
			this.add(panel_NhanVien);
			btnthem.addActionListener(this);
			btnCapNhat.addActionListener(this);
			btnTimKiem.addActionListener(this);
			tableNhanVien.addMouseListener(this);
			
			docDuLieuTuDataVaoTable();
			
	  }
	
	  private void giaoDienThemCapNhatNV() {
			setForeground(new Color(255, 255, 255));
			setPreferredSize(new Dimension(1250,780));
			setLayout(new BorderLayout(0, 0));

			panel_Them_SuaNhanVien = new RoundPanel();
			panel_Them_SuaNhanVien.setBackground(new Color(192, 192, 192));
			panel_Them_SuaNhanVien.setRound(50);
			panel_Them_SuaNhanVien.setLayout(null);
			
			RoundPanel panel_0 = new RoundPanel();
			panel_0.setSize(1230, 70);
			panel_0.setLocation(10, 10);
			panel_0.setBackground(new Color(168, 211, 255));
			panel_0.setRound(20);
			panel_0.setLayout(new BorderLayout(0, 0));
			lblChucNang = new JLabel("THÊM NHÂN VIÊN");
			lblChucNang.setBackground(new Color(162, 208, 255));
			lblChucNang.setForeground(new Color(0, 0, 0));
			lblChucNang.setHorizontalAlignment(SwingConstants.CENTER);
			lblChucNang.setFont(new Font("Times New Roman", Font.BOLD, 30));
			panel_0.add(lblChucNang);
			
			RoundPanel panel_1 = new RoundPanel();
			panel_1.setSize(868, 560);
			panel_1.setLocation(10, 90);
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setRound(20);
			panel_1.setLayout(null);
			
			
			RoundPanel panel_2 = new RoundPanel();
			panel_2.setLocation(888, 90);
			panel_2.setSize(352, 560);
			panel_2.setBackground(new Color(255, 255, 255));
			panel_2.setRound(20);
			panel_2.setLayout(null);
			
			RoundPanel panel_3 = new RoundPanel();
			panel_3.setSize(1230, 110);
			panel_3.setLocation(10, 660);
			panel_3.setBackground(new Color(255, 255, 255));
			panel_3.setRound(20);
			panel_3.setLayout(null);
			
			panel_Them_SuaNhanVien.add(panel_3);
			panel_Them_SuaNhanVien.add(panel_2);
			panel_Them_SuaNhanVien.add(panel_1);
			panel_Them_SuaNhanVien.add(panel_0);

			JLabel lbl_NgayCongTac = new JLabel("Ngày công tác:");
			lbl_NgayCongTac.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgayCongTac.setBounds(440, 30, 150, 40);
			panel_1.add(lbl_NgayCongTac);
			
			JLabel lbl_HoTen = new JLabel("Họ và tên:");
			lbl_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HoTen.setBounds(20, 110, 110, 40);
			panel_1.add(lbl_HoTen);
			
			JLabel lbl_Phai = new JLabel("Phái:");
			lbl_Phai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_Phai.setBounds(20, 270, 110, 40);
			panel_1.add(lbl_Phai);
			
			JLabel lbl_Email = new JLabel("Email:");
			lbl_Email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_Email.setBounds(20, 350, 110, 40);
			panel_1.add(lbl_Email);
			
			JLabel lbl_SDT = new JLabel("Số điện thoại:");
			lbl_SDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_SDT.setBounds(20, 430, 110, 40);
			panel_1.add(lbl_SDT);
			
			txtHoTen = new JTextField();
			txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtHoTen.setColumns(10);
			txtHoTen.setBounds(140, 110, 221, 40);
			panel_1.add(txtHoTen);
			
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtEmail.setColumns(10);
			txtEmail.setBounds(140, 350, 221, 40);
			panel_1.add(txtEmail);
			
			txtSDT = new JTextField();
			txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtSDT.setColumns(10);
			txtSDT.setBounds(140, 430, 221, 40);
			panel_1.add(txtSDT);
			
			JLabel lbl_NgaySinh = new JLabel("Ngày Sinh:");
			lbl_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgaySinh.setBounds(20, 190, 110, 40);
			panel_1.add(lbl_NgaySinh);
			dateChooser_NgaySinh = new JDateChooser();
			dateChooser_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_NgaySinh.setSize(221, 40);
			dateChooser_NgaySinh.setLocation(140, 190);
	        dateChooser_NgaySinh.setDateFormatString("yyyy-MM-dd"); // Đặt định dạng ngày
	        panel_1.add(dateChooser_NgaySinh);
			
			JLabel lbl_PhuCap = new JLabel("Phụ Cấp:");
			lbl_PhuCap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_PhuCap.setBounds(440, 430, 150, 40);
			panel_1.add(lbl_PhuCap);
			
			JLabel lbl_PhongBan = new JLabel("Phòng Ban:");
			lbl_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_PhongBan.setBounds(440, 190, 150, 40);
			panel_1.add(lbl_PhongBan);
			
			JLabel lbl_TayNghe = new JLabel("Hệ số BHXH:");
			lbl_TayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_TayNghe.setBounds(440, 350, 150, 40);
			panel_1.add(lbl_TayNghe);
			
			JLabel lbl_NgayKetThucCT = new JLabel("Ngày kết thúc công tác:");
			lbl_NgayKetThucCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgayKetThucCT.setBounds(440, 110, 189, 40);
			panel_1.add(lbl_NgayKetThucCT);
			ButtonGroup group = new ButtonGroup();
			rbtn_Nam = new JRadioButton("Nam");
			rbtn_Nam.setBackground(null);
			rbtn_Nam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rbtn_Nam.setBounds(136, 270, 100, 40);
			panel_1.add(rbtn_Nam);
		    
			rbtnNu = new JRadioButton("Nữ");
			rbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rbtnNu.setBounds(286, 270, 100, 40);
			rbtnNu.setBackground(null);
			panel_1.add(rbtnNu);
			group.add(rbtn_Nam);
			
			group.add(rbtnNu);
			dateChooser_ngayKTCT = new JDateChooser();
			dateChooser_ngayKTCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_ngayKTCT.setDateFormatString("yyyy-MM-dd");
			dateChooser_ngayKTCT.setBounds(629, 110, 229, 40);
			panel_1.add(dateChooser_ngayKTCT);
			
			cb_PhongBan = new JComboBox<String>();
			cb_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cb_PhongBan.setBounds(629, 190, 229, 40);
			panel_1.add(cb_PhongBan);
			
			pb_bus = new PhongBan_BUS();
			ArrayList<PhongBan> listPB = pb_bus.getDSPB();
			for (PhongBan pb : listPB) {
				cb_PhongBan.addItem(pb.getTenPhongBan());
			}
		
			

	        avatarImage = new JLabel();
	        avatarImage.setBounds(26, 35, 300, 400);
	        panel_2.add(avatarImage);

		
			
			btnChonAnh = new JButton("Chọn ảnh");
			btnChonAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnChonAnh.setBounds(106, 475, 150, 40);
			panel_2.add(btnChonAnh);
			
			btnThemNhanVien = new JButton("Thêm");
			btnThemNhanVien.setBackground(new Color(0, 255, 0));
			btnThemNhanVien.setForeground(new Color(0, 0, 0));
			btnThemNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnThemNhanVien.setBounds(400, 30, 150, 60);
			panel_3.add(btnThemNhanVien);
			
			btnHuyThem = new JButton("Hủy");
			btnHuyThem.setForeground(Color.BLACK);
			btnHuyThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnHuyThem.setBackground(new Color(255, 0, 0));
			btnHuyThem.setBounds(750, 30, 150, 60);
			panel_3.add(btnHuyThem);
			
			
			btnCapNhatNhanVien = new JButton("Cập nhật");
			btnCapNhatNhanVien.setForeground(Color.BLACK);
			btnCapNhatNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnCapNhatNhanVien.setBackground(Color.GREEN);
			btnCapNhatNhanVien.setBounds(400, 30, 150, 60);
			panel_3.add(btnCapNhatNhanVien);
			
			btnHuyThem.addActionListener(this);
			this.add(panel_Them_SuaNhanVien);
			
			txtHeSoBHXH = new JTextField();
			txtHeSoBHXH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtHeSoBHXH.setEditable(false);
			txtHeSoBHXH.setBounds(629, 350, 229, 40);
			panel_1.add(txtHeSoBHXH);
			txtHeSoBHXH.setColumns(10);
			
			
			
			lbl_CCCD = new JLabel("CCCD:");
			lbl_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_CCCD.setBounds(20, 510, 110, 40);
			panel_1.add(lbl_CCCD);
			
			txtCCCD = new JTextField();
			txtCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtCCCD.setColumns(10);
			txtCCCD.setBounds(140, 510, 221, 40);
			panel_1.add(txtCCCD);
			
			lbl_LuongCB = new JLabel("Lương cơ bản:");
			lbl_LuongCB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_LuongCB.setBounds(440, 510, 150, 40);
			panel_1.add(lbl_LuongCB);
			
			txtLuongCB = new JTextField();
			txtLuongCB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtLuongCB.setEditable(false);
			txtLuongCB.setColumns(10);
			txtLuongCB.setBounds(629, 510, 229, 40);
			panel_1.add(txtLuongCB);
			
			dateChooser_ngayCT = new JDateChooser();
			
			dateChooser_ngayCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_ngayCT.setDateFormatString("yyyy-MM-dd");
		
			dateChooser_ngayCT.setBounds(629, 30, 229, 40);
			panel_1.add(dateChooser_ngayCT);
			
			JLabel lbl_ID = new JLabel("ID:");
			lbl_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_ID.setBounds(20, 30, 110, 40);
			panel_1.add(lbl_ID);
			
			txtID = new JTextField();
			txtID.setEditable(false);
			txtID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtID.setColumns(10);
			txtID.setBounds(140, 30, 221, 40);
			panel_1.add(txtID);
			
			JLabel lbl_ChucVu = new JLabel("Chức vụ:");
			lbl_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_ChucVu.setBounds(440, 270, 150, 40);
			panel_1.add(lbl_ChucVu);
			
			cb_ChucVu = new JComboBox<String>();
			cb_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cb_ChucVu.setBounds(629, 270, 229, 40);
			panel_1.add(cb_ChucVu);
			cv_bus = new ChucVu_BUS();
			ArrayList<ChucVu> listCV = cv_bus.getDSCV();
			for (ChucVu cv : listCV) {
				cb_ChucVu.addItem(cv.getTenChucVu());
			}
			
			txtPhuCap = new JTextField();
			txtPhuCap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtPhuCap.setEditable(false);
			txtPhuCap.setColumns(10);
			txtPhuCap.setBounds(629, 430, 229, 40);
			panel_1.add(txtPhuCap);
			btnChonAnh.addActionListener(this);
			cb_ChucVu.addActionListener(this);
		}

	  private void docDuLieuTuDataVaoTable() {
		  	nv_bus = new NhanVien_BUS();
		  	pb_bus = new PhongBan_BUS();
		  	cv_bus = new ChucVu_BUS();
			ArrayList<NhanVien> list = nv_bus.getdsNV();
			for (NhanVien nv : list) {
				model.addRow(new Object[] {
						nv.getIdNhanVien(),
						nv.getHoTen(),
						nv.isPhai()?"Nam":"Nữ",
						nv.getNgaySinh(),
						pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan(),
						cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu(),
						nv.getEmail(),
						nv.getSoDienThoai(),
						nv.getcCCD(),
						nv.getNgayBatDauCongTac(),
						(nv.getNgayKetThucCongTac()==null)?"Còn Làm":"Nghỉ làm"	
						
				});
				
			}
			
		}
	  private void hienThiPanelCapNhat(String maNV) {
		  	panel_NhanVien.setVisible(false);
			giaoDienThemCapNhatNV();
			dateChooser_ngayKTCT.setEnabled(true);;
			btnThemNhanVien.setVisible(false);
			btnCapNhatNhanVien.setVisible(true);
			NhanVien nv = nv_bus.getNV(maNV);
			txtID.setText(nv.getIdNhanVien());
			selectedDate = java.sql.Date.valueOf(nv.getNgaySinh());
			dateChooser_NgaySinh.setDate(selectedDate);
			selectedDate = java.sql.Date.valueOf(nv.getNgayBatDauCongTac());
			dateChooser_ngayCT.setDate(selectedDate);
			if(nv.getNgayKetThucCongTac()!=null) {
				selectedDate = java.sql.Date.valueOf(nv.getNgayKetThucCongTac());
				dateChooser_ngayKTCT.setDate(selectedDate);
			}
			else {
				dateChooser_ngayKTCT.setDate(null);
			}
			
			txtHoTen.setText(nv.getHoTen());
			txtCCCD.setText(nv.getcCCD());
			txtHeSoBHXH.setText(nv.getHESOBAOHIEMXAHOI()+"");
			txtEmail.setText(nv.getEmail());
			txtSDT.setText(nv.getSoDienThoai());
			txtPhuCap.setText(nv.getPhuCap(nv.getChucVu())+"");
			cb_PhongBan.setSelectedItem(pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan());
			cb_ChucVu.setSelectedItem(cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu());
			txtLuongCB.setText(nv.getLUONGCOBAN()+"");
			if(nv.isPhai()) {
				rbtn_Nam.setSelected(true);
			}
			else {
				rbtnNu.setSelected(true);
			}
			ImageIcon themAvatar = new ImageIcon(nv.getAnhDaiDien());
	        
	        
        	// Lấy kích thước mới của JLabel
            int labelWidth = avatarImage.getWidth();
            int labelHeight = avatarImage.getHeight();

            // Chỉnh kích thước ảnh theo JLabel
            Image themAnh = themAvatar.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            themAvatar = new ImageIcon(themAnh);
            avatarImage.setIcon(themAvatar);

	  }
	  private void hienThiThongTinNV(NhanVien nv) {
			txt_HienThiID.setText(nv.getIdNhanVien());
			txt_HienThiTrangThai.setText((nv.getNgayKetThucCongTac()==null)?"Còn làm":"NghĨ làm");
			txt_HienThiHoTen.setText(nv.getHoTen());
			txt_HienThiNgaySinh.setText(nv.getNgaySinh().toString());
			txt_HienThiPhai.setText((nv.isPhai()==true)?"Nam":"Nữ");
			txt_HienThiCCCD.setText(nv.getcCCD());
			txt_HienThiSDT.setText(nv.getSoDienThoai());
			txt_HienThiEmail.setText(nv.getEmail());
			txt_HienThiCV.setText(cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu());
			txt_HienThiPB.setText(pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan());
			ImageIcon hienThiImageIcon = new ImageIcon(nv.getAnhDaiDien());
		
        	
        	
        	// Lấy kích thước mới của JLabel
            int labelWidth = hienThiAvatar.getWidth();
            int labelHeight = hienThiAvatar.getHeight();

            // Chỉnh kích thước ảnh theo JLabel
            Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        	hienThiImageIcon = new ImageIcon(themAnh);
            hienThiAvatar.setIcon(hienThiImageIcon);
	  }
	  private void hienThiPanelThem() {
		  	panel_NhanVien.setVisible(false);
			giaoDienThemCapNhatNV();
			dateChooser_ngayKTCT.setEnabled(false);;
			btnThemNhanVien.setVisible(true);
			btnCapNhatNhanVien.setVisible(false);
	  }
	  private NhanVien layTTNVTuTextField() {
		  String maVN = txtID.getText();
		  String tenNV = txtHoTen.getText();
		  Date nsDate = dateChooser_ngayCT.getDate();
		  int yearNS = nsDate.getYear();
		  int monthNS = nsDate.getMonth();
		  int dayNS = nsDate.getDay();
		  LocalDate ns = LocalDate.of(yearNS, monthNS, monthNS);
		  
		  Date ctDate = dateChooser_ngayCT.getDate();
		  int yearCT = ctDate.getYear();
		  int monthCT = ctDate.getMonth();
		  int dayCT = ctDate.getDay();
		  LocalDate ct = LocalDate.of(yearCT, monthCT, monthCT);
		  
		  Date ktctDate = dateChooser_ngayCT.getDate();
		  int yearKTCT = nsDate.getYear();
		  int monthKTCT = nsDate.getMonth();
		  int dayKTCT = nsDate.getDay();
		  LocalDate ktct = LocalDate.of(yearKTCT, monthKTCT, monthKTCT);
		  
		  PhongBan pb = pb_bus.getPBTheoTen(cb_PhongBan.getSelectedItem().toString());
		  ChucVu cv = cv_bus.getCVTheoTen(cb_ChucVu.getSelectedItem().toString());
		  boolean phai = rbtn_Nam.isSelected();
		  String email = txtEmail.getText();
		  String sdt =  txtSDT.getText();
		  String cccd = txtCCCD.getText();
		  double heSoBHXH =Double.parseDouble(txtHeSoBHXH.getText());
		  double luongCb =Double.parseDouble(txtLuongCB.getText());
		  NhanVien nv = new NhanVien(maVN, tenNV, phai, ns, ct, ktct, email, sdt,cv, null, pb,null, cccd);
		  return nv;
	  }
	  
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub'
			Object o = e.getSource();
			if(o.equals(btnthem)){
				hienThiPanelThem();
				
				
			}
			if(o.equals(cb_ChucVu)){
				
				int n = cb_ChucVu.getSelectedIndex();
				if(n==0) {
				   txtPhuCap.setText("500000");
				}
				else if(n==1) {
					txtPhuCap.setText("700000");
				}
				else {
					txtPhuCap.setText("1000000");
				}
			
				System.out.println(n);
				
			}
			if(o.equals(btnHuyThem)){
				int n = tableNhanVien.getSelectedRow();
				panel_Them_SuaNhanVien.setVisible(false);
				if (n!=-1) {
					System.out.println(n);
					String maNV = tableNhanVien.getValueAt(n, 0).toString();
					NhanVien nv = nv_bus.getNV(maNV);
					int m = nv_bus.getdsNV().indexOf(nv);
					giaoDienNV();
					tableNhanVien.setRowSelectionInterval(m, m);
					tableNhanVien.scrollRectToVisible(tableNhanVien.getCellRect(m, m, true));
					hienThiThongTinNV(nv);	
				}
				else {
					giaoDienNV();
				}
			}
			if(o.equals(btnTimKiem)) {
				String ma = textTimKiem.getText();
				NhanVien nv = nv_bus.getNV(ma);
				model.setRowCount(0);
				model.addRow(new Object[] {
						ma,
						nv.getHoTen(),
						nv.isPhai()?"Nam":"Nữ",
						nv.getNgaySinh(),
						pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan(),
						cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu(),
						nv.getEmail(),
						nv.getSoDienThoai(),
						nv.getcCCD(),
						nv.getNgayBatDauCongTac(),
						(nv.getNgayKetThucCongTac()==null)?"Còn Làm":"Nghỉ làm"	
						
				});
				tableNhanVien.setRowSelectionInterval(0, 0);
				hienThiThongTinNV(nv);
			}
			if(o.equals(btnCapNhat)) {
				int r = tableNhanVien.getSelectedRow();
				if(r == -1) {
					
					JOptionPane.showMessageDialog(null, "Chọn 1 nhân viên để cập nhật!");
			    }
				else {
					String maNV = tableNhanVien.getValueAt(r, 0).toString();
					hienThiPanelCapNhat(maNV);
				}
			}
			if(o.equals(btnChonAnh)) {
				
		            fileChooser = new JFileChooser();
		            fileChooser.setDialogTitle("Chọn ảnh");
		            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		            int result = fileChooser.showOpenDialog(null);

		            if (result == JFileChooser.APPROVE_OPTION) {
		                // Đoạn mã xử lý khi người dùng chọn tệp ảnh ở đây
		            	ImageIcon themAvatar = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath()+"");
		        
		        
		            	// Lấy kích thước mới của JLabel
		                int labelWidth = avatarImage.getWidth();
		                int labelHeight = avatarImage.getHeight();

		                // Chỉnh kích thước ảnh theo JLabel
		                Image themAnh = themAvatar.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		                themAvatar = new ImageIcon(themAnh);
		                avatarImage.setIcon(themAvatar);
		            }
		       
			}
				
		}
		@Override
		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
			
			int n = tableNhanVien.getSelectedRow();
			String maNV = tableNhanVien.getValueAt(n, 0).toString();
			NhanVien nv = nv_bus.getNV(maNV);
			hienThiThongTinNV(nv);
			
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
}
