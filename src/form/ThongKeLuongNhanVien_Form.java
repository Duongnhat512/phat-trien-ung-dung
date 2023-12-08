package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

import com.raven.datechooser.DateChooser;
import com.toedter.calendar.JDateChooser;

import bus.PhongBan_BUS;
import bus.ThongKeLuongNV_BUS;
import commons.RoundPanel;
import commons.RoundTextField;
import commons.Table;
import connectDB.ConnectDB;
import entities.CongNhan;
import entities.PhongBan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

import gui.Main_GUI;

import javax.print.DocFlavor.URL;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter.Entry;
import javax.swing.RowSorter;

import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.RowFilter;

import net.miginfocom.swing.MigLayout;

public class ThongKeLuongNhanVien_Form extends JPanel implements ActionListener, MouseListener {

	private JPanel panelNorth;
	private JPanel panelSouth;
	private int width = 1250;
	private int height = 777;
	private DefaultTableModel model;
	private Table tableThongKe;
	private RoundPanel panelBarChart;
	private RoundPanel panelLineChart;

	private RoundPanel panelCenter;
	private JComboBox cbThang;
	private JComboBox cbNam;
	private DefaultTableModel modelTK;
	private ThongKeLuongNV_BUS thongKeLuongNV_BUS;
	private RoundPanel panelListTK;
	private JLabel lbThongKe;
	private PhongBan_BUS phongBan_BUS;
	private JButton btnPrint;
	private DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
	private RoundTextField txtTimKiem;
	private TableRowSorter sorter;


