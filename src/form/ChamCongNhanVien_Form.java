package form;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import commons.RoundPanel;
import commons.Table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class ChamCongNhanVien_Form extends JPanel {
	private RoundPanel panelCenterLeft;
	private RoundPanel panelSouth;
	private int width = 1259;
	private int height = 813;
	private Table tableCongNhan;
	private Table tableNhanVien;
	private Table tableChamCong;
	private RoundPanel panelNV;
	private JLabel lbListNV;
	private RoundPanel panelListCC;
	private JLabel lbChamCong;
	private JPanel panel_2;
	private JTextField txtIDNV;
	private JTextField txtTenNV;
	private JTextField textField_1;
	private JDateChooser dateChooser;
	/**
	 * Create the panel.
	 */
	public ChamCongNhanVien_Form(int width, int height) {
		setBackground(new Color(240, 240, 240));
		this.width = width;
		this.height = height;
		initPanel();
	}
	
	private void initPanel() {
		setPreferredSize(new Dimension(1259, 813));
//		setRound(20);

		panelCenterLeft = new RoundPanel();
		panelCenterLeft.setRound(20);
		panelCenterLeft.setBackground(new Color(255, 255, 255));
		panelCenterLeft.setBorder(new EmptyBorder(5, 15, 10, 10));
		
		panelSouth = new RoundPanel();
		panelSouth.setLayout(new BorderLayout());
		panelSouth.setBackground(new Color(255, 255, 255));
		panelSouth.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelSouth.setPreferredSize(new Dimension((int) (this.width * 0.95), (int) (this.height * 0.6)));
		panelSouth.setRound(20);
		
		RoundPanel panelCenterRight = new RoundPanel();
		panelCenterRight.setRound(20);
		panelCenterRight.setPreferredSize(new Dimension(1259, 325));
		panelCenterRight.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCenterRight.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelSouth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panelCenterLeft, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelCenterRight, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenterLeft, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelCenterRight, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		RoundPanel panelThongTin = new RoundPanel();
		panelThongTin.setRound(10);
		panelThongTin.setOpaque(false);
		panelThongTin.setBackground(new Color(153, 204, 255));
		
		JLabel lblThngTinChamCong = new JLabel("Thông tin chấm công");
		lblThngTinChamCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelThongTin.add(lblThngTinChamCong);
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GroupLayout gl_panelCenterRight = new GroupLayout(panelCenterRight);
		gl_panelCenterRight.setHorizontalGroup(
			gl_panelCenterRight.createParallelGroup(Alignment.LEADING)
				.addComponent(panelThongTin, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
		);
		gl_panelCenterRight.setVerticalGroup(
			gl_panelCenterRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenterRight.createSequentialGroup()
					.addComponent(panelThongTin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(null);
		panelCenterRight.setLayout(gl_panelCenterRight);
		panelCenterLeft.setLayout(new BorderLayout(0, 0));
		panelSouth.setLayout(new BorderLayout(0, 0));
		setLayout(groupLayout);	
		JLabel lbIDNhanVien = new JLabel("ID Nhân Viên:");
		lbIDNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbIDNhanVien.setBounds(29, 24, 108, 24);
		panel_2.add(lbIDNhanVien);
		
		txtIDNV = new JTextField();
		txtIDNV.setBounds(145, 25, 210, 29);
		panel_2.add(txtIDNV);
		txtIDNV.setColumns(10);
		
		JButton btnChamCong = new JButton("Chấm công");
		btnChamCong.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChamCong.setBounds(29, 254, 204, 36);
		panel_2.add(btnChamCong);
		
		JButton btnSetALL = new JButton("Có mặt tất cả");
		btnSetALL.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSetALL.setBounds(243, 210, 146, 36);
		panel_2.add(btnSetALL);
		
		JButton btnGetList = new JButton("Lấy danh sách chấm công");
		btnGetList.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGetList.setBounds(29, 210, 204, 36);
		panel_2.add(btnGetList);
		
		JLabel lbTenNV = new JLabel("Tên nhân viên:");
		lbTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbTenNV.setBounds(29, 72, 103, 24);
		panel_2.add(lbTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(145, 73, 210, 29);
		panel_2.add(txtTenNV);
		
		JLabel lbNgayCong = new JLabel("Ngày công:");
		lbNgayCong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbNgayCong.setBounds(29, 119, 108, 21);
		panel_2.add(lbNgayCong);
		
//		textField_1 = new JTextField();
//		textField_1.setColumns(10);
//		textField_1.setBounds(145, 118, 210, 29);
		dateChooser = new JDateChooser();
		dateChooser.setBounds(145, 118, 210, 29);
		panel_2.add(dateChooser);
		
		JLabel lblPhongBan = new JLabel("Phòng ban:");
		lblPhongBan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhongBan.setBounds(29, 165, 108, 21);
		panel_2.add(lblPhongBan);
		
		JComboBox cbPhongBan = new JComboBox();
		cbPhongBan.setBounds(145, 164, 210, 29);
		panel_2.add(cbPhongBan);
		
		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTrangThai.setBounds(379, 26, 108, 21);
		panel_2.add(lblTrangThai);
		
		JRadioButton radCoMat = new JRadioButton("Có mặt");
		radCoMat.setBackground(new Color(255, 255, 255));
		radCoMat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radCoMat.setBounds(464, 26, 103, 21);
		panel_2.add(radCoMat);
		
		JRadioButton radVang = new JRadioButton("Vắng mặt");
		radVang.setBackground(new Color(255, 255, 255));
		radVang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radVang.setBounds(464, 64, 103, 21);
		panel_2.add(radVang);
		
		JRadioButton radCoPhep = new JRadioButton("Có phép");
		radCoPhep.setBackground(new Color(255, 255, 255));
		radCoPhep.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radCoPhep.setBounds(464, 109, 103, 21);
		panel_2.add(radCoPhep);
		
		JButton btnReSet = new JButton("Đặt lại chấm công");
		btnReSet.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReSet.setBounds(399, 210, 152, 36);
		panel_2.add(btnReSet);
		// Bảng công nhân
		tableCongNhan = new Table();
		tableCongNhan.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	            	"ID","Họ và tên","Ca làm","Sản phẩm","Công đoạn","Số lượng được giao"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
		tableNhanVien = new Table();
        tableNhanVien.setOpaque(false);
        tableNhanVien.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00F2ng Ban", "C\u00F3 m\u1EB7t", "V\u1EAFng m\u1EB7t", "C\u00F3 ph\u00E9p"
        	}
        ));
        
        JScrollPane scrollListNV = new JScrollPane();
        scrollListNV.setBackground(new Color(255, 255, 255));
        scrollListNV.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollListNV.setViewportView(tableNhanVien);
		panelCenterLeft.add(scrollListNV);
		tableNhanVien.fixTable(scrollListNV);
		
		// Khởi tạo panel chứa tiêu đề của bảng
		panelNV = new RoundPanel();
		panelNV.setBackground(new Color(155, 204, 255));
		panelCenterLeft.add(panelNV, BorderLayout.NORTH);
		panelNV.setRound(10);
		panelNV.setOpaque(false);
		
		// 
		lbListNV = new JLabel("Danh sách nhân viên\r\n");
		lbListNV.setBackground(new Color(0, 0, 0));
		lbListNV.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelNV.add(lbListNV);
		
		// Bảng chấm công
		tableChamCong = new Table();
        tableChamCong.setOpaque(false);
        // Cài đặt header cho table Chấm công
        tableChamCong.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"1", "2", "3", "4", null, null, null},
        		{"2", null, null, null, null, null, null},
        	},
        	new String[] {
        		"ID ch\u1EA5m c\u00F4ng", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "ID nh\u00E2n vi\u00EAn", "H\u1ECD t\u00EAn", "Ph\u00F2ng Ban", "Tr\u1EA1ng th\u00E1i", "Ngh\u1EC9 ph\u00E9p"
        	}
        ));
        
        JScrollPane scrollListCC = new JScrollPane();
        scrollListCC.setBackground(new Color(255, 255, 255));
        scrollListCC.setOpaque(false);
        scrollListCC.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollListCC.setViewportView(tableChamCong);
        panelSouth.add(scrollListCC);
        
        tableChamCong.fixTable(scrollListCC);
        
        // Khởi tạo panel chứa tiêu đề của bảng
        panelListCC = new RoundPanel();
        panelListCC.setRound(10);
        panelListCC.setOpaque(false);
        panelListCC.setBackground(new Color(153, 204, 255));
//        scrollPane.setColumnHeaderView(panel_1);
        panelSouth.add(panelListCC, BorderLayout.NORTH);
        
        lbChamCong = new JLabel("Danh sách chấm công");
        lbChamCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
        panelListCC.add(lbChamCong);
	}

}
