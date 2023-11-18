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

import bus.BangLuongCongNhan_BUS;
import bus.BangLuongNhanVien_BUS;
import bus.ChamCongCongNhan_BUS;
import bus.ChamCongNhanVien_BUS;
import bus.ChucVu_BUS;
import bus.CongNhan_BUS;
import bus.NhanVien_BUS;
import bus.PhanXuong_BUS;
import bus.PhongBan_BUS;
import bus.TaiKhoanNganHang_BUS;
import bus.TaiKhoan_BUS;
import commons.RoundPanel;
import commons.Table;
import connectDB.ConnectDB;
import entities.ChucVu;
import entities.CongNhan;
import entities.LuongCongNhan;
import entities.LuongNhanVien;
import entities.NhanVien;
import entities.PhanXuong;
import entities.PhongBan;
import entities.TaiKhoan;
import entities.TaiKhoanNganHang;

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

public class TinhLuongCongNhan_Form extends JPanel implements ActionListener, MouseListener {
	private int width = 1250;
	private int height = 725;
	private BangLuongCongNhan_BUS bl_bus;
	private ChamCongCongNhan_BUS cccn_bus;
	private PhanXuong_BUS px_bus;
	private CongNhan_BUS cn_bus;
	private TaiKhoanNganHang_BUS tknh_bus;

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
	private JLabel lbl_slcn;
	private JLabel lbl_sp;
	private JLabel lbl_time;
	private JLabel lbl_lsp;
	private JLabel lbl_ltc;
	private JLabel lbl_pc;
	private JLabel lbl_thucLanh;
	private String[] dataSearch;
	private JButton btnSearch;
	private RoundPanel panel_southTitle;
	private JTable table_chiTiet1;
	private JTable table_chiTiet2;
	private TaiKhoan_BUS tk_bus;

	public TinhLuongCongNhan_Form(int width, int height) {
		setBackground(new Color(240, 240, 240));
		bl_bus = new BangLuongCongNhan_BUS();
		cccn_bus = new ChamCongCongNhan_BUS();
		px_bus = new PhanXuong_BUS();
		cn_bus = new CongNhan_BUS();
		tk_bus = new TaiKhoan_BUS();
		tknh_bus=new TaiKhoanNganHang_BUS();
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
				new String[] { "STT","ID Lương","Ngày Tính Lương","Phân Xưởng", "ID Công Nhân", "Tên Công Nhân","Tổng Thời Gian Làm Việc","Tổng Sản Lượng Hoàn Thành",
						"Lương Hành Chánh",
						"Lương Tăng Ca", "Phụ Cấp", "Thực Lãnh"}));
		tableLuong.getColumnModel().getColumn(0).setPreferredWidth(20);
