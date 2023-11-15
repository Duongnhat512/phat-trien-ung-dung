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
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.raven.datechooser.DateChooser;
import com.toedter.calendar.JDateChooser;

import bus.CongNhan_BUS;
import bus.ThongKeKPI_BUS;
import commons.RoundPanel;
import commons.Table;
import connectDB.ConnectDB;
import entities.CongNhan;

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

public class ThongKeKPI_Form extends JPanel implements ActionListener{
     

	private JPanel panelNorth;
	private JPanel panelSouth;
    private  int width = 1250;
    private  int height = 725;
	private DefaultTableModel model;
    private Table table_2;
    private Table tableThongKe;
	private JTextField textField;
	private JPanel panelBarChart;
	private JPanel panelLineChart;
	private JComponent lblNewLabel_1;
	private JComponent panelCenter;
	private RoundPanel panelListTK;
	private JLabel lbThongKe;
	private JButton btnThongKe;
	private ThongKeKPI_BUS thongKeKPI_BUS;
	private JComboBox cbThang;
	private JComboBox cbNam;
	private CongNhan_BUS congNhan_BUS;
	
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
	private void showPieChart(double tyle){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "Đạt KPI" , tyle );  
      barDataset.setValue( "Không đạt" , 100 - tyle );   
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Tỷ lệ hoàn thành KPI tháng "+cbThang.getSelectedItem().toString(),barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setSectionPaint("Đạt KPI",new Color(102,255,102));
        piePlot.setSectionPaint("Không đạt", new Color(255,0,0));
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        barChartPanel.setBounds(0, 0, 423, 388);
        panelBarChart.removeAll();
        panelBarChart.setLayout(new FlowLayout());
        panelBarChart.add(barChartPanel);
        barChartPanel.setLayout(new BorderLayout(0, 0));
        panelBarChart.validate();
    }
    private void showLineChart(double[] t){
    //create dataset for the graph
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
    JFreeChart linechart = ChartFactory.createLineChart("Biểu đồ tăng trưởng KPI từng tháng của năm "+cbNam.getSelectedItem().toString(),"Tháng","Tỷ lệ", 
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
    panelLineChart.setLayout(new BorderLayout());
    panelLineChart.add(lineChartPanel);
    lineChartPanel.setLayout(null);
    panelLineChart.validate();
}
    public void initComponents()
    {
      setPreferredSize(new Dimension(this.width, this.height));
  	  setBackground(Color.decode("#004e92"));
//  	  String col[] = {"ID Công nhân","Tên công nhân","Tên công đoạn","Số lượng được giao","Số lượng hoàn thành"};
//  	  model = new DefaultTableModel(col,0);
  	  
  	  panelBarChart = new JPanel();
  	  panelBarChart.setBackground(new Color(255, 255, 255));
  	  panelBarChart.setBounds(31, 364, 414, 407);
  	  panelLineChart = new JPanel();
  	  panelLineChart.setBackground(new Color(255, 255, 255));
  	  panelLineChart.setBounds(455, 364, 774, 407);
  	  setLayout(null);
  	  add(panelBarChart);
  	  add(panelLineChart);
  	  panelLineChart.setLayout(new BorderLayout(0, 0));

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
   		   panelCenter.setBounds(31, 75, 1193, 279);
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
      
      JPanel pNorth = new JPanel();
      pNorth.setBounds(31, 10, 1198, 55);
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
      cbNam.setModel(new DefaultComboBoxModel(new String[] {"2010", "2011", "2012", "2013", "2014", "2015", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
      pNorth.add(cbNam);
      
       btnThongKe = new JButton("Thống kê");
      btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnThongKe.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnThongKe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThongKeKPI_Form.class.getResource("/icon/thongKe.png")).getScaledInstance(30, 25,Image.SCALE_SMOOTH)));
      
      
      btnThongKe.setBounds(484, 10, 148, 38);
      pNorth.add(btnThongKe);
      
      JButton btnXuatExcel = new JButton("Xuất ra excel");
      btnXuatExcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnXuatExcel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThongKeKPI_Form.class.getResource("/icon/excel.png")).getScaledInstance(30, 25,Image.SCALE_SMOOTH)));

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
    
      cbNam.setSelectedIndex(14);
      cbThang.setSelectedIndex(10);
      btnThongKe.addActionListener(this);
//      tinhTangTruong(Integer.parseInt(cbNam.getSelectedItem().toString()));
      tinhTangTruong(Integer.parseInt(cbNam.getSelectedItem().toString()));
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThongKe))
		{
			hienThibieuDo();
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
	
	private void tinhTangTruong(int year)
	{
		double[] t = new double[20];
		String col[] = {"idCong Nhan","Hoten","PhanXuong","soLuongDG","SoLuongHT"};
		DefaultTableModel modeltest = new DefaultTableModel(col,0);
		JTable tableTest = new JTable(model);
		for(int i = 1 ;i <= 12;i++)
		{
			modeltest.setRowCount(0);
			ArrayList<String> listCN = thongKeKPI_BUS.getListCNKPI(i, year);
			for (String string : listCN) {
				modeltest.addRow(string.split(";"));
			}
			double soLuongCNdatKPI = 0;
			try {
				for (int j = 0; j < modeltest.getRowCount(); j++) {
					int soLuongSPDC = Integer.parseInt(tableTest.getValueAt(j, 3).toString());
					int soLuongSPHT = Integer.parseInt(tableTest.getValueAt(j, 4).toString());
					if (soLuongSPDC < soLuongSPHT) {
						soLuongCNdatKPI++;
					}
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
			ArrayList<CongNhan> cn = congNhan_BUS.getDanhSachCongNhan();
	    	double soLuongCN = cn.size();
	    	
	        t[i-1] = (soLuongCNdatKPI / soLuongCN)*100;
		}
		showLineChart(t);
	}
	private void hienThibieuDo()
	{
		hienThiDSThongKe();
    	double soLuongCNdatKPI = 0;
    	for(int i = 0; i < tableThongKe.getRowCount();i++)
    	{
    		int soLuongSPDC = Integer.parseInt(tableThongKe.getValueAt(i, 3).toString());
    		
    		int soLuongSPHT = Integer.parseInt(tableThongKe.getValueAt(i, 4).toString());
    		
    		if(soLuongSPDC<soLuongSPHT)
    		{
    			soLuongCNdatKPI++;
    		}
    	}
    	ArrayList<CongNhan> cn = congNhan_BUS.getDanhSachCongNhan();
    	double soLuongCN = cn.size();
    	
        double tyle = (soLuongCNdatKPI / soLuongCN)*100;
    	showPieChart(tyle);
	}
}

