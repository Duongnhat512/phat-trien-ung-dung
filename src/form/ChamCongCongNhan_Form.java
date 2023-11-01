package form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Scrollbar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;

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
		panelCenter.setBorder(new EmptyBorder(15, 15, 4, 10));
		panelCenter.setLayout(new BorderLayout());
		panelCenter.setSize(this.width, (int)(this.height*0.5));
		panelCenter.setPreferredSize(new Dimension(this.width, (int)(this.height*0.5)));
		add(panelCenter, BorderLayout.CENTER);
		
		panelSouth = new JPanel();
		panelSouth.setBorder(new EmptyBorder(0, 15, 10, 10));
		panelSouth.setLayout(new BorderLayout());
		panelSouth.setPreferredSize(new Dimension((int) (this.width * 0.95), (int) (this.height * 0.45)));
		add(panelSouth, BorderLayout.SOUTH);
		
		// Bảng công nhân
		tableCongNhan = new JTable();
		tableCongNhan.setModel(new DefaultTableModel(new Object[] {"ID Công nhân", "Tên công nhân", "Ca làm", "Số lượng được giao"}, 0));
		JScrollPane scrollPane = new JScrollPane(tableCongNhan);
		scrollPane.setPreferredSize(new Dimension((int) (this.width * 0.4), (int)(panelCenter.getHeight()*0.9)));
		panelCenter.add(scrollPane, BorderLayout.WEST);
		
		// Bảng chấm công
		tableChamCong = new JTable();
		tableChamCong.setModel(new DefaultTableModel(new Object[]{"ID C\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng nh\u00E2n", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "T\u00EAn s\u1EA3n ph\u1EA9m", "T\u00EAn c\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng ho\u00E0n th\u00E0nh"}, 0));
		tableChamCong.getColumnModel().getColumn(1).setPreferredWidth(117);
		tableChamCong.getColumnModel().getColumn(2).setPreferredWidth(93);
		tableChamCong.getColumnModel().getColumn(3).setPreferredWidth(115);
		tableChamCong.getColumnModel().getColumn(4).setPreferredWidth(130);
		tableChamCong.getColumnModel().getColumn(5).setPreferredWidth(115);
		JScrollPane scrollPane1 = new JScrollPane(tableChamCong);
		panelSouth.add(scrollPane1, BorderLayout.CENTER);
		
		panelCCenter = new JPanel();
		panelCenter.add(panelCCenter, BorderLayout.CENTER);
	}
}
