package form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Scrollbar;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import bus.BangLuongNhanVien_BUS;
import bus.ChamCongNhanVien_BUS;
import bus.ChucVu_BUS;
import bus.NhanVien_BUS;
import bus.TaiKhoan_BUS;
import commons.RoundPanel;
import commons.Table;
import connectDB.ConnectDB;
import entities.ChucVu;
import entities.LuongNhanVien;
import entities.NhanVien;
import entities.PhongBan;
import entities.TaiKhoan;

import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;

public class TinhLuongNhanVien_Form extends JPanel implements ActionListener, MouseListener {
	private int width = 1250;
	private int height = 725;
	private BangLuongNhanVien_BUS bl_bus;
	private ChamCongNhanVien_BUS ccnv_bus;
	private ChucVu_BUS cv_bus;
	private NhanVien_BUS nv_bus;

	private JTextField txtTenNV;
	private JTextField txtIdLuong;
	private JTextField txtPhanXuong;
	private JTextField txtTen;
	private JTextField txtTongLuong;
	private JTextField txtThucLanh;
	private Table tableLuong;

	private DefaultTableModel dftable;
	private JButton btnTinhLuong;
	private JButton btnExcel;
	private JButton btnEmail;
	private JComboBox cbbNam;
	private JComboBox cbbThang;
	private JComboBox cbbPhongBan;
	private Container panelCenterLeft;
	private JLabel lbl;
	private JLabel lbl_4;
	private JLabel lbl_7;
	private JTextField searchField;
	private JLabel lbl_slnv;
	private JLabel lbl_lcb;
	private JLabel lbl_pc;
	private JLabel lbl_thue;
	private JLabel lbl_bhxh;
	private JLabel lbl_luongThucTe;
	private JLabel lbl_thucLanh;
	private String[] dataSearch;
	private JButton btnSearch;
	private RoundPanel panel_southTitle;
	private JTable table_chiTiet1;
	private JTable table_chiTiet2;
	private TaiKhoan_BUS tk_bus;

