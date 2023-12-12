package form;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import bus.BangLuongNhanVien_BUS;
import bus.ChamCongNhanVien_BUS;
import bus.NhanVien_BUS;
import bus.PhongBan_BUS;

import javax.swing.*;

import commons.MyButton;
import commons.RoundPanel;
import commons.RoundTextField;
import commons.Table;
import connectDB.ConnectDB;
import entities.BangChamCongNhanVien;
import entities.NhanVien;
import entities.PhongBan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.awt.Cursor;

public class ChamCongNhanVien_Form extends JPanel implements ActionListener, MouseListener {
	private RoundPanel panelCenterLeft;
	private RoundPanel panelSouth;
	private int width = 1259;
	private int height = 813;
	private Table tableNhanVien;
	private Table tableChamCong;
	private RoundPanel panelNV;
	private JLabel lbListNV;
	private RoundPanel panelListCC;
	private JLabel lbChamCong;
	private JPanel panel_2;
	private JLabel textPhongBan;
	private JLabel textNgay;
	private JLabel lbMaNV;
	private JLabel textTen;
	private JComboBox boxPhongBan;
	private PhongBan_BUS phongBan_BUS;
	private NhanVien_BUS nhanVien_BUS;
	private DefaultTableModel modelNV;
	private DefaultTableModel modelCC;
	private ChamCongNhanVien_BUS chamCongNhanVien_BUS;
	private Date valueOld;
	public Date selectedDate;
	private MyButton btnSetALL;
	private MyButton btnReset;
	private Object selectedValue;
	private ButtonGroup group2;
	private static int buttonClickCount = 0;
	private JTextField textField;
	private JTextField textField_1;
	private MyButton btnChamCong;
	private RoundTextField txtTimKiem;
	private RoundTextField txtTimKiemCC;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private JLabel ngayCong;
	private TableRowSorter<DefaultTableModel> sorter;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	private MyButton btnLamMoi;

