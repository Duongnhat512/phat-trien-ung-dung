package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
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
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.raven.datechooser.DateChooser;
import com.toedter.calendar.JDateChooser;

import bus.CongNhan_BUS;
import bus.ThongKeKPI_BUS;
import commons.MyButton;
import commons.RoundPanel;
import commons.RoundTextField;
import commons.Table;
import connectDB.ConnectDB;
import entities.CongNhan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

import gui.Main_GUI;
import net.miginfocom.swing.MigLayout;

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
import java.lang.reflect.Array;
import java.sql.SQLException;
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

public class ThongKeKPI_Form extends JPanel implements ActionListener,MouseListener{
     

	private JPanel panelNorth;
	private JPanel panelSouth;
    private  int width = 1250;
    private  int height = 725;
	private DefaultTableModel model;
    private Table table_2;
    private Table tableThongKe;
	private JTextField textField;
	private RoundPanel panelBarChart;
	private RoundPanel panelLineChart;
	private JComponent lblNewLabel_1;
	private JComponent panelCenter;
	private RoundPanel panelListTK;
	private JLabel lbThongKe;
	private JButton btnThongKe;
	private ThongKeKPI_BUS thongKeKPI_BUS;
	private JComboBox cbThang;
	private JComboBox cbNam;
	private CongNhan_BUS congNhan_BUS;
	private MyButton btnPrint;
	private RoundTextField txtTimKiem;
	private TableRowSorter<DefaultTableModel> sorter;
	
