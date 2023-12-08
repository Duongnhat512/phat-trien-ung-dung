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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class XemHopDong_Dialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private int width = 900;
	private int height = 800;
	private MyButton btnDong;
	private JPanel buttonPane;
	private JLabel lblTnHpng;
	private JLabel lblNgyBtu;
	private JLabel lblNgyKtThc;
	private JTextField txtIDHopDong;
	private JLabel lblNhnVinPh;
	private JLabel lblGhiCh;
	private JLabel lblTngTinHp;
	private JLabel lblTongTien;
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
	private JLabel lblThongBao;
	private JTextArea txtGhiChu;
	private double tongTien = 0;
	private HopDongSanPham hd = new HopDongSanPham();
	
	//
	private ArrayList<ChiTietHopDong> cthd = new ArrayList<ChiTietHopDong>();
	
	//
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//
	private HopDongSanPham_BUS hopDongSanPham_BUS = new HopDongSanPham_BUS();
	private ChiTietHopDong_BUS chiTietHopDong_BUS = new ChiTietHopDong_BUS();
	private SanPham_BUS sanPham_BUS = new SanPham_BUS();
	private NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
	private JTextField txtNhanVien;
	private JTextField txtTenHopDong;
	private JTextField txtNgayBatDau;
	private JTextField txtNgayKetThuc;
	
