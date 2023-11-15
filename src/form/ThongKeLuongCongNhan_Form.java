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

import bus.ThongKeLuongCongNhan_BUS;
import bus.ThongKeLuongNV_BUS;
import commons.RoundPanel;
import commons.Table;
import connectDB.ConnectDB;

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

public class ThongKeLuongCongNhan_Form extends JPanel implements ActionListener{
     

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
    private ThongKeLuongCongNhan_BUS thongKeLuongCongNhan_BUS;
	private RoundPanel panelCenter;
	private JComboBox cbThang;
	private JComboBox cbNam;
	private JButton btnThongKe;
	private DefaultTableModel modelTK;
	public ThongKeLuongCongNhan_Form(int width, int height)
    { 
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
           

	 public void showBarChart(double[] t){
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
	        JFreeChart chart = ChartFactory.createBarChart("Biểu Đồ Cột Thể Hiện Sự Tăng Trưởng Thu Nhập Theo Phân Xưởng","Tháng","Lương (%)", 
	                dataset, PlotOrientation.VERTICAL, false,true,false);
	        
	        CategoryPlot categoryPlot = chart.getCategoryPlot();
	        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
	        categoryPlot.setBackgroundPaint(Color.WHITE);
	        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
	        Color clr3 = new Color(204,0,51);
	        renderer.setSeriesPaint(0, clr3);
	        
	        ChartPanel barpChartPanel = new ChartPanel(chart);
	        panelBarChart.removeAll();
	        panelBarChart.add(barpChartPanel, BorderLayout.CENTER);
	        panelBarChart.validate();
	        
	        
	    }
	 public void showLineChart(double t[]){
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
	        JFreeChart linechart = ChartFactory.createLineChart("Biểu Đồ Tăng Trưởng Thu Nhập Theo Phân Xưởng Năm "+cbNam.getSelectedItem().toString(),"Tháng","Lương(%)", 
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
	        lineChartPanel.setBounds(-27, 0, 645, 407);
	        panelLineChart.removeAll();
	        panelLineChart.setLayout(new FlowLayout());
	        panelLineChart.setLayout(new BorderLayout(0, 0));
	        panelLineChart.add(lineChartPanel);
	        panelLineChart.validate();
	        
	    }
    public void initComponents()
    {
      setPreferredSize(new Dimension(1250, 778));
  	  setBackground(Color.decode("#004e92"));
  	  panelBarChart = new RoundPanel();
  	 
  	  panelBarChart.setBackground(new Color(255, 255, 255));
  	  panelBarChart.setBounds(10, 364, 592, 407);
  	  panelLineChart = new RoundPanel();
  	
  	  panelLineChart.setBackground(new Color(255, 255, 255));
  	  panelLineChart.setBounds(612, 364, 628, 407);
  	  setLayout(null);
  	  add(panelBarChart);
  	  panelBarChart.setLayout(new BorderLayout(0, 0));
  	  add(panelLineChart);
      
   // Bảng chấm công
   		tableThongKe = new Table();
   		  tableThongKe.setOpaque(false);
           // Cài đặt header cho table Chấm công
   		    tableThongKe.setModel(modelTK = new DefaultTableModel(
   		    	new Object[][] {

   		    	},
   		    	new String[] {
   		    		"ID ph\u00E2n x\u01B0\u1EDFng", "T\u00EAn ph\u00E2n x\u01B0\u1EDFng", "S\u1ED1 l\u01B0\u1EE3ng c\u00F4ng nh\u00E2n", "T\u1ED5ng L\u01B0\u01A1ng"
   		    	}
   		    ));
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
           panelCenter.setLayout(null);
           panelCenter.add(scrollPane_TK);
   
           

      JPanel pNorth = new JPanel();
      pNorth.setBounds(10, 10, 1230, 55);
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
      btnThongKe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThongKeLuongCongNhan_Form.class.getResource("/icon/thongKe.png")).getScaledInstance(30, 25,Image.SCALE_SMOOTH)));
      
      
      btnThongKe.setBounds(484, 10, 154, 38);
      pNorth.add(btnThongKe);
      
      JButton btnXuatExcel = new JButton("Xuất ra excel");
      btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnXuatExcel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThongKeLuongCongNhan_Form.class.getResource("/icon/excel.png")).getScaledInstance(30, 25,Image.SCALE_SMOOTH)));

      btnXuatExcel.setBounds(663, 10, 160, 38);
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
      btnThongKe.addActionListener(this);
      tinhTangTruong(Integer.parseInt(cbNam.getSelectedItem().toString()));
	  hienThiBieuDoCot(Integer.parseInt(cbNam.getSelectedItem().toString()));
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThongKe))
		{
			hienThiTable();
		}
	}

	private void hienThiTable() {
		// TODO Auto-generated method stub
		modelTK.setRowCount(0);
		int month = Integer.parseInt(cbThang.getSelectedItem().toString());
		int year = Integer.parseInt(cbNam.getSelectedItem().toString());
		ArrayList<String> listPB = thongKeLuongCongNhan_BUS.getListLuongPX(month, year);
		for (String string : listPB) {
			modelTK.addRow(string.split(";"));
		}
		tinhTangTruong(Integer.parseInt(cbNam.getSelectedItem().toString()));
	}
	private void hienThiBieuDoCot(int year) {
		// TODO Auto-generated method stub
		double[] t = new double[20];
		String col[] = {"idPB","TenPB","SLNV","TongLuong"};
		DefaultTableModel modeltest = new DefaultTableModel(col,0);
		JTable tableTest = new JTable(modeltest);
		double tongLuong=0;
		for(int i = 1 ;i <= 12;i++)
		{
			modeltest.setRowCount(0);
			ArrayList<String> listCN = thongKeLuongCongNhan_BUS.getListLuongPX(i, year);
			
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
			ArrayList<String> listCN = thongKeLuongCongNhan_BUS.getListLuongPX(i, year);
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
	private void tinhTangTruong(int year)
	{
		double[] t = new double[20];
		String col[] = {"idPhanXuong","TenPX","SLCN","TongLuong"};
		DefaultTableModel modeltest = new DefaultTableModel(col,0);
		JTable tableTest = new JTable(modeltest);
		double tongLuong=0;
		for(int i = 1 ;i <= 12;i++)
		{
			modeltest.setRowCount(0);
			ArrayList<String> listCN = thongKeLuongCongNhan_BUS.getListLuongPX(i, year);
			
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
			ArrayList<String> listCN = thongKeLuongCongNhan_BUS.getListLuongPX(i, year);
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
}

