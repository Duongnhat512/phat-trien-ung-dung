package form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import bus.BangLuongCongNhan_BUS;
import bus.ChamCongCongNhan_BUS;
import bus.CongNhan_BUS;
import bus.PhanXuong_BUS;
import bus.TaiKhoanNganHang_BUS;
import bus.TaiKhoan_BUS;
import commons.MyButton;
import commons.RoundPanel;
import commons.RoundTextField;
import commons.Table;
import connectDB.ConnectDB;
import entities.CongNhan;
import entities.LuongCongNhan;
import entities.PhanXuong;
import entities.TaiKhoanNganHang;

import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.RowFilter.Entry;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Cursor;

public class TinhLuongCongNhan_Form extends JPanel implements ActionListener, MouseListener {
	private int width = 1250;
	private int height = 725;
	private BangLuongCongNhan_BUS bl_bus;
	private ChamCongCongNhan_BUS cccn_bus;
	private PhanXuong_BUS px_bus;
	private CongNhan_BUS cn_bus;
	private TaiKhoanNganHang_BUS tknh_bus;

	private Table tableLuong;

	private DefaultTableModel dftable;
	private JComboBox cbbNam;
	private JComboBox cbbThang;
	private JComboBox cbbPhongBan;
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
	private RoundPanel panel_southTitle;
	private JTable table_chiTiet1;
	private JTable table_chiTiet2;
	private JLabel lbldsCC;
	private boolean allowFilter = true;
	private MyButton btnRefesh;
	private MyButton btnPrint;
	private MyButton btnEmail;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

