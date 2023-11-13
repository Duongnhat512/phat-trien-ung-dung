package form;


import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import connectDB.ConnectDB;
import entities.CongNhan;
import entities.PhanXuong;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import bus.CongNhan_BUS;
import bus.PhanXuong_BUS;
import commons.RoundPanel;
import commons.Table;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Nguyễn Gia Bảo, Ngô Quốc Đạt, Nguyễn Nhất Dương, Võ Văn Nghĩa Hiệp
 * @version 1.0s
 *
 */

public class QuanLyCongNhan_Form extends JPanel implements ActionListener, MouseListener{


	private DefaultTableModel model;

	private JTextField textTimKiem;
	private JTextField txt_HienThiID;
	private JTextField txt_HienThiHoTen;
	private JTextField txt_HienThiPhai;
	private JTextField txt_HienThiCCCD;
	private JTextField txt_HienThiNgaySinh;
	private JTextField txt_HienThiTayNghe;
	private JTextField txt_HienThiPX;
	private JTextField txt_HienThiSDT;
	private JTextField txt_HienThiEmail;
	private JTextField txt_HienThiTrangThai;
	private  int width = 1259;
	private  int height = 813;
	private JButton btnChonAnh;
	private RoundPanel panel_Them_SuaCongNhan;
	private JButton btnThemCongNhan;
	private JButton btnHuyThem;
	private JButton btnCapNhatCongNhan;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JDateChooser dateChooser_NgaySinh;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private JDateChooser dateChooser_ngayKTCT;
	private JComboBox<String> cb_PhanXuong;
	private JButton btnthem;
	private JButton btnCapNhat;
	private JButton btnTimKiem;
	private JPanel panel_CongNhan;
	private JLabel lbl_CCCD;
	private JTextField txtCCCD;
	private CongNhan_BUS cn_bus;
	private JTextField txtID;
	private JComboBox<String> cb_TayNghe;
	private RoundPanel panel_bangTTCN;
	private JScrollPane scrollPane;
	private JDateChooser dateChooser_ngayCT;
	private java.sql.Date selectedDate;
	private Table tableCongNhan;

	private JLabel lblChuCNang;






	private JLabel avatarImage;

	private JLabel hienThiAvatar;

	private JFileChooser fileChooser;

	private PhanXuong_BUS px_bus;

	private JLabel lbl_NgayKetThucCT;

