package form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Scrollbar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import bus.BangLuongNhanVien_BUS;
import bus.ChamCongNhanVien_BUS;
import connectDB.ConnectDB;
import entities.LuongNhanVien;
import entities.NhanVien;
import entities.PhongBan;

import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class TinhLuongNhanVien_Form extends JPanel implements ActionListener {
	private int width = 1250;
	private int height = 725;
	private JTextField txtTenNV;
	private JTextField txtIdLuong;
	private JTextField txtPhanXuong;
	private JTextField txtTen;
	private JTextField txtTongLuong;
	private JTextField txtThucLanh;
	private JTable tableLuong;
	private JLabel lblThue;
	private BangLuongNhanVien_BUS bl_bus;
	private ChamCongNhanVien_BUS ccnv_bus;
	private DefaultTableModel dftable;
	private JButton btnTinhLuong;
	private JButton btnExcel;
	private JButton btnEmail;
	private JComboBox cbbNam;
	private JComboBox cbbThang;
	private JComboBox cbbPhongBan;

	public TinhLuongNhanVien_Form(int width, int height) {
		bl_bus = new BangLuongNhanVien_BUS();
		ccnv_bus = new ChamCongNhanVien_BUS();
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

		setPreferredSize(new Dimension(this.width, this.height));
		setLayout(null);
		Calendar calendar = Calendar.getInstance();
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);
		int startYear = 2010; // Năm bắt đầu
		int endYear = 2025; // Năm kết thúc
		String[] years = new String[endYear - startYear + 1];
		for (int i = startYear; i <= endYear; i++) {
			years[i - startYear] = String.valueOf(i);
		}
		cbbNam = new JComboBox(years);
		cbbNam.setBounds(23, 23, 142, 30);
		cbbNam.setSelectedItem(String.valueOf(currentYear));
		add(cbbNam);

		String[] months = { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8",
				"Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" };
		cbbThang = new JComboBox(months);
		cbbThang.setBounds(206, 23, 142, 30);
		cbbThang.setSelectedIndex(currentMonth);
		add(cbbThang);

		cbbPhongBan = new JComboBox();
		cbbPhongBan.setBounds(383, 23, 142, 30);
		add(cbbPhongBan);

		JComboBox cbbTenNV = new JComboBox();
		cbbTenNV.setBounds(576, 23, 142, 30);
		add(cbbTenNV);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 63, 1214, 378);
		add(scrollPane);

		tableLuong = new JTable();
		tableLuong.setModel(dftable = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "N\u0103m", "Th\u00E1ng", "Ph\u00F2ng Ban", "ID Nh\u00E2n Vi\u00EAn", "H\u1ECD T\u00EAn", "L\u01B0\u01A1ng C\u01A1 B\u1EA3n", "H\u1EC7 S\u1ED1 L\u01B0\u01A1ng", "Ph\u1EE5 C\u1EA5p", "T\u1ED5ng L\u01B0\u01A1ng Th\u1EF1c T\u1EBF", "BHXH", "Thu\u1EBF", "Th\u1EF1c L\u00E3nh"
			}
		));
		tableLuong.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableLuong.getColumnModel().getColumn(1).setPreferredWidth(20);
		tableLuong.getColumnModel().getColumn(2).setPreferredWidth(20);
		tableLuong.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableLuong.getColumnModel().getColumn(4).setPreferredWidth(50);
		tableLuong.getColumnModel().getColumn(5).setPreferredWidth(70);
		tableLuong.getColumnModel().getColumn(7).setPreferredWidth(30);
		tableLuong.getColumnModel().getColumn(9).setPreferredWidth(100);
		tableLuong.getColumnModel().getColumn(12).setPreferredWidth(80);
		tableLuong.setSelectionBackground(new Color(232, 57, 95));
		tableLuong.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		tableLuong.setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableLuong.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableLuong.getTableHeader().setBackground(new Color(32, 136, 203));
		tableLuong.getTableHeader().setForeground(new Color(255, 255, 255));
		tableLuong.setPreferredScrollableViewportSize(new Dimension(400, 500));
		scrollPane.setViewportView(tableLuong);
		DefaultTableCellRenderer centerHeaderRenderer = (DefaultTableCellRenderer) tableLuong.getDefaultRenderer(Object.class);
        centerHeaderRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(23, 452, 1214, 263);
		add(panel);
		panel.setLayout(null);

		JLabel lblThngTinChung = new JLabel("Thông Tin Chung");
		lblThngTinChung.setForeground(new Color(0, 0, 205));
		lblThngTinChung.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngTinChung.setBounds(10, 11, 164, 28);
		panel.add(lblThngTinChung);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(20, 29, 1194, 234);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID Nhân Viên ");
		lblNewLabel.setBounds(10, 11, 83, 25);
		panel_1.add(lblNewLabel);

		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setBounds(10, 47, 83, 25);
		panel_1.add(lblHTn);

		JLabel lblPhngBan = new JLabel("Giới Tính");
		lblPhngBan.setBounds(10, 83, 83, 25);
		panel_1.add(lblPhngBan);

		JLabel lblChcV = new JLabel("Ngày Sinh");
		lblChcV.setBounds(10, 119, 83, 25);
		panel_1.add(lblChcV);

		JLabel lblPhngBan_1 = new JLabel("Phòng Ban");
		lblPhngBan_1.setBounds(10, 155, 83, 25);
		panel_1.add(lblPhngBan_1);

		JLabel lblChcV_1_1 = new JLabel("Chức Vụ");
		lblChcV_1_1.setBounds(10, 191, 83, 25);
		panel_1.add(lblChcV_1_1);

		JLabel lblChcV_1 = new JLabel("Lương Cơ Bản");
		lblChcV_1.setBounds(421, 11, 83, 25);
		panel_1.add(lblChcV_1);

		JLabel lblChcV_1_2 = new JLabel("Hệ Số Lương");
		lblChcV_1_2.setBounds(421, 47, 83, 25);
		panel_1.add(lblChcV_1_2);

		JLabel lblChcV_1_2_1 = new JLabel("Phụ Cấp");
		lblChcV_1_2_1.setBounds(421, 83, 83, 25);
		panel_1.add(lblChcV_1_2_1);

		JLabel lblChcV_1_2_1_1 = new JLabel("BHXH");
		lblChcV_1_2_1_1.setBounds(421, 119, 83, 25);
		panel_1.add(lblChcV_1_2_1_1);

		JLabel lblChcV_1_2_1_1_1 = new JLabel("Thuế");
		lblChcV_1_2_1_1_1.setBounds(421, 155, 83, 25);
		panel_1.add(lblChcV_1_2_1_1_1);

		JLabel lblChcV_1_2_1_1_1_1 = new JLabel("Thực Lãnh");
		lblChcV_1_2_1_1_1_1.setBounds(421, 191, 83, 25);
		panel_1.add(lblChcV_1_2_1_1_1_1);

		JLabel lblIdNV = new JLabel("ID Nhân Viên ");
		lblIdNV.setBounds(129, 11, 83, 25);
		panel_1.add(lblIdNV);

		JLabel lblTen = new JLabel("ID Nhân Viên ");
		lblTen.setBounds(129, 47, 83, 25);
		panel_1.add(lblTen);

		JLabel lblPhai = new JLabel("ID Nhân Viên ");
		lblPhai.setBounds(129, 83, 83, 25);
		panel_1.add(lblPhai);

		JLabel ltlNgaySinh = new JLabel("ID Nhân Viên ");
		ltlNgaySinh.setBounds(129, 119, 83, 25);
		panel_1.add(ltlNgaySinh);

		JLabel ltlPhongBan = new JLabel("ID Nhân Viên ");
		ltlPhongBan.setBounds(129, 155, 83, 25);
		panel_1.add(ltlPhongBan);

		JLabel lblChucVu = new JLabel("ID Nhân Viên ");
		lblChucVu.setBounds(129, 191, 83, 25);
		panel_1.add(lblChucVu);

		JLabel ltlLuongcb = new JLabel("ID Nhân Viên ");
		ltlLuongcb.setBounds(566, 11, 83, 25);
		panel_1.add(ltlLuongcb);

		JLabel ltlHeSoLuong = new JLabel("ID Nhân Viên ");
		ltlHeSoLuong.setBounds(566, 47, 83, 25);
		panel_1.add(ltlHeSoLuong);

		JLabel ltlPhuCap = new JLabel("ID Nhân Viên ");
		ltlPhuCap.setBounds(566, 83, 83, 25);
		panel_1.add(ltlPhuCap);

		JLabel ltlBh = new JLabel("ID Nhân Viên ");
		ltlBh.setBounds(566, 119, 83, 25);
		panel_1.add(ltlBh);

		lblThue = new JLabel("ID Nhân Viên ");
		lblThue.setBounds(566, 155, 83, 25);
		panel_1.add(lblThue);

		JLabel lblThucLanh = new JLabel("ID Nhân Viên ");
		lblThucLanh.setBounds(566, 191, 83, 25);
		panel_1.add(lblThucLanh);

		btnExcel = new JButton("Xuất Excel");
		btnExcel.setBounds(916, 23, 112, 30);
		add(btnExcel);

		btnEmail = new JButton("Gửi Email Hàng Loạt");
		btnEmail.setBounds(1066, 23, 158, 30);
		add(btnEmail);
		
		btnTinhLuong = new JButton("Tinh Lương");
		btnTinhLuong.setBounds(760, 23, 112, 30);
		add(btnTinhLuong);
		docDuLieuPhongBan();
		btnTinhLuong.addActionListener(this);
		btnExcel.addActionListener(this);
		btnEmail.addActionListener(this);
	}
	public void xoaTable() {
		DefaultTableModel dm = (DefaultTableModel) tableLuong.getModel();
		dm.getDataVector().removeAllElements();
	}
	public void docDulieuVaoTable(int thang,int nam,String phongBan) throws SQLException {
		xoaTable();
		ArrayList<NhanVien> dsnv = new ArrayList<>();
		dsnv = ccnv_bus.getDSChamCongNhanVien(thang,nam,phongBan);
		int stt = 1;
		if(dsnv.isEmpty()) {
			JOptionPane.showConfirmDialog(this,"Không có dữ liệu để tính lương");
		}
		for (NhanVien nv : dsnv) {
			LuongNhanVien l = bl_bus.getLuongNhanVien(nv.getIdNhanVien(), thang, nam,phongBan);
			DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
			String tongLuong = decimalFormat.format(l.getTongLuong())+ " VND";
			String bhxh = decimalFormat.format(l.getThueBHXH()) + " VND";
			String thue = decimalFormat.format(l.getThueLaoDong()) + " VND";
			String thuclanh = decimalFormat.format(l.getThucLanh()) + "VND";
			String phuCap = decimalFormat.format(nv.getPhuCap()) + "VND";
			String luongCB = decimalFormat.format(800000)+"VND";
			dftable.addRow(new Object[] { stt, 2023, 10, phongBan, nv.getIdNhanVien(),
					nv.getHoTen(), luongCB, 1.4, phuCap, tongLuong, bhxh, thue, thuclanh });
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

	public static void main(String[] args) {
		new TinhLuongNhanVien_Form(WIDTH, HEIGHT).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnTinhLuong)) {
			int thang;
			int nam;
			try {
			    thang = Integer.parseInt(((String) cbbThang.getSelectedItem()).replaceAll("\\D", ""));
			    nam = Integer.parseInt(((String) cbbNam.getSelectedItem()).replaceAll("\\D", ""));
			} catch (NumberFormatException e1) {
			    // Xử lý ngoại lệ nếu chuỗi không chứa số
			    thang = 0; // hoặc giá trị mặc định khác bạn muốn đặt
			    nam=0;
			}
			String pb = (String) cbbPhongBan.getSelectedItem();

			try {
				docDulieuVaoTable(thang, nam, pb);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
