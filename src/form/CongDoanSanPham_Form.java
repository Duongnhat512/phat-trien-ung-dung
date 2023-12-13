package form;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import bus.ChiTietHopDong_BUS;
import bus.CongDoanSanPham_BUS;
import bus.HopDongSanPham_BUS;
import bus.SanPham_BUS;
import commons.MyButton;
import commons.RoundPanel;
import commons.RoundTextField;
import commons.Table;
import connectDB.ConnectDB;
import entities.ChiTietHopDong;
import entities.CongDoanSanPham;
import entities.NhanVien;
import entities.SanPham;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;

public class CongDoanSanPham_Form extends JPanel implements ActionListener, FocusListener {

	private Table tableSP;

	private Table tableCDSP;
	private DefaultTableModel modelSP;
	private DefaultTableModel modelCDSP;
	private JTextField txtHienThiIDSP;
	private JTextField txtHienThiTenSP;
	private JTextField txtHienThiLuongCD;
	private JTextField txtHienThiTenCD;
	private int width = 1259;
	private int height = 813;
	private String idSP;
	private SanPham_BUS sp_bus;
	private MyButton btnThem;
	private MyButton btnCapNhat;
	private CongDoanSanPham_BUS cdsp_bus;

	private ArrayList<CongDoanSanPham> listCDSP;
	private JTextField txtIDSP;
	private JTextField txtTenSP;
	private JTextField txtTenCongDoan;
	private JTextField txtLuongCD;

	private MyButton btnThemCD;

	private MyButton btnHuy;

	private MyButton btnCapNhatCD;

	private JDialog dialog;
	private RoundTextField txtTim;

	private JComboBox<String> cb_TrangThai;

	private ChiTietHopDong_BUS cthd_bus;
	private JTextField txtCheckTen;
	private JTextField txtCheckLuong;

	public CongDoanSanPham_Form(int width, int height) {
		this.width = width;
		this.height = height;
//		moDialogThemCDSP(idSP);
		giaoDienCDSP();
	}

	private void giaoDienCDSP() {
		try {
			ConnectDB.getInstance().connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sp_bus = new SanPham_BUS();
		cdsp_bus = new CongDoanSanPham_BUS();
		cthd_bus = new ChiTietHopDong_BUS();
		setForeground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1259, 780));
		JPanel panel_CongDoanSanPham = new JPanel();
		panel_CongDoanSanPham.setBackground(new Color(213, 213, 213));

		panel_CongDoanSanPham.setLayout(null);

		JPanel panel_North = new JPanel();
		panel_North.setBackground(null);
		panel_North.setBounds(10, 10, 1239, 378);
		panel_CongDoanSanPham.add(panel_North);
		panel_North.setLayout(null);

		RoundPanel panel_BangSP = new RoundPanel();
		panel_BangSP.setBounds(0, 0, 612, 368);
		panel_BangSP.setBackground(new Color(255, 255, 255));
		panel_BangSP.setRound(30);
		panel_North.add(panel_BangSP);

		String[] headers = { "ID", "Tên sản phẩm" };
		modelSP = new DefaultTableModel(headers, 0);
		panel_BangSP.setLayout(null);

		tableSP = new Table();
		tableSP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableSP.setModel(modelSP);
		tableSP.getColumnModel().getColumn(1).setPreferredWidth(110);
		tableSP.setOpaque(false);
		// Cài đặt header cho table Chấm công

		JScrollPane scrollPaneSP = new JScrollPane();
		scrollPaneSP.setBounds(10, 93, 592, 265);
		scrollPaneSP.setBackground(new Color(255, 255, 255));
		scrollPaneSP.setOpaque(false);
		scrollPaneSP.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPaneSP.setViewportView(tableSP);
		panel_BangSP.add(scrollPaneSP);
		tableSP.fixTable(scrollPaneSP);

