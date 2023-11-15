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
import entities.SanPham;
import entities.TaiKhoan;

import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javax.swing.border.LineBorder;
import javax.swing.plaf.DimensionUIResource;

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
	private  int width = 1259;
	private  int height = 813;
	private JButton btnChonAnh;
	private RoundPanel panel_Them_SuaNhanVien;
	private JButton btnThemNhanVien;
	private JButton btnHuy;
	private JButton btnCapNhatNhanVien;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JDateChooser dateChooser_NgaySinh;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JDateChooser dateChooser_ngayKTCT;
	private JComboBox<String> cb_PhongBan;
	private JButton btnthem;
	private JButton btnCapNhat;
	private JButton btnTimKiem;
	private JPanel panel_NhanVien;

	private JLabel lbl_CCCD;
	private JTextField txtCCCD;

	private NhanVien_BUS nv_bus;
	private JTextField txtID;
	private JComboBox<String> cb_ChucVu;
	private JScrollPane scrollPane;
	private JDateChooser dateChooser_ngayCT;
	private Table tableNhanVien;

	private JLabel lblChucNang;

	private PhongBan_BUS pb_bus;

	private ChucVu_BUS cv_bus;



	private JLabel avatarImage;

	private JLabel hienThiAvatar;



	private String url;

	private JLabel lbl_NgayKetThucCT;




	
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
		  	setPreferredSize(new DimensionUIResource(this.width, this.height));
			
		  	try {
				ConnectDB.getInstance().connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  	nv_bus = new NhanVien_BUS();
		  	pb_bus = new PhongBan_BUS();
		  	cv_bus = new ChucVu_BUS();
		  	setLayout(new BorderLayout(0, 0));
			//Panel danh sách nhan vien
			
			panel_NhanVien = new JPanel();
			panel_NhanVien.setBounds(0, 0, 1259,813);
			panel_NhanVien.setLayout(null);
			
			RoundPanel panel_bangTTNV = new RoundPanel();
			panel_bangTTNV.setRound(20);
			panel_bangTTNV.setBackground(new Color(255, 255, 255));
			panel_bangTTNV.setBounds(10, 89, 1239, 381);
			panel_bangTTNV.setLayout(null);
			
			panel_NhanVien.add(panel_bangTTNV);
			
			
			RoundPanel panelTieuDe = new RoundPanel();
			panelTieuDe.setRound(20);
			panelTieuDe.setLayout(new BorderLayout(0, 0));
			panelTieuDe.setBounds(10, 10, 1219, 30);
			panelTieuDe.setBackground(new Color(113, 184, 255));
			
			panel_bangTTNV.add(panelTieuDe);
			
			JLabel tieuDe = new JLabel("Bảng thông tin nhân viên");
		    tieuDe.setBounds(19, 10, 1210, 30);
		    tieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		    tieuDe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		    
		    panelTieuDe.add(tieuDe);
		    
			
			String[] headers = {"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00E1i", "Ng\u00E0y sinh", "Ngày công tác", "Ph\u00F2ng ban", "Ch\u1EE9c v\u1EE5", "Email", "S\u0110T", "CCCD","Tr\u1EA1ng th\u00E1i"};
			model = new DefaultTableModel(headers , 0);
		

			tableNhanVien = new Table();
			tableNhanVien.setOpaque(false);
			tableNhanVien.setModel(model);
			
			scrollPane = new JScrollPane();
	        scrollPane.setBackground(new Color(255, 255, 255));
	        scrollPane.setOpaque(false);
	        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        scrollPane.setViewportView(tableNhanVien);
	        scrollPane.setBounds(10, 40, 1219, 331);
	        tableNhanVien.fixTable(scrollPane);
	        
	        panel_bangTTNV.add(scrollPane);
	     
			
			

			
			
			
			//Panel chi tiet thong tin 1 nhan vien
		    RoundPanel panel_ChiTietNV = new RoundPanel();
		    panel_ChiTietNV.setRound(20);
			panel_ChiTietNV.setBackground(new Color(240, 240, 240));
			panel_ChiTietNV.setBounds(10, 480, 1239, 300);
			panel_ChiTietNV.setLayout(null);
			
			panel_NhanVien.add(panel_ChiTietNV);
			

			RoundPanel panel_Avt = new RoundPanel();
			panel_Avt.setBorder(new LineBorder(new Color(113, 184, 255), 3, true));
			panel_Avt.setRound(20);
			panel_Avt.setBackground(new Color(255, 255, 255));
			panel_Avt.setBounds(4, 10, 205, 280);
			panel_Avt.setLayout(null);
			
			panel_ChiTietNV.add(panel_Avt);
			
		
	        

	        hienThiAvatar = new JLabel();
	        hienThiAvatar.setBounds(26, 18, 150, 200);
	        
	        panel_Avt.add(hienThiAvatar);
			
			RoundPanel panel_LyLich = new RoundPanel();
			panel_LyLich.setBackground(new Color(255, 255, 255));
			panel_LyLich.setRound(20);
			panel_LyLich.setBounds(215, 10, 514, 280);
			panel_LyLich.setLayout(null);
			
			panel_ChiTietNV.add(panel_LyLich);
			
			RoundPanel panelLblLyLich = new RoundPanel();
			panelLblLyLich.setRound(20);
			panelLblLyLich.setLayout(new BorderLayout(0, 0));
			panelLblLyLich.setBounds(10, 10, 490, 24);
			panelLblLyLich.setBackground(new Color(113, 184, 255));
			
			JLabel lb_LyLich = new JLabel("Lý lịch nhân viên");
			lb_LyLich.setHorizontalAlignment(SwingConstants.CENTER);
			lb_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			panelLblLyLich.add(lb_LyLich);
			
			panel_LyLich.add(panelLblLyLich);
		
			JLabel lbl_HienThiHoTen = new JLabel("Họ và tên:");
			lbl_HienThiHoTen.setForeground(new Color(0, 0, 128));
			lbl_HienThiHoTen.setBackground(new Color(255, 255, 255));
			lbl_HienThiHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiHoTen.setBounds(10, 64, 130, 25);
			
			panel_LyLich.add(lbl_HienThiHoTen);
			
			JLabel lbl_HienThiCCCD = new JLabel("CCCD:");
			lbl_HienThiCCCD.setForeground(new Color(0, 0, 128));
			lbl_HienThiCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiCCCD.setBounds(10, 244, 130, 25);
			
			panel_LyLich.add(lbl_HienThiCCCD);
			
			JLabel lbl_HienThiPhai = new JLabel("Phái:");
			lbl_HienThiPhai.setForeground(new Color(0, 0, 128));
			lbl_HienThiPhai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiPhai.setBounds(10, 124, 130, 25);
			
			panel_LyLich.add(lbl_HienThiPhai);
			
			JLabel lbl_HienThiNgaySinh = new JLabel("Ngày sinh:");
			lbl_HienThiNgaySinh.setForeground(new Color(0, 0, 128));
			lbl_HienThiNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiNgaySinh.setBounds(10, 184, 130, 25);
			
			panel_LyLich.add(lbl_HienThiNgaySinh);
			
			txt_HienThiHoTen = new JTextField();
			txt_HienThiHoTen.setEditable(false);
			txt_HienThiHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiHoTen.setBackground(null);
			txt_HienThiHoTen.setBorder(null);
			txt_HienThiHoTen.setBounds(206, 64, 294, 25);
			txt_HienThiHoTen.setColumns(10);
			
			panel_LyLich.add(txt_HienThiHoTen);
			
			txt_HienThiPhai = new JTextField();
			txt_HienThiPhai.setEditable(false);
			txt_HienThiPhai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiPhai.setBackground(null);
			txt_HienThiPhai.setBorder(null);
			txt_HienThiPhai.setColumns(10);
			txt_HienThiPhai.setBounds(206, 124, 294, 25);
			
			panel_LyLich.add(txt_HienThiPhai);
			
			txt_HienThiCCCD = new JTextField();
			txt_HienThiCCCD.setEditable(false);
			txt_HienThiCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiCCCD.setBackground(null);
			txt_HienThiCCCD.setBorder(null);
			txt_HienThiCCCD.setColumns(10);
			txt_HienThiCCCD.setBounds(206, 244, 294, 25);
			
			panel_LyLich.add(txt_HienThiCCCD);
			
			txt_HienThiNgaySinh = new JTextField();
			txt_HienThiNgaySinh.setEditable(false);
			txt_HienThiNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiNgaySinh.setBackground(null);
			txt_HienThiNgaySinh.setBorder(null);
			txt_HienThiNgaySinh.setColumns(10);
			txt_HienThiNgaySinh.setBounds(206, 184, 294, 25);
			
			panel_LyLich.add(txt_HienThiNgaySinh);
			
			JLabel lbl_LyLich = new JLabel("Lý lịch nhân viên");
			lbl_LyLich.setBounds(49, 10, 430, 24);
			lbl_LyLich.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			panel_LyLich.add(lbl_LyLich);
			
			
			RoundPanel panel_TT_Khac = new RoundPanel();
			panel_TT_Khac.setBackground(new Color(255, 255, 255));
			panel_TT_Khac.setRound(20);
			panel_TT_Khac.setBounds(739, 10, 500, 280);
			panel_TT_Khac.setLayout(null);
			
			panel_ChiTietNV.add(panel_TT_Khac);
			
			
			RoundPanel panelLblTTKhac = new RoundPanel();
			panelLblTTKhac.setRound(20);
			panelLblTTKhac.setLayout(new BorderLayout(0, 0));
			panelLblTTKhac.setBounds(10, 10, 484, 24);
			panelLblTTKhac.setBackground(new Color(113, 184, 255));

			panel_TT_Khac.add(panelLblTTKhac);
			
			JLabel lbl_TT_Khac = new JLabel("Thông tin khác");
			lbl_TT_Khac.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_TT_Khac.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			panelLblTTKhac.add(lbl_TT_Khac, BorderLayout.NORTH);
			
			txt_HienThiCV = new JTextField();
			txt_HienThiCV.setEditable(false);
			txt_HienThiCV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiCV.setBackground(null);
			txt_HienThiCV.setBorder(null);
			txt_HienThiCV.setColumns(10);
			txt_HienThiCV.setBounds(191, 244, 303, 25);
			
			panel_TT_Khac.add(txt_HienThiCV);
			
			JLabel lbl_HienThiChucVu = new JLabel("Chức vụ:");
			lbl_HienThiChucVu.setForeground(new Color(0, 0, 128));
			lbl_HienThiChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiChucVu.setBounds(10, 244, 130, 25);
			
			panel_TT_Khac.add(lbl_HienThiChucVu);
			
			JLabel lbl_HienThiPhongBan = new JLabel("Phòng ban:");
			lbl_HienThiPhongBan.setForeground(new Color(0, 0, 128));
			lbl_HienThiPhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiPhongBan.setBounds(10, 184, 130, 25);
			
			panel_TT_Khac.add(lbl_HienThiPhongBan);
			
			txt_HienThiPB = new JTextField();
			txt_HienThiPB.setEditable(false);
			txt_HienThiPB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiPB.setBackground(null);
			txt_HienThiPB.setBorder(null);
			txt_HienThiPB.setColumns(10);
			txt_HienThiPB.setBounds(191, 184, 303, 25);
			
			panel_TT_Khac.add(txt_HienThiPB);
			
			txt_HienThiSDT = new JTextField();
			txt_HienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiSDT.setBackground(null);
			txt_HienThiSDT.setBorder(null);
			txt_HienThiSDT.setEditable(false);
			txt_HienThiSDT.setColumns(10);
			txt_HienThiSDT.setBounds(191, 124, 303, 25);
			
			panel_TT_Khac.add(txt_HienThiSDT);
			
			JLabel lbl_HienThiSDT = new JLabel("Số điện thoại:");
			lbl_HienThiSDT.setForeground(new Color(0, 0, 128));
			lbl_HienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiSDT.setBounds(10, 124, 130, 25);
			
			panel_TT_Khac.add(lbl_HienThiSDT);
			
			JLabel lbl_HienThiEmail = new JLabel("Email:");
			lbl_HienThiEmail.setForeground(new Color(0, 0, 128));
			lbl_HienThiEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiEmail.setBounds(10, 64, 130, 25);
			
			panel_TT_Khac.add(lbl_HienThiEmail);
			
			txt_HienThiEmail = new JTextField();
			txt_HienThiEmail.setEditable(false);
			txt_HienThiEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiEmail.setBackground(null);
			txt_HienThiEmail.setBorder(null);
			txt_HienThiEmail.setColumns(10);
			txt_HienThiEmail.setBounds(191, 64, 303, 25);
			
			panel_TT_Khac.add(txt_HienThiEmail);
			
			JLabel lb_TT_Khac = new JLabel("Thông tin khác");
			lb_TT_Khac.setBounds(10, 10, 475, 24);
			lb_TT_Khac.setHorizontalAlignment(SwingConstants.CENTER);
			lb_TT_Khac.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			panel_TT_Khac.add(lb_TT_Khac);
			
			
			
			JLabel lb_ID = new JLabel("ID:");
			lb_ID.setForeground(new Color(0, 0, 128));
			lb_ID.setBounds(10, 228, 89, 20);
			lb_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			
			panel_Avt.add(lb_ID);
			
			txt_HienThiID = new JTextField();
			txt_HienThiID.setEditable(false);
			txt_HienThiID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiID.setBorder(null);
			txt_HienThiID.setBackground(null);
			txt_HienThiID.setBounds(109, 228, 86, 20);
			txt_HienThiID.setColumns(10);
			
			panel_Avt.add(txt_HienThiID);
			
			JLabel lb_TrangThai = new JLabel("Trạng thái:");
			lb_TrangThai.setForeground(new Color(0, 0, 128));
			lb_TrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lb_TrangThai.setBounds(10, 255, 89, 20);
			
			panel_Avt.add(lb_TrangThai);
			
			txt_HienThiTrangThai = new JTextField();
			txt_HienThiTrangThai.setEditable(false);
			txt_HienThiTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiTrangThai.setBorder(null);
			txt_HienThiTrangThai.setBackground(null);
			txt_HienThiTrangThai.setColumns(10);
			txt_HienThiTrangThai.setBounds(109, 255, 86, 20);
			
			panel_Avt.add(txt_HienThiTrangThai);
			
			btnthem = new JButton("Thêm nhân viên");
			btnthem.setBounds(33, 26, 141, 35);
			btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	
			panel_NhanVien.add(btnthem);
			
			btnCapNhat = new JButton("Cập nhật");
			btnCapNhat.setBounds(206, 26, 141, 35);
			btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	
			
			panel_NhanVien.add(btnCapNhat);
			
			textTimKiem = new JTextField();
			textTimKiem.setBounds(823, 26, 245, 35);
			textTimKiem.setColumns(10);
			
			panel_NhanVien.add(textTimKiem);
			
			btnTimKiem = new JButton("Tìm kiếm");
			btnTimKiem.setBounds(1070, 26, 127, 35);
			btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			
			panel_NhanVien.add(btnTimKiem);
			
			this.add(panel_NhanVien);
			
			docDuLieuTuDataVaoTable();
			
			btnthem.addActionListener(this);
			btnCapNhat.addActionListener(this);
			btnTimKiem.addActionListener(this);
			tableNhanVien.addMouseListener(this);
			
			
			
	  }
	
	  private void giaoDienThemCapNhatNV() {
			setForeground(new Color(255, 255, 255));
			setPreferredSize(new DimensionUIResource(this.width, this.height));

			panel_Them_SuaNhanVien = new RoundPanel();
			panel_Them_SuaNhanVien.setBackground(new Color(192, 192, 192));
			panel_Them_SuaNhanVien.setRound(50);
			panel_Them_SuaNhanVien.setLayout(null);
			
			RoundPanel panel_0 = new RoundPanel();
			panel_0.setSize(1239, 70);
			panel_0.setLocation(10, 10);
			panel_0.setBackground(new Color(168, 211, 255));
			panel_0.setRound(20);
			panel_0.setLayout(new BorderLayout(0, 0));		
			
			RoundPanel panel_1 = new RoundPanel();
			panel_1.setSize(877, 560);
			panel_1.setLocation(10, 92);
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setRound(20);
			panel_1.setLayout(null);
			
			
			RoundPanel panel_2 = new RoundPanel();
			panel_2.setLocation(897, 92);
			panel_2.setSize(352, 560);
			panel_2.setBackground(new Color(255, 255, 255));
			panel_2.setRound(20);
			panel_2.setLayout(null);
			
			RoundPanel panel_3 = new RoundPanel();
			panel_3.setSize(1239, 110);
			panel_3.setLocation(10, 665);
			panel_3.setBackground(new Color(255, 255, 255));
			panel_3.setRound(20);
			panel_3.setLayout(null);
			
			panel_Them_SuaNhanVien.add(panel_3);
			panel_Them_SuaNhanVien.add(panel_2);
			panel_Them_SuaNhanVien.add(panel_1);
			panel_Them_SuaNhanVien.add(panel_0);

			JLabel lbl_NgayCongTac = new JLabel("Ngày công tác:");
			lbl_NgayCongTac.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgayCongTac.setBounds(438, 110, 150, 40);
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
	        dateChooser_NgaySinh.setDateFormatString("dd/MM/yyy"); // Đặt định dạng ngày
	        panel_1.add(dateChooser_NgaySinh);
			
	
			JLabel lbl_PhongBan = new JLabel("Phòng Ban:");
			lbl_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_PhongBan.setBounds(438, 190, 150, 40);
			panel_1.add(lbl_PhongBan);
			
	
			
			lbl_NgayKetThucCT = new JLabel("Ngày kết thúc:");
			lbl_NgayKetThucCT.setVisible(false);
			lbl_NgayKetThucCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgayKetThucCT.setBounds(438, 350, 150, 40);
			panel_1.add(lbl_NgayKetThucCT);
			ButtonGroup group = new ButtonGroup();
			rdNam = new JRadioButton("Nam");
			rdNam.setSelected(true);
			rdNam.setBackground(null);
			rdNam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rdNam.setBounds(136, 270, 100, 40);
			panel_1.add(rdNam);
		    
			rdNu = new JRadioButton("Nữ");
			rdNu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rdNu.setBounds(286, 270, 100, 40);
			rdNu.setBackground(null);
			panel_1.add(rdNu);
			group.add(rdNam);
			
			group.add(rdNu);
			dateChooser_ngayKTCT = new JDateChooser();
			dateChooser_ngayKTCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_ngayKTCT.setDateFormatString("dd/MM/yyy");
			dateChooser_ngayKTCT.setBounds(627, 350, 229, 40);
			panel_1.add(dateChooser_ngayKTCT);
			
			cb_PhongBan = new JComboBox<String>();
			cb_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cb_PhongBan.setBounds(627, 190, 229, 40);
			panel_1.add(cb_PhongBan);
			
			pb_bus = new PhongBan_BUS();
			ArrayList<PhongBan> listPB = pb_bus.getDSPB();
			for (PhongBan pb : listPB) {
				cb_PhongBan.addItem(pb.getTenPhongBan());
			}
		
			

	        avatarImage = new JLabel();
	        avatarImage.setBounds(26, 35, 300, 400);
	        panel_2.add(avatarImage);

	        int labelWidth = avatarImage.getWidth();
            int labelHeight = avatarImage.getHeight();

            ImageIcon avatarIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
			// Chỉnh kích thước ảnh theo JLabel
            Image avatar = avatarIcon .getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            avatarIcon = new ImageIcon(avatar);
            avatarImage.setIcon(avatarIcon);
			
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
			
			btnHuy = new JButton("Hủy");
			btnHuy.setForeground(Color.BLACK);
			btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnHuy.setBackground(new Color(255, 0, 0));
			btnHuy.setBounds(680, 30, 150, 60);
			panel_3.add(btnHuy);
			
			
			btnCapNhatNhanVien = new JButton("Cập nhật");
			btnCapNhatNhanVien.setForeground(Color.BLACK);
			btnCapNhatNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnCapNhatNhanVien.setBackground(Color.GREEN);
			btnCapNhatNhanVien.setBounds(400, 30, 150, 60);
			panel_3.add(btnCapNhatNhanVien);
			
			btnHuy.addActionListener(this);
			setLayout(new BorderLayout(0, 0));
			this.add(panel_Them_SuaNhanVien);
			

			
			
			
			lbl_CCCD = new JLabel("CCCD:");
			lbl_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_CCCD.setBounds(438, 40, 150, 40);
			panel_1.add(lbl_CCCD);
			
			txtCCCD = new JTextField();
			txtCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtCCCD.setColumns(10);
			txtCCCD.setBounds(627, 40, 229, 40);
			panel_1.add(txtCCCD);
			

			
;
			
			dateChooser_ngayCT = new JDateChooser();
			
			dateChooser_ngayCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_ngayCT.setDateFormatString("dd/MM/yyy");
		
			dateChooser_ngayCT.setBounds(627, 110, 229, 40);
			panel_1.add(dateChooser_ngayCT);
			
			JLabel lbl_ID = new JLabel("ID:");
			lbl_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_ID.setBounds(20, 30, 110, 40);
			panel_1.add(lbl_ID);
			
			txtID = new JTextField();
			txtID.setEnabled(false);
			txtID.setEditable(false);
			txtID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtID.setColumns(10);
			txtID.setBounds(140, 30, 221, 40);
			panel_1.add(txtID);
			
			JLabel lbl_ChucVu = new JLabel("Chức vụ:");
			lbl_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_ChucVu.setBounds(438, 270, 150, 40);
			panel_1.add(lbl_ChucVu);
			
			cb_ChucVu = new JComboBox<String>();
			cb_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cb_ChucVu.setBounds(627, 270, 229, 40);
			panel_1.add(cb_ChucVu);
			lblChucNang = new JLabel("THÊM NHÂN VIÊN");
			lblChucNang.setBounds(19, 10, 1230, 70);
			panel_0.add(lblChucNang);
			lblChucNang.setBackground(new Color(162, 208, 255));
			lblChucNang.setForeground(new Color(0, 0, 0));
			lblChucNang.setHorizontalAlignment(SwingConstants.CENTER);
			lblChucNang.setFont(new Font("Times New Roman", Font.BOLD, 30));
			cv_bus = new ChucVu_BUS();
			ArrayList<ChucVu> listCV = cv_bus.getDSCV();
			for (ChucVu cv : listCV) {
				cb_ChucVu.addItem(cv.getTenChucVu());
			}
	
			btnChonAnh.addActionListener(this);
			btnCapNhatNhanVien.addActionListener(this);
			btnThemNhanVien.addActionListener(this);
		}

	  private void docDuLieuTuDataVaoTable() {
		  	
			ArrayList<NhanVien> list = nv_bus.getdsNV();
			for (NhanVien nv : list) {
				model.addRow(new Object[] {
						nv.getIdNhanVien(),
						nv.getHoTen(),
						nv.isPhai()?"Nam":"Nữ",
						nv.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						nv.getNgayBatDauCongTac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan(),
						cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu(),
						nv.getEmail(),
						nv.getSoDienThoai(),
						nv.getcCCD(),
						
						(nv.getNgayKetThucCongTac()==null)?"Đang làm":"Nghỉ làm"	
						
				});
				
			}
			
		}
	  private void hienThiGDCapNhat(String maNV) {
		  	panel_NhanVien.setVisible(false);
			giaoDienThemCapNhatNV();
			lblChucNang.setText("CẬP NHẬT NHÂN VIÊN");
			lbl_NgayKetThucCT.setVisible(true);
			dateChooser_ngayKTCT.setVisible(true);;
			btnThemNhanVien.setVisible(false);
			btnCapNhatNhanVien.setVisible(true);
			NhanVien nv = nv_bus.getNV(maNV);
			txtID.setText(nv.getIdNhanVien());
			java.sql.Date selectedDate = java.sql.Date.valueOf(nv.getNgaySinh());
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
			txtEmail.setText(nv.getEmail());
			txtSDT.setText(nv.getSoDienThoai());
	
			cb_PhongBan.setSelectedItem(pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan());
			cb_ChucVu.setSelectedItem(cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu());
			if(nv.isPhai()) {
				rdNam.setSelected(true);
			}
			else {
				rdNu.setSelected(true);
			}
			ImageIcon hienThiImageIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
			if(nv.getAnhDaiDien()!=null) {
				hienThiImageIcon = new ImageIcon("src\\images\\"+nv.getAnhDaiDien());
			}
	
        	// Lấy kích thước mới của JLabel
            int labelWidth = avatarImage.getWidth();
            int labelHeight = avatarImage.getHeight();

            // Chỉnh kích thước ảnh theo JLabel
            Image avatar = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            hienThiImageIcon = new ImageIcon(avatar);
            avatarImage.setIcon(hienThiImageIcon);

	  }
	  private void hienThiThongTinNV(NhanVien nv) {
			txt_HienThiID.setText(nv.getIdNhanVien());
			txt_HienThiTrangThai.setText((nv.getNgayKetThucCongTac()==null)?"Đang làm":"Nghĩ làm");
			txt_HienThiHoTen.setText(nv.getHoTen());
			txt_HienThiNgaySinh.setText(nv.getNgaySinh().toString());
			txt_HienThiPhai.setText((nv.isPhai()==true)?"Nam":"Nữ");
			txt_HienThiCCCD.setText(nv.getcCCD());
			txt_HienThiSDT.setText(nv.getSoDienThoai());
			txt_HienThiEmail.setText(nv.getEmail());
			txt_HienThiCV.setText(cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu());
			txt_HienThiPB.setText(pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan());
			ImageIcon hienThiImageIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
			if(nv.getAnhDaiDien()!=null) {
				hienThiImageIcon = new ImageIcon("src\\images\\"+nv.getAnhDaiDien());
			}
        	// Lấy kích thước mới của JLabel
            int labelWidth = hienThiAvatar.getWidth();
            int labelHeight = hienThiAvatar.getHeight();
            // Chỉnh kích thước ảnh theo JLabel
            Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        	hienThiImageIcon = new ImageIcon(themAnh);
            hienThiAvatar.setIcon(hienThiImageIcon);
	  }
	  private void hienThiGDThem() {
		  	panel_NhanVien.setVisible(false);
			giaoDienThemCapNhatNV();
			String maNV = sinhMaNV();
		    txtID.setText(maNV);
			dateChooser_ngayKTCT.setVisible(false);;
			btnThemNhanVien.setVisible(true);
			btnCapNhatNhanVien.setVisible(false);
	  }
		private String sinhMaNV() {
			int stt = 1;
			ArrayList<NhanVien>  list= nv_bus.getdsNV();
			String id="NV" + String.format("%04d",  stt);
			for (NhanVien nv : list) {
				if(nv.getIdNhanVien().equals(id)) {
					stt++;
					id="NV" + String.format("%04d",  stt);
				}
			}
			return id;
		}
	  private NhanVien layTTNVTuTextField() {
		  String maNV = txtID.getText();
		  String tenNV = txtHoTen.getText();
		  
		  Date nsDate = dateChooser_NgaySinh.getDate();

		  int yearNS = nsDate.getYear()+1900;		  
		  int monthNS = nsDate.getMonth()+1;		
		  int dayNS = nsDate.getDate();
		  LocalDate ns = LocalDate.of(yearNS, monthNS, dayNS);
	      
		  Date ctDate = dateChooser_ngayCT.getDate();
		  int yearCT = ctDate.getYear()+1900;
		  int monthCT = ctDate.getMonth()+1;
		  int dayCT = ctDate.getDate();
		  LocalDate ct = LocalDate.of(yearCT, monthCT, dayCT);
		  
		  LocalDate ktct=null;
		  if(dateChooser_ngayKTCT.getDate()!=null) {
			  Date ktctDate = dateChooser_ngayKTCT.getDate();
			  int yearKTCT = ktctDate.getYear()+1900;
			  int monthKTCT = ktctDate.getMonth()+1;
			  int dayKTCT = ktctDate.getDate();
			  ktct = LocalDate.of(yearKTCT, monthKTCT, dayKTCT);
		  }
		  
		  String tenPB = cb_PhongBan.getSelectedItem().toString();
		  PhongBan pb = pb_bus.getPBTheoTen(tenPB);
		  ChucVu cv = cv_bus.getCVTheoTen(cb_ChucVu.getSelectedItem().toString());
		  boolean phai = rdNam.isSelected();
		  String email = txtEmail.getText();
		  String sdt =  txtSDT.getText();
		  String cccd = txtCCCD.getText();
		  String avatar = null;
//		  TaiKhoan tk = new TaiKhoan(tenPB);
		  if(url != null) {
			  File absoluteFile = new File(url);
			  avatar = absoluteFile.getName();

		  }
		  NhanVien nv = new NhanVien(maNV, tenPB, phai, ns, ct, ktct, email, sdt, cv, new TaiKhoan(maNV), pb, avatar, cccd);
		  return nv;
	  }
	  	
	
	  
	  
	  
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub'
			Object o = e.getSource();
			if(o.equals(btnThemNhanVien)){
				 	NhanVien nv = layTTNVTuTextField();
				 	nv_bus.create(nv);
					panel_Them_SuaNhanVien.setVisible(false);
			
					String maNV = nv.getIdNhanVien();
					NhanVien nv2 = nv_bus.getNV(maNV);
					int m = nv_bus.getdsNV().indexOf(nv2);
					giaoDienNV();
					tableNhanVien.setRowSelectionInterval(m, m);
					tableNhanVien.scrollRectToVisible(tableNhanVien.getCellRect(m, m, true));
					hienThiThongTinNV(nv);	
			
			}
			if(o.equals(btnthem)){
				hienThiGDThem();
			}
			
			if(o.equals(btnHuy)){
				int n = tableNhanVien.getSelectedRow();
				panel_Them_SuaNhanVien.setVisible(false);
				if (n!=-1) {
			
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
					
					hienThiGDCapNhat(maNV);
				}
			}
			if(o.equals(btnCapNhatNhanVien)) {
				NhanVien nv_new = layTTNVTuTextField();
				nv_bus.update(nv_new);
				panel_Them_SuaNhanVien.setVisible(false);
				String maNV = nv_new.getIdNhanVien();
				NhanVien nv2 = nv_bus.getNV(maNV);
				int m = nv_bus.getdsNV().indexOf(nv2);
				giaoDienNV();
				tableNhanVien.setRowSelectionInterval(m, m);
				tableNhanVien.scrollRectToVisible(tableNhanVien.getCellRect(m, m, true));
				hienThiThongTinNV(nv_new);
			}
			if(o.equals(btnChonAnh)) {
		            JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Chọn ảnh");
		            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		            int result = fileChooser.showOpenDialog(null);

		            if (result == JFileChooser.APPROVE_OPTION) {
		                // Đoạn mã xử lý khi người dùng chọn tệp ảnh ở đây
		            	url = fileChooser.getSelectedFile().getAbsolutePath();
		            	ImageIcon avatarIcon = new ImageIcon(url);
		            	
		            	// Lấy kích thước mới của JLabel
		                int labelWidth = avatarImage.getWidth();
		                int labelHeight = avatarImage.getHeight();

		                // Chỉnh kích thước ảnh theo JLabel
		                Image avatar = avatarIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		                avatarIcon = new ImageIcon(avatar);
		                
		                avatarImage.setIcon(avatarIcon);
		                
		              
						
		              
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
