package form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Scrollbar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class TinhLuongNhanVien_Form extends JPanel {
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

	public TinhLuongNhanVien_Form(int width, int height) {
		this.height = height;
		this.width = width;
		
		setPreferredSize(new Dimension(this.width, this.height));
		setLayout(null);
		Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);
        int startYear = 2010; // Năm bắt đầu
        int endYear = 2025;   // Năm kết thúc
        String[] years = new String[endYear - startYear + 1];
        for (int i = startYear; i <= endYear; i++) {
            years[i - startYear] =String.valueOf(i);
        }
		JComboBox cbbNam = new JComboBox(years);
		cbbNam.setBounds(23, 23, 142, 30);
		cbbNam.setSelectedItem(String.valueOf(currentYear));
		add(cbbNam);
		
		String[] months = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
		JComboBox cbbThang = new JComboBox(months);
		cbbThang.setBounds(206, 23, 142, 30);
		cbbThang.setSelectedIndex(currentMonth);
		add(cbbThang);
		
		JComboBox cbbPhongBan = new JComboBox();
		cbbPhongBan.setBounds(383, 23, 142, 30);
		add(cbbPhongBan);
		
		JComboBox cbbTenNV = new JComboBox();
		cbbTenNV.setBounds(576, 23, 142, 30);
		add(cbbTenNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 1214, 378);
		add(scrollPane);

		tableLuong = new JTable();
		tableLuong
				.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"STT","Năm","Tháng","Phòng Ban", "ID Nh\u00E2n Vi\u00EAn", "H\u1ECD T\u00EAn", "L\u01B0\u01A1ng C\u01A1 B\u1EA3n", "H\u1EC7 S\u1ED1 L\u01B0\u01A1ng", "Ph\u1EE5 C\u1EA5p", "T\u1ED5ng L\u01B0\u01A1ng Th\u1EF1c T\u1EBF", "BHXH", "Thu\u1EBF", "Th\u1EF1c L\u00E3nh"
			}
		));
		tableLuong.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableLuong.setSelectionBackground(new Color(232, 57, 95));
		tableLuong.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		tableLuong.setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableLuong.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableLuong.getTableHeader().setBackground(new Color(32, 136, 203));
		tableLuong.getTableHeader().setForeground(new Color(255, 255, 255));
		tableLuong.setPreferredScrollableViewportSize(new Dimension(400, 500));
		scrollPane.setViewportView(tableLuong);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 452, 1214, 306);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblThngTinChung = new JLabel("Thông Tin Chung");
		lblThngTinChung.setForeground(new Color(0, 0, 205));
		lblThngTinChung.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngTinChung.setBounds(10, 11, 164, 28);
		panel.add(lblThngTinChung);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(10, 50, 1194, 268);
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
		
		JButton btnNewButton = new JButton("Xuất Excel");
		btnNewButton.setBounds(829, 23, 112, 30);
		add(btnNewButton);
		
		JButton btnGiEmailHng = new JButton("Gửi Email Hàng Loạt");
		btnGiEmailHng.setBounds(993, 23, 158, 30);
		add(btnGiEmailHng);
	}
}
