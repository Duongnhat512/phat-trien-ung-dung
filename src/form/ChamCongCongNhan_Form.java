package form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Scrollbar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ChamCongCongNhan_Form extends JPanel {
	
	private static ChamCongCongNhan_Form chamCongCongNhan_Form = new ChamCongCongNhan_Form();
	private JPanel panelNorth;
	private JPanel panelCenter;
	private final int WIDTH = 1250;
	private final int HEIGHT = 725;
	private JTable tableChamCong;
	private DefaultTableModel tableModel;
	private Scrollbar scrollPane;
	/**
	 * Create the panel.
	 */
	public ChamCongCongNhan_Form() {
		setSize(new Dimension(WIDTH, HEIGHT));
		setBorder(null);
		setLayout(new BorderLayout());
		
		panelNorth = new JPanel();
		setLayout(new BorderLayout());
		panelNorth.setPreferredSize(new Dimension(WIDTH, (int)(HEIGHT*0.5)));
		add(panelNorth, BorderLayout.NORTH);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout());
		add(panelCenter, BorderLayout.CENTER);
		
//		tableModel = new DefaultTableModel(new Object[] {});
		
		tableChamCong = new JTable();
		tableChamCong.setModel(new DefaultTableModel(new Object[]{"ID C\u00F4ng nh\u00E2n", "T\u00EAn c\u00F4ng nh\u00E2n", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "T\u00EAn s\u1EA3n ph\u1EA9m", "T\u00EAn c\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng ho\u00E0n th\u00E0nh"}, 0));
		tableChamCong.getColumnModel().getColumn(1).setPreferredWidth(117);
		tableChamCong.getColumnModel().getColumn(2).setPreferredWidth(93);
		tableChamCong.getColumnModel().getColumn(3).setPreferredWidth(115);
		tableChamCong.getColumnModel().getColumn(4).setPreferredWidth(130);
		tableChamCong.getColumnModel().getColumn(5).setPreferredWidth(115);
		panelCenter.add(new JScrollPane(tableChamCong), BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new ChamCongCongNhan_Form().setVisible(true);
	}
}
