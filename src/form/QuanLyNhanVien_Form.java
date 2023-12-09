package form;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import connectDB.ConnectDB;
import entities.ChucVu;
import entities.CongNhan;
import entities.NhanVien;
import entities.PhongBan;
import entities.TaiKhoan;
import entities.TaiKhoanNganHang;

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
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import bus.ChucVu_BUS;
import bus.CongNhan_BUS;
import bus.NhanVien_BUS;
import bus.PhongBan_BUS;
import bus.TaiKhoanNganHang_BUS;
import bus.TaiKhoan_BUS;
import commons.MyButton;
import commons.RoundPanel;
import commons.Table;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

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
	private JTextField txtHienThiID;
	private JTextField txtHienThiHoTen;
	private JTextField txtHienThiPhai;
	private JTextField txtHienThiCCCD;
	private JTextField txtHienThiNgaySinh;
	private JTextField txtHienThiCV;
	private JTextField txtHienThiPB;
	private JTextField txtHienThiSDT;
	private JTextField txtHienThiEmail;
	private int width = 1259;
	private int height = 813;
	private MyButton btnChonAnh;
	private MyButton btnHuy;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JDateChooser dateChooser_NgaySinh;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JDateChooser dateChooser_ngayKTCT;
	private JComboBox<String> cb_PhongBan;
	private MyButton btnThem;
	private MyButton btnCapNhat;
	private MyButton btnTimKiem;
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
	private MyButton btnGoAnh;
	private MyButton btnCapNhatNhanVien;
	private MyButton btnThemNhanVien;
	private MyButton btnLamMoi;

	private JComboBox<String>cbLocPB;
	private JTextField txtSoNH;
	private JTextField txtCheckSoNH;
	private JLabel lblNewLabel_6;

	private TaiKhoan_BUS tk_bus;

	private TaiKhoanNganHang_BUS tknh_bus;

	private CongNhan_BUS cn_bus;

	/**
	 * Create the frame.
	 */
	public QuanLyNhanVien_Form(int width, int height) {

		this.width = width;
		this.height = height;
		giaoDienNV();
//		dialogThemCapNhat();

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
		cn_bus = new CongNhan_BUS();
		nv_bus = new NhanVien_BUS();
		pb_bus = new PhongBan_BUS();
		cv_bus = new ChucVu_BUS();
		tk_bus = new TaiKhoan_BUS();
		tknh_bus = new TaiKhoanNganHang_BUS();
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
		hienThiAvatar.setBounds(26, 24, 150, 200);

		panel_Avt.add(hienThiAvatar);
		
		ImageIcon hienThiImageIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
		// Lấy kích thước mới của JLabel
		int labelWidth = hienThiAvatar.getWidth();
		int labelHeight = hienThiAvatar.getHeight();

		// Chỉnh kích thước ảnh theo JLabeL
		Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		hienThiImageIcon = new ImageIcon(themAnh);
		hienThiAvatar.setIcon(hienThiImageIcon);
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

		txtHienThiHoTen = new JTextField();
		txtHienThiHoTen.setEditable(false);
		txtHienThiHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiHoTen.setBackground(null);
		txtHienThiHoTen.setBorder(null);
		txtHienThiHoTen.setBounds(206, 64, 294, 25);
		txtHienThiHoTen.setColumns(10);

		panel_LyLich.add(txtHienThiHoTen);

		txtHienThiPhai = new JTextField();
		txtHienThiPhai.setEditable(false);
		txtHienThiPhai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiPhai.setBackground(null);
		txtHienThiPhai.setBorder(null);
		txtHienThiPhai.setColumns(10);
		txtHienThiPhai.setBounds(206, 124, 294, 25);

		panel_LyLich.add(txtHienThiPhai);

		txtHienThiCCCD = new JTextField();
		txtHienThiCCCD.setEditable(false);
		txtHienThiCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiCCCD.setBackground(null);
		txtHienThiCCCD.setBorder(null);
		txtHienThiCCCD.setColumns(10);
		txtHienThiCCCD.setBounds(206, 244, 294, 25);

		panel_LyLich.add(txtHienThiCCCD);

		txtHienThiNgaySinh = new JTextField();
		txtHienThiNgaySinh.setEditable(false);
		txtHienThiNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiNgaySinh.setBackground(null);
		txtHienThiNgaySinh.setBorder(null);
		txtHienThiNgaySinh.setColumns(10);
		txtHienThiNgaySinh.setBounds(206, 184, 294, 25);

		panel_LyLich.add(txtHienThiNgaySinh);

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

		txtHienThiCV = new JTextField();
		txtHienThiCV.setEditable(false);
		txtHienThiCV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiCV.setBackground(null);
		txtHienThiCV.setBorder(null);
		txtHienThiCV.setColumns(10);
		txtHienThiCV.setBounds(191, 244, 303, 25);

		panel_TT_Khac.add(txtHienThiCV);

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

		txtHienThiPB = new JTextField();
		txtHienThiPB.setEditable(false);
		txtHienThiPB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiPB.setBackground(null);
		txtHienThiPB.setBorder(null);
		txtHienThiPB.setColumns(10);
		txtHienThiPB.setBounds(191, 184, 303, 25);

		panel_TT_Khac.add(txtHienThiPB);

		txtHienThiSDT = new JTextField();
		txtHienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiSDT.setBackground(null);
		txtHienThiSDT.setBorder(null);
		txtHienThiSDT.setEditable(false);
		txtHienThiSDT.setColumns(10);
		txtHienThiSDT.setBounds(191, 124, 303, 25);

		panel_TT_Khac.add(txtHienThiSDT);

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

		txtHienThiEmail = new JTextField();
		txtHienThiEmail.setEditable(false);
		txtHienThiEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiEmail.setBackground(null);
		txtHienThiEmail.setBorder(null);
		txtHienThiEmail.setColumns(10);
		txtHienThiEmail.setBounds(191, 64, 303, 25);

		panel_TT_Khac.add(txtHienThiEmail);

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

		txtHienThiID = new JTextField();
		txtHienThiID.setEditable(false);
		txtHienThiID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiID.setBorder(null);
		txtHienThiID.setBackground(null);
		txtHienThiID.setBounds(65, 250, 130, 20);
		txtHienThiID.setColumns(10);

		panel_Avt.add(txtHienThiID);
		
		JPanel panelThaoTac = new JPanel();
		panelThaoTac.setBounds(10, 10, 1239, 69);
		panel_NhanVien.add(panelThaoTac);
		panelThaoTac.setLayout(null);
		
		btnThem = new MyButton();
		btnThem.setRadius(20);
		btnThem.setFocusPainted(false);
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setText("Thêm nhân viên");
		btnThem.setBounds(10, 10, 160, 49);
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panelThaoTac.add(btnThem);

		btnCapNhat = new MyButton();
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setRadius(20);
		btnCapNhat.setBackground(new Color(255, 255, 255));
		btnCapNhat.setBorderColor(new Color(255, 255, 255));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setBounds(180, 10, 110, 49);
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		panelThaoTac.add(btnCapNhat);

		txtTimKiem = new JTextField("Nhập mã nhân viên cần tìm VD: NV0001");
		txtTimKiem.setForeground(Color.GRAY);
		txtTimKiem.setBounds(765, 22, 224, 30);
		txtTimKiem.setColumns(10);

		panelThaoTac.add(txtTimKiem);

		btnTimKiem = new MyButton();
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBackground(new Color(255, 255, 255));
		btnTimKiem.setBorderColor(new Color(255, 255, 255));
		btnTimKiem.setRadius(20);
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setBounds(999, 10, 110, 49);
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		btnLamMoi = new MyButton();
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBackground(new Color(255, 255, 255));
		btnLamMoi.setBorderColor(new Color(255, 255, 255));
		btnLamMoi.setRadius(20);
		btnLamMoi.setText("Làm mới");
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLamMoi.setBounds(1119, 10, 110, 49);
		panelThaoTac.add(btnLamMoi);
		
		
		
		panelThaoTac.add(btnTimKiem);

		this.add(panel_NhanVien);
		
		cbLocPB = new JComboBox<String>();
		ArrayList<PhongBan> listPB = pb_bus.getDSPB();

		for (PhongBan phongBan : listPB) {
			cbLocPB.addItem(phongBan.getTenPhongBan());
		}
		cbLocPB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbLocPB.setBounds(607, 20, 148, 30);
		panelThaoTac.add(cbLocPB);
		
		JLabel lblLocPB = new JLabel("Lọc theo phòng ban:");
		lblLocPB.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLocPB.setBounds(449, 20, 148, 30);
		panelThaoTac.add(lblLocPB);
		
		

		docDuLieuTuDataVaoTable();
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnTimKiem.addActionListener(this);
		txtTimKiem.addFocusListener(this);
		cbLocPB.addActionListener(this);
		tableNhanVien.addMouseListener(this);

	}
	private void dialogThemCapNhat() {
		dl_ThemCapNhatNV = new JDialog();
		
		dl_ThemCapNhatNV.setSize(900, 700);
		dl_ThemCapNhatNV.setTitle("Thêm nhân viên");
		dl_ThemCapNhatNV.setLocationRelativeTo(null);
		dl_ThemCapNhatNV.setResizable(false);;
		JPanel panel_Center = new JPanel();
		panel_Center.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
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
		txtID.setBounds(180, 10, 79, 20);
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
		txtHoTen.setBounds(180, 60, 398, 20);
		panel_Center.add(txtHoTen);

		JLabel lbl_Phai = new JLabel("Phái:");
		lbl_Phai.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_Phai.setBounds(20, 160, 110, 20);
		panel_Center.add(lbl_Phai);

		ButtonGroup group = new ButtonGroup();
		rdNam = new JRadioButton("Nam");
		rdNam.setBackground(null);
		rdNam.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdNam.setBounds(180, 160, 79, 20);
		rdNam.setSelected(true);

		rdNu = new JRadioButton("Nữ");
		rdNu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		rdNu.setBounds(322, 160, 79, 20);
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
		dateChooser_NgaySinh.setSize(240, 25);
		dateChooser_NgaySinh.setLocation(180, 110);
		dateChooser_NgaySinh.setDateFormatString("dd/MM/yyyy"); // Đặt định dạng ngày
		dateChooser_NgaySinh.getDateEditor().setEnabled(false);
		panel_Center.add(dateChooser_NgaySinh);

		JLabel lbl_NgayCongTac = new JLabel("Ngày công tác:");
		lbl_NgayCongTac.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_NgayCongTac.setBounds(20, 510, 120, 25);
		panel_Center.add(lbl_NgayCongTac);

		dateChooser_ngayCT = new JDateChooser();
		dateChooser_ngayCT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dateChooser_ngayCT.setDateFormatString("dd/MM/yyyy");
		dateChooser_ngayCT.getDateEditor().setEnabled(false);
		dateChooser_ngayCT.setBounds(180, 510, 240, 25);
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
		txtEmail.setBounds(180, 210, 398, 20);
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
		txtSDT.setBounds(180, 260, 240, 20);
		panel_Center.add(txtSDT);

		JLabel lbl_ChucVu = new JLabel("Chức vụ:");
		lbl_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_ChucVu.setBounds(20, 460, 120, 25);
		panel_Center.add(lbl_ChucVu);

		cb_ChucVu = new JComboBox<String>();
		ArrayList<ChucVu> listCV = cv_bus.getDSCVPhongKeToan();

		for (ChucVu chucVu : listCV) {
			cb_ChucVu.addItem(chucVu.getTenChucVu());
		}
		cb_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		cb_ChucVu.setBounds(180, 460, 240, 25);
		panel_Center.add(cb_ChucVu);

		lbl_NgayKetThucCT = new JLabel("Ngày kết thúc:");
		lbl_NgayKetThucCT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_NgayKetThucCT.setBounds(20, 560, 120, 25);
		panel_Center.add(lbl_NgayKetThucCT);

		dateChooser_ngayKTCT = new JDateChooser();
		dateChooser_ngayKTCT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dateChooser_ngayKTCT.setDateFormatString("dd/MM/yyyy");
		dateChooser_ngayKTCT.setBounds(180, 560, 240, 25);
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
		txtCCCD.setBounds(180, 310, 240, 20);
		panel_Center.add(txtCCCD);

		JLabel lbl_PhongBan = new JLabel("Phòng ban:");
		lbl_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_PhongBan.setBounds(20, 410, 120, 25);
		panel_Center.add(lbl_PhongBan);

		cb_PhongBan = new JComboBox<String>();
		ArrayList<PhongBan> listPB = pb_bus.getDSPB();

		for (PhongBan phongBan : listPB) {
			cb_PhongBan.addItem(phongBan.getTenPhongBan());
		}
		cb_PhongBan.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		cb_PhongBan.setBounds(180, 410, 240, 25);
		panel_Center.add(cb_PhongBan);

		txtCheckHoTen = new JTextField();
		txtCheckHoTen.setEditable(false);
		txtCheckHoTen.setBorder(null);
		txtCheckHoTen.setFocusable(false);
		txtCheckHoTen.setForeground(new Color(255, 0, 0));
		txtCheckHoTen.setBackground(null);
		txtCheckHoTen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckHoTen.setColumns(10);
		txtCheckHoTen.setBounds(180, 80, 461, 20);
		panel_Center.add(txtCheckHoTen);

		txtCheckNS = new JTextField();
		txtCheckNS.setEditable(false);
		txtCheckNS.setFocusable(false);
		txtCheckNS.setBorder(null);
		txtCheckNS.setForeground(new Color(255, 0, 0));
		txtCheckNS.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckNS.setColumns(10);
		txtCheckNS.setBackground(null);
		txtCheckNS.setBounds(180, 135, 460, 20);
		panel_Center.add(txtCheckNS);

		txtCheckEmail = new JTextField();
		txtCheckEmail.setFocusable(false);
		txtCheckEmail.setEditable(false);
		txtCheckEmail.setBorder(null);
		txtCheckEmail.setForeground(new Color(255, 0, 0));
		txtCheckEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckEmail.setColumns(10);
		txtCheckEmail.setBackground(null);
		txtCheckEmail.setBounds(180, 230, 460, 20);
		panel_Center.add(txtCheckEmail);

		txtCheckSDT = new JTextField();
		txtCheckSDT.setEditable(false);
		txtCheckSDT.setBorder(null);
		txtCheckSDT.setFocusable(false);
		txtCheckSDT.setForeground(new Color(255, 0, 0));
		txtCheckSDT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckSDT.setColumns(10);
		txtCheckSDT.setBackground(null);
		txtCheckSDT.setBounds(180, 280, 460, 20);
		panel_Center.add(txtCheckSDT);

		txtCheckCCCD = new JTextField();
		txtCheckCCCD.setEditable(false);
		txtCheckCCCD.setFocusable(false);
		txtCheckCCCD.setBorder(null);
		txtCheckCCCD.setForeground(new Color(255, 0, 0));
		txtCheckCCCD.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckCCCD.setColumns(10);
		txtCheckCCCD.setBackground(null);
		txtCheckCCCD.setBounds(180, 330, 460, 20);
		panel_Center.add(txtCheckCCCD);

		txtCheckNCT = new JTextField();
		txtCheckNCT.setFocusable(false);
		txtCheckNCT.setEditable(false);
		txtCheckNCT.setBorder(null);
		txtCheckNCT.setForeground(new Color(255, 0, 0));
		txtCheckNCT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckNCT.setColumns(10);
		txtCheckNCT.setBackground(null);
		txtCheckNCT.setBounds(180, 535, 492, 20);
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
		lblNewLabel.setBounds(592, 60, 11, 20);
		panel_Center.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(426, 112, 11, 20);
		panel_Center.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(592, 210, 11, 20);
		panel_Center.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(428, 260, 11, 20);
		panel_Center.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(428, 310, 11, 20);
		panel_Center.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(430, 510, 11, 20);
		panel_Center.add(lblNewLabel_5);

		avatarImage = new JLabel();
		avatarImage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		avatarImage.setBounds(650, 30, 200, 300);
		int labelWidth = avatarImage.getWidth();
		int labelHeight = avatarImage.getHeight();
		ImageIcon avatarIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
		// Chỉnh kích thước ảnh theo JLabel
		Image avatar = avatarIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		avatarIcon = new ImageIcon(avatar);

		avatarImage.setIcon(avatarIcon);
		panel_Center.add(avatarImage);

		btnChonAnh = new MyButton();
		btnChonAnh.setFocusPainted(false);
		btnChonAnh.setBackground(new Color(255, 255, 255));
		btnChonAnh.setBorderColor(new Color(255, 255, 255));
		btnChonAnh.setRadius(10);
		btnChonAnh.setText("Chọn ảnh");
		btnChonAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnChonAnh.setBounds(683, 340, 130, 30);
		panel_Center.add(btnChonAnh);

		dl_ThemCapNhatNV.getContentPane().add(panel_Center, BorderLayout.CENTER);

		btnGoAnh = new MyButton();
		btnGoAnh.setFocusPainted(false);
		btnGoAnh.setBackground(new Color(255, 255, 255));
		btnGoAnh.setBorderColor(new Color(255, 255, 255));
		btnGoAnh.setRadius(10);
		btnGoAnh.setText("Gỡ ảnh");
		btnGoAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnGoAnh.setBounds(683, 380, 130, 30);
		panel_Center.add(btnGoAnh);
		
		txtSoNH = new JTextField("Nhập số tài khoản ngân hàng");
		txtSoNH.setForeground(Color.GRAY);
		txtSoNH.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtSoNH.setColumns(10);
		txtSoNH.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtSoNH.setBackground((Color) null);
		txtSoNH.setBounds(180, 360, 398, 20);
		panel_Center.add(txtSoNH);
		
		txtCheckSoNH = new JTextField();
		txtCheckSoNH.setForeground(Color.RED);
		txtCheckSoNH.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckSoNH.setFocusable(false);
		txtCheckSoNH.setEditable(false);
		txtCheckSoNH.setColumns(10);
		txtCheckSoNH.setBorder(null);
		txtCheckSoNH.setBackground((Color) null);
		txtCheckSoNH.setBounds(180, 380, 460, 20);
		panel_Center.add(txtCheckSoNH);
		
		JLabel lbl_soNH = new JLabel("Tài khoản ngân hàng:");
		lbl_soNH.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_soNH.setBounds(20, 360, 150, 20);
		panel_Center.add(lbl_soNH);
		
		lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(585, 360, 11, 20);
		panel_Center.add(lblNewLabel_6);

		JPanel panel_ChucNang = new JPanel();
		btnThemNhanVien = new MyButton();
		btnThemNhanVien.setFocusPainted(false);
		btnThemNhanVien.setRadius(10);
		btnThemNhanVien.setText("Thêm");
		btnThemNhanVien.setBackground(new Color(0, 255, 0));
		btnThemNhanVien.setPreferredSize(new Dimension(100, 30));
		btnThemNhanVien.setForeground(new Color(0, 0, 0));
		btnThemNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		panel_ChucNang.add(btnThemNhanVien);

		btnCapNhatNhanVien = new MyButton();
		btnCapNhatNhanVien.setFocusPainted(false);
		btnCapNhatNhanVien.setPreferredSize(new Dimension(100, 30));
		btnCapNhatNhanVien.setRadius(10);
		btnCapNhatNhanVien.setText("Cập nhật");
		btnCapNhatNhanVien.setForeground(Color.BLACK);
		btnCapNhatNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCapNhatNhanVien.setBackground(Color.GREEN);
		
		panel_ChucNang.add(btnCapNhatNhanVien);
		Box b;
		b = Box.createVerticalBox();
		b.add(Box.createRigidArea(new Dimension(150, 30)));

		panel_ChucNang.add(b);
		btnHuy = new MyButton();
		btnHuy.setFocusPainted(false);
		btnHuy.setRadius(10);
		btnHuy.setPreferredSize(new Dimension(100, 30));
		btnHuy.setText("Hủy");
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuy.setBackground(new Color(255, 0, 0));
		
		panel_ChucNang.add(btnHuy);
		dl_ThemCapNhatNV.getContentPane().add(panel_ChucNang, BorderLayout.SOUTH);
			
		
		btnHuy.addActionListener(this);
		btnThemNhanVien.addActionListener(this);
		btnChonAnh.addActionListener(this);
		btnGoAnh.addActionListener(this);
		cb_PhongBan.addActionListener(this);
		btnCapNhatNhanVien.addActionListener(this);
		txtHoTen.addFocusListener(this);
		txtSoNH.addFocusListener(this);
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
						txtCheckNS.setText("Ngày sinh trước năm hiện tại 18 năm!");
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
						txtCheckNCT.setText("Ngày công tác bằng hoặc trước ngày hiện tại!");
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
						txtCheckNKTCT.setText("Ngày kết thúc bằng hoặc trước ngày hiện tại , sau ngày công tác!");
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
	private void hienThiDialogThem() {
		dialogThemCapNhat();
		txtID.setText(sinhMaNV());
		lbl_NgayKetThucCT.setVisible(false);
		txtCheckNKTCT.setVisible(false);
		dateChooser_ngayKTCT.setVisible(false);
		btnThemNhanVien.setVisible(true);
		btnCapNhatNhanVien.setVisible(false);
		dl_ThemCapNhatNV.setModal(true);
		dl_ThemCapNhatNV.setVisible(true);
		
		
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
		txtSoNH.setText(nv.getTaiKhoan().getTaiKhoanNganHang().getSoTaiKhoan());
		txtSoNH.setForeground(Color.BLACK);
		cb_PhongBan.setSelectedItem(nv.getPhongBan().getTenPhongBan());
		cb_ChucVu.setSelectedItem(nv.getChucVu().getTenChucVu());
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
		dl_ThemCapNhatNV.setModal(true);
		dl_ThemCapNhatNV.setVisible(true);
	}

	private void hienThiThongTinNV(NhanVien nv) {
		txtHienThiID.setText(nv.getIdNhanVien());
		txtHienThiHoTen.setText(nv.getHoTen());
		txtHienThiNgaySinh.setText(nv.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		txtHienThiPhai.setText((nv.isPhai() == true) ? "Nam" : "Nữ");
		txtHienThiCCCD.setText(nv.getcCCD());
		txtHienThiSDT.setText(nv.getSoDienThoai());
		txtHienThiEmail.setText(nv.getEmail());
		txtHienThiCV.setText(cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu());
		txtHienThiPB.setText(pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan());
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
		String avatar = "Unknown_person.jpg";
		if (url != null) {
			File absoluteFile = new File(url);
			avatar = absoluteFile.getName();

		}
		NhanVien nv = new NhanVien(maNV, tenNV, phai, ns, ct, ktct, email, sdt, cv, null, pb, avatar,
				cccd);
		return nv;
	}
	private boolean kiemTraSDT() {
		int dem = 0;
		NhanVien nhanVien = nv_bus.getNhanVienDangLamTheoID(txtID.getText());
		ArrayList<CongNhan> listCN = cn_bus.getDanhSachCongNhan();
		ArrayList<String> listSDT = new ArrayList<String>();
		String sdt =txtSDT.getText();
		for (CongNhan cn : listCN) {
			listSDT.add(cn.getSoDienThoai());
		}
		ArrayList<NhanVien> listNV =nv_bus.getdsNV();
		for (NhanVien nv : listNV) {
			listSDT.add(nv.getSoDienThoai());
		}
		for(String soDT : listSDT) {
			if(soDT.equals(sdt)) {
				dem++;
			}
		}
		if(nhanVien==null) {
			return dem < 1;
		}
		else {
			return dem < 2;
		}
	}
	private boolean kiemTraTKNH() {
		int dem = 0;
		NhanVien nhanVien = nv_bus.getNhanVienDangLamTheoID(txtID.getText());
		ArrayList<CongNhan> listCN = cn_bus.getDanhSachCongNhan();
		ArrayList<String> listTKNH = new ArrayList<String>();
		String tkNH =txtSoNH.getText();
		for (CongNhan cn : listCN) {
			listTKNH.add(cn.getTaiKhoan().getTaiKhoanNganHang().getSoTaiKhoan());
		}
		ArrayList<NhanVien> listNV =nv_bus.getdsNV();
		for (NhanVien nv : listNV) {
			listTKNH.add(nv.getTaiKhoan().getTaiKhoanNganHang().getSoTaiKhoan());
		}
		for(String soTK : listTKNH) {
			if(soTK.equals(tkNH)) {
				dem++;
			}
		}
		if(nhanVien==null) {
			return dem < 1;
		}
		else {
			return dem < 2;
		}
	}
	private boolean kiemTraEmail() {
		int dem = 0;
		NhanVien nhanVien = nv_bus.getNhanVienDangLamTheoID(txtID.getText());
		ArrayList<CongNhan> listCN = cn_bus.getDanhSachCongNhan();
		ArrayList<String> listEmail = new ArrayList<String>();
		String email =txtEmail.getText();
		for (CongNhan cn : listCN) {
			listEmail.add(cn.getEmail());
		}
		ArrayList<NhanVien> listNV =nv_bus.getdsNV();
		for (NhanVien nv : listNV) {
			listEmail.add(nv.getEmail());
		}
		for(String mail : listEmail) {
			if(mail.equals(email)) {
				dem++;
			}
		}
		if(nhanVien==null) {
			return dem < 1;
		}
		else {
			return dem < 2;
		}
	}
	private boolean kiemTraCCCD() {
		int dem = 0;
		
		NhanVien nv = nv_bus.getNhanVienDangLamTheoID(txtID.getText());
		ArrayList<CongNhan> listCN = cn_bus.getDanhSachCongNhan();
		ArrayList<String> listCCCD = new ArrayList<String>();
		String cCCD =txtCCCD.getText();
		for (CongNhan congNhan : listCN) {
				listCCCD.add(congNhan.getcCCD());
		}
		ArrayList<NhanVien> listNV =nv_bus.getdsNV();
		for (NhanVien nhanVien : listNV) {
			listCCCD.add(nhanVien.getcCCD());
		}
		for(String canCuocCongDan : listCCCD) {
			if(canCuocCongDan.equals(cCCD)) {
				dem++;
			}
		}
		if(nv==null) {
			return dem < 1;
		}
		else {
			return dem < 2;
		}
	}
	private boolean validData() {

		String hoTen = txtHoTen.getText().trim();
		if (!hoTen.matches("[\\p{Lu}][\\p{Ll}]*([\\s]+[\\p{Lu}][\\p{Ll}]*)+")) {
			txtCheckHoTen.setText("Họ tên ít nhất 2 âm, mỗi âm có chữ cái đầu viết hoa!");
			return false;
		}
		
		
		Date nsDate = dateChooser_NgaySinh.getDate();
		if(nsDate == null) {
			txtCheckNS.setText("Ngày sinh trước năm hiện tại 18 năm!");
			return false;
		}
		int yearNS = nsDate.getYear() + 1900;

		// Lấy ngày hiện tại
		Calendar calendar = Calendar.getInstance();
		Date ngayHT = calendar.getTime();
		int yearHT = ngayHT.getYear() + 1900;
		if (!(yearHT - yearNS >= 18)) {
			txtCheckNS.setText("Ngày sinh trước năm hiện tại 18 năm!");
			return false;
		}

		
		String soNH = txtSoNH.getText();
		
		
		if(!kiemTraEmail())
		{
			txtCheckEmail.setText("Email này đã được sử dụng!");
			return false;
		}
		String email = txtEmail.getText().trim();
		if (!email.matches("[a-zA-Z0-9_.]+\\@(gmail.com)")) {
			txtCheckEmail.setText("Email có dạng kết thúc là @gmail.com!");
			return false;
		}
		String sDT = txtSDT.getText().trim();
		if (!sDT.matches("^0[3|5|7|9][0-9]{8}$")) {
			txtCheckSDT.setText("SĐT có dạng 10 ký số bắt đầu là 03, 05, 07, 08, 09!");
			return false;
		}
		if (!kiemTraSDT()) {
			txtCheckSDT.setText("SĐT này đã được sử dụng!");
			return false;
		}
		

		String cCCD = txtCCCD.getText().trim();
		if (!cCCD.matches("\\d{12}")) {
			txtCheckCCCD.setText("CCCD có dạng 12 ký số!");
			return false;
		}
		if(!kiemTraCCCD()) {
			txtCheckCCCD.setText("CCCD này đã được sử dụng!");
			return false;
		}
		if (!soNH.matches("^[0-9]{12}$")) {
			txtCheckSoNH.setText("Số tài khoản ngân hàng gồm 12 ký số!");
			return false;
		}
		if (!kiemTraTKNH()) {
			txtCheckSoNH.setText("Số tài khoản ngân hàng này đã được sử dụng!");
			return false;
		}
		Date ctDate = dateChooser_ngayCT.getDate();
		if(ctDate == null) {
			txtCheckNCT.setText("Ngày công tác bằng hoặc trước ngày hiện tại!");
			return false;
		}
		int result = ctDate.compareTo(ngayHT);
		if (!(result <= 0)) {
			txtCheckNCT.setText("Ngày công tác bằng hoặc trước ngày hiện tại!");
			return false;
		}
		
		Date ktctDate = dateChooser_ngayKTCT.getDate();
		if(ktctDate!=null) {
			int result2 = ktctDate.compareTo(ctDate);
			if (!(result <= 0 && result2 > 0)) {
				txtCheckNKTCT.setText("Ngày kết thúc bằng hoặc trước ngày hiện tại , sau ngày công tác!");
				return false;
			}
		}
		

		return true;
	}
	private String loaiTaiKhoan() {
		String loaiTK = "";
		if(cb_ChucVu.getSelectedItem().toString().equals("Nhân viên hành chánh")) {
			loaiTK = "NV";
		}
		else if(cb_ChucVu.getSelectedItem().toString().equals("Kế toán")) {
			loaiTK = "KT";
		}
		else if(cb_ChucVu.getSelectedItem().toString().equals("Trưởng phòng sản xuất")) {
			loaiTK = "TPSX";
		}
		else if(cb_ChucVu.getSelectedItem().toString().equals("Trưởng phòng nhân sự")) {
			loaiTK = "TPNS";
		}
		else {
			loaiTK = "TPKT";
		}
		return loaiTK;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub'
		Object o = e.getSource();
		if (o.equals(btnThemNhanVien)) {
			if (validData()) {
				NhanVien nv = layTTNVTuTextField();
				String soNH = txtSoNH.getText();
				TaiKhoanNganHang tknh = new TaiKhoanNganHang(soNH, "Sacombank", nv.getHoTen() ,"Chi nhánh Gò Vấp, HCM");
				TaiKhoan tk = new TaiKhoan(nv.getIdNhanVien(),"1111",loaiTaiKhoan(),tknh);
				
				tknh_bus.create(tknh);
				tk_bus.create(tk);
				nv.setTaiKhoan(tk);
				nv_bus.create(nv);
				JOptionPane.showMessageDialog(null, "Thêm thành công!");
				dl_ThemCapNhatNV.dispose();
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
		if (o.equals(btnThem)) {
			hienThiDialogThem();		}

		if (o.equals(btnHuy)) {
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn hủy không?", "Cảnh báo!", JOptionPane.YES_NO_OPTION);


	        if (choice == JOptionPane.YES_OPTION) {
	        	dl_ThemCapNhatNV.dispose();
	        } else {
	            return;
	        }
		}
		if (o.equals(btnTimKiem)) {
			String ma = txtTimKiem.getText();
			if (ma.equals("Nhập mã nhân viên cần tìm VD: NV0001")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên!");
			} else {

				NhanVien nv = nv_bus.getNhanVienDangLamTheoID(ma);
				if (nv != null) {
					model.setRowCount(0);
					model.addRow(new Object[] { nv.getIdNhanVien(), nv.getHoTen(), nv.isPhai() ? "Nam" : "Nữ",
							nv.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							nv.getNgayBatDauCongTac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan(),
							cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu(), nv.getEmail(), nv.getSoDienThoai(),
							nv.getcCCD()

					});
					tableNhanVien.setRowSelectionInterval(0, 0);
					hienThiThongTinNV(nv);
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên có mã " + ma + "!");
					txtTimKiem.setText("Nhập mã nhân viên cần tìm VD: NV0001");
					txtTimKiem.setForeground(Color.GRAY);
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
				NhanVien nv_old = nv_bus.getNhanVienDangLamTheoID(txtID.getText());
				
				NhanVien nv_new = layTTNVTuTextField();
				
				String soTKNH = txtSoNH.getText();
				tk_bus.updateTaiKhoan(nv_new.getIdNhanVien(), loaiTaiKhoan(),null);
				TaiKhoanNganHang tknh_old = nv_old.getTaiKhoan().getTaiKhoanNganHang();
				tknh_bus.update(tknh_old, soTKNH);
				tk_bus.updateTaiKhoan(nv_new.getIdNhanVien(), loaiTaiKhoan(),soTKNH);
				
				
				
				TaiKhoan tk = tk_bus.getTaiKhoan(nv_new.getIdNhanVien());
				nv_new.setTaiKhoan(tk);
				nv_bus.update(nv_new);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				dl_ThemCapNhatNV.dispose();
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
		if(o.equals(cbLocPB)) {
			String tenPB = cbLocPB.getSelectedItem().toString();
			PhongBan pb = pb_bus.getPBTheoTen(tenPB);
			ArrayList<NhanVien> listNVPB =  nv_bus.getdsNVDangLamThePB(pb.getIdPhongBan());
			if(listNVPB.size()==0) {
				JOptionPane.showMessageDialog(this, "Không có nhân viên nào trong phòng ban " + tenPB);
				return;
			}
			else {
				model.setRowCount(0);
				for (NhanVien nv : listNVPB) {
					model.addRow(new Object[] { nv.getIdNhanVien(), nv.getHoTen(), nv.isPhai() ? "Nam" : "Nữ",
							nv.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							nv.getNgayBatDauCongTac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							pb_bus.getPB(nv.getPhongBan().getIdPhongBan()).getTenPhongBan(),
							cv_bus.getCV(nv.getChucVu().getIdChucVu()).getTenChucVu(), nv.getEmail(), nv.getSoDienThoai(),
							nv.getcCCD()

					});
				}
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
			txtHienThiID.setText("");
			txtHienThiHoTen.setText("");
			txtHienThiEmail.setText("");
			txtHienThiCCCD.setText("");
			txtHienThiNgaySinh.setText("");
			txtHienThiPhai.setText("");
			txtHienThiPB.setText("");
			txtHienThiSDT.setText("");
			txtHienThiCV.setText("");
			
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
		if (o.equals(cb_PhongBan)) {
			if(cb_PhongBan.getSelectedItem().toString().equals("Phòng Kế Toán")) {
				ArrayList<ChucVu> listCV = cv_bus.getDSCVPhongKeToan();
				cb_ChucVu.removeAllItems();
				for (ChucVu chucVu : listCV) {
					cb_ChucVu.addItem(chucVu.getTenChucVu());
				}
			}
			else if(cb_PhongBan.getSelectedItem().toString().equals("Phòng Nhân Sự")) {
				ArrayList<ChucVu> listCV = cv_bus.getDSCVPhongNhanSu();
				cb_ChucVu.removeAllItems();
				for (ChucVu chucVu : listCV) {
					cb_ChucVu.addItem(chucVu.getTenChucVu());
				}
			}
			else {
				ArrayList<ChucVu> listCV = cv_bus.getDSCVPhongSanXuat();
				cb_ChucVu.removeAllItems();
				for (ChucVu chucVu : listCV) {
					cb_ChucVu.addItem(chucVu.getTenChucVu());
				}
			}

		}


	}

	@Override
	public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(tableNhanVien)) {
			int n = tableNhanVien.getSelectedRow();
			String maNV = tableNhanVien.getValueAt(n, 0).toString();
			NhanVien nv = nv_bus.getNV(maNV);
			hienThiThongTinNV(nv);
		}
		

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
		if (o.equals(txtSoNH)) {
			txtCheckSoNH.setText("");
			 if (txtSoNH.getText().equals("Nhập số tài khoản ngân hàng")) {
				 txtSoNH.setText("");
				 txtSoNH.setForeground(Color.BLACK);
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
		
			if (!hoTen.matches("[\\p{Lu}][\\p{Ll}]*([\\s]+[\\p{Lu}][\\p{Ll}]*)+")) {
				txtCheckHoTen.setText("Họ tên ít nhất 2 âm, mỗi âm có chữ cái đầu viết hoa!");
			} else {
				txtCheckHoTen.setText("");
			}
		}
		if (o.equals(txtSoNH)) {
			String soNH = txtSoNH.getText().trim();
			if (soNH.isEmpty()) {
				txtSoNH.setText("Nhập số tài khoản ngân hàng");
				txtSoNH.setForeground(Color.GRAY);
				return;
            }
			if (!soNH.matches("^[0-9]{12}$")) {
				txtCheckSoNH.setText("Số tài khoản ngân hàng gồm 12 ký số!");
			} 
			else if (!kiemTraTKNH()) {
				txtCheckSoNH.setText("Số tài khoản ngân hàng này đã được sử dụng!");
			} else {
				txtCheckSoNH.setText("");
			}
		}
		if (o.equals(txtSDT)) {
			String sDT = txtSDT.getText().trim();
			if (sDT.isEmpty()) {
				txtSDT.setText("Nhập số điện thoại");
				txtSDT.setForeground(Color.GRAY);
				return;
            }
			if (!sDT.matches("^0[3|5|7|9][0-9]{8}$")) {
				txtCheckSDT.setText("SĐT có dạng 10 ký số bắt đầu là 03, 05, 07, 08, 09!");
			} 
			else if (!kiemTraSDT()) {
				txtCheckSDT.setText("SĐT này đã được sử dụng!");
			}
			else {
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
				txtCheckEmail.setText("Email có dạng kết thúc là @gmail.com!");
			}
			else if (!kiemTraEmail()) {
				txtCheckEmail.setText("Email này đã được sử dụng!");
			}else {
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
				txtCheckCCCD.setText("CCCD có dạng 12 ký số!");
			} 
			else if (!kiemTraCCCD()) {
				txtCheckCCCD.setText("CCCD này đã được sử dụng!");
			}else {
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
