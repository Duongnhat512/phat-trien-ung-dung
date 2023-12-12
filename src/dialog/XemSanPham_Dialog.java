package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commons.MyButton;
import commons.RoundPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class XemSanPham_Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int width = 900;
	private int height = 550;
	private MyButton btnCapNhat;
	private MyButton btnHuy;
	private JPanel buttonPane;
	private RoundPanel panel_1;
	private JTextArea textGhiChu;
	private JLabel lblNewLabel;
	private JLabel lblTnSnPhm;
	private JLabel lblnGi;
	private JLabel lblChtLiu;
	private JLabel lblnVTnh;
	private JLabel lblGhiCh;
	private JTextField textIDSP;
	private JTextField textTenSP;
	private JTextField textDonGia;
	private JTextField textChatLieu;
	private JTextField textDonViTinh;
	private JLabel lblThongBaoDonViTinh;
	
	//
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			XemSanPham_Dialog dialog = new XemSanPham_Dialog();
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openThemSanPham_Dialog(int width, int height) {
		this.width = width;
		this.height = height;
		new XemSanPham_Dialog().setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public XemSanPham_Dialog() {
		getContentPane().setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Thêm sản phẩm");
		setBounds(100, 100, 509, 467);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
			buttonPane.setPreferredSize(new Dimension(this.width, (int) (this.height*0.05)));
			{
				btnCapNhat = new MyButton();
				btnCapNhat.setRadius(10);
				btnCapNhat.setForeground(new Color(0, 0, 0));
				btnCapNhat.setIcon(new ImageIcon(XemSanPham_Dialog.class.getResource("/icon/update.png")));
				btnCapNhat.setText("Thêm");
				btnCapNhat.setFont(new Font("SansSerif", Font.PLAIN, 15));
				btnCapNhat.setFocusPainted(false);
				btnCapNhat.setActionCommand("OK");
				btnCapNhat.setBackground(new Color(255, 255, 255));
				getRootPane().setDefaultButton(btnCapNhat);
			}
			{
				btnHuy = new MyButton();
				btnHuy.setRadius(10);
				btnHuy.setIcon(new ImageIcon(XemSanPham_Dialog.class.getResource("/icon/unavailable.png")));
				btnHuy.setText("Hủy");
				btnHuy.setFont(new Font("SansSerif", Font.PLAIN, 15));
				btnHuy.setFocusPainted(false);
				btnHuy.setBackground(new Color(255, 81, 81));
				btnHuy.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(259)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(431, Short.MAX_VALUE))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnHuy, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		panel_1 = new RoundPanel();
		panel_1.setRound(10);
		panel_1.setOpaque(false);
		textGhiChu = new JTextArea();
		textGhiChu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textGhiChu.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblNewLabel = new JLabel("ID sản phẩm:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblnGi = new JLabel("Đơn giá:");
		lblnGi.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblChtLiu = new JLabel("Chất liệu:");
		lblChtLiu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblnVTnh = new JLabel("Đơn vị tính:");
		lblnVTnh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblGhiCh = new JLabel("Ghi chú:");
		lblGhiCh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		textIDSP = new JTextField();
		textIDSP.setEditable(false);
		textIDSP.setEnabled(false);
		textIDSP.setBackground(new Color(240, 240, 240));
		textIDSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textIDSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textIDSP.setColumns(10);
		
		textTenSP = new JTextField();
		textTenSP.setEditable(false);
		textTenSP.setBackground(new Color(240, 240, 240));
		textTenSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textTenSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textTenSP.setColumns(10);
		
		textDonGia = new JTextField();
		textDonGia.setBackground(new Color(240, 240, 240));
		textDonGia.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textDonGia.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textDonGia.setColumns(10);
		
		textChatLieu = new JTextField();
		textChatLieu.setBackground(new Color(240, 240, 240));
		textChatLieu.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textChatLieu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textChatLieu.setColumns(10);
		
		textDonViTinh = new JTextField();
		textDonViTinh.setEditable(false);
		textDonViTinh.setBackground(new Color(240, 240, 240));
		textDonViTinh.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textDonViTinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textDonViTinh.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(392, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		lblThongBaoDonViTinh = new JLabel();
		lblThongBaoDonViTinh.setForeground(Color.RED);
		lblThongBaoDonViTinh.setFont(new Font("SansSerif", Font.ITALIC, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblGhiCh, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(textGhiChu))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(textIDSP, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(textTenSP, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblnGi, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(textDonGia, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblChtLiu, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(textChatLieu, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblnVTnh, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(textDonViTinh, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)))
					.addGap(167)
					.addComponent(lblThongBaoDonViTinh, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(textIDSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblTnSnPhm))
						.addComponent(textTenSP, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblnGi))
						.addComponent(textDonGia, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblChtLiu))
						.addComponent(textChatLieu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblnVTnh))
						.addComponent(textDonViTinh, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textGhiChu, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(lblThongBaoDonViTinh, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblGhiCh))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
		
		
	}
	
	private void themSanPhan() {
		
	}
}
