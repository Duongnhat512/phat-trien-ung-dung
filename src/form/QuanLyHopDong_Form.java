package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import commons.RoundPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import commons.MyButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class QuanLyHopDong_Form extends JPanel {

	private int width = 1259;
	private int height = 813;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public QuanLyHopDong_Form(int width, int height) {
		this.width = width;
		this.height = height;
		initPanel();
	}
	
	public void initPanel() {
		setPreferredSize(new DimensionUIResource(this.width, this.height));
		
		RoundPanel panelCenter = new RoundPanel();
		panelCenter.setRound(20);
		panelCenter.setBackground(Color.WHITE);
		
		RoundPanel panelSouth = new RoundPanel();
		panelSouth.setRound(20);
		panelSouth.setBackground(Color.WHITE);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		panelNorth.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelNorth.setBackground(Color.WHITE);
		
		MyButton btnThemHopDong = new MyButton();
		btnThemHopDong.setIcon(new ImageIcon(QuanLyHopDong_Form.class.getResource("/icon/add.png")));
		btnThemHopDong.setText("Thêm hợp đồng");
		btnThemHopDong.setRadius(10);
		btnThemHopDong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnThemHopDong.setFocusPainted(false);
		btnThemHopDong.setBackground(Color.WHITE);
		
		MyButton btnTimKiem = new MyButton();
		btnTimKiem.setText("TÌm kiếm");
		btnTimKiem.setRadius(10);
		btnTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBackground(Color.WHITE);
		
		MyButton btnChamCong = new MyButton();
		btnChamCong.setIcon(new ImageIcon(QuanLyHopDong_Form.class.getResource("/icon/update.png")));
		btnChamCong.setText("Cập nhật");
		btnChamCong.setRadius(10);
		btnChamCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnChamCong.setFocusPainted(false);
		btnChamCong.setBackground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField.setColumns(10);
		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
			gl_panelNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelNorth.createSequentialGroup()
					.addGap(83)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(93)
					.addComponent(btnThemHopDong, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(86)
					.addComponent(btnChamCong, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(194, Short.MAX_VALUE))
		);
		gl_panelNorth.setVerticalGroup(
			gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
					.addGroup(gl_panelNorth.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChamCong, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThemHopDong, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelNorth.setLayout(gl_panelNorth);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 1222, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panelSouth, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelNorth, GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		setLayout(groupLayout);
	}
}
