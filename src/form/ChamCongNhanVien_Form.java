package form;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import com.toedter.calendar.JDateChooser;

import bus.BangLuongNhanVien_BUS;
import bus.ChamCongNhanVien_BUS;
import bus.NhanVien_BUS;
import bus.PhongBan_BUS;

import javax.swing.*;
import commons.RoundPanel;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;

public class ChamCongNhanVien_Form extends JPanel implements ActionListener, MouseListener, PropertyChangeListener {
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
	private JRadioButton radCoMat;
	private JRadioButton radVang;
	private JRadioButton radCoPhep;
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
	private JDateChooser dateChamCong;
	private Date valueOld;
	public Date selectedDate;
	private JButton btnChamCong;
	private JButton btnSetALL;
	private JButton btnReset;
	private Object selectedValue;
	private ButtonGroup group2;
	private JButton btnChamCongALL;
	private static int buttonClickCount = 0;

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
		panelCenterLeft.setBounds(23, 71, 589, 308);
		panelCenterLeft.setRound(20);
		panelCenterLeft.setBackground(new Color(255, 255, 255));
		panelCenterLeft.setBorder(new EmptyBorder(5, 15, 10, 10));

		panelSouth = new RoundPanel();
		panelSouth.setBounds(23, 389, 1204, 378);
		panelSouth.setLayout(new BorderLayout());
		panelSouth.setBackground(new Color(255, 255, 255));
		panelSouth.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelSouth.setPreferredSize(new Dimension((int) (this.width * 0.95), (int) (this.height * 0.6)));
		panelSouth.setRound(20);

