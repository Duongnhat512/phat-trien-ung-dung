package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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

import bus.ThongKeLuongCongNhan_BUS;
import bus.ThongKeLuongNV_BUS;
import commons.MyButton;
import commons.RoundPanel;
import commons.RoundTextField;
import commons.Table;
import connectDB.ConnectDB;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.RowFilter;

import net.miginfocom.swing.MigLayout;

public class ThongKeLuongCongNhan_Form extends JPanel implements ActionListener, MouseListener {

	private JPanel panelNorth;
	private JPanel panelSouth;
	private int width = 1250;
	private int height = 725;
	private DefaultTableModel model;
	private Table table_2;
	private Table tableThongKe;
	private JTextField textField;
	private RoundPanel panelBarChart;
	private RoundPanel panelLineChart;
	private ThongKeLuongCongNhan_BUS thongKeLuongCongNhan_BUS;
	private RoundPanel panelCenter;
	private JComboBox cbThang;
	private JComboBox cbNam;
	private DefaultTableModel modelTK;
	private MyButton btnPrint;
	private JTextField textField_1;
	private RoundTextField txtTimKiem;
    private DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
	private TableRowSorter sorter;
	private RoundPanel panelListTK;
	private JComponent lbThongKe;
	private MyButton btnLamMoi;