		RoundPanel panellblBangSP = new RoundPanel();
		panellblBangSP.setRound(30);
		panellblBangSP.setBackground(new Color(153, 204, 255));
		panellblBangSP.setBounds(10, 50, 592, 40);
		panel_BangSP.add(panellblBangSP);
		panellblBangSP.setLayout(new BorderLayout(0, 0));

		JLabel lblSp = new JLabel("Bảng sản phẩm");
		lblSp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSp.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panellblBangSP.add(lblSp, BorderLayout.CENTER);

		txtTim = new RoundTextField(30);
		txtTim.setText(" Nhập mã sản phẩm cần tìm...");
		txtTim.setBackground(new Color(230, 230, 230));
		txtTim.setBorder(null);
		txtTim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTim.setBounds(10, 10, 326, 30);
		txtTim.addKeyListener(new KeyAdapter() {
			@Override
        	public void keyReleased(KeyEvent e) {
				
					if (!txtTim.getText().trim().isEmpty()) {
	        			String str = txtTim.getText().toUpperCase();
	        			ArrayList<SanPham> SanPham =  sp_bus.getListSanPhamTheoID(str);
	        			modelSP.setRowCount(0);
	        			for (SanPham sp : SanPham) {
	        				modelSP.addRow(new Object[] { sp.getIdSanPham(), sp.getTenSanPham()});
						}
					}
	        		else {
						docDuLieuDataAllLenTableSP();
					}
				}
		});

		txtTim.setForeground(Color.GRAY);
		panel_BangSP.add(txtTim);
		txtTim.setColumns(10);
		
		cb_TrangThai = new JComboBox<String>();
		cb_TrangThai.addItem("Sản phẩm mới");
		cb_TrangThai.addItem("Sản phẩm cũ");
		cb_TrangThai.addItem("Tất cả");
		cb_TrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb_TrangThai.setSelectedIndex(2);
		cb_TrangThai.setBounds(346, 10, 256, 30);
		
		panel_BangSP.add(cb_TrangThai);
		ImageIcon iconTimKiem = new ImageIcon("src/icon/search.png");

		RoundPanel panel_ThongTinCD = new RoundPanel();
		panel_ThongTinCD.setBounds(622, 0, 617, 368);
		panel_ThongTinCD.setBackground(new Color(255, 255, 255));
		panel_ThongTinCD.setRound(30);
		panel_North.add(panel_ThongTinCD);
		panel_ThongTinCD.setLayout(null);

		RoundPanel panellblTTCDSP = new RoundPanel();
		panellblTTCDSP.setBounds(10, 10, 597, 40);
		panellblTTCDSP.setRound(30);
		panellblTTCDSP.setBackground(new Color(153, 204, 255));
		panel_ThongTinCD.add(panellblTTCDSP);
		panellblTTCDSP.setLayout(new BorderLayout(0, 0));

		JLabel lblTTCDSP = new JLabel("Thông tin công đoạn");
		lblTTCDSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblTTCDSP.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panellblTTCDSP.add(lblTTCDSP, BorderLayout.CENTER);

		RoundPanel panelbtnThemCapNhat = new RoundPanel();
		panelbtnThemCapNhat.setRound(30);
		panelbtnThemCapNhat.setBackground(new Color(215, 215, 215));
		panelbtnThemCapNhat.setBounds(10, 55, 597, 303);
		panel_ThongTinCD.add(panelbtnThemCapNhat);
		panelbtnThemCapNhat.setLayout(null);

		btnThem = new MyButton();
		ImageIcon iconThem = new ImageIcon("src/icon/add.png");
		btnThem.setIcon(iconThem);
		btnThem.setRadius(10);
		btnThem.setFocusPainted(false);
		btnThem.setText("Thêm");
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setBackground(new Color(193, 224, 255));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnThem.setBounds(103, 251, 150, 42);
		panelbtnThemCapNhat.add(btnThem);