//	public void openXemHopDong_Dialog(int width, int height) {
//		this.width = width;
//		this.height = height;
//		new XemHopDong_Dialog().setVisible(true);
//	}
	
	/**
	 * Create the dialog.
	 */
	public XemHopDong_Dialog(String idHD) {
		setTitle("Thêm hợp đồng");
		initComponents();
		hd = hopDongSanPham_BUS.getHopDongSanPhamTheoID(idHD);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		duaDuLieuHDLenTextField();
		docDuLieuCTHDLenTable();
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
				btnDong = new MyButton();
				btnDong.setFocusTraversalKeysEnabled(false);
				btnDong.setFocusable(false);
				btnDong.setRadius(10);
				btnDong.setIcon(new ImageIcon(XemHopDong_Dialog.class.getResource("/icon/unavailable.png")));
				btnDong.setText("Đóng");
				btnDong.setFont(new Font("SansSerif", Font.PLAIN, 15));
				btnDong.setFocusPainted(false);
				btnDong.setBackground(new Color(255, 81, 81));
				btnDong.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(784)
						.addComponent(btnDong, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnDong, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
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
		panelCTHopDong.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panelSanPham = new JPanel();
		panelSanPham.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		
		lblTngTinHp = new JLabel("Tổng tiền hợp đồng:");
		lblTngTinHp.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblTongTien = new JLabel("");
		lblTongTien.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblIdSnPhm = new JLabel("ID Sản phẩm:");
		lblIdSnPhm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtIDSanPham = new JTextField();
		txtIDSanPham.setDisabledTextColor(new Color(0, 0, 0));
		txtIDSanPham.setEnabled(false);
		txtIDSanPham.setEditable(false);
		txtIDSanPham.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtIDSanPham.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtIDSanPham.setBackground(new Color(240, 240, 240));
		
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
		txtSoLuong.setDisabledTextColor(new Color(0, 0, 0));
		txtSoLuong.setEnabled(false);
		txtSoLuong.setEditable(false);
		txtSoLuong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtSoLuong.setBackground(new Color(240, 240, 240));
		
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
		lblNewLabel.setBounds(10, 15, 130, 20);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblTnHpng = new JLabel("Tên hợp đồng:");
		lblTnHpng.setBounds(10, 59, 130, 20);
		lblTnHpng.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblNgyBtu = new JLabel("Ngày bắt đầu:");
		lblNgyBtu.setBounds(10, 94, 130, 20);
		lblNgyBtu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblNgyKtThc = new JLabel("Ngày kết thúc:");
		lblNgyKtThc.setBounds(10, 130, 130, 20);
		lblNgyKtThc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtIDHopDong = new JTextField();
		txtIDHopDong.setEnabled(false);
		txtIDHopDong.setBackground(new Color(240, 240, 240));
		txtIDHopDong.setDisabledTextColor(new Color(0, 0, 0));
		txtIDHopDong.setBounds(143, 10, 245, 21);
		txtIDHopDong.setEditable(false);
		txtIDHopDong.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtIDHopDong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtIDHopDong.setColumns(10);
		
		lblNhnVinPh = new JLabel("Nhân viên phụ trách:");
		lblNhnVinPh.setBounds(442, 15, 151, 20);
		lblNhnVinPh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
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
		scrollPaneCTHD.setBorder(new EmptyBorder(1, 1, 1, 1));
		scrollPaneCTHD.setViewportView(tableCTHopDong);
		panelCTHopDong.add(scrollPaneCTHD, BorderLayout.CENTER);
		tableCTHopDong.setOpaque(false);
		tableCTHopDong.setBorder(null);
		tableCTHopDong.fixTable(scrollPaneCTHD);
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
						.addComponent(panelSanPham, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
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
					.addComponent(panelCTHopDong, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTngTinHp)
						.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(txtIDHopDong);
		panel.add(lblTnHpng);
		panel.add(lblNgyBtu);
		panel.add(lblNgyKtThc);
		panel.add(lblThongBao);
		panel.add(lblNhnVinPh);
		panel.add(lblGhiCh);
		panel.add(txtGhiChu);
		
		txtNhanVien = new JTextField();
		txtNhanVien.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtNhanVien.setEnabled(false);
		txtNhanVien.setEditable(false);
		txtNhanVien.setDisabledTextColor(Color.BLACK);
		txtNhanVien.setColumns(10);
		txtNhanVien.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNhanVien.setBackground(SystemColor.menu);
		txtNhanVien.setBounds(620, 13, 209, 21);
		panel.add(txtNhanVien);
		
		txtTenHopDong = new JTextField();
		txtTenHopDong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTenHopDong.setEnabled(false);
		txtTenHopDong.setEditable(false);
		txtTenHopDong.setDisabledTextColor(Color.BLACK);
		txtTenHopDong.setColumns(10);
		txtTenHopDong.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTenHopDong.setBackground(SystemColor.menu);
		txtTenHopDong.setBounds(143, 52, 245, 21);
		panel.add(txtTenHopDong);
		
		txtNgayBatDau = new JTextField();
		txtNgayBatDau.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtNgayBatDau.setEnabled(false);
		txtNgayBatDau.setEditable(false);
		txtNgayBatDau.setDisabledTextColor(Color.BLACK);
		txtNgayBatDau.setColumns(10);
		txtNgayBatDau.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNgayBatDau.setBackground(SystemColor.menu);
		txtNgayBatDau.setBounds(143, 90, 245, 21);
		panel.add(txtNgayBatDau);
		
		txtNgayKetThuc = new JTextField();
		txtNgayKetThuc.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtNgayKetThuc.setEnabled(false);
		txtNgayKetThuc.setEditable(false);
		txtNgayKetThuc.setDisabledTextColor(Color.BLACK);
		txtNgayKetThuc.setColumns(10);
		txtNgayKetThuc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNgayKetThuc.setBackground(SystemColor.menu);
		txtNgayKetThuc.setBounds(143, 130, 245, 21);
		panel.add(txtNgayKetThuc);
		
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
		
		//
		btnDong.addActionListener(this);
		tableCTHopDong.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				duaDuLieuCTHDLenTextField();
			}
		});
	}
	
	/**
	 * Đưa dữ liệu hợp đồng lên text field
	 */
	private void duaDuLieuHDLenTextField() {
		txtIDHopDong.setText(hd.getIdHopDong());
		txtTenHopDong.setText(hd.getTenHopDong());
		txtNgayBatDau.setText(dtf.format(hd.getNgayBatDau()));
		txtNgayKetThuc.setText(dtf.format(hd.getNgayKetThuc()));
		txtNhanVien.setText(hd.getNguoiQuanLy().getHoTen());
		txtGhiChu.setText(hd.getGhiChu());
		lblTongTien.setText(String.format("%,.2f VND", hd.getTongTien()));
	}
	
	/**
	 * Đọc dữ liệu chi tiết hợp đồng lên table
	 */
	public void docDuLieuCTHDLenTable() {
		cthd = chiTietHopDong_BUS.getChiTietHopDongTheoIDHopDong(hd.getIdHopDong());
		DefaultTableModel dm = (DefaultTableModel) tableCTHopDong.getModel();
		for (ChiTietHopDong chiTietHopDong : cthd) {
			dm.addRow(new Object[] {chiTietHopDong.getSanPham().getIdSanPham(), chiTietHopDong.getSanPham().getTenSanPham(), 
					chiTietHopDong.getSoLuong(), chiTietHopDong.getSanPham().getDonGia() + " VND", 
					String.format("%,.2f VND", chiTietHopDong.getThanhTien())});
		}
	}
	
	/**
	 * Đưa dữ liệu chi tiết hợp đồng lên textField
	 */
	private void duaDuLieuCTHDLenTextField() {
		int row = tableCTHopDong.getSelectedRow();
		if (row == -1) {
			return;
		}
		SanPham sp = sanPham_BUS.getSanPhamTheoID(tableCTHopDong.getValueAt(row, 0).toString());
		txtIDSanPham.setText(sp.getIdSanPham());
		txtTenSP.setText(sp.getTenSanPham());
		txtDonGia.setText(sp.getDonGia() + " VND");
		txtChatLieu.setText(sp.getChatLieu());
		txtSoLuong.setText(tableCTHopDong.getValueAt(row, 2).toString());
		txtDonViTinh.setText(sp.getDonViTinh());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDong)) {
			this.dispose();
		}
		
	}
}