	public ThongKeLuongCongNhan_Form(int width, int height) {
		this.width = width;
		this.height = height;
		thongKeLuongCongNhan_BUS = new ThongKeLuongCongNhan_BUS();
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

	public void showBarChart(double[] t, int row) {
		if(row>=0)
		{
			
		
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
		JFreeChart chart = ChartFactory.createBarChart("Biểu Đồ Cột Thể Hiện Sự Tăng Trưởng Thu Nhập Của "+tableThongKe.getValueAt(row, 1).toString()+
				 " Năm " + cbNam.getSelectedItem().toString(),
				"Tháng", "Lương", dataset, PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot categoryPlot = chart.getCategoryPlot();
		// categoryPlot.setRangeGridlinePaint(Color.BLUE);
		categoryPlot.setBackgroundPaint(Color.WHITE);
		BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
		Color clr3 = new Color(204, 0, 51);
		renderer.setSeriesPaint(0, clr3);

		ChartPanel barpChartPanel = new ChartPanel(chart);
		barpChartPanel.setBounds(10, 10, 585, 387);
		panelBarChart.removeAll();
		panelBarChart.setLayout(null);
		panelBarChart.setLayout(new MigLayout("", "[585px]", "[387px]"));
		panelBarChart.add(barpChartPanel, "cell 0 0,grow");
		barpChartPanel.setLayout(new BorderLayout(0, 0));
		panelBarChart.validate();
		}
		else
		{
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
			JFreeChart chart = ChartFactory.createBarChart("Biểu Đồ Cột Thể Hiện Sự Tăng Trưởng Thu Nhập"+
					 " Năm " + cbNam.getSelectedItem().toString(),
					"Tháng", "Lương", dataset, PlotOrientation.VERTICAL, false, true, false);

			CategoryPlot categoryPlot = chart.getCategoryPlot();
			// categoryPlot.setRangeGridlinePaint(Color.BLUE);
			categoryPlot.setBackgroundPaint(Color.WHITE);
			BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
			Color clr3 = new Color(204, 0, 51);
			renderer.setSeriesPaint(0, clr3);

			ChartPanel barpChartPanel = new ChartPanel(chart);
			barpChartPanel.setBounds(10, 10, 585, 387);
			panelBarChart.removeAll();
			panelBarChart.setLayout(null);
			panelBarChart.setLayout(new MigLayout("", "[585px]", "[387px]"));
			panelBarChart.add(barpChartPanel, "cell 0 0,grow");
			barpChartPanel.setLayout(new BorderLayout(0, 0));
			panelBarChart.validate();
		}
	}

	private void showPieChart(double tyle[], int row) {

		// create dataset
		if(row>=0)
		{
		DefaultPieDataset barDataset = new DefaultPieDataset();
		for (int i = 0; i < tyle.length; i++) {
			if (tyle[i] != 0) {
				barDataset.setValue("Tháng " + (i + 1), tyle[i]);
			}
		}
		// create chart
		JFreeChart piechart = ChartFactory.createPieChart(
				"Biểu đồ tròn thể hiện mức độ gia tăng lương mỗi tháng của "
						+ tableThongKe.getValueAt(row, 1).toString() + " Năm " + cbNam.getSelectedItem().toString(), barDataset,
				false, true, false);// explain

		PiePlot piePlot = (PiePlot) piechart.getPlot();

		// changing pie chart blocks colors
		piePlot.setSectionPaint("Đạt KPI", new Color(102, 255, 102));
		piePlot.setSectionPaint("Không đạt", new Color(255, 0, 0));
		piePlot.setBackgroundPaint(Color.white);

		// create chartPanel to display chart(graph)
		ChartPanel barChartPanel = new ChartPanel(piechart);
		barChartPanel.setBounds(10, 10, 585, 387);
		panelLineChart.removeAll();
		panelLineChart.setLayout(null);
		panelLineChart.setLayout(new MigLayout("", "[585px]", "[387px]"));
		panelLineChart.add(barChartPanel, "cell 0 0,grow");
		barChartPanel.setLayout(new BorderLayout(0, 0));
		panelLineChart.validate();
		}else
		{
			DefaultPieDataset barDataset = new DefaultPieDataset();
			for (int i = 0; i < tyle.length; i++) {
				if (tyle[i] != 0) {
					barDataset.setValue("Tháng " + (i + 1), tyle[i]);
				}
			}
			// create chart
			JFreeChart piechart = ChartFactory.createPieChart(
					"Biểu đồ tròn phần trăm lương mỗi tháng của năm " + cbNam.getSelectedItem().toString(), barDataset,
					false, true, false);// explain

			PiePlot piePlot = (PiePlot) piechart.getPlot();

			// changing pie chart blocks colors
			piePlot.setSectionPaint("Đạt KPI", new Color(102, 255, 102));
			piePlot.setSectionPaint("Không đạt", new Color(255, 0, 0));
			piePlot.setBackgroundPaint(Color.white);

			// create chartPanel to display chart(graph)
			ChartPanel barChartPanel = new ChartPanel(piechart);
			barChartPanel.setBounds(10, 10, 585, 387);
			panelLineChart.removeAll();
			panelLineChart.setLayout(null);
			panelLineChart.setLayout(new MigLayout("", "[585px]", "[387px]"));
			panelLineChart.add(barChartPanel, "cell 0 0,grow");
			barChartPanel.setLayout(new BorderLayout(0, 0));
			panelLineChart.validate();
		}
	}

	public void initComponents() {
		setPreferredSize(new Dimension(1250, 778));
		setBackground(Color.decode("#004e92"));
		panelBarChart = new RoundPanel();
		panelBarChart.setRound(20);
		panelBarChart.setBackground(new Color(255, 255, 255));
		panelBarChart.setBounds(10, 364, 615, 407);
		panelLineChart = new RoundPanel();
		panelLineChart.setRound(20);
		panelLineChart.setBackground(new Color(255, 255, 255));
		panelLineChart.setBounds(635, 364, 605, 407);
		setLayout(null);
		add(panelBarChart);
		add(panelLineChart);

		// Bảng chấm công
		tableThongKe = new Table();
		tableThongKe.setOpaque(false);
		// Cài đặt header cho table Chấm công
		tableThongKe
				.setModel(modelTK = new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
						new String[] { "ID C\u00F4ng nh\u00E2n", "H\u1ECD t\u00EAn", "Ph\u00E2n x\u01B0\u1EDFng",
								"Th\u00E1ng", "S\u1ED1 l\u01B0\u1EE3ng s\u1EA3n ph\u1EA9m ho\u00E0n th\u00E0nh",
								"Th\u1EF1c l\u00E3nh" }));
		tableThongKe.getColumnModel().getColumn(1).setPreferredWidth(92);
		tableThongKe.getColumnModel().getColumn(2).setPreferredWidth(89);

		JScrollPane scrollPane_TK = new JScrollPane();
		scrollPane_TK.setBackground(new Color(255, 255, 255));
		scrollPane_TK.setOpaque(false);
		scrollPane_TK.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane_TK.setViewportView(tableThongKe);
		scrollPane_TK.setBounds(10, 10, 1198, 259);
		tableThongKe.fixTable(scrollPane_TK);
		panelCenter = new RoundPanel();
		panelCenter.setRound(20);
		panelCenter.setBackground(new Color(255, 255, 255));
		panelCenter.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelCenter.setBounds(10, 75, 1230, 279);
		add(panelCenter);
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(scrollPane_TK,BorderLayout.CENTER);
		 panelListTK = new RoundPanel();
		panelListTK.setRound(10);
		panelListTK.setOpaque(false);
		panelListTK.setBackground(new Color(153, 204, 255));
//           scrollPane.setColumnHeaderView(panel_1);
		panelCenter.add(panelListTK, BorderLayout.NORTH);

		lbThongKe = new JLabel("Danh sách công nhân");
		lbThongKe.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelListTK.add(lbThongKe,BorderLayout.NORTH);

		RoundPanel pNorth = new RoundPanel();
		pNorth.setBackground(new Color(255, 255, 255));
		pNorth.setRound(20);
		pNorth.setBounds(10, 10, 1230, 55);
		add(pNorth);
		pNorth.setLayout(null);

		cbThang = new JComboBox();
		cbThang.setBackground(new Color(255, 255, 255));
		cbThang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbThang.setBounds(93, 15, 83, 28);
		String data[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cbThang.setModel(new DefaultComboBoxModel<String>(data));
		cbThang.setSelectedItem(LocalDate.now().getMonthValue() + "");
		pNorth.add(cbThang);

		cbNam = new JComboBox();
		cbNam.setBackground(new Color(255, 255, 255));
		cbNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbNam.setBounds(261, 15, 181, 28);
		String data_1[] = { "2023" };
		cbNam.setModel(new DefaultComboBoxModel<String>(data_1));
		cbNam.setSelectedItem(LocalDate.now().getYear() + "");
		pNorth.add(cbNam);

		btnPrint = new MyButton();
		btnPrint.setText("Xuất Excel");
		btnPrint.setRadius(20);
		btnPrint.setBackground(Color.white);
		btnPrint.setFocusPainted(false);
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrint.setIcon(new ImageIcon(ThongKeLuongCongNhan_Form.class.getResource("/icon/excel.png")));

		btnPrint.setBounds(1055, 10, 131, 38);
		pNorth.add(btnPrint);
		btnPrint.addActionListener(this);
		JLabel lbthang = new JLabel("Tháng:");
		lbthang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbthang.setHorizontalAlignment(SwingConstants.CENTER);
		lbthang.setBounds(36, 19, 58, 20);
		pNorth.add(lbthang);

		JLabel lbNam = new JLabel("Năm:");
		lbNam.setHorizontalAlignment(SwingConstants.CENTER);
		lbNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNam.setBounds(204, 19, 58, 20);
		pNorth.add(lbNam);

		txtTimKiem = new RoundTextField(10);
		txtTimKiem.setText("Nhập tên công nhân cần tìm...");
		txtTimKiem.setForeground(Color.GRAY);
		txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBorder(new EmptyBorder(0, 15, 0, 0));
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().isEmpty()) {
					txtTimKiem.setText("Nhập dữ liệu công nhân cần tìm...");
					txtTimKiem.setForeground(Color.GRAY);
				}
				super.focusLost(e);
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equalsIgnoreCase("Nhập dữ liệu công nhân cần tìm...")) {
					txtTimKiem.setText("");
					txtTimKiem.setForeground(Color.BLACK);
				}
				super.focusGained(e);
			}
		});
		txtTimKiem.setBounds(452, 13, 408, 33);
		pNorth.add(txtTimKiem);
		
		btnLamMoi = new MyButton();
		btnLamMoi.setIcon(new ImageIcon(ThongKeLuongCongNhan_Form.class.getResource("/icon/reset.png")));
		btnLamMoi.setText("Làm mới");
		btnLamMoi.setRadius(20);
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setBounds(877, 10, 131, 38);
		pNorth.add(btnLamMoi);
		btnLamMoi.addActionListener(this);
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchEmployee();
			}
		});
		
		tableThongKe.addMouseListener(this);
		cbThang.addActionListener(this);
		cbNam.addActionListener(this);
        hienThiTable();
        if(tableThongKe.getRowCount()!=0)
        {
        	thongKeLuongNhanVien(0);
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnLamMoi))
		{
			hienThiTable();
		}
		if (o.equals(cbThang) || o.equals(cbNam)) {
			hienThiTable();
			 if(tableThongKe.getRowCount()!=0)
		        {
		        	thongKeLuongNhanVien(0);
		        }
			 if(tableThongKe.getRowCount() == 0)
			{
	           JOptionPane.showMessageDialog(this, "Tháng này chưa có lương");
	           double[] t = new double[20];
	           for(int i = 0;i<19;i++)
	           {
	        	   t[i] = 0;
	           }
	           showBarChart(t,-1);
	           showPieChart(t,-1);
			}
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
	}

	private void hienThiTable() {
		// TODO Auto-generated method stub
		modelTK.setRowCount(0);
		int month = Integer.parseInt(cbThang.getSelectedItem().toString());
		int year = Integer.parseInt(cbNam.getSelectedItem().toString());
		ArrayList<String> listPB = thongKeLuongCongNhan_BUS.getListLuongPX(month, year);
		for (String string : listPB) {
			String[] mangChuoi = string.split(";");
	
			double luongThucLanh = Double.parseDouble(mangChuoi[5]);
			String thucLanhFM = decimalFormat.format(luongThucLanh)+ " VND";
			modelTK.addRow(new Object[] { mangChuoi[0],
					mangChuoi[1],mangChuoi[2].toString(),mangChuoi[3].toString(),mangChuoi[4],thucLanhFM});
		}
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

	public void thongKeLuongNhanVien(int row) {
		hienThiTable();
		double t[] = new double[20];
		double tong = 0;
		String col[] = { "Idcn", "TenCN", "TenPX", "thang", "slht", "TongLuong" };
		DefaultTableModel modeltest = new DefaultTableModel(col, 0);
		JTable tableTest = new JTable(modeltest);
		modeltest.setRowCount(0);
		ArrayList<String> listCN = thongKeLuongCongNhan_BUS.getListLuongCongNhan(
				tableThongKe.getValueAt(row, 0).toString(), Integer.parseInt(cbNam.getSelectedItem().toString()));
		for (String string : listCN) {
			modeltest.addRow(string.split(";"));
		}
		for (int i = 0; i < tableTest.getRowCount(); i++) {
			int thang = Integer.parseInt(tableTest.getValueAt(i, 3).toString());
			double luong = Double.parseDouble(tableTest.getValueAt(i, 5).toString());
			t[thang - 1] = luong;
			tong += luong;
		}
		showBarChart(t,row);

		double t1[] = new double[20];
		for (int j = 0; j < tableTest.getRowCount(); j++) {
			int thang = Integer.parseInt(tableTest.getValueAt(j, 3).toString());
			double luong = Double.parseDouble(tableTest.getValueAt(j, 5).toString());
			t1[thang - 1] = ((luong * 1.0) / (tong * 1.0)) / 100;
		}
		showPieChart(t1,row);
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
