package form;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import commons.Table;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import commons.RoundPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import commons.MyButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;

public class CongDoanPhanCong_Form extends JPanel {
	private int width = 1259;
	private int height = 813;
	private Table tableCongNhan;
	private Table tableCongDoan;
	
	
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
		
		RoundPanel panel = new RoundPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 64, 336, 332);
		
		RoundPanel panel_2 = new RoundPanel();
		panel_2.setBounds(352, 64, 347, 332);
		panel_2.setRound(10);
		panel_2.setBorder(new EmptyBorder(2, 2, 2, 2));
		
		RoundPanel panel_3 = new RoundPanel();
		panel_3.setBounds(709, 64, 528, 332);
		panel_3.setRound(20);
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(new BorderLayout(0, 0));
		
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
		panel_2.add(scrollPane2);
		
		tableCongNhan = new Table();
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
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBorder(null);
		scrollPane3.setBackground(new Color(255, 255, 255));
		panel.add(scrollPane3);
		
		tableCongDoan = new Table();
		tableCongDoan.setBorder(null);
		tableCongDoan.setOpaque(false);
		scrollPane3.setViewportView(tableCongDoan);
		tableCongDoan.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                	"Tên sản phẩm", "Tên công đoạn", "Số lượng cần giao"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
		tableCongDoan.fixTable(scrollPane3);
		panelNorth.setLayout(null);
		panelNorth.add(panel);
		panelNorth.add(panel_2);
		panelNorth.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		RoundPanel panel_1_1 = new RoundPanel();
		panel_1_1.setRound(10);
		panel_1_1.setOpaque(false);
		panel_1_1.setBackground(new Color(153, 204, 255));
		panel_3.add(panel_1_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin phân công");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_3.add(panel_4, BorderLayout.CENTER);
		
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
		
		MyButton btnCapNhat = new MyButton();
		btnCapNhat.setBounds(1096, 11, 141, 43);
		panelNorth.add(btnCapNhat);
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setRadius(10);
		btnCapNhat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setBackground(Color.WHITE);
		
		MyButton btnPhanCong = new MyButton();
		btnPhanCong.setBounds(949, 10, 141, 45);
		panelNorth.add(btnPhanCong);
		btnPhanCong.setText("Chấm công");
		btnPhanCong.setRadius(10);
		btnPhanCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnPhanCong.setFocusPainted(false);
		btnPhanCong.setBackground(Color.WHITE);
	}
}