	/**
	 * Create the panel.
	 */
	public ChamCongNhanVien_Form(int width, int height) {
		setBackground(new Color(240, 240, 240));
		this.width = width;
		this.height = height;
		phongBan_BUS = new PhongBan_BUS();
		nhanVien_BUS = new NhanVien_BUS();
		chamCongNhanVien_BUS = new ChamCongNhanVien_BUS();
		try {
			ConnectDB.getInstance().connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initPanel();
	}

	private void initPanel() {
		setPreferredSize(new Dimension(1259, 813));
//		setRound(20);

		panelCenterLeft = new RoundPanel();
		panelCenterLeft.setBounds(23, 71, 773, 290);
		panelCenterLeft.setRound(20);
		panelCenterLeft.setBackground(new Color(255, 255, 255));
		panelCenterLeft.setBorder(new EmptyBorder(5, 15, 10, 10));

		panelSouth = new RoundPanel();
		panelSouth.setBounds(23, 414, 1204, 353);
		panelSouth.setLayout(new BorderLayout());
		panelSouth.setBackground(new Color(255, 255, 255));
		panelSouth.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelSouth.setPreferredSize(new Dimension((int) (this.width * 0.95), (int) (this.height * 0.6)));
		panelSouth.setRound(20);

		RoundPanel panelCenterRight = new RoundPanel();
		panelCenterRight.setBounds(806, 71, 421, 290);
		panelCenterRight.setRound(20);
		panelCenterRight.setPreferredSize(new Dimension(1259, 325));
		panelCenterRight.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCenterRight.setBackground(new Color(255, 255, 255));

		RoundPanel panelThongTin = new RoundPanel();
		panelThongTin.setRound(10);
		panelThongTin.setOpaque(false);
		panelThongTin.setBackground(new Color(153, 204, 255));

		JLabel lblThngTinChamCong = new JLabel("Thông tin chấm công");
		lblThngTinChamCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelThongTin.add(lblThngTinChamCong);
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GroupLayout gl_panelCenterRight = new GroupLayout(panelCenterRight);
		gl_panelCenterRight.setHorizontalGroup(gl_panelCenterRight.createParallelGroup(Alignment.LEADING)
				.addComponent(panelThongTin, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
				.addGroup(gl_panelCenterRight.createSequentialGroup().addContainerGap()
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panelCenterRight.setVerticalGroup(gl_panelCenterRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenterRight.createSequentialGroup()
						.addComponent(panelThongTin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(53, Short.MAX_VALUE)));
		panel_2.setLayout(null);
		panelCenterRight.setLayout(gl_panelCenterRight);
		panelCenterLeft.setLayout(new BorderLayout(0, 0));
		panelSouth.setLayout(new BorderLayout(0, 0));
		JLabel lbIDNhanVien = new JLabel("ID Nhân Viên:");
		lbIDNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbIDNhanVien.setBounds(21, 10, 108, 24);
		panel_2.add(lbIDNhanVien);

		JLabel lbTenNV = new JLabel("Tên nhân viên:");
		lbTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbTenNV.setBounds(21, 61, 103, 24);
		panel_2.add(lbTenNV);

		JLabel lbNgayCong = new JLabel("Ngày công:");
		lbNgayCong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbNgayCong.setBounds(21, 121, 108, 21);
		panel_2.add(lbNgayCong);

		JLabel lblPhongBan = new JLabel("Phòng ban:");
		lblPhongBan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhongBan.setBounds(21, 182, 108, 21);
		panel_2.add(lblPhongBan);

		textPhongBan = new JLabel("");
		textPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPhongBan.setBounds(135, 178, 156, 28);
		panel_2.add(textPhongBan);

		textNgay = new JLabel("");
		textNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNgay.setBounds(133, 121, 177, 28);
		panel_2.add(textNgay);

		lbMaNV = new JLabel("");
		lbMaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMaNV.setBounds(133, 10, 259, 28);
		panel_2.add(lbMaNV);

		textTen = new JLabel("");
		textTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTen.setBounds(133, 61, 210, 28);
		panel_2.add(textTen);
		// Bảng công nhân

		tableNhanVien = new Table();
		tableNhanVien.setOpaque(false);
		tableNhanVien.setModel(modelNV = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "H\u1ECD v\u00E0 t\u00EAn", "Gi\u1EDBi t\u00EDnh", "Ph\u00F2ng Ban",
						"C\u00F3 m\u1EB7t", "C\u00F3 ph\u00E9p", "Kh\u00F4ng ph\u00E9p" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Boolean.class,
					Boolean.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		modelNV.addTableModelListener((TableModelListener) new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int row = e.getFirstRow();
					int column = e.getColumn();

					// Kiểm tra xem cột có kiểu boolean.class không
					if (modelNV.getColumnClass(column).equals(Boolean.class)) {
						// Nếu ô được chọn, đặt giá trị false cho các ô khác trên cùng một hàng
						if ((Boolean) modelNV.getValueAt(row, column)) {
							for (int i = 4; i < modelNV.getColumnCount(); i++) {
								if (i != column) {
									modelNV.setValueAt(false, row, i);
								}
							}
						}
					}
				}
			}
		});

		JScrollPane scrollListNV = new JScrollPane();
		scrollListNV.setIgnoreRepaint(true);
		scrollListNV.setFocusable(false);
		scrollListNV.setBackground(new Color(255, 255, 255));
		scrollListNV.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollListNV.setViewportView(tableNhanVien);
		panelCenterLeft.add(scrollListNV);
		tableNhanVien.fixTable(scrollListNV);

		tableNhanVien.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tableNhanVien.getSelectedRow();
				if (row != -1) {
					tableChamCong.clearSelection();
					lbMaNV.setText(tableNhanVien.getValueAt(row, 0).toString());
					textTen.setText(tableNhanVien.getValueAt(row, 1).toString());
					textPhongBan.setText(tableNhanVien.getValueAt(row, 3).toString());
					String format = formatter.format(LocalDate.now());
					textNgay.setText(format);

				}

			}
		});
		// Khởi tạo panel chứa tiêu đề của bảng
		panelNV = new RoundPanel();
		panelNV.setBackground(new Color(155, 204, 255));
		panelCenterLeft.add(panelNV, BorderLayout.NORTH);
		panelNV.setRound(10);
		panelNV.setOpaque(false);

