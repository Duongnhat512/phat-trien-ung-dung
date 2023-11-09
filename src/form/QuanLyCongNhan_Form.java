package form;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import connectDB.ConnectDB;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Container;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
import bus.CongNhan_BUS;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

/**
 * 
 * @author Nguyễn Gia Bảo, Ngô Quốc Đạt, Nguyễn Nhất Dương, Võ Văn Nghĩa Hiệp
 * @version 1.0
 *
 */

public class QuanLyCongNhan_Form extends JPanel implements ActionListener, MouseListener{

	private JTable table;
	private DefaultTableModel model;

	private JTextField textTimKiem;
	private JTextField txt_HienThiID;
	private JTextField txt_HienThiHoTen;
	private JTextField txt_HienThiPhai;
	private JTextField txt_HienThiCCCD;
	private JTextField txt_HienThiNgaySinh;
	private JTextField txt_HienThiPhanXuong;
	private JTextField txt_HienThiTayNghe;
	private JTextField txt_HienThiEmail;
	private JTextField txt_HienThiTrangThai;
	private  int width = 1259;
	private  int height = 813;
	private JButton btnChonAnh;
	private Container panel_Them_SuaCongNhan;
	private JButton btnThemCongNhan;
	private JButton btnHuyThem;
	private JButton btnCapNhatCongNhan;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JDateChooser dateChooser_NgaySinh;
	private JRadioButton rbtn_Nam;
	private Container rbtnNu;
	private JDateChooser dateChooser_ngayKTCT;
	private ImageIcon themAvatar;
	private JButton btnthem;
	private JButton btnCapNhat;
	private JPanel panel_CongNhan;
	private JLabel lbl_CCCD;
	private JTextField txt_CCCD;
	private CongNhan_BUS CN_bus;
	private JTextField txt_ID;
	private JComboBox cb_PhanXuong;
	private JPanel panel_ChiTietCN;
	private JPanel panel_bangTTCN;
	private JScrollPane scrollPane;
	private JTextField txt_hienThiSDT;
	private JTextField txt_hienThiNgayCT;
	private ImageIcon defaultAvatar;



	
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
		  	setPreferredSize(new Dimension(1259,813));
			
