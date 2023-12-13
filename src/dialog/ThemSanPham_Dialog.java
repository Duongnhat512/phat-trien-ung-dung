package dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import bus.SanPham_BUS;
import commons.MyButton;
import commons.RoundPanel;
import entities.SanPham;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ThemSanPham_Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int width = 900;
	private int height = 550;
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
	
	private String url;

	//
	private SanPham_BUS sp_Bus = new SanPham_BUS();
	private JLabel lblThongBao;
	private JLabel avatarSP;
	private JButton btnGoAnh;
	private JButton btnChonAnh;

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
		setBounds(100, 100, 784, 459);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
			buttonPane.setPreferredSize(new Dimension(this.width, (int) (this.height * 0.05)));
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
			
			MyButton btnThem = new MyButton();
			btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					themSanPham();
				}
			});
			btnThem.setIcon(new ImageIcon(ThemSanPham_Dialog.class.getResource("/icon/icons8_plus_math_30px_1.png")));
			btnThem.setText("Thêm");
			btnThem.setRadius(10);
			btnThem.setForeground(Color.WHITE);
			btnThem.setFont(new Font("SansSerif", Font.PLAIN, 15));
			btnThem.setFocusable(false);
			btnThem.setFocusTraversalKeysEnabled(false);
			btnThem.setFocusPainted(false);
			btnThem.setBackground(new Color(82, 125, 254));
			btnThem.setActionCommand("ADD");
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_buttonPane.createSequentialGroup()
						.addGap(256)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(430, Short.MAX_VALUE))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnHuy, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
					.addGap(290))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		textIDSP.setDisabledTextColor(new Color(0, 0, 0));
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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		lblThongBao = new JLabel("");
		lblThongBao.setFont(new Font("SansSerif", Font.ITALIC, 15));
		lblThongBao.setForeground(new Color(255, 0, 0));
		
		avatarSP = new JLabel();
		avatarSP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		avatarSP.setBounds(650, 30, 200, 300);
		
		
		ImageIcon avatarIcon = new ImageIcon("src\\images\\avatarSP.png");

		// Lấy kích thước mới của JLabel
		int labelWidth = avatarSP.getWidth();
		int labelHeight = avatarSP.getHeight();

		// Chỉnh kích thước ảnh theo JLabel
		Image avatar = avatarIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		avatarIcon = new ImageIcon(avatar);

		avatarSP.setIcon(avatarIcon);
		
		btnChonAnh = new JButton("Chọn ảnh");
		btnChonAnh.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chọn ảnh");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				int result = fileChooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					// Đoạn mã xử lý khi người dùng chọn tệp ảnh ở đây
					url = fileChooser.getSelectedFile().getAbsolutePath();
					ImageIcon avatarIcon = new ImageIcon(url);

					// Lấy kích thước mới của JLabel
					int labelWidth = avatarSP.getWidth();
					int labelHeight = avatarSP.getHeight();

					// Chỉnh kích thước ảnh theo JLabel
					Image avatar = avatarIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
					avatarIcon = new ImageIcon(avatar);

					avatarSP.setIcon(avatarIcon);

				}
				
			}
		});
		
		btnGoAnh = new JButton("Gỡ ảnh");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
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
							.addComponent(textDonViTinh, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblGhiCh, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textGhiChu, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
								.addComponent(lblThongBao, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(48)
							.addComponent(avatarSP, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addGap(42))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnGoAnh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnChonAnh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(102))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
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
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGhiCh)
								.addComponent(textGhiChu, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblThongBao, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(36)
							.addComponent(avatarSP, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnChonAnh)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnGoAnh)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);

		textIDSP.setText(String.format("SP%04d", sp_Bus.getAllSanPham().size() + 1));
		
		btnHuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
	
	/**
	 * Lấy dữ liệu sản phẩm từ textField
	 * @return
	 */
	public SanPham getDataSanPham() {
		SanPham sp = null;
		String idSP = String.format("SP%04d", sp_Bus.getAllSanPham().size() + 1);
		String tenSP = textTenSP.getText();
		if (tenSP.trim().isEmpty()) {
			lblThongBao.setText("Tên sản phầm không được để trống!");
			textTenSP.selectAll();
			textTenSP.requestFocus();
			return null;
		}
		double donGia = 0;
		try {
			donGia = Double.parseDouble(textDonGia.getText());
			if (donGia <= 0) {
				lblThongBao.setText("Đơn giá sản phầm phải là số dương!");
				textDonGia.selectAll();
				textDonGia.requestFocus();
				return null;
			}
		} catch (NumberFormatException e) {
			lblThongBao.setText("Đơn giá sản phầm phải là chữ số!");
			textDonGia.selectAll();
			textDonGia.requestFocus();
			return null;
		}
		String chatLieu = textChatLieu.getText();
		if(chatLieu.trim().isEmpty()) {
			lblThongBao.setText("Chất liệu không được để trống!");
			textChatLieu.selectAll();
			textChatLieu.requestFocus();
			return null;
		}
		String donViTinh = textDonViTinh.getText();
		if (donViTinh.trim().isEmpty()) {
			lblThongBao.setText("Đơn vị tính không được để trống!");
			textDonViTinh.selectAll();
			textDonViTinh.requestFocus();
			return null;
		}
		String ghiChu = textGhiChu.getText();
		String avatar = "avatarSP.png";
		if (url != null) {
			File absoluteFile = new File(url);
			avatar = absoluteFile.getName();

		}
		sp = new SanPham(idSP, tenSP, donGia, chatLieu, donViTinh, ghiChu, avatar);
		return sp;
	}
	
	/**
	 * Thêm sản phẩm
	 */
	private void themSanPham() {
		SanPham sp = new SanPham();
		sp = getDataSanPham();
		if (sp != null) {
			sp_Bus.themSanPham(sp);
			JOptionPane.showMessageDialog(this, "Thêm thành công!");
			this.dispose();
		}
	}
}
