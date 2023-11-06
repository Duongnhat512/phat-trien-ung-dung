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
import javax.swing.table.TableColumn;
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

public class TinhLuongCongNhan_Form extends JPanel {
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

	public TinhLuongCongNhan_Form(int width, int height) {
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
		JComboBox cbbNam = new JComboBox(years);
		cbbNam.setBounds(23, 23, 142, 30);
		cbbNam.setSelectedItem(String.valueOf(currentYear));
		add(cbbNam);

		String[] months = { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8",
				"Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" };
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
		scrollPane.setBounds(23, 65, 1214, 436);
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
				"STT","Năm","Tháng","Phân Xưởng", "ID Công Nhân", "Tên Công Nhân", "Tay Nghề", "Tổng Thu Nhập", "Thuế", "Thực Lãnh"
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
		add(scrollPane);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(23, 511, 1214, 203);
		add(panel);
		panel.setLayout(null);

		JLabel lblThngTinChung = new JLabel("Thông Tin Chung");
		lblThngTinChung.setForeground(new Color(0, 0, 205));
		lblThngTinChung.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThngTinChung.setBounds(10, 11, 164, 28);
		panel.add(lblThngTinChung);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(10, 50, 1194, 153);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID Công Nhân");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 109, 25);
		panel_1.add(lblNewLabel);

		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHTn.setBounds(10, 68, 83, 25);
		panel_1.add(lblHTn);

		JLabel lblPhngBan = new JLabel("Giới Tính");
		lblPhngBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhngBan.setBounds(10, 117, 83, 25);
		panel_1.add(lblPhngBan);

		JLabel lblChcV = new JLabel("Tổng Thu Nhập");
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChcV.setBounds(831, 11, 108, 25);
		panel_1.add(lblChcV);

		JLabel lblPhngBan_1 = new JLabel("Ngày Sinh");
		lblPhngBan_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhngBan_1.setBounds(421, 11, 83, 25);
		panel_1.add(lblPhngBan_1);

		JLabel lblChcV_1_1 = new JLabel("Thuế");
		lblChcV_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChcV_1_1.setBounds(831, 68, 83, 25);
		panel_1.add(lblChcV_1_1);

		JLabel lblChcV_1_2_1_1_1 = new JLabel("Tay Nghề");
		lblChcV_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChcV_1_2_1_1_1.setBounds(421, 68, 118, 25);
		panel_1.add(lblChcV_1_2_1_1_1);

		JLabel lblChcV_1_2_1_1_1_1 = new JLabel("Thực Lãnh");
		lblChcV_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChcV_1_2_1_1_1_1.setBounds(831, 117, 83, 25);
		panel_1.add(lblChcV_1_2_1_1_1_1);

		JLabel lblIdNV = new JLabel("ID Nhân Viên ");
		lblIdNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdNV.setBounds(180, 11, 101, 25);
		panel_1.add(lblIdNV);

		JLabel lblTen = new JLabel("ID Nhân Viên ");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTen.setBounds(180, 68, 101, 25);
		panel_1.add(lblTen);

		JLabel lblPhai = new JLabel("ID Nhân Viên ");
		lblPhai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhai.setBounds(180, 117, 101, 25);
		panel_1.add(lblPhai);

		JLabel ltlNgaySinh = new JLabel("ID Nhân Viên ");
		ltlNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ltlNgaySinh.setBounds(1018, 11, 83, 25);
		panel_1.add(ltlNgaySinh);

		JLabel ltlPhongBan = new JLabel("ID Nhân Viên ");
		ltlPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ltlPhongBan.setBounds(1018, 68, 83, 25);
		panel_1.add(ltlPhongBan);

		lblThue = new JLabel("ID Nhân Viên ");
		lblThue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThue.setBounds(566, 11, 83, 25);
		panel_1.add(lblThue);

		JLabel lblThucLanh = new JLabel("ID Nhân Viên ");
		lblThucLanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThucLanh.setBounds(1018, 117, 83, 25);
		panel_1.add(lblThucLanh);
		
		JLabel lblChcV_1_2_1_1_1_2 = new JLabel("Phân Xưởng");
		lblChcV_1_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChcV_1_2_1_1_1_2.setBounds(421, 117, 83, 25);
		panel_1.add(lblChcV_1_2_1_1_1_2);
		
		JLabel lblThucLanh_1 = new JLabel("ID Nhân Viên ");
		lblThucLanh_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThucLanh_1.setBounds(566, 117, 83, 25);
		panel_1.add(lblThucLanh_1);
		
		JLabel lblThucLanh_2 = new JLabel("ID Nhân Viên ");
		lblThucLanh_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThucLanh_2.setBounds(566, 68, 83, 25);
		panel_1.add(lblThucLanh_2);

		JButton btnNewButton = new JButton("Xuất Excel");
		btnNewButton.setBounds(829, 23, 112, 30);
		add(btnNewButton);

		JButton btnGiEmailHng = new JButton("Gửi Email Hàng Loạt");
		btnGiEmailHng.setBounds(993, 23, 158, 30);
		add(btnGiEmailHng);
	}
}
