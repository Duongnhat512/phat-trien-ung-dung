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

import commons.RoundPanel;
import commons.Table;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
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

public class ThongKeKPI_Form extends JPanel{
     

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
	public ThongKeKPI_Form(int width, int height)
    { 
    	this.width = width;
    	this.height = height;
           initComponents();
           showPieChart();
           showLineChart();

           
    }
public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "Đạt KPI" , new Double(  70) );  
      barDataset.setValue( "Không đạt" , new Double( 30 ) );   
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Tỷ lệ hoàn thành KPI",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setSectionPaint("Đạt KPI",new Color(255,255,102));
        piePlot.setSectionPaint("Không đạt", new Color(102,255,102));
       
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);


        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.NORTH);
        barChartPanel.setLayout(null);
        panelBarChart.validate();
    }
public void showLineChart(){
    //create dataset for the graph
     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.setValue(200, "Amount", "january");
    dataset.setValue(150, "Amount", "february");
    dataset.setValue(18, "Amount", "march");
    dataset.setValue(100, "Amount", "april");
    dataset.setValue(80, "Amount", "may");
    dataset.setValue(250, "Amount", "june");
    
    //create chart
    JFreeChart linechart = ChartFactory.createLineChart("contribution","monthly","amount", 
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
    panelLineChart.setLayout(new BorderLayout(0, 0));
    panelLineChart.add(lineChartPanel);
    lineChartPanel.setLayout(null);
    panelLineChart.validate();
}
    public void initComponents()
    {
      setPreferredSize(new Dimension(1250, 747));
  	  setBackground(Color.white);
//  	  String col[] = {"ID Công nhân","Tên công nhân","Tên công đoạn","Số lượng được giao","Số lượng hoàn thành"};
//  	  model = new DefaultTableModel(col,0);
  	  
  	  panelBarChart = new JPanel();
  	  panelBarChart.setBackground(new Color(255, 255, 255));
  	  panelBarChart.setBounds(31, 364, 598, 407);
  	  
  	   panelLineChart = new JPanel();
  	  panelLineChart.setBackground(new Color(255, 255, 255));
  	  panelLineChart.setBounds(626, 364, 598, 383);
  	  setLayout(null);
  	  add(panelBarChart);
  	  add(panelLineChart);
//      table_2 = new Table(new DefaultTableModel(
//      	new Object[][] {
//      		{"1", "3", "4", "5", "6"},
//      		{"2", "7", "8", "9", null},
//      		{"3", "4", "5", "6", "7"},
//      		{"6", "6", "6", "7", "8"},
//      		{"5", "4", "3", "2", "12"},
//      		{"2", "2", "2", "2", "2"},
//      		{"2", "2", "2", "2", "2"},
//      		{"2", "2", "2", "2", "2"},
//      		{null, "2", "2", "2", "2"},
//      		{"5", "4", "3", "2", "12"},
//      		{"2", "2", "2", "2", "2"},
//      		{"2", "2", "2", "2", "2"},
//      		{"2", "2", "2", "2", "2"},
//      		{null, "2", "2", "2", "2"},
//      		{"5", "4", "3", "2", "12"},
//      		{"2", "2", "2", "2", "2"},
//      		{"2", "2", "2", "2", "2"},
//      		{"2", "2", "2", "2", "2"},
//      		{null, "2", "2", "2", "2"},
//      		{"5", "4", "3", "2", "12"},
//      		{"2", "2", "2", "2", "2"},
//      		{"2", "2", "2", "2", "2"},
//      		{"2", "2", "2", "2", "2"},
//      		{null, "2", "2", "2", "2"},
//      	},
//      	new String[] {
//      		"ID C\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u01B0\u1EE3c giao", "S\u1ED1 l\u01B0\u1EE3ng ho\u00E0n th\u00E0nh"
//      	}
//      ));
//      table_2.setModel(new DefaultTableModel(
//          	new Object[][] {
//          		
//          	},
//          	new String[] {
//              		"ID C\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u01B0\u1EE3c giao", "S\u1ED1 l\u01B0\u1EE3ng ho\u00E0n th\u00E0nh"
//          	}
//          ));
//      table_2.setShowVerticalLines(false);
//      table_2.setSelectionBackground(new Color(232, 57, 95));
//      table_2.setIntercellSpacing(new Dimension(0, 0));
//      table_2.setFocusable(false);
//      table_2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
//      table_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
//      table_2.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
//      table_2.getTableHeader().setOpaque(false);
//      table_2.getTableHeader().setBackground(new Color(32,136,203));
//      table_2.getTableHeader().setForeground(new Color(255,255,255));
//      table_2.setRowHeight(25);
//      JScrollPane pane = new JScrollPane(table_2);
//      pane.setBounds(31, 73, 1198, 188);
//      
   // Bảng chấm công
   		tableThongKe = new Table();
   		  tableThongKe.setOpaque(false);
           // Cài đặt header cho table Chấm công
   		    tableThongKe.setModel(new DefaultTableModel(
   		    	new Object[][] {
   		    		{"1", "2", "3", "4", null, null, null},
   		    		{"2", null, null, null, null, null, null},
   		    		{null, null, null, null, null, null, null},
   		    		{null, null, null, null, null, null, null},
   		    		{null, null, null, null, null, null, null},
   		    	},
   		    	new String[] {
   		    		"ID ch\u1EA5m c\u00F4ng", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "ID nh\u00E2n vi\u00EAn", "H\u1ECD t\u00EAn", "Ph\u00F2ng Ban", "Tr\u1EA1ng th\u00E1i", "Ngh\u1EC9 ph\u00E9p"
   		    	}
   		    ));
           
           JScrollPane scrollPane_TK = new JScrollPane();
           scrollPane_TK.setBackground(new Color(255, 255, 255));
           scrollPane_TK.setOpaque(false);
           scrollPane_TK.setBorder(new EmptyBorder(5, 5, 5, 5));
           scrollPane_TK.setViewportView(tableThongKe);
           scrollPane_TK.setBounds(0, 0, 1198, 283);
           tableThongKe.fixTable(scrollPane_TK);
           panelCenter = new RoundPanel();
   		   ((RoundPanel) panelCenter).setRound(20);
   		   panelCenter.setBackground(new Color(255, 255, 255));
   		   panelCenter.setBorder(new EmptyBorder(5, 15, 10, 10));
   		   panelCenter.setBounds(31, 75, 1193, 279);
           add(panelCenter);
           panelCenter.setLayout(null);
           panelCenter.add(scrollPane_TK);
           
           
         
//      table_2.setPreferredScrollableViewportSize(new Dimension(400,500));
//      
//      add(pane);
      
      JPanel pNorth = new JPanel();
      pNorth.setBounds(31, 10, 1198, 66);
      add(pNorth);
      pNorth.setLayout(null);
      
      JComboBox cbThang = new JComboBox();
      cbThang.setFont(new Font("Tahoma", Font.PLAIN, 15));
      cbThang.setBounds(93, 15, 83, 28);
      String data[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
      cbThang.setModel(new DefaultComboBoxModel<String>(data));
      pNorth.add(cbThang);
      
      JComboBox cbNam = new JComboBox();
      cbNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
      cbNam.setBounds(272, 15, 181, 28);
      String data_1[] = {"2023"};
      cbNam.setModel(new DefaultComboBoxModel<String>(data_1));
      pNorth.add(cbNam);
      
      JButton btnThongKe = new JButton("Thống kê");
      btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnThongKe.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnThongKe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThongKeKPI_Form.class.getResource("/icon/search.png")).getScaledInstance(30, 25,Image.SCALE_SMOOTH)));
      
      
      btnThongKe.setBounds(484, 10, 130, 38);
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
      
      
      
      
    }
}