	private String url;



	
	/**
	 * Create the frame.
	 */
	    public QuanLyCongNhan_Form(int width, int height) {
			this.width = width;
			this.height= height;
			giaoDienCN();
//			giaoDienThemCapNhatCN();
			
		}
	  private void giaoDienCN() {
		  
		  
		  	setForeground(new Color(255, 255, 255));
		  	setPreferredSize(new Dimension(1259,780));
			
		  	try {
				ConnectDB.getInstance().connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  	
		  	
		  	cn_bus = new CongNhan_BUS();
		  	px_bus = new PhanXuong_BUS();
			//Panel danh sách cong nhan
			
			panel_CongNhan = new JPanel();
			panel_CongNhan.setBounds(0, 0, 1259,813);
			panel_CongNhan.setLayout(null);
			
			panel_bangTTCN = new RoundPanel();
			panel_bangTTCN.setRound(20);
			panel_bangTTCN.setBackground(new Color(255, 255, 255));
			panel_bangTTCN.setBounds(10, 78, 1230, 382);
			panel_CongNhan.add(panel_bangTTCN);
			panel_bangTTCN.setLayout(null);
			
			RoundPanel panelTieuDe = new RoundPanel();
			panelTieuDe.setRound(20);
			panelTieuDe.setLayout(new BorderLayout(0, 0));
			JLabel tieuDe = new JLabel("Bảng thông tin công nhân");
			panelTieuDe.add(tieuDe);
			panelTieuDe.setBounds(10, 10, 1210, 30);
			panelTieuDe.setBackground(new Color(113, 184, 255));
			tieuDe.setHorizontalAlignment(SwingConstants.CENTER);
			tieuDe.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_bangTTCN.add(panelTieuDe);
			String[] headers = {"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00E1i", "Ng\u00E0y sinh", "Ngày công tác", "Phân xưởng", "Tay nghề", "Email", "S\u0110T", "CCCD","Tr\u1EA1ng th\u00E1i"};
			model = new DefaultTableModel(headers , 0);
		

			tableCongNhan = new Table();
			tableCongNhan.setOpaque(false);
	        // Cài đặt header cho table Chấm công
			tableCongNhan.setModel(model);
			tableCongNhan.getColumnModel().getColumn(8).setPreferredWidth(72);
			
					
	        
			scrollPane = new JScrollPane();
	        scrollPane.setBackground(new Color(255, 255, 255));
	        scrollPane.setOpaque(false);
	        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        scrollPane.setViewportView(tableCongNhan);
	        scrollPane.setBounds(10, 40, 1210, 332);
	        tableCongNhan.fixTable(scrollPane);
	        panel_bangTTCN.add(scrollPane);
			
			
			

			
			
			
			
			//Panel chi tiet thong tin 1 cong nhan
		    RoundPanel panel_ChiTietCN = new RoundPanel();
		    panel_ChiTietCN.setRound(20);
			panel_ChiTietCN.setBackground(new Color(240, 240, 240));
			panel_ChiTietCN.setBounds(10, 470, 1230, 300);
			panel_CongNhan.add(panel_ChiTietCN);
			panel_ChiTietCN.setLayout(null);
			
			RoundPanel panel_Avt = new RoundPanel();
			panel_Avt.setRound(20);
			panel_Avt.setBackground(new Color(255, 255, 255));
			panel_Avt.setBounds(0, 10, 205, 280);
			panel_ChiTietCN.add(panel_Avt);
			
		
	        panel_Avt.setLayout(null);

	        hienThiAvatar = new JLabel();
	        hienThiAvatar.setBounds(26, 18, 150, 200);
	        panel_Avt.add(hienThiAvatar);
			
			RoundPanel panel_LyLich = new RoundPanel();
			panel_LyLich.setBackground(new Color(255, 255, 255));
			panel_LyLich.setRound(20);
			panel_LyLich.setBounds(215, 10, 510, 280);
			panel_ChiTietCN.add(panel_LyLich);
			panel_LyLich.setLayout(null);
			
			RoundPanel panelLblLyLich = new RoundPanel();
			panelLblLyLich.setRound(20);
			panelLblLyLich.setLayout(new BorderLayout(0, 0));
			JLabel lb_LyLich = new JLabel("Lý lịch công nhân");
			lb_LyLich.setHorizontalAlignment(SwingConstants.CENTER);
			lb_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panelLblLyLich.add(lb_LyLich);
			panelLblLyLich.setBounds(10, 10, 490, 24);
			panelLblLyLich.setBackground(new Color(113, 184, 255));

			panel_LyLich.add(panelLblLyLich);
		
			JLabel lbl_HienThiHoTen = new JLabel("Họ và tên:");
			lbl_HienThiHoTen.setForeground(new Color(0, 0, 128));
			lbl_HienThiHoTen.setBackground(new Color(255, 255, 255));
			lbl_HienThiHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiHoTen.setBounds(10, 64, 130, 25);
			panel_LyLich.add(lbl_HienThiHoTen);
			
			JLabel lbl_HienThiCCCD = new JLabel("CCCD:");
			lbl_HienThiCCCD.setForeground(new Color(0, 0, 128));
			lbl_HienThiCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiCCCD.setBounds(10, 244, 130, 25);
			panel_LyLich.add(lbl_HienThiCCCD);
			
			JLabel lbl_HienThiPhai = new JLabel("Phái:");
			lbl_HienThiPhai.setForeground(new Color(0, 0, 128));
			lbl_HienThiPhai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiPhai.setBounds(10, 124, 130, 25);
			panel_LyLich.add(lbl_HienThiPhai);
			
			JLabel lbl_HienThiNgaySinh = new JLabel("Ngày sinh:");
			lbl_HienThiNgaySinh.setForeground(new Color(0, 0, 128));
			lbl_HienThiNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiNgaySinh.setBounds(10, 184, 130, 25);
			panel_LyLich.add(lbl_HienThiNgaySinh);
			
			txt_HienThiHoTen = new JTextField();
			txt_HienThiHoTen.setEditable(false);
			txt_HienThiHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiHoTen.setBackground(null);
			txt_HienThiHoTen.setBorder(null);
			txt_HienThiHoTen.setBounds(206, 64, 294, 25);
			panel_LyLich.add(txt_HienThiHoTen);
			txt_HienThiHoTen.setColumns(10);
			
			txt_HienThiPhai = new JTextField();
			txt_HienThiPhai.setEditable(false);
			txt_HienThiPhai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiPhai.setBackground(null);
			txt_HienThiPhai.setBorder(null);
			txt_HienThiPhai.setColumns(10);
			txt_HienThiPhai.setBounds(206, 124, 294, 25);
			panel_LyLich.add(txt_HienThiPhai);
			
			txt_HienThiCCCD = new JTextField();
			txt_HienThiCCCD.setEditable(false);
			txt_HienThiCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiCCCD.setBackground(null);
			txt_HienThiCCCD.setBorder(null);
			txt_HienThiCCCD.setColumns(10);
			txt_HienThiCCCD.setBounds(206, 244, 294, 25);
			panel_LyLich.add(txt_HienThiCCCD);
			
			txt_HienThiNgaySinh = new JTextField();
			txt_HienThiNgaySinh.setEditable(false);
			txt_HienThiNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiNgaySinh.setBackground(null);
			txt_HienThiNgaySinh.setBorder(null);
			txt_HienThiNgaySinh.setColumns(10);
			txt_HienThiNgaySinh.setBounds(206, 184, 294, 25);
			panel_LyLich.add(txt_HienThiNgaySinh);
			JLabel lbl_LyLich = new JLabel("Lý lịch công nhân");
			lbl_LyLich.setBounds(49, 10, 430, 24);
			panel_LyLich.add(lbl_LyLich);
			lbl_LyLich.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			RoundPanel panel_TT_Khac = new RoundPanel();
			panel_TT_Khac.setBackground(new Color(255, 255, 255));
			panel_TT_Khac.setRound(20);
			panel_TT_Khac.setBounds(735, 10, 495, 280);
			panel_ChiTietCN.add(panel_TT_Khac);
			panel_TT_Khac.setLayout(null);
			
			
			
			
			RoundPanel panelLblTTKhac = new RoundPanel();
			panelLblTTKhac.setRound(20);
			panelLblTTKhac.setLayout(new BorderLayout(0, 0));
			JLabel lb_TT_Khac = new JLabel("Thông tin khác");
			panelLblTTKhac.add(lb_TT_Khac);
			panelLblTTKhac.setBounds(10, 10, 475, 24);
			panelLblTTKhac.setBackground(new Color(113, 184, 255));
			lb_TT_Khac.setHorizontalAlignment(SwingConstants.CENTER);
			lb_TT_Khac.setFont(new Font("Times New Roman", Font.BOLD, 20));
			panel_TT_Khac.add(panelLblTTKhac);
			
			txt_HienThiTayNghe = new JTextField();
			txt_HienThiTayNghe.setEditable(false);
			txt_HienThiTayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiTayNghe.setBackground(null);
			txt_HienThiTayNghe.setBorder(null);
			txt_HienThiTayNghe.setColumns(10);
			txt_HienThiTayNghe.setBounds(191, 244, 294, 25);
			panel_TT_Khac.add(txt_HienThiTayNghe);
			
			JLabel lbl_HienThiTayNghe = new JLabel("Tay nghề:");
			lbl_HienThiTayNghe.setForeground(new Color(0, 0, 128));
			lbl_HienThiTayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiTayNghe.setBounds(10, 244, 130, 25);
			panel_TT_Khac.add(lbl_HienThiTayNghe);
			
			JLabel lbl_HienThiPhanXuong = new JLabel("Phân xưởng:");
			lbl_HienThiPhanXuong.setForeground(new Color(0, 0, 128));
			lbl_HienThiPhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiPhanXuong.setBounds(10, 184, 130, 25);
			panel_TT_Khac.add(lbl_HienThiPhanXuong);
			
			txt_HienThiPX = new JTextField();
			txt_HienThiPX.setEditable(false);
			txt_HienThiPX.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiPX.setBackground(null);
			txt_HienThiPX.setBorder(null);
			txt_HienThiPX.setColumns(10);
			txt_HienThiPX.setBounds(191, 184, 294, 25);
			panel_TT_Khac.add(txt_HienThiPX);
			
			txt_HienThiSDT = new JTextField();
			txt_HienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiSDT.setBackground(null);
			txt_HienThiSDT.setBorder(null);
			txt_HienThiSDT.setEditable(false);
			txt_HienThiSDT.setColumns(10);
			txt_HienThiSDT.setBounds(191, 124, 294, 25);
			panel_TT_Khac.add(txt_HienThiSDT);
			
			JLabel lbl_HienThiSDT = new JLabel("Số điện thoại:");
			lbl_HienThiSDT.setForeground(new Color(0, 0, 128));
			lbl_HienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiSDT.setBounds(10, 124, 130, 25);
			panel_TT_Khac.add(lbl_HienThiSDT);
			
			JLabel lbl_HienThiEmail = new JLabel("Email:");
			lbl_HienThiEmail.setForeground(new Color(0, 0, 128));
			lbl_HienThiEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HienThiEmail.setBounds(10, 64, 130, 25);
			panel_TT_Khac.add(lbl_HienThiEmail);
			
			txt_HienThiEmail = new JTextField();
			txt_HienThiEmail.setEditable(false);
			txt_HienThiEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiEmail.setBackground(null);
			txt_HienThiEmail.setBorder(null);
			txt_HienThiEmail.setColumns(10);
			txt_HienThiEmail.setBounds(191, 64, 294, 25);
			panel_TT_Khac.add(txt_HienThiEmail);
			
			JLabel lb_ID = new JLabel("ID:");
			lb_ID.setForeground(new Color(0, 0, 128));
			lb_ID.setBounds(10, 228, 89, 20);
			lb_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			panel_Avt.add(lb_ID);
			
			txt_HienThiID = new JTextField();
			txt_HienThiID.setEditable(false);
			txt_HienThiID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiID.setBorder(null);
			txt_HienThiID.setBackground(null);
			txt_HienThiID.setBounds(109, 228, 86, 20);
			panel_Avt.add(txt_HienThiID);
			txt_HienThiID.setColumns(10);
			
			JLabel lb_TrangThai = new JLabel("Trạng thái:");
			lb_TrangThai.setForeground(new Color(0, 0, 128));
			lb_TrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lb_TrangThai.setBounds(10, 258, 89, 20);
			panel_Avt.add(lb_TrangThai);
			
			txt_HienThiTrangThai = new JTextField();
			txt_HienThiTrangThai.setEditable(false);
			txt_HienThiTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_HienThiTrangThai.setBorder(null);
			txt_HienThiTrangThai.setBackground(null);
			txt_HienThiTrangThai.setColumns(10);
			txt_HienThiTrangThai.setBounds(109, 258, 86, 20);
			panel_Avt.add(txt_HienThiTrangThai);
			
			btnthem = new JButton("Thêm công nhân");
			btnthem.setBounds(33, 26, 141, 35);
			btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
			panel_CongNhan.add(btnthem);
			
			btnCapNhat = new JButton("Cập nhật\r\n");
			btnCapNhat.setBounds(206, 26, 141, 35);
			btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	
			setLayout(new BorderLayout(0, 0));
			panel_CongNhan.add(btnCapNhat);
			
			textTimKiem = new JTextField();
			textTimKiem.setBounds(823, 26, 245, 35);
			panel_CongNhan.add(textTimKiem);
			textTimKiem.setColumns(10);
			
			btnTimKiem = new JButton("Tìm kiếm");
			btnTimKiem.setBounds(1070, 26, 127, 35);
			btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			panel_CongNhan.add(btnTimKiem);
			this.add(panel_CongNhan);
			btnthem.addActionListener(this);
			btnCapNhat.addActionListener(this);
			btnTimKiem.addActionListener(this);
			tableCongNhan.addMouseListener(this);
			
			docDuLieuTuDataVaoTable();
			
	  }
	
	  private void giaoDienThemCapNhatCN() {
			setForeground(new Color(255, 255, 255));
			setPreferredSize(new Dimension(1259,780));
			setLayout(new BorderLayout(0, 0));

			panel_Them_SuaCongNhan = new RoundPanel();
			panel_Them_SuaCongNhan.setBackground(new Color(192, 192, 192));
			panel_Them_SuaCongNhan.setRound(50);
			panel_Them_SuaCongNhan.setLayout(null);
			
			RoundPanel panel_0 = new RoundPanel();
			panel_0.setSize(1230, 70);
			panel_0.setLocation(10, 10);
			panel_0.setBackground(new Color(168, 211, 255));
			panel_0.setRound(20);
			panel_0.setLayout(new BorderLayout(0, 0));
			
			lblChuCNang = new JLabel();
			lblChuCNang.setBackground(new Color(162, 208, 255));
			lblChuCNang.setForeground(new Color(0, 0, 0));
			lblChuCNang.setHorizontalAlignment(SwingConstants.CENTER);
			lblChuCNang.setFont(new Font("Times New Roman", Font.BOLD, 30));
			panel_0.add(lblChuCNang);
			
			RoundPanel panel_1 = new RoundPanel();
			panel_1.setSize(868, 560);
			panel_1.setLocation(10, 90);
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setRound(20);
			panel_1.setLayout(null);
			
			
			RoundPanel panel_2 = new RoundPanel();
			panel_2.setLocation(888, 90);
			panel_2.setSize(352, 560);
			panel_2.setBackground(new Color(255, 255, 255));
			panel_2.setRound(20);
			panel_2.setLayout(null);
			
			RoundPanel panel_3 = new RoundPanel();
			panel_3.setSize(1230, 110);
			panel_3.setLocation(10, 660);
			panel_3.setBackground(new Color(255, 255, 255));
			panel_3.setRound(20);
			panel_3.setLayout(null);
			
			panel_Them_SuaCongNhan.add(panel_3);
			panel_Them_SuaCongNhan.add(panel_2);
			panel_Them_SuaCongNhan.add(panel_1);
			panel_Them_SuaCongNhan.add(panel_0);

			JLabel lbl_NgayCongTac = new JLabel("Ngày công tác:");
			lbl_NgayCongTac.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgayCongTac.setBounds(440, 140, 150, 40);
			panel_1.add(lbl_NgayCongTac);
			
			JLabel lbl_HoTen = new JLabel("Họ và tên:");
			lbl_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HoTen.setBounds(20, 140, 110, 40);
			panel_1.add(lbl_HoTen);
			
			JLabel lbl_Phai = new JLabel("Phái:");
			lbl_Phai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_Phai.setBounds(20, 300, 110, 40);
			panel_1.add(lbl_Phai);
			
			JLabel lbl_Email = new JLabel("Email:");
			lbl_Email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_Email.setBounds(20, 380, 110, 40);
			panel_1.add(lbl_Email);
			
			JLabel lbl_SDT = new JLabel("Số điện thoại:");
			lbl_SDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_SDT.setBounds(20, 460, 110, 40);
			panel_1.add(lbl_SDT);
			
			txtHoTen = new JTextField();
			txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtHoTen.setColumns(10);
			txtHoTen.setBounds(148, 140, 221, 40);
			panel_1.add(txtHoTen);
			
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtEmail.setColumns(10);
			txtEmail.setBounds(148, 380, 221, 40);
			panel_1.add(txtEmail);
			
			txtSDT = new JTextField();
			txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtSDT.setColumns(10);
			txtSDT.setBounds(148, 460, 221, 40);
			panel_1.add(txtSDT);
			
			JLabel lbl_NgaySinh = new JLabel("Ngày Sinh:");
			lbl_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgaySinh.setBounds(20, 220, 110, 40);
			panel_1.add(lbl_NgaySinh);
			dateChooser_NgaySinh = new JDateChooser();
			dateChooser_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_NgaySinh.setSize(221, 40);
			dateChooser_NgaySinh.setLocation(148, 220);
	        dateChooser_NgaySinh.setDateFormatString("dd/MM/yyyy"); // Đặt định dạng ngày
	        panel_1.add(dateChooser_NgaySinh);
			
			JLabel lbl_PhanXuong = new JLabel("Phân xưởng:");
			lbl_PhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_PhanXuong.setBounds(438, 220, 150, 40);
			panel_1.add(lbl_PhanXuong);
			
			lbl_NgayKetThucCT = new JLabel("Ngày kết thúc:");
			lbl_NgayKetThucCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgayKetThucCT.setBounds(438, 380, 150, 40);
			lbl_NgayKetThucCT.setVisible(false);
			panel_1.add(lbl_NgayKetThucCT);
			ButtonGroup group = new ButtonGroup();
			rdNam = new JRadioButton("Nam");
			rdNam.setBackground(null);
			rdNam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rdNam.setBounds(144, 300, 100, 40);
			rdNam.setSelected(true);
			panel_1.add(rdNam);
		    
			rdNu = new JRadioButton("Nữ");
			rdNu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rdNu.setBounds(294, 300, 100, 40);
			rdNu.setBackground(null);
			panel_1.add(rdNu);
			group.add(rdNam);
			
			group.add(rdNu);
			dateChooser_ngayKTCT = new JDateChooser();
			dateChooser_ngayKTCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_ngayKTCT.setDateFormatString("dd/MM/yyyy");
			dateChooser_ngayKTCT.setBounds(625, 380, 219, 40);
			dateChooser_ngayKTCT.setVisible(false);
			panel_1.add(dateChooser_ngayKTCT);
			
			cb_PhanXuong = new JComboBox<String>();
			cb_PhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cb_PhanXuong.setBounds(625, 220, 221, 40);
			panel_1.add(cb_PhanXuong);
			px_bus = new PhanXuong_BUS();
			ArrayList<PhanXuong> list = px_bus.getdsPX();
			for (PhanXuong px : list) {
				cb_PhanXuong.addItem(px.getTenPhanXuong());
			}
		
			

	        avatarImage = new JLabel();
	        avatarImage.setBounds(26, 35, 300, 400);
	        panel_2.add(avatarImage);

	

	        int labelWidth = avatarImage.getWidth();
            int labelHeight = avatarImage.getHeight();

            ImageIcon avatarIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
			// Chỉnh kích thước ảnh theo JLabel
            Image avatar = avatarIcon .getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            avatarIcon = new ImageIcon(avatar);
            avatarImage.setIcon(avatarIcon);
			
			btnChonAnh = new JButton("Chọn ảnh");
			btnChonAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnChonAnh.setBounds(106, 475, 150, 40);
			panel_2.add(btnChonAnh);
			
			btnThemCongNhan = new JButton("Thêm");
			btnThemCongNhan.setBackground(new Color(0, 255, 0));
			btnThemCongNhan.setForeground(new Color(0, 0, 0));
			btnThemCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnThemCongNhan.setBounds(400, 30, 150, 60);
			panel_3.add(btnThemCongNhan);
			
			btnHuyThem = new JButton("Hủy");
			btnHuyThem.setForeground(Color.BLACK);
			btnHuyThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnHuyThem.setBackground(new Color(255, 0, 0));
			btnHuyThem.setBounds(813, 30, 150, 60);
			panel_3.add(btnHuyThem);
			
			
			btnCapNhatCongNhan = new JButton("Cập nhật");
			btnCapNhatCongNhan.setForeground(Color.BLACK);
			btnCapNhatCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnCapNhatCongNhan.setBackground(Color.GREEN);
			btnCapNhatCongNhan.setBounds(400, 30, 150, 60);
			panel_3.add(btnCapNhatCongNhan);
			
			btnHuyThem.addActionListener(this);
			this.add(panel_Them_SuaCongNhan);
			
			
			
			lbl_CCCD = new JLabel("CCCD:");
			lbl_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_CCCD.setBounds(440, 60, 150, 40);
			panel_1.add(lbl_CCCD);
			
			txtCCCD = new JTextField();
			txtCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtCCCD.setColumns(10);
			txtCCCD.setBounds(627, 60, 219, 40);
			panel_1.add(txtCCCD);
			
			dateChooser_ngayCT = new JDateChooser();
			
			dateChooser_ngayCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			dateChooser_ngayCT.setDateFormatString("dd/MM/yyyy");
		
			dateChooser_ngayCT.setBounds(627, 140, 221, 40);
			panel_1.add(dateChooser_ngayCT);
			
			JLabel lbl_ID = new JLabel("ID:");
			lbl_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_ID.setBounds(20, 60, 110, 40);
			panel_1.add(lbl_ID);
			
			txtID = new JTextField();
			txtID.setEditable(false);
			txtID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtID.setColumns(10);
			txtID.enable(false);
			txtID.setBounds(148, 60, 221, 40);
			panel_1.add(txtID);
			
			JLabel lbl_tayNghe = new JLabel("Tay nghề:");
			lbl_tayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_tayNghe.setBounds(438, 300, 150, 40);
			panel_1.add(lbl_tayNghe);
			
			cb_TayNghe = new JComboBox<String>();
			cb_TayNghe.addItem("Giỏi");
			cb_TayNghe.addItem("Khá");
			cb_TayNghe.addItem("Trung bình");
			cb_TayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			cb_TayNghe.setBounds(625, 300, 219, 40);
			panel_1.add(cb_TayNghe);
			
			btnThemCongNhan.addActionListener(this);
			btnChonAnh.addActionListener(this);
			btnCapNhatCongNhan.addActionListener(this);
		
			
		}



	  private void docDuLieuTuDataVaoTable() {
		  	
		  	
			ArrayList<CongNhan> list = cn_bus.getDanhSachCongNhan();
			for (CongNhan cn : list) {
				model.addRow(new Object[] {
						cn.getIdCongNhan(),
						cn.getHoTen(),
						cn.isPhai()?"Nam":"Nữ",
								cn.getNgaySinh(),
						cn.getNgayBatDauCongTac(),
						px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong()).getTenPhanXuong(),
						cn.getTayNghe(),
						cn.getEmail(),
						cn.getSoDienThoai(),
						cn.getcCCD(),
						(cn.getNgayKetThucCongTac()==null)?"Còn Làm":"Nghỉ làm"	
						
				});
				
			}
			
		}
	  private void hienThiPanelCapNhat(String maCN) {
		  	panel_CongNhan.setVisible(false);
			giaoDienThemCapNhatCN();
			lblChuCNang.setText("CẬP NHẬT CÔNG NHÂN");
			lbl_NgayKetThucCT.setVisible(true);
			dateChooser_ngayKTCT.setVisible(true);
			btnThemCongNhan.setVisible(false);
			btnCapNhatCongNhan.setVisible(true);
			CongNhan cn = cn_bus.getCongNhanTheoID(maCN);
			

			
			txtID.setText(cn.getIdCongNhan());
			selectedDate = java.sql.Date.valueOf(cn.getNgaySinh());
			dateChooser_NgaySinh.setDate(selectedDate);
			selectedDate = java.sql.Date.valueOf(cn.getNgayBatDauCongTac());
			dateChooser_ngayCT.setDate(selectedDate);
			if(cn.getNgayKetThucCongTac()!=null) {
				selectedDate = java.sql.Date.valueOf(cn.getNgayKetThucCongTac());
				dateChooser_ngayKTCT.setDate(selectedDate);
			}
			else {
				dateChooser_ngayKTCT.setDate(null);
			}
			
			txtHoTen.setText(cn.getHoTen());
			txtCCCD.setText(cn.getcCCD());
			txtEmail.setText(cn.getEmail());
			txtSDT.setText(cn.getSoDienThoai());
			if(cn.isPhai()) {
				rdNam.setSelected(true);
			}
			else {
				rdNu.setSelected(true);
			}
			cb_TayNghe.setSelectedItem(cn.getTayNghe());
			cb_PhanXuong.setSelectedItem(px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong()).getTenPhanXuong());
	        