	public TinhLuongNhanVien_Form(int width, int height) {
		setBackground(new Color(240, 240, 240));
		bl_bus = new BangLuongNhanVien_BUS();
		ccnv_bus = new ChamCongNhanVien_BUS();
		cv_bus = new ChucVu_BUS();
		nv_bus = new NhanVien_BUS();
		tk_bus = new TaiKhoan_BUS();
		try {
			try {
				ConnectDB.getInstance().connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.height = height;
		this.width = width;

		setPreferredSize(new Dimension(1250, 777));
		setLayout(null);
		Calendar calendar = Calendar.getInstance();
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);
		int startYear = 2010; // Năm bắt đầu
		int endYear = 2025; // Năm kết thúc
		String[] years = new String[endYear - startYear + 1];
		for (int i = startYear; i <= endYear; i++) {
			years[i - startYear] = "Năm " + String.valueOf(i);
		}
		cbbNam = new JComboBox(years);
		cbbNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNam.setBounds(23, 23, 142, 30);
		cbbNam.setSelectedItem("Năm " + String.valueOf(currentYear));
		add(cbbNam);

		String[] months = { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8",
				"Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" };
		cbbThang = new JComboBox(months);
		cbbThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThang.setBounds(206, 23, 142, 30);
		cbbThang.setSelectedIndex(currentMonth);
		add(cbbThang);

		cbbPhongBan = new JComboBox();
		cbbPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbPhongBan.setBounds(383, 23, 142, 30);
		add(cbbPhongBan);

		RoundPanel pSouth = new RoundPanel();
		pSouth.setBackground(new Color(255, 255, 255));
		pSouth.setBounds(23, 315, 1209, 452);
		pSouth.setRound(20);
		pSouth.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(pSouth);
		pSouth.setLayout(new BorderLayout(0, 0));
		tableLuong = new Table();
		tableLuong.setOpaque(false);
		// Cài đặt header cho table Chấm công
		tableLuong.setModel(dftable = new DefaultTableModel(new Object[][] {},
				new String[] { "STT","ID Lương","Ngày Tính Lương", "Ph\u00F2ng Ban", "ID Nh\u00E2n Vi\u00EAn", "H\u1ECD T\u00EAn",
						"Ch\u1EE9c V\u1EE5", "L\u01B0\u01A1ng C\u01A1 B\u1EA3n", "H\u1EC7 S\u1ED1 L\u01B0\u01A1ng",
						"Ph\u1EE5 C\u1EA5p", "T\u1ED5ng L\u01B0\u01A1ng", "BHXH", "Thu\u1EBF",
						"Th\u1EF1c L\u00E3nh", }));
		tableLuong.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableLuong.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableLuong.getColumnModel().getColumn(4).setPreferredWidth(50);
		tableLuong.getColumnModel().getColumn(6).setPreferredWidth(30);
		tableLuong.getColumnModel().getColumn(8).setPreferredWidth(30);
		tableLuong.getColumnModel().getColumn(10).setPreferredWidth(100);
		tableLuong.getColumnModel().getColumn(13).setPreferredWidth(80);
		DefaultTableCellRenderer centerHeaderRenderer = (DefaultTableCellRenderer) tableLuong
				.getDefaultRenderer(Object.class);
		centerHeaderRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setOpaque(false);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(tableLuong);
		pSouth.add(scrollPane, BorderLayout.CENTER);

		tableLuong.fixTable(scrollPane);

		// Khởi tạo panel chứa tiêu đề của bảng
		panel_southTitle = new RoundPanel();
		panel_southTitle.setRound(10);
		panel_southTitle.setOpaque(false);
		panel_southTitle.setBackground(new Color(153, 204, 255));
		pSouth.add(panel_southTitle, BorderLayout.NORTH);

		JLabel lbldsCC = new JLabel("Danh sách lương tháng 10 - 2023 ");
		lbldsCC.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_southTitle.add(lbldsCC);
		RoundPanel panel = new RoundPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setRound(20);
		panel.setBounds(23, 64, 1214, 196);
		add(panel);
		panel.setLayout(null);

		JLabel lblThngTinChung = new JLabel("Thông Tin Chung");
		lblThngTinChung.setForeground(new Color(0, 0, 205));
		lblThngTinChung.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngTinChung.setBounds(10, 11, 164, 28);
		panel.add(lblThngTinChung);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(20, 39, 1194, 147);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lbl_1 = new JLabel("Tổng số lượng nhân viên");
		lbl_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_1.setBounds(10, 11, 161, 25);
		panel_1.add(lbl_1);

		JLabel lbl_2 = new JLabel("Tổng lương cơ bản");
		lbl_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_2.setBounds(10, 63, 135, 25);
		panel_1.add(lbl_2);

		JLabel lbl_5 = new JLabel("Tổng Phụ Cấp");
		lbl_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_5.setBounds(10, 111, 83, 25);
		panel_1.add(lbl_5);

		JLabel lbl_6 = new JLabel("Tổng Thuế");
		lbl_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_6.setBounds(420, 11, 83, 25);
		panel_1.add(lbl_6);

		lbl = new JLabel("Tổng BHXH");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl.setBounds(420, 63, 83, 25);
		panel_1.add(lbl);

		lbl_4 = new JLabel("Tổng Lương Thực Tế");
		lbl_4.setFont(new Font("Dialog", Font.PLAIN, 13));
		lbl_4.setBounds(420, 111, 161, 25);
		panel_1.add(lbl_4);

		lbl_7 = new JLabel("Tổng Thực Lãnh");
		lbl_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_7.setBounds(816, 110, 161, 25);
		panel_1.add(lbl_7);

		lbl_slnv = new JLabel("");
		lbl_slnv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_slnv.setBounds(201, 14, 143, 19);
		panel_1.add(lbl_slnv);

		lbl_lcb = new JLabel("");
		lbl_lcb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_lcb.setBounds(201, 63, 143, 19);
		panel_1.add(lbl_lcb);

		lbl_pc = new JLabel("");
		lbl_pc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_pc.setBounds(201, 111, 143, 19);
		panel_1.add(lbl_pc);

		lbl_thue = new JLabel("");
		lbl_thue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_thue.setBounds(600, 14, 143, 19);
		panel_1.add(lbl_thue);

		lbl_bhxh = new JLabel("");
		lbl_bhxh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_bhxh.setBounds(600, 66, 143, 19);
		panel_1.add(lbl_bhxh);

		lbl_luongThucTe = new JLabel("");
		lbl_luongThucTe.setFont(new Font("Dialog", Font.PLAIN, 13));
		lbl_luongThucTe.setBounds(600, 114, 143, 19);
		panel_1.add(lbl_luongThucTe);

		lbl_thucLanh = new JLabel("");
		lbl_thucLanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_thucLanh.setBounds(998, 113, 186, 19);
		panel_1.add(lbl_thucLanh);

		btnExcel = new JButton("Xuất Excel");
		btnExcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcel.setBounds(874, 23, 158, 30);
		add(btnExcel);

		btnEmail = new JButton("Gửi Email Hàng Loạt");
		btnEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEmail.setBounds(1053, 23, 179, 30);
		add(btnEmail);

		btnTinhLuong = new JButton("Bảng Lương");
		btnTinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTinhLuong.setBounds(680, 23, 158, 30);
		add(btnTinhLuong);
		//
		searchField = new JTextField();
		searchField.setBounds(923, 270, 187, 30);
		add(searchField);
		searchField.setColumns(10);

		btnSearch = new JButton("Tìm Kiếm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(1120, 270, 112, 30);
		add(btnSearch);
		docDuLieuPhongBan();
		btnTinhLuong.addActionListener(this);
		btnExcel.addActionListener(this);
		btnEmail.addActionListener(this);
		btnSearch.addActionListener(this);
		tableLuong.addMouseListener(this);

	}

	public void xoaTable() {
		DefaultTableModel model = (DefaultTableModel) tableLuong.getModel();
		model.setRowCount(0);
	}

	public void docDulieuVaoTable(int thang, int nam, String phongBan) throws SQLException {
		xoaTable();
		ArrayList<NhanVien> dsnv = new ArrayList<>();
		ArrayList<LuongNhanVien> dslnv=new ArrayList<>();
		int stt = 1;
		int tongSoLuong=0;
		double luongCb = 0, tongPhuCap = 0, tongThue = 0, tongBhxh = 0, luongThucTe = 0, tongThucLanh = 0;
		dslnv = bl_bus.getAllTableTinhLuongTheoThang(phongBan, thang, nam);
		if(dslnv.isEmpty()) {
			dsnv = ccnv_bus.getDSChamCongNhanVien(thang, nam, phongBan);
			if (dsnv.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu để tính lương");
			}
			tongSoLuong = dsnv.size();
			for (NhanVien nv : dsnv) {
				LuongNhanVien l = bl_bus.getLuongNhanVien(nv.getIdNhanVien(), thang, nam);
				String idBangLuong =  getIdBangLuong(l.getIdLuong());
				l.setIdLuong(idBangLuong);
				bl_bus.themBangLuongNhanVien(l, thang, nam);
				ChucVu c = cv_bus.getCV(nv.getChucVu().getIdChucVu());
				DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
				String tongLuong = decimalFormat.format(l.getTongLuong()) + " VND";
				String bhxh = decimalFormat.format(l.getThueBHXH()) + " VND";
				String thue = decimalFormat.format(l.getThueLaoDong()) + " VND";
				String thuclanh = decimalFormat.format(l.getThucLanh()) + "VND";
				String phuCap = decimalFormat.format(nv.getPhuCap()) + " VND";
				String luongCB = decimalFormat.format(nv.getLUONGCOBAN()) + " VND";
				tongPhuCap += nv.getPhuCap();
				tongThue += l.getThueLaoDong();
				tongBhxh += l.getThueBHXH();
				luongThucTe += l.getTongLuong();
				tongThucLanh += l.getThucLanh();
				luongCb += nv.getLUONGCOBAN();
				dftable.addRow(new Object[] { stt,l.getIdLuong(), l.getNgayTinhLuong(), phongBan, nv.getIdNhanVien(), nv.getHoTen(), c.getTenChucVu(), luongCB,
						c.getHeSoLuong(), phuCap, tongLuong, bhxh, thue, thuclanh });
				stt++;
			}
		}else {
			tongSoLuong = dslnv.size();
			for (LuongNhanVien lnv : dslnv) {
				NhanVien nv = nv_bus.getNV(lnv.getNhanVien().getIdNhanVien());
				ChucVu c = cv_bus.getCV(nv.getChucVu().getIdChucVu());
				DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
				String tongLuong = decimalFormat.format(lnv.getTongLuong()) + " VND";
				String bhxh = decimalFormat.format(lnv.getThueBHXH()) + " VND";
				String thue = decimalFormat.format(lnv.getThueLaoDong()) + " VND";
				String thuclanh = decimalFormat.format(lnv.getThucLanh()) + "VND";
				String phuCap = decimalFormat.format(nv.getPhuCap()) + " VND";
				String luongCB = decimalFormat.format(nv.getLUONGCOBAN()) + " VND";
				tongPhuCap += nv.getPhuCap();
				tongThue += lnv.getThueLaoDong();
				tongBhxh += lnv.getThueBHXH();
				luongThucTe += lnv.getTongLuong();
				tongThucLanh += lnv.getThucLanh();
				luongCb += nv.getLUONGCOBAN();
				dftable.addRow(new Object[] { stt,lnv.getIdLuong(), lnv.getNgayTinhLuong(), phongBan, nv.getIdNhanVien(), nv.getHoTen(), c.getTenChucVu(), luongCB,
						c.getHeSoLuong(), phuCap, tongLuong, bhxh, thue, thuclanh });
				stt++;
			}
		}
		
		
		
		docDuLieuVaoThongTinChung(tongSoLuong, luongCb, tongPhuCap, tongThue, tongBhxh, luongThucTe, tongThucLanh);
	}

	public void docDuLieuVaoThongTinChung(int tongSoLuong, double luongCb, double tongPhuCap, double tongThue,
			double tongBhxh, double luongThucTe, double tongThucLanh) {
		if (tongSoLuong == 0) {
			lbl_lcb.setText("");
			lbl_pc.setText("");
			lbl_thue.setText("");
			lbl_bhxh.setText("");
			lbl_luongThucTe.setText("");
			lbl_thucLanh.setText("");
			lbl_slnv.setText("");
		} else {
			DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
			lbl_lcb.setText(decimalFormat.format(luongCb) + " VND");
			lbl_pc.setText(decimalFormat.format(tongPhuCap) + " VND");
			lbl_thue.setText(decimalFormat.format(tongThue) + " VND");
			lbl_bhxh.setText(decimalFormat.format(tongBhxh) + " VND");
			lbl_luongThucTe.setText(decimalFormat.format(luongThucTe) + " VND");
			lbl_thucLanh.setText(decimalFormat.format(tongThucLanh) + " VND");
			lbl_slnv.setText(tongSoLuong + "");
		}

	}

	public void docDuLieuPhongBan() {
		ArrayList<PhongBan> dspb = new ArrayList<>();
		dspb = bl_bus.getAllPhongBan();
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
		for (PhongBan phongBan : dspb) {
			comboBoxModel.addElement(phongBan.getTenPhongBan());
		}
		cbbPhongBan.setModel(comboBoxModel);
	}
	public String getIdBangLuong(String id) {
		boolean check =  bl_bus.kiemTraTonTaiLuongNhanVien(id);
		String a = "LNV0001";
		int stt=1;
		while(check) {
			stt++;
			 String formattedCounter = String.format("%04d", stt);
			  a = "LNV"+ formattedCounter;
			  check =  bl_bus.kiemTraTonTaiLuongNhanVien(a);
		}
		return a;
	}
	public static void main(String[] args) {
		new TinhLuongNhanVien_Form(WIDTH, HEIGHT).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnTinhLuong)) {
			int thang;
			int nam;
			try {
				thang = Integer.parseInt(((String) cbbThang.getSelectedItem()).replaceAll("\\D", ""));
				nam = Integer.parseInt(((String) cbbNam.getSelectedItem()).replaceAll("\\D", ""));
			} catch (NumberFormatException e1) {
				// Xử lý ngoại lệ nếu chuỗi không chứa số
				thang = 0; // hoặc giá trị mặc định khác bạn muốn đặt
				nam = 0;
			}
			String pb = (String) cbbPhongBan.getSelectedItem();

			try {
				docDulieuVaoTable(thang, nam, pb);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (obj.equals(btnSearch)) {
			xoaTable();
			int thang;
			int nam;
			try {
				thang = Integer.parseInt(((String) cbbThang.getSelectedItem()).replaceAll("\\D", ""));
				nam = Integer.parseInt(((String) cbbNam.getSelectedItem()).replaceAll("\\D", ""));
			} catch (NumberFormatException e1) {
				// Xử lý ngoại lệ nếu chuỗi không chứa số
				thang = 0; // hoặc giá trị mặc định khác bạn muốn đặt
				nam = 0;
			}
			String pb = (String) cbbPhongBan.getSelectedItem();

			ArrayList<LuongNhanVien> dslnv = bl_bus.getAllTableTinhLuongTheoThang(pb, thang, nam);
			int stt = 1;
			double luongCb = 0, tongPhuCap = 0, tongThue = 0, tongBhxh = 0, luongThucTe = 0, tongThucLanh = 0;
			boolean checkNV = false;

			int tongSoLuong = dslnv.size();
			String txtSearch = searchField.getText();
			for (LuongNhanVien lnv : dslnv) {
				NhanVien nv = nv_bus.getNV(lnv.getNhanVien().getIdNhanVien());
				if (lnv.getIdLuong().contains(txtSearch) || nv.getIdNhanVien().contains(txtSearch) || nv.getHoTen().contains(txtSearch)) {
					checkNV = true;
					ChucVu c = cv_bus.getCV(nv.getChucVu().getIdChucVu());
					DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
					String tongLuong = decimalFormat.format(lnv.getTongLuong()) + " VND";
					String bhxh = decimalFormat.format(lnv.getThueBHXH()) + " VND";
					String thue = decimalFormat.format(lnv.getThueLaoDong()) + " VND";
					String thuclanh = decimalFormat.format(lnv.getThucLanh()) + "VND";
					String phuCap = decimalFormat.format(nv.getPhuCap()) + " VND";
					String luongCB = decimalFormat.format(nv.getLUONGCOBAN()) + " VND";
					tongPhuCap += nv.getPhuCap();
					tongThue += lnv.getThueLaoDong();
					tongBhxh += lnv.getThueBHXH();
					luongThucTe += lnv.getTongLuong();
					tongThucLanh += lnv.getThucLanh();
					luongCb += nv.getLUONGCOBAN();
					dftable.addRow(new Object[] { stt, pb, nv.getIdNhanVien(), nv.getHoTen(), c.getTenChucVu(), luongCB,
							c.getHeSoLuong(), phuCap, tongLuong, bhxh, thue, thuclanh });
					stt++;;
				}
			}
			if (!checkNV) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");;
				tongSoLuong=0;
			}
			docDuLieuVaoThongTinChung(tongSoLuong, luongCb, tongPhuCap, tongThue, tongBhxh, luongThucTe, tongThucLanh);
		}
	}

	public void docDuLieuChiTiet() {

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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(tableLuong)) {
			int r = tableLuong.getSelectedRow();
			int thang;
			int nam;
			try {
				thang = Integer.parseInt(((String) cbbThang.getSelectedItem()).replaceAll("\\D", ""));
				nam = Integer.parseInt(((String) cbbNam.getSelectedItem()).replaceAll("\\D", ""));
			} catch (NumberFormatException e1) {
				// Xử lý ngoại lệ nếu chuỗi không chứa số
				thang = 0; // hoặc giá trị mặc định khác bạn muốn đặt
				nam = 0;
			}
		    TaiKhoan stk = tk_bus.getTaiKhoan((String) tableLuong.getValueAt(r, 4));
		    int[] chiTiet= bl_bus.getChiTietLuong((String) tableLuong.getValueAt(r, 4), thang, nam);
			JDialog dialog = new JDialog();
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(1250, 906));
			panel.setLayout(null);
			dialog.add(panel);
			panel.setBounds(73, 43, 700, 500);
			dialog.add(panel);
			panel.setLayout(null);
			
			
			RoundPanel pSouthh = new RoundPanel();
			pSouthh.setBackground(new Color(153, 204, 255));
			pSouthh.setBounds(15, 10, 660, 40);
			pSouthh.setRound(20);
			pSouthh.setBorder(new EmptyBorder(5, 5, 5, 5));
			RoundPanel panel_2 = new RoundPanel();
			panel_2.setRound(10);
			panel_2.setOpaque(false);
			panel_2.setBackground(new Color(153, 204, 255));
			pSouthh.add(panel_2, BorderLayout.NORTH);

			JLabel lbldsCCC = new JLabel("Danh sách lương tháng 10 - 2023 ");
			lbldsCCC.setFont(new Font("SansSerif", Font.PLAIN, 15));
			panel_southTitle.add(lbldsCCC);
			panel.add(pSouthh, BorderLayout.NORTH);
			JLabel lblNewLabel = new JLabel("Chi Tiết Bảng Lương Nhân Viên Tháng 10 - 2023");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel_2.add(lblNewLabel);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 62, 660, 150);
			panel.add(scrollPane);
			table_chiTiet1 = new JTable();
			table_chiTiet1.setModel(
					new DefaultTableModel(new Object[][] { 
						{ "Tên Nhân Viên", (String) tableLuong.getValueAt(r, 5) },
						{ "Số Tài Khoản", stk.getTaiKhoanNganHang().getSoTaiKhoan() },
						{ "Phòng Ban", (String) tableLuong.getValueAt(r, 3) },
						{ "Chức Vụ", (String) tableLuong.getValueAt(r, 6) },
						{ "Số Ngày Công Thực Tế Trong Tháng", chiTiet[0] },
						{ "Ngày Nhận", LocalDate.now() }, }, 
					new String[] { "New column", "New column" }));
			scrollPane.setColumnHeaderView(table_chiTiet1);
			int cellHeight = 25;
			table_chiTiet1.setRowHeight(cellHeight);
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(15, 233, 660, 183);
			panel.add(scrollPane_1);
			table_chiTiet2 = new JTable();
			table_chiTiet2.setModel(new DefaultTableModel(new Object[][] { 
				{ "Lương Co Bản",null,null, (String) tableLuong.getValueAt(r, 7) },
				{ "Hệ Số Lương", ""+tableLuong.getValueAt(r, 8),null,null },
				{ "Số Ngày Công", chiTiet[1]+"","Ngày",null },
				{ "Phụ Cấp",null,null, (String) tableLuong.getValueAt(r, 9) },
				{ "TỔNG LƯƠNG",null,null, (String) tableLuong.getValueAt(r, 10) }, 
				{ "Số Ngày Nghỉ Có Phép", chiTiet[2]+"","Ngày",null }, 
				{ "Số Ngày Nghỉ Không Phép", chiTiet[3]+"","Ngày",chiTiet[4]+"" }, 
				{ "Bảo Hiểm Xã Hội",null,null,(String) tableLuong.getValueAt(r,11) }, 
				{ "Thuế Thu Nhập",null,null, (String) tableLuong.getValueAt(r, 12) }, 
				{"Thực Lãnh",null,null,(String) tableLuong.getValueAt(r, 13) }
				},
					new String[] { "T\u00EAn M\u1EE5c Ph\u1EE5 C\u1EA5p", "S\u1ED1 Ng\u00E0y / Gi\u1EDD",
							"\u0110\u01A1n V\u1ECB Ch\u1EA5m C\u00F4ng", "S\u1ED1 Ti\u1EC1n" }));
			table_chiTiet2.getColumnModel().getColumn(0).setPreferredWidth(100);
			table_chiTiet2.getColumnModel().getColumn(0).setMinWidth(100);
			table_chiTiet2.getColumnModel().getColumn(1).setMinWidth(100);
			table_chiTiet2.getColumnModel().getColumn(2).setMinWidth(100);
			table_chiTiet2.getColumnModel().getColumn(3).setMinWidth(100);
			// Tạo một đối tượng DefaultTableCellRenderer
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

	        // Thiết lập đối tượng renderer cho tất cả các cột
	        for (int i = 1; i < table_chiTiet2.getColumnCount(); i++) {
	        	table_chiTiet2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	        }
	     // Thiết lập đối tượng renderer cho tất cả các cột
	        for (int i = 1; i < table_chiTiet1.getColumnCount(); i++) {
	        	table_chiTiet1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	        }
			scrollPane_1.setViewportView(table_chiTiet2);
			JButton btnNewButton = new JButton("In");
			btnNewButton.setBounds(15, 427, 92, 28);
			panel.add(btnNewButton);
			JButton btnExcel = new JButton("Excel");
			btnExcel.setBounds(140, 427, 92, 28);
			panel.add(btnExcel);
			JButton btnng = new JButton("Đóng");
			btnng.setBounds(259, 427, 92, 28);
			panel.add(btnng);
			dialog.setSize(700, 500);
			dialog.setLocationRelativeTo(null); // Hiển thị JDialog ở trung tâm JFrame
			dialog.setVisible(true);
		}
	}
}
