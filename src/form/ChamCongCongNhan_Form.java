package form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Scrollbar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bus.ChamCongCongNhan_BUS;
import bus.CongDoanPhanCong_BUS;
import commons.MyButton;
import commons.RoundPanel;
import commons.Table;
import entities.BangChamCongCongNhan;
import entities.CaLam;
import entities.CongDoanPhanCong;

import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import commons.RoundTextField;

public class ChamCongCongNhan_Form extends RoundPanel implements ActionListener{
	
	private RoundPanel panelCenter;
	private RoundPanel panelSouth;
	private int width = 1259;
	private int height = 813;
	private Table tableCongNhan;
	private Table tableChamCong;
	private RoundPanel panel;
	private JLabel lblNewLabel;
	private RoundPanel panel_1;
	private JLabel lblNewLabel_1;
	private JPanel panel_3;
	private int indexCaLam;
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//
	private ChamCongCongNhan_BUS bangChamCongCongNhan_BUS = new ChamCongCongNhan_BUS();
	private CongDoanPhanCong_BUS congDoanPhanCong_BUS = new CongDoanPhanCong_BUS();
	private JTextField txtSLHoanThanh;
	private JLabel lblID;
	private JLabel lblHoTen;
	private JLabel lblCaLam;
	private JLabel lblPhanXuong;
	private JLabel lblTenSanPham;
	private JLabel lblCongDoan;
	private JLabel lblSLDuocGiao;
	private JLabel lblSLConLai;
	private JLabel lblThongBao;
	private MyButton btnChamCong;
	private MyButton btnChamCongAll;
	private MyButton btnCapNhat;
	
	//
	private ArrayList<CongDoanPhanCong> listPhanCong = new ArrayList<CongDoanPhanCong>();
	private ArrayList<BangChamCongCongNhan> listChamCong = new ArrayList<BangChamCongCongNhan>();
	private JPanel panelNorth;
	private JComboBox cboCaLam;
	private JLabel lblNewLabel_2;
	private JTextField textNgayChamCong;
	private RoundTextField txtTimKiem;
	private JComboBox cboPhanXuong;
	private LocalDate date;

	/**
	 * Create the panel.
	 */
	public ChamCongCongNhan_Form(int width, int height) {
		setBackground(new Color(240, 240, 240));
		this.width = width;
		this.height = height;
		initPanel();
	}
	
	private void initPanel() {
		setSize(new Dimension(this.width, this.height));
		setRound(20);

		panelCenter = new RoundPanel();
		panelCenter.setRound(20);
		panelCenter.setBackground(new Color(255, 255, 255));
		panelCenter.setBorder(new EmptyBorder(5, 15, 10, 10));
		
		panelSouth = new RoundPanel();
		panelSouth.setLayout(new BorderLayout());
		panelSouth.setBackground(new Color(255, 255, 255));
		panelSouth.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelSouth.setPreferredSize(new Dimension((int) (this.width * 0.95), (int) (this.height * 0.6)));
		panelSouth.setRound(20);
		
		RoundPanel panelCenter_1 = new RoundPanel();
		panelCenter_1.setRound(20);
		panelCenter_1.setPreferredSize(new Dimension(1259, 325));
		panelCenter_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCenter_1.setBackground(new Color(255, 255, 255));
		
		RoundPanel panel_2 = new RoundPanel();
		panel_2.setRound(10);
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(153, 204, 255));
		
