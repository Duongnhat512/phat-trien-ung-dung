package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import commons.MyButton;
import commons.Table;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class ThemHopDong_Dialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private int width = 900;
	private int height = 800;
	private MyButton btnThem;
	private MyButton btnHuy;
	private JPanel buttonPane;
	private JLabel lblTnHpng;
	private JLabel lblNgyBtu;
	private JLabel lblNgyKtThc;
	private JTextField txtID;
	private JTextField txtTenHopDong;
	private JTextField txtNgayBatDau;
	private JTextField txtNgayKetThuc;
	private JLabel lblNhnVinPh;
	private JComboBox cboNhanVien;
	private JLabel lblGhiCh;
	private JLabel lblTngTinHp;
	private JLabel lblTongTien;
	private MyButton btnThemSP;
	private Table tableCTHopDong;
	private JLabel lblIdSnPhm;
	private JTextField txtIDSanPham;
	private JLabel lblTnSnPhm;
	private JTextField txtTenSP;
	private JLabel lblnGi;
	private JTextField txtDonGia;
	private JLabel lblChtLiu;
	private JLabel lblnVTnh;
	private JLabel lblSLngt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblThongBaoSL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ThemHopDong_Dialog dialog = new ThemHopDong_Dialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openThemHopDong_Dialog(int width, int height) {
		this.width = width;
		this.height = height;
		new ThemHopDong_Dialog().setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public ThemHopDong_Dialog() {
		setTitle("Thêm hợp đồng");
		initComponents();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public void initComponents() {
		setBounds(100, 100, this.width, this.height);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setBackground(new Color(240, 240, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(192, 192, 192)));
			buttonPane.setPreferredSize(new Dimension(this.width, (int) (this.height*0.05)));
			{
				btnThem = new MyButton();
				btnThem.setRadius(10);
				btnThem.setForeground(new Color(255, 255, 255));
				btnThem.setIcon(new ImageIcon(ThemHopDong_Dialog.class.getResource("/icon/icons8_plus_math_30px.png")));
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
				btnHuy.setIcon(new ImageIcon(ThemHopDong_Dialog.class.getResource("/icon/unavailable.png")));
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
						.addGap(676)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
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
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 886, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension((int) (this.width*0.4), (int) (this.height*0.4)));
		
		JPanel panelCTHopDong = new JPanel();
		
		JPanel panelSanPham = new JPanel();
		
		lblTngTinHp = new JLabel("Tổng tiền hợp đồng:");
		lblTngTinHp.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblTongTien = new JLabel("");
		lblTongTien.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		btnThemSP = new MyButton();
		btnThemSP.setIcon(new ImageIcon(ThemHopDong_Dialog.class.getResource("/icon/icons8_plus_math_30px.png")));
		btnThemSP.setBackground(new Color(52, 254, 78));
		btnThemSP.setBorderColor(new Color(255, 255, 255));
		btnThemSP.setRadius(10);
		btnThemSP.setFocusPainted(false);
		btnThemSP.setText("Thêm sản phẩm");
		btnThemSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		MyButton btnBoChon = new MyButton();
		btnBoChon.setIcon(new ImageIcon(ThemHopDong_Dialog.class.getResource("/icon/Remove.png")));
		btnBoChon.setBackground(new Color(255, 255, 255));
		btnBoChon.setBorderColor(new Color(255, 255, 255));
		btnBoChon.setText("Bỏ chọn");
		btnBoChon.setRadius(10);
		btnBoChon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnBoChon.setFocusPainted(false);
		
		lblIdSnPhm = new JLabel("ID Sản phẩm:");
		lblIdSnPhm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtIDSanPham = new JTextField();
		txtIDSanPham.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtIDSanPham.setColumns(10);
		txtIDSanPham.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtIDSanPham.setBackground(SystemColor.menu);
		
		lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtTenSP = new JTextField();
		txtTenSP.setEnabled(false);
		txtTenSP.setEditable(false);
		txtTenSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTenSP.setColumns(10);
		txtTenSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTenSP.setBackground(SystemColor.menu);
		
		lblnGi = new JLabel("Đơn giá:");
		lblnGi.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtDonGia = new JTextField();
		txtDonGia.setEnabled(false);
		txtDonGia.setEditable(false);
		txtDonGia.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtDonGia.setColumns(10);
		txtDonGia.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDonGia.setBackground(SystemColor.menu);
		
		lblChtLiu = new JLabel("Chất liệu:");
		lblChtLiu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblnVTnh = new JLabel("Đơn vị tính:");
		lblnVTnh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblSLngt = new JLabel("Số lượng đặt:");
		lblSLngt.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField.setBackground(SystemColor.menu);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBackground(SystemColor.menu);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_2.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel = new JLabel("ID Hợp Đồng:");
		lblNewLabel.setBounds(10, 10, 130, 20);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblTnHpng = new JLabel("Tên hợp đồng:");
		lblTnHpng.setBounds(10, 49, 130, 20);
		lblTnHpng.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblNgyBtu = new JLabel("Ngày bắt đầu:");
		lblNgyBtu.setBounds(10, 87, 130, 20);
		lblNgyBtu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblNgyKtThc = new JLabel("Ngày kết thúc:");
		lblNgyKtThc.setBounds(10, 127, 130, 20);
		lblNgyKtThc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtID = new JTextField();
		txtID.setBounds(179, 10, 209, 21);
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtID.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtID.setColumns(10);
		
		txtTenHopDong = new JTextField();
		txtTenHopDong.setBounds(179, 49, 209, 21);
		txtTenHopDong.setBackground(new Color(240, 240, 240));
		txtTenHopDong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTenHopDong.setColumns(10);
		txtTenHopDong.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		txtNgayBatDau = new JTextField();
		txtNgayBatDau.setBounds(179, 88, 209, 21);
		txtNgayBatDau.setBackground(new Color(240, 240, 240));
		txtNgayBatDau.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtNgayBatDau.setColumns(10);
		txtNgayBatDau.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		txtNgayKetThuc = new JTextField();
		txtNgayKetThuc.setBounds(179, 127, 209, 21);
		txtNgayKetThuc.setBackground(new Color(240, 240, 240));
		txtNgayKetThuc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtNgayKetThuc.setColumns(10);
		txtNgayKetThuc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		lblNhnVinPh = new JLabel("Nhân viên phụ trách:");
		lblNhnVinPh.setBounds(442, 15, 151, 20);
		lblNhnVinPh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		cboNhanVien = new JComboBox();
		cboNhanVien.setBounds(597, 11, 215, 28);
		cboNhanVien.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblGhiCh = new JLabel("Ghi chú:");
		lblGhiCh.setBounds(442, 59, 130, 20);
		lblGhiCh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JTextArea txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(442, 89, 424, 77);
		txtGhiChu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtGhiChu.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblThongBao = new JLabel("");
		lblThongBao.setBounds(10, 158, 378, 20);
		lblThongBao.setForeground(new Color(255, 0, 0));
		lblThongBao.setFont(new Font("SansSerif", Font.ITALIC, 15));
		getContentPane().setLayout(groupLayout);
		panelCTHopDong.setLayout(new BorderLayout(0, 0));
		
		tableCTHopDong = new Table();
		tableCTHopDong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID S\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		tableCTHopDong.getColumnModel().getColumn(1).setPreferredWidth(99);
		JScrollPane scrollPaneCTHD = new JScrollPane();
		scrollPaneCTHD.setBorder(null);
		scrollPaneCTHD.setViewportView(tableCTHopDong);
		panelCTHopDong.add(scrollPaneCTHD, BorderLayout.CENTER);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 876, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(493)
							.addComponent(lblTngTinHp, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelSanPham, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap(586, Short.MAX_VALUE)
							.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnBoChon, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelCTHopDong, GroupLayout.PREFERRED_SIZE, 876, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSanPham, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBoChon, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCTHopDong, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTngTinHp)
						.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(txtID);
		panel.add(lblTnHpng);
		panel.add(txtTenHopDong);
		panel.add(lblNgyBtu);
		panel.add(txtNgayBatDau);
		panel.add(lblNgyKtThc);
		panel.add(txtNgayKetThuc);
		panel.add(lblThongBao);
		panel.add(lblNhnVinPh);
		panel.add(cboNhanVien);
		panel.add(lblGhiCh);
		panel.add(txtGhiChu);
		
		lblThongBaoSL = new JLabel("");
		lblThongBaoSL.setForeground(new Color(255, 0, 0));
		lblThongBaoSL.setFont(new Font("SansSerif", Font.ITALIC, 15));
		GroupLayout gl_panelSanPham = new GroupLayout(panelSanPham);
		gl_panelSanPham.setHorizontalGroup(
			gl_panelSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGap(10)
					.addComponent(lblIdSnPhm, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(txtIDSanPham, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addComponent(lblChtLiu, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGap(10)
					.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addComponent(lblnVTnh, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGap(10)
					.addComponent(lblnGi, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(txtDonGia, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addComponent(lblSLngt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGap(453)
					.addComponent(lblThongBaoSL, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelSanPham.setVerticalGroup(
			gl_panelSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdSnPhm)
						.addComponent(txtIDSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChtLiu)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnSnPhm)
						.addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblnVTnh)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblnGi)
						.addComponent(txtDonGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSLngt)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(lblThongBaoSL, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		);
		panelSanPham.setLayout(gl_panelSanPham);
		contentPanel.setLayout(gl_contentPanel);
		
		//
		btnHuy.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnHuy)) {
			if((JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy không?", "Hỏi nhắc!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
				this.dispose();
			}
		}
		
	}
}