//		tableLuong.getColumnModel().getColumn(1).setPreferredWidth(20);
//		tableLuong.getColumnModel().getColumn(2).setPreferredWidth(20);
//		tableLuong.getColumnModel().getColumn(3).setPreferredWidth(30);
//		tableLuong.getColumnModel().getColumn(6).setPreferredWidth(30);
//		tableLuong.getColumnModel().getColumn(8).setPreferredWidth(100);
//		tableLuong.getColumnModel().getColumn(11).setPreferredWidth(80);
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
		lblThngTinChung.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblThngTinChung.setBounds(20, 11, 164, 28);
		panel.add(lblThngTinChung);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(20, 39, 1194, 147);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lbl_1 = new JLabel("Tổng số lượng công nhân");
		lbl_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_1.setBounds(10, 11, 161, 25);
		panel_1.add(lbl_1);

		JLabel lbl_2 = new JLabel("Tổng Sản lượng Sản Phẩm");
		lbl_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_2.setBounds(10, 63, 161, 25);
		panel_1.add(lbl_2);

		JLabel lbl_5 = new JLabel("Tổng Thời Gian Làm Việc");
		lbl_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_5.setBounds(10, 111, 143, 25);
		panel_1.add(lbl_5);

		JLabel lbl_6 = new JLabel("Tổng Lương Sản Phẩm");
		lbl_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_6.setBounds(420, 11, 143, 25);
		panel_1.add(lbl_6);

		lbl = new JLabel("Tổng Lương Tăng Ca");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl.setBounds(420, 63, 143, 25);
		panel_1.add(lbl);

		lbl_4 = new JLabel("Tổng Phụ Cấp");
		lbl_4.setFont(new Font("Dialog", Font.PLAIN, 13));
		lbl_4.setBounds(420, 111, 161, 25);
		panel_1.add(lbl_4);

		lbl_7 = new JLabel("Tổng Thực Lãnh");
		lbl_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_7.setBounds(816, 110, 161, 25);
		panel_1.add(lbl_7);

		lbl_slcn = new JLabel("");
		lbl_slcn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_slcn.setBounds(201, 14, 143, 19);
		panel_1.add(lbl_slcn);

		lbl_sp = new JLabel("");
		lbl_sp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_sp.setBounds(201, 63, 143, 19);
		panel_1.add(lbl_sp);

		lbl_time = new JLabel("");
		lbl_time.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_time.setBounds(201, 111, 143, 19);
		panel_1.add(lbl_time);

		lbl_lsp = new JLabel("");
		lbl_lsp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_lsp.setBounds(600, 14, 143, 19);
		panel_1.add(lbl_lsp);

		lbl_ltc = new JLabel("");
		lbl_ltc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_ltc.setBounds(600, 66, 143, 19);
		panel_1.add(lbl_ltc);

		lbl_pc = new JLabel("");
		lbl_pc.setFont(new Font("Dialog", Font.PLAIN, 13));
		lbl_pc.setBounds(600, 114, 143, 19);
		panel_1.add(lbl_pc);

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
		docDuLieuPhanXuong();
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

	public void docDulieuVaoTable(int thang, int nam, String phanXuong) throws SQLException {
		xoaTable();
		ArrayList<CongNhan> dscn = new ArrayList<>();
		ArrayList<LuongCongNhan> dslcn = new ArrayList<>();
		int stt = 1;
		int tongSoLuong=0;
		dslcn = bl_bus.getAllTableTinhLuongTheoThang(phanXuong, thang, nam);
		double tongThoiGianLamViec = 0, tongSoLuongSanPham = 0, tongLuongHanhChanh = 0, tongLuongTangCa = 0, tongPhuCap = 0, tongThucLanh = 0;
		if(dslcn.isEmpty()) {
			dscn = cccn_bus.getDSChamCongCongNhan(thang, nam, phanXuong);			
			if (dscn.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu để tính lương");;
			}
			tongSoLuong = dscn.size();
			for (CongNhan cn : dscn) {
				LuongCongNhan l = bl_bus.getLuongCongNhan(cn.getIdCongNhan(), thang, nam);
				int[] values = bl_bus.TinhTongSanLuongVaThoiGianLamViec( cn.getIdCongNhan(), thang, nam);
				String idBangLuong =  getIdBangLuong(l.getIdLuongCN());
				l.setIdLuongCN(idBangLuong);
				bl_bus.themBangLuongCongNhan(l, thang, nam);
				DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
				String luongHanhChanh = decimalFormat.format(l.getTongLuong()) + " VND";
				String thucLanh = decimalFormat.format(l.getThucLanh()) + " VND";
				String phuCap = decimalFormat.format(cn.getPhuCap()) + " VND";
				
				double tangCa = l.getThucLanh()-l.getTongLuong()-cn.getPhuCap();
				String luongTangCa = decimalFormat.format(tangCa) + " VND";
				dftable.addRow(new Object[] { stt,l.getIdLuongCN(),l.getNgayTinhLuong(), phanXuong, cn.getIdCongNhan(), cn.getHoTen(),values[1]+"h",values[0], luongHanhChanh, luongTangCa,
						phuCap, thucLanh});
				stt++;
				tongThoiGianLamViec+=values[1];
				tongSoLuongSanPham+=values[0];
				tongLuongHanhChanh+=l.getTongLuong();
				tongLuongTangCa+=l.getThucLanh()-l.getTongLuong()-cn.getPhuCap();
				tongPhuCap+=cn.getPhuCap();
				tongThucLanh+=l.getThucLanh();
			}
		}else {
			tongSoLuong = dslcn.size();
			for (LuongCongNhan luongCongNhan : dslcn) {
				DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
				CongNhan cn = cn_bus.getCongNhanTheoID(luongCongNhan.getCongNhan().getIdCongNhan());
				String luongHanhChanh = decimalFormat.format(luongCongNhan.getTongLuong()) + " VND";
				String thucLanh = decimalFormat.format(luongCongNhan.getThucLanh()) + " VND";
				String phuCap = decimalFormat.format(cn.getPhuCap()) + " VND";
				int[] values = bl_bus.TinhTongSanLuongVaThoiGianLamViec( luongCongNhan.getCongNhan().getIdCongNhan(), thang, nam);
				double tangCa = luongCongNhan.getThucLanh()-luongCongNhan.getTongLuong()-cn.getPhuCap();
				String luongTangCa = decimalFormat.format(tangCa) + " VND";
				dftable.addRow(new Object[] { stt,luongCongNhan.getIdLuongCN(),luongCongNhan.getNgayTinhLuong(), phanXuong, luongCongNhan.getCongNhan().getIdCongNhan(), cn.getHoTen(),values[1]+"h",values[0], luongHanhChanh, luongTangCa,
						phuCap, thucLanh});
				stt++;
				tongThoiGianLamViec+=values[1];
				tongSoLuongSanPham+=values[0];
				tongLuongHanhChanh+=luongCongNhan.getTongLuong();
				tongLuongTangCa+=luongCongNhan.getThucLanh()-luongCongNhan.getTongLuong()-cn.getPhuCap();
				tongPhuCap+=cn.getPhuCap();
				tongThucLanh+=luongCongNhan.getThucLanh();
			}
		}
		docDuLieuVaoThongTinChung(tongSoLuong, tongThoiGianLamViec, tongSoLuongSanPham, tongLuongHanhChanh, tongLuongTangCa, tongPhuCap, tongThucLanh);
	}

	public String getIdBangLuong(String id) {
		boolean check =  bl_bus.kiemTraTonTaiLuongCongNhan(id);
		String a = "LCN0001";
		int stt=1;
		while(check) {
			stt++;
			 String formattedCounter = String.format("%04d", stt);
			  a = "LCN"+ formattedCounter;
			  check =  bl_bus.kiemTraTonTaiLuongCongNhan(a);
		}
		return a;
	}
	public void docDuLieuVaoThongTinChung(int tongSoLuong,double tongThoiGianLamViec, double tongSoLuongSanPham, double tongLuongHanhChanh, double tongLuongTangCa,
			double tongPhuCap, double tongThucLanh) {
		if (tongSoLuong == 0) {
			lbl_sp.setText("");
			lbl_time.setText("");
			lbl_lsp.setText("");
			lbl_ltc.setText("");
			lbl_pc.setText("");
			lbl_thucLanh.setText("");
			lbl_slcn.setText("");
		} else {
			DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
			lbl_sp.setText(tongSoLuongSanPham+"");
			lbl_time.setText(tongThoiGianLamViec + "H");
			lbl_ltc.setText(decimalFormat.format(tongLuongTangCa) + " VND");
			lbl_lsp.setText(decimalFormat.format(tongLuongHanhChanh) + " VND");
			lbl_pc.setText(decimalFormat.format(tongPhuCap) + " VND");
			lbl_thucLanh.setText(decimalFormat.format(tongThucLanh) + " VND");
			lbl_slcn.setText(tongSoLuong + "");
		}

	}

	public void docDuLieuPhanXuong() {
		ArrayList<PhanXuong> dspb = new ArrayList<>();
		dspb = px_bus.getDanhSachPhanXuong();
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
		for (PhanXuong px : dspb) {
			comboBoxModel.addElement(px.getTenPhanXuong());
		}
		cbbPhongBan.setModel(comboBoxModel);
	}

	public static void main(String[] args) {
		new TinhLuongCongNhan_Form(WIDTH, HEIGHT).setVisible(true);
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
			String phanXuong = (String) cbbPhongBan.getSelectedItem();
			ArrayList<LuongCongNhan> dslcn = new ArrayList<>();
			int tongSoLuong=0;
			dslcn = bl_bus.getAllTableTinhLuongTheoThang(phanXuong, thang, nam);
			double tongThoiGianLamViec = 0, tongSoLuongSanPham = 0, tongLuongHanhChanh = 0, tongLuongTangCa = 0, tongPhuCap = 0, tongThucLanh = 0;
			int stt=1;
			tongSoLuong = dslcn.size();
			String txtSearch = searchField.getText();
			boolean checkNV=false;
			for (LuongCongNhan lcn: dslcn) {
				CongNhan cn = cn_bus.getCongNhanTheoID(lcn.getCongNhan().getIdCongNhan());
				if (lcn.getIdLuongCN().contains(txtSearch) || cn.getIdCongNhan().contains(txtSearch)|| cn.getHoTen().contains(txtSearch) ) {
					checkNV = true;
					DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
					String luongHanhChanh = decimalFormat.format(lcn.getTongLuong()) + " VND";
					String thucLanh = decimalFormat.format(lcn.getThucLanh()) + " VND";
					String phuCap = decimalFormat.format(cn.getPhuCap()) + " VND";
					int[] values = bl_bus.TinhTongSanLuongVaThoiGianLamViec( lcn.getCongNhan().getIdCongNhan(), thang, nam);
					double tangCa = lcn.getThucLanh()-lcn.getTongLuong()-cn.getPhuCap();
					String luongTangCa = decimalFormat.format(tangCa) + " VND";
					dftable.addRow(new Object[] { stt,lcn.getIdLuongCN(),lcn.getNgayTinhLuong(), phanXuong, lcn.getCongNhan().getIdCongNhan(), cn.getHoTen(),values[1]+"h",values[0], luongHanhChanh, luongTangCa,
							phuCap, thucLanh});
					stt++;
					tongThoiGianLamViec+=values[1];
					tongSoLuongSanPham+=values[0];
					tongLuongHanhChanh+=lcn.getTongLuong();
					tongLuongTangCa+=lcn.getThucLanh()-lcn.getTongLuong()-cn.getPhuCap();
					tongPhuCap+=cn.getPhuCap();
					tongThucLanh+=lcn.getThucLanh();
				}
			}
			if (!checkNV) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
				tongSoLuong=0;
			}
			docDuLieuVaoThongTinChung(tongSoLuong, tongThoiGianLamViec, tongSoLuongSanPham, tongLuongHanhChanh, tongLuongTangCa, tongPhuCap, tongThucLanh);
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
			JDialog dialog = new JDialog();
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(1250, 906));
			panel.setLayout(null);
			dialog.getContentPane().add(panel);
			panel.setBounds(73, 43, 700, 500);
			dialog.getContentPane().add(panel);
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
			JLabel lblNewLabel = new JLabel("Chi Tiết Bảng Lương Công Nhân Tháng 10 - 2023");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel_2.add(lblNewLabel);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 62, 660, 175);
			panel.add(scrollPane);
			
			CongNhan cn = cn_bus.getCongNhanTheoID((String) tableLuong.getValueAt(r, 4) );
			TaiKhoanNganHang tk = tknh_bus.getTaiKhoanNganHangTheoIDCongNhan((String) tableLuong.getValueAt(r, 4));
			table_chiTiet1 = new JTable();
			table_chiTiet1.setModel(
					new DefaultTableModel(new Object[][] { 
						{ "ID Lương", (String) tableLuong.getValueAt(r, 1)},
						{ "Mã Công Nhân", (String) tableLuong.getValueAt(r, 4) },
						{ "Tên Công Nhân", (String) tableLuong.getValueAt(r,5) },
						{ "Số Tài Khoản", tk.getSoTaiKhoan() },
						{ "Phân Xưởng", (String) tableLuong.getValueAt(r, 3) },
						{ "Trình Độ", cn.getTayNghe()},
						{"Giờ Công",(String) tableLuong.getValueAt(r, 6)},
						{ "Tổng Lương", (String) tableLuong.getValueAt(r, 11)}, }, 
					new String[] { "New column", "New column" }));
			scrollPane.setColumnHeaderView(table_chiTiet1);
			int cellHeight = 25;
			table_chiTiet1.setRowHeight(cellHeight);
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(15, 268, 660, 150);
			panel.add(scrollPane_1);
			table_chiTiet2 = new JTable();
			table_chiTiet2.setRowHeight(cellHeight);
			ArrayList<String[]> listChiTiet = bl_bus.getChiTietLuong((String) tableLuong.getValueAt(r, 4), thang, nam);
			DefaultTableModel dfChiTiet2;
			table_chiTiet2.setModel(dfChiTiet2 =  new DefaultTableModel(new Object[][] {} ,
					new String[] { "ID Sản Phẩm","Tên Sản Phẩm","Tên Công Đoạn","Thời Gian Làm Việc","Số Lượng Hoàn Thành","Tổng Tiền" }));
			table_chiTiet2.getColumnModel().getColumn(0).setPreferredWidth(100);
			table_chiTiet2.getColumnModel().getColumn(0).setMinWidth(100);
			table_chiTiet2.getColumnModel().getColumn(1).setMinWidth(100);
			table_chiTiet2.getColumnModel().getColumn(2).setMinWidth(100);
			table_chiTiet2.getColumnModel().getColumn(3).setMinWidth(100);
			DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
			for (String[] strings : listChiTiet) {
				dfChiTiet2.addRow(new Object[] {
						strings[0],strings[1],strings[2],strings[3]+"h",strings[4],decimalFormat.format(Double.parseDouble(strings[5]))+" VND"
				});
			}
			// Tạo một đối tượng DefaultTableCellRenderer
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

	        // Thiết lập đối tượng renderer cho tất cả các cột
	        for (int i = 0; i < table_chiTiet2.getColumnCount(); i++) {
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
