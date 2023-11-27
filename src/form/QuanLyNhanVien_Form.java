package form;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entities.ChucVu;
import entities.NhanVien;
import entities.PhongBan;
import entities.TaiKhoan;

import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import bus.ChucVu_BUS;
import bus.NhanVien_BUS;
import bus.PhongBan_BUS;
import commons.RoundPanel;
import commons.Table;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

/**
 * 
 * @author Nguyễn Gia Bảo, Ngô Quốc Đạt, Nguyễn Nhất Dương, Võ Văn Nghĩa Hiệp
 * @version 1.0
 *
 */

public class QuanLyNhanVien_Form extends JPanel implements ActionListener, MouseListener, FocusListener {

	private DefaultTableModel model;

	private JTextField txtTimKiem;
	private JTextField txt_HienThiID;
	private JTextField txt_HienThiHoTen;
	private JTextField txt_HienThiPhai;
	private JTextField txt_HienThiCCCD;
	private JTextField txt_HienThiNgaySinh;
	private JTextField txt_HienThiCV;
	private JTextField txt_HienThiPB;
	private JTextField txt_HienThiSDT;
	private JTextField txt_HienThiEmail;
	private int width = 1259;
	private int height = 813;
	private JButton btnChonAnh;


	private JButton btnHuy;

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



	private PhongBan_BUS pb_bus;

	private ChucVu_BUS cv_bus;

	private JLabel avatarImage;

	private JLabel hienThiAvatar;

	private String url;

	private JLabel lbl_NgayKetThucCT;

	private JDialog dl_ThemCapNhatNV;

	private JTextField txtCheckHoTen;

	private JTextField txtCheckNS;

	private JTextField txtCheckEmail;

	private JTextField txtCheckSDT;

	private JTextField txtCheckCCCD;

	private JTextField txtCheckNCT;

	private JTextField txtCheckNKTCT;



	private JButton btnGoAnh;

	private JButton btnCapNhatNhanVien;

	private JButton btnThemNhanVien;

	private JButton btnLamMoi;

	/**
	 * Create the frame.
	 */
	public QuanLyNhanVien_Form(int width, int height) {

		this.width = width;
		this.height = height;
		giaoDienNV();
//			dialogThemCapNhat();

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
		// Panel danh sách nhan vien

		panel_NhanVien = new JPanel();
		panel_NhanVien.setBounds(0, 0, 1259, 813);
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

		String[] headers = { "ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00E1i", "Ng\u00E0y sinh", "Ngày công tác",
				"Ph\u00F2ng ban", "Ch\u1EE9c v\u1EE5", "Email", "S\u0110T", "CCCD" };
		model = new DefaultTableModel(headers, 0);

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

		// Panel chi tiet thong tin 1 nhan vien
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
		lb_ID.setBounds(10, 250, 45, 20);
		lb_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		panel_Avt.add(lb_ID);

		txt_HienThiID = new JTextField();
		txt_HienThiID.setEditable(false);
		txt_HienThiID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_HienThiID.setBorder(null);
		txt_HienThiID.setBackground(null);
		txt_HienThiID.setBounds(65, 250, 130, 20);
		txt_HienThiID.setColumns(10);

		panel_Avt.add(txt_HienThiID);

		btnthem = new JButton("Thêm nhân viên");
		btnthem.setBounds(33, 26, 141, 35);
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		panel_NhanVien.add(btnthem);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(206, 26, 141, 35);
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		panel_NhanVien.add(btnCapNhat);

		txtTimKiem = new JTextField("Nhập mã nhân viên cần tìm VD: NV0001");
		txtTimKiem.setForeground(Color.GRAY);
		txtTimKiem.setBounds(823, 26, 245, 35);
		txtTimKiem.setColumns(10);

		panel_NhanVien.add(txtTimKiem);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(1070, 26, 127, 35);
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLamMoi.setBounds(672, 26, 141, 35);
		panel_NhanVien.add(btnLamMoi);
		
		
		
		panel_NhanVien.add(btnTimKiem);

		this.add(panel_NhanVien);

		docDuLieuTuDataVaoTable();
		btnLamMoi.addActionListener(this);
		btnthem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnTimKiem.addActionListener(this);
		txtTimKiem.addFocusListener(this);
		tableNhanVien.addMouseListener(this);

	}

