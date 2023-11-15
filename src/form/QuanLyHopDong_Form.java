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
import dialog.ThemHopDong_Dialog;
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
import javax.swing.JDialog;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class QuanLyHopDong_Form extends RoundPanel implements ActionListener{

	private int width = 1259;
	private int height = 813;
	private RoundTextField textTimKiem;
	private Table tableHopDong;
	
	//
	private HopDongSanPham_BUS hopDongSanPham_BUS = new HopDongSanPham_BUS();
	private MyButton btnXemChiTiet;
	private MyButton btnCapNhat;
	private MyButton btnThem;
	
	
	/**
	 * Create the panel.
	 */
	public QuanLyHopDong_Form(int width, int height) {
		setRound(20);
		setBorder(new EmptyBorder(5, 0, 5, 0));
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
		btnThem.setIcon(new ImageIcon(QuanLyHopDong_Form.class.getResource("/icon/icons8_plus_math_30px.png")));
		btnThem.setText("Thêm");
		btnThem.setRadius(10);
		btnThem.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnThem.setFocusPainted(false);
		btnThem.setBackground(new Color(82, 125, 254));
		
		btnCapNhat = new MyButton();
		btnCapNhat.setIcon(new ImageIcon(QuanLyHopDong_Form.class.getResource("/icon/update.png")));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setRadius(10);
		btnCapNhat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setBackground(Color.WHITE);
		
		textTimKiem = new RoundTextField(10);
		textTimKiem.setText("Nhập tên hợp đồng cần tìm.....");
		textTimKiem.setBorder(new EmptyBorder(0, 15, 0, 0));
		textTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textTimKiem.setForeground(Color.GRAY);
		textTimKiem.setColumns(10);
		textTimKiem.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textTimKiem.getText().isEmpty()) {
					textTimKiem.setText("Nhập mã hợp đồng cần tìm.....");
					textTimKiem.setForeground(Color.GRAY);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(textTimKiem.getText().equals("Nhập mã hợp đồng cần tìm.....")) {
					textTimKiem.setText("");
					textTimKiem.setForeground(Color.BLACK);
				}
			}
		});
		
		btnXemChiTiet = new MyButton();
		btnXemChiTiet.setIcon(new ImageIcon(QuanLyHopDong_Form.class.getResource("/icon/show_property.png")));
		btnXemChiTiet.setText("Xem chi tiết");
		btnXemChiTiet.setRadius(10);
		btnXemChiTiet.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnXemChiTiet.setFocusPainted(false);
		btnXemChiTiet.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(textTimKiem, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
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
							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		RoundPanel panel_1_1 = new RoundPanel();
		panel_1_1.setRound(10);
		panel_1_1.setOpaque(false);
		panel_1_1.setBackground(new Color(153, 204, 255));
		
		JLabel lblNewLabel_1_1 = new JLabel("Danh sách hợp đồng");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		tableHopDong = new Table();
        tableHopDong.setOpaque(false);
        
        tableHopDong.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
            		"ID h\u1EE3p \u0111\u1ED3ng", "T\u00EAn h\u1EE3p \u0111\u1ED3ng", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc", "Nh\u00E2n vi\u00EAn ph\u1EE5 tr\u00E1ch", "T\u1ED5ng ti\u1EC1n h\u1EE3p \u0111\u1ED3ng", "Ghi ch\u00FA"
                	
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        tableHopDong.getColumnModel().getColumn(4).setPreferredWidth(120);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setOpaque(false);
        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane.setViewportView(tableHopDong);
        panelSouth.add(scrollPane);
        
        tableHopDong.fixTable(scrollPane);
        
        //Đăng ký sự kiện
        btnCapNhat.addActionListener(this);
        btnThem.addActionListener(this);
        btnXemChiTiet.addActionListener(this);
        setLayout(new BorderLayout(0, 0));
        add(panel, BorderLayout.NORTH);
        add(panelSouth);
        panelSouth.setLayout(new BorderLayout(0, 0));
        panelSouth.add(scrollPane);
        panelSouth.add(panel_1_1, BorderLayout.NORTH);
        panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_1_1.add(lblNewLabel_1_1);
        
        //
        docDuLieuLenTableHDSP();
	}
	
	
	/**
	 * Đọc dữ liệu lên table Hợp đồng sản phẩm
	 */
	private void docDuLieuLenTableHDSP() {
		ArrayList<HopDongSanPham> list = hopDongSanPham_BUS.getAllHopDongSanPham();
		DefaultTableModel dm = (DefaultTableModel) tableHopDong.getModel();
		for(HopDongSanPham hd : list) {
			dm.addRow(new Object[] {hd.getIdHopDong(), hd.getTenHopDong(), hd.getNgayBatDau(), hd.getNgayKetThuc(), hd.getNguoiQuanLy().getHoTen(), String.format("%,.2f", hd.getTongTien()), hd.getGhiChu()});
		}
	}
	
	private void moDialogThemHD() {
		ThemHopDong_Dialog themHopDong_Dialog = new ThemHopDong_Dialog();
		themHopDong_Dialog.openThemHopDong_Dialog((int) (this.width*0.75), this.height);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			moDialogThemHD();
		}
	}
}
