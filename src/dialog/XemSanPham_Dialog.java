package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commons.MyButton;
import commons.RoundPanel;
import entities.SanPham;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

import bus.SanPham_BUS;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class XemSanPham_Dialog extends JDialog implements ActionListener{

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
	private String url;
	//
	private SanPham sp = new SanPham();
	private JLabel lblThongBao;
	private JLabel avatarSP;
	
	public void openThemSanPham_Dialog(int width, int height, String id) {
		this.width = width;
		this.height = height;
		new XemSanPham_Dialog(id).setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public XemSanPham_Dialog(String id) {
		getContentPane().setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initComponents(id);
	}
	
	public void initComponents(String id) {
		setTitle("Xem sản phẩm");
		setBounds(100, 100, 766, 467);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setBounds(0, 0, 752, 355);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setBounds(0, 361, 752, 59);
			buttonPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
			buttonPane.setPreferredSize(new Dimension(this.width, (int) (this.height*0.05)));
			{
				btnCapNhat = new MyButton();
				btnCapNhat.setRadius(10);
				btnCapNhat.setForeground(new Color(0, 0, 0));
				btnCapNhat.setIcon(new ImageIcon(XemSanPham_Dialog.class.getResource("/icon/update.png")));
				btnCapNhat.setText("Cập nhật");
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
						.addGap(268)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(397, Short.MAX_VALUE))
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
		panel_1 = new RoundPanel();
		panel_1.setBounds(5, 5, 738, 348);
		panel_1.setRound(10);
		panel_1.setOpaque(false);
		textGhiChu = new JTextArea();
		textGhiChu.setBounds(175, 236, 274, 45);
		textGhiChu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textGhiChu.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblNewLabel = new JLabel("ID sản phẩm:");
		lblNewLabel.setBounds(10, 21, 104, 20);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setBounds(10, 62, 104, 20);
		lblTnSnPhm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblnGi = new JLabel("Đơn giá:");
		lblnGi.setBounds(10, 102, 104, 20);
		lblnGi.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblChtLiu = new JLabel("Chất liệu:");
		lblChtLiu.setBounds(10, 146, 104, 20);
		lblChtLiu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblnVTnh = new JLabel("Đơn vị tính:");
		lblnVTnh.setBounds(10, 194, 104, 20);
		lblnVTnh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblGhiCh = new JLabel("Ghi chú:");
		lblGhiCh.setBounds(10, 236, 104, 20);
		lblGhiCh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		textIDSP = new JTextField();
		textIDSP.setBounds(175, 21, 274, 21);
		textIDSP.setDisabledTextColor(new Color(0, 0, 0));
		textIDSP.setEditable(false);
		textIDSP.setEnabled(false);
		textIDSP.setBackground(new Color(240, 240, 240));
		textIDSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textIDSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textIDSP.setColumns(10);
		
		textTenSP = new JTextField();
		textTenSP.setBounds(175, 60, 274, 26);
		textTenSP.setEditable(false);
		textTenSP.setBackground(new Color(240, 240, 240));
		textTenSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textTenSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textTenSP.setColumns(10);
		
		textDonGia = new JTextField();
		textDonGia.setBounds(175, 100, 274, 26);
		textDonGia.setBackground(new Color(240, 240, 240));
		textDonGia.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textDonGia.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textDonGia.setColumns(10);
		
		textChatLieu = new JTextField();
		textChatLieu.setBounds(175, 144, 274, 26);
		textChatLieu.setBackground(new Color(240, 240, 240));
		textChatLieu.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textChatLieu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textChatLieu.setColumns(10);
		
		textDonViTinh = new JTextField();
		textDonViTinh.setBounds(175, 188, 274, 26);
		textDonViTinh.setBackground(new Color(240, 240, 240));
		textDonViTinh.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textDonViTinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textDonViTinh.setColumns(10);
		
		lblThongBaoDonViTinh = new JLabel();
		lblThongBaoDonViTinh.setBounds(616, 430, 274, 13);
		lblThongBaoDonViTinh.setForeground(Color.RED);
		lblThongBaoDonViTinh.setFont(new Font("SansSerif", Font.ITALIC, 15));
		
		lblThongBao = new JLabel("");
		lblThongBao.setBounds(175, 441, 274, 34);
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("SansSerif", Font.ITALIC, 15));
		
		avatarSP = new JLabel();
		avatarSP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		avatarSP.setBounds(493, 21, 211, 209);
		
	
		
		
		JButton btnChonAnh = new JButton("Chọn ảnh");
		btnChonAnh.setBounds(558, 260, 90, 20);
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
		
	
		getContentPane().setLayout(null);
		getContentPane().add(buttonPane);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel);
		panel_1.add(textIDSP);
		panel_1.add(lblTnSnPhm);
		panel_1.add(textTenSP);
		panel_1.add(lblnGi);
		panel_1.add(textDonGia);
		panel_1.add(lblChtLiu);
		panel_1.add(textChatLieu);
		panel_1.add(lblnVTnh);
		panel_1.add(textDonViTinh);
		panel_1.add(lblGhiCh);
		panel_1.add(textGhiChu);
		panel_1.add(lblThongBao);
		panel_1.add(lblThongBaoDonViTinh);
		panel_1.add(avatarSP);
		panel_1.add(btnChonAnh);

		layDuLieuSanPham(id);
		duaDuLieuLenTextField();
		
		btnCapNhat.addActionListener(this);
		btnHuy.addActionListener(this);
	}
	
	/**
	 * Lấy dữ liệu sản phẩm
	 * @param id
	 */
	private void layDuLieuSanPham(String id) {
		SanPham_BUS sPham_BUS = new SanPham_BUS();
		sp = sPham_BUS.getSanPhamTheoID(id);
	}
	
	/**
	 * Đưa dữ liệu lên textfield
	 */
	private void duaDuLieuLenTextField() {
		textIDSP.setText(sp.getIdSanPham());
		textTenSP.setText(sp.getTenSanPham());
		textDonGia.setText(sp.getDonGia() + "");
		textChatLieu.setText(sp.getChatLieu());
		textDonViTinh.setText(sp.getDonViTinh());
		textGhiChu.setText(sp.getGhiChu());
		
		
		
		ImageIcon avatarIcon = new ImageIcon("src\\images\\"+sp.getAnhSanPham());

		// Lấy kích thước mới của JLabel
		int labelWidth = avatarSP.getWidth();
		int labelHeight = avatarSP.getHeight();

		// Chỉnh kích thước ảnh theo JLabel
		Image avatar = avatarIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
		avatarIcon = new ImageIcon(avatar);

		avatarSP.setIcon(avatarIcon);
		
	}
	
	public SanPham getDataSanPham() {
		SanPham sp = null;
		String idSP = textIDSP.getText();
		String tenSP = textTenSP.getText();
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
	
	private void capNhatSanPham() {
		SanPham temp = getDataSanPham();
		if (temp != null) {
			if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thay đổi không?", "Hỏi nhắc", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				SanPham_BUS sPham_BUS = new SanPham_BUS();
				sPham_BUS.capNhatSanPham(temp);
				JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnHuy)) {
			this.dispose();
		}
		else if (o.equals(btnCapNhat)) {
			capNhatSanPham();
			this.dispose();
		}
	}
}