		JLabel lblThngTinChm = new JLabel("Thông tin chấm công");
		lblThngTinChm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_2.add(lblThngTinChm);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		GroupLayout gl_panelCenter_1 = new GroupLayout(panelCenter_1);
		gl_panelCenter_1.setHorizontalGroup(
			gl_panelCenter_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_panelCenter_1.setVerticalGroup(
			gl_panelCenter_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
		);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ID Công nhân:");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(24, 10, 110, 20);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên công nhân:");
		lblNewLabel_3_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(24, 40, 110, 20);
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Ca làm:");
		lblNewLabel_3_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(24, 70, 110, 20);
		panel_3.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Phân xưởng:");
		lblNewLabel_3_3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(24, 103, 110, 20);
		panel_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Sản phẩm:");
		lblNewLabel_3_4.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3_4.setBounds(24, 133, 110, 20);
		panel_3.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Công đoạn:");
		lblNewLabel_3_5.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3_5.setBounds(24, 163, 110, 20);
		panel_3.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_5_1 = new JLabel("Số lượng được giao:");
		lblNewLabel_3_5_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3_5_1.setBounds(24, 193, 151, 20);
		panel_3.add(lblNewLabel_3_5_1);
		
		JLabel lblNewLabel_3_5_1_1 = new JLabel("Số lượng hoàn thành:");
		lblNewLabel_3_5_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3_5_1_1.setBounds(24, 253, 151, 20);
		panel_3.add(lblNewLabel_3_5_1_1);
		
		JLabel lblNewLabel_3_5_1_2 = new JLabel("Số lượng còn lại:");
		lblNewLabel_3_5_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_3_5_1_2.setBounds(24, 223, 173, 20);
		panel_3.add(lblNewLabel_3_5_1_2);
		
		lblID = new JLabel("");
		lblID.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblID.setBounds(273, 10, 244, 20);
		panel_3.add(lblID);
		
		lblHoTen = new JLabel("");
		lblHoTen.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblHoTen.setBounds(273, 40, 244, 20);
		panel_3.add(lblHoTen);
		
		lblCaLam = new JLabel("");
		lblCaLam.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCaLam.setBounds(273, 70, 244, 20);
		panel_3.add(lblCaLam);
		
		lblPhanXuong = new JLabel("");
		lblPhanXuong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPhanXuong.setBounds(273, 103, 244, 20);
		panel_3.add(lblPhanXuong);
		
		lblTenSanPham = new JLabel("");
		lblTenSanPham.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTenSanPham.setBounds(273, 133, 244, 20);
		panel_3.add(lblTenSanPham);
		
		lblCongDoan = new JLabel("");
		lblCongDoan.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCongDoan.setBounds(273, 163, 244, 20);
		panel_3.add(lblCongDoan);
		
		lblSLDuocGiao = new JLabel("");
		lblSLDuocGiao.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSLDuocGiao.setBounds(271, 193, 110, 20);
		panel_3.add(lblSLDuocGiao);
		
		lblSLConLai = new JLabel("");
		lblSLConLai.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblSLConLai.setBounds(271, 223, 110, 20);
		panel_3.add(lblSLConLai);
		
		txtSLHoanThanh = new JTextField();
		txtSLHoanThanh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtSLHoanThanh.setBounds(273, 251, 72, 24);
		panel_3.add(txtSLHoanThanh);
		txtSLHoanThanh.setColumns(10);
		
		lblThongBao = new JLabel("");
		lblThongBao.setForeground(new Color(255, 0, 0));
		lblThongBao.setFont(new Font("SansSerif", Font.ITALIC, 15));
		lblThongBao.setBounds(24, 285, 493, 20);
		panel_3.add(lblThongBao);
		panelCenter_1.setLayout(gl_panelCenter_1);
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelSouth.setLayout(new BorderLayout(0, 0));
		
		// Bảng công nhân
		
		tableCongNhan = new Table();
        tableCongNhan.setOpaque(false);
        tableCongNhan.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                		"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ca l\u00E0m", "Ph\u00E2n x\u01B0\u1EDFng", "S\u1EA3n ph\u1EA9m", "C\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u01B0\u1EE3c giao", "Số lượng còn lại"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        tableCongNhan.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableCongNhan.getColumnModel().getColumn(6).setPreferredWidth(136);
        
        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBackground(new Color(255, 255, 255));
        scrollPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane1.setViewportView(tableCongNhan);
		panelCenter.add(scrollPane1);
		tableCongNhan.fixTable(scrollPane1);
		