	public ThongKeKPI_Form(int width, int height)
    { 
    	this.width = width;
    	this.height = height;
    	thongKeKPI_BUS = new ThongKeKPI_BUS();
    	congNhan_BUS = new CongNhan_BUS();
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
	private void showPieChart(double tyle , int row){
        
        //create dataset
		if(row>=0)
		{
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "Đạt KPI" , tyle );  
      barDataset.setValue( "Không đạt" , 100 - tyle );   
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Biểu Đồ Tròn Thể Hiện Mức Độ Hoàn Thành KPI Của "+tableThongKe.getValueAt(row, 1) +" tháng "+cbThang.getSelectedItem().toString(),barDataset, false,true,false);//explain"
       		
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setSectionPaint("Đạt KPI",new Color(102,255,102));
        piePlot.setSectionPaint("Không đạt", new Color(255,0,0));
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        barChartPanel.setBounds(0, 0, 423, 388);
        panelBarChart.removeAll();
        panelBarChart.setLayout(new MigLayout("", "[414px]", "[407px]"));
        panelBarChart.add(barChartPanel, "cell 0 0,grow");
        barChartPanel.setLayout(new BorderLayout(0, 0));
        panelBarChart.validate();
		}
		else
		{
			DefaultPieDataset barDataset = new DefaultPieDataset( );
		      barDataset.setValue( "Đạt KPI" , tyle );  
		      barDataset.setValue( "Không đạt" , 100 - tyle );   
		      
		      //create chart
		       JFreeChart piechart = ChartFactory.createPieChart("Biểu Đồ Tròn Thể Hiện Mức Độ Hoàn Thành KPI Của "+" tháng "+cbThang.getSelectedItem().toString(),barDataset, false,true,false);//explain"
		       		
		      
		        PiePlot piePlot =(PiePlot) piechart.getPlot();
		      
		       //changing pie chart blocks colors
		        piePlot.setSectionPaint("Đạt KPI",new Color(102,255,102));
		        piePlot.setSectionPaint("Không đạt", new Color(255,0,0));
		        piePlot.setBackgroundPaint(Color.white);
		        
		        //create chartPanel to display chart(graph)
		        ChartPanel barChartPanel = new ChartPanel(piechart);
		        barChartPanel.setBounds(0, 0, 423, 388);
		        panelBarChart.removeAll();
		        panelBarChart.setLayout(new MigLayout("", "[414px]", "[407px]"));
		        panelBarChart.add(barChartPanel, "cell 0 0,grow");
		        barChartPanel.setLayout(new BorderLayout(0, 0));
		        panelBarChart.validate();
		}
    }
    private void showLineChart(double[] t,int row){
    //create dataset for the graph
    	if(row>=0)
    	{
     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.setValue(t[0], "Số Lượng", "T1");
    dataset.setValue(t[1], "Số Lượng", "T2");
    dataset.setValue(t[2], "Số Lượng", "T3");
    dataset.setValue(t[3], "Số Lượng", "T4");
    dataset.setValue(t[4], "Số Lượng", "T5");
    dataset.setValue(t[5], "Số Lượng", "T6");
    dataset.setValue(t[6], "Số Lượng", "T7");
    dataset.setValue(t[7], "Số Lượng", "T8");
    dataset.setValue(t[8], "Số Lượng", "T9");
    dataset.setValue(t[9], "Số Lượng", "T10");
    dataset.setValue(t[10], "Số Lượng", "T11");
    dataset.setValue(t[11], "Số Lượng", "T12");
    
    //create chart
    JFreeChart linechart = ChartFactory.createLineChart("Biểu đồ tăng trưởng KPI của "+tableThongKe.getValueAt(row, 1) +" năm "+cbNam.getSelectedItem().toString(),"Tháng","Tỷ lệ", 
            dataset, PlotOrientation.VERTICAL, false,true,false);
    
    //create plot object
     CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
   // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
    lineCategoryPlot.setBackgroundPaint(Color.white);
    
    //create render object to change the moficy the line properties like color
    LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
    Color lineChartColor = new Color(204,0,51);
    lineRenderer.setSeriesPaint(0, lineChartColor);
    
     //create chartPanel to display chart(graph)
    ChartPanel lineChartPanel = new ChartPanel(linechart);
    lineChartPanel.setPreferredSize(new Dimension(HEIGHT, 410));
    panelLineChart.removeAll();
    panelLineChart.setLayout(new MigLayout("", "[774px]", "[372px]"));
    panelLineChart.add(lineChartPanel, "cell 0 0,grow");
    lineChartPanel.setLayout(new BorderLayout(0, 0));
    panelLineChart.validate();
    	}
    	else
    	{
    		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	    dataset.setValue(t[0], "Số Lượng", "T1");
    	    dataset.setValue(t[1], "Số Lượng", "T2");
    	    dataset.setValue(t[2], "Số Lượng", "T3");
    	    dataset.setValue(t[3], "Số Lượng", "T4");
    	    dataset.setValue(t[4], "Số Lượng", "T5");
    	    dataset.setValue(t[5], "Số Lượng", "T6");
    	    dataset.setValue(t[6], "Số Lượng", "T7");
    	    dataset.setValue(t[7], "Số Lượng", "T8");
    	    dataset.setValue(t[8], "Số Lượng", "T9");
    	    dataset.setValue(t[9], "Số Lượng", "T10");
    	    dataset.setValue(t[10], "Số Lượng", "T11");
    	    dataset.setValue(t[11], "Số Lượng", "T12");
    	    
    	    //create chart
    	    JFreeChart linechart = ChartFactory.createLineChart("Biểu đồ tăng trưởng KPI "+" năm "+cbNam.getSelectedItem().toString(),"Tháng","Tỷ lệ", 
    	            dataset, PlotOrientation.VERTICAL, false,true,false);
    	    
    	    //create plot object
    	     CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
    	   // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
    	    lineCategoryPlot.setBackgroundPaint(Color.white);
    	    
    	    //create render object to change the moficy the line properties like color
    	    LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
    	    Color lineChartColor = new Color(204,0,51);
    	    lineRenderer.setSeriesPaint(0, lineChartColor);
    	    
    	     //create chartPanel to display chart(graph)
    	    ChartPanel lineChartPanel = new ChartPanel(linechart);
    	    lineChartPanel.setPreferredSize(new Dimension(HEIGHT, 410));
    	    panelLineChart.removeAll();
    	    panelLineChart.setLayout(new MigLayout("", "[774px]", "[372px]"));
    	    panelLineChart.add(lineChartPanel, "cell 0 0,grow");
    	    lineChartPanel.setLayout(new BorderLayout(0, 0));
    	    panelLineChart.validate();
    	}
}
    public void initComponents()
    {
      setPreferredSize(new Dimension(1250, 780));
  	  setBackground(Color.decode("#004e92"));
//  	  String col[] = {"ID Công nhân","Tên công nhân","Tên công đoạn","Số lượng được giao","Số lượng hoàn thành"};
//  	  model = new DefaultTableModel(col,0);
  	  
  	  panelBarChart = new RoundPanel();
  	  panelBarChart.setRound(20);
  	  panelBarChart.setBackground(new Color(255, 255, 255));
  	  panelBarChart.setBounds(10, 364, 435, 406);
  	  panelLineChart = new RoundPanel();
      panelLineChart.setRound(20);
  	  panelLineChart.setBackground(new Color(255, 255, 255));
  	  panelLineChart.setBounds(455, 364, 785, 406);
  	  setLayout(null);
  	  add(panelBarChart);
  	  add(panelLineChart);

   // Bảng chấm công
   		tableThongKe = new Table();
   		  tableThongKe.setOpaque(false);
           // Cài đặt header cho table Chấm công
   		    tableThongKe.setModel(model = new DefaultTableModel(
   		    	new Object[][] {
   		    		{null, null, null, null, null},
   		    	},
   		    	new String[] {
   		    		"ID C\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng nh\u00E2n", "Ph\u00E2n x\u01B0\u1EDFng", "S\u1ED1 l\u01B0\u1EE3ng b\u00E0n giao", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u00E3 ho\u00E0n th\u00E0nh"
   		    	}
   		    ));
           
           JScrollPane scrollPane_TK = new JScrollPane();
           scrollPane_TK.setBackground(new Color(255, 255, 255));
           scrollPane_TK.setOpaque(false);
           scrollPane_TK.setBorder(new EmptyBorder(5, 5, 5, 5));
           scrollPane_TK.setViewportView(tableThongKe);
           tableThongKe.fixTable(scrollPane_TK);
           
           
           
           panelCenter = new RoundPanel();
   		   ((RoundPanel) panelCenter).setRound(20);
   		   panelCenter.setBackground(new Color(255, 255, 255));
   		   panelCenter.setBorder(new EmptyBorder(5, 15, 10, 10));
   		   panelCenter.setBounds(10, 75, 1230, 279);
           add(panelCenter);
           panelCenter.setLayout(new BorderLayout(0, 0));
           panelCenter.add(scrollPane_TK,BorderLayout.CENTER);
           
           panelListTK = new RoundPanel();
           panelListTK.setRound(10);
           panelListTK.setOpaque(false);
           panelListTK.setBackground(new Color(153, 204, 255));
//           scrollPane.setColumnHeaderView(panel_1);
           panelCenter.add(panelListTK,BorderLayout.NORTH);
           
           lbThongKe = new JLabel("Danh sách công nhân");
           lbThongKe.setFont(new Font("SansSerif", Font.PLAIN, 15));
           panelListTK.add(lbThongKe);
           
         
//      table_2.setPreferredScrollableViewportSize(new Dimension(400,500));
//      
//      add(pane);
      
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
      String data[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
      cbThang.setModel(new DefaultComboBoxModel<String>(data));
      cbThang.setSelectedItem(LocalDate.now().getMonthValue()+"");
      pNorth.add(cbThang);
      
       cbNam = new JComboBox();
       cbNam.setBackground(new Color(255, 255, 255));
      cbNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
      cbNam.setBounds(272, 15, 181, 28);
      String data_1[] = {"2023"};
      cbNam.setModel(new DefaultComboBoxModel(new String[] {"2010", "2011", "2012", "2013", "2014", "2015", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
      cbNam.setSelectedItem(LocalDate.now().getYear()+"");
      pNorth.add(cbNam);
      
     
      
      btnPrint = new MyButton();
		btnPrint.setText("Xuất Excel");
		btnPrint.setRadius(20);
		btnPrint.setBackground(Color.white);
		btnPrint.setFocusPainted(false);
      btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnPrint.setIcon(new ImageIcon(ThongKeKPI_Form.class.getResource("/icon/excel.png")));

      btnPrint.setBounds(1005, 10, 131, 38);
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
      lbNam.setBounds(215, 19, 58, 20);
      pNorth.add(lbNam);
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
		txtTimKiem.setBounds(492, 13, 408, 33);
		pNorth.add(txtTimKiem);
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchEmployee();
				if(tableThongKe.getRowCount()!=0)
			      {
			    	  thongKeTungNhanVienBieuDoTron(0);
			    	  thongKeTungNhanVienBieuDoTangTruong(0);
			      }
			}
		});
      tableThongKe.addMouseListener(this);
      cbThang.addActionListener(this);
      cbNam.addActionListener(this);
      hienThiDSThongKe();
      if(tableThongKe.getRowCount()!=0)
      {
    	  thongKeTungNhanVienBieuDoTron(0);
    	  thongKeTungNhanVienBieuDoTangTruong(0);
      }
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(cbThang) || o.equals(cbNam))
		{			
			hienThiDSThongKe();
			if(tableThongKe.getRowCount()!=0)
	        {
				thongKeTungNhanVienBieuDoTron(0);
		    	  thongKeTungNhanVienBieuDoTangTruong(0);
	        }
		 if(tableThongKe.getRowCount() == 0)
		{
           JOptionPane.showMessageDialog(this, "Tháng này chưa có chấm công!");
           double[] t = new double[20];
           for(int i = 0;i<19;i++)
           {
        	   t[i] = 0;
           }
           showLineChart(t, -1);
           showPieChart(0,-1);
		}
		}
		if (o.equals(btnPrint)) {
			String projectDirectory = System.getProperty("user.dir");
			String filePath = projectDirectory + "\\file\\file.xlsx";
			if (model.getRowCount() > 0) {
				if (exportToExcelAndCreateUI(tableThongKe, filePath)) {
					openExcelFile(filePath); // Mở tệp Excel nếu xuất thành công
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không có dữ liệu để xuất file");
			}

		}
	}
	private void hienThiDSThongKe() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		int month = Integer.parseInt(cbThang.getSelectedItem().toString());
		int year = Integer.parseInt(cbNam.getSelectedItem().toString());
		ArrayList<String> listCN = thongKeKPI_BUS.getListCNKPI(month, year);
		
		for (String string : listCN) {
			model.addRow(string.split(";"));
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableThongKe.getSelectedRow();
		if(row!=-1)
		{
			thongKeTungNhanVienBieuDoTron(row);
			thongKeTungNhanVienBieuDoTangTruong(row);
		}
	}
	private void thongKeTungNhanVienBieuDoTron(int row)
	{	
		    hienThiDSThongKe();
    		int soLuongSPDC = Integer.parseInt(tableThongKe.getValueAt(row, 3).toString());
    		int soLuongSPHT = Integer.parseInt(tableThongKe.getValueAt(row, 4).toString());
    	
        double tyle = ((soLuongSPHT*1.0) /(soLuongSPDC*1.0))*100;
    	showPieChart(tyle,row);
	}
	private void thongKeTungNhanVienBieuDoTangTruong(int row)
	{
		double[] t = new double[20];
		ArrayList<String> getListKPI = thongKeKPI_BUS.getKPICN(tableThongKe.getValueAt(row, 0).toString());
		String col[] = {"idCong Nhan","Hoten","thang","soLuongHT","SoLuongDG"};
		DefaultTableModel model = new DefaultTableModel(col,0);
	    JTable table = new JTable(model);
	    for (String string : getListKPI) {
			model.addRow(string.split(";"));
		}
	    	for(int j = 0 ;j < table.getRowCount();j++)
	    	{
	    	   int thang = Integer.parseInt(table.getValueAt(j, 2).toString());
	    	   int slht = Integer.parseInt(table.getValueAt(j, 3).toString());
	    	   int sldg = Integer.parseInt(table.getValueAt(j, 4).toString());
	           double tyle = ((slht*1.0)/(sldg*1.0))*100;
	           t[thang-1] = tyle;
	         }
	    	showLineChart(t,row);
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
			JOptionPane.showMessageDialog(this, "File đang được mở");
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
		sorter = new TableRowSorter<>(model);
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
