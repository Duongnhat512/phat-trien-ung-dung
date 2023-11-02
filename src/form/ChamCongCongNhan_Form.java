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

import commons.RoundPanel;
import commons.Table;

import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChamCongCongNhan_Form extends RoundPanel {
	
	private RoundPanel panelCenter;
	private RoundPanel panelSouth;
	private int width = 1259;
	private int height = 813;
	private Table tableCongNhan;
	private Table tableCongNhan_1;
	private Table tableChamCong;
	private RoundPanel panel;
	private JLabel lblNewLabel;
	private RoundPanel panel_1;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;

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
		setPreferredSize(new Dimension(1259, 813));
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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelSouth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelCenter_1, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelCenter_1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
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
		tableCongNhan_1 = new Table();
        tableCongNhan_1.setOpaque(false);
        tableCongNhan_1.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ca l\u00E0m", "Ph\u00E2n x\u01B0\u1EDFng", "S\u1EA3n ph\u1EA9m", "C\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u01B0\u1EE3c giao"
        	}
        ));
        tableCongNhan_1.getColumnModel().getColumn(6).setPreferredWidth(136);
        
        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBackground(new Color(255, 255, 255));
        scrollPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane1.setViewportView(tableCongNhan_1);
		panelCenter.add(scrollPane1);
		tableCongNhan_1.fixTable(scrollPane1);
		
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
}