		// Khởi tạo panel chứa tiêu đề của bảng
		panel = new RoundPanel();
		panel.setBackground(new Color(153, 204, 255));
		panelCenter.add(panel, BorderLayout.NORTH);
		panel.setRound(10);
		panel.setOpaque(false);
		
		// 
		lblNewLabel = new JLabel("Danh sách công nhân");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		// Bảng chấm công
		tableChamCong = new Table();
        tableChamCong.setOpaque(false);
        // Cài đặt header cho table Chấm công
        tableChamCong.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                	"ID c\u00F4ng nh\u00E2n", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "Ph\u00E2n x\u01B0\u1EDFng", "S\u1EA3n ph\u1EA9m", "C\u00F4ng \u0111o\u1EA1n", "Số lượng được giao", "S\u1ED1 l\u01B0\u1EE3ng ho\u00E0n th\u00E0nh"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setOpaque(false);
        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        scrollPane.setViewportView(tableChamCong);
        panelSouth.add(scrollPane);
        
        tableChamCong.fixTable(scrollPane);
        
        // Khởi tạo panel chứa tiêu đề của bảng
        panel_1 = new RoundPanel();
        panel_1.setRound(10);
        panel_1.setOpaque(false);
        panel_1.setBackground(new Color(153, 204, 255));
//        scrollPane.setColumnHeaderView(panel_1);
        panelSouth.add(panel_1, BorderLayout.NORTH);
        
        lblNewLabel_1 = new JLabel("Danh sách chấm công");
        lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
        panel_1.add(lblNewLabel_1);
        
        JPanel panelNorth_1 = new JPanel();
        panelNorth_1.setOpaque(false);
        panelNorth_1.setBorder(new EmptyBorder(0, 0, 0, 0));
        panelNorth_1.setBackground(Color.WHITE);
        
        btnChamCong = new MyButton();
        btnChamCong.setText("Chấm công");
        btnChamCong.setRadius(10);
        btnChamCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
        btnChamCong.setFocusPainted(false);
        btnChamCong.setBackground(Color.WHITE);
        
        btnChamCongAll = new MyButton();
        btnChamCongAll.setText("Chấm công hàng loạt");
        btnChamCongAll.setRadius(10);
        btnChamCongAll.setFont(new Font("SansSerif", Font.PLAIN, 15));
        btnChamCongAll.setFocusPainted(false);
        btnChamCongAll.setBackground(Color.WHITE);
        
