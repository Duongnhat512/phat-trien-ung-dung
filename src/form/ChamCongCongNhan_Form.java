package form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Scrollbar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import commons.MyButton;
import commons.RoundPanel;
import commons.Table;

import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ChamCongCongNhan_Form extends RoundPanel {
	
	private RoundPanel panelCenter;
	private RoundPanel panelSouth;
	private int width = 1259;
	private int height = 813;
	private Table tableCongNhan;
	private Table tableChamCong;
	private RoundPanel panel;
	private JLabel lblNewLabel;
	private RoundPanel panel_1;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;
	private JTextField textNgayChamCong;
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Create the panel.
	 */
	public ChamCongCongNhan_Form(int width, int height) {
		setBackground(new Color(240, 240, 240));
		this.width = width;
		this.height = height;
		initPanel();
	}
	
	private void initPanel() {
		setPreferredSize(new Dimension(this.width, this.height));
		setRound(20);

		panelCenter = new RoundPanel();
		panelCenter.setRound(20);
		panelCenter.setBackground(new Color(255, 255, 255));
		panelCenter.setBorder(new EmptyBorder(5, 15, 10, 10));
		
		panelSouth = new RoundPanel();
		panelSouth.setLayout(new BorderLayout());
		panelSouth.setBackground(new Color(255, 255, 255));
		panelSouth.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelSouth.setPreferredSize(new Dimension((int) (this.width * 0.95), (int) (this.height * 0.6)));
		panelSouth.setRound(20);
		
		RoundPanel panelCenter_1 = new RoundPanel();
		panelCenter_1.setRound(20);
		panelCenter_1.setPreferredSize(new Dimension(1259, 325));
		panelCenter_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCenter_1.setBackground(new Color(255, 255, 255));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		panelNorth.setBackground(new Color(255, 255, 255));
		panelNorth.setBorder(new EmptyBorder(0, 0, 0, 0));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(19, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelNorth, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panelSouth, GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(panelCenter_1, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE))))
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter_1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày chấm công:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		textNgayChamCong = new JTextField();
		textNgayChamCong.setBorder(null);
		textNgayChamCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textNgayChamCong.setText(dtf.format(LocalDate.now()));
		textNgayChamCong.setHorizontalAlignment(SwingConstants.CENTER);
		textNgayChamCong.setColumns(10);
		
		MyButton btnCapNhat = new MyButton();
		btnCapNhat.setBackground(new Color(255, 255, 255));
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/icon/update.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setRadius(10);
		btnCapNhat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		MyButton btnChamCongAll = new MyButton();
		btnChamCongAll.setBackground(new Color(255, 255, 255));
		btnChamCongAll.setFocusPainted(false);
		btnChamCongAll.setIcon(new ImageIcon(ChamCongCongNhan_Form.class.getResource("/icon/add.png")));
		btnChamCongAll.setText("Chấm công hàng loạt");
		btnChamCongAll.setRadius(10);
		btnChamCongAll.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		MyButton btnChamCong = new MyButton();
		btnChamCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChamCong.setBackground(new Color(255, 255, 255));
		btnChamCong.setFocusPainted(false);
		btnChamCong.setIcon(new ImageIcon(ChamCongCongNhan_Form.class.getResource("/icon/add.png")));
		btnChamCong.setText("Chấm công");
		btnChamCong.setRadius(10);
		btnChamCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JComboBox cboCaLam = new JComboBox();
		cboCaLam.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		MyButton btnLocTheoCa = new MyButton();
		btnLocTheoCa.setIcon(new ImageIcon(ChamCongCongNhan_Form.class.getResource("/icon/icons8_filter_25px_1.png")));
		btnLocTheoCa.setText("Lọc ca");
		btnLocTheoCa.setRadius(10);
		btnLocTheoCa.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnLocTheoCa.setFocusPainted(false);
		btnLocTheoCa.setBackground(Color.WHITE);
		
		
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGap(18)
					.addComponent(cboCaLam, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLocTheoCa, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addComponent(btnChamCong, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnChamCongAll, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textNgayChamCong, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(88))
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(textNgayChamCong, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnLocTheoCa, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addComponent(cboCaLam, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addComponent(btnChamCong, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnChamCongAll, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
		
		RoundPanel panel_2 = new RoundPanel();
		panel_2.setRound(10);
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(153, 204, 255));
		
		JLabel lblThngTinChm = new JLabel("Thông tin chấm công");
		lblThngTinChm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_2.add(lblThngTinChm);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		GroupLayout gl_panelCenter_1 = new GroupLayout(panelCenter_1);
		gl_panelCenter_1.setHorizontalGroup(
			gl_panelCenter_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
		);
		gl_panelCenter_1.setVerticalGroup(
			gl_panelCenter_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 587, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		panel_3.setLayout(gl_panel_3);
		panelCenter_1.setLayout(gl_panelCenter_1);
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelSouth.setLayout(new BorderLayout(0, 0));
		setLayout(groupLayout);	
		
		// Bảng công nhân
		
		tableCongNhan = new Table();
        tableCongNhan.setOpaque(false);
        tableCongNhan.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ca l\u00E0m", "Ph\u00E2n x\u01B0\u1EDFng", "S\u1EA3n ph\u1EA9m", "C\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u01B0\u1EE3c giao", "S\u1ED1 l\u01B0\u1EE3ng ho\u00E0n th\u00E0nh"
        	}
        ));
        tableCongNhan.getColumnModel().getColumn(6).setPreferredWidth(136);
        
        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBackground(new Color(255, 255, 255));
        scrollPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane1.setViewportView(tableCongNhan);
		panelCenter.add(scrollPane1);
		tableCongNhan.fixTable(scrollPane1);
		
		// Khởi tạo panel chứa tiêu đề của bảng
		panel = new RoundPanel();
		panel.setBackground(new Color(153, 204, 255));
		panelCenter.add(panel, BorderLayout.NORTH);
		panel.setRound(10);
		panel.setOpaque(false);
		
		// 
		lblNewLabel = new JLabel("Danh sách công nhân");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		// Bảng chấm công
		tableChamCong = new Table();
        tableChamCong.setOpaque(false);
        // Cài đặt header cho table Chấm công
        tableChamCong.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID c\u00F4ng nh\u00E2n", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "Ph\u00E2n x\u01B0\u1EDFng", "S\u1EA3n ph\u1EA9m", "C\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u01B0\u1EE3c giao", "S\u1ED1 l\u01B0\u1EE3ng ho\u00E0n th\u00E0nh"
        	}
        ));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setOpaque(false);
        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane.setViewportView(tableChamCong);
        panelSouth.add(scrollPane);
        
        tableChamCong.fixTable(scrollPane);
        
        // Khởi tạo panel chứa tiêu đề của bảng
        panel_1 = new RoundPanel();
        panel_1.setRound(10);
        panel_1.setOpaque(false);
        panel_1.setBackground(new Color(153, 204, 255));
//        scrollPane.setColumnHeaderView(panel_1);
        panelSouth.add(panel_1, BorderLayout.NORTH);
        
        lblNewLabel_1 = new JLabel("Danh sách chấm công");
        lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
        panel_1.add(lblNewLabel_1);
        
        
	}
	
	private void layDanhSachCongNhan() {
		
	}
}
