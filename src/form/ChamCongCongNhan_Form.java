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
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ChamCongCongNhan_Form extends JPanel {
	
	private JPanel panelCenter;
	private JPanel panelSouth;
	private int width = 1250;
	private int height = 725;
	private JTable tableChamCong;
	private DefaultTableModel tableModel;
	private Scrollbar scrollPane;
	private JTable tableCongNhan;
	private JPanel panelCCenter;
	/**
	 * Create the panel.
	 */
	public ChamCongCongNhan_Form(int width, int height) {
		this.width = width;
		this.height = height;
		initPanel();
	}
	
	private void initPanel() {
		setSize(new Dimension(this.width, this.height));
		setLayout(new BorderLayout());
		
		panelCenter = new JPanel();
		panelCenter.setBorder(new EmptyBorder(5, 15, 4, 10));
		panelCenter.setSize(this.width, (int)(this.height*0.5));
		panelCenter.setPreferredSize(new Dimension(this.width, (int)(this.height*0.4)));
		add(panelCenter, BorderLayout.CENTER);
		
		panelSouth = new JPanel();
		panelSouth.setBorder(new EmptyBorder(0, 15, 0, 10));
		panelSouth.setPreferredSize(new Dimension((int) (this.width * 0.95), (int) (this.height * 0.6)));
		add(panelSouth, BorderLayout.SOUTH);
		
		// Bảng công nhân
		tableCongNhan = new JTable();
		tableCongNhan.setModel(new DefaultTableModel(new Object[] {"ID Công nhân", "Tên công nhân", "Ca làm", "Số lượng được giao"}, 0));
		JScrollPane scrollPane = new JScrollPane(tableCongNhan);
		scrollPane.setPreferredSize(new Dimension((int) (this.width * 0.4), (int)(panelCenter.getHeight()*0.9)));
		
		// Bảng chấm công
		tableChamCong = new JTable();
		tableChamCong.setModel(new DefaultTableModel(new Object[]{"ID C\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng nh\u00E2n", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "T\u00EAn s\u1EA3n ph\u1EA9m", "T\u00EAn c\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng ho\u00E0n th\u00E0nh", "Hệ số ca làm"}, 0));
		tableChamCong.getColumnModel().getColumn(1).setPreferredWidth(117);
		tableChamCong.getColumnModel().getColumn(2).setPreferredWidth(93);
		tableChamCong.getColumnModel().getColumn(3).setPreferredWidth(115);
		tableChamCong.getColumnModel().getColumn(4).setPreferredWidth(130);
		tableChamCong.getColumnModel().getColumn(5).setPreferredWidth(115);
		JScrollPane scrollPane1 = new JScrollPane(tableChamCong);
//		scrollPane1.setPreferredSize(new Dimension(this.width, (int)(panelSouth.getHeight()*0.9)));
		
		//
		JLabel lblCongNhan = new JLabel("Danh sách công nhân");
		lblCongNhan.setPreferredSize(new Dimension((int)(this.width), (int)(this.height * 0.05)));
		
		JLabel lblChamCong = new JLabel("Danh sách chấm công công nhân");
		lblChamCong.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblCongNhan.setPreferredSize(new Dimension((int)(this.width), (int)(this.height * 0.05)));
		GroupLayout gl_panelSouth = new GroupLayout(panelSouth);
		gl_panelSouth.setHorizontalGroup(
			gl_panelSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSouth.createSequentialGroup()
					.addGroup(gl_panelSouth.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChamCong, GroupLayout.PREFERRED_SIZE, 1225, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1225, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_panelSouth.setVerticalGroup(
			gl_panelSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSouth.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChamCong, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelSouth.setLayout(gl_panelSouth);
		
		panelCCenter = new JPanel();
		panelCCenter.setBorder(new EmptyBorder(10, 0, 0, 0));
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCenter.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelCCenter, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCongNhan, GroupLayout.PREFERRED_SIZE, 1225, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCongNhan, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelCCenter, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblNewLabel1 = new JLabel("ID Công nhân:");
		lblNewLabel1.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JLabel lblIDCongNhan = new JLabel("adsa");
		lblIDCongNhan.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		
		JLabel lblTenCongNhan = new JLabel("dsada");
		lblTenCongNhan.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		
		JLabel lblNewLabel_2 = new JLabel("Tên công nhân:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2_1 = new JLabel("Ca làm:");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JComboBox comboBoxCaLam = new JComboBox();
		comboBoxCaLam.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JButton btnLocCa = new JButton("Lọc theo ca");
		btnLocCa.setIcon(new ImageIcon(ChamCongCongNhan_Form.class.getResource("/icon/icons8_filter_25px_1.png")));
		btnLocCa.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Tên sản phẩm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTnCngon = new JLabel("Tên công đoạn:");
		lblTnCngon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNgyChmCng = new JLabel("Ngày chấm công:");
		lblNgyChmCng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNgyChmCng_1 = new JLabel("Ngày chấm công:");
		lblNgyChmCng_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNgyChmCng_1_1 = new JLabel("Ngày chấm công:");
		lblNgyChmCng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panelCCenter = new GroupLayout(panelCCenter);
		gl_panelCCenter.setHorizontalGroup(
			gl_panelCCenter.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCCenter.createSequentialGroup()
							.addGroup(gl_panelCCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTenCongNhan, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
								.addComponent(lblIDCongNhan, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelCCenter.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxCaLam, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLocCa)))
					.addGap(125)
					.addGroup(gl_panelCCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNgyChmCng_1_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNgyChmCng_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblTnCngon)
						.addComponent(lblNgyChmCng, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
					.addGap(110))
		);
		gl_panelCCenter.setVerticalGroup(
			gl_panelCCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCCenter.createSequentialGroup()
					.addGroup(gl_panelCCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel1)
						.addComponent(lblIDCongNhan)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_panelCCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblTenCongNhan)
						.addComponent(lblTnCngon, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(gl_panelCCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCCenter.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panelCCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxCaLam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLocCa)))
						.addGroup(gl_panelCCenter.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNgyChmCng, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addComponent(lblNgyChmCng_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblNgyChmCng_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(129))
		);
		panelCCenter.setLayout(gl_panelCCenter);
		panelCenter.setLayout(gl_panelCenter);
		
	}
}
