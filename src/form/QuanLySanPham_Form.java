package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

import bus.HopDongSanPham_BUS;
import commons.RoundPanel;
import commons.RoundTextField;
import commons.Table;
import dialog.ThemSanPham_Dialog;
import entities.HopDongSanPham;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import commons.MyButton;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLySanPham_Form extends JPanel implements ActionListener{

	private int width = 1259;
	private int height = 813;
	private RoundTextField textTimKiem;
	private Table tableSanPham;
	private MyButton btnXemChiTiet;
	private MyButton btnCapNhat;
	private MyButton btnLoc;
	private MyButton btnThem;
	
	//
	
	
	/**
	 * Create the panel.
	 */
	public QuanLySanPham_Form(int width, int height) {
		this.width = width;
		this.height = height;
		initPanel();
	}
	
	public void initPanel() {
		setPreferredSize(new DimensionUIResource(this.width, this.height));
		
		RoundPanel panelSouth = new RoundPanel();
		panelSouth.setBackground(Color.WHITE);
		
		RoundPanel panel = new RoundPanel();
		panel.setOpaque(false);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		
		btnThem = new MyButton();
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setIcon(new ImageIcon(QuanLySanPham_Form.class.getResource("/icon/icons8_plus_math_30px.png")));
		btnThem.setText("Thêm");
		btnThem.setRadius(10);
		btnThem.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnThem.setFocusPainted(false);
		btnThem.setBackground(new Color(82, 125, 254));
		
		btnLoc = new MyButton();
		btnLoc.setIcon(new ImageIcon(QuanLySanPham_Form.class.getResource("/icon/icons8_filter_25px_1.png")));
		btnLoc.setText("Lọc");
		btnLoc.setRadius(10);
		btnLoc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnLoc.setFocusPainted(false);
		btnLoc.setBackground(Color.WHITE);
		
		btnCapNhat = new MyButton();
		btnCapNhat.setIcon(new ImageIcon(QuanLySanPham_Form.class.getResource("/icon/update.png")));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setRadius(10);
		btnCapNhat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setBackground(Color.WHITE);
		
		textTimKiem = new RoundTextField(10);
		textTimKiem.setText("Nhập mã sản phẩm cần tìm.....");
		textTimKiem.setBorder(new EmptyBorder(0, 15, 0, 0));
		textTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textTimKiem.setForeground(Color.GRAY);
		textTimKiem.setColumns(10);
		textTimKiem.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textTimKiem.getText().isEmpty()) {
					textTimKiem.setText("Nhập mã sản phẩm cần tìm.....");
					textTimKiem.setForeground(Color.GRAY);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(textTimKiem.getText().equals("Nhập mã sản phẩm cần tìm.....")) {
					textTimKiem.setText("");
					textTimKiem.setForeground(Color.BLACK);
				}
			}
		});
		
		btnXemChiTiet = new MyButton();
		btnXemChiTiet.setIcon(new ImageIcon(QuanLySanPham_Form.class.getResource("/icon/show_property.png")));
		btnXemChiTiet.setText("Xem chi tiết");
		btnXemChiTiet.setRadius(10);
		btnXemChiTiet.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnXemChiTiet.setFocusPainted(false);
		btnXemChiTiet.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(83)
					.addComponent(textTimKiem, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
					.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnXemChiTiet, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnXemChiTiet, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textTimKiem, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1259, Short.MAX_VALUE)
				.addComponent(panelSouth, GroupLayout.DEFAULT_SIZE, 1259, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		
		RoundPanel panel_1_1 = new RoundPanel();
		panel_1_1.setRound(10);
		panel_1_1.setOpaque(false);
		panel_1_1.setBackground(new Color(153, 204, 255));
		
		JLabel lblNewLabel_1_1 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		setLayout(groupLayout);
		
		tableSanPham = new Table();
        tableSanPham.setOpaque(false);
        // Cài đặt header cho table Chấm công
        tableSanPham.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID sản phẩm", "Tên sản phẩm", "Chất liệu", "Đơn giá", "Đơn vị tính", "Ghi chú"
        	}
        ));
        tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(120);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setOpaque(false);
        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane.setViewportView(tableSanPham);
        panelSouth.add(scrollPane);
        
        tableSanPham.fixTable(scrollPane);
        GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
        gl_panel_1_1.setHorizontalGroup(
        	gl_panel_1_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1_1.createSequentialGroup()
        			.addGap(540)
        			.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(501, Short.MAX_VALUE))
        );
        gl_panel_1_1.setVerticalGroup(
        	gl_panel_1_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1_1.createSequentialGroup()
        			.addGap(5)
        			.addComponent(lblNewLabel_1_1)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_1_1.setLayout(gl_panel_1_1);
        GroupLayout gl_panelSouth = new GroupLayout(panelSouth);
        gl_panelSouth.setHorizontalGroup(
        	gl_panelSouth.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelSouth.createSequentialGroup()
        			.addGap(31)
        			.addGroup(gl_panelSouth.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
        				.addComponent(scrollPane))
        			.addContainerGap())
        );
        gl_panelSouth.setVerticalGroup(
        	gl_panelSouth.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelSouth.createSequentialGroup()
        			.addGap(8)
        			.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        			.addContainerGap())
        );
        panelSouth.setLayout(gl_panelSouth);
        
        //
        btnThem.addActionListener(this);
        btnCapNhat.addActionListener(this);
        btnLoc.addActionListener(this);
        btnXemChiTiet.addActionListener(this);
	}
	
	private void moThemSanPham_Dialog() {
		ThemSanPham_Dialog themSanPham_Dialog = new ThemSanPham_Dialog();
		themSanPham_Dialog.openThemSanPham_Dialog((int) (this.width*0.75), (int) (this.height*0.7));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			moThemSanPham_Dialog();
		}
	}
	
	
	
}