		RoundPanel panelCenterRight = new RoundPanel();
		panelCenterRight.setBounds(630, 43, 597, 336);
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
				.addComponent(panelThongTin, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE));
		gl_panelCenterRight.setVerticalGroup(gl_panelCenterRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenterRight.createSequentialGroup()
						.addComponent(panelThongTin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)));
		panel_2.setLayout(null);
		panelCenterRight.setLayout(gl_panelCenterRight);
		panelCenterLeft.setLayout(new BorderLayout(0, 0));
		panelSouth.setLayout(new BorderLayout(0, 0));
		JLabel lbIDNhanVien = new JLabel("ID Nhân Viên:");
		lbIDNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbIDNhanVien.setBounds(29, 24, 108, 24);
		panel_2.add(lbIDNhanVien);

		btnChamCong = new JButton("Chấm công");
		btnChamCong.setIcon(new ImageIcon(ChamCongNhanVien_Form.class.getResource("/icon/add.png")));
		btnChamCong.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChamCong.setBounds(29, 221, 165, 36);
		panel_2.add(btnChamCong);

		btnReset = new JButton("Cập nhật");
		btnReset.setIcon(new ImageIcon(ChamCongNhanVien_Form.class.getResource("/icon/update.png")));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(426, 221, 151, 36);
		panel_2.add(btnReset);

		JLabel lbTenNV = new JLabel("Tên nhân viên:");
		lbTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbTenNV.setBounds(29, 72, 103, 24);
		panel_2.add(lbTenNV);

		JLabel lbNgayCong = new JLabel("Ngày công:");
		lbNgayCong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lbNgayCong.setBounds(29, 119, 108, 21);
		panel_2.add(lbNgayCong);

		JLabel lblPhongBan = new JLabel("Phòng ban:");
		lblPhongBan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhongBan.setBounds(29, 165, 108, 21);
		panel_2.add(lblPhongBan);

		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTrangThai.setBounds(350, 26, 108, 21);
		panel_2.add(lblTrangThai);

		radCoMat = new JRadioButton("Có mặt");
		radCoMat.setVisible(false);
		radCoMat.setBackground(new Color(255, 255, 255));
		radCoMat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radCoMat.setBounds(437, 26, 103, 21);
		panel_2.add(radCoMat);

		radVang = new JRadioButton("Không phép");
		radVang.setVisible(false);
		radVang.setBackground(new Color(255, 255, 255));
		radVang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radVang.setBounds(437, 98, 120, 21);
		panel_2.add(radVang);

		radCoPhep = new JRadioButton("Có phép");
		radCoPhep.setVisible(false);
		radCoPhep.setBackground(new Color(255, 255, 255));
		radCoPhep.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radCoPhep.setBounds(437, 60, 103, 21);
		panel_2.add(radCoPhep);

		textPhongBan = new JLabel("");
		textPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPhongBan.setBounds(145, 162, 210, 28);
		panel_2.add(textPhongBan);

		textNgay = new JLabel("");
		textNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNgay.setBounds(145, 116, 210, 28);
		panel_2.add(textNgay);

		lbMaNV = new JLabel("");
		lbMaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMaNV.setBounds(145, 24, 210, 28);
		panel_2.add(lbMaNV);

		textTen = new JLabel("");
		textTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTen.setBounds(145, 72, 210, 28);
		panel_2.add(textTen);

		btnChamCongALL = new JButton("Chấm công hàng loạt");
		btnChamCongALL.setIcon(new ImageIcon(ChamCongNhanVien_Form.class.getResource("/icon/add.png")));
		btnChamCongALL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChamCongALL.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChamCongALL.setBounds(206, 221, 210, 36);
		panel_2.add(btnChamCongALL);
		// Bảng công nhân

		tableNhanVien = new Table();
		tableNhanVien.setOpaque(false);
		tableNhanVien.setModel(modelNV = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00F2ng Ban", "C\u00F3 m\u1EB7t" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		JScrollPane scrollListNV = new JScrollPane();
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
					textPhongBan.setText(tableNhanVien.getValueAt(row, 2).toString());
					String day = dateChamCong.getDate().getDate() + "";
					if (day.length() < 2) {
						day = "0" + day;
					}
					String month = (dateChamCong.getDate().getMonth() + 1) + "";
					if (month.length() < 2) {
						month = "0" + month;
					}

					String year = (dateChamCong.getDate().getYear() + 1900) + "";
					String format = year + "-" + month + "-" + day;
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
		panelSouth.add(scrollListCC);

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

					if (tableChamCong.getValueAt(row, 5).toString().equals("Có mặt")) {
						radCoMat.setVisible(true);
						radCoMat.setSelected(true);
						radVang.setVisible(true);
						radVang.setBounds(437, 98, 110, 21);
						radCoPhep.setVisible(true);
					} else if (tableChamCong.getValueAt(row, 5).toString().equals("Có phép")) {
						radCoMat.setVisible(true);
						radCoPhep.setSelected(true);
						radVang.setVisible(true);
						radVang.setBounds(437, 98, 110, 21);
						radCoPhep.setVisible(true);
					} else {
						radCoMat.setVisible(true);
						radVang.setSelected(true);
						radVang.setVisible(true);
						radCoPhep.setVisible(true);
						radVang.setBounds(437, 98, 110, 21);
					}
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
		lblNewLabel.setBounds(23, 10, 122, 23);
		add(lblNewLabel);

		dateChamCong = new JDateChooser();
		dateChamCong.setBounds(144, 10, 146, 29);
		add(dateChamCong);
		dateChamCong.addPropertyChangeListener("date", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					// Xử lý sự kiện khi ngày thay đổi
					selectedDate = (Date) evt.getNewValue();
					valueOld = (Date) evt.getOldValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

				}
			}

		});
		JLabel lblNewLabel_1 = new JLabel("Phòng Ban:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(311, 16, 90, 23);
		add(lblNewLabel_1);

		boxPhongBan = new JComboBox();
		boxPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boxPhongBan.setBounds(397, 9, 157, 30);
		add(boxPhongBan);

		dateChamCong.setDate(new Date(LocalDate.now().getYear() - 1900, LocalDate.now().getMonthValue() - 1,
				LocalDate.now().getDayOfMonth()));
		boxPhongBan.addActionListener(this);

		btnChamCong.addActionListener(this);
		tableNhanVien.addMouseListener(this);
		tableChamCong.addMouseListener(this);
		dateChamCong.addPropertyChangeListener(this);

		btnSetALL = new JButton("");
		btnSetALL.setBackground(new Color(255, 255, 255));
		btnSetALL.setIcon(new ImageIcon(ChamCongNhanVien_Form.class.getResource("/icon/select.png")));
		btnSetALL.setBounds(561, 38, 51, 33);
		add(btnSetALL);
		btnSetALL.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSetALL.addActionListener(this);
		btnChamCongALL.addActionListener(this);
		btnReset.addActionListener(this);

		group2 = new ButtonGroup();
		group2.add(radCoMat);
		group2.add(radVang);
		group2.add(radCoPhep);
		radCoMat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				radCoPhep.setSelected(false);
				radVang.setSelected(false);
			}
		});

		radCoPhep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				radCoMat.setSelected(false);
			}
		});

		radVang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				radCoMat.setSelected(false);
			}
		});
		tableNhanVien.addMouseListener(this);
		LocTheoPhongBan();
		getListNVTheoPhongBan();
		getListNVchuaChamCong();
		getListChamCong();
		selectColumn();
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
			ActionChamCong();
		}
		if (o.equals(btnSetALL)) {
			setCoMatAll();
		}

		if (o.equals(btnChamCongALL)) {
			chamCongTatCa();
		}
		if (o.equals(btnReset)) {
			datLaiChamCong();
		}
	}

	private void datLaiChamCong() {
		// TODO Auto-generated method stub
		int row = tableChamCong.getSelectedRow();

		if (row != -1) {
			if (JOptionPane.showConfirmDialog(this, "Bạn muốn sửa lại chấm công nhân viên đúng không ?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				NhanVien nv = new NhanVien(tableChamCong.getValueAt(row, 2).toString());
				String trangThai = "";
				if (radCoMat.isSelected()) {
					trangThai = "Có mặt";
				} else {
					if (radCoPhep.isSelected()) {
						trangThai = "Có phép";
					} else {
						trangThai = "Không phép";
					}
				}
				BangChamCongNhanVien bcc = new BangChamCongNhanVien(tableChamCong.getValueAt(row, 0).toString(),
						LocalDate.parse(tableChamCong.getValueAt(row, 1).toString()), trangThai, nv);

				if (chamCongNhanVien_BUS.update(bcc)) {
					getListChamCong();
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên để chỉnh chấm công");
		}
	}

	private void setCoMatAll() {
		// TODO Auto-generated method stub
		buttonClickCount++;
		int columnToSelect = 3; // Chọn cột 1, thay đổi nếu cần
		boolean selectValue = (buttonClickCount % 2 == 1); // Đảo ngược trạng thái mỗi lần nhấn
		for (int row = 0; row < tableNhanVien.getRowCount(); row++) {
			modelNV.setValueAt(selectValue, row, columnToSelect);
		}
	}

	private void ActionChamCong() {
		// TODO Auto-generated method stub
		try {
			String idNV = lbMaNV.getText();
			LocalDate ngayChamCong = LocalDate.parse(textNgay.getText());
			String trangThai = "Có mặt";
			if (tableNhanVien.getValueAt(tableNhanVien.getSelectedRow(), 3).toString().equals("true")) {
				trangThai = "Có mặt";
			} else {
				if (radVang.isSelected()) {
					trangThai = "Không phép";
				} else if (radCoPhep.isSelected()) {
					trangThai = "Có phép";
				} else if (!radCoPhep.isSelected() && !radVang.isSelected()) {
					JOptionPane.showMessageDialog(this, "Hãy chọn trạng thái chấm công ");
					return;
				}
			}
			NhanVien nv = new NhanVien(idNV);
			BangChamCongNhanVien bcc = new BangChamCongNhanVien("1", ngayChamCong, trangThai, nv);
			System.out.println(bcc.getTrangThai() + "");
			int row = tableNhanVien.getSelectedRow();
			if (chamCongNhanVien_BUS.themChamCong(bcc)) {
				modelNV.removeRow(row);
				getListChamCong();
			} else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void getListNVTheoPhongBan() {
		// TODO Auto-generated method stub

		String tenPB = boxPhongBan.getSelectedItem().toString();
		if (!tenPB.equals("Tất cả")) {

			modelNV.setRowCount(0);
			String day = dateChamCong.getDate().getDate() + "";
			String month = (dateChamCong.getDate().getMonth() + 1) + "";
			String year = (dateChamCong.getDate().getYear() + 1900) + "";
			String format = year + "-" + month + "-" + day;
			System.out.println(format);
			ArrayList<NhanVien> listCC = chamCongNhanVien_BUS.getListNVchuaChamCong(format);
			for (NhanVien nhanVien : listCC) {
				if (phongBan_BUS.getPBTheoTen(tenPB).getIdPhongBan().equals(nhanVien.getPhongBan().getIdPhongBan())) {
					modelNV.addRow(new Object[] { nhanVien.getIdNhanVien(), nhanVien.getHoTen(),
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
		String day = dateChamCong.getDate().getDate() + "";
		String month = (dateChamCong.getDate().getMonth() + 1) + "";
		String year = (dateChamCong.getDate().getYear() + 1900) + "";
		String format = year + "-" + month + "-" + day;
		System.out.println(format);
		ArrayList<NhanVien> listCC = chamCongNhanVien_BUS.getListNVchuaChamCong(format);
		for (NhanVien nhanVien : listCC) {
			modelNV.addRow(new Object[] { nhanVien.getIdNhanVien(), nhanVien.getHoTen(),
					phongBan_BUS.getPB(nhanVien.getPhongBan().getIdPhongBan()).getTenPhongBan(), false, false, false });
		}
	}

	private void getListChamCong() {
		modelCC.setRowCount(0);
		String day = dateChamCong.getDate().getDate() + "";
		String month = (dateChamCong.getDate().getMonth() + 1) + "";
		String year = (dateChamCong.getDate().getYear() + 1900) + "";
		String format = year + "-" + month + "-" + day;
		ArrayList<BangChamCongNhanVien> listCC = chamCongNhanVien_BUS.getListChamCong(format);
		for (BangChamCongNhanVien bcc : listCC) {
			String tenpb = phongBan_BUS
					.getPB(nhanVien_BUS.getNV(bcc.getNhanVien().getIdNhanVien()).getPhongBan().getIdPhongBan())
					.getTenPhongBan();
			modelCC.addRow(new Object[] { bcc.getIdChamCongNVHC(), bcc.getNgayChamCong(),
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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if ("date".equals(evt.getPropertyName())) {
			// Xử lý sự kiện khi ngày thay đổi
			selectedDate = (Date) evt.getNewValue();
			valueOld = (Date) evt.getOldValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String format = dateFormat.format(selectedDate);
			int year = selectedDate.getYear() + 1900;
			int month = selectedDate.getMonth() + 1;
			int day = selectedDate.getDate();
			LocalDate select = LocalDate.parse(format);
			if (select.isAfter(LocalDate.now())) {
				JOptionPane.showMessageDialog(this, "Ngày chấm công không được lớn hơn ngày hiện tại");
				dateChamCong.setDate(valueOld);
				return;
			} else {
				getListChamCong();
				modelNV.setRowCount(0);
				ArrayList<NhanVien> listCC = chamCongNhanVien_BUS.getListNVchuaChamCong(format);
				for (NhanVien nhanVien : listCC) {
					modelNV.addRow(new Object[] { nhanVien.getIdNhanVien(), nhanVien.getHoTen(),
							phongBan_BUS.getPB(nhanVien.getPhongBan().getIdPhongBan()).getTenPhongBan(), false, false,
							false });
				}
			}
		}
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
						System.out.println(selectedValue);
						if (tableNhanVien.getValueAt(selectedRow, 3).toString().equals("true")) {
							radCoMat.setVisible(true);
							radCoMat.setSelected(true);
							radVang.setVisible(false);
							radCoPhep.setVisible(false);
						} else {
							radCoMat.setVisible(false);
							radVang.setVisible(true);
							radCoPhep.setVisible(true);
							radCoPhep.setSelected(false);
							radVang.setSelected(false);
							radVang.setBounds(437, 27, 110, 21);

						}
					}

				}
			}
		});
	}

	private void chamCongTatCa() {
		if (JOptionPane.showConfirmDialog(this, "Bạn muốn chấm công tất cả nhân viên ?", "Cảnh báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			ArrayList<Object> listNVChuaCheck = new ArrayList<Object>();
			int soLuong = tableNhanVien.getModel().getRowCount();
			for (int i = 0; i < soLuong; i++) {
				if ("true".equalsIgnoreCase(tableNhanVien.getValueAt(i, 3).toString())) {
					String manv = tableNhanVien.getValueAt(i, 0).toString();
					String tennv = tableNhanVien.getValueAt(i, 1).toString();
					String pb = tableNhanVien.getValueAt(i, 2).toString();
					String trangThai = tableNhanVien.getValueAt(i, 3).toString();
					if (trangThai.endsWith("true")) {
						trangThai = "Có mặt";
					}
					String day = dateChamCong.getDate().getDate() + "";
					if (day.length() < 2) {
						day = "0" + day;
					}
					String month = (dateChamCong.getDate().getMonth() + 1) + "";
					if (month.length() < 2) {
						month = "0" + month;
					}
					String year = (dateChamCong.getDate().getYear() + 1900) + "";
					String format = year + "-" + month + "-" + day;
					NhanVien nv = new NhanVien(manv);
					BangChamCongNhanVien bcc = new BangChamCongNhanVien("1", LocalDate.parse(format), trangThai, nv);
					if (chamCongNhanVien_BUS.themChamCong(bcc)) {
						getListChamCong();
					}
				}
			}
			getListNVchuaChamCong();

		}
	}
}