		btnCapNhat = new MyButton();
		ImageIcon iconCapNhat = new ImageIcon("src/icon/update_1.png");
		btnCapNhat.setIcon(iconCapNhat);
		btnCapNhat.setRadius(10);
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setForeground(new Color(0, 0, 0));
		btnCapNhat.setBackground(new Color(193, 224, 255));
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCapNhat.setBounds(355, 249, 150, 44);
		panelbtnThemCapNhat.add(btnCapNhat);

		JLabel lbl_hienThiIDSP = new JLabel("ID sản phẩm:");
		lbl_hienThiIDSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_hienThiIDSP.setBounds(20, 150, 163, 25);
		panelbtnThemCapNhat.add(lbl_hienThiIDSP);

		txtHienThiIDSP = new JTextField();
		txtHienThiIDSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiIDSP.setEditable(false);
		txtHienThiIDSP.setBorder(null);
		txtHienThiIDSP.setBounds(193, 150, 380, 25);
		txtHienThiIDSP.setBackground(null);
		panelbtnThemCapNhat.add(txtHienThiIDSP);
		txtHienThiIDSP.setColumns(10);

		JLabel lbl_hienThiTenSanPham = new JLabel("Tên sản phẩm:");
		lbl_hienThiTenSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_hienThiTenSanPham.setBounds(20, 210, 163, 25);
		panelbtnThemCapNhat.add(lbl_hienThiTenSanPham);

		txtHienThiTenSP = new JTextField();
		txtHienThiTenSP.setEditable(false);
		txtHienThiTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiTenSP.setColumns(10);
		txtHienThiTenSP.setBorder(null);
		txtHienThiTenSP.setBackground(null);
		txtHienThiTenSP.setBounds(193, 210, 380, 25);
		panelbtnThemCapNhat.add(txtHienThiTenSP);

		txtHienThiLuongCD = new JTextField();
		txtHienThiLuongCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiLuongCD.setEditable(false);
		txtHienThiLuongCD.setColumns(10);
		txtHienThiLuongCD.setBorder(null);
		txtHienThiLuongCD.setBackground(null);
		txtHienThiLuongCD.setBounds(193, 90, 380, 25);
		panelbtnThemCapNhat.add(txtHienThiLuongCD);

		JLabel lbl_hienThiLuongCD = new JLabel("Lương công đoạn:");
		lbl_hienThiLuongCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_hienThiLuongCD.setBounds(20, 90, 163, 25);
		panelbtnThemCapNhat.add(lbl_hienThiLuongCD);

		txtHienThiTenCD = new JTextField();
		txtHienThiTenCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtHienThiTenCD.setEditable(false);
		txtHienThiTenCD.setBorder(null);
		txtHienThiTenCD.setColumns(10);
		txtHienThiTenCD.setBackground(null);
		txtHienThiTenCD.setBounds(193, 30, 380, 25);
		panelbtnThemCapNhat.add(txtHienThiTenCD);

		JLabel lbl_hienThiTenCongDoan = new JLabel("Tên công đoạn:");
		lbl_hienThiTenCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_hienThiTenCongDoan.setBounds(20, 30, 163, 25);
		panelbtnThemCapNhat.add(lbl_hienThiTenCongDoan);