			ImageIcon hienThiImageIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
			if(cn.getAnhDaiDien()!=null) {
				hienThiImageIcon = new ImageIcon("src\\images\\"+cn.getAnhDaiDien());
			}
	
        	// Lấy kích thước mới của JLabel
            int labelWidth = avatarImage.getWidth();
            int labelHeight = avatarImage.getHeight();

            // Chỉnh kích thước ảnh theo JLabel
            Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            hienThiImageIcon = new ImageIcon(themAnh);
            avatarImage.setIcon(hienThiImageIcon);

	  }
	  private void hienThiThongTinCN(CongNhan cn) {
			txt_HienThiID.setText(cn.getIdCongNhan());
			txt_HienThiTrangThai.setText((cn.getNgayKetThucCongTac()==null)?"Còn làm":"NghĨ làm");
			txt_HienThiHoTen.setText(cn.getHoTen());
			txt_HienThiNgaySinh.setText(cn.getNgaySinh().toString());
			txt_HienThiPhai.setText((cn.isPhai()==true)?"Nam":"Nữ");
			txt_HienThiCCCD.setText(cn.getcCCD());
			txt_HienThiSDT.setText(cn.getSoDienThoai());
			txt_HienThiEmail.setText(cn.getEmail());
			txt_HienThiPX.setText(px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong()).getTenPhanXuong());
			txt_HienThiTayNghe.setText(cn.getTayNghe());
		
			ImageIcon hienThiImageIcon = new ImageIcon("src\\images\\Unknown_person.jpg");
			if(cn.getAnhDaiDien()!=null) {
				hienThiImageIcon = new ImageIcon("src\\images\\"+cn.getAnhDaiDien());
			}
		
        	// Lấy kích thước mới của JLabel
            int labelWidth = hienThiAvatar.getWidth();
            int labelHeight = hienThiAvatar.getHeight();

            // Chỉnh kích thước ảnh theo JLabel
            Image themAnh = hienThiImageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        	hienThiImageIcon = new ImageIcon(themAnh);
            hienThiAvatar.setIcon(hienThiImageIcon);
	  }
	  private void hienThiGDThem() {
		  	panel_CongNhan.setVisible(false);
		  	
			giaoDienThemCapNhatCN();
			
			lblChuCNang.setText("THÊM CÔNG NHÂN");
			txtID.setText(sinhMaCN());
			
			btnThemCongNhan.setVisible(true);
			btnCapNhatCongNhan.setVisible(false);
	  }
	  private CongNhan layTTCNTuTextField() {
		  String maCN = txtID.getText();
		  String tenCN = txtHoTen.getText();
		  
		  Date nsDate = dateChooser_NgaySinh.getDate();

		  int yearNS = nsDate.getYear()+1900;		  
		  int monthNS = nsDate.getMonth()+1;		
		  int dayNS = nsDate.getDate();
		  LocalDate ns = LocalDate.of(yearNS, monthNS, dayNS);
	      
		  Date ctDate = dateChooser_ngayCT.getDate();
		  int yearCT = ctDate.getYear()+1900;
		  int monthCT = ctDate.getMonth()+1;
		  int dayCT = ctDate.getDate();
		  LocalDate ct = LocalDate.of(yearCT, monthCT, dayCT);
		  
		  LocalDate ktct=null;
		  if(dateChooser_ngayKTCT.getDate()!=null) {
			  Date ktctDate = dateChooser_ngayKTCT.getDate();
			  int yearKTCT = ktctDate.getYear()+1900;
			  int monthKTCT = ktctDate.getMonth()+1;
			  int dayKTCT = ktctDate.getDate();
			  ktct = LocalDate.of(yearKTCT, monthKTCT, dayKTCT);
		  }
		  
		  String tenPX = cb_PhanXuong.getSelectedItem().toString();
		  PhanXuong px = px_bus.getPXtheoTen(tenPX);
		  boolean phai = rdNam.isSelected();
		  String email = txtEmail.getText();
		  String sdt =  txtSDT.getText();
		  String cccd = txtCCCD.getText();
		  String tayNghe = cb_TayNghe.getSelectedItem().toString();
		  String avatar = null;
		  if(url != null) {
			  File absoluteFile = new File(url);
			  avatar = absoluteFile.getName();

		  }
		  CongNhan cn = new CongNhan(maCN, tenCN, phai, ns, ct, ktct, px, email, sdt, tayNghe, null, avatar, cccd);
		  return cn;
	  }
	  
		private String sinhMaCN() {
			int stt = 1;
			ArrayList<CongNhan>  list= cn_bus.getDanhSachCongNhan();
			String id="CN" + String.format("%04d",  stt);
			for (CongNhan cn : list) {
				if(cn.getIdCongNhan().equals(id)) {
					stt++;
					id="CN" + String.format("%04d",  stt);
				}
			}
			return id;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub'
			Object o = e.getSource();
			if(o.equals(btnthem)){
				hienThiGDThem();
				
				
			}
			if(o.equals(btnThemCongNhan)) {
				
				CongNhan cn = layTTCNTuTextField();
			 	cn_bus.create(cn);
				panel_Them_SuaCongNhan.setVisible(false);
				int m = cn_bus.getDanhSachCongNhan().indexOf(cn);
				giaoDienCN();
				tableCongNhan.setRowSelectionInterval(m, m);
				tableCongNhan.scrollRectToVisible(tableCongNhan.getCellRect(m, m, true));
				hienThiThongTinCN(cn);
			}

			if(o.equals(btnHuyThem)){
				int n = tableCongNhan.getSelectedRow();
				panel_Them_SuaCongNhan.setVisible(false);
				if (n!=-1) {
		
					String maCN = tableCongNhan.getValueAt(n, 0).toString();
//					CongNhan cn = cn_bus.getCN(maCN);
//					int m = cn_bus.getdsCN().indexOf(cn);
					giaoDienCN();
//					tableCongNhan.setRowSelectionInterval(m, m);
//					tableCongNhan.scrollRectToVisible(tableCongNhan.getCellRect(m, m, true));
//					hienThiThongTinCN(cn);	
				}
				else {
					giaoDienCN();
				}
			}
			if(o.equals(btnTimKiem)) {
				String ma = textTimKiem.getText();
				CongNhan cn = cn_bus.getCongNhanTheoID(ma);
				model.setRowCount(0);
				model.addRow(new Object[] {
						ma,
						cn.getHoTen(),
						cn.isPhai()?"Nam":"Nữ",
						cn.getNgaySinh(),
						px_bus.getdsPXtheoID(cn.getPhanXuong().getIdPhanXuong()).getTenPhanXuong(),
						cn.getTayNghe(),
						cn.getEmail(),
						cn.getSoDienThoai(),
						cn.getcCCD(),
						(cn.getNgayKetThucCongTac()==null)?"Còn Làm":"Nghỉ làm"	
						
				});
				tableCongNhan.setRowSelectionInterval(0, 0);
				hienThiThongTinCN(cn);
			}
			if(o.equals(btnCapNhat)) {
				int r = tableCongNhan.getSelectedRow();
				if(r == -1) {
					
					JOptionPane.showMessageDialog(null, "Chọn 1 công nhân để cập nhật!");
			    }
				else {
					String maCN = tableCongNhan.getValueAt(r, 0).toString();
					hienThiPanelCapNhat(maCN);
				}
			}
			if(o.equals(btnCapNhatCongNhan)) {
				CongNhan cn_new = layTTCNTuTextField();
				cn_bus.update(cn_new);
				panel_Them_SuaCongNhan.setVisible(false);
				String maCN = cn_new.getIdCongNhan();
				CongNhan cn2 = cn_bus.getCongNhanTheoID(maCN);
				int m = cn_bus.getDanhSachCongNhan().indexOf(cn2);
				giaoDienCN();
				tableCongNhan.setRowSelectionInterval(m, m);
				tableCongNhan.scrollRectToVisible(tableCongNhan.getCellRect(m, m, true));
				hienThiThongTinCN(cn2);
			}
			if(o.equals(btnChonAnh)) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chọn ảnh");
	            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

	            int result = fileChooser.showOpenDialog(null);

	            if (result == JFileChooser.APPROVE_OPTION) {
	                // Đoạn mã xử lý khi người dùng chọn tệp ảnh ở đây
	            	url = fileChooser.getSelectedFile().getAbsolutePath();
	            	ImageIcon avatarIcon = new ImageIcon(url);
	            	
	            	// Lấy kích thước mới của JLabel
	                int labelWidth = avatarImage.getWidth();
	                int labelHeight = avatarImage.getHeight();

	                // Chỉnh kích thước ảnh theo JLabel
	                Image avatar = avatarIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
	                avatarIcon = new ImageIcon(avatar);
	                
	                avatarImage.setIcon(avatarIcon);
		       
			}
	        	
	      }
			
				
		}
		@Override
		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
			
			int n = tableCongNhan.getSelectedRow();
			String maCN = tableCongNhan.getValueAt(n, 0).toString();
			CongNhan cn = cn_bus.getCongNhanTheoID(maCN);
			hienThiThongTinCN(cn);
			
			
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
}