		//
		lbListNV = new JLabel("Danh sách nhân viên\r\n");
		lbListNV.setBackground(new Color(0, 0, 0));
		lbListNV.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelNV.add(lbListNV);
		setLayout(null);

		// Bảng chấm công
		tableChamCong = new Table();
		tableChamCong.setOpaque(false);
		// Cài đặt header cho table Chấm công
		tableChamCong.setModel(modelCC = new DefaultTableModel(new Object[][] {},
				new String[] { "ID ch\u1EA5m c\u00F4ng", "Ng\u00E0y ch\u1EA5m c\u00F4ng", "ID nh\u00E2n vi\u00EAn",
						"H\u1ECD t\u00EAn", "Ph\u00F2ng Ban", "Tr\u1EA1ng th\u00E1i" }));

		JScrollPane scrollListCC = new JScrollPane();
		scrollListCC.setBackground(new Color(255, 255, 255));
		scrollListCC.setOpaque(false);
		scrollListCC.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollListCC.setViewportView(tableChamCong);
		panelSouth.add(scrollListCC, BorderLayout.CENTER);
		tableChamCong.addMouseListener(this);
		tableChamCong.fixTable(scrollListCC);

		tableChamCong.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tableChamCong.getSelectedRow();
				if (row != -1) {
					tableNhanVien.clearSelection();
					lbMaNV.setText(tableChamCong.getValueAt(row, 2).toString());
					textTen.setText(tableChamCong.getValueAt(row, 3).toString());
					textNgay.setText(tableChamCong.getValueAt(row, 1).toString());
					textPhongBan.setText(tableChamCong.getValueAt(row, 4).toString());

				}

			}
		});

		// Khởi tạo panel chứa tiêu đề của bảng
		panelListCC = new RoundPanel();
		panelListCC.setRound(10);
		panelListCC.setOpaque(false);
		panelListCC.setBackground(new Color(153, 204, 255));
