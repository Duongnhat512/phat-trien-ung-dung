package form;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.animation.timing.triggers.MouseTrigger;

import bus.CongDoanPhanCong_BUS;
import bus.CongDoanSanPham_BUS;
import bus.CongNhan_BUS;
import commons.Table;
import entities.CaLam;
import entities.ChiTietHopDong;
import entities.CongDoanPhanCong;
import entities.CongDoanSanPham;
import entities.CongNhan;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import commons.RoundPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import commons.MyButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import commons.RoundTextField;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class CongDoanPhanCong_Form extends JPanel implements ActionListener{
	private int width = 1259;
	private int height = 813;
	private Table tableCongNhan;
	private Table tableCongDoanSP;
	private MyButton btnPhanCong;
	private MyButton btnCapNhat;
	
	//
	private CongNhan_BUS congNhan_BUS = new CongNhan_BUS();
	private CongDoanPhanCong_BUS congDoanPhanCong_BUS = new CongDoanPhanCong_BUS();
	private CongDoanSanPham_BUS congDoanSanPham_BUS = new CongDoanSanPham_BUS();
	
	//
	private ArrayList<CongNhan> listCongNhan = new ArrayList<CongNhan>();
	private ArrayList<CongDoanSanPham> listCongDoan = new ArrayList<CongDoanSanPham>();
	private ArrayList<CongDoanPhanCong> listPhanCong = new ArrayList<CongDoanPhanCong>();
	private JTextField txtSLPhanCong;
	private JLabel lblIDCongNhan;
	private JLabel lblTenCongNhan;
	private JLabel lblPhanXuong;
	private JLabel lblTenSanPham;
	private JLabel lblTenCongDoan;
	private JLabel lblSLCanChia;
	private JComboBox cboCaLam;
	private Table tablePhanCong;
	
	/**
	 * Create the panel.
	 */
	public CongDoanPhanCong_Form() {
		setBorder(new EmptyBorder(0, 5, 10, 0));
		initComponents();
	}
	
	private void initComponents() {
		setSize(new Dimension(width, height));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setPreferredSize(new Dimension(this.width, (int)(this.height * 0.5)));
		add(panelNorth, BorderLayout.NORTH);
		
		RoundPanel panelSanPham = new RoundPanel();
		panelSanPham.setBackground(new Color(255, 255, 255));
		panelSanPham.setRound(20);
		panelSanPham.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelSanPham.setBounds(0, 64, 346, 332);
		
		RoundPanel panelCN = new RoundPanel();
		panelCN.setBackground(new Color(255, 255, 255));
		panelCN.setBounds(352, 64, 347, 332);
		panelCN.setRound(20);
		panelCN.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		RoundPanel panelThongTin = new RoundPanel();
		panelThongTin.setBounds(709, 64, 528, 332);
		panelThongTin.setRound(20);
		panelThongTin.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelThongTin.setBackground(new Color(255, 255, 255));
		panelCN.setLayout(new BorderLayout(0, 0));
		
		RoundPanel panelCenter = new RoundPanel();
		panelCenter.setRound(20);
		panelCenter.setPreferredSize(new Dimension(1196, 487));
		panelCenter.setBorder(new EmptyBorder(5, 15, 10, 10));
		panelCenter.setBackground(Color.WHITE);
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setBackground(Color.WHITE);
		panelCenter.add(scrollPane, BorderLayout.CENTER);
		
		tablePhanCong = new Table();
		tablePhanCong.setOpaque(false);
		scrollPane.setViewportView(tablePhanCong);
		
		tablePhanCong.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                	"ID Công nhân", "Tên công nhân", "Tên sản phẩm", "Tên công đoạn", "Số lượng được giao"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
		tablePhanCong.fixTable(scrollPane);
		
		RoundPanel panel_1 = new RoundPanel();
		panel_1.setRound(10);
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(153, 204, 255));
		panelCenter.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách phân công");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setOpaque(false);
		scrollPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCN.add(scrollPane2);
		
		tableCongNhan = new Table();
		tableCongNhan.setBorder(null);
		tableCongNhan.setOpaque(false);
		scrollPane2.setViewportView(tableCongNhan);
		tableCongNhan.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                	"ID Công nhân", "Tên công nhân", "Phân xưởng"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
		tableCongNhan.fixTable(scrollPane2);
		panelNorth.setLayout(null);
		panelNorth.add(panelSanPham);
		panelSanPham.setLayout(new BorderLayout(0, 0));
		
		tableCongDoanSP = new Table();
		tableCongDoanSP.setOpaque(false);
		tableCongDoanSP.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                	"Tên sản phẩm", "Tên công đoạn", "Số lượng cần chia"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setOpaque(false);
		scrollPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(tableCongDoanSP);
		tableCongDoanSP.fixTable(scrollPane_1);
		panelSanPham.add(scrollPane_1, BorderLayout.CENTER);
		
		RoundPanel panelTitleSP = new RoundPanel();
		panelTitleSP.setRound(10);
		panelTitleSP.setOpaque(false);
		panelTitleSP.setBackground(new Color(153, 204, 255));
		panelSanPham.add(panelTitleSP, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Danh sách công đoạn sản phẩm");
		lblNewLabel_1_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelTitleSP.add(lblNewLabel_1_1_2);
		panelNorth.add(panelCN);
		
		RoundPanel panel_1_1_1 = new RoundPanel();
		panel_1_1_1.setRound(10);
		panel_1_1_1.setOpaque(false);
		panel_1_1_1.setBackground(new Color(153, 204, 255));
		panelCN.add(panel_1_1_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Danh sách công nhân");
		lblNewLabel_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_1_1_1.add(lblNewLabel_1_1_1);
		panelNorth.add(panelThongTin);
		panelThongTin.setLayout(new BorderLayout(0, 0));
		
		RoundPanel panel_1_1 = new RoundPanel();
		panel_1_1.setRound(10);
		panel_1_1.setOpaque(false);
		panel_1_1.setBackground(new Color(153, 204, 255));
		panelThongTin.add(panel_1_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin phân công");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panelThongTin.add(panel_4, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("ID Công nhân:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JLabel lblTnCngNhn = new JLabel("Tên công nhân:");
		lblTnCngNhn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JLabel lblPhnXng = new JLabel("Phân xưởng:");
		lblPhnXng.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JLabel lblCaLm = new JLabel("Ca làm:");
		lblCaLm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JLabel lblTnCngon = new JLabel("Tên công đoạn:");
		lblTnCngon.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JLabel lblSLngCn = new JLabel("Số lượng cần chia:");
		lblSLngCn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JLabel lblSLngPhn = new JLabel("Số lượng phân công:");
		lblSLngPhn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblIDCongNhan = new JLabel("");
		lblIDCongNhan.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblTenCongNhan = new JLabel("");
		lblTenCongNhan.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblPhanXuong = new JLabel("");
		lblPhanXuong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblTenSanPham = new JLabel("");
		lblTenSanPham.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblTenCongDoan = new JLabel("");
		lblTenCongDoan.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		lblSLCanChia = new JLabel("");
		lblSLCanChia.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		cboCaLam = new JComboBox();
		cboCaLam.setFont(new Font("SansSerif", Font.PLAIN, 15));
		cboCaLam.setModel(new DefaultComboBoxModel<String>(new String[] {"Ca sáng", "Ca chiều", "Ca tối"}));
		
		txtSLPhanCong = new JTextField();
		txtSLPhanCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtSLPhanCong.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(lblIDCongNhan, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblTnCngNhn, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(lblTenCongNhan, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblPhnXng, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(lblPhanXuong, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblCaLm, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(cboCaLam, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblTnSnPhm, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(lblTenSanPham, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblTnCngon, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(lblTenCongDoan, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblSLngCn, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(111)
							.addComponent(lblSLCanChia, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblSLngPhn, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(95)
							.addComponent(txtSLPhanCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblIDCongNhan, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnCngNhn)
						.addComponent(lblTenCongNhan, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPhnXng)
						.addComponent(lblPhanXuong, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCaLm))
						.addComponent(cboCaLam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnSnPhm)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTenSanPham, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTnCngon)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTenCongDoan, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSLngCn)
						.addComponent(lblSLCanChia, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSLngPhn))
						.addComponent(txtSLPhanCong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_4.setLayout(gl_panel_4);
		
		btnCapNhat = new MyButton();
		btnCapNhat.setBounds(1096, 11, 141, 43);
		panelNorth.add(btnCapNhat);
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setRadius(10);
		btnCapNhat.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnCapNhat.setFocusPainted(false);
		btnCapNhat.setBackground(Color.WHITE);
		
		btnPhanCong = new MyButton();
		btnPhanCong.setBounds(949, 10, 141, 45);
		panelNorth.add(btnPhanCong);
		btnPhanCong.setText("Phân công");
		btnPhanCong.setRadius(10);
		btnPhanCong.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnPhanCong.setFocusPainted(false);
		btnPhanCong.setBackground(Color.WHITE);
		
		RoundTextField txtTimKiemCN = new RoundTextField(10);
		txtTimKiemCN.setText("Nhập tên công nhân cần tìm...");
		txtTimKiemCN.setForeground(Color.GRAY);
		txtTimKiemCN.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTimKiemCN.setColumns(10);
		txtTimKiemCN.setBorder(new EmptyBorder(0, 15, 0, 0));
		txtTimKiemCN.setBounds(352, 19, 347, 35);
		panelNorth.add(txtTimKiemCN);
		
		RoundTextField txtTimKiemCDSP = new RoundTextField(10);
		txtTimKiemCDSP.setText("Nhập tên sản phẩm cần tìm...");
		txtTimKiemCDSP.setForeground(Color.GRAY);
		txtTimKiemCDSP.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtTimKiemCDSP.setColumns(10);
		txtTimKiemCDSP.setBorder(new EmptyBorder(0, 15, 0, 0));
		txtTimKiemCDSP.setBounds(10, 19, 336, 35);
		panelNorth.add(txtTimKiemCDSP);
		
		
		layDanhSachCongNhan();
		docDuLieuLenTableCongNhan(listCongNhan);
		
		layDanhSachCongDoanSP();
		docDuLieuLenTableCongDoan(listCongDoan);
		
		layDanhSachPhanCong();
		docDuLieuDaPhanCongLenTable();
		
		// Đăng ký sự kiện cho các table
		tableCongDoanSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				duaDuLieuCongDoanLenLabel();
			}
		});
		tableCongNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				duaDuLieuCongNhanLenLabel();
			}
		});
		
		//Đăng ký sự kiện cho button
		btnPhanCong.addActionListener(this);
	}
	
	/**
	 * Lấy danh sách đã phân công
	 */
	private void layDanhSachPhanCong() {
		listPhanCong = congDoanPhanCong_BUS.getDanhSachPhanCong();
	}
	
	
	/**
	 * Lấy danh sách công nhân
	 */
	private void layDanhSachCongNhan() {
		listCongNhan = congNhan_BUS.getDanhSachCongNhanChuaPhanCong();
	}
	
	private void docDuLieuLenTableCongNhan(ArrayList<CongNhan> list) {
		tableCongNhan.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableCongNhan.getModel();
		dm.getDataVector().removeAllElements();
		
		for(CongNhan cn : list) {
			dm.addRow(new Object[] {cn.getIdCongNhan(), cn.getHoTen(), cn.getPhanXuong().getTenPhanXuong()});
		}
	}
	
	/**
	 * Lấy danh sách công đoạn chưa chia xong
	 */
	private void layDanhSachCongDoanSP() {
		listCongDoan = congDoanSanPham_BUS.getDanhSachCongDoanChuaChiaXong();
	}
	
	private void docDuLieuLenTableCongDoan(ArrayList<CongDoanSanPham> list) {
		tableCongDoanSP.clearSelection();
		DefaultTableModel dm = (DefaultTableModel) tableCongDoanSP.getModel();
		dm.getDataVector().removeAllElements();
		for (CongDoanSanPham congDoanSanPham : list) {
			dm.addRow(new Object[] {congDoanSanPham.getSanPham().getTenSanPham(), congDoanSanPham.getTenCongDoan(), congDoanSanPham.getSoLuongSanPham()});
		}
	}
	
	/**
	 * Đưa dữ liệu công đoạn lên label
	 */
	private void duaDuLieuCongDoanLenLabel() {
		int row = tableCongDoanSP.getSelectedRow();
		if (row != -1) {
			lblTenSanPham.setText(tableCongDoanSP.getValueAt(row, 0).toString());
			lblTenCongDoan.setText(tableCongDoanSP.getValueAt(row, 1).toString());
			lblSLCanChia.setText(tableCongDoanSP.getValueAt(row, 2).toString());
		}
	}
	
	/**
	 * Đưa dữ liệu Công nhân lên các label
	 */
	private void duaDuLieuCongNhanLenLabel() {
		int row = tableCongNhan.getSelectedRow();
		if (row != -1) {
			lblIDCongNhan.setText(tableCongNhan.getValueAt(row, 0).toString());
			lblTenCongNhan.setText(tableCongNhan.getValueAt(row, 1).toString());
			lblPhanXuong.setText(tableCongNhan.getValueAt(row, 2).toString());
			txtSLPhanCong.setText("1");
		}
	}
	
	/**
	 * Lấy data từ các label và textfield
	 * @return
	 */
	private CongDoanPhanCong getDataPhanCong() {
		int rowTblCongDoan = tableCongDoanSP.getSelectedRow();
		if (rowTblCongDoan == -1) {
			JOptionPane.showMessageDialog(this, "Bạn cần chọn công đoạn để phân công!");
			return null;
		}
		int rowTblCongNhan = tableCongNhan.getSelectedRow();
		if(rowTblCongNhan == -1) {
			JOptionPane.showMessageDialog(this, "Bạn cần chọn công nhân để phân công!");
			return null;
		}
		String idPhanCong = String.format("PC%04d", listPhanCong.size() + 1);
		int sLPhanCong = 0;
		try {
			sLPhanCong = Integer.parseInt(txtSLPhanCong.getText());
			if (sLPhanCong <= 0) {
				JOptionPane.showMessageDialog(this, "Số lượng phân công phải là số dương!");
				txtSLPhanCong.selectAll();
				txtSLPhanCong.requestFocus();
				return null;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Số lượng phân công phải là chữ số!");
			txtSLPhanCong.selectAll();
			txtSLPhanCong.requestFocus();
			return null;
		}
		CaLam caLam = new CaLam(cboCaLam.getSelectedIndex() + 1);
		CongDoanSanPham congDoanSanPham = listCongDoan.get(rowTblCongDoan);
		CongNhan cn = listCongNhan.get(rowTblCongNhan);
		return new CongDoanPhanCong(idPhanCong, congDoanSanPham, cn, sLPhanCong, caLam, sLPhanCong);
	}
	
	/**
	 * Thêm phân công
	 */
	private void themPhanCong() {
		CongDoanPhanCong cdPC = getDataPhanCong();
		if(cdPC != null) {
			if (congDoanPhanCong_BUS.themPhanCong(cdPC)) {
				JOptionPane.showMessageDialog(this, "Phân công thành công!");
			}
			else {
				JOptionPane.showMessageDialog(this, "Phân công không thành công!");
			}
		}
		congDoanSanPham_BUS.updateSoLuongSanPham(cdPC.getCongDoanSP().getIdCongDoan(), cdPC.getSoLuongSanPhamDuocGiao());
		layDanhSachCongNhan();
		docDuLieuLenTableCongNhan(listCongNhan);
		
		layDanhSachCongDoanSP();
		docDuLieuLenTableCongDoan(listCongDoan);
		
		layDanhSachPhanCong();
		docDuLieuDaPhanCongLenTable();
	}
	
	/**
	 * Đọc dữ liệu phân công lên table
	 */
	private void docDuLieuDaPhanCongLenTable() {
		DefaultTableModel dm = (DefaultTableModel) tablePhanCong.getModel();
		dm.getDataVector().removeAllElements();
		
		for(CongDoanPhanCong cdpc : listPhanCong) {
			dm.addRow(new Object[] {cdpc.getCongNhan().getIdCongNhan(), cdpc.getCongNhan().getHoTen(), 
					cdpc.getCongDoanSP().getSanPham().getTenSanPham(), cdpc.getCongDoanSP().getTenCongDoan(),
					cdpc.getSoLuongSanPhamDuocGiao()});
		}
		tablePhanCong.repaint();
		tablePhanCong.revalidate();
	}
	
	private void timCongDoanTheoTenSP(String tenSP) {
		ArrayList<CongDoanSanPham> temp = new ArrayList<CongDoanSanPham>();
		for (CongDoanSanPham congDoanSanPham : listCongDoan) {
			if (congDoanSanPham.getSanPham().getTenSanPham().trim().toUpperCase().contains(tenSP.trim().toUpperCase())) {
				temp.add(congDoanSanPham);
			}
		}
		listCongDoan = new ArrayList<CongDoanSanPham>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnPhanCong)) {
			themPhanCong();
		}
		
	}
}