        btnCapNhat = new MyButton();
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setRadius(10);
        btnCapNhat.setFont(new Font("SansSerif", Font.PLAIN, 15));
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setBackground(Color.WHITE);
        GroupLayout gl_panelNorth_1 = new GroupLayout(panelNorth_1);
        gl_panelNorth_1.setHorizontalGroup(
        	gl_panelNorth_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panelNorth_1.createSequentialGroup()
        			.addGap(702)
        			.addComponent(btnChamCong, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(btnChamCongAll, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
        );
        gl_panelNorth_1.setVerticalGroup(
        	gl_panelNorth_1.createParallelGroup(Alignment.LEADING)
        		.addComponent(btnChamCong, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        		.addGroup(gl_panelNorth_1.createSequentialGroup()
        			.addGap(1)
        			.addComponent(btnChamCongAll, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panelNorth_1.createSequentialGroup()
        			.addGap(2)
        			.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        );
        panelNorth_1.setLayout(gl_panelNorth_1);
        
        
        btnChamCong.addActionListener(this);
        btnChamCongAll.addActionListener(this);
        btnCapNhat.addActionListener(this);
        
        panelNorth = new JPanel();
        panelNorth.setLayout(null);
        panelNorth.setOpaque(false);
        panelNorth.setBorder(new EmptyBorder(0, 0, 0, 0));
        panelNorth.setBackground(Color.WHITE);
        
        cboCaLam = new JComboBox();
        cboCaLam.setModel(new DefaultComboBoxModel<String>(new String[] {"Ca sáng", "Ca chiều", "Ca tối", "Tất cả"}));
        cboCaLam.setSelectedIndex(3);
        cboCaLam.setFont(new Font("SansSerif", Font.PLAIN, 15));
        cboCaLam.setBounds(311, 3, 117, 37);
        panelNorth.add(cboCaLam);
        
        lblNewLabel_2 = new JLabel("Ngày chấm công:");
        lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(573, 12, 117, 20);
        panelNorth.add(lblNewLabel_2);
        
        textNgayChamCong = new JTextField();
        date = LocalDate.now().minusDays(1);
        textNgayChamCong.setText(dtf.format(date));
        textNgayChamCong.setHorizontalAlignment(SwingConstants.CENTER);
        textNgayChamCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
        textNgayChamCong.setColumns(10);
        textNgayChamCong.setBorder(null);
        textNgayChamCong.setBounds(694, 5, 93, 35);
        panelNorth.add(textNgayChamCong);
        
        txtTimKiem = new RoundTextField(10);
        txtTimKiem.setText("Nhập tên công nhân cần tìm...");
        txtTimKiem.setForeground(Color.GRAY);
        txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 15));
        txtTimKiem.setColumns(10);
        txtTimKiem.setBorder(new EmptyBorder(0, 15, 0, 0));
        txtTimKiem.setBounds(10, 4, 291, 35);
        panelNorth.add(txtTimKiem);
//        
//        cboPhanXuong = new JComboBox();
//        cboPhanXuong.setFont(new Font("SansSerif", Font.PLAIN, 15));
//        cboPhanXuong.setBounds(438, 3, 117, 37);
//        panelNorth.add(cboPhanXuong);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(19)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 1221, GroupLayout.PREFERRED_SIZE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
        					.addGap(10)
        					.addComponent(panelCenter_1, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE))
        				.addComponent(panelNorth_1, GroupLayout.PREFERRED_SIZE, 1221, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 1221, GroupLayout.PREFERRED_SIZE))
        			.addGap(19))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(8)
        			.addComponent(panelNorth, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(2)
        					.addComponent(panelCenter, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
        				.addComponent(panelCenter_1, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
        			.addGap(10)
        			.addComponent(panelNorth_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(9)
        			.addComponent(panelSouth, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
        );
        setLayout(groupLayout);
      
        tableCongNhan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableChamCong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
      indexCaLam = 3;
      cboCaLam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				kiemTraComboBoxCaLam();
			}
		});
      
      //
      tableCongNhan.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		duaDuLieuPhanCongLenLabel();
      		super.mouseClicked(e);
      	}
      });
      
      // Đăng ký sự kiện cho ô tìm kiếm theo tên
      
      //Place holder
      txtTimKiem.addFocusListener(new FocusAdapter() {
      	@Override
      	public void focusLost(FocusEvent e) {
      		if (txtTimKiem.getText().isEmpty()) {
      			 txtTimKiem.setText("Nhập tên công nhân cần tìm...");
      			 txtTimKiem.setForeground(Color.GRAY);
				}
      		super.focusLost(e);
      	}
      	@Override
      	public void focusGained(FocusEvent e) {
      		if (txtTimKiem.getText().equalsIgnoreCase("Nhập tên công nhân cần tìm...")) {
					txtTimKiem.setText("");
					txtTimKiem.setForeground(Color.BLACK);
				}
      		super.focusGained(e);
      	}
      });
      
      // Xử lý sự kiện tìm kiếm
      txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				kiemTraComboBoxCaLam();
			}
		});
      //
	    //
	  	locDuLieuChamCongTheoNgay();
	    layDanhSachCongNhan();
	    docDuLieuLenTablePhanCong(listPhanCong);
        
	}
	
	/**
	 * Đọc dữ liệu lên bảng phân công
	 */
	private void docDuLieuLenTablePhanCong(ArrayList<CongDoanPhanCong> list) {
		DefaultTableModel dm = (DefaultTableModel) tableCongNhan.getModel();
		dm.getDataVector().removeAllElements();
		for(CongDoanPhanCong congDoanPhanCong : list) {
			dm.addRow(new Object[] {congDoanPhanCong.getCongNhan().getIdCongNhan(), 
					congDoanPhanCong.getCongNhan().getHoTen(), congDoanPhanCong.getCaLam().getTenCaLam(), 
					congDoanPhanCong.getCongNhan().getPhanXuong().getTenPhanXuong(), congDoanPhanCong.getCongDoanSP().getSanPham().getTenSanPham(), 
					congDoanPhanCong.getCongDoanSP().getTenCongDoan(), congDoanPhanCong.getSoLuongSanPhamDuocGiao(), 
					congDoanPhanCong.getSoLuongConLai()});
		}
		tableCongNhan.repaint();
		tableCongNhan.revalidate();
	}
	
	/**
	 * Lọc danh sách phân công theo ca làm
	 * @param caLam
	 */
	private void locPhanCongTheoCaLam(int caLam) {
		ArrayList<CongDoanPhanCong> temp = new ArrayList<CongDoanPhanCong>();
		temp.addAll(listPhanCong);
		listPhanCong = new ArrayList<CongDoanPhanCong>();
		for(CongDoanPhanCong congDoanPhanCong : temp) {
			if (congDoanPhanCong.getCaLam().getIdCaLam() == caLam) {
				listPhanCong.add(congDoanPhanCong);
			}
		}
	}
	
	/**
	 * Lọc danh sách phân công theo tên
	 */
	private void locPhanCongTheoHoTen() {
		ArrayList<CongDoanPhanCong> temp = new ArrayList<CongDoanPhanCong>();
		temp.addAll(listPhanCong);
		listPhanCong = new ArrayList<CongDoanPhanCong>();
		for(CongDoanPhanCong congDoanPhanCong : temp) {
			if(congDoanPhanCong.getCongNhan().getHoTen().trim().toUpperCase().contains(txtTimKiem.getText().trim().toUpperCase())) {
				listPhanCong.add(congDoanPhanCong);
			}
		}
	}
	
	private void layDanhSachCongNhan() {
		ArrayList<CongDoanPhanCong> temp = congDoanPhanCong_BUS.getDanhSachPhanCong();
		listPhanCong = new ArrayList<CongDoanPhanCong>();
		for(CongDoanPhanCong congDoanPhanCong : temp) {
			if (congDoanPhanCong.getSoLuongConLai() > 0) {
				if (!listChamCong.contains(new BangChamCongCongNhan(date, congDoanPhanCong))) {
					listPhanCong.add(congDoanPhanCong);
				}
			}
		}
	}
	
	/**
	 * Đọc dữ liệu lên bảng chấm công
	 */
	private void docDuLieuLenTableChamCong(ArrayList<BangChamCongCongNhan> listChamCong) {
		DefaultTableModel dm = (DefaultTableModel) tableChamCong.getModel();
		dm.getDataVector().removeAllElements();
		for(BangChamCongCongNhan bangChamCongCongNhan : listChamCong) {
			dm.addRow(new Object[] {bangChamCongCongNhan.getCongDoanPhanCong().getCongNhan().getIdCongNhan(), 
						dtf.format(bangChamCongCongNhan.getNgayChamCong()), bangChamCongCongNhan.getCongDoanPhanCong().getCongNhan().getPhanXuong().getTenPhanXuong(), 
						bangChamCongCongNhan.getCongDoanPhanCong().getCongDoanSP().getSanPham().getTenSanPham(), bangChamCongCongNhan.getCongDoanPhanCong().getCongDoanSP().getTenCongDoan(), 
						bangChamCongCongNhan.getCongDoanPhanCong().getSoLuongSanPhamDuocGiao(), bangChamCongCongNhan.getSoLuongHoanThanh()});
		}
		dm.fireTableDataChanged();
		tableChamCong.repaint();
		tableChamCong.revalidate();
	}
	
	/**
	 * Lọc dữ liệu chấm công theo ngày
	 */
	private void locDuLieuChamCongTheoNgay() {
		listChamCong  = bangChamCongCongNhan_BUS.getDanhSachChamCongTheoNgay(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
		docDuLieuLenTableChamCong(listChamCong);
	}
	
	/**
	 * Đưa dữ liệu phân công lên các label
	 */
	private void duaDuLieuPhanCongLenLabel() {
		int row = tableCongNhan.getSelectedRow();
		if (row != -1) {
			lblID.setText(tableCongNhan.getValueAt(row, 0).toString());
			lblHoTen.setText(tableCongNhan.getValueAt(row, 1).toString());
			lblCaLam.setText(tableCongNhan.getValueAt(row, 2).toString());
			lblPhanXuong.setText(tableCongNhan.getValueAt(row, 3).toString());
			lblTenSanPham.setText(tableCongNhan.getValueAt(row, 4).toString());
			lblCongDoan.setText(tableCongNhan.getValueAt(row, 5).toString());
			lblSLDuocGiao.setText(tableCongNhan.getValueAt(row, 6).toString());
			lblSLConLai.setText(tableCongNhan.getValueAt(row, 7).toString());
			txtSLHoanThanh.setText(tableCongNhan.getValueAt(row, 7).toString());
		}
	}
	
	/**
	 * Chấm công cho một công nhân
	 */
	public void chamCong() {
		int row = tableCongNhan.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Bạn cần chọn công nhân để chấm công.");
			return;
		}
		CongDoanPhanCong congDoanPhanCong = listPhanCong.get(row);
		String idChamCong = String.format("CCN%04d", bangChamCongCongNhan_BUS.getDanhSachChamCong().size() + 1);
		LocalDate ngayChamCong =  LocalDate.parse(textNgayChamCong.getText(), dtf);
		int soLuongConLai = congDoanPhanCong.getSoLuongConLai();
		int soLuongHoanThanh = 0;
		try {
			soLuongHoanThanh = Integer.parseInt(txtSLHoanThanh.getText());
			if (soLuongHoanThanh <= 0) {
				lblThongBao.setText("Số lượng hoàn thành nhập vào phải là số dương!");
				txtSLHoanThanh.selectAll();
				txtSLHoanThanh.requestFocus();
				return;
			}
			if (soLuongConLai < soLuongHoanThanh) {
				lblThongBao.setText("Số lượng hoàn thành nhập vào bé hơn số lượng còn lại!");
				txtSLHoanThanh.selectAll();
				txtSLHoanThanh.requestFocus();
				return;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			lblThongBao.setText("Số lượng hoàn thành nhập vào phải là chữ số!");
			txtSLHoanThanh.selectAll();
			txtSLHoanThanh.requestFocus();
			return;
		}
		double heSoNgayLam = 1;
		if (ngayChamCong.getDayOfWeek() == DayOfWeek.SUNDAY) {
			heSoNgayLam = 1.5;
		}
		BangChamCongCongNhan bangChamCongCongNhan = new BangChamCongCongNhan(idChamCong, ngayChamCong, soLuongHoanThanh, 
													congDoanPhanCong, heSoNgayLam);
		bangChamCongCongNhan_BUS.themChamCong(bangChamCongCongNhan);
		congDoanPhanCong.setSoLuongConLai(soLuongConLai - soLuongHoanThanh);
		congDoanPhanCong_BUS.capNhatSoLuongConLai(congDoanPhanCong);
		lblThongBao.setText("Chấm công thành công!");
	}
	
	/**
	 * Kiểm tra dữ liệu trong thanh tìm kiếm
	 */
	private void kiemTraThanhTimKiem() {
		if (!txtTimKiem.getText().equals("Nhập tên công nhân cần tìm...")) {
			locPhanCongTheoHoTen();
		}
	}
	
	/**
	 * Kiểm tra combobox Ca làm để lọc dữ liệu
	 */
	private void kiemTraComboBoxCaLam() {
		tableCongNhan.clearSelection();
		indexCaLam = cboCaLam.getSelectedIndex();
		layDanhSachCongNhan();
		if (indexCaLam != 3) {
			locPhanCongTheoCaLam(indexCaLam + 1);
		}
		kiemTraThanhTimKiem();
		docDuLieuLenTablePhanCong(listPhanCong);
	}
	
	/**
	 * Chấm công cho tất cả công nhân
	 */
	public void chamCongHangLoat() {
		if ((JOptionPane.showConfirmDialog(this, "Bạn có muốn chấm công cho toàn bộ công nhân?", "Hỏi nhắc!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)) {
			tableCongNhan.clearSelection();
			layDanhSachCongNhan();
			for (CongDoanPhanCong congDoanPhanCong : listPhanCong) {
				String idChamCong = String.format("CCN%04d", bangChamCongCongNhan_BUS.getDanhSachChamCong().size() + 1);
				LocalDate ngayChamCong =  LocalDate.parse(textNgayChamCong.getText(), dtf);
				int soLuongConLai = congDoanPhanCong.getSoLuongConLai();
				int soLuongHoanThanh = soLuongConLai;
				double heSoNgayLam = 1;
				if (ngayChamCong.getDayOfWeek() == DayOfWeek.SUNDAY) {
					heSoNgayLam = 1.35;
				}
				BangChamCongCongNhan bangChamCongCongNhan = new BangChamCongCongNhan(idChamCong, ngayChamCong, soLuongHoanThanh, congDoanPhanCong, heSoNgayLam);
				bangChamCongCongNhan_BUS.themChamCong(bangChamCongCongNhan);
				congDoanPhanCong.setSoLuongConLai(soLuongConLai - soLuongHoanThanh);
				congDoanPhanCong_BUS.capNhatSoLuongConLai(congDoanPhanCong);
			}
			JOptionPane.showMessageDialog(this, "Chấm công thành công!");
		}
	}
	
	/**
	 * Cập nhật số lượng hoàn thành
	 */
	private void capNhatSoLuongHoanThanh() {
		int row = tableChamCong.getSelectedRow();
		tableChamCong.editCellAt(row, 0);
		if (row != -1) {
			BangChamCongCongNhan bangCC = listChamCong.get(row);
			int soLuongHoanThanh = 0;
			try {
				soLuongHoanThanh = Integer.parseInt(tableChamCong.getValueAt(row, 6).toString());
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số lượng hoàn thành cần sửa phải là chữ số.");
				tableChamCong.setValueAt("" + bangCC.getSoLuongHoanThanh(), row, 6);
				return;
			}
			if (soLuongHoanThanh > (bangCC.getSoLuongHoanThanh() + bangCC.getCongDoanPhanCong().getSoLuongConLai())) {
				JOptionPane.showMessageDialog(this, "Số lượng hoàn thành vượt quá số lượng còn lại của công nhân.");
			}
			else {
				CongDoanPhanCong congDoanPhanCong = bangCC.getCongDoanPhanCong();
				congDoanPhanCong.setSoLuongConLai(congDoanPhanCong.getSoLuongConLai() - (soLuongHoanThanh - bangCC.getSoLuongHoanThanh()));
				bangCC.setSoLuongHoanThanh(soLuongHoanThanh);
				bangChamCongCongNhan_BUS.capNhatSoLuongHoanThanh(bangCC);
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Bạn cần chọn ngày công để sửa chấm công.");
			return;	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnChamCong)) {
			chamCong();
			locDuLieuChamCongTheoNgay();
			kiemTraComboBoxCaLam();
		}
		if (o.equals(btnChamCongAll)) {
			chamCongHangLoat();
			locDuLieuChamCongTheoNgay();
			kiemTraComboBoxCaLam();
		}
		if (o.equals(btnCapNhat)) {
			capNhatSoLuongHoanThanh();
		}
	}

}
