package form;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import bus.CongDoanPhanCong_BUS;
import bus.CongNhan_BUS;
import commons.Table;
import entities.CongDoanPhanCong;
import entities.CongNhan;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import commons.RoundPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import commons.MyButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import commons.RoundTextField;

public class CongDoanPhanCong_Form extends JPanel {
	private int width = 1259;
	private int height = 813;
	private Table tableCongNhan;
	private Table tableSanPham;
	private MyButton btnPhanCong;
	private MyButton btnCapNhat;
	
	//
	private CongNhan_BUS congNhan_BUS = new CongNhan_BUS();
	private CongDoanPhanCong_BUS congDoanPhanCong_BUS = new CongDoanPhanCong_BUS();
	
	//
	private ArrayList<CongNhan> listCongNhan = new ArrayList<CongNhan>();
	
	/**
	 * Create the panel.
	 */
	public CongDoanPhanCong_Form() {
		initComponents();
	}
	
	private void initComponents() {
		setSize(new Dimension(width, height));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setPreferredSize(new Dimension(this.width, (int)(this.height * 0.5)));
		add(panelNorth, BorderLayout.NORTH);
		
		RoundPanel panelSanPham = new RoundPanel();
		panelSanPham.setBackground(new Color(255, 255, 255));
		panelSanPham.setRound(20);
		panelSanPham.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelSanPham.setBounds(0, 64, 346, 332);
		
		RoundPanel panelCN = new RoundPanel();
		panelCN.setBackground(new Color(255, 255, 255));
		panelCN.setBounds(352, 64, 347, 332);
		panelCN.setRound(20);
		panelCN.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		RoundPanel panelThongTin = new RoundPanel();
		panelThongTin.setBounds(709, 64, 528, 332);
		panelThongTin.setRound(20);
		panelThongTin.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelThongTin.setBackground(new Color(255, 255, 255));
		panelCN.setLayout(new BorderLayout(0, 0));
		
		RoundPanel panelCenter = new RoundPanel();
		panelCenter.setRound(20);
		panelCenter.setPreferredSize(new Dimension(1196, 487));
		panelCenter.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelCenter.setBackground(Color.WHITE);
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setBackground(Color.WHITE);
		panelCenter.add(scrollPane, BorderLayout.CENTER);
		
		Table tablePhanCong = new Table();
		tablePhanCong.setOpaque(false);
		scrollPane.setViewportView(tablePhanCong);
		
		tablePhanCong.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                	"ID Công nhân", "Tên công nhân", "Tên sản phẩm", "Tên công đoạn", "Số lượng được giao"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
		tablePhanCong.fixTable(scrollPane);
		
		RoundPanel panel_1 = new RoundPanel();
		panel_1.setRound(10);
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(153, 204, 255));
		panelCenter.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách phân công");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setOpaque(false);
		scrollPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCN.add(scrollPane2);
		
		tableCongNhan = new Table();
		tableCongNhan.setBorder(null);
		tableCongNhan.setOpaque(false);
		scrollPane2.setViewportView(tableCongNhan);
		tableCongNhan.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                	"ID Công nhân", "Tên công nhân", "Ca làm", "Phân xưởng"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
		tableCongNhan.fixTable(scrollPane2);
		panelNorth.setLayout(null);
		panelNorth.add(panelSanPham);
		panelSanPham.setLayout(new BorderLayout(0, 0));
		
		tableSanPham = new Table();
		tableSanPham.setOpaque(false);
		tableSanPham.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                	"Tên sản phẩm", "Tên công đoạn", "Số lượng cần chia"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setOpaque(false);
		scrollPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(tableSanPham);
		tableSanPham.fixTable(scrollPane_1);
		panelSanPham.add(scrollPane_1, BorderLayout.CENTER);
		
		RoundPanel panelTitleSP = new RoundPanel();
		panelTitleSP.setRound(10);
		panelTitleSP.setOpaque(false);
		panelTitleSP.setBackground(new Color(153, 204, 255));
		panelSanPham.add(panelTitleSP, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Danh sách công đoạn sản phẩm");
		lblNewLabel_1_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelTitleSP.add(lblNewLabel_1_1_2);
		panelNorth.add(panelCN);
		
		RoundPanel panel_1_1_1 = new RoundPanel();
		panel_1_1_1.setRound(10);
		panel_1_1_1.setOpaque(false);
		panel_1_1_1.setBackground(new Color(153, 204, 255));
		panelCN.add(panel_1_1_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Danh sách công nhân");
		lblNewLabel_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_1_1_1.add(lblNewLabel_1_1_1);
		panelNorth.add(panelThongTin);
		panelThongTin.setLayout(new BorderLayout(0, 0));
		
		RoundPanel panel_1_1 = new RoundPanel();
		panel_1_1.setRound(10);
		panel_1_1.setOpaque(false);
		panel_1_1.setBackground(new Color(153, 204, 255));
		panelThongTin.add(panel_1_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin phân công");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panelThongTin.add(panel_4, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("New label");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(463, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(269, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		btnCapNhat = new MyButton();
		btnCapNhat.setBounds(1096, 11, 141, 43);
		panelNorth.add(btnCapNhat);
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setRadius(10);
		btnCapNhat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setBackground(Color.WHITE);
		
		btnPhanCong = new MyButton();
		btnPhanCong.setBounds(949, 10, 141, 45);
		panelNorth.add(btnPhanCong);
		btnPhanCong.setText("Chấm công");
		btnPhanCong.setRadius(10);
		btnPhanCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnPhanCong.setFocusPainted(false);
		btnPhanCong.setBackground(Color.WHITE);
		
		RoundTextField txtTimKiemCN = new RoundTextField(10);
		txtTimKiemCN.setText("Nhập tên công nhân cần tìm...");
		txtTimKiemCN.setForeground(Color.GRAY);
		txtTimKiemCN.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTimKiemCN.setColumns(10);
		txtTimKiemCN.setBorder(new EmptyBorder(0, 15, 0, 0));
		txtTimKiemCN.setBounds(352, 19, 347, 35);
		panelNorth.add(txtTimKiemCN);
		
		RoundTextField txtTimKiemCDSP = new RoundTextField(10);
		txtTimKiemCDSP.setText("Nhập tên sản phẩm cần tìm...");
		txtTimKiemCDSP.setForeground(Color.GRAY);
		txtTimKiemCDSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTimKiemCDSP.setColumns(10);
		txtTimKiemCDSP.setBorder(new EmptyBorder(0, 15, 0, 0));
		txtTimKiemCDSP.setBounds(10, 19, 336, 35);
		panelNorth.add(txtTimKiemCDSP);
	}
	
	private void layDanhSachCongNhan() {
		listCongNhan = congNhan_BUS.getDanhSachCongNhan();
//		ArrayList<CongDoanPhanCong> temp = congDoanPhanCong_BUS.getDanhSachPhanCong();
	}
}