//        scrollPane.setColumnHeaderView(panel_1);
		panelSouth.add(panelListCC, BorderLayout.NORTH);

		lbChamCong = new JLabel("Danh sách chấm công");
		lbChamCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelListCC.add(lbChamCong);
		add(panelSouth);
		add(panelCenterLeft);
		add(panelCenterRight);

		JLabel lblNewLabel = new JLabel("Ngày chấm công:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(661, 19, 122, 23);
		add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Phòng Ban:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(345, 19, 90, 23);
		add(lblNewLabel_1);

		boxPhongBan = new JComboBox();
		boxPhongBan.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		boxPhongBan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boxPhongBan.setBorder(null);
		boxPhongBan.setBackground(Color.white);
	
		boxPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boxPhongBan.setBounds(445, 12, 165, 36);
		add(boxPhongBan);
		boxPhongBan.addActionListener(this);
		tableNhanVien.addMouseListener(this);
		tableChamCong.addMouseListener(this);

		btnSetALL = new MyButton();
		btnSetALL.setText("Đánh dấu có mặt tất cả");
		btnSetALL.setRadius(20);
		btnSetALL.setBackground(new Color(255, 255, 255));
		btnSetALL.setIcon(new ImageIcon(ChamCongNhanVien_Form.class.getResource("/icon/select.png")));
		btnSetALL.setBounds(357, 371, 223, 36);
		add(btnSetALL);
		btnSetALL.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSetALL.addActionListener(this);

		group2 = new ButtonGroup();
		tableNhanVien.addMouseListener(this);

		btnReset = new MyButton();
		btnReset.setText("Cập nhật");
		btnReset.setRadius(20);
		btnReset.setBounds(765, 371, 151, 36);
		btnReset.setBackground(Color.white);
		add(btnReset);
		btnReset.setIcon(new ImageIcon(ChamCongNhanVien_Form.class.getResource("/icon/update.png")));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.addActionListener(this);

		txtTimKiem = new RoundTextField(10);
		txtTimKiem.setText("Nhập dữ liệu nhân viên cần tìm...");
		txtTimKiem.setForeground(Color.GRAY);
		txtTimKiem.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBorder(new EmptyBorder(0, 15, 0, 0));
		txtTimKiem.setBounds(23, 13, 291, 35);
		add(txtTimKiem);

		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().isEmpty()) {
					txtTimKiem.setText("Nhập dữ liệu nhân viên cần tìm...");
					txtTimKiem.setForeground(Color.GRAY);
				}
				super.focusLost(e);
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equalsIgnoreCase("Nhập dữ liệu nhân viên cần tìm...")) {
					txtTimKiem.setText("");
					txtTimKiem.setForeground(Color.BLACK);
				}
				super.focusGained(e);
			}
		});
		txtTimKiem.addActionListener(this);
		btnChamCong = new MyButton();
		btnChamCong.setRadius(20);
		btnChamCong.setText("Lưu chấm công");
		btnChamCong.setBackground(Color.white);
		btnChamCong.setIcon(new ImageIcon(ChamCongNhanVien_Form.class.getResource("/icon/add.png")));
		btnChamCong.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChamCong.setBounds(590, 371, 165, 36);
		add(btnChamCong);
		btnChamCong.addActionListener(this);

		txtTimKiemCC = new RoundTextField(10);
		txtTimKiemCC.setText("Nhập dữ liệu chấm công cần tìm...");
		txtTimKiemCC.setForeground(Color.GRAY);
		txtTimKiemCC.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTimKiemCC.setColumns(10);
		txtTimKiemCC.setBorder(new EmptyBorder(0, 15, 0, 0));
		txtTimKiemCC.setBounds(926, 371, 301, 35);
		add(txtTimKiemCC);
        txtTimKiemCC.addActionListener(this);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(246, 246, 246));
		panel.setBounds(793, 12, 123, 42);
		add(panel);
		panel.setLayout(null);
		
				ngayCong = new JLabel("New label");
				ngayCong.setBounds(10, 0, 125, 42);
				panel.add(ngayCong);
				ngayCong.setIcon(new ImageIcon(ChamCongNhanVien_Form.class.getResource("/icon/schedule.png")));
				ngayCong.setBackground(new Color(242, 242, 242));
				ngayCong.setFont(new Font("Tahoma", Font.PLAIN, 15));
				ngayCong.setText(formatter.format(LocalDate.now()));
				
				btnLamMoi = new MyButton();
				btnLamMoi.setFocusPainted(false);
				btnLamMoi.setText("Làm mới");
				btnLamMoi.setBackground(Color.white);
				btnLamMoi.setRadius(20);
				btnLamMoi.setIcon(new ImageIcon(ChamCongNhanVien_Form.class.getResource("/icon/reset.png")));
				btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnLamMoi.setBounds(1004, 10, 137, 48);
				add(btnLamMoi);
				btnLamMoi.addActionListener(this);
		txtTimKiemCC.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiemCC.getText().isEmpty()) {
					txtTimKiemCC.setText("Nhập dữ liệu chấm công cần tìm...");
					txtTimKiemCC.setForeground(Color.GRAY);
				}
				super.focusLost(e);
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiemCC.getText().equalsIgnoreCase("Nhập dữ liệu chấm công cần tìm...")) {
					txtTimKiemCC.setText("");
					txtTimKiemCC.setForeground(Color.BLACK);
				}
				super.focusGained(e);
			}
		});
		TableColumn roleColumn = tableChamCong.getColumnModel().getColumn(5);
		roleColumn.setCellEditor(new ComboBoxCellEditor(new String[] { "Có mặt", "Có phép", "Không phép" }));
		LocTheoPhongBan();
		getListNVTheoPhongBan();
		getListNVchuaChamCong();
		getListChamCong();
		selectColumn();
		
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchEmployee();
			}
		});
		txtTimKiemCC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchEmployee();
			}
		});
	}

	public void LocTheoPhongBan() {
		boxPhongBan.addItem("Tất cả");
		ArrayList<PhongBan> listPB = phongBan_BUS.getDSPB();
		for (PhongBan phongBan : listPB) {
			boxPhongBan.addItem(phongBan.getTenPhongBan());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(boxPhongBan)) {
			getListNVTheoPhongBan();
		}
		if (o.equals(btnChamCong)) {
			chamCongTatCa();
			getListChamCong();
		}
		if (o.equals(btnSetALL)) {
			setCoMatAll();
		}
		if (o.equals(btnReset)) {
			updateData();
		}
		if(o.equals(btnLamMoi))
		{
			txtTimKiem.setText("Nhập dữ liệu nhân viên cần tìm...");
			txtTimKiem.setForeground(Color.GRAY);
			txtTimKiem.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					if (txtTimKiem.getText().isEmpty()) {
						txtTimKiem.setText("Nhập dữ liệu nhân viên cần tìm...");
						txtTimKiem.setForeground(Color.GRAY);
					}
					super.focusLost(e);
				}

				@Override
				public void focusGained(FocusEvent e) {
					if (txtTimKiem.getText().equalsIgnoreCase("Nhập dữ liệu nhân viên cần tìm...")) {
						txtTimKiem.setText("");
						txtTimKiem.setForeground(Color.BLACK);
					}
					super.focusGained(e);
				}
			});
			
			if(txtTimKiem.getText().equalsIgnoreCase("Nhập dữ liệu nhân viên cần tìm..."))
			{
				txtTimKiem.setText("");
				searchEmployee();
				txtTimKiem.setText("Nhập dữ liệu nhân viên cần tìm...");
			}
			boxPhongBan.setSelectedIndex(0);
		}
	}

	private void searchEmployee() {
		String searchText = txtTimKiem.getText().trim();
		sorter = new TableRowSorter<>(modelNV);
		tableNhanVien.setRowSorter(sorter);
		RowFilter<DefaultTableModel, Object> idOrNameFilter = new RowFilter<DefaultTableModel, Object>() {
			@Override
			public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
				String text = searchText.toLowerCase();
				for (int i = 0; i < entry.getValueCount(); i++) {
					Object value = entry.getValue(i);
					if (value != null && value.toString().toLowerCase().contains(text)) {
						return true;
					}
				}
				return false;
			}
		};
		sorter.setRowFilter(idOrNameFilter);
	}
	private void searchEmployeeCC() {
		String searchText = txtTimKiemCC.getText().trim();
		sorter = new TableRowSorter<>(modelCC);
		tableChamCong.setRowSorter(sorter);
		RowFilter<DefaultTableModel, Object> idOrNameFilter = new RowFilter<DefaultTableModel, Object>() {
			@Override
			public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
				String text = searchText.toLowerCase();
				for (int i = 0; i < entry.getValueCount(); i++) {
					Object value = entry.getValue(i);
					if (value != null && value.toString().toLowerCase().contains(text)) {
						return true;
					}
				}
				return false;
			}
		};
		sorter.setRowFilter(idOrNameFilter);
	}

	private void setCoMatAll() {
		// TODO Auto-generated method stub
		buttonClickCount++;

		int columnToSelect = 4; // Chọn cột 1, thay đổi nếu cần
		boolean selectValue = (buttonClickCount % 2 == 1); // Đảo ngược trạng thái mỗi lần nhấn
		for (int row = 0; row < tableNhanVien.getRowCount(); row++) {
			tableNhanVien.setValueAt(selectValue, row, columnToSelect);
		}
	}

	private void getListNVTheoPhongBan() {
		// TODO Auto-generated method stub

		String tenPB = boxPhongBan.getSelectedItem().toString();
		if (!tenPB.equals("Tất cả")) {

			modelNV.setRowCount(0);
			String format = LocalDate.now().toString();
			ArrayList<NhanVien> listCC = chamCongNhanVien_BUS.getListNVchuaChamCong(format);
			for (NhanVien nhanVien : listCC) {
				if (phongBan_BUS.getPBTheoTen(tenPB).getIdPhongBan().equals(nhanVien.getPhongBan().getIdPhongBan())) {
					modelNV.addRow(new Object[] { nhanVien.getIdNhanVien(), nhanVien.getHoTen(),
							nhanVien.isPhai() ? "Nam" : "Nữ",
							phongBan_BUS.getPB(nhanVien.getPhongBan().getIdPhongBan()).getTenPhongBan(), false, false,
							false });
				}
			}
		} else {

			getListNVchuaChamCong();
		}
	}

	public void getListNVchuaChamCong() {
		modelNV.setRowCount(0);
		String format = LocalDate.now().toString();
		ArrayList<NhanVien> listCC = chamCongNhanVien_BUS.getListNVchuaChamCong(format);
		for (NhanVien nhanVien : listCC) {
			modelNV.addRow(new Object[] { nhanVien.getIdNhanVien(), nhanVien.getHoTen(),
					nhanVien.isPhai() ? "Nam" : "Nữ",
					phongBan_BUS.getPB(nhanVien.getPhongBan().getIdPhongBan()).getTenPhongBan(), false, false, false });
		}
	}

	private void getListChamCong() {
		modelCC.setRowCount(0);
		ArrayList<BangChamCongNhanVien> listCC = chamCongNhanVien_BUS.getListChamCong(LocalDate.now().toString());

		for (BangChamCongNhanVien bcc : listCC) {
			String tenpb = phongBan_BUS
					.getPB(nhanVien_BUS.getNV(bcc.getNhanVien().getIdNhanVien()).getPhongBan().getIdPhongBan())
					.getTenPhongBan();

			modelCC.addRow(new Object[] { bcc.getIdChamCongNVHC(), formatter.format(bcc.getNgayChamCong()),
					bcc.getNhanVien().getIdNhanVien(), nhanVien_BUS.getNV(bcc.getNhanVien().getIdNhanVien()).getHoTen(),
					tenpb, bcc.getTrangThai(), });
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		selectColumn();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void selectColumn() {
		ListSelectionModel selectionModel = tableNhanVien.getSelectionModel();

		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = tableNhanVien.getSelectedRow();
					int selectedColumn = 3;
					if (selectedRow != -1 && selectedColumn != -1) {
						selectedValue = tableNhanVien.getValueAt(selectedRow, selectedColumn);

					}
				}
			}
		});
	}

	private void chamCongTatCa() {
		int row = tableNhanVien.getSelectedRow();
		if(row!=-1)
		{
		if (JOptionPane.showConfirmDialog(this, "Bạn muốn lưu chấm công ?", "Cảnh báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			String ktra = txtTimKiem.getText().trim();
			if (!ktra.equalsIgnoreCase("Nhập dữ liệu nhân viên cần tìm...")) {
				searchEmployee();
				for (int i = 0; i < sorter.getViewRowCount(); i++) {
					if (tableNhanVien.getValueAt(i, 4).toString().equals("true")
							|| tableNhanVien.getValueAt(i, 5).toString().equals("true")
							|| tableNhanVien.getValueAt(i, 6).toString().equals("true")) {
						String manv = tableNhanVien.getValueAt(i, 0).toString();
						String tennv = tableNhanVien.getValueAt(i, 1).toString();
						String pb = tableNhanVien.getValueAt(i, 3).toString();
						String trangThai = "";
						if (tableNhanVien.getValueAt(i, 4).toString().equals("true")) {
							trangThai = "Có mặt";
						} else if (tableNhanVien.getValueAt(i, 5).toString().equals("true")) {
							trangThai = "Có phép";
						} else if (tableNhanVien.getValueAt(i, 6).toString().equals("true")) {
							trangThai = "Không phép";
						}
						NhanVien nv = new NhanVien(manv);
						BangChamCongNhanVien bcc = new BangChamCongNhanVien("1", LocalDate.now(), trangThai, nv);
						if (chamCongNhanVien_BUS.themChamCong(bcc)) {
							getListChamCong();
						}
					}
				}

				txtTimKiem.setText("");
				searchEmployee();
			} else {
				for (int i = 0; i < modelNV.getRowCount(); i++) {
					if (tableNhanVien.getValueAt(i, 4).toString().equals("true")
							|| tableNhanVien.getValueAt(i, 5).toString().equals("true")
							|| tableNhanVien.getValueAt(i, 6).toString().equals("true")) {
						String manv = tableNhanVien.getValueAt(i, 0).toString();
						String tennv = tableNhanVien.getValueAt(i, 1).toString();
						String pb = tableNhanVien.getValueAt(i, 3).toString();
						String trangThai = "";
						if (tableNhanVien.getValueAt(i, 4).toString().equals("true")) {
							trangThai = "Có mặt";
						} else if (tableNhanVien.getValueAt(i, 5).toString().equals("true")) {
							trangThai = "Có phép";
						} else if (tableNhanVien.getValueAt(i, 6).toString().equals("true")) {
							trangThai = "Không phép";
						}
						NhanVien nv = new NhanVien(manv);
						BangChamCongNhanVien bcc = new BangChamCongNhanVien("1", LocalDate.now(), trangThai, nv);
						if (chamCongNhanVien_BUS.themChamCong(bcc)) {
							getListChamCong();
						}
					}
				}
			}
			getListNVchuaChamCong();
		}
		}
		else
		{
			boolean flag=false;
			for(int i = 0;i < tableNhanVien.getRowCount();i++)
			{
				if(tableNhanVien.getValueAt(i, 4).toString().equals("true"))
				{
					flag = true;
				}
			}
			
			if(flag == false)
			{
				JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên để chấm công");
			}
			else
			{
				for (int i = 0; i < modelNV.getRowCount(); i++) {
					if (tableNhanVien.getValueAt(i, 4).toString().equals("true")
							|| tableNhanVien.getValueAt(i, 5).toString().equals("true")
							|| tableNhanVien.getValueAt(i, 6).toString().equals("true")) {
						String manv = tableNhanVien.getValueAt(i, 0).toString();
						String tennv = tableNhanVien.getValueAt(i, 1).toString();
						String pb = tableNhanVien.getValueAt(i, 3).toString();
						String trangThai = "";
						if (tableNhanVien.getValueAt(i, 4).toString().equals("true")) {
							trangThai = "Có mặt";
						} else if (tableNhanVien.getValueAt(i, 5).toString().equals("true")) {
							trangThai = "Có phép";
						} else if (tableNhanVien.getValueAt(i, 6).toString().equals("true")) {
							trangThai = "Không phép";
						}
						NhanVien nv = new NhanVien(manv);
						BangChamCongNhanVien bcc = new BangChamCongNhanVien("1", LocalDate.now(), trangThai, nv);
						if (chamCongNhanVien_BUS.themChamCong(bcc)) {
							getListChamCong();
						}
					}
				}
			}
			getListNVchuaChamCong();
		}
	}

	private class ComboBoxCellEditor extends DefaultCellEditor {
		private JComboBox<String> comboBox;

		public ComboBoxCellEditor(String[] items) {
			super(new JComboBox<>(items));
			this.comboBox = (JComboBox<String>) getComponent();
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			comboBox.setSelectedItem(value);
			return super.getTableCellEditorComponent(table, value, isSelected, row, column);
		}
	}

	private void updateData() {
		int selectedRow = tableChamCong.getSelectedRow();
		if (selectedRow != -1) {
			// Lấy giá trị từ JComboBox editor trong ô cần cập nhật
			TableCellEditor editor = tableChamCong.getCellEditor(selectedRow, 5);
			Object value = editor.getCellEditorValue();

			// Cập nhật giá trị từ JComboBox vào cột tương ứng trong JTable
			modelCC.setValueAt(value, selectedRow, 5);
			String maCC = tableChamCong.getValueAt(selectedRow, 0).toString();
			LocalDate date = LocalDate.now();
			String maNV = tableChamCong.getValueAt(selectedRow, 2).toString();
			String hoTen = tableChamCong.getValueAt(selectedRow, 3).toString();
			NhanVien nv = new NhanVien(maNV, hoTen);
			BangChamCongNhanVien bcc = new BangChamCongNhanVien(maCC, date, value + "", nv);
			if (chamCongNhanVien_BUS.update(bcc)) {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để cập nhật.");
		}
	}
}
