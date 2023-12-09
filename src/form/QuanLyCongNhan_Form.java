package form;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import connectDB.ConnectDB;
import entities.CongNhan;
import entities.NhanVien;
import entities.PhanXuong;
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
import com.toedter.calendar.JDateChooser;
import bus.CongNhan_BUS;
import bus.NhanVien_BUS;
import bus.PhanXuong_BUS;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;

/**
 * 
 * @author Nguyễn Gia Bảo, Ngô Quốc Đạt, Nguyễn Nhất Dương, Võ Văn Nghĩa Hiệp
 * @version 1.0s
 *
 */

public class QuanLyCongNhan_Form extends JPanel implements ActionListener, MouseListener, FocusListener {

	private DefaultTableModel model;

	private JTextField txtTimKiem;
	private JTextField txtHienThiID;
	private JTextField txtHienThiHoTen;
	private JTextField txtHienThiPhai;
	private JTextField txtHienThiCCCD;
	private JTextField txtHienThiNgaySinh;
	private JTextField txtHienThiTayNghe;
	private JTextField txtHienThiPX;
	private JTextField txtHienThiSDT;
	private JTextField txtHienThiEmail;
	private int width = 1259;
	private int height = 813;
	private MyButton btnChonAnh;
	private MyButton btnThemCongNhan;
	private MyButton btnHuyThem;
	private MyButton btnCapNhatCongNhan;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JDateChooser dateChooser_NgaySinh;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JDateChooser dateChooser_ngayKTCT;
	private JComboBox<String> cb_PhanXuong;
	private MyButton btnThem;
	private MyButton btnCapNhat;
	private MyButton btnTimKiem;
	private JPanel panel_CongNhan;
	private JLabel lbl_CCCD;
	private JTextField txtCCCD;
	private CongNhan_BUS cn_bus;
	private JTextField txtID;
	private JComboBox<String> cb_TayNghe;
	private RoundPanel panel_bangTTCN;
	private JScrollPane scrollPane;
	private JDateChooser dateChooser_ngayCT;
	private Table tableCongNhan;
	private JLabel avatarImage;
	private JLabel hienThiAvatar;
	private PhanXuong_BUS px_bus;
	private JLabel lbl_NgayKetThucCT;
	private String url;
	private JTextField txtCheckHoTen;
	private JDialog dl_ThemCapNhatCN;
	private JTextField txtCheckNS;
	private JTextField txtCheckEmail;
	private JTextField txtCheckSDT;
	private JTextField txtCheckCCCD;
	private JTextField txtCheckNCT;
	private JTextField txtCheckNKTCT;
	private MyButton btnLamMoi;
	private MyButton btnGoAnh;

	private JComboBox<String> cbLocPX;
	private JTextField txtSoNH;
	private JLabel lblNewLabel_3_2;
	private JTextField txtCheckSoNH;

	private TaiKhoan_BUS tk_bus;

	private TaiKhoanNganHang_BUS tknh_bus;

	private NhanVien_BUS nv_bus;

	/**
	 * Create the frame.x
	 */
	public QuanLyCongNhan_Form(int width, int height) {
		this.width = width;
		this.height = height;
		giaoDienCN();
//		dialogThemCapNhat();

	}

