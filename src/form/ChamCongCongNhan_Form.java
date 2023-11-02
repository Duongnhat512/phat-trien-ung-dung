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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChamCongCongNhan_Form extends JPanel {
	
	private RoundPanel panelCenter;
	private RoundPanel panelSouth;
	private int width = 1259;
	private int height = 813;
	private Table tableCongNhan;
	private Table tableChamCong;

	/**
	 * Create the panel.
	 */
	public ChamCongCongNhan_Form(int width, int height) {
		setBackground(new Color(255, 255, 255));
		this.width = width;
		this.height = height;
		initPanel();
	}
	
	private void initPanel() {
		setPreferredSize(new Dimension(1259, 791));
		
		panelCenter = new RoundPanel();
		panelCenter.setRound(20);
		panelCenter.setBackground(new Color(240, 240, 240));
		panelCenter.setBorder(new EmptyBorder(5, 15, 4, 10));
		panelCenter.setLayout(new BorderLayout());
		panelCenter.setPreferredSize(new Dimension(this.width, (int)(this.height*0.4)));
		
		panelSouth = new RoundPanel();
		panelSouth.setLayout(new BorderLayout());
		panelSouth.setBackground(new Color(240, 240, 240));
		panelSouth.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelSouth.setPreferredSize(new Dimension((int) (this.width * 0.95), (int) (this.height * 0.6)));
		panelSouth.setRound(20);
		
		RoundPanel panelCenter_1 = new RoundPanel();
		panelCenter_1.setRound(20);
		panelCenter_1.setPreferredSize(new Dimension(1259, 325));
		panelCenter_1.setBorder(new EmptyBorder(5, 15, 4, 10));
		panelCenter_1.setBackground(new Color(240, 240, 240));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 1227, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelCenter_1, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
							.addGap(9))))
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
		GroupLayout gl_panelCenter_1 = new GroupLayout(panelCenter_1);
		gl_panelCenter_1.setHorizontalGroup(
			gl_panelCenter_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 597, Short.MAX_VALUE)
		);
		gl_panelCenter_1.setVerticalGroup(
			gl_panelCenter_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 326, Short.MAX_VALUE)
		);
		panelCenter_1.setLayout(gl_panelCenter_1);
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelSouth.setLayout(new BorderLayout(0, 0));
		setLayout(groupLayout);
		
		
		
		// Bảng công nhân
		String[] headerCongNhan = new String[]{"ID", "Họ và tên", "Ca làm", "Sản phẩm", "Công đoạn", "Số lượng được giao"};
		tableCongNhan = new Table();
		tableCongNhan.setModel(new DefaultTableModel(headerCongNhan, 0));
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBorder(null);
		scrollPane1.setViewportView(tableCongNhan);
		tableCongNhan.fixTable(scrollPane1);
		panelCenter.add(scrollPane1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Danh sách công nhân");
		scrollPane1.setColumnHeaderView(lblNewLabel);
		
		// Bảng chấm công
		tableChamCong = new Table();
		tableChamCong.setModel(new DefaultTableModel(new Object[] {"ID Chấm công", "ID công nhân", "Ngày chấm công", "Sản phẩm", "Công đoạn", "Số lượng được giao", "Số lượng hoàn thành"}, 0));
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(null);
		scrollPane2.setViewportView(tableChamCong);
		tableCongNhan.fixTable(scrollPane2);
		panelSouth.add(scrollPane2, BorderLayout.CENTER);
	}
}
