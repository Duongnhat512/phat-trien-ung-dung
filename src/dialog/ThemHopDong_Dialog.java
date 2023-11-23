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
import entities.ChiTietHopDong;
import entities.HopDongSanPham;
import entities.NhanVien;
import entities.SanPham;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;
import javax.swing.text.Segment;

import bus.ChiTietHopDong_BUS;
import bus.HopDongSanPham_BUS;
import bus.NhanVien_BUS;
import bus.SanPham_BUS;

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
	private JTextField txtIDHopDong;
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
	private JTextField txtSoLuong;
	private JTextField txtDonViTinh;
	private JTextField txtChatLieu;
	private JLabel lblThongBaoSP;
	private MyButton btnBoChon;
	private JLabel lblThongBao;
	private JTextArea txtGhiChu;
	private double tongTien = 0;
	private boolean flag = false;
	
	//
	private ArrayList<ChiTietHopDong> listCTHD;
	private ArrayList<HopDongSanPham> listHD;
	private ArrayList<NhanVien> listTPSanXuat;
	
	//
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//
	private HopDongSanPham_BUS hopDongSanPham_BUS = new HopDongSanPham_BUS();
	private ChiTietHopDong_BUS chiTietHopDong_BUS = new ChiTietHopDong_BUS();
	private SanPham_BUS sanPham_BUS = new SanPham_BUS();
	private NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
	
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
				btnThem.setFocusTraversalKeysEnabled(false);
				btnThem.setFocusable(false);
				btnThem.setActionCommand("ADD");
				btnThem.setRadius(10);
				btnThem.setForeground(new Color(255, 255, 255));
				btnThem.setIcon(new ImageIcon(ThemHopDong_Dialog.class.getResource("/icon/icons8_plus_math_30px.png")));
				btnThem.setText("Thêm");
				btnThem.setFont(new Font("SansSerif", Font.PLAIN, 15));
				btnThem.setFocusPainted(false);
				btnThem.setBackground(new Color(82, 125, 254));
				getRootPane().setDefaultButton(btnThem);
			}
			{
				btnHuy = new MyButton();
				btnHuy.setFocusTraversalKeysEnabled(false);
				btnHuy.setFocusable(false);
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
		panel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		panel.setPreferredSize(new Dimension((int) (this.width*0.4), (int) (this.height*0.4)));
		
		JPanel panelCTHopDong = new JPanel();
		
		JPanel panelSanPham = new JPanel();
		panelSanPham.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		
		lblTngTinHp = new JLabel("Tổng tiền hợp đồng:");
		lblTngTinHp.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblTongTien = new JLabel("");
		lblTongTien.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		btnThemSP = new MyButton();
		btnThemSP.setFocusTraversalKeysEnabled(false);
		btnThemSP.setFocusable(false);
		btnThemSP.setIcon(new ImageIcon(ThemHopDong_Dialog.class.getResource("/icon/icons8_plus_math_30px.png")));
		btnThemSP.setBackground(new Color(52, 254, 78));
		btnThemSP.setBorderColor(new Color(255, 255, 255));
		btnThemSP.setRadius(10);
		btnThemSP.setFocusPainted(false);
		btnThemSP.setText("Thêm sản phẩm");
		btnThemSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		btnBoChon = new MyButton();
		btnBoChon.setFocusTraversalKeysEnabled(false);
		btnBoChon.setFocusable(false);
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
		txtIDSanPham.setBorder(new EmptyBorder(2, 4, 2, 4));
		txtIDSanPham.setBackground(new Color(255, 255, 255));
		
		lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtTenSP = new JTextField();
		txtTenSP.setDisabledTextColor(new Color(0, 0, 0));
		txtTenSP.setEnabled(false);
		txtTenSP.setEditable(false);
		txtTenSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTenSP.setColumns(10);
		txtTenSP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTenSP.setBackground(SystemColor.menu);
		
		lblnGi = new JLabel("Đơn giá:");
		lblnGi.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtDonGia = new JTextField();
		txtDonGia.setDisabledTextColor(new Color(0, 0, 0));
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
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBorder(new EmptyBorder(2, 4, 2, 4));
		txtSoLuong.setBackground(new Color(255, 255, 255));
		
		txtDonViTinh = new JTextField();
		txtDonViTinh.setDisabledTextColor(new Color(0, 0, 0));
		txtDonViTinh.setEnabled(false);
		txtDonViTinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtDonViTinh.setEditable(false);
		txtDonViTinh.setColumns(10);
		txtDonViTinh.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDonViTinh.setBackground(SystemColor.menu);
		
		txtChatLieu = new JTextField();
		txtChatLieu.setDisabledTextColor(new Color(0, 0, 0));
		txtChatLieu.setEnabled(false);
		txtChatLieu.setEditable(false);
		txtChatLieu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtChatLieu.setColumns(10);
		txtChatLieu.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtChatLieu.setBackground(SystemColor.menu);
		
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
		
		txtIDHopDong = new JTextField();
		txtIDHopDong.setBackground(new Color(240, 240, 240));
		txtIDHopDong.setDisabledTextColor(new Color(0, 0, 0));
		txtIDHopDong.setBounds(179, 10, 209, 21);
		txtIDHopDong.setEnabled(false);
		txtIDHopDong.setEditable(false);
		txtIDHopDong.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtIDHopDong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtIDHopDong.setColumns(10);
		
		txtTenHopDong = new JTextField();
		txtTenHopDong.setBounds(179, 49, 209, 21);
		txtTenHopDong.setBackground(new Color(255, 255, 255));
		txtTenHopDong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTenHopDong.setColumns(10);
		txtTenHopDong.setBorder(new EmptyBorder(2, 4, 2, 4));
		
		txtNgayBatDau = new JTextField();
		txtNgayBatDau.setBounds(179, 88, 209, 21);
		txtNgayBatDau.setBackground(new Color(255, 255, 255));
		txtNgayBatDau.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtNgayBatDau.setColumns(10);
		txtNgayBatDau.setBorder(new EmptyBorder(2, 4, 2, 4));
		
		txtNgayKetThuc = new JTextField();
		txtNgayKetThuc.setBounds(179, 127, 209, 21);
		txtNgayKetThuc.setBackground(new Color(255, 255, 255));
		txtNgayKetThuc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtNgayKetThuc.setColumns(10);
		txtNgayKetThuc.setBorder(new EmptyBorder(2, 4, 2, 4));
		
		lblNhnVinPh = new JLabel("Nhân viên phụ trách:");
		lblNhnVinPh.setBounds(442, 15, 151, 20);
		lblNhnVinPh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		cboNhanVien = new JComboBox();
		cboNhanVien.setBounds(597, 11, 215, 28);
		cboNhanVien.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblGhiCh = new JLabel("Ghi chú:");
		lblGhiCh.setBounds(442, 59, 130, 20);
		lblGhiCh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(442, 89, 424, 77);
		txtGhiChu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtGhiChu.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblThongBao = new JLabel("");
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
		scrollPaneCTHD.setViewportView(tableCTHopDong);
		panelCTHopDong.add(scrollPaneCTHD, BorderLayout.CENTER);
		tableCTHopDong.setOpaque(false);
		tableCTHopDong.setBorder(null);
		tableCTHopDong.fixTable(scrollPaneCTHD);
		
		MyButton btnCapNhat = new MyButton();
		btnCapNhat.setFocusTraversalKeysEnabled(false);
		btnCapNhat.setFocusable(false);
		btnCapNhat.setIcon(new ImageIcon(ThemHopDong_Dialog.class.getResource("/icon/update.png")));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setRadius(10);
		btnCapNhat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setBorderColor(Color.WHITE);
		btnCapNhat.setBackground(Color.WHITE);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 876, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addGap(493)
							.addComponent(lblTngTinHp, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelSanPham, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
						.addComponent(panelCTHopDong, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 876, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBoChon, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(20)))
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
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBoChon, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCTHopDong, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTngTinHp)
						.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(txtIDHopDong);
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
		
		lblThongBaoSP = new JLabel("");
		lblThongBaoSP.setForeground(new Color(255, 0, 0));
		lblThongBaoSP.setFont(new Font("SansSerif", Font.ITALIC, 15));
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
					.addComponent(txtChatLieu, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGap(10)
					.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addComponent(lblnVTnh, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(txtDonViTinh, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGap(10)
					.addComponent(lblnGi, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(txtDonGia, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addComponent(lblSLngt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGap(453)
					.addComponent(lblThongBaoSP, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelSanPham.setVerticalGroup(
			gl_panelSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdSnPhm)
						.addComponent(txtIDSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChtLiu)
						.addComponent(txtChatLieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnSnPhm)
						.addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblnVTnh)
						.addComponent(txtDonViTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
						.addComponent(lblnGi)
						.addComponent(txtDonGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSLngt)
						.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(lblThongBaoSP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		);
		panelSanPham.setLayout(gl_panelSanPham);
		contentPanel.setLayout(gl_contentPanel);
		
		lblTongTien.setText(String.format("%,.2f VND", tongTien));
		
		// Cài đặt giá trị mặc đinh cho txtNgayBatDau là ngày hiện hành
		txtNgayBatDau.setText(dtf.format(LocalDate.now()));
		
		// 
		listCTHD = new ArrayList<ChiTietHopDong>();
		listTPSanXuat = new ArrayList<NhanVien>();
		
		//Đưa dữ liệu lên cboNhanVien
		getDataTPSX();
		//
		listHD = hopDongSanPham_BUS.getAllHopDongSanPham();
		
//		 Hiển thị IDHopDong
		txtIDHopDong.setText(String.format("HD%04d", listHD.size() + 1));
		
		
		//
		btnHuy.addActionListener(this);
		btnThemSP.addActionListener(this);
		btnBoChon.addActionListener(this);
		
		
		btnThem.addActionListener(this);
		
		// Sự kiện hiển thị thông tin sau khi nhập mã sản phẩm ở txtIDSanPham
		txtIDSanPham.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtIDSanPham.getText().trim().length() > 6) {
					txtIDSanPham.setText(txtIDSanPham.getText().substring(0, 6));
				}
				if (txtIDSanPham.getText().trim().length() == 6) {
					timSanPham();
				}
			}
		});
	}
	
	/**
	 * Lấy dữ liệu trưởng phòng sản xuất
	 */
	private void getDataTPSX() {
		listTPSanXuat = nhanVien_BUS.getDanHSachNhanVienTheoChucVu("CV003");
		String[] item = new String[listTPSanXuat.size()];
		int i = 0;
		for (NhanVien nv : listTPSanXuat) {
			item[i] = nv.getHoTen();
			i++;
		}
		cboNhanVien.setModel(new DefaultComboBoxModel<>(item));
		cboNhanVien.setSelectedIndex(0);
	}
	
	/**
	 * Kiểm tra dữ liệu nhập vào cho hợp đồng
	 */
	private boolean kiemTraDuLieuHopDong() {
		if (txtTenHopDong.getText().trim().isEmpty()) {
			lblThongBao.setText("Tên hợp đồng không được để trống!");
			txtTenHopDong.selectAll();
			txtTenHopDong.requestFocus();
			return false;
		}
		String tenHopDong = txtTenHopDong.getText();
		if (!tenHopDong.matches("^[\\p{L}]+([\\s]+[\\p{L}]+)*")) {
			lblThongBao.setText("Tên hợp đồng không được chứa ký tự đặc biệt!");
			txtTenHopDong.selectAll();
			txtTenHopDong.requestFocus();
			return false;
		}
		if (txtNgayBatDau.getText().trim().isEmpty()) {
			lblThongBao.setText("Ngày bắt đầu không được để trống");
			txtNgayBatDau.selectAll();
			txtNgayBatDau.requestFocus();
			return false;
		}
		LocalDate ngayBatDau = LocalDate.parse(txtNgayBatDau.getText(), dtf);
		if (txtNgayKetThuc.getText().trim().isEmpty()) {
			lblThongBao.setText("Ngày kết thúc không được để trống");
			txtNgayKetThuc.selectAll();
			txtNgayKetThuc.requestFocus();
			return false;
		}
		LocalDate ngayKetThuc = LocalDate.parse(txtNgayKetThuc.getText(), dtf);
		if (!ngayKetThuc.isAfter(ngayBatDau)) {
			lblThongBao.setText("Ngày kết thúc hợp đồng phải sau ngày bắt đầu!");
			txtNgayKetThuc.selectAll();
			txtNgayKetThuc.requestFocus();
			return false;
		}
		lblThongBao.setText("");
		return true;
	}
	
	/**
	 * Thêm hợp đồng
	 */
	private void themHopDong() {
		if (listCTHD.size() == 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa thêm sản phẩm nào vào hợp đồng!");
			return;
		}
		if(kiemTraDuLieuHopDong()) {
			String idHopDong = txtIDHopDong.getText();
			String tenHopDong = txtTenHopDong.getText();
			LocalDate ngayBatDau = LocalDate.parse(txtNgayBatDau.getText(), dtf);
			LocalDate ngayKetThuc = LocalDate.parse(txtNgayKetThuc.getText(), dtf);
			String ghiChu = null;
			if (!txtGhiChu.getText().trim().isEmpty()) {
				ghiChu = txtGhiChu.getText();
			}
			NhanVien nv = listTPSanXuat.get(cboNhanVien.getSelectedIndex());
			double tongTien = 0;
			for (ChiTietHopDong chiTietHopDong : listCTHD) {
				tongTien+= chiTietHopDong.getThanhTien();
			}
			HopDongSanPham hd = new HopDongSanPham(idHopDong, tenHopDong, ngayBatDau, ngayKetThuc, nv, tongTien, ghiChu);
			hopDongSanPham_BUS.themHopDong(hd);
			for (ChiTietHopDong chiTietHopDong : listCTHD) {
				chiTietHopDong.setHopDongSanPham(hd);
				chiTietHopDong.setTrangThai(false);
				chiTietHopDong_BUS.themCTHopDong(chiTietHopDong);
			}
			JOptionPane.showMessageDialog(this, "Thêm hợp đồng thành công!");
			flag = true;
			this.dispose();
		}
		
	}
	
	/**
	 * Thêm sản phẩm vào chi tiết hợp đồng tạm thời
	 */
	private void themSanPhamVaoDanhSach() {
		ChiTietHopDong ctHD = getDuLieuCTHopDong();
		if (ctHD != null) {
			listCTHD.add(ctHD);
			tongTien+= ctHD.getThanhTien();
			lblTongTien.setText(String.format("%,.2f VND", tongTien));
		}
	}
	
	/**
	 * Lấy dữ liệu chi tiết hợp đồng để hiển thị lên table
	 * @return
	 */
	private ChiTietHopDong getDuLieuCTHopDong() {
		HopDongSanPham hopDongSanPham = new HopDongSanPham(txtIDHopDong.getText());
		SanPham sp = sanPham_BUS.getSanPhamTheoID(txtIDSanPham.getText());
		int soLuong = 0;
		try {
			soLuong = Integer.parseInt(txtSoLuong.getText());
			if (soLuong <= 0) {
				lblThongBaoSP.setText("Số lượng phải là số dương!");
				txtSoLuong.selectAll();
				txtSoLuong.requestFocus();
				return null;
			}
			else {
				lblThongBaoSP.setText("");
			}
		} catch (NumberFormatException e) {
			lblThongBaoSP.setText("Số lượng phải là chữ số!");
			txtSoLuong.selectAll();
			txtSoLuong.requestFocus();
			return null;
		}
		ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hopDongSanPham, sp, soLuong);
		if (listCTHD.contains(chiTietHopDong)) {
			lblThongBaoSP.setText("Sản phẩm trên đã được thêm vào hợp đồng!");
			return null;
		}
		lblThongBaoSP.setText("Thêm thành công!");
		return chiTietHopDong;
	}
	
	/**
	 * Đọc dữ liệu lên bảng chi tiết hợp đồng khi vừa thêm sản phẩm vào hợp đồng
	 */
	private void docDuLieuLenBangCTHD() {
		DefaultTableModel dm = (DefaultTableModel) tableCTHopDong.getModel();
		dm.getDataVector().removeAllElements();
		
		for (ChiTietHopDong chiTietHopDong : listCTHD) {
			dm.addRow(new Object[] {chiTietHopDong.getSanPham().getIdSanPham(), chiTietHopDong.getSanPham().getTenSanPham(), chiTietHopDong.getSoLuong(), chiTietHopDong.getSanPham().getDonGia(), chiTietHopDong.getThanhTien()});
		}
		tableCTHopDong.clearSelection();
		tableCTHopDong.repaint();
		tableCTHopDong.revalidate();
	}
	
	/**
	 * Tìm sản phẩm theo mã sản phẩm đã nhập ở txtIDSanPham
	 */
	private void timSanPham() {
		String idSP = txtIDSanPham.getText().toUpperCase().trim();
		SanPham sp = sanPham_BUS.getSanPhamTheoID(idSP);
		if (sp != null) {
			hienThiThongTinSanPham(sp);
			
		}
	}
	
	/**
	 * Hiển thị thông tin sản phẩm lên textField
	 * @param sp
	 */
	private void hienThiThongTinSanPham(SanPham sp) {
		txtTenSP.setText(sp.getTenSanPham());
		txtDonGia.setText(sp.getDonGia() + "");
		txtChatLieu.setText(sp.getChatLieu());
		txtDonViTinh.setText(sp.getDonViTinh());
		txtSoLuong.setText("1");
	}
	
	/**
	 * Bỏ chọn sản phẩm
	 */
	private void boChonSanPham() {
		int row = tableCTHopDong.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm còn bỏ chọn.");
			return;
		}
		if (JOptionPane.showConfirmDialog(this, "Bạn có muốn bỏ chọn sản phẩm này không?", "Hỏi nhắc!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			listCTHD.remove(row);
			docDuLieuLenBangCTHD();
		}
	}
	
	public boolean getFlag() {
		return flag;
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
		if (o.equals(btnThemSP)) {
			if (txtIDSanPham.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Bạn cần nhập mã sản phẩm cần thêm vào hợp đồng!");
			}
			else {
				themSanPhamVaoDanhSach();
				docDuLieuLenBangCTHD();
			}
		}
		if (o.equals(btnBoChon)) {
			boChonSanPham();
		}
		if (o.equals(btnThem)) {
			themHopDong();
		}
		
	}
}