	private void giaoDienCN() {

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
		px_bus = new PhanXuong_BUS();
		tk_bus = new TaiKhoan_BUS();
		tknh_bus = new TaiKhoanNganHang_BUS();
		// Panel danh sách cong nhan

		panel_CongNhan = new JPanel();
		panel_CongNhan.setBounds(0, 0, 1259, 813);
		panel_CongNhan.setLayout(null);

		panel_bangTTCN = new RoundPanel();
		panel_bangTTCN.setRound(20);
		panel_bangTTCN.setBackground(new Color(255, 255, 255));
		panel_bangTTCN.setBounds(10, 89, 1239, 381);
		panel_CongNhan.add(panel_bangTTCN);
		panel_bangTTCN.setLayout(null);

		RoundPanel panelTieuDe = new RoundPanel();
		panelTieuDe.setRound(20);
		panelTieuDe.setLayout(new BorderLayout(0, 0));
		JLabel tieuDe = new JLabel("Bảng thông tin công nhân");
		panelTieuDe.add(tieuDe);
		panelTieuDe.setBounds(10, 10, 1210, 30);
		panelTieuDe.setBackground(new Color(113, 184, 255));
		tieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		tieuDe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_bangTTCN.add(panelTieuDe);
		String[] headers = { "ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00E1i", "Ng\u00E0y sinh", "Ngày công tác",
				"Phân xưởng", "Tay nghề", "Email", "S\u0110T", "CCCD" };
		model = new DefaultTableModel(headers, 0);

		tableCongNhan = new Table();
		tableCongNhan.setOpaque(false);
		// Cài đặt header cho table Chấm công
		tableCongNhan.setModel(model);
		tableCongNhan.getColumnModel().getColumn(8).setPreferredWidth(72);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setOpaque(false);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(tableCongNhan);
		scrollPane.setBounds(10, 40, 1210, 331);
		tableCongNhan.fixTable(scrollPane);
		panel_bangTTCN.add(scrollPane);

		// Panel chi tiet thong tin 1 cong nhan
		RoundPanel panel_ChiTietCN = new RoundPanel();
		panel_ChiTietCN.setRound(20);
		panel_ChiTietCN.setBackground(new Color(240, 240, 240));
		panel_ChiTietCN.setBounds(10, 480, 1239, 289);
		panel_CongNhan.add(panel_ChiTietCN);
		panel_ChiTietCN.setLayout(null);

		RoundPanel panel_Avt = new RoundPanel();
		panel_Avt.setBorder(new LineBorder(new Color(113, 184, 255), 3, true));
		panel_Avt.setRound(20);
		panel_Avt.setBackground(new Color(255, 255, 255));
		panel_Avt.setBounds(4, 10, 205, 280);
		panel_ChiTietCN.add(panel_Avt);

		panel_Avt.setLayout(null);

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
		panel_ChiTietCN.add(panel_LyLich);
		panel_LyLich.setLayout(null);

		RoundPanel panelLblLyLich = new RoundPanel();
		panelLblLyLich.setRound(20);
		panelLblLyLich.setLayout(new BorderLayout(0, 0));
		JLabel lb_LyLich = new JLabel("Lý lịch công nhân");
		lb_LyLich.setHorizontalAlignment(SwingConstants.CENTER);
		lb_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panelLblLyLich.add(lb_LyLich);
		panelLblLyLich.setBounds(10, 10, 490, 24);
		panelLblLyLich.setBackground(new Color(113, 184, 255));

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
		panel_LyLich.add(txtHienThiHoTen);
		txtHienThiHoTen.setColumns(10);

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
		JLabel lbl_LyLich = new JLabel("Lý lịch công nhân");
		lbl_LyLich.setBounds(49, 10, 430, 24);
		panel_LyLich.add(lbl_LyLich);
		lbl_LyLich.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));

		RoundPanel panel_TT_Khac = new RoundPanel();
		panel_TT_Khac.setBackground(new Color(255, 255, 255));
		panel_TT_Khac.setRound(20);
		panel_TT_Khac.setBounds(739, 10, 500, 280);
		panel_ChiTietCN.add(panel_TT_Khac);
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

		txtHienThiTayNghe = new JTextField();
		txtHienThiTayNghe.setEditable(false);
		txtHienThiTayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiTayNghe.setBackground(null);
		txtHienThiTayNghe.setBorder(null);
		txtHienThiTayNghe.setColumns(10);
		txtHienThiTayNghe.setBounds(191, 244, 294, 25);
		panel_TT_Khac.add(txtHienThiTayNghe);

		JLabel lbl_HienThiTayNghe = new JLabel("Tay nghề:");
		lbl_HienThiTayNghe.setForeground(new Color(0, 0, 128));
		lbl_HienThiTayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_HienThiTayNghe.setBounds(10, 244, 130, 25);
		panel_TT_Khac.add(lbl_HienThiTayNghe);

		JLabel lbl_HienThiPhanXuong = new JLabel("Phân xưởng:");
		lbl_HienThiPhanXuong.setForeground(new Color(0, 0, 128));
		lbl_HienThiPhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_HienThiPhanXuong.setBounds(10, 184, 130, 25);
		panel_TT_Khac.add(lbl_HienThiPhanXuong);

		txtHienThiPX = new JTextField();
		txtHienThiPX.setEditable(false);
		txtHienThiPX.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiPX.setBackground(null);
		txtHienThiPX.setBorder(null);
		txtHienThiPX.setColumns(10);
		txtHienThiPX.setBounds(191, 184, 294, 25);
		panel_TT_Khac.add(txtHienThiPX);

		txtHienThiSDT = new JTextField();
		txtHienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiSDT.setBackground(null);
		txtHienThiSDT.setBorder(null);
		txtHienThiSDT.setEditable(false);
		txtHienThiSDT.setColumns(10);
		txtHienThiSDT.setBounds(191, 124, 294, 25);
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
		txtHienThiEmail.setBounds(191, 64, 294, 25);
		panel_TT_Khac.add(txtHienThiEmail);

		JLabel lb_ID = new JLabel("ID:");
		lb_ID.setForeground(new Color(0, 0, 128));
		lb_ID.setBounds(10, 250, 40, 20);
		lb_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_Avt.add(lb_ID);

		txtHienThiID = new JTextField();
		txtHienThiID.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHienThiID.setEditable(false);
		txtHienThiID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiID.setBorder(null);
		txtHienThiID.setBackground(null);
		txtHienThiID.setBounds(63, 250, 132, 20);
		panel_Avt.add(txtHienThiID);
		txtHienThiID.setColumns(10);

		JPanel panelThaoTac = new JPanel();
		panelThaoTac.setBounds(10, 10, 1239, 69);
		panel_CongNhan.add(panelThaoTac);
		panelThaoTac.setLayout(null);
		
		btnThem = new MyButton();
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setBorderColor(new Color(255, 255, 255));
		btnThem.setRadius(20);
		btnThem.setBounds(10, 10, 160, 49);
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnThem.setText("Thêm công nhân");
		panelThaoTac.add(btnThem);

		btnCapNhat = new MyButton();
		btnCapNhat.setBackground(new Color(255, 255, 255));
		btnCapNhat.setBorderColor(new Color(255, 255, 255));
		btnCapNhat.setRadius(20);
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setBounds(180, 10, 110, 49);
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		setLayout(new BorderLayout(0, 0));
		panelThaoTac.add(btnCapNhat);

		txtTimKiem = new JTextField("Nhập mã công nhân cần tìm VD: CN0001");
		txtTimKiem.setForeground(Color.GRAY);
		txtTimKiem.setBounds(765, 22, 224, 30);


		panelThaoTac.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btnTimKiem = new MyButton();
		btnTimKiem.setBackground(new Color(255, 255, 255));
		btnTimKiem.setBorderColor(new Color(255, 255, 255));
		btnTimKiem.setRadius(20);
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setBounds(999, 10, 110, 49);
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panelThaoTac.add(btnTimKiem);
		
		
		btnLamMoi = new MyButton();
		btnLamMoi.setBackground(new Color(255, 255, 255));
		btnLamMoi.setBorderColor(new Color(255, 255, 255));
		btnLamMoi.setRadius(20);
		btnLamMoi.setText("Làm mới");
		btnLamMoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLamMoi.setBounds(1119, 10, 110, 49);
		panelThaoTac.add(btnLamMoi);
		
		cbLocPX = new JComboBox<String>();
		ArrayList<PhanXuong> listPX = px_bus.getDanhSachPhanXuong();

		for (PhanXuong phanXuong : listPX) {
			cbLocPX.addItem(phanXuong.getTenPhanXuong());
		}
		cbLocPX.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbLocPX.setBounds(607, 20, 148, 30);
		panelThaoTac.add(cbLocPX);
		
		JLabel lblLocPB = new JLabel("Lọc theo phân xưởng:");
		lblLocPB.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLocPB.setBounds(449, 20, 148, 30);
		panelThaoTac.add(lblLocPB);
		
		this.add(panel_CongNhan);
		cbLocPX.addActionListener(this);
		btnThem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnTimKiem.addActionListener(this);
		tableCongNhan.addMouseListener(this);
		txtTimKiem.addFocusListener(this);
		btnLamMoi.addActionListener(this);
		docDuLieuTuDataVaoTable();

	}

	private void dialogThemCapNhat() {
		dl_ThemCapNhatCN = new JDialog();

		dl_ThemCapNhatCN.setSize(900, 700);
		dl_ThemCapNhatCN.setTitle("Thêm công nhân");
		dl_ThemCapNhatCN.setLocationRelativeTo(null);
		dl_ThemCapNhatCN.setResizable(false);;
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
		txtID.setBounds(180, 11, 79, 20);
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
		txtHoTen.setBounds(180, 60, 402, 20);
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
		txtEmail.setBounds(180, 210, 402, 20);
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

		JLabel lbl_PhanXuong = new JLabel("Phân xưởng:");
		lbl_PhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_PhanXuong.setBounds(20, 410, 120, 25);
		panel_Center.add(lbl_PhanXuong);

		cb_PhanXuong = new JComboBox<String>();
		cb_PhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		cb_PhanXuong.setBounds(180, 410, 240, 25);
		panel_Center.add(cb_PhanXuong);

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

		JLabel lbl_tayNghe = new JLabel("Tay nghề:");
		lbl_tayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_tayNghe.setBounds(20, 460, 120, 25);
		panel_Center.add(lbl_tayNghe);

		cb_TayNghe = new JComboBox<String>();
		cb_TayNghe.addItem("Giỏi");
		cb_TayNghe.addItem("Khá");
		cb_TayNghe.addItem("Trung bình");
		cb_TayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		cb_TayNghe.setBounds(180, 460, 240, 25);
		panel_Center.add(cb_TayNghe);

		
	

		txtCheckHoTen = new JTextField();
		txtCheckHoTen.setEditable(false);
		txtCheckHoTen.setBorder(null);
		txtCheckHoTen.setFocusable(false);
		txtCheckHoTen.setForeground(new Color(255, 0, 0));
		txtCheckHoTen.setBackground(null);
		txtCheckHoTen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckHoTen.setColumns(10);
		txtCheckHoTen.setBounds(180, 80, 460, 20);
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
		txtCheckNCT.setBounds(180, 535, 467, 20);
		panel_Center.add(txtCheckNCT);

		txtCheckNKTCT = new JTextField();
		txtCheckNKTCT.setEditable(false);
		txtCheckNKTCT.setFocusable(false);
		txtCheckNKTCT.setBorder(null);
		txtCheckNKTCT.setForeground(new Color(255, 0, 0));
		txtCheckNKTCT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtCheckNKTCT.setColumns(10);
		txtCheckNKTCT.setBackground(null);
		txtCheckNKTCT.setBounds(148, 537, 492, 20);
		panel_Center.add(txtCheckNKTCT);

		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(592, 60, 11, 20);
		panel_Center.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(431, 112, 11, 20);
		panel_Center.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(592, 210, 11, 20);
		panel_Center.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(431, 260, 11, 20);
		panel_Center.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(431, 314, 11, 20);
		panel_Center.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(398, 460, 11, 20);
		panel_Center.add(lblNewLabel_5);

		px_bus = new PhanXuong_BUS();
		ArrayList<PhanXuong> list = px_bus.getDanhSachPhanXuong();
		for (PhanXuong px : list) {
			cb_PhanXuong.addItem(px.getTenPhanXuong());
		}


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
		btnChonAnh.setRadius(10);
		btnChonAnh.setBackground(new Color(255, 255, 255));
		btnChonAnh.setText("Chọn ảnh");
		btnChonAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnChonAnh.setBounds(683, 340, 130, 30);
		panel_Center.add(btnChonAnh);

		dl_ThemCapNhatCN.getContentPane().add(panel_Center, BorderLayout.CENTER);
		
		btnGoAnh = new MyButton();
		btnGoAnh.setFocusPainted(false);
		btnGoAnh.setRadius(10);
		btnGoAnh.setBackground(new Color(255, 255, 255));
		btnGoAnh.setText("Gỡ ảnh");
		btnGoAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnGoAnh.setBounds(683, 380, 130, 30);
		panel_Center.add(btnGoAnh);
		
		JLabel lbl_TKNH = new JLabel("Tài khoản ngân hàng:");
		lbl_TKNH.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lbl_TKNH.setBounds(20, 360, 154, 20);
		panel_Center.add(lbl_TKNH);
		
		txtSoNH = new JTextField("Nhập số tài khoản ngân hàng");
		txtSoNH.setForeground(Color.GRAY);
		txtSoNH.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtSoNH.setColumns(10);
		txtSoNH.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtSoNH.setBackground((Color) null);
		txtSoNH.setBounds(180, 360, 398, 20);
		panel_Center.add(txtSoNH);
		
		JLabel lblNewLabel_3_1 = new JLabel("*");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(428, 512, 11, 20);
		panel_Center.add(lblNewLabel_3_1);
		
		lblNewLabel_3_2 = new JLabel("*");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(592, 360, 11, 20);
		panel_Center.add(lblNewLabel_3_2);
		
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

		JPanel panel_ChucNang = new JPanel();
		btnThemCongNhan = new MyButton();
		btnThemCongNhan.setFocusPainted(false);
		btnThemCongNhan.setRadius(10);
		btnThemCongNhan.setText("Thêm");
		btnThemCongNhan.setBackground(new Color(0, 255, 0));
		btnThemCongNhan.setPreferredSize(new Dimension(100, 30));
		btnThemCongNhan.setForeground(new Color(0, 0, 0));
		btnThemCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThemCongNhan.setBounds(400, 30, 150, 60);
		panel_ChucNang.add(btnThemCongNhan);

		btnCapNhatCongNhan = new MyButton();
		btnCapNhatCongNhan.setFocusPainted(false);
		btnCapNhatCongNhan.setRadius(10);
		btnCapNhatCongNhan.setText("Cập nhật");
		btnCapNhatCongNhan.setPreferredSize(new Dimension(100, 30));
		btnCapNhatCongNhan.setForeground(Color.BLACK);
		btnCapNhatCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCapNhatCongNhan.setBackground(Color.GREEN);
		btnCapNhatCongNhan.setBounds(400, 30, 150, 60);
		panel_ChucNang.add(btnCapNhatCongNhan);
		Box b;
		b = Box.createVerticalBox();
		b.add(Box.createRigidArea(new Dimension(150, 30)));

		panel_ChucNang.add(b);
		btnHuyThem = new MyButton();
		btnHuyThem.setFocusPainted(false);
		btnHuyThem.setPreferredSize(new Dimension(100, 30));
		btnHuyThem.setRadius(10);
		btnHuyThem.setText("Hủy");
		btnHuyThem.setForeground(Color.BLACK);
		btnHuyThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuyThem.setBackground(new Color(255, 0, 0));
		btnHuyThem.setBounds(700, 30, 150, 60);
		panel_ChucNang.add(btnHuyThem);
		dl_ThemCapNhatCN.getContentPane().add(panel_ChucNang, BorderLayout.SOUTH);
		
		
		btnHuyThem.addActionListener(this);
		btnThemCongNhan.addActionListener(this);
		btnChonAnh.addActionListener(this);
		btnGoAnh.addActionListener(this);
		txtSoNH.addFocusListener(this);
		btnCapNhatCongNhan.addActionListener(this);
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

		ArrayList<CongNhan> list = cn_bus.getDanhSachCongNhanDangLam();
		for (CongNhan cn : list) {
			model.addRow(new Object[] { cn.getIdCongNhan(), cn.getHoTen(), cn.isPhai() ? "Nam" : "Nữ",
					cn.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					cn.getNgayBatDauCongTac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong()).getTenPhanXuong(), cn.getTayNghe(),
					cn.getEmail(), cn.getSoDienThoai(), cn.getcCCD()

			});

		}

	}

	private void hienThiDialogCapNhat(String maCN) {

		dialogThemCapNhat();
		dl_ThemCapNhatCN.setTitle("Cập nhật công nhân");
		lbl_NgayKetThucCT.setVisible(true);
		dateChooser_ngayKTCT.setVisible(true);
		txtCheckNKTCT.setVisible(true);
		btnCapNhatCongNhan.setVisible(true);
		btnThemCongNhan.setVisible(false);

		CongNhan cn = cn_bus.getCongNhanDangLamTheoID(maCN);

		txtID.setText(cn.getIdCongNhan());
		Date dateNS = java.sql.Date.valueOf(cn.getNgaySinh());
		dateChooser_NgaySinh.setDate(dateNS);
		Date dateNCT = java.sql.Date.valueOf(cn.getNgayBatDauCongTac());
		dateChooser_ngayCT.setDate(dateNCT);
		txtSoNH.setText(cn.getTaiKhoan().getTaiKhoanNganHang().getSoTaiKhoan());
		txtSoNH.setForeground(Color.BLACK);
		txtHoTen.setText(cn.getHoTen());
		txtHoTen.setForeground(Color.BLACK);
		txtCCCD.setText(cn.getcCCD());
		txtCCCD.setForeground(Color.BLACK);
		txtEmail.setText(cn.getEmail());
		txtEmail.setForeground(Color.BLACK);
		txtSDT.setText(cn.getSoDienThoai());
		txtSDT.setForeground(Color.BLACK);
		if (cn.isPhai()) {
			rdNam.setSelected(true);
		} else {
			rdNu.setSelected(true);
		}
		cb_TayNghe.setSelectedItem(cn.getTayNghe());
		cb_PhanXuong.setSelectedItem(cn.getPhanXuong().getTenPhanXuong());
		url = "src\\images\\Unknown_person.jpg";
		ImageIcon hienThiImageIcon = new ImageIcon(url);
		
		if (cn.getAnhDaiDien()!= null) {
			url = "src\\images\\" + cn.getAnhDaiDien();
			hienThiImageIcon = new ImageIcon(url); 
		}

		// Lấy kích thước mới của JLabel
		int labelWidth = avatarImage.getWidth();
		int labelHeight = avatarImage.getHeight();

		// Chỉnh kích thước ảnh theo JLabel
		Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		hienThiImageIcon = new ImageIcon(themAnh);
		avatarImage.setIcon(hienThiImageIcon);
		dl_ThemCapNhatCN.setModal(true);
		dl_ThemCapNhatCN.setVisible(true);
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

	private void hienThiThongTinCN(CongNhan cn) {
		txtHienThiID.setText(cn.getIdCongNhan());
		txtHienThiHoTen.setText(cn.getHoTen());
		txtHienThiNgaySinh.setText(cn.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		txtHienThiPhai.setText((cn.isPhai() == true) ? "Nam" : "Nữ");
		txtHienThiCCCD.setText(cn.getcCCD());
		txtHienThiSDT.setText(cn.getSoDienThoai());
		txtHienThiEmail.setText(cn.getEmail());
		txtHienThiPX.setText(px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong()).getTenPhanXuong());
		txtHienThiTayNghe.setText(cn.getTayNghe());

		ImageIcon hienThiImageIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
		if (cn.getAnhDaiDien()!= null) {
			hienThiImageIcon = new ImageIcon("src\\images\\" + cn.getAnhDaiDien());
		}

		// Lấy kích thước mới của JLabel
		int labelWidth = hienThiAvatar.getWidth();
		int labelHeight = hienThiAvatar.getHeight();

		// Chỉnh kích thước ảnh theo JLabeL
		Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		hienThiImageIcon = new ImageIcon(themAnh);
		hienThiAvatar.setIcon(hienThiImageIcon);
	}

	private void hienThiDialogThem() {

		dialogThemCapNhat();
		txtID.setText(sinhMaCN());
		lbl_NgayKetThucCT.setVisible(false);
		txtCheckNKTCT.setVisible(false);
		dateChooser_ngayKTCT.setVisible(false);
		btnThemCongNhan.setVisible(true);
		btnCapNhatCongNhan.setVisible(false);
		dl_ThemCapNhatCN.setModal(true);
		dl_ThemCapNhatCN.setVisible(true);
	}


	private CongNhan layTTCNTuTextField() {
		String maCN = txtID.getText();
		String tenCN = txtHoTen.getText();

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
		if (dateChooser_ngayKTCT.getDate()!= null) {
			Date ktctDate = dateChooser_ngayKTCT.getDate();
			int yearKTCT = ktctDate.getYear() + 1900;
			int monthKTCT = ktctDate.getMonth() + 1;
			int dayKTCT = ktctDate.getDate();
			ktct = LocalDate.of(yearKTCT, monthKTCT, dayKTCT);
		}
		
		String tenPX = cb_PhanXuong.getSelectedItem().toString();
		PhanXuong px = px_bus.getPXtheoTen(tenPX);
		boolean phai = rdNam.isSelected();
		String email = txtEmail.getText();
		String sdt = txtSDT.getText();
		String cccd = txtCCCD.getText();
		String tayNghe = cb_TayNghe.getSelectedItem().toString();
		String avatar = null;
		if (url!= null) {
			File absoluteFile = new File(url);
			avatar = absoluteFile.getName();

		}
		
		CongNhan cn = new CongNhan(maCN, tenCN, phai, ns, ct, ktct, px, email, sdt, tayNghe, null, avatar, cccd);
		return cn;
	}

	private String sinhMaCN() {
		int stt = 1;
		ArrayList<CongNhan> list = cn_bus.getDanhSachCongNhan();
		String id = "CN" + String.format("%04d", stt);
		for (CongNhan cn : list) {
			if (cn.getIdCongNhan().equals(id)) {
				stt++;
				id = "CN" + String.format("%04d", stt);
			}
		}
		return id;
	}
	private boolean kiemTraSDT() {
		int dem = 0;
		CongNhan congNhan = cn_bus.getCongNhanDangLamTheoID(txtID.getText());
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
		if(congNhan==null) {
			return dem < 1;
		}
		else {
			return dem < 2;
		}
	}
	private boolean kiemTraTKNH() {
		int dem = 0;
		CongNhan congNhan = cn_bus.getCongNhanDangLamTheoID(txtID.getText());
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
		if(congNhan==null) {
			return dem < 1;
		}
		else {
			return dem < 2;
		}
	}
	private boolean kiemTraEmail() {
		int dem = 0;
		CongNhan congNhan = cn_bus.getCongNhanDangLamTheoID(txtID.getText());
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
		if(congNhan==null) {
			return dem < 1;
		}
		else {
			return dem < 2;
		}
	}
	private boolean kiemTraCCCD() {
		int dem = 0;
		
		CongNhan cn = cn_bus.getCongNhanDangLamTheoID(txtID.getText());
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
		if(cn==null) {
			return dem < 1;
		}
		else {
			return dem < 2;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub'
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			hienThiDialogThem();
			btnCapNhatCongNhan.setVisible(false);
		}
		if (o.equals(btnThemCongNhan)) {
			if(validData()) {
				CongNhan cn = layTTCNTuTextField();
				String soNH = txtSoNH.getText();
				TaiKhoanNganHang tknh = new TaiKhoanNganHang(soNH, "Sacombank", cn.getHoTen() ,"Chi nhánh Gò Vấp, HCM");
				TaiKhoan tk = new TaiKhoan(cn.getIdCongNhan(),"1111","CN",tknh);
				cn.setTaiKhoan(tk);
				JOptionPane.showMessageDialog(null, "Thêm thành công!");
				tknh_bus.create(tknh);
				tk_bus.create(tk);
				cn_bus.create(cn);
				
				dl_ThemCapNhatCN.dispose();
				model.setRowCount(0);
				docDuLieuTuDataVaoTable();
				String maCN = cn.getIdCongNhan();
				CongNhan cn2 = cn_bus.getCongNhanDangLamTheoID(maCN);
				int m = cn_bus.getDanhSachCongNhanDangLam().indexOf(cn2);
				tableCongNhan.setRowSelectionInterval(m, m);
				tableCongNhan.scrollRectToVisible(tableCongNhan.getCellRect(m, m, true));
				hienThiThongTinCN(cn2);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng và đầy đủ thông tin cần nhập!");
			}
			

		}
		
		if (o.equals(btnHuyThem)) {
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn hủy không?", "Cảnh báo!", JOptionPane.YES_NO_OPTION);

	        if (choice == JOptionPane.YES_OPTION) {
	        	dl_ThemCapNhatCN.dispose();
	        } else {
	            return;
	        }
			
		}
		if (o.equals(btnTimKiem)) {
			String ma = txtTimKiem.getText();
			if (ma.equals("Nhập mã công nhân cần tìm VD: CN0001")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã công nhân!");
				
			} else {

				CongNhan cn = cn_bus.getCongNhanDangLamTheoID(ma);
				if (cn!= null) {
					model.setRowCount(0);
					model.addRow(new Object[] { cn.getIdCongNhan(), cn.getHoTen(), cn.isPhai() ? "Nam" : "Nữ",
							cn.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							cn.getNgayBatDauCongTac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong()).getTenPhanXuong(), cn.getTayNghe(),
							cn.getEmail(), cn.getSoDienThoai(), cn.getcCCD()

					});
					tableCongNhan.setRowSelectionInterval(0, 0);
					hienThiThongTinCN(cn);
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy công nhân có mã " + ma+"!");
					txtTimKiem.setText("Nhập mã công nhân cần tìm VD: CN0001");
					txtTimKiem.setForeground(Color.GRAY);
				}

			}

		}
		if (o.equals(btnCapNhat)) {
			int r = tableCongNhan.getSelectedRow();
			if (r == -1) {

				JOptionPane.showMessageDialog(null, "Chọn 1 công nhân để cập nhật!");
			} else {
				String maCN = tableCongNhan.getValueAt(r, 0).toString();
				hienThiDialogCapNhat(maCN);
			}
		}
		if (o.equals(btnCapNhatCongNhan)) {
			if(validData()) {
				CongNhan cn_old = cn_bus.getCongNhanDangLamTheoID(txtID.getText());
	
				CongNhan cn_new = layTTCNTuTextField();
				
				String soTKNH = txtSoNH.getText();
				tk_bus.updateTaiKhoan(cn_new.getIdCongNhan(),"CN", null);
				TaiKhoanNganHang tknh_old = cn_old.getTaiKhoan().getTaiKhoanNganHang();
				tknh_bus.update(tknh_old, soTKNH);
				tk_bus.updateTaiKhoan(cn_new.getIdCongNhan(), "CN",soTKNH);
				
				
				
				TaiKhoan tk = tk_bus.getTaiKhoan(cn_new.getIdCongNhan());
				cn_new.setTaiKhoan(tk);
				cn_bus.update(cn_new);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				dl_ThemCapNhatCN.dispose();
				String maCN = cn_new.getIdCongNhan();
				CongNhan cn2 = cn_bus.getCongNhanDangLamTheoID(maCN);
				model.setRowCount(0);
				docDuLieuTuDataVaoTable();
				if (cn2 == null) {
					return;
				}
				int m = cn_bus.getDanhSachCongNhanDangLam().indexOf(cn2);
				tableCongNhan.setRowSelectionInterval(m, m);
				tableCongNhan.scrollRectToVisible(tableCongNhan.getCellRect(m, m, true));
				hienThiThongTinCN(cn2);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng và đầy đủ thông tin cần nhập!");
			}
			
		}
		if(o.equals(btnLamMoi)) {
			model.setRowCount(0);
			docDuLieuTuDataVaoTable();
			txtTimKiem.setText("Nhập mã công nhân cần tìm VD: CN0001");
			txtTimKiem.setForeground(Color.GRAY);
			txtHienThiID.setText("");
			txtHienThiHoTen.setText("");
			txtHienThiEmail.setText("");
			txtHienThiCCCD.setText("");
			txtHienThiNgaySinh.setText("");
			txtHienThiPhai.setText("");
			txtHienThiPX.setText("");
			txtHienThiSDT.setText("");
			txtHienThiTayNghe.setText("");
			
			ImageIcon hienThiImageIcon = new ImageIcon("src\\images\\Unknown_person.jpg");

			// Lấy kích thước mới của JLabel
			int labelWidth = hienThiAvatar.getWidth();
			int labelHeight = hienThiAvatar.getHeight();

			// Chỉnh kích thước ảnh theo JLabel
			Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
			hienThiImageIcon = new ImageIcon(themAnh);
			hienThiAvatar.setIcon(hienThiImageIcon);
			
		}
		if(o.equals(cbLocPX)) {
			String tenPX = cbLocPX.getSelectedItem().toString();
			PhanXuong px = px_bus.getPXtheoTen(tenPX);
			ArrayList<CongNhan> listCNPX =  cn_bus.getDanhSachCongNhanDangLamTheoPX(px.getIdPhanXuong());
			if(listCNPX.size()==0) {
				JOptionPane.showMessageDialog(this, "Không có công nhân nào trong phân xưởng " + tenPX);
				return;
			}
			else {
				model.setRowCount(0);
				for (CongNhan cn : listCNPX) {
					model.addRow(new Object[] { cn.getIdCongNhan(), cn.getHoTen(), cn.isPhai() ? "Nam" : "Nữ",
							cn.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							cn.getNgayBatDauCongTac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
							px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong()).getTenPhanXuong(), cn.getTayNghe(),
							cn.getEmail(), cn.getSoDienThoai(), cn.getcCCD()

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

		int n = tableCongNhan.getSelectedRow();
		String maCN = tableCongNhan.getValueAt(n, 0).toString();
		CongNhan cn = cn_bus.getCongNhanDangLamTheoID(maCN);
		hienThiThongTinCN(cn);

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
			 if (txtTimKiem.getText().equals("Nhập mã công nhân cần tìm VD: CN0001")) {
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
		if (o.equals(txtSoNH)) {
			txtCheckSoNH.setText("");
			 if (txtSoNH.getText().equals("Nhập số tài khoản ngân hàng")) {
				 txtSoNH.setText("");
				 txtSoNH.setForeground(Color.BLACK);
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
				txtTimKiem.setText("Nhập mã công nhân cần tìm VD: CN0001");
				txtTimKiem.setForeground(Color.GRAY);
            }
		}

	}
}