	public TinhLuongCongNhan_Form(int width, int height) {
		setBackground(new Color(240, 240, 240));
		bl_bus = new BangLuongCongNhan_BUS();
		cccn_bus = new ChamCongCongNhan_BUS();
		px_bus = new PhanXuong_BUS();
		cn_bus = new CongNhan_BUS();
		tknh_bus = new TaiKhoanNganHang_BUS();
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
		cbbNam.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbbNam.setBorder(null);
		cbbNam.setBackground(new Color(255, 255, 255));
		cbbNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNam.setBounds(23, 23, 142, 30);
		cbbNam.setSelectedItem("Năm " + String.valueOf(currentYear));
		add(cbbNam);

		String[] months = { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8",
				"Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" };
		cbbThang = new JComboBox(months);
		cbbThang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbbThang.setBorder(null);
		cbbThang.setBackground(new Color(255, 255, 255));
		cbbThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThang.setBounds(206, 23, 142, 30);
		cbbThang.setSelectedIndex(currentMonth - 1);
		add(cbbThang);

		cbbPhongBan = new JComboBox();
		cbbPhongBan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbbPhongBan.setBorder(null);
		cbbPhongBan.setBackground(new Color(255, 255, 255));
		cbbPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbPhongBan.setBounds(391, 23, 142, 30);
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
				new String[] { "STT", "Ngày Tính Lương", "Phân Xưởng", "ID Công Nhân", "Tên Công Nhân",
						"Tổng Thời Gian Làm Việc", "Tổng Sản Lượng Hoàn Thành", "Lương Hành Chánh", "Lương Tăng Ca",
						"Phụ Cấp", "Thực Lãnh" }));
		tableLuong.getColumnModel().getColumn(0).setPreferredWidth(20);
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

		lbldsCC = new JLabel("Danh sách lương tháng " + (currentMonth + 1) + " - " + currentYear);
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
		lbl_7.setBounds(816, 110, 155, 25);
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
		lbl_thucLanh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_thucLanh.setBounds(985, 113, 199, 19);
		panel_1.add(lbl_thucLanh);

		btnPrint = new MyButton();
		btnPrint.setFocusPainted(false);
		btnPrint.setBackground(new Color(255, 255, 255));
		btnPrint.setText("Xuất Excel");
		btnPrint.setRadius(20);
		btnPrint.setIcon(new ImageIcon(TinhLuongCongNhan_Form.class.getResource("/icon/excel.png")));
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrint.setBounds(815, 23, 158, 30);
		add(btnPrint);

		btnEmail = new MyButton();
		btnEmail.setFocusPainted(false);
		btnEmail.setBackground(new Color(255, 255, 255));
		btnEmail.setText("Gửi Email Hàng Loạt");
		btnEmail.setRadius(20);
		btnEmail.setIcon(new ImageIcon(TinhLuongCongNhan_Form.class.getResource("/icon/mail.png")));
		btnEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEmail.setBounds(1021, 23, 211, 30);
		add(btnEmail);
		//
		searchField = new RoundTextField(10);
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchField.setText("Nhập mã/tên công nhân cần tìm");
		searchField.setBounds(23, 270, 298, 30);
		add(searchField);
		searchField.setColumns(10);
		searchField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (searchField.getText().isEmpty()) {
					searchField.setText("Nhập mã/tên công nhân cần tìm");
					searchField.setForeground(Color.GRAY);
				}
				super.focusLost(e);
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (searchField.getText().equalsIgnoreCase("Nhập mã/tên công nhân cần tìm")) {
					searchField.setText("");
					searchField.setForeground(Color.BLACK);
				}
				super.focusGained(e);
			}
		});
		btnRefesh = new MyButton();
		btnRefesh.setFocusPainted(false);
		btnRefesh.setBackground(new Color(255, 255, 255));
		btnRefesh.setText("Làm Mới");

		btnRefesh.setRadius(20);
		btnRefesh.setIcon(new ImageIcon(TinhLuongCongNhan_Form.class.getResource("/icon/refresh.png")));
		btnRefesh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefesh.setBounds(622, 23, 158, 30);
		add(btnRefesh);

		docDuLieuPhanXuong();
		filterTable();
		btnPrint.addActionListener(this);
		btnEmail.addActionListener(this);
		tableLuong.addMouseListener(this);
		btnPrint.addMouseListener(this);
		cbbThang.addActionListener(this);
		cbbNam.addActionListener(this);
		cbbPhongBan.addActionListener(this);
		btnRefesh.addActionListener(this);

		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchTable();
			}
		});
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
		int tongSoLuong = 0;
		dslcn = bl_bus.getAllTableTinhLuongTheoThang(phanXuong, thang, nam);
		double tongThoiGianLamViec = 0, tongSoLuongSanPham = 0, tongLuongHanhChanh = 0, tongLuongTangCa = 0,
				tongPhuCap = 0, tongThucLanh = 0;
		lbldsCC.setText("Danh sách lương tháng " + thang + " - " + nam);
		if (dslcn.isEmpty()) {
			dscn = cccn_bus.getDSChamCongCongNhan(thang, nam, phanXuong);
			if (dscn.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu để tính lương");
				;
			}
			tongSoLuong = dscn.size();
			for (CongNhan cn : dscn) {
				LuongCongNhan l = bl_bus.getLuongCongNhan(cn.getIdCongNhan(), thang, nam);
				double[] values = bl_bus.TinhTongSanLuongVaThoiGianLamViec(cn.getIdCongNhan(), thang, nam);
				PhanXuong p = px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong());
				String idBangLuong = getIdBangLuong(l.getIdLuongCN());
				l.setIdLuongCN(idBangLuong);
				bl_bus.themBangLuongCongNhan(l, thang, nam);
				if (LocalDate.now().getMonthValue() == thang + 1 && LocalDate.now().getDayOfMonth() == 5) {
				}
				DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
				if (l.getThucLanh() < 0) {
					String thuclanh = decimalFormat.format(0) + " VND";
				}
				double hanhChanh = values[2];
				String luongHanhChanh = decimalFormat.format(hanhChanh) + " VND";
				String thucLanh = decimalFormat.format(l.getThucLanh()) + " VND";
				String phuCap = decimalFormat.format(cn.getPhuCap()) + " VND";

				double tangCa = values[3];
				String luongTangCa = decimalFormat.format(tangCa) + " VND";
				dftable.addRow(
						new Object[] { stt, l.getNgayTinhLuong().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
								p.getTenPhanXuong(), cn.getIdCongNhan(), cn.getHoTen(), values[1] + "h", values[0],
								luongHanhChanh, luongTangCa, phuCap, thucLanh });
				stt++;
				tongThoiGianLamViec += values[1];
				tongSoLuongSanPham += values[0];
				tongLuongHanhChanh += hanhChanh;
				tongLuongTangCa += tangCa;
				tongPhuCap += cn.getPhuCap();
				tongThucLanh += hanhChanh;
			}
		} else {
			tongSoLuong = dslcn.size();
			for (LuongCongNhan luongCongNhan : dslcn) {
				DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
				if (luongCongNhan.getThucLanh() < 0) {
					String thuclanh = decimalFormat.format(0) + " VND";
				}
				CongNhan cn = cn_bus.getCongNhanTheoID(luongCongNhan.getCongNhan().getIdCongNhan());
				PhanXuong p = px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong());
				String thucLanh = decimalFormat.format(luongCongNhan.getThucLanh()) + " VND";
				String phuCap = decimalFormat.format(cn.getPhuCap()) + " VND";
				double[] values = bl_bus.TinhTongSanLuongVaThoiGianLamViec(luongCongNhan.getCongNhan().getIdCongNhan(),
						thang, nam);
				double tangCa = values[3];
				double hanhChanh = values[2];
				String luongHanhChanh = decimalFormat.format(hanhChanh) + " VND";
				String luongTangCa = decimalFormat.format(tangCa) + " VND";
				dftable.addRow(new Object[] { stt,
						luongCongNhan.getNgayTinhLuong().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						p.getTenPhanXuong(), cn.getIdCongNhan(), cn.getHoTen(), values[1] + "h", values[0],
						luongHanhChanh, luongTangCa, phuCap, thucLanh });
				stt++;
				tongThoiGianLamViec += values[1];
				tongSoLuongSanPham += values[0];
				tongLuongHanhChanh += hanhChanh;
				tongLuongTangCa += tangCa;
				tongPhuCap += cn.getPhuCap();
				tongThucLanh += luongCongNhan.getThucLanh();
			}
		}
		docDuLieuVaoThongTinChung(tongSoLuong, tongThoiGianLamViec, tongSoLuongSanPham, tongLuongHanhChanh,
				tongLuongTangCa, tongPhuCap, tongThucLanh);
	}

	public String getIdBangLuong(String id) {
		boolean check = bl_bus.kiemTraTonTaiLuongCongNhan(id);
		String a = "LCN0001";
		int stt = 1;
		while (check) {
			stt++;
			String formattedCounter = String.format("%04d", stt);
			a = "LCN" + formattedCounter;
			check = bl_bus.kiemTraTonTaiLuongCongNhan(a);
		}
		return a;
	}

	public void docDuLieuVaoThongTinChung(int tongSoLuong, double tongThoiGianLamViec, double tongSoLuongSanPham,
			double tongLuongHanhChanh, double tongLuongTangCa, double tongPhuCap, double tongThucLanh) {
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
			lbl_sp.setText(tongSoLuongSanPham + "");
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
		comboBoxModel.addElement("Tất cả");
		for (PhanXuong px : dspb) {
			comboBoxModel.addElement(px.getTenPhanXuong());
		}
		cbbPhongBan.setModel(comboBoxModel);
	}

	public static void main(String[] args) {
		new TinhLuongCongNhan_Form(WIDTH, HEIGHT).setVisible(true);
	}

	private boolean exportToExcelAndCreateUI(JTable table, String filePath) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sheet1");
		// Thêm dòng tiêu đề từ JTable vào tệp Excel
		Vector<String> header = new Vector<>();
		for (int i = 0; i < table.getColumnCount(); i++) {
			header.add(table.getColumnName(i));
		}
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < header.size(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(header.get(i));
		}

		// Thêm dữ liệu từ JTable vào tệp Excel
		for (int i = 0; i < table.getRowCount(); i++) {
			Row row = sheet.createRow(i + 1);
			for (int j = 0; j < table.getColumnCount(); j++) {
				Object value = table.getValueAt(i, j);
				Cell cell = row.createCell(j);
				if (value != null) {
					cell.setCellValue(value.toString());
				}
			}
		}

		try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
			workbook.write(outputStream);
			workbook.close();
			int option = JOptionPane.showConfirmDialog(null, "Xuất Excel thành công . Bạn có muốn mở file không",
					"Xác nhận", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Hàm mở tệp Excel
	private void openExcelFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			try {
				Desktop.getDesktop().open(file); // Mở tệp Excel bằng ứng dụng mặc định
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File not found: " + filePath);
		}
	}

	public boolean exportPdf(int r, int thang, int nam) {
		// Tạo một Document iText
		String projectDirectory = System.getProperty("user.dir");
		String filePath = projectDirectory + "\\file\\file.pdf";
		String ttfPath = projectDirectory + "\\file\\ARIAL.TTF";
		File file = new File(filePath);
		CongNhan cn = cn_bus.getCongNhanTheoID((String) tableLuong.getValueAt(r, 3));
		TaiKhoanNganHang tk = tknh_bus.getTaiKhoanNganHangTheoIDCongNhan((String) tableLuong.getValueAt(r, 3));
		ArrayList<String[]> listChiTiet = bl_bus.getChiTietLuong((String) tableLuong.getValueAt(r, 3), 10, 2023);
		DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
		Document document = new Document();
		try {

			Object[][] data1 = { { "Mã Công Nhân", (String) tableLuong.getValueAt(r, 3) },
					{ "Tên Công Nhân", (String) tableLuong.getValueAt(r, 4) }, { "Số Tài Khoản", tk.getSoTaiKhoan() },
					{ "Phân Xưởng", (String) tableLuong.getValueAt(r, 2) }, { "Trình Độ", cn.getTayNghe() },
					{ "Giờ Công", (String) tableLuong.getValueAt(r, 5) },
					{ "Ngày Nhận Lương", (String) tableLuong.getValueAt(r, 1) },
					{ "Thực Lãnh", (String) tableLuong.getValueAt(r, 10) }, };

			Object[][] data2 = new Object[listChiTiet.size() + 1][6]; // Khởi tạo mảng với số hàng cần thiết
			data2[0] = new Object[] { "ID Sản Phẩm", "Tên Sản Phẩm", "Tên Công Đoạn", "Thời Gian Làm Việc",
					"Số Lượng Hoàn Thành", "Tổng Tiền" };

			for (int i = 0; i < listChiTiet.size(); i++) {
				String[] strings = listChiTiet.get(i);
				data2[i + 1] = new Object[] { strings[0], strings[1], strings[2], strings[3] + "h", strings[4],
						decimalFormat.format(Double.parseDouble(strings[5])) + " VND" };
			}
			// Khởi tạo đối tượng PdfWriter để ghi vào file PDF
			PdfWriter.getInstance(document, new FileOutputStream(file));
			// Mở Document để bắt đầu ghi dữ liệu
			document.open();
			// Tiêu đề
			com.itextpdf.text.Font customFont = new com.itextpdf.text.Font();
			com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font();
			try {
				BaseFont baseFont = BaseFont.createFont(ttfPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
				customFont = new com.itextpdf.text.Font(baseFont, 12);
				titleFont = new com.itextpdf.text.Font(baseFont, 18, Font.BOLD);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Paragraph title = new Paragraph("Bảng Lương Công Nhân " + cbbThang.getSelectedItem() + " "
					+ cbbNam.getSelectedItem() + "" + "" + "" + "" + "" + "" + "" + "", titleFont);
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			// Bảng 1
			PdfPTable table1 = new PdfPTable((data1[0].length)); // Số cột trong bảng
			// Thêm dữ liệu từ mảng vào bảng PDF
			for (Object[] row : data1) {
				for (Object cellData : row) {
					PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(cellData), customFont));
					table1.addCell(cell);
				}
			}
			table1.setSpacingBefore(50); // Khoảng cách trước bảng 2
			table1.setSpacingAfter(20); // Khoảng cách sau bảng 1
			document.add(table1);

			// Bảng 2
			PdfPTable table2 = new PdfPTable((data2[0].length)); // Số cột trong bảng
			// Thêm dữ liệu vào bảng 2 từ table_chiTiet2 (ví dụ)
			for (Object[] row : data2) {
				for (Object cellData : row) {
					PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(cellData), customFont));
					table2.addCell(cell);
				}
			}

			table2.setSpacingBefore(20); // Khoảng cách trước bảng 2
			document.add(table2);
			// Đóng Document sau khi hoàn thành
			document.close();
			return true;
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void searchTable() {
		String searchText = searchField.getText().trim();
		if (searchText.isEmpty() || searchText.equals("Nhập mã/tên công nhân cần tìm")) {
			filterTable();
			return;
		}
		TableRowSorter sorter = new TableRowSorter<>(dftable);
		tableLuong.setRowSorter(sorter);

		RowFilter<DefaultTableModel, Object> idOrNameFilter = new RowFilter<DefaultTableModel, Object>() {
			@Override
			public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
				String text = searchText.toLowerCase();
				Object col3Value = entry.getValue(3); 
				Object col4Value = entry.getValue(4); 

				if ((col3Value != null && col3Value.toString().toLowerCase().contains(text))
						|| (col4Value != null && col4Value.toString().toLowerCase().contains(text))) {
					return true;
				}
				return false;
			}
		};
		sorter.setRowFilter(idOrNameFilter);
	}

	public void filterTable() {
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

	public void lamMoi() {
		searchField.setText("Nhập mã/tên công nhân cần tìm");
		Calendar calendar = Calendar.getInstance();
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);
		cbbNam.setSelectedItem("Năm " + String.valueOf(currentYear));
		cbbThang.setSelectedIndex(currentMonth - 1);
		cbbPhongBan.setSelectedItem("Tất cả");
		lbldsCC.setText("Danh sách lương tháng " + (currentMonth + 1) + " - " + currentYear);
		filterTable();
		TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tableLuong.getRowSorter();
		if (sorter != null) {
			sorter.setRowFilter(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(cbbThang) || obj.equals(cbbNam) || obj.equals(cbbPhongBan)) {
			if (allowFilter) {
				filterTable();
			}
		}
		if (obj.equals(btnPrint)) {
			String projectDirectory = System.getProperty("user.dir");
			String filePath = projectDirectory + "\\file\\file.xlsx";
			if (dftable.getRowCount() > 0) {
				if (exportToExcelAndCreateUI(tableLuong, filePath)) {
					openExcelFile(filePath); // Mở tệp Excel nếu xuất thành công
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu để xuất file");
			}

		}
		if (obj.equals(btnRefesh)) {
			allowFilter = false; // Ngăn chặn sự kiện filterTable
			lamMoi(); // Gọi hàm làm mới các combobox ở đây
			allowFilter = true;
		}
		if (obj.equals(btnEmail)) {
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
			// Thông tin tài khoản email
			final String username = "ngoquocdat0810@gmail.com"; // Thay bằng địa chỉ email của bạn
			final String password = "ozkc hoyu xosh kkxf"; // Thay bằng mật khẩu của bạn

			// Cấu hình thông tin máy chủ email
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com"); // Thay bằng SMTP host của bạn (ví dụ: smtp.gmail.com cho
															// Gmail)
			props.put("mail.smtp.port", "587"); // Port thường là 587 cho TLS

			// Tạo phiên làm việc (session) để gửi email
			Authenticator auth = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			};
			Session session = Session.getInstance(props, auth);

			try {
				int rowCount = dftable.getRowCount();
				if (rowCount < 1) {
					JOptionPane.showMessageDialog(null, "Không có giá trị để gửi");
					return;
				}
				for (int row = 0; row < rowCount; row++) {
					Object cellValue = dftable.getValueAt(row, 3);
					exportPdf(row, thang, nam);
					// Xử lý giá trị trong ô tại hàng 'row' và cột 'col'
					System.out.println("Giá trị tại hàng " + row + ", cột " + 4 + ": " + cellValue);
					// Thực hiện xử lý khác ở đây...
					CongNhan n = cn_bus.getCongNhanTheoID(cellValue + "");

					// Tạo thông điệp email
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(username));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(n.getEmail()));
					message.setSubject("Bảng lương  " + cbbThang.getSelectedItem() + " " + cbbNam.getSelectedItem());

					MimeBodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setText("Chủ đề: Thông tin Bảng lương - Thanh toán tháng " + thang + "/" + nam
							+ "\r\n" + "\r\n" + "Kính gửi " + n.getHoTen() + ",\r\n" + "\r\n"
							+ "Xin chào! Dưới đây là thông tin chi tiết về Bảng lương của bạn cho thanh toán tháng "
							+ thang + "/" + nam + ":\r\n" + "\r\n"
							+ "Mời bạn tải xuống và xem thông tin chi tiết trong file PDF đính kèm. Nếu bạn có bất kỳ câu hỏi nào hoặc cần hỗ trợ, vui lòng liên hệ với Bộ phận Tài chính qua email nguyennhatduong@gmail.com hoặc số điện thoại 0912345678.\r\n"
							+ "\r\n"
							+ "Xin cảm ơn bạn đã đóng góp và làm việc chăm chỉ. Hãy liên hệ nếu có bất kỳ thắc mắc nào.\r\n"
							+ "\r\n" + "Trân trọng,\r\n" + "Nguyễn Nhất Dương\r\n" + "Bộ phận Tài chính");
					MimeBodyPart attachmentPart = new MimeBodyPart();
					String projectDirectory = System.getProperty("user.dir");
					String filePath = projectDirectory + "\\file\\file.pdf";
					attachmentPart.attachFile(new File(filePath));
					// Gửi email
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					multipart.addBodyPart(attachmentPart);
					message.setContent(multipart, "text/plain; charset=UTF-8");
					Transport.send(message);
				}
				JOptionPane.showMessageDialog(null, "Đã gửi email thành công");

//	            
			} catch (MessagingException b) {
				b.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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

			panel.add(pSouthh, BorderLayout.NORTH);
			JLabel lblNewLabel = new JLabel("Danh sách lương tháng " + thang + " - " + nam);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			panel_2.add(lblNewLabel);

			CongNhan cn = cn_bus.getCongNhanTheoID((String) tableLuong.getValueAt(r, 3));
			TaiKhoanNganHang tk = tknh_bus.getTaiKhoanNganHangTheoIDCongNhan(cn.getIdCongNhan());

			table_chiTiet1 = new JTable();
			table_chiTiet1.setModel(new DefaultTableModel(
					new Object[][] { { "Mã Công Nhân", (String) tableLuong.getValueAt(r, 3) },
							{ "Tên Công Nhân", (String) tableLuong.getValueAt(r, 4) },
							{ "Số Tài Khoản", tk.getSoTaiKhoan() },
							{ "Phân Xưởng", (String) tableLuong.getValueAt(r, 2) }, { "Trình Độ", cn.getTayNghe() },
							{ "Giờ Công", (String) tableLuong.getValueAt(r, 5) },
							{ "Ngày Nhận Lương", (String) tableLuong.getValueAt(r, 1) },
							{ "Thực Lãnh", (String) tableLuong.getValueAt(r, 10) }, },
					new String[] { "New column", "New column" }));
			JScrollPane scrollPane = new JScrollPane(table_chiTiet1);
			scrollPane.setColumnHeaderView(table_chiTiet1);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(15, 62, 660, 200);
			panel.add(scrollPane);
			int cellHeight = 25;
			table_chiTiet1.setRowHeight(cellHeight);

			table_chiTiet2 = new JTable();
			table_chiTiet2.setRowHeight(cellHeight);
			ArrayList<String[]> listChiTiet = bl_bus.getChiTietLuong((String) tableLuong.getValueAt(r, 3), thang, nam);
			DefaultTableModel dfChiTiet2;
			table_chiTiet2.setModel(dfChiTiet2 = new DefaultTableModel(new Object[][] {}, new String[] { "ID Sản Phẩm",
					"Tên Sản Phẩm", "Tên Công Đoạn", "Thời Gian Làm Việc", "Số Lượng Hoàn Thành", "Tổng Tiền" }));
			table_chiTiet2.getColumnModel().getColumn(0).setPreferredWidth(100);
			table_chiTiet2.getColumnModel().getColumn(0).setMinWidth(100);
			table_chiTiet2.getColumnModel().getColumn(1).setMinWidth(100);
			table_chiTiet2.getColumnModel().getColumn(2).setMinWidth(100);
			table_chiTiet2.getColumnModel().getColumn(3).setMinWidth(100);
			DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
			for (String[] strings : listChiTiet) {
				dfChiTiet2.addRow(new Object[] { strings[0], strings[1], strings[2], strings[3] + "h", strings[4],
						decimalFormat.format(Double.parseDouble(strings[5])) + " VND" });
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
			JScrollPane scrollPane_1 = new JScrollPane(table_chiTiet2);
			scrollPane_1.setBounds(15, 293, 660, 150);
			scrollPane_1.setViewportView(table_chiTiet2);
			scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			panel.add(scrollPane_1);
			JButton btnjd = new JButton("In PDF");
			btnjd.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
					.createImage(TinhLuongNhanVien_Form.class.getResource("/icon/printer.png"))
					.getScaledInstance(25, 20, Image.SCALE_SMOOTH)));
			btnjd.setBounds(15, 452, 120, 28);
			panel.add(btnjd);
			dialog.setSize(700, 525);
			dialog.setLocationRelativeTo(null); // Hiển thị JDialog ở trung tâm JFrame
			dialog.setVisible(true);

			btnjd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int thang = Integer.parseInt(((String) cbbThang.getSelectedItem()).replaceAll("\\D", ""));
					int nam = Integer.parseInt(((String) cbbNam.getSelectedItem()).replaceAll("\\D", ""));
					boolean check = exportPdf(r, thang, nam);
					if (check) {
						int option = JOptionPane.showConfirmDialog(null,
								"Xuất PDF thành công . Bạn có muốn mở file không", "Xác nhận",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							// Kiểm tra xem Desktop được hỗ trợ không trước khi mở file
							if (Desktop.isDesktopSupported()) {
								Desktop desktop = Desktop.getDesktop();
								String projectDirectory = System.getProperty("user.dir");
								String ttfPath = projectDirectory + "\\file\\file.pdf";
								File file = new File(ttfPath);
								if (file.exists()) {
									try {
										desktop.open(file);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} // Mở file PDF
								} else {
									System.out.println("File không tồn tại!");
								}
							} else {
								System.out.println("Desktop không được hỗ trợ!");
							}
						} else {

						}

					}

				}
			});
		}
	}
}