		RoundPanel panel_South = new RoundPanel();
		panel_South.setRound(30);
		panel_South.setBounds(10, 388, 1239, 382);
		panel_South.setBackground(new Color(255, 255, 255));
		panel_CongDoanSanPham.add(panel_South);
		panel_South.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 1219, 322);
		panel_South.add(scrollPane);

		String[] headers_CDSP = { "Tên công đoạn", "Tên sản phẩm", "Lương công đoạn" };
		modelCDSP = new DefaultTableModel(headers_CDSP, 0);

		tableCDSP = new Table();
		tableCDSP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableCDSP.setOpaque(false);
		// Cài đặt header cho table Chấm công
		tableCDSP.setModel(modelCDSP);
		tableCDSP.getColumnModel().getColumn(2).setPreferredWidth(142);
		setLayout(new BorderLayout(0, 0));

		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setOpaque(false);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(tableCDSP);

		tableCDSP.fixTable(scrollPane);

		JLabel lblBangCongDoanSp = new JLabel("Bảng công đoạn sản phẩm");
		lblBangCongDoanSp.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblBangCongDoanSp.setHorizontalAlignment(SwingConstants.CENTER);

		RoundPanel panelBangCongDoanSp = new RoundPanel();
		panelBangCongDoanSp.setBackground(new Color(153, 204, 255));
		panelBangCongDoanSp.setRound(30);
		panelBangCongDoanSp.setBounds(10, 10, 1219, 40);
		panelBangCongDoanSp.setLayout(new BorderLayout(0, 0));
		panelBangCongDoanSp.add(lblBangCongDoanSp);
		panel_South.add(panelBangCongDoanSp);

		docDuLieuDataAllLenTableSP();

		tableSP.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				modelCDSP.setRowCount(0);
				int n = tableSP.getSelectedRow();
				idSP = tableSP.getValueAt(n, 0).toString();
				docDuLieuDataLenTableCDSPTheoSP(idSP);
			}
		});

		tableCDSP.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				hienThiThongTinCD();

			}
		});
		cb_TrangThai.addActionListener(this);
		btnThem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		txtTim.addFocusListener(this);
		this.add(panel_CongDoanSanPham);
	}

	private void docDuLieuDataMoiLenTableSP() {
		modelSP.setRowCount(0);
		ArrayList<SanPham> listSP = sp_bus.getAllSanPhamMoi();
		for (SanPham sp : listSP) {
			modelSP.addRow(new Object[] { sp.getIdSanPham(), sp.getTenSanPham()

			});
		}
	}
	private void docDuLieuDataCuLenTableSP() {
		modelSP.setRowCount(0);
		ArrayList<SanPham> listSP = sp_bus.getAllSanPhamCu();
		for (SanPham sp : listSP) {
			modelSP.addRow(new Object[] { sp.getIdSanPham(), sp.getTenSanPham()

			});
		}
	}
	private void docDuLieuDataAllLenTableSP() {
		modelSP.setRowCount(0);
		ArrayList<SanPham> listSP = sp_bus.getAllSanPham();
		for (SanPham sp : listSP) {
			modelSP.addRow(new Object[] { sp.getIdSanPham(), sp.getTenSanPham()

			});
		}
	}
	private void docDuLieuDataLenTableCDSPTheoSP(String id) {
		
		listCDSP = cdsp_bus.getCongDoanTheoSP(id);
		for (CongDoanSanPham cdSP : listCDSP) {
			modelCDSP.addRow(
					new Object[] { cdSP.getTenCongDoan(), cdSP.getSanPham().getTenSanPham(), (int)cdSP.getLuongCongDoan()

					});
		}
	}

	private void hienThiThongTinCD() {
		int n = tableCDSP.getSelectedRow();
		txtHienThiIDSP.setText(idSP);
		txtHienThiTenCD.setText(modelCDSP.getValueAt(n, 0).toString());
		txtHienThiTenSP.setText(modelCDSP.getValueAt(n, 1).toString());
		txtHienThiLuongCD.setText(modelCDSP.getValueAt(n, 2).toString());
	}

	private void moDialogThemCDSP(String idsp) {
		dialog = new JDialog();
		dialog.setBackground(new Color(223, 223, 223));
		dialog.setTitle("Thêm công đoạn");
		dialog.setSize(748, 372);

		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		dialog.getContentPane().setLayout(null);

		JLabel lblidSP = new JLabel("ID sản phẩm: ");
		lblidSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblidSP.setBounds(10, 30, 152, 25);
		dialog.getContentPane().add(lblidSP);

		JLabel lblTenSP = new JLabel("Tên sản phẩm: ");
		lblTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenSP.setBounds(10, 90, 152, 25);
		dialog.getContentPane().add(lblTenSP);

		JLabel lblTenCongDoan = new JLabel("Tên công đoạn: ");
		lblTenCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenCongDoan.setBounds(10, 150, 152, 25);
		dialog.getContentPane().add(lblTenCongDoan);

		JLabel lblLuongCongDoan = new JLabel("Lương công đoạn: ");
		lblLuongCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLuongCongDoan.setBounds(10, 210, 152, 25);
		dialog.getContentPane().add(lblLuongCongDoan);

		txtIDSP = new JTextField();
		txtIDSP.setEditable(false);
		txtIDSP.setText(idsp);
		txtIDSP.setBackground(null);
		txtIDSP.setBorder(null);
		txtIDSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtIDSP.setBounds(176, 30, 548, 25);
		dialog.getContentPane().add(txtIDSP);
		txtIDSP.setColumns(10);

		txtTenSP = new JTextField();
		txtTenSP.setEditable(false);
		String tenSP = sp_bus.getSanPhamTheoID(idsp).getTenSanPham();
		txtTenSP.setText(tenSP);
		txtTenSP.setBackground(null);
		txtTenSP.setBorder(null);
		txtTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(176, 90, 548, 25);
		dialog.getContentPane().add(txtTenSP);


		txtTenCongDoan = new JTextField("Nhập Tên Công Đoạn");
		txtTenCongDoan.setForeground(Color.GRAY);
		txtTenCongDoan.setBackground(null);
		txtTenCongDoan.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtTenCongDoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenCongDoan.setColumns(10);
		txtTenCongDoan.setBounds(172, 150, 548, 25);
		dialog.getContentPane().add(txtTenCongDoan);

		txtLuongCD = new JTextField("Nhập lương công đoạn");
		txtLuongCD.setForeground(Color.GRAY);
		txtLuongCD.setBackground(null);
		txtLuongCD.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtLuongCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtLuongCD.setColumns(10);
		txtLuongCD.setBounds(176, 210, 548, 25);
		dialog.getContentPane().add(txtLuongCD);

		btnThemCD = new MyButton();
		btnThemCD.setText("Thêm");
		btnThemCD.setBackground(new Color(0, 255, 0));
		btnThemCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThemCD.setBounds(127, 285, 150, 30);
		dialog.getContentPane().add(btnThemCD);

		btnHuy = new MyButton();
		btnHuy.setText("Hủy");
		btnHuy.setBackground(new Color(255, 0, 0));
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuy.setBounds(431, 285, 150, 30);
		dialog.getContentPane().add(btnHuy);

		btnCapNhatCD = new MyButton();
		btnCapNhatCD.setText("Cập nhật");
		btnCapNhatCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCapNhatCD.setBackground(Color.GREEN);
		btnCapNhatCD.setBounds(127, 285, 150, 30);
		dialog.getContentPane().add(btnCapNhatCD);
		
		txtCheckTen = new JTextField();
		txtCheckTen.setBorder(null);
		txtCheckTen.setBackground(null);
		txtCheckTen.setForeground(new Color(255, 0, 0));
		txtCheckTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCheckTen.setBounds(172, 185, 552, 25);
		dialog.getContentPane().add(txtCheckTen);
		txtCheckTen.setColumns(10);
		
		txtCheckLuong = new JTextField();
		txtCheckLuong.setBorder(null);
		txtCheckLuong.setBackground(null);
		txtCheckLuong.setForeground(new Color(255, 0, 0));
		txtCheckLuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCheckLuong.setColumns(10);
		txtCheckLuong.setBounds(172, 246, 552, 25);
		
		txtTenCongDoan.addFocusListener(this);
		txtLuongCD.addFocusListener(this);
		dialog.getContentPane().add(txtCheckLuong);
		btnCapNhatCD.addActionListener(this);
		btnThemCD.addActionListener(this);
		btnHuy.addActionListener(this);

	}
	private boolean validData() {
		
	
		String tenCD = txtTenCongDoan.getText().trim();
	
		
		if (!tenCD.matches("[\\p{Lu}][\\p{Ll}]*([\\s]*[\\p{Ll}][\\p{Ll}]*)*")) {
			txtCheckTen.setText("Tên công đoạn ít nhất 1 âm, âm đầu có chữ cái đầu viết hoa!");
			return false;
		}
		String luongCD = txtLuongCD.getText().trim();
		if (!luongCD.matches("[1-9]{1}[0-9]{3,4}")) {
			txtCheckLuong.setText("Lương công đoạn có 4 đến 5 chữ số!");
			return false;
		}
		return true;
	}
	private String sinhMaCD() {
		int stt = 1;
		ArrayList<CongDoanSanPham> list = cdsp_bus.getDSCongDoan();
		String id = "CD" + String.format("%04d", stt);
		for (CongDoanSanPham cd : list) {
			if (cd.getIdCongDoan().equals(id)) {
				stt++;
				id = "CD" + String.format("%04d", stt);
			}
		}
		return id;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			int r = tableSP.getSelectedRow();
			if (r == -1) {

				JOptionPane.showMessageDialog(null, "Chọn 1 sản phẩm để thêm công đoạn!");
			} else {
				moDialogThemCDSP(idSP);
				btnThemCD.setVisible(true);
				btnCapNhatCD.setVisible(false);
				dialog.setModal(true);
				dialog.setVisible(true);
			}

		}
		if (o.equals(btnHuy)) {
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn hủy không?", "Cảnh báo!", JOptionPane.YES_NO_OPTION);

	        if (choice == JOptionPane.YES_OPTION) {
	        	dialog.dispose();
	        } else {
	            return;
	        }
		}
		if (o.equals(cb_TrangThai)) {
			if(cb_TrangThai.getSelectedIndex()==0) {
				docDuLieuDataMoiLenTableSP();
			}
			else if(cb_TrangThai.getSelectedIndex()==1) {
				docDuLieuDataCuLenTableSP();
			}
			else {
				docDuLieuDataAllLenTableSP();
			}
		}
		if (o.equals(btnCapNhat)) {

			int r = tableCDSP.getSelectedRow();
			if (r == -1) {

				JOptionPane.showMessageDialog(null, "Chọn 1 công đoạn để cập nhật!");
			} else {
				moDialogThemCDSP(idSP);
				btnCapNhatCD.setVisible(true);
				btnThemCD.setVisible(false);
				String tenCDSP = modelCDSP.getValueAt(r, 0).toString();
				txtTenCongDoan.setText(tenCDSP);
				txtTenCongDoan.setForeground(Color.BLACK);
				String luongCD = modelCDSP.getValueAt(r, 2).toString();
				txtLuongCD.setText(luongCD);
				txtLuongCD.setForeground(Color.BLACK);
				dialog.setModal(true);
				dialog.setVisible(true);
			}

		}
		if (o.equals(btnThemCD)) {
			if(validData()) {
				String maCD = sinhMaCD();
				String tenCD = txtTenCongDoan.getText();
				double luongCD = Double.parseDouble(txtLuongCD.getText());
				String idSanPham = txtIDSP.getText();
				SanPham sp = sp_bus.getSanPhamTheoID(idSanPham);
				int tongSoLuong = sp_bus.getTongSoLuongDatSanPhamTheoID(idSanPham);
				CongDoanSanPham cdsp = new CongDoanSanPham(maCD, tenCD,tongSoLuong, luongCD, sp);
				cdsp_bus.create(cdsp);
				modelCDSP.setRowCount(0);
				docDuLieuDataLenTableCDSPTheoSP(idSanPham);
				JOptionPane.showMessageDialog(null, "Thêm thành công!");
				dialog.dispose();
				int m = cdsp_bus.getCongDoanTheoSP(idSanPham).indexOf(cdsp);
				tableCDSP.setRowSelectionInterval(m, m);
				tableCDSP.scrollRectToVisible(tableCDSP.getCellRect(m, m, true));
				hienThiThongTinCD();
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng và đầy đủ thông tin!");
			
			}
			
		}
		if (o.equals(btnCapNhatCD)) {
			if(validData()) {
				String maCD = listCDSP.get(tableCDSP.getSelectedRow()).getIdCongDoan();
				String tenCD = txtTenCongDoan.getText();
				double luongCD = Double.parseDouble(txtLuongCD.getText());
				String idSanPham = txtIDSP.getText();
				SanPham sp = sp_bus.getSanPhamTheoID(idSanPham);
				int tongSoLuong = sp_bus.getTongSoLuongDatSanPhamTheoID(idSanPham);
				CongDoanSanPham cdsp = new CongDoanSanPham(maCD, tenCD,tongSoLuong, luongCD, sp);
				cdsp_bus.update(cdsp);
				modelCDSP.setRowCount(0);
				docDuLieuDataLenTableCDSPTheoSP(idSanPham);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				dialog.dispose();
				int m = cdsp_bus.getCongDoanTheoSP(idSanPham).indexOf(cdsp);
				tableCDSP.setRowSelectionInterval(m, m);
				tableCDSP.scrollRectToVisible(tableCDSP.getCellRect(m, m, true));
				hienThiThongTinCD();
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng và đầy đủ thông tin!");
				
			}
			
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(txtTim)) {
			if (txtTim.getText().equals(" Nhập mã sản phẩm cần tìm...")) {
				txtTim.setText("");
				txtTim.setForeground(Color.BLACK);
			}
		}
		if (o.equals(txtTenCongDoan)) {
			txtCheckTen.setText("");
			 if (txtTenCongDoan.getText().equals("Nhập Tên Công Đoạn")) {
				 txtTenCongDoan.setText("");
				 txtTenCongDoan.setForeground(Color.BLACK);
            }
		}
		if (o.equals(txtLuongCD)) {
			txtCheckLuong.setText("");
			 if (txtLuongCD.getText().equals("Nhập lương công đoạn")) {
				 txtLuongCD.setText("");
				 txtLuongCD.setForeground(Color.BLACK);
            }
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(txtTim)) {
			if (txtTim.getText().trim().isEmpty()) {
				txtTim.setText(" Nhập mã sản phẩm cần tìm...");
				txtTim.setForeground(Color.GRAY);
			}
		}
		if (o.equals(txtTenCongDoan)) {
			String tenCD = txtTenCongDoan.getText().trim();
			if (tenCD.isEmpty()) {
				txtTenCongDoan.setText("Nhập Tên Công Đoạn");
				txtTenCongDoan.setForeground(Color.GRAY);
				return;
            }
			
			if (!tenCD.matches("[\\p{Lu}][\\p{Ll}]*([\\s]*[\\p{Ll}][\\p{Ll}]*)*")) {
				txtCheckTen.setText("Tên công đoạn ít nhất 1 âm, âm đầu có chữ cái đầu viết hoa!");
			} else {
				txtCheckTen.setText("");
			}
		}
		if (o.equals(txtLuongCD)) {
			String luongCD = txtLuongCD.getText().trim();
			if (luongCD.isEmpty()) {
				txtLuongCD.setText("Nhập lương công đoạn");
				txtLuongCD.setForeground(Color.GRAY);
				return;
            }
			
			if (!luongCD.matches("[1-9]{1}[0-9]{3,4}")) {
				txtCheckLuong.setText("Lương công đoạn có 4 đến 5 chữ số!");
			} else {
				txtCheckLuong.setText("");
			}
		}
	}
}