	public ThongKeLuongNhanVien_Form(int width, int height) {
		this.width = width;
		this.height = height;
		thongKeLuongNV_BUS = new ThongKeLuongNV_BUS();
		phongBan_BUS = new PhongBan_BUS();
		try {
			ConnectDB.getInstance().connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();

	}

	private void showBarChart(double[] t, int row) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(t[0], "Lương trung bình", "T1");
		dataset.setValue(t[1], "Lương trung bình", "T2");
		dataset.setValue(t[2], "Lương trung bình", "T3");
		dataset.setValue(t[3], "Lương trung bình", "T4");
		dataset.setValue(t[4], "Lương trung bình", "T5");
		dataset.setValue(t[5], "Lương trung bình", "T6");
		dataset.setValue(t[6], "Lương trung bình", "T7");
		dataset.setValue(t[7], "Lương trung bình", "T8");
		dataset.setValue(t[8], "Lương trung bình", "T9");
		dataset.setValue(t[9], "Lương trung bình", "T10");
		dataset.setValue(t[10], "Lương trung bình", "T11");
		dataset.setValue(t[11], "Lương trung bình", "T12");
		JFreeChart chart = ChartFactory.createBarChart(
				"Biểu Đồ Cột Thể Hiện Sự Tăng Trưởng Thu Nhập Của " + tableThongKe.getValueAt(row, 1).toString()
						+ " Năm " + cbNam.getSelectedItem().toString(),
				"Tháng", "Lương ()", dataset, PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot categoryPlot = chart.getCategoryPlot();
		// categoryPlot.setRangeGridlinePaint(Color.BLUE);
		categoryPlot.setBackgroundPaint(Color.WHITE);
		BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
		Color clr3 = new Color(204, 0, 51);
		renderer.setSeriesPaint(0, clr3);

		ChartPanel barpChartPanel = new ChartPanel(chart);
		panelBarChart.removeAll();
		panelBarChart.setLayout(null);
		panelBarChart.setLayout(null);
		panelBarChart.setLayout(new MigLayout("", "[634px]", "[404px]"));
		panelBarChart.add(barpChartPanel, "cell 0 0,grow");
		barpChartPanel.setLayout(new BorderLayout(0, 0));
		panelBarChart.validate();

	}

	private void showPieChart(double tyle[], int row) {

		// create dataset
		DefaultPieDataset barDataset = new DefaultPieDataset();
		for (int i = 0; i < tyle.length; i++) {
			if (tyle[i] != 0) {
				barDataset.setValue("Tháng " + (i + 1), tyle[i]);
			}
		}
		// create chart
		JFreeChart piechart = ChartFactory.createPieChart(
				"Biểu đồ tròn thể hiện mức độ gia tăng lương mỗi tháng của "
						+ tableThongKe.getValueAt(row, 1).toString() + " Năm " + cbNam.getSelectedItem().toString(),
				barDataset, false, true, false);// explain

		PiePlot piePlot = (PiePlot) piechart.getPlot();

		// changing pie chart blocks colors
		piePlot.setSectionPaint("Đạt KPI", new Color(102, 255, 102));
		piePlot.setSectionPaint("Không đạt", new Color(255, 0, 0));
		piePlot.setBackgroundPaint(Color.white);

		// create chartPanel to display chart(graph)
		ChartPanel barChartPanel = new ChartPanel(piechart);
		panelLineChart.removeAll();
		panelLineChart.setLayout(null);
		panelLineChart.setLayout(new MigLayout("", "[549px]", "[404px]"));
		panelLineChart.add(barChartPanel, "cell 0 0,grow");
		barChartPanel.setLayout(new BorderLayout(0, 0));
		panelLineChart.validate();
	}

	public void initComponents() {
		setPreferredSize(new Dimension(1250, 777));
		setBackground(Color.decode("#004e92"));
		panelBarChart = new RoundPanel();
		panelBarChart.setRound(20);
		panelBarChart.setBackground(new Color(255, 255, 255));
		panelBarChart.setBounds(24, 363, 634, 404);
		panelLineChart = new RoundPanel();
		panelLineChart.setRound(20);
		panelLineChart.setBackground(new Color(255, 255, 255));
		panelLineChart.setBounds(668, 363, 556, 404);
		setLayout(null);
		add(panelBarChart);
		add(panelLineChart);

		// Bảng chấm công
		tableThongKe = new Table();
		tableThongKe.setOpaque(false);
		// Cài đặt header cho table Chấm công
		tableThongKe
				.setModel(modelTK = new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
						new String[] { "ID Nh\u00E2n vi\u00EAn", "H\u1ECD t\u00EAn", " Ph\u00F2ng ban", "Th\u00E1ng",
								"T\u1ED5ng l\u01B0\u01A1ng", "Th\u1EF1c l\u00E3nh" }));
		tableThongKe.getColumnModel().getColumn(1).setPreferredWidth(92);
		tableThongKe.getColumnModel().getColumn(2).setPreferredWidth(89);
		tableThongKe.getColumnModel().getColumn(4).setPreferredWidth(110);
		JScrollPane scrollPane_TK = new JScrollPane();
		scrollPane_TK.setBackground(new Color(255, 255, 255));
		scrollPane_TK.setOpaque(false);
		scrollPane_TK.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane_TK.setViewportView(tableThongKe);
		tableThongKe.fixTable(scrollPane_TK);
		panelCenter = new RoundPanel();
		panelCenter.setRound(20);
		panelCenter.setBackground(new Color(255, 255, 255));
		panelCenter.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelCenter.setBounds(24, 59, 1200, 294);
		add(panelCenter);
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelCenter.add(scrollPane_TK, BorderLayout.CENTER);

		panelListTK = new RoundPanel();
		panelListTK.setRound(10);
		panelListTK.setOpaque(false);
		panelListTK.setBackground(new Color(153, 204, 255));
//           scrollPane.setColumnHeaderView(panel_1);
		panelCenter.add(panelListTK, BorderLayout.NORTH);

		lbThongKe = new JLabel("Danh sách lương nhân viên");
		lbThongKe.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelListTK.add(lbThongKe);

		JPanel pNorth = new JPanel();
		pNorth.setBackground(new Color(255, 255, 255));
		pNorth.setBounds(25, 10, 1199, 39);
		add(pNorth);
		pNorth.setLayout(null);

		cbThang = new JComboBox();
		cbThang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbThang.setBounds(84, 6, 83, 28);
		String data[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cbThang.setModel(new DefaultComboBoxModel<String>(data));
		cbThang.setSelectedItem(LocalDate.now().getMonthValue() + "");
		pNorth.add(cbThang);

		cbNam = new JComboBox();
		cbNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbNam.setBounds(272, 6, 181, 28);
		String data_1[] = new String[15];
		for (int i = 0; i < 15; i++) {
			data_1[i] = 2015 + i + "";
		}
		cbNam.setModel(new DefaultComboBoxModel<String>(data_1));
		cbNam.setSelectedItem(LocalDate.now().getYear() + "");
		pNorth.add(cbNam);

		btnPrint = new JButton("Xuất ra excel");
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrint.setIcon(new ImageIcon(ThongKeLuongNhanVien_Form.class.getResource("/icon/excel.png")));

		btnPrint.setBounds(929, 4, 160, 33);
		pNorth.add(btnPrint);

		JLabel lbthang = new JLabel("Tháng:");
		lbthang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbthang.setHorizontalAlignment(SwingConstants.CENTER);
		lbthang.setBounds(27, 10, 58, 20);
		pNorth.add(lbthang);
		txtTimKiem = new RoundTextField(10);
		txtTimKiem.setText("Nhập dữ liệu nhân viên cần tìm...");
		txtTimKiem.setForeground(Color.GRAY);
		txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBorder(new EmptyBorder(0, 15, 0, 0));
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().isEmpty()) {
					txtTimKiem.setText("Nhập dữ liệu nhân viên cần tìm...");
					txtTimKiem.setForeground(Color.GRAY);
				}
				super.focusLost(e);
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equalsIgnoreCase("Nhập dữ liệu nhân viên cần tìm...")) {
					txtTimKiem.setText("");
					txtTimKiem.setForeground(Color.BLACK);
				}
				super.focusGained(e);
			}
		});
		txtTimKiem.setBounds(496, 4, 408, 33);
		pNorth.add(txtTimKiem);
		txtTimKiem.addActionListener(this);
		JLabel lbNam = new JLabel("Năm:");
		lbNam.setHorizontalAlignment(SwingConstants.CENTER);
		lbNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNam.setBounds(204, 10, 58, 20);
		pNorth.add(lbNam);
		btnPrint.addActionListener(this);
		tableThongKe.addMouseListener(this);
		cbThang.addActionListener(this);
		cbNam.addActionListener(this);
		hienThiTable();
		if (tableThongKe.getRowCount() != 0) {
			thongKeLuongNhanVien(0);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(cbThang) || o.equals(cbNam)) {
			hienThiTable();
	

		}
		if (o.equals(btnPrint)) {
			String projectDirectory = System.getProperty("user.dir");
			String filePath = projectDirectory + "\\file\\file.xlsx";
			if (modelTK.getRowCount() > 0) {
				if (exportToExcelAndCreateUI(tableThongKe, filePath)) {
					openExcelFile(filePath); // Mở tệp Excel nếu xuất thành công
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu để xuất file");
			}

		}
		if(o.equals(txtTimKiem))
		{
			searchEmployee();
		}
	}

	private void hienThiDsLuongPB() {
		// TODO Auto-generated method stub

	}

	private void hienThiTable() {
		// TODO Auto-generated method stub
		modelTK.setRowCount(0);
		int month = Integer.parseInt(cbThang.getSelectedItem().toString());
		int year = Integer.parseInt(cbNam.getSelectedItem().toString());
		ArrayList<String> listPB = thongKeLuongNV_BUS.getListLuongPB(month, year);
		for (String string : listPB) {
			String[] mangChuoi = string.split(";");
			double tongLuong = Double.parseDouble(mangChuoi[4]);
			double luongThucLanh = Double.parseDouble(mangChuoi[5]);
			String tongLuongFM = decimalFormat.format(tongLuong) + " VND";
			String thucLanhFM = decimalFormat.format(luongThucLanh) + " VND";
			modelTK.addRow(new Object[] { mangChuoi[0], mangChuoi[1], mangChuoi[2].toString(), mangChuoi[3].toString(),
					tongLuongFM, thucLanhFM });
		}

	}

	public void thongKeLuongNhanVien(int row) {
		hienThiTable();
		double t[] = new double[20];
		double tong = 0;
		String col[] = { "Idnv", "Tennv", "TenPb", "thang", "ThucThu" };
		DefaultTableModel modeltest = new DefaultTableModel(col, 0);
		JTable tableTest = new JTable(modeltest);
		modeltest.setRowCount(0);
		ArrayList<String> listCN = thongKeLuongNV_BUS.getListLuongPB(tableThongKe.getValueAt(row, 0).toString(),
				Integer.parseInt(cbNam.getSelectedItem().toString()));
		for (String string : listCN) {
			modeltest.addRow(string.split(";"));
		}
		for (int i = 0; i < tableTest.getRowCount(); i++) {
			int thang = Integer.parseInt(tableTest.getValueAt(i, 3).toString());
			double luong = Double.parseDouble(tableTest.getValueAt(i, 4).toString());
			t[thang - 1] = luong;
			tong += luong;
		}
		showBarChart(t, row);

		double t1[] = new double[20];
		for (int j = 0; j < tableTest.getRowCount(); j++) {
			int thang = Integer.parseInt(tableTest.getValueAt(j, 3).toString());
			double luong = Double.parseDouble(tableTest.getValueAt(j, 4).toString());
			t1[thang - 1] = ((luong * 1.0) / (tong * 1.0)) / 100;

		}
		showPieChart(t1, row);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableThongKe.getSelectedRow();
		if (row != -1) {
			thongKeLuongNhanVien(row);
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

	private void searchEmployee() {
		String searchText = txtTimKiem.getText().trim();
		sorter = new TableRowSorter<>(modelTK);
		tableThongKe.setRowSorter(sorter);
		RowFilter<DefaultTableModel, Object> idOrNameFilter = new RowFilter<DefaultTableModel, Object>() {
			@Override
			public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
				String text = searchText.toLowerCase();
				for (int i = 0; i < entry.getValueCount(); i++) {
					Object value = entry.getValue(i);
					if (value != null && value.toString().toLowerCase().contains(text)) {
						return true;
					}
				}
				return false;
			}
		};
		sorter.setRowFilter(idOrNameFilter);
	}
}