		  	try {
				ConnectDB.getInstance().connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Panel danh sách cong nhan
			
			panel_CongNhan = new JPanel();
			panel_CongNhan.setBounds(0, 0, 1259,813);
			panel_CongNhan.setLayout(null);
			
			panel_bangTTCN = new JPanel();
			panel_bangTTCN.setBackground(new Color(255, 255, 255));
			panel_bangTTCN.setBounds(10, 78, 1230, 404);
			panel_CongNhan.add(panel_bangTTCN);
			panel_bangTTCN.setLayout(null);
			
			JLabel tieuDe = new JLabel("Bảng thông tin công nhân");
			tieuDe.setOpaque(true);
			tieuDe.setBackground(Color.CYAN);
			tieuDe.setHorizontalAlignment(SwingConstants.CENTER);
			tieuDe.setFont(new Font("Times New Roman", Font.BOLD, 20));
			tieuDe.setBounds(10, 10, 1210, 30);
			panel_bangTTCN.add(tieuDe);
			String[] headers = {"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00E1i", "Ng\u00E0y sinh", "Ph\u00F2ng ban", "Ch\u1EE9c v\u1EE5", "Email", "S\u0110T", "CCCD", "Tr\u1EA1ng th\u00E1i"};
			model = new DefaultTableModel(headers , 0);
		
			
			scrollPane = new JScrollPane(table = new JTable(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "H\u1ECD v\u00E0 t\u00EAn", "Ph\u00E1i", "Ng\u00E0y sinh", "Ng\u00E0y c\u00F4ng t\u00E1c", "Ph\u00E2n x\u01B0\u1EDFng", "Tay ngh\u1EC1", "Email", "S\u0110T", "CCCD", "Tr\u1EA1ng th\u00E1i"
				}
			)));

			scrollPane.setBounds(10, 40, 1210, 353);
			panel_bangTTCN.add(scrollPane);
			scrollPane.setViewportView(table);
			
			
			
			
			//Panel chi tiet thong tin 1 cong nhan
		    panel_ChiTietCN = new JPanel();
		    panel_ChiTietCN.setVisible(false);
			panel_ChiTietCN.setBackground(new Color(255, 255, 255));
			panel_ChiTietCN.setBounds(10, 492, 1230, 300);
			panel_CongNhan.add(panel_ChiTietCN);
			panel_ChiTietCN.setLayout(null);
			
			JPanel panel_Avt = new JPanel();
			panel_Avt.setBounds(10, 10, 250, 214);
			panel_ChiTietCN.add(panel_Avt);
			
			defaultAvatar = new ImageIcon(""); 
	        panel_Avt.setLayout(null);

	        JLabel avatarImage = new JLabel(defaultAvatar);
	        avatarImage.setBounds(0, 0, 250, 214);
	        panel_Avt.add(avatarImage);
			
			JPanel panel_LyLich = new JPanel();
			panel_LyLich.setBounds(292, 10, 450, 275);
			panel_ChiTietCN.add(panel_LyLich);
			panel_LyLich.setLayout(null);
			
			JLabel lbl_LyLich = new JLabel("Lý lịch công nhân");
			lbl_LyLich.setOpaque(true); // Đặt `opaque` thành true để cho phép sử dụng màu nền
			lbl_LyLich.setBackground(Color.CYAN);
			lbl_LyLich.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lbl_LyLich.setBounds(10, 10, 430, 24);
			panel_LyLich.add(lbl_LyLich);
		
			JLabel lbl_hienThiHoTen = new JLabel("Họ và tên:");
			lbl_hienThiHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_hienThiHoTen.setBounds(10, 64, 102, 20);
			panel_LyLich.add(lbl_hienThiHoTen);
			
			JLabel lbl_hienThiCCCD = new JLabel("CCCD:");
			lbl_hienThiCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_hienThiCCCD.setBounds(10, 244, 102, 20);
			panel_LyLich.add(lbl_hienThiCCCD);
			
			JLabel lbl_hienThiPhai = new JLabel("Phái:");
			lbl_hienThiPhai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_hienThiPhai.setBounds(10, 124, 102, 20);
			panel_LyLich.add(lbl_hienThiPhai);
			
			JLabel lbl_hienThiNgaySinh = new JLabel("Ngày sinh:");
			lbl_hienThiNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_hienThiNgaySinh.setBounds(10, 184, 102, 20);
			panel_LyLich.add(lbl_hienThiNgaySinh);
			
			txt_HienThiHoTen = new JTextField();
			txt_HienThiHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_HienThiHoTen.setEditable(false);
			txt_HienThiHoTen.setBackground(null);
			txt_HienThiHoTen.setBorder(null);
			txt_HienThiHoTen.setBounds(142, 64, 298, 20);
			panel_LyLich.add(txt_HienThiHoTen);
			txt_HienThiHoTen.setColumns(10);
			
			txt_HienThiPhai = new JTextField();
			txt_HienThiPhai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_HienThiPhai.setBackground(null);
			txt_HienThiPhai.setBorder(null);
			txt_HienThiPhai.setEditable(false);
			txt_HienThiPhai.setColumns(10);
			txt_HienThiPhai.setBounds(142, 124, 298, 20);
			panel_LyLich.add(txt_HienThiPhai);
			
			txt_HienThiCCCD = new JTextField();
			txt_HienThiCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_HienThiCCCD.setBackground(null);
			txt_HienThiCCCD.setBorder(null);
			txt_HienThiCCCD.setEditable(false);
			txt_HienThiCCCD.setColumns(10);
			txt_HienThiCCCD.setBounds(142, 244, 298, 20);
			panel_LyLich.add(txt_HienThiCCCD);
			
			txt_HienThiNgaySinh = new JTextField();
			txt_HienThiNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_HienThiNgaySinh.setBackground(null);
			txt_HienThiNgaySinh.setBorder(null);
			txt_HienThiNgaySinh.setEditable(false);
			txt_HienThiNgaySinh.setColumns(10);
			txt_HienThiNgaySinh.setBounds(142, 184, 298, 20);
			panel_LyLich.add(txt_HienThiNgaySinh);
			
			JPanel panel_TT_Khac = new JPanel();
			panel_TT_Khac.setBounds(770, 10, 450, 275);
			panel_ChiTietCN.add(panel_TT_Khac);
			panel_TT_Khac.setLayout(null);
			
			JLabel lb_TT_Khac = new JLabel("Thông tin khác");
			lb_TT_Khac.setBounds(10, 10, 430, 24);
			lb_TT_Khac.setOpaque(true);
			lb_TT_Khac.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lb_TT_Khac.setBackground(Color.CYAN);
			panel_TT_Khac.add(lb_TT_Khac);
			
			JLabel lbl_PhanXuong = new JLabel("Phân xưởng:");
			lbl_PhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_PhanXuong.setBounds(10, 244, 102, 20);
			panel_TT_Khac.add(lbl_PhanXuong);
			
			txt_HienThiPhanXuong = new JTextField();
			txt_HienThiPhanXuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_HienThiPhanXuong.setBackground(null);
			txt_HienThiPhanXuong.setBorder(null);
			txt_HienThiPhanXuong.setEditable(false);
			txt_HienThiPhanXuong.setColumns(10);
			txt_HienThiPhanXuong.setBounds(142, 244, 298, 20);
			panel_TT_Khac.add(txt_HienThiPhanXuong);
			
			txt_HienThiTayNghe = new JTextField();
			txt_HienThiTayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_HienThiTayNghe.setBackground(null);
			txt_HienThiTayNghe.setBorder(null);
			txt_HienThiTayNghe.setEditable(false);
			txt_HienThiTayNghe.setColumns(10);
			txt_HienThiTayNghe.setBounds(142, 184, 298, 20);
			panel_TT_Khac.add(txt_HienThiTayNghe);
			
			JLabel lbl_thiThiTayNghe = new JLabel("Tay nghề:");
			lbl_thiThiTayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_thiThiTayNghe.setBounds(10, 184, 102, 20);
			panel_TT_Khac.add(lbl_thiThiTayNghe);
			
			JLabel lbl_hienThiEmail = new JLabel("Email:");
			lbl_hienThiEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_hienThiEmail.setBounds(10, 64, 102, 20);
			panel_TT_Khac.add(lbl_hienThiEmail);
			
			txt_HienThiEmail = new JTextField();
			txt_HienThiEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_HienThiEmail.setBackground(null);
			txt_HienThiEmail.setBorder(null);
			txt_HienThiEmail.setEditable(false);
			txt_HienThiEmail.setColumns(10);
			txt_HienThiEmail.setBounds(142, 64, 298, 20);
			panel_TT_Khac.add(txt_HienThiEmail);
			
			JLabel lbl_hienThiSDT = new JLabel("Số điện thoại:");
			lbl_hienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lbl_hienThiSDT.setBounds(10, 124, 102, 20);
			panel_TT_Khac.add(lbl_hienThiSDT);
			
			txt_hienThiSDT = new JTextField();
			txt_hienThiSDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_hienThiSDT.setEditable(false);
			txt_hienThiSDT.setColumns(10);
			txt_hienThiSDT.setBorder(null);
			txt_hienThiSDT.setBackground((Color) null);
			txt_hienThiSDT.setBounds(142, 124, 298, 20);
			panel_TT_Khac.add(txt_hienThiSDT);
			
			JLabel lb_hienThiID = new JLabel("ID:");
			lb_hienThiID.setBounds(10, 230, 97, 15);
			lb_hienThiID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			panel_ChiTietCN.add(lb_hienThiID);
			
			txt_HienThiID = new JTextField();
			txt_HienThiID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txt_HienThiID.setEditable(false);
			txt_HienThiID.setBorder(null);
			txt_HienThiID.setBackground(null);
			txt_HienThiID.setBounds(117, 230, 143, 15);
			panel_ChiTietCN.add(txt_HienThiID);
			txt_HienThiID.setColumns(10);
			
			JLabel lb_hienThiTrangThai = new JLabel("Trạng thái:");
			lb_hienThiTrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lb_hienThiTrangThai.setBounds(10, 270, 97, 20);
			panel_ChiTietCN.add(lb_hienThiTrangThai);
			
			txt_HienThiTrangThai = new JTextField();
			txt_HienThiTrangThai.setEditable(false);
			txt_HienThiTrangThai.setBorder(null);
			txt_HienThiTrangThai.setBackground(null);
			txt_HienThiTrangThai.setColumns(10);
			txt_HienThiTrangThai.setBounds(116, 270, 144, 15);
			panel_ChiTietCN.add(txt_HienThiTrangThai);
			
			JLabel lb_hienThiNgayCT = new JLabel("Ngày công tác:");
			lb_hienThiNgayCT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lb_hienThiNgayCT.setBounds(10, 250, 97, 15);
			panel_ChiTietCN.add(lb_hienThiNgayCT);
			
			txt_hienThiNgayCT = new JTextField();
			txt_hienThiNgayCT.setEditable(false);
			txt_hienThiNgayCT.setColumns(10);
			txt_hienThiNgayCT.setBorder(null);
			txt_hienThiNgayCT.setBackground((Color) null);
			txt_hienThiNgayCT.setBounds(116, 250, 144, 15);
			panel_ChiTietCN.add(txt_hienThiNgayCT);
			
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
			
			JButton btnTimKiem = new JButton("Tìm kiếm");
			btnTimKiem.setBounds(1070, 26, 127, 35);
			btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			panel_CongNhan.add(btnTimKiem);
			this.add(panel_CongNhan);
			btnthem.addActionListener(this);
			btnCapNhat.addActionListener(this);
			
			table.addMouseListener(this);

			docDuLieuTuDataVaoTable();
			
	  }
	
	  private void giaoDienThemCapNhatCN() {
			setForeground(new Color(255, 255, 255));
			setPreferredSize(new Dimension(1259,813));
			setLayout(new BorderLayout(0, 0));

			panel_Them_SuaCongNhan = new JPanel();
			panel_Them_SuaCongNhan.setForeground(new Color(255, 255, 255));

			
		
			panel_Them_SuaCongNhan.setLayout(null);
			
			JLabel lbl_NgayCongTac = new JLabel("Ngày công tác:");
			lbl_NgayCongTac.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgayCongTac.setBounds(450, 50, 150, 40);
			panel_Them_SuaCongNhan.add(lbl_NgayCongTac);
			
			JLabel lbl_HoTen = new JLabel("Họ và tên:");
			lbl_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_HoTen.setBounds(30, 140, 110, 40);
			panel_Them_SuaCongNhan.add(lbl_HoTen);
			
			JLabel lbl_Phai = new JLabel("Phái:");
			lbl_Phai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_Phai.setBounds(30, 320, 110, 40);
			panel_Them_SuaCongNhan.add(lbl_Phai);
			
			JLabel lbl_Email = new JLabel("Email:");
			lbl_Email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_Email.setBounds(450, 230, 150, 40);
			panel_Them_SuaCongNhan.add(lbl_Email);
			
			JLabel lbl_SDT = new JLabel("Số điện thoại:");
			lbl_SDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_SDT.setBounds(30, 410, 110, 40);
			panel_Them_SuaCongNhan.add(lbl_SDT);
			
			txtHoTen = new JTextField();
			txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtHoTen.setColumns(10);
			txtHoTen.setBounds(150, 140, 250, 40);
			panel_Them_SuaCongNhan.add(txtHoTen);
			
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtEmail.setColumns(10);
			txtEmail.setBounds(610, 230, 250, 40);
			panel_Them_SuaCongNhan.add(txtEmail);
			
			txtSDT = new JTextField();
			txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtSDT.setColumns(10);
			txtSDT.setBounds(150, 410, 250, 40);
			panel_Them_SuaCongNhan.add(txtSDT);
			
			JLabel lbl_NgaySinh = new JLabel("Ngày Sinh:");
			lbl_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgaySinh.setBounds(30, 230, 110, 40);
			panel_Them_SuaCongNhan.add(lbl_NgaySinh);
			
			dateChooser_NgaySinh = new JDateChooser();
			dateChooser_NgaySinh.setSize(250, 40);
			dateChooser_NgaySinh.setLocation(150, 230);
	        dateChooser_NgaySinh.setDateFormatString("dd/MM/yyyy"); // Đặt định dạng ngày
	        panel_Them_SuaCongNhan.add(dateChooser_NgaySinh);
			
			JLabel lbl_TayNghe = new JLabel("Tay nghề:");
			lbl_TayNghe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_TayNghe.setBounds(450, 500, 150, 40);
			panel_Them_SuaCongNhan.add(lbl_TayNghe);
			
			JLabel lbl_NgayKetThucCT = new JLabel("Ngày kết thúc công tác:");
			lbl_NgayKetThucCT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_NgayKetThucCT.setBounds(450, 140, 189, 40);
			panel_Them_SuaCongNhan.add(lbl_NgayKetThucCT);
			
			rbtn_Nam = new JRadioButton("Nam");
			rbtn_Nam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rbtn_Nam.setBounds(150, 320, 100, 40);
			panel_Them_SuaCongNhan.add(rbtn_Nam);
			
			rbtnNu = new JRadioButton("Nữ");
			rbtnNu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			rbtnNu.setBounds(300, 320, 100, 40);
			panel_Them_SuaCongNhan.add(rbtnNu);
			
			dateChooser_ngayKTCT = new JDateChooser();
			dateChooser_ngayKTCT.setDateFormatString("dd/MM/yyyy");
			dateChooser_ngayKTCT.setBounds(639, 140, 221, 40);
			panel_Them_SuaCongNhan.add(dateChooser_ngayKTCT);
			
		
		
			
			
			themAvatar = new ImageIcon(""); 
	 

	        JLabel avatarImage = new JLabel(themAvatar);
	        avatarImage.setBounds(940, 150, 250, 214);
	        panel_Them_SuaCongNhan.add(avatarImage);

		
			
			btnChonAnh = new JButton("Chọn ảnh");
			btnChonAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnChonAnh.setBounds(996, 410, 120, 50);
			panel_Them_SuaCongNhan.add(btnChonAnh);
			
			btnThemCongNhan = new JButton("Thêm");
			btnThemCongNhan.setBackground(new Color(0, 255, 0));
			btnThemCongNhan.setForeground(new Color(0, 0, 0));
			btnThemCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnThemCongNhan.setBounds(811, 682, 141, 50);
			panel_Them_SuaCongNhan.add(btnThemCongNhan);
			
			btnHuyThem = new JButton("Hủy");
			btnHuyThem.setForeground(Color.BLACK);
			btnHuyThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnHuyThem.setBackground(new Color(255, 0, 0));
			btnHuyThem.setBounds(1049, 682, 141, 50);
			panel_Them_SuaCongNhan.add(btnHuyThem);
			
			
			btnCapNhatCongNhan = new JButton("Cập nhật");
			btnCapNhatCongNhan.setForeground(Color.BLACK);
			btnCapNhatCongNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnCapNhatCongNhan.setBackground(Color.GREEN);
			btnCapNhatCongNhan.setBounds(811, 682, 141, 50);
			panel_Them_SuaCongNhan.add(btnCapNhatCongNhan);
			
			btnHuyThem.addActionListener(this);
			this.add(panel_Them_SuaCongNhan);
			
			lbl_CCCD = new JLabel("CCCD:");
			lbl_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_CCCD.setBounds(30, 500, 110, 40);
			panel_Them_SuaCongNhan.add(lbl_CCCD);
			
			txt_CCCD = new JTextField();
			txt_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_CCCD.setColumns(10);
			txt_CCCD.setBounds(150, 500, 250, 40);
			panel_Them_SuaCongNhan.add(txt_CCCD);
			
			JDateChooser dateChooser_ngayCT = new JDateChooser();
			dateChooser_ngayCT.setDateFormatString("dd/MM/yyyy");
			dateChooser_ngayCT.setBounds(610, 50, 250, 40);
			panel_Them_SuaCongNhan.add(dateChooser_ngayCT);
			
			JLabel lbl_ID = new JLabel("ID:");
			lbl_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_ID.setBounds(30, 50, 110, 40);
			panel_Them_SuaCongNhan.add(lbl_ID);
			
			txt_ID = new JTextField();
			txt_ID.setEditable(false);
			txt_ID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txt_ID.setColumns(10);
			txt_ID.setBounds(150, 50, 250, 40);
			panel_Them_SuaCongNhan.add(txt_ID);
			
			JLabel lbl_ChucVu = new JLabel("Phân xưởng:");
			lbl_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			lbl_ChucVu.setBounds(450, 410, 150, 40);
			panel_Them_SuaCongNhan.add(lbl_ChucVu);
			
			cb_PhanXuong = new JComboBox();
			cb_PhanXuong.setBounds(610, 410, 250, 40);
			panel_Them_SuaCongNhan.add(cb_PhanXuong);
			
			JComboBox cb_TayNghe = new JComboBox();
			cb_TayNghe.setBounds(610, 500, 250, 40);
			panel_Them_SuaCongNhan.add(cb_TayNghe);
			
	   
		}

	  private void docDuLieuTuDataVaoTable() {
//		  	CN_bus = new CongNhan_BUS();
//			ArrayList<CongNhan> list = CN_bus.getdsCN();
//			for (CongNhan CN : list) {
//				model.addRow(new Object[] {
//						CN.getIdCongNhan(),
//						CN.getHoTen(),
//						CN.isPhai()?"Nam":"Nữ",
//						CN.getNgaySinh(),
//						CN.getPhongBan().getIdPhongBan(),
//						CN.getChucVu().getIdChucVu(),
//						CN.getEmail(),
//						CN.getSoDienThoai(),
//						"8 triệu",
//						(CN.getNgayKetThucCongTac()==null)?"Còn Làm":"Nghỉ làm"	
//						
//				});
//				
//			}
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub'
			Object o = e.getSource();
			if(o.equals(btnthem)){
				panel_CongNhan.setVisible(false);
				giaoDienThemCapNhatCN();
				dateChooser_ngayKTCT.setEnabled(false);;
				btnThemCongNhan.setVisible(true);
				btnCapNhatCongNhan.setVisible(false);
				
				
			}
			if(o.equals(btnHuyThem)){
				
				panel_Them_SuaCongNhan.setVisible(false);
				giaoDienCN();
				
			}
			if(o.equals(btnCapNhat)) {
				panel_CongNhan.setVisible(false);
				giaoDienThemCapNhatCN();
				dateChooser_ngayKTCT.setEnabled(true);;
				btnThemCongNhan.setVisible(false);
				btnCapNhatCongNhan.setVisible(true);
				
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
			panel_ChiTietCN.setVisible(true);
			panel_bangTTCN.setBounds(10, 78, 1230, 415);
			scrollPane.setBounds(10, 40, 1210, 365);
			
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
