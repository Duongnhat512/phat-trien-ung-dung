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

public class ThemSanPham_Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int width = 900;
	private int height = 550;
	private MyButton btnThem;
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
	private JPanel panelAnhSP;
	private MyButton btnChonAnh;
	private JLabel lblThongBaoTen;
	private JLabel lblThongBaoDonGia;
	private JLabel lblThongBaoChatLieu;
	private JLabel lblThongBaoDonViTinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ThemSanPham_Dialog dialog = new ThemSanPham_Dialog();
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openThemSanPham_Dialog(int width, int height) {
		this.width = width;
		this.height = height;
		new ThemSanPham_Dialog().setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public ThemSanPham_Dialog() {
		getContentPane().setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Thêm sản phẩm");
		setBounds(100, 100, this.width, this.height);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
			buttonPane.setPreferredSize(new Dimension(this.width, (int) (this.height*0.05)));
			{
				btnThem = new MyButton();
				btnThem.setRadius(10);
				btnThem.setForeground(new Color(255, 255, 255));
				btnThem.setIcon(new ImageIcon(ThemSanPham_Dialog.class.getResource("/icon/icons8_plus_math_30px.png")));
				btnThem.setText("Thêm");
				btnThem.setFont(new Font("SansSerif", Font.PLAIN, 15));
				btnThem.setFocusPainted(false);
				btnThem.setActionCommand("OK");
				btnThem.setBackground(new Color(82, 125, 254));
				getRootPane().setDefaultButton(btnThem);
			}
			{
				btnHuy = new MyButton();
				btnHuy.setRadius(10);
				btnHuy.setIcon(new ImageIcon(ThemSanPham_Dialog.class.getResource("/icon/unavailable.png")));
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
						.addGap(681)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnHuy, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 448, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
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
		textDonViTinh.setBackground(new Color(240, 240, 240));
		textDonViTinh.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textDonViTinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textDonViTinh.setColumns(10);
		
		panelAnhSP = new JPanel();
		panelAnhSP.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnChonAnh = new MyButton();
		btnChonAnh.setIcon(new ImageIcon(ThemSanPham_Dialog.class.getResource("/icon/picture_30px.png")));
		btnChonAnh.setRadius(10);
		btnChonAnh.setText("Chọn ảnh");
		btnChonAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChonAnh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		lblThongBaoTen = new JLabel();
		lblThongBaoTen.setForeground(Color.RED);
		lblThongBaoTen.setFont(new Font("SansSerif", Font.ITALIC, 15));
		
		lblThongBaoDonGia = new JLabel();
		lblThongBaoDonGia.setForeground(Color.RED);
		lblThongBaoDonGia.setFont(new Font("SansSerif", Font.ITALIC, 15));
		
		lblThongBaoChatLieu = new JLabel();
		lblThongBaoChatLieu.setForeground(Color.RED);
		lblThongBaoChatLieu.setFont(new Font("SansSerif", Font.ITALIC, 15));
		
		lblThongBaoDonViTinh = new JLabel();
		lblThongBaoDonViTinh.setForeground(Color.RED);
		lblThongBaoDonViTinh.setFont(new Font("SansSerif", Font.ITALIC, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblnGi, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblChtLiu, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
							.addGap(61)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textIDSP, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(textTenSP, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblThongBaoTen, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDonGia, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblThongBaoDonGia, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(textChatLieu, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
							.addGap(179)
							.addComponent(panelAnhSP, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(lblnVTnh, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblThongBaoChatLieu, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDonViTinh, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
							.addGap(210)
							.addComponent(btnChonAnh, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(175)
							.addComponent(lblThongBaoDonViTinh, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(lblGhiCh, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(textGhiChu, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)))
					.addGap(60))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(36)
							.addComponent(lblTnSnPhm)
							.addGap(39)
							.addComponent(lblnGi)
							.addGap(39)
							.addComponent(lblChtLiu))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textIDSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(textTenSP, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblThongBaoTen, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textDonGia, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblThongBaoDonGia, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textChatLieu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelAnhSP, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(29)
							.addComponent(lblnVTnh))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblThongBaoChatLieu, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textDonViTinh, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(btnChonAnh, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(lblThongBaoDonViTinh, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblGhiCh)
							.addGap(72))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textGhiChu, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
							.addContainerGap())))
		);
		panel_1.setLayout(gl_panel_1);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}
}