	private void dialogThemCapNhat() {
		dl_ThemCapNhatNV = new JDialog();

		dl_ThemCapNhatNV.setSize(750, 650);
		dl_ThemCapNhatNV.setTitle("Thêm nhân viên");
		dl_ThemCapNhatNV.setLocationRelativeTo(null);
		JPanel panel_Center = new JPanel();
		panel_Center.setLayout(null);

		JLabel lbl_ID = new JLabel("ID:");
		lbl_ID.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_ID.setBounds(20, 10, 110, 20);
		panel_Center.add(lbl_ID);

		txtID = new JTextField();
		txtID.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtID.setEditable(false);
		txtID.setFont(new Font("Times New Roman", Font.BOLD, 17));
		txtID.setColumns(10);
		txtID.setFocusable(false);
		txtID.setBounds(148, 10, 96, 20);
		panel_Center.add(txtID);

		JLabel lbl_HoTen = new JLabel("Họ và tên:");
		lbl_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_HoTen.setBounds(20, 60, 110, 20);
		panel_Center.add(lbl_HoTen);

		txtHoTen = new JTextField("Nhập họ tên");
		txtHoTen.setForeground(Color.GRAY);
		txtHoTen.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtHoTen.setBackground(null);
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(148, 60, 320, 20);
		panel_Center.add(txtHoTen);

		JLabel lbl_Phai = new JLabel("Phái:");
		lbl_Phai.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_Phai.setBounds(20, 160, 110, 20);
		panel_Center.add(lbl_Phai);

		ButtonGroup group = new ButtonGroup();
		rdNam = new JRadioButton("Nam");
		rdNam.setBackground(null);
		rdNam.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdNam.setBounds(148, 160, 79, 20);
		rdNam.setSelected(true);

		rdNu = new JRadioButton("Nữ");
		rdNu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdNu.setBounds(290, 160, 79, 20);
		rdNu.setBackground(null);
		group.add(rdNam);
		group.add(rdNu);

		panel_Center.add(rdNam);
		panel_Center.add(rdNu);

		JLabel lbl_NgaySinh = new JLabel("Ngày Sinh:");
		lbl_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_NgaySinh.setBounds(20, 110, 110, 25);
		panel_Center.add(lbl_NgaySinh);

		dateChooser_NgaySinh = new JDateChooser();
		dateChooser_NgaySinh.setForeground(new Color(0, 0, 0));
		dateChooser_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dateChooser_NgaySinh.setSize(157, 25);
		dateChooser_NgaySinh.setLocation(148, 110);
		dateChooser_NgaySinh.setDateFormatString("dd/MM/yyyy"); // Đặt định dạng ngày
		dateChooser_NgaySinh.getDateEditor().setEnabled(false);
		panel_Center.add(dateChooser_NgaySinh);

		JLabel lbl_NgayCongTac = new JLabel("Ngày công tác:");
		lbl_NgayCongTac.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_NgayCongTac.setBounds(20, 460, 120, 25);
		panel_Center.add(lbl_NgayCongTac);

		dateChooser_ngayCT = new JDateChooser();
		dateChooser_ngayCT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dateChooser_ngayCT.setDateFormatString("dd/MM/yyyy");
		dateChooser_ngayCT.getDateEditor().setEnabled(false);
		dateChooser_ngayCT.setBounds(148, 460, 157, 25);
		panel_Center.add(dateChooser_ngayCT);

		JLabel lbl_Email = new JLabel("Email:");
		lbl_Email.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_Email.setBounds(20, 210, 110, 20);
		panel_Center.add(lbl_Email);

		txtEmail = new JTextField("Nhập email");
		txtEmail.setForeground(Color.GRAY);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtEmail.setColumns(10);
		txtEmail.setBackground(null);
		txtEmail.setBounds(148, 210, 320, 20);
		panel_Center.add(txtEmail);

		JLabel lbl_SDT = new JLabel("Số điện thoại:");
		lbl_SDT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_SDT.setBounds(20, 260, 110, 20);
		panel_Center.add(lbl_SDT);

		txtSDT = new JTextField("Nhập số điện thoại");
		txtSDT.setForeground(Color.GRAY);
		txtSDT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtSDT.setBackground(null);
		txtSDT.setColumns(10);
		txtSDT.setBounds(148, 260, 200, 20);
		panel_Center.add(txtSDT);

		JLabel lbl_ChucVu = new JLabel("Chức vụ:");
		lbl_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_ChucVu.setBounds(20, 410, 120, 25);
		panel_Center.add(lbl_ChucVu);

		cb_ChucVu = new JComboBox<String>();
		ArrayList<ChucVu> listCV = cv_bus.getDSCV();

		for (ChucVu chucVu : listCV) {
			cb_ChucVu.addItem(chucVu.getTenChucVu());
		}
		cb_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		cb_ChucVu.setBounds(148, 410, 200, 25);
		panel_Center.add(cb_ChucVu);

		lbl_NgayKetThucCT = new JLabel("Ngày kết thúc:");
		lbl_NgayKetThucCT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_NgayKetThucCT.setBounds(20, 510, 120, 25);
		panel_Center.add(lbl_NgayKetThucCT);

		dateChooser_ngayKTCT = new JDateChooser();
		dateChooser_ngayKTCT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dateChooser_ngayKTCT.setDateFormatString("dd/MM/yyyy");
		dateChooser_ngayKTCT.setBounds(148, 510, 157, 25);
		dateChooser_ngayKTCT.getDateEditor().setEnabled(false);
		panel_Center.add(dateChooser_ngayKTCT);

		lbl_CCCD = new JLabel("CCCD:");
		lbl_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_CCCD.setBounds(20, 310, 110, 20);
		panel_Center.add(lbl_CCCD);

		txtCCCD = new JTextField("Nhập căn cước công dân");
		txtCCCD.setForeground(Color.GRAY);
		txtCCCD.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtCCCD.setColumns(10);
		txtCCCD.setBackground(null);
		txtCCCD.setBounds(148, 310, 200, 20);
		panel_Center.add(txtCCCD);

		JLabel lbl_PhongBan = new JLabel("Phòng ban:");
		lbl_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_PhongBan.setBounds(20, 360, 120, 25);
		panel_Center.add(lbl_PhongBan);

		cb_PhongBan = new JComboBox<String>();
		ArrayList<PhongBan> listPB = pb_bus.getDSPB();

		for (PhongBan phongBan : listPB) {
			cb_PhongBan.addItem(phongBan.getTenPhongBan());
		}
		cb_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		cb_PhongBan.setBounds(148, 360, 200, 25);
		panel_Center.add(cb_PhongBan);

		txtCheckHoTen = new JTextField();
		txtCheckHoTen.setEditable(false);
		txtCheckHoTen.setBorder(null);
		txtCheckHoTen.setFocusable(false);
		txtCheckHoTen.setForeground(new Color(255, 0, 0));
		txtCheckHoTen.setBackground(null);
		txtCheckHoTen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckHoTen.setColumns(10);
		txtCheckHoTen.setBounds(148, 80, 336, 20);
		panel_Center.add(txtCheckHoTen);

		txtCheckNS = new JTextField();
		txtCheckNS.setEditable(false);
		txtCheckNS.setFocusable(false);
		txtCheckNS.setBorder(null);
		txtCheckNS.setForeground(new Color(255, 0, 0));
		txtCheckNS.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckNS.setColumns(10);
		txtCheckNS.setBackground(null);
		txtCheckNS.setBounds(148, 135, 336, 20);
		panel_Center.add(txtCheckNS);

		txtCheckEmail = new JTextField();
		txtCheckEmail.setFocusable(false);
		txtCheckEmail.setEditable(false);
		txtCheckEmail.setBorder(null);
		txtCheckEmail.setForeground(new Color(255, 0, 0));
		txtCheckEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckEmail.setColumns(10);
		txtCheckEmail.setBackground(null);
		txtCheckEmail.setBounds(148, 230, 336, 20);
		panel_Center.add(txtCheckEmail);

		txtCheckSDT = new JTextField();
		txtCheckSDT.setEditable(false);
		txtCheckSDT.setBorder(null);
		txtCheckSDT.setFocusable(false);
		txtCheckSDT.setForeground(new Color(255, 0, 0));
		txtCheckSDT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckSDT.setColumns(10);
		txtCheckSDT.setBackground(null);
		txtCheckSDT.setBounds(148, 280, 336, 20);
		panel_Center.add(txtCheckSDT);

		txtCheckCCCD = new JTextField();
		txtCheckCCCD.setEditable(false);
		txtCheckCCCD.setFocusable(false);
		txtCheckCCCD.setBorder(null);
		txtCheckCCCD.setForeground(new Color(255, 0, 0));
		txtCheckCCCD.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckCCCD.setColumns(10);
		txtCheckCCCD.setBackground(null);
		txtCheckCCCD.setBounds(148, 330, 336, 20);
		panel_Center.add(txtCheckCCCD);

		txtCheckNCT = new JTextField();
		txtCheckNCT.setFocusable(false);
		txtCheckNCT.setEditable(false);
		txtCheckNCT.setBorder(null);
		txtCheckNCT.setForeground(new Color(255, 0, 0));
		txtCheckNCT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckNCT.setColumns(10);
		txtCheckNCT.setBackground(null);
		txtCheckNCT.setBounds(148, 385, 336, 20);
		panel_Center.add(txtCheckNCT);

		txtCheckNKTCT = new JTextField();
		txtCheckNKTCT.setEditable(false);
		txtCheckNKTCT.setFocusable(false);
		txtCheckNKTCT.setBorder(null);
		txtCheckNKTCT.setForeground(new Color(255, 0, 0));
		txtCheckNKTCT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckNKTCT.setColumns(10);
		txtCheckNKTCT.setBackground(null);
		txtCheckNKTCT.setBounds(148, 535, 336, 20);
		panel_Center.add(txtCheckNKTCT);

		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(473, 60, 11, 20);
		panel_Center.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(315, 110, 11, 20);
		panel_Center.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(473, 210, 11, 20);
		panel_Center.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(358, 260, 11, 20);
		panel_Center.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(358, 310, 11, 20);
		panel_Center.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(315, 462, 11, 20);
		panel_Center.add(lblNewLabel_5);

		avatarImage = new JLabel();
		avatarImage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		avatarImage.setBounds(505, 30, 200, 300);
		int labelWidth = avatarImage.getWidth();
		int labelHeight = avatarImage.getHeight();
		ImageIcon avatarIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
		// Chỉnh kích thước ảnh theo JLabel
		Image avatar = avatarIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		avatarIcon = new ImageIcon(avatar);

		avatarImage.setIcon(avatarIcon);
		panel_Center.add(avatarImage);

		btnChonAnh = new JButton("Chọn ảnh");
		btnChonAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnChonAnh.setBounds(538, 340, 130, 30);
		panel_Center.add(btnChonAnh);

		dl_ThemCapNhatNV.getContentPane().add(panel_Center, BorderLayout.CENTER);

		btnGoAnh = new JButton("Gỡ ảnh");
		btnGoAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnGoAnh.setBounds(538, 379, 130, 30);
		panel_Center.add(btnGoAnh);

		JPanel panel_ChucNang = new JPanel();
		panel_ChucNang.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnThemNhanVien = new JButton("Thêm");
		btnThemNhanVien.setBackground(new Color(0, 255, 0));
		btnThemNhanVien.setForeground(new Color(0, 0, 0));
		btnThemNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThemNhanVien.setBounds(400, 30, 150, 60);
		panel_ChucNang.add(btnThemNhanVien);

		btnCapNhatNhanVien = new JButton("Cập nhật");
		btnCapNhatNhanVien.setForeground(Color.BLACK);
		btnCapNhatNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCapNhatNhanVien.setBackground(Color.GREEN);
		btnCapNhatNhanVien.setBounds(400, 30, 150, 60);
		panel_ChucNang.add(btnCapNhatNhanVien);
		Box b;
		b = Box.createVerticalBox();
		b.add(Box.createRigidArea(new Dimension(150, 30)));

		panel_ChucNang.add(b);
		btnHuy = new JButton("Hủy");
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuy.setBackground(new Color(255, 0, 0));
		btnHuy.setBounds(700, 30, 150, 60);
		panel_ChucNang.add(btnHuy);
		dl_ThemCapNhatNV.getContentPane().add(panel_ChucNang, BorderLayout.SOUTH);

		dl_ThemCapNhatNV.setVisible(true);
		btnHuy.addActionListener(this);
		btnThemNhanVien.addActionListener(this);
		btnChonAnh.addActionListener(this);
		btnGoAnh.addActionListener(this);
		btnCapNhatNhanVien.addActionListener(this);
		txtHoTen.addFocusListener(this);
		txtEmail.addFocusListener(this);
		txtCCCD.addFocusListener(this);
		txtSDT.addFocusListener(this);
		dateChooser_NgaySinh.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					// Xử lý khi ngày thay đổi
					Date nsDate = dateChooser_NgaySinh.getDate();

					int yearNS = nsDate.getYear() + 1900;

					// Lấy ngày hiện tại
					Calendar calendar = Calendar.getInstance();
					Date currentDate = calendar.getTime();

					JDateChooser dateChooser = new JDateChooser();
					// Đặt ngày hiện tại cho JDateChooser
					dateChooser.setDate(currentDate);
					Date ngayHT = dateChooser.getDate();
					int yearHT = ngayHT.getYear() + 1900;
					if (!(yearHT - yearNS >= 18)) {
						txtCheckNS.setText("Trước năm hiện tại 18 năm!");
					} else {
						txtCheckNS.setText("");
					}
				}
			}

		});
		dateChooser_ngayCT.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					// Xử lý khi ngày thay đổi
					Date ctDate = dateChooser_ngayCT.getDate();

					// Lấy ngày hiện tại
					Calendar calendar = Calendar.getInstance();
					Date currentDate = calendar.getTime();

					JDateChooser dateChooser = new JDateChooser();
					// Đặt ngày hiện tại cho JDateChooser
					dateChooser.setDate(currentDate);
					Date ngayHT = dateChooser.getDate();
					int result = ctDate.compareTo(ngayHT);
					if (!(result <= 0)) {
						txtCheckNCT.setText("Bằng hoặc trước ngày hiện tại!");
					} else {
						txtCheckNCT.setText("");
					}
				}
			}
		});

		dateChooser_ngayKTCT.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					// Xử lý khi ngày thay đổi
					Date ktctDate = dateChooser_ngayKTCT.getDate();
					Date ctDate = dateChooser_ngayCT.getDate();
					// Lấy ngày hiện tại
					Calendar calendar = Calendar.getInstance();
					Date currentDate = calendar.getTime();

					JDateChooser dateChooser = new JDateChooser();
					// Đặt ngày hiện tại cho JDateChooser
					dateChooser.setDate(currentDate);
					Date ngayHT = dateChooser.getDate();
					int result = ktctDate.compareTo(ngayHT);
					int result2 = ktctDate.compareTo(ctDate);
					if (!(result <= 0 && result2 > 0)) {
						txtCheckNKTCT.setText("Bằng hoặc trước ngày hiện tại , sau ngày công tác!");
					} else {
						txtCheckNKTCT.setText("");
					}
				}
			}

		});
	}

	private void docDuLieuTuDataVaoTable() {

		ArrayList<NhanVien> list = nv_bus.getdsNVDangLam();
		for (NhanVien nv : list) {
			model.addRow(new Object[] { nv.getIdNhanVien(), nv.getHoTen(), nv.isPhai() ? "Nam" : "Nữ",
					nv.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					nv.getNgayBatDauCongTac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan(),
					cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu(), nv.getEmail(), nv.getSoDienThoai(),
					nv.getcCCD()

			});

		}

	}

	private void hienThiDialogCapNhat(String maNV) {
		dialogThemCapNhat();
		dl_ThemCapNhatNV.setTitle("Cập nhật nhân viên");
		lbl_NgayKetThucCT.setVisible(true);
		dateChooser_ngayKTCT.setVisible(true);
		txtCheckNKTCT.setVisible(true);
		btnCapNhatNhanVien.setVisible(true);
		btnThemNhanVien.setVisible(false);

		NhanVien nv = nv_bus.getNhanVienDangLamTheoID(maNV);

		txtID.setText(nv.getIdNhanVien());
		Date dateNS = java.sql.Date.valueOf(nv.getNgaySinh());
		dateChooser_NgaySinh.setDate(dateNS);
		Date dateNCT = java.sql.Date.valueOf(nv.getNgayBatDauCongTac());
		dateChooser_ngayCT.setDate(dateNCT);

		txtHoTen.setText(nv.getHoTen());
		txtHoTen.setForeground(Color.BLACK);
		txtCCCD.setText(nv.getcCCD());
		txtCCCD.setForeground(Color.BLACK);
		txtEmail.setText(nv.getEmail());
		txtEmail.setForeground(Color.BLACK);
		txtSDT.setText(nv.getSoDienThoai());
		txtSDT.setForeground(Color.BLACK);
		if (nv.isPhai()) {
			rdNam.setSelected(true);
		} else {
			rdNu.setSelected(true);
		}
		cb_PhongBan.setSelectedItem(nv.getPhongBan().getTenPhongBan());
		cb_ChucVu.setSelectedItem(nv.getChucVu().getIdChucVu());
		url = "src\\images\\Unknown_person.jpg";
		ImageIcon hienThiImageIcon = new ImageIcon(url);

		if (nv.getAnhDaiDien() != null) {
			url = "src\\images\\" + nv.getAnhDaiDien();
			hienThiImageIcon = new ImageIcon(url);
		}

		// Lấy kích thước mới của JLabel
		int labelWidth = avatarImage.getWidth();
		int labelHeight = avatarImage.getHeight();

		// Chỉnh kích thước ảnh theo JLabel
		Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		hienThiImageIcon = new ImageIcon(themAnh);
		avatarImage.setIcon(hienThiImageIcon);

	}

	private void hienThiThongTinNV(NhanVien nv) {
		txt_HienThiID.setText(nv.getIdNhanVien());
		txt_HienThiHoTen.setText(nv.getHoTen());
		txt_HienThiNgaySinh.setText(nv.getNgaySinh().toString());
		txt_HienThiPhai.setText((nv.isPhai() == true) ? "Nam" : "Nữ");
		txt_HienThiCCCD.setText(nv.getcCCD());
		txt_HienThiSDT.setText(nv.getSoDienThoai());
		txt_HienThiEmail.setText(nv.getEmail());
		txt_HienThiCV.setText(cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu());
		txt_HienThiPB.setText(pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan());
		ImageIcon hienThiImageIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
		if (nv.getAnhDaiDien() != null) {
			hienThiImageIcon = new ImageIcon("src\\images\\" + nv.getAnhDaiDien());
		}
		// Lấy kích thước mới của JLabel
		int labelWidth = hienThiAvatar.getWidth();
		int labelHeight = hienThiAvatar.getHeight();
		// Chỉnh kích thước ảnh theo JLabel
		Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		hienThiImageIcon = new ImageIcon(themAnh);
		hienThiAvatar.setIcon(hienThiImageIcon);
	}

	private void hienThiDialogThem() {
		dialogThemCapNhat();
		txtID.setText(sinhMaNV());
		lbl_NgayKetThucCT.setVisible(false);
		txtCheckNKTCT.setVisible(false);
		dateChooser_ngayKTCT.setVisible(false);
		btnThemNhanVien.setVisible(true);
		btnCapNhatNhanVien.setVisible(false);
	}

	private String sinhMaNV() {
		int stt = 1;
		ArrayList<NhanVien> list = nv_bus.getdsNV();
		String id = "NV" + String.format("%04d", stt);
		for (NhanVien nv : list) {
			if (nv.getIdNhanVien().equals(id)) {
				stt++;
				id = "NV" + String.format("%04d", stt);
			}
		}
		return id;
	}

	private NhanVien layTTNVTuTextField() {
		String maNV = txtID.getText();
		String tenNV = txtHoTen.getText();

		Date nsDate = dateChooser_NgaySinh.getDate();

		int yearNS = nsDate.getYear() + 1900;
		int monthNS = nsDate.getMonth() + 1;
		int dayNS = nsDate.getDate();
		LocalDate ns = LocalDate.of(yearNS, monthNS, dayNS);

		Date ctDate = dateChooser_ngayCT.getDate();
		int yearCT = ctDate.getYear() + 1900;
		int monthCT = ctDate.getMonth() + 1;
		int dayCT = ctDate.getDate();
		LocalDate ct = LocalDate.of(yearCT, monthCT, dayCT);

		LocalDate ktct = null;
		if (dateChooser_ngayKTCT.getDate() != null) {
			Date ktctDate = dateChooser_ngayKTCT.getDate();
			int yearKTCT = ktctDate.getYear() + 1900;
			int monthKTCT = ktctDate.getMonth() + 1;
			int dayKTCT = ktctDate.getDate();
			ktct = LocalDate.of(yearKTCT, monthKTCT, dayKTCT);
		}

		String tenPB = cb_PhongBan.getSelectedItem().toString();
		PhongBan pb = pb_bus.getPBTheoTen(tenPB);
		ChucVu cv = cv_bus.getCVTheoTen(cb_ChucVu.getSelectedItem().toString());
		boolean phai = rdNam.isSelected();
		String email = txtEmail.getText();
		String sdt = txtSDT.getText();
		String cccd = txtCCCD.getText();
		String avatar = null;
//		  TaiKhoan tk = new TaiKhoan(tenPB);
		if (url != null) {
			File absoluteFile = new File(url);
			avatar = absoluteFile.getName();

		}
		NhanVien nv = new NhanVien(maNV, tenNV, phai, ns, ct, ktct, email, sdt, cv, new TaiKhoan(maNV), pb, avatar,
				cccd);
		return nv;
	}

	private boolean validData() {

		String hoTen = txtHoTen.getText().trim();
		if (!hoTen.matches("[\\p{Lu}][\\p{L}]+([\\s]+[\\p{Lu}][\\p{L}]+)+")) {
			return false;
		}

		String sDT = txtSDT.getText().trim();
		if (!sDT.matches("^0[1|3|5|7|9][0-9]{8}$")) {
			return false;
		}
		String email = txtEmail.getText().trim();
		if (!email.matches("[a-zA-Z0-9_.]+\\@(gmail.com)")) {
			return false;
		}

		String cCCD = txtCCCD.getText().trim();
		if (!cCCD.matches("\\d{12}")) {
			return false;
		}
		Date nsDate = dateChooser_NgaySinh.getDate();
		if (nsDate == null) {
			return false;
		}
		int yearNS = nsDate.getYear() + 1900;

		// Lấy ngày hiện tại
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDate(currentDate);
		Date ngayHT = dateChooser.getDate();
		int yearHT = ngayHT.getYear() + 1900;
		if (!(yearHT - yearNS >= 18)) {
			return false;
		}
		Date ctDate = dateChooser_ngayCT.getDate();
		if (ctDate == null) {
			return false;
		}
		int result = ctDate.compareTo(ngayHT);
		if (!(result <= 0)) {
			return false;
		}

		Date ktctDate = dateChooser_ngayKTCT.getDate();
		if (ktctDate != null) {
			int result2 = ktctDate.compareTo(ctDate);
			if (!(result <= 0 && result2 > 0)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub'
		Object o = e.getSource();
		if (o.equals(btnThemNhanVien)) {
			if (validData()) {
				NhanVien nv = layTTNVTuTextField();
				JOptionPane.showMessageDialog(null, "Thêm thành công!");
				nv_bus.create(nv);
				dl_ThemCapNhatNV.setVisible(false);
				model.setRowCount(0);
				docDuLieuTuDataVaoTable();
				String maNV = nv.getIdNhanVien();
				NhanVien nv2 = nv_bus.getNhanVienDangLamTheoID(maNV);
				int m = nv_bus.getdsNVDangLam().indexOf(nv2);
				tableNhanVien.setRowSelectionInterval(m, m);
				tableNhanVien.scrollRectToVisible(tableNhanVien.getCellRect(m, m, true));
				hienThiThongTinNV(nv2);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng và đầy đủ thông tin cần nhập!");
			}
		}
		if (o.equals(btnthem)) {
			hienThiDialogThem();
			btnCapNhatNhanVien.setVisible(false);
		}

		if (o.equals(btnHuy)) {
			dl_ThemCapNhatNV.setVisible(false);
		}
		if (o.equals(btnTimKiem)) {
			String ma = txtTimKiem.getText();
			if (ma.equals("Nhập mã nhân viên cần tìm VD: NV0001")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên!");
			} else {

				NhanVien nv = nv_bus.getNhanVienDangLamTheoID(ma);
				if (nv != null) {
					model.setRowCount(0);
					model.addRow(new Object[] { ma, nv.getHoTen(), nv.isPhai() ? "Nam" : "Nữ", nv.getNgaySinh(),
							nv.getPhongBan().getTenPhongBan(), nv.getChucVu().getTenChucVu(), nv.getEmail(),
							nv.getSoDienThoai(), nv.getcCCD()

					});
					tableNhanVien.setRowSelectionInterval(0, 0);
					hienThiThongTinNV(nv);
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên có mã " + ma + "!");
				}

			}
		}
		if (o.equals(btnCapNhat)) {
			int r = tableNhanVien.getSelectedRow();
			if (r == -1) {

				JOptionPane.showMessageDialog(null, "Chọn 1 nhân viên để cập nhật!");
			} else {
				String maNV = tableNhanVien.getValueAt(r, 0).toString();

				hienThiDialogCapNhat(maNV);
			}
		}
		if (o.equals(btnCapNhatNhanVien)) {
			if(validData()) {
				NhanVien nv_new = layTTNVTuTextField();
				nv_bus.update(nv_new);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				dl_ThemCapNhatNV.setVisible(false);
				String maNV = nv_new.getIdNhanVien();
				NhanVien nv2 = nv_bus.getNhanVienDangLamTheoID(maNV);
				model.setRowCount(0);
				docDuLieuTuDataVaoTable();
				if (nv2 == null) {
					return;
				}
				int m = nv_bus.getdsNVDangLam().indexOf(nv2);
				tableNhanVien.setRowSelectionInterval(m, m);
				tableNhanVien.scrollRectToVisible(tableNhanVien.getCellRect(m, m, true));
				hienThiThongTinNV(nv2);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng và đầy đủ thông tin cần nhập!");
			}
		}
		if (o.equals(btnChonAnh)) {
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
		if(o.equals(btnLamMoi)) {
			model.setRowCount(0);
			docDuLieuTuDataVaoTable();
			txtTimKiem.setText("Nhập mã nhân viên cần tìm VD: NV0001");
			txtTimKiem.setForeground(Color.GRAY);
			txt_HienThiID.setText("");
			txt_HienThiHoTen.setText("");
			txt_HienThiEmail.setText("");
			txt_HienThiCCCD.setText("");
			txt_HienThiNgaySinh.setText("");
			txt_HienThiPhai.setText("");
			txt_HienThiPB.setText("");
			txt_HienThiSDT.setText("");
			txt_HienThiCV.setText("");
			
			ImageIcon hienThiImageIcon = new ImageIcon("src\\images\\Unknown_person.jpg");

			// Lấy kích thước mới của JLabel
			int labelWidth = hienThiAvatar.getWidth();
			int labelHeight = hienThiAvatar.getHeight();

			// Chỉnh kích thước ảnh theo JLabel
			Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
			hienThiImageIcon = new ImageIcon(themAnh);
			hienThiAvatar.setIcon(hienThiImageIcon);
			
		}
		if (o.equals(btnGoAnh)) {

			// Đoạn mã xử lý khi người dùng chọn tệp ảnh ở đây
			url = "src\\images\\Unknown_person.jpg";
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

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(txtTimKiem)) {
			 if (txtTimKiem.getText().equals("Nhập mã nhân viên cần tìm VD: NV0001")) {
				 txtTimKiem.setText("");
				 txtTimKiem.setForeground(Color.BLACK);
             }
		}
		if (o.equals(txtCCCD)) {
			txtCheckCCCD.setText("");
			 if (txtCCCD.getText().equals("Nhập căn cước công dân")) {
				 txtCCCD.setText("");
				 txtCCCD.setForeground(Color.BLACK);
            }
		}
		if (o.equals(txtEmail)) {
			 txtCheckEmail.setText("");
				 if (txtEmail.getText().equals("Nhập email")) {
					 txtEmail.setText("");
					 txtEmail.setForeground(Color.BLACK);
	            }
			}
		if (o.equals(txtSDT)) {
			 txtCheckSDT.setText("");
				 if (txtSDT.getText().equals("Nhập số điện thoại")) {
					 txtSDT.setText("");
					 txtSDT.setForeground(Color.BLACK);
	            }
			}
		if (o.equals(txtHoTen)) {
			 txtCheckHoTen.setText("");
				 if (txtHoTen.getText().equals("Nhập họ tên")) {
					 txtHoTen.setText("");
					 txtHoTen.setForeground(Color.BLACK);
	            }
			}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(txtHoTen)) {
			String hoTen = txtHoTen.getText().trim();
			if (hoTen.isEmpty()) {
				txtHoTen.setText("Nhập họ tên");
				txtHoTen.setForeground(Color.GRAY);
				return;
            }
			
			if (!hoTen.matches("[\\p{Lu}][\\p{L}]+([\\s]+[\\p{Lu}][\\p{L}]+)+")) {
				txtCheckHoTen.setText("Bắt đầu là chữ hoa và không có ký số!");
			} else {
				txtCheckHoTen.setText("");
			}
		}
		if (o.equals(txtSDT)) {
			String sDT = txtSDT.getText().trim();
			if (sDT.isEmpty()) {
				txtSDT.setText("Nhập số điện thoại");
				txtSDT.setForeground(Color.GRAY);
				return;
            }
			if (!sDT.matches("^0[1|3|5|7|9][0-9]{8}$")) {
				txtCheckSDT.setText("Gồm 10 ký số bắt đầu là 03, 05, 07, 08, 09!");
			} else {
				txtCheckSDT.setText("");
			}
		}
		if (o.equals(txtEmail)) {
			String email = txtEmail.getText().trim();
			if (email.isEmpty()) {
				txtEmail.setText("Nhập email");
				txtEmail.setForeground(Color.GRAY);
				return;
            }
			if (!email.matches("[a-zA-Z0-9_.]+\\@(gmail.com)")) {
				txtCheckEmail.setText("Là chuỗi kết thúc là @gmail.com!");
			} else {
				txtCheckEmail.setText("");
			}
		}
		if (o.equals(txtCCCD)) {
			String cCCD = txtCCCD.getText().trim();
			if (cCCD.isEmpty()) {
				txtCCCD.setText("Nhập căn cước công dân");
				txtCCCD.setForeground(Color.GRAY);
				return;
            }
			
			if (!cCCD.matches("\\d{12}")) {
				txtCheckCCCD.setText("Là chuỗi gồm 12 ký số!");
			} else {
				txtCheckCCCD.setText("");
			}
		}
		if (o.equals(txtTimKiem)) {
			if (txtTimKiem.getText().isEmpty()) {
				txtTimKiem.setText("Nhập mã nhân viên cần tìm VD: NV0001");
				txtTimKiem.setForeground(Color.GRAY);
            }
		}

	}
}
