package form;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;


import bus.CongDoanSanPham_BUS;
import bus.HopDongSanPham_BUS;
import bus.SanPham_BUS;
import commons.RoundPanel;
import commons.Table;
import connectDB.ConnectDB;
import entities.CongDoanSanPham;

import entities.SanPham;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class CongDoanSanPham_Form extends JPanel implements ActionListener{


	private Table tableSP;

	private Table tableCDSP;
	private DefaultTableModel modelSP;
	private DefaultTableModel modelCDSP;
	private JTextField txtHienThiIDSP;
	private JTextField txtHienThiTenSP;
	private JTextField txtHienThiLuongCD;
	private JTextField txtHienThiTenCD;
	private  int width = 1259;
	private  int height = 813;
	private  String idSP;
	private SanPham_BUS sp_bus;
	private JButton btnThem;
	private JButton btnCapNhat;
	private CongDoanSanPham_BUS cdsp_bus;

	private ArrayList<CongDoanSanPham> listCDSP;
	private JTextField txtIDSP;
	private JTextField txtTenSP;
	private JTextField txtTenCongDoan;
	private JTextField txtLuongCD;

	private JButton btnThemCD;

	private JButton btnHuy;

	private JButton btnCapNhatCD;

	private JDialog dialog;



	public CongDoanSanPham_Form(int width, int height) {
		this.width = width;
		this.height= height;
//		moDialogThemCDSP(idSP);
		giaoDienCDSP();
	}
	private void giaoDienCDSP() {
		try {
			ConnectDB.getInstance().connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sp_bus = new SanPham_BUS();
		cdsp_bus = new CongDoanSanPham_BUS();
		
		setForeground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1259,780));
		JPanel panel_CongDoanSanPham = new JPanel();
		panel_CongDoanSanPham.setBackground(new Color(213, 213, 213));
		
		panel_CongDoanSanPham.setLayout(null);
		
		JPanel panel_North = new JPanel();
		panel_North.setBackground(null);
		panel_North.setBounds(10, 10, 1239, 378);
		panel_CongDoanSanPham.add(panel_North);
		panel_North.setLayout(null);
		
		RoundPanel panel_BangSP = new RoundPanel();
		panel_BangSP.setBounds(0, 0, 612, 368);
		panel_BangSP.setBackground(new Color(255, 255, 255));
		panel_BangSP.setRound(30);
		panel_North.add(panel_BangSP);
		
		String[] headers = {"ID", "Tên sản phẩm"};
		modelSP = new DefaultTableModel(headers , 0);
		panel_BangSP.setLayout(null);
	

		tableSP = new Table();
		tableSP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableSP.setModel(modelSP);
		tableSP.getColumnModel().getColumn(1).setPreferredWidth(110);
		tableSP.setOpaque(false);
        // Cài đặt header cho table Chấm công
	
		
				
        
		JScrollPane scrollPaneSP = new JScrollPane();
		scrollPaneSP.setBounds(10, 50, 592, 308);
        scrollPaneSP.setBackground(new Color(255, 255, 255));
        scrollPaneSP.setOpaque(false);
        scrollPaneSP.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPaneSP.setViewportView(tableSP);
        panel_BangSP.add(scrollPaneSP);
        tableSP.fixTable(scrollPaneSP);
        
        RoundPanel panellblBangSP = new RoundPanel();
        panellblBangSP.setRound(30);
        panellblBangSP.setBackground(Color.CYAN);
        panellblBangSP.setBounds(10, 10, 592, 40);
        panel_BangSP.add(panellblBangSP);
        panellblBangSP.setLayout(new BorderLayout(0, 0));
        
        JLabel lblSp = new JLabel("Bảng sản phẩm");
        lblSp.setHorizontalAlignment(SwingConstants.CENTER);
        lblSp.setFont(new Font("Times New Roman", Font.BOLD, 25));
        panellblBangSP.add(lblSp, BorderLayout.CENTER);
		
		
		RoundPanel panel_ThongTinCD = new RoundPanel();
		panel_ThongTinCD.setBounds(622, 0, 617, 368);
		panel_ThongTinCD.setBackground(new Color(255, 255, 255));
		panel_ThongTinCD.setRound(30);
		panel_North.add(panel_ThongTinCD);
		panel_ThongTinCD.setLayout(null);
		
		RoundPanel panellblTTCDSP = new RoundPanel();
		panellblTTCDSP.setBounds(10, 10, 597, 40);
		panellblTTCDSP.setRound(30);
		panellblTTCDSP.setBackground(Color.CYAN);
		panel_ThongTinCD.add(panellblTTCDSP);
		panellblTTCDSP.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTTCDSP = new JLabel("Thông tin công đoạn");
		lblTTCDSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblTTCDSP.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panellblTTCDSP.add(lblTTCDSP, BorderLayout.CENTER);
		
		RoundPanel panelbtnThemCapNhat = new RoundPanel();
		panelbtnThemCapNhat.setRound(30);
		panelbtnThemCapNhat.setBackground(new Color(215, 215, 215));
		panelbtnThemCapNhat.setBounds(10, 55, 597, 303);
		panel_ThongTinCD.add(panelbtnThemCapNhat);
		panelbtnThemCapNhat.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(0, 255, 0));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 20));
	
		btnThem.setBounds(102, 259, 150, 30);
		panelbtnThemCapNhat.add(btnThem);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(new Color(0, 0, 0));
		btnCapNhat.setBackground(new Color(0, 255, 0));
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCapNhat.setBounds(354, 257, 150, 30);
		panelbtnThemCapNhat.add(btnCapNhat);
		
		JLabel lbl_hienThiIDSP = new JLabel("ID sản phẩm:");
		lbl_hienThiIDSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_hienThiIDSP.setBounds(20, 150, 163, 25);
		panelbtnThemCapNhat.add(lbl_hienThiIDSP);
		
		txtHienThiIDSP = new JTextField();
		txtHienThiIDSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiIDSP.setEditable(false);
		txtHienThiIDSP.setBorder(null);
		txtHienThiIDSP.setBounds(193, 150, 380, 25);
		txtHienThiIDSP.setBackground(null);
		panelbtnThemCapNhat.add(txtHienThiIDSP);
		txtHienThiIDSP.setColumns(10);
		
		JLabel lbl_hienThiTenSanPham = new JLabel("Tên sản phẩm:");
		lbl_hienThiTenSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_hienThiTenSanPham.setBounds(20, 210, 163, 25);
		panelbtnThemCapNhat.add(lbl_hienThiTenSanPham);
		
		txtHienThiTenSP = new JTextField();
		txtHienThiTenSP.setEditable(false);
		txtHienThiTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiTenSP.setColumns(10);
		txtHienThiTenSP.setBorder(null);
		txtHienThiTenSP.setBackground(null);
		txtHienThiTenSP.setBounds(193, 210, 380, 25);
		panelbtnThemCapNhat.add(txtHienThiTenSP);
		
		txtHienThiLuongCD = new JTextField();
		txtHienThiLuongCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiLuongCD.setEditable(false);
		txtHienThiLuongCD.setColumns(10);
		txtHienThiLuongCD.setBorder(null);
		txtHienThiLuongCD.setBackground(null);
		txtHienThiLuongCD.setBounds(193, 90, 380, 25);
		panelbtnThemCapNhat.add(txtHienThiLuongCD);
		
		JLabel lbl_hienThiLuongCD = new JLabel("Lương công đoạn:");
		lbl_hienThiLuongCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_hienThiLuongCD.setBounds(20, 90, 163, 25);
		panelbtnThemCapNhat.add(lbl_hienThiLuongCD);
		
		txtHienThiTenCD = new JTextField();
		txtHienThiTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiTenCD.setEditable(false);
		txtHienThiTenCD.setBorder(null);
		txtHienThiTenCD.setColumns(10);
		txtHienThiTenCD.setBackground(null);
		txtHienThiTenCD.setBounds(193, 30, 380, 25);
		panelbtnThemCapNhat.add(txtHienThiTenCD);
		
		JLabel lbl_hienThiTenCongDoan = new JLabel("Tên công đoạn:");
		lbl_hienThiTenCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_hienThiTenCongDoan.setBounds(20, 30, 163, 25);
		panelbtnThemCapNhat.add(lbl_hienThiTenCongDoan);
		
		RoundPanel panel_South = new RoundPanel();
		panel_South.setRound(30);
		panel_South.setBounds(10, 388, 1239, 378);
		panel_South.setBackground(new Color(255, 255, 255));
		panel_CongDoanSanPham.add(panel_South);
		panel_South.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 1219, 318);
		panel_South.add(scrollPane);
		
		String[] headers_CDSP = {"Tên công đoạn", "Tên sản phẩm", "Lương công đoạn"};
		modelCDSP = new DefaultTableModel(headers_CDSP , 0);
	

		tableCDSP = new Table();
		tableCDSP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableCDSP.setOpaque(false);
        // Cài đặt header cho table Chấm công
		tableCDSP.setModel(modelCDSP);
		tableCDSP.getColumnModel().getColumn(2).setPreferredWidth(142);
        setLayout(new BorderLayout(0, 0));
		
				
        
	
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setOpaque(false);
        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane.setViewportView(tableCDSP);
     
        tableCDSP.fixTable(scrollPane);
        
        JLabel lblBangCongDoanSp = new JLabel("Bảng công đoạn sản phẩm");
        lblBangCongDoanSp.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblBangCongDoanSp.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        RoundPanel panelBangCongDoanSp = new RoundPanel();
        panelBangCongDoanSp.setBackground(new Color(0, 255, 255));
        panelBangCongDoanSp.setRound(30);
        panelBangCongDoanSp.setBounds(10, 10, 1219, 40);
        panelBangCongDoanSp.setLayout(new BorderLayout(0, 0));
        panelBangCongDoanSp.add(lblBangCongDoanSp);
        panel_South.add(panelBangCongDoanSp);
        
        docDuLieuDataLenTableSP();
        	
        tableSP.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
        		modelCDSP.setRowCount(0);
        		int n = tableSP.getSelectedRow();
        		idSP = tableSP.getValueAt(n, 0).toString();
        		docDuLieuDataLenTableCDSPTheoSP(idSP);
        	}
		});
        
        tableCDSP.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
        		hienThiThongTinCD();
        		
        	}
		});
        btnThem.addActionListener(this);
        btnCapNhat.addActionListener(this);
        this.add(panel_CongDoanSanPham);
	}
		
	
	private void docDuLieuDataLenTableSP() {
		ArrayList<SanPham> listSP = sp_bus.getAllSanPham();
		for (SanPham sp : listSP) {
			modelSP.addRow(new Object[] {	
				sp.getIdSanPham(),
				sp.getTenSanPham()
	
			});
		}
	}
	private void docDuLieuDataLenTableCDSPTheoSP(String id) {
		listCDSP = cdsp_bus.getCongDoanTheoSP(id);
		for (CongDoanSanPham cdSP : listCDSP) {
			modelCDSP.addRow(new Object[] {	
				cdSP.getTenCongDoan(),
				cdSP.getSanPham().getTenSanPham(),
				cdSP.getLuongCongDoan()

			});
		}
	}
	private void hienThiThongTinCD() {
		int n = tableCDSP.getSelectedRow();
		txtHienThiIDSP.setText(idSP);
		txtHienThiTenCD.setText(modelCDSP.getValueAt(n, 0).toString());
		txtHienThiTenSP.setText(modelCDSP.getValueAt(n, 1).toString());
		txtHienThiLuongCD.setText(modelCDSP.getValueAt(n, 2).toString());
	}
	private void moDialogThemCDSP(String idsp) {
		dialog = new JDialog();
		dialog.setBackground(new Color(223, 223, 223));
		dialog.setTitle("Thêm công đoạn");
        dialog.setSize(748, 372);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setLayout(null);
        
        JLabel lblidSP = new JLabel("ID sản phẩm: ");
        lblidSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblidSP.setBounds(10, 30, 152, 25);
        dialog.add(lblidSP);
        
        JLabel lblTenSP = new JLabel("Tên sản phẩm: ");
        lblTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblTenSP.setBounds(10, 90, 152, 25);
        dialog.add(lblTenSP);
        
        JLabel lblTenCongDoan = new JLabel("Tên công đoạn: ");
        lblTenCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblTenCongDoan.setBounds(10, 150, 152, 25);
        dialog.add(lblTenCongDoan);
        
        JLabel lblLuongCongDoan = new JLabel("Lương công đoạn: ");
        lblLuongCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblLuongCongDoan.setBounds(10, 210, 152, 25);
        dialog.add(lblLuongCongDoan);
        
        txtIDSP = new JTextField();
        txtIDSP.setEditable(false);
        txtIDSP.setText(idsp);
        txtIDSP.setBackground(null);
        txtIDSP.setBorder(null);
        txtIDSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtIDSP.setBounds(176, 30, 548, 25);
        dialog.add(txtIDSP);
        txtIDSP.setColumns(10);
        
        txtTenSP = new JTextField();
        txtTenSP.setEditable(false);
        String tenSP = sp_bus.getSanPhamTheoID(idsp).getTenSanPham();
        txtTenSP.setText(tenSP);
        txtTenSP.setBackground(null);
        txtTenSP.setBorder(null);
        txtTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtTenSP.setColumns(10);
        txtTenSP.setBounds(176, 90, 548, 25);
        dialog.add(txtTenSP);
        
        txtTenCongDoan = new JTextField();
        txtTenCongDoan.setBackground(null);
        txtTenCongDoan.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        txtTenCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtTenCongDoan.setColumns(10);
        txtTenCongDoan.setBounds(172, 150, 548, 25);
        dialog.add(txtTenCongDoan);
        
        txtLuongCD = new JTextField();
        txtLuongCD.setBackground(null);
        txtLuongCD.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        txtLuongCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtLuongCD.setColumns(10);
        txtLuongCD.setBounds(176, 210, 548, 25);
        dialog.add(txtLuongCD);
        
        btnThemCD = new JButton("Thêm");
        btnThemCD.setBackground(new Color(0, 255, 0));
        btnThemCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnThemCD.setBounds(127, 285, 150, 30);
        dialog.add(btnThemCD);
        
        btnHuy = new JButton("Hủy");
        btnHuy.setBackground(new Color(255, 0, 0));
        btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnHuy.setBounds(431, 285, 150, 30);
        dialog.add(btnHuy);
        
        btnCapNhatCD = new JButton("Cập nhật");
        btnCapNhatCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnCapNhatCD.setBackground(Color.GREEN);
        btnCapNhatCD.setBounds(127, 285, 150, 30); 
        dialog.add(btnCapNhatCD);
        btnCapNhatCD.addActionListener(this);
        btnThemCD.addActionListener(this);
        btnHuy.addActionListener(this);

	}
	
	private String sinhMaCD() {
		int stt = 1;
		ArrayList<CongDoanSanPham>  list= cdsp_bus.getDSCongDoan();
		String id="CD" + String.format("%04d",  stt);
		for (CongDoanSanPham cd : list) {
			if(cd.getIdCongDoan().equals(id)) {
				stt++;
				id="CD" + String.format("%04d",  stt);
			}
		}
		return id;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			int r = tableSP.getSelectedRow();
			if(r == -1) {
				
				JOptionPane.showMessageDialog(null, "Chọn 1 sản phẩm để thêm công đoạn!");
		    }
			else {
				moDialogThemCDSP(idSP);
				btnThemCD.setVisible(true);
				btnCapNhatCD.setVisible(false);
			}
			
		}
		if(o.equals(btnHuy)) {
			dialog.setVisible(false);
		}
		if(o.equals(btnCapNhat)) {
			
			int r = tableCDSP.getSelectedRow();
			if(r == -1) {
				
				JOptionPane.showMessageDialog(null, "Chọn 1 công đoạn để cập nhật!");
		    }
			else {
				moDialogThemCDSP(idSP);
				btnCapNhatCD.setVisible(true);
				btnThemCD.setVisible(false);
				String tenCDSP = modelCDSP.getValueAt(r, 0).toString();
				txtTenCongDoan.setText(tenCDSP);
				String luongCD = modelCDSP.getValueAt(r, 2).toString();
				txtLuongCD.setText(luongCD);
			}
			
		}
		if(o.equals(btnThemCD)) {
			String maCD = sinhMaCD();
			String tenCD = txtTenCongDoan.getText();
			double luongCD = Double.parseDouble(txtLuongCD.getText());
			String idSanPham = txtIDSP.getText();
			SanPham sp = sp_bus.getSanPhamTheoID(idSanPham);
			CongDoanSanPham cdsp = new CongDoanSanPham(maCD, tenCD, luongCD, sp);
			cdsp_bus.create(cdsp);
			modelCDSP.setRowCount(0);
			docDuLieuDataLenTableCDSPTheoSP(idSanPham);
			dialog.setVisible(false);
			int m = cdsp_bus.getCongDoanTheoSP(idSanPham).indexOf(cdsp);
			tableCDSP.setRowSelectionInterval(m, m);
			tableCDSP.scrollRectToVisible(tableCDSP.getCellRect(m, m, true));
			hienThiThongTinCD();
		}
		if(o.equals(btnCapNhatCD)) {
			String maCD = listCDSP.get(tableCDSP.getSelectedRow()).getIdCongDoan();
			String tenCD = txtTenCongDoan.getText();
			double luongCD = Double.parseDouble(txtLuongCD.getText());
			String idSanPham = txtIDSP.getText();
			SanPham sp = sp_bus.getSanPhamTheoID(idSanPham);
			CongDoanSanPham cdsp = new CongDoanSanPham(maCD, tenCD, luongCD, sp);
			cdsp_bus.update(cdsp);
			modelCDSP.setRowCount(0);
			docDuLieuDataLenTableCDSPTheoSP(idSanPham);
			dialog.setVisible(false);
			int m = cdsp_bus.getCongDoanTheoSP(idSanPham).indexOf(cdsp);
			tableCDSP.setRowSelectionInterval(m, m);
			tableCDSP.scrollRectToVisible(tableCDSP.getCellRect(m, m, true));
			hienThiThongTinCD();
		}
	}
}
