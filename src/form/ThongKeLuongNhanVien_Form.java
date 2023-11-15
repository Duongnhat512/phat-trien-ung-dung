package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
import commons.Table;
import connectDB.ConnectDB;
import entities.CongNhan;
import entities.PhongBan;

import javax.swing.JLabel;
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
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import java.awt.FlowLayout;
import javax.swing.JToolBar;

public class ThongKeLuongNhanVien_Form extends JPanel implements ActionListener{
     

	private JPanel panelNorth;
	private JPanel panelSouth;
    private  int width = 1250;
    private  int height = 777;
	private DefaultTableModel model;
    private Table tableThongKe;
	private JPanel panelBarChart;
	private JPanel panelLineChart;

	private RoundPanel panelCenter;
	private JComboBox cbThang;
	private JComboBox cbNam;
	private DefaultTableModel modelTK;
	private JButton btnThongKe;
	private ThongKeLuongNV_BUS thongKeLuongNV_BUS;
	private RoundPanel panelListTK;
	private JLabel lbThongKe;
	private JComboBox comBoPB;
	private PhongBan_BUS phongBan_BUS;
	public ThongKeLuongNhanVien_Form(int width, int height)
    { 
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
           

	 private void showBarChart(double[] t){
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
	        
	        JFreeChart chart = ChartFactory.createBarChart("Biểu Đồ Cột Thể Hiện Sự Tăng Trưởng Thu Nhập Theo Phòng Ban","Tháng","Lương (%)", 
	                dataset, PlotOrientation.VERTICAL, false,true,false);
	        
	        CategoryPlot categoryPlot = chart.getCategoryPlot();
	        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
	        categoryPlot.setBackgroundPaint(Color.WHITE);
	        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
	        Color clr3 = new Color(204,0,51);
	        renderer.setSeriesPaint(0, clr3);
	        
	        ChartPanel barpChartPanel = new ChartPanel(chart);
	        barpChartPanel.setBounds(-25, -17, 680, 442);
	        panelBarChart.removeAll();
	        panelBarChart.setLayout(null);
	        panelBarChart.setLayout(new BorderLayout(0, 0));
	        panelBarChart.add(barpChartPanel);
	        barpChartPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	        panelBarChart.validate();
	        
	        
	    }

	 private void showLineChart(double[] t){
	        //create dataset for the graph
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
	    
	        //create ch
	        JFreeChart linechart = ChartFactory.createLineChart("Biểu Đồ Tăng Trưởng Thu Nhập Theo Phòng Ban Năm "+cbNam.getSelectedItem().toString(),"Tháng","Lương(%)", 
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
	        panelLineChart.removeAll();
	        panelLineChart.setLayout(null);
	        panelLineChart.setLayout(new BorderLayout(0, 0));
	        panelLineChart.add(lineChartPanel);
	        lineChartPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	        panelLineChart.validate();
	        panelLineChart.setVisible(true);
	    }
    public void initComponents()
    {
      setPreferredSize(new Dimension(1250, 777));
      setBackground(Color.decode("#004e92"));
  	  panelBarChart = new JPanel();
  	  panelBarChart.setBackground(new Color(255, 255, 255));
  	  panelBarChart.setBounds(-12, 363, 615, 414);
  	  panelLineChart = new JPanel();
  	  panelLineChart.setBackground(new Color(255, 255, 255));
  	  panelLineChart.setBounds(621, 363, 629, 414);
  	  setLayout(null);
  	  add(panelBarChart);
  	  add(panelLineChart);

   // Bảng chấm công
   		tableThongKe = new Table();
   		  tableThongKe.setOpaque(false);
           // Cài đặt header cho table Chấm công
   		    tableThongKe.setModel(modelTK = new DefaultTableModel(
   		    	new Object[][] {
   		    		{null, null, null, null},
   		    	},
   		    	new String[] {
   		    		"ID Ph\u00F2ng Ban", "T\u00EAn ph\u00F2ng ban", "S\u1ED1 l\u01B0\u1EE3ng nh\u00E2n vi\u00EAn \u0111\u00E3 c\u00F3 l\u01B0\u01A1ng", "T\u1ED5ng L\u01B0\u01A1ng"
   		    	}
   		    ));
   		    tableThongKe.getColumnModel().getColumn(1).setPreferredWidth(92);
   		    tableThongKe.getColumnModel().getColumn(2).setPreferredWidth(89);
           
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
           panelCenter.add(scrollPane_TK,BorderLayout.CENTER);
           
           panelListTK = new RoundPanel();
           panelListTK.setRound(10);
           panelListTK.setOpaque(false);
           panelListTK.setBackground(new Color(153, 204, 255));
//           scrollPane.setColumnHeaderView(panel_1);
           panelCenter.add(panelListTK,BorderLayout.NORTH);
           
           lbThongKe = new JLabel("Danh sách lương theo phòng ban");
           lbThongKe.setFont(new Font("SansSerif", Font.PLAIN, 15));
           panelListTK.add(lbThongKe);

      JPanel pNorth = new JPanel();
      pNorth.setBackground(new Color(255, 255, 255));
      pNorth.setBounds(25, 0, 1199, 49);
      add(pNorth);
      pNorth.setLayout(null);
      
       cbThang = new JComboBox();
      cbThang.setFont(new Font("Tahoma", Font.PLAIN, 15));
      cbThang.setBounds(93, 15, 83, 28);
      String data[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
      cbThang.setModel(new DefaultComboBoxModel<String>(data));
      pNorth.add(cbThang);
      
       cbNam = new JComboBox();
      cbNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
      cbNam.setBounds(272, 15, 181, 28);
      String data_1[] = {"2023"};
      cbNam.setModel(new DefaultComboBoxModel<String>(data_1));
      pNorth.add(cbNam);
      
       btnThongKe = new JButton("Thống kê");
      btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnThongKe.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnThongKe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThongKeLuongNhanVien_Form.class.getResource("/icon/thongKe.png")).getScaledInstance(30, 25,Image.SCALE_SMOOTH)));
      
      
      btnThongKe.setBounds(853, 10, 154, 33);
      pNorth.add(btnThongKe);
      
      JButton btnXuatExcel = new JButton("Xuất ra excel");
      btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnXuatExcel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThongKeLuongNhanVien_Form.class.getResource("/icon/excel.png")).getScaledInstance(30, 25,Image.SCALE_SMOOTH)));

      btnXuatExcel.setBounds(1029, 10, 160, 33);
      pNorth.add(btnXuatExcel);
      
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
      
      JLabel lblLcTheoPhng = new JLabel("Lọc theo phòng ban:\r\n");
      lblLcTheoPhng.setHorizontalAlignment(SwingConstants.CENTER);
      lblLcTheoPhng.setFont(new Font("Tahoma", Font.PLAIN, 15));
      lblLcTheoPhng.setBounds(485, 15, 141, 27);
      pNorth.add(lblLcTheoPhng);
      
      comBoPB = new JComboBox();
      comBoPB.setBounds(636, 15, 181, 27);
      pNorth.add(comBoPB);
      
      comBoPB.addActionListener(this);
      btnXuatExcel.addActionListener(this);
      btnThongKe.addActionListener(this);
      
      duaDuLieuPbLenComBoBox();
  	  tinhTangTruong(Integer.parseInt(cbNam.getSelectedItem().toString()));
	  bieuDoCot(Integer.parseInt(cbNam.getSelectedItem().toString()));
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThongKe))
		{
			hienThiTable();
		
		}
		if(o.equals(comBoPB))
		{
			hienThiDsLuongPB();
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
			modelTK.addRow(string.split(";"));
		}
		tinhTangTruong(Integer.parseInt(cbNam.getSelectedItem().toString()));
	}
	private void tinhTangTruong(int year)
	{
		double[] t = new double[20];
		String col[] = {"idPB","TenPB","SLNV","TongLuong"};
		DefaultTableModel modeltest = new DefaultTableModel(col,0);
		JTable tableTest = new JTable(modeltest);
		double tongLuong=0;
		for(int i = 1 ;i <= 12;i++)
		{
			modeltest.setRowCount(0);
			ArrayList<String> listCN = thongKeLuongNV_BUS.getListLuongPB(i, year);
			
			for (String string : listCN) {
				modeltest.addRow(string.split(";"));
			}
			double luongTheoThang = 0;	
			for(int j = 0;j < tableTest.getRowCount();j++)
			{
                luongTheoThang += Double.parseDouble(tableTest.getValueAt(j, 3).toString());
                
			}	
			tongLuong += luongTheoThang;
			
		}
		for(int i = 1 ;i <= 12;i++)
		{
			modeltest.setRowCount(0);
			ArrayList<String> listCN = thongKeLuongNV_BUS.getListLuongPB(i, year);
			for (String string : listCN) {
				modeltest.addRow(string.split(";"));
			}
			double luongTheoThang = 0;	
			for(int j = 0;j < tableTest.getRowCount();j++)
			{
                luongTheoThang += Double.parseDouble(tableTest.getValueAt(j, 3).toString());
			}
			
			t[i-1] = (luongTheoThang / tongLuong )*100;
			
		}
		showLineChart(t);
	}
	private void bieuDoCot(int year)
	{
		double[] t = new double[20];
		String col[] = {"idPB","TenPB","SLNV","TongLuong"};
		DefaultTableModel modeltest = new DefaultTableModel(col,0);
		JTable tableTest = new JTable(modeltest);
		double tongLuong=0;
		for(int i = 1 ;i <= 12;i++)
		{
			modeltest.setRowCount(0);
			ArrayList<String> listCN = thongKeLuongNV_BUS.getListLuongPB(i, year);
			
			for (String string : listCN) {
				modeltest.addRow(string.split(";"));
			}
			double luongTheoThang = 0;	
			for(int j = 0;j < tableTest.getRowCount();j++)
			{
                luongTheoThang += Double.parseDouble(tableTest.getValueAt(j, 3).toString());
                
			}	
			tongLuong += luongTheoThang;
			
		}
		for(int i = 1 ;i <= 12;i++)
		{
			modeltest.setRowCount(0);
			ArrayList<String> listCN = thongKeLuongNV_BUS.getListLuongPB(i, year);
			for (String string : listCN) {
				modeltest.addRow(string.split(";"));
			}
			double luongTheoThang = 0;	
			for(int j = 0;j < tableTest.getRowCount();j++)
			{
                luongTheoThang += Double.parseDouble(tableTest.getValueAt(j, 3).toString());
			}
			
			t[i-1] = (luongTheoThang / tongLuong )*100;
			
		}
		showBarChart(t);
	}
   private void duaDuLieuPbLenComBoBox()
   {
	   comBoPB.addItem("Tất cả");
	   ArrayList<PhongBan> listpb = phongBan_BUS.getDSPB();
	   for (PhongBan phongBan : listpb) {
		comBoPB.addItem(phongBan.getTenPhongBan());
	}
   }
}

