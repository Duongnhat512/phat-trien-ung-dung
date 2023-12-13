package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.CongNhan_BUS;
import bus.NhanVien_BUS;
import commons.MyButton;
import commons.RoundPanel;
import entities.CongNhan;
import entities.NhanVien;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ThongTinCaNhan_Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private RoundPanel panelThongTinKhac;
	private RoundPanel panelThongTinCaNhan;
	
	private NhanVien nv = null;
	private CongNhan cn = null;
	private JLabel lblHoTen;
	private JLabel lblTenNganHang;
	private JLabel lblSoTaiKhoan;
	private JLabel lblNgaySinh;
	private JLabel lblPhai;
	private JLabel lblCCCD;
	private JLabel lblNgayBatDauCongTac;
	private JLabel lblEmail;
	private JLabel lblSoDienThoai;
	private JLabel lblPhuCap;
	private JLabel lblContent1;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lblContent2;
	private JLabel lbl3;
	private JLabel lblContent3;
	private JLabel lbl4;
	private JLabel lblContent4;
	private JLabel lblID;
	private MyButton cancelButton;

	/**
	 * Create the dialog.
	 */
	public ThongTinCaNhan_Dialog(String id) {
		setTitle("Xem thông tin cá nhân");
		setBounds(100, 100, 923, 588);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAvt = new JLabel("");
		lblAvt.setBounds(99, 10, 236, 223);
		contentPanel.add(lblAvt);
		{
			panelThongTinCaNhan = new RoundPanel();
			panelThongTinCaNhan.setBounds(22, 283, 408, 208);
			contentPanel.add(panelThongTinCaNhan);
			panelThongTinCaNhan.setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 35, 408, 173);
				panelThongTinCaNhan.add(panel);
				panel.setLayout(null);
				{
					JLabel lblNewLabel_2 = new JLabel("Họ và tên:");
					lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(10, 10, 107, 25);
					panel.add(lblNewLabel_2);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Phái:");
					lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(10, 45, 107, 25);
					panel.add(lblNewLabel_2);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Ngày sinh:");
					lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(10, 82, 107, 25);
					panel.add(lblNewLabel_2);
				}
				{
					lblHoTen = new JLabel("");
					lblHoTen.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblHoTen.setBounds(175, 12, 223, 25);
					panel.add(lblHoTen);
				}
				{
					lblPhai = new JLabel("");
					lblPhai.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblPhai.setBounds(175, 45, 223, 25);
					panel.add(lblPhai);
				}
				{
					lblNgaySinh = new JLabel("");
					lblNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblNgaySinh.setBounds(175, 82, 223, 25);
					panel.add(lblNgaySinh);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("CCCD:");
					lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblNewLabel_2.setBounds(10, 118, 107, 25);
					panel.add(lblNewLabel_2);
				}
				{
					lblCCCD = new JLabel("");
					lblCCCD.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblCCCD.setBounds(175, 118, 223, 25);
					panel.add(lblCCCD);
				}
			}
			{
				RoundPanel panelTitle = new RoundPanel();
				panelTitle.setBackground(new Color(153, 204, 255));
				panelTitle.setRound(10);
				panelTitle.setBounds(0, 5, 408, 29);
				panelThongTinCaNhan.add(panelTitle);
				{
					JLabel lblNewLabel_1 = new JLabel("Thông tin cá nhân");
					lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
					panelTitle.add(lblNewLabel_1);
				}
			}
		}
		{
			panelThongTinKhac = new RoundPanel();
			panelThongTinKhac.setBounds(452, 10, 447, 481);
			contentPanel.add(panelThongTinKhac);
			panelThongTinKhac.setLayout(null);
			{
				RoundPanel panelTitle = new RoundPanel();
				panelTitle.setBounds(0, 0, 447, 30);
				panelTitle.setRound(10);
				panelTitle.setBackground(new Color(153, 204, 255));
				panelThongTinKhac.add(panelTitle);
				{
					JLabel lblNewLabel_1 = new JLabel("Thông tin cá nhân");
					lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
					panelTitle.add(lblNewLabel_1);
				}
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Ngày bắt đầu công tác:");
				lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(10, 40, 154, 25);
				panelThongTinKhac.add(lblNewLabel_2);
			}
			{
				lblNgayBatDauCongTac = new JLabel("");
				lblNgayBatDauCongTac.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblNgayBatDauCongTac.setBounds(214, 40, 223, 25);
				panelThongTinKhac.add(lblNgayBatDauCongTac);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Email:");
				lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(10, 75, 163, 25);
				panelThongTinKhac.add(lblNewLabel_2);
			}
			{
				lblEmail = new JLabel("");
				lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblEmail.setBounds(214, 75, 223, 25);
				panelThongTinKhac.add(lblEmail);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
				lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(10, 116, 163, 25);
				panelThongTinKhac.add(lblNewLabel_2);
			}
			{
				lblSoDienThoai = new JLabel("");
				lblSoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblSoDienThoai.setBounds(214, 116, 223, 25);
				panelThongTinKhac.add(lblSoDienThoai);
			}
			{
				lblPhuCap = new JLabel("");
				lblPhuCap.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblPhuCap.setBounds(214, 162, 223, 25);
				panelThongTinKhac.add(lblPhuCap);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Phụ cấp:");
				lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(10, 162, 163, 25);
				panelThongTinKhac.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Số tài khoản:");
				lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(10, 207, 163, 25);
				panelThongTinKhac.add(lblNewLabel_2);
			}
			{
				lblSoTaiKhoan = new JLabel("");
				lblSoTaiKhoan.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblSoTaiKhoan.setBounds(214, 207, 223, 25);
				panelThongTinKhac.add(lblSoTaiKhoan);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tên ngân hàng:");
				lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(10, 253, 163, 25);
				panelThongTinKhac.add(lblNewLabel_2);
			}
			{
				lblTenNganHang = new JLabel("");
				lblTenNganHang.setFont(new Font("SansSerif", Font.PLAIN, 15));
				lblTenNganHang.setBounds(214, 253, 223, 25);
				panelThongTinKhac.add(lblTenNganHang);
			}
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 288, 447, 193);
				panelThongTinKhac.add(panel);
				panel.setLayout(null);
				{
					lblContent1 = new JLabel("");
					lblContent1.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblContent1.setBounds(214, 10, 223, 25);
					panel.add(lblContent1);
				}
				{
					lbl1 = new JLabel("");
					lbl1.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lbl1.setBounds(10, 10, 163, 25);
					panel.add(lbl1);
				}
				{
					lbl2 = new JLabel("");
					lbl2.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lbl2.setBounds(10, 53, 163, 25);
					panel.add(lbl2);
				}
				{
					lblContent2 = new JLabel("");
					lblContent2.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblContent2.setBounds(214, 53, 223, 25);
					panel.add(lblContent2);
				}
				{
					lbl3 = new JLabel("");
					lbl3.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lbl3.setBounds(10, 101, 163, 25);
					panel.add(lbl3);
				}
				{
					lblContent3 = new JLabel("");
					lblContent3.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblContent3.setBounds(214, 101, 223, 25);
					panel.add(lblContent3);
				}
				{
					lbl4 = new JLabel("");
					lbl4.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lbl4.setBounds(10, 147, 163, 25);
					panel.add(lbl4);
				}
				{
					lblContent4 = new JLabel("");
					lblContent4.setFont(new Font("SansSerif", Font.PLAIN, 15));
					lblContent4.setBounds(214, 147, 223, 25);
					panel.add(lblContent4);
				}
			}
		}
		{
			lblID = new JLabel("");
			lblID.setFont(new Font("SansSerif", Font.PLAIN, 15));
			lblID.setHorizontalAlignment(SwingConstants.CENTER);
			lblID.setBounds(122, 243, 188, 30);
			contentPanel.add(lblID);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new MyButton();
				cancelButton.setFocusPainted(false);
				cancelButton.setPreferredSize(new Dimension(100, 40));
				cancelButton.setText("Đóng");
				cancelButton.setBackground(new Color(255, 0, 0));
				cancelButton.setIcon(new ImageIcon(ThongTinCaNhan_Dialog.class.getResource("/icon/unavailable.png")));
				cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 15));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
			}
		}
		
		getData(id);
		hienThiThongTin();
	}
	
	private void getData(String id) {
		if (id.matches("(CN)\\d{4}")) {
			CongNhan_BUS cn_Bus = new CongNhan_BUS();
			cn = cn_Bus.getCongNhanTheoID(id);
		}
		else {
			NhanVien_BUS nv_Bus = new NhanVien_BUS();
			nv = nv_Bus.getNhanVienTheoID(id);
		}
	}
	
	private void hienThiThongTin() {
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (nv == null) {
			lblID.setText(cn.getIdCongNhan());
			lblHoTen.setText(cn.getHoTen());
			lblNgaySinh.setText(dft.format(cn.getNgaySinh()));
			lblPhai.setText(cn.isPhai()?"Nam":"Nữ");
			lblCCCD.setText(cn.getcCCD());
			lblNgayBatDauCongTac.setText(dft.format(cn.getNgayBatDauCongTac()));
			lblEmail.setText(cn.getEmail());
			lblSoDienThoai.setText(cn.getSoDienThoai());
			lblPhuCap.setText(String.format("%,.2f VND", cn.getPhuCap()));
			lblSoTaiKhoan.setText(cn.getTaiKhoan().getTaiKhoanNganHang().getSoTaiKhoan());
			lblTenNganHang.setText(cn.getTaiKhoan().getTaiKhoanNganHang().getTenNganHang());
			lbl1.setText("Phân xưởng:");
			lblContent1.setText(cn.getPhanXuong().getTenPhanXuong());
			lbl2.setText("Tay nghề:");
			lblContent2.setText(cn.getTayNghe());
		}
		else {
			lblID.setText(nv.getIdNhanVien());
			lblHoTen.setText(nv.getHoTen());
			lblNgaySinh.setText(dft.format(nv.getNgaySinh()));
			lblPhai.setText(nv.isPhai()?"Nam":"Nữ");
			lblCCCD.setText(nv.getcCCD());
			lblNgayBatDauCongTac.setText(dft.format(nv.getNgayBatDauCongTac()));
			lblEmail.setText(nv.getEmail());
			lblSoDienThoai.setText(nv.getSoDienThoai());
			lblPhuCap.setText(String.format("%,.2f VND", nv.getPhuCap()));
			lblSoTaiKhoan.setText(nv.getTaiKhoan().getTaiKhoanNganHang().getSoTaiKhoan());
			lblTenNganHang.setText(nv.getTaiKhoan().getTaiKhoanNganHang().getTenNganHang());
			lbl1.setText("Phòng ban: ");
			lblContent1.setText(nv.getPhongBan().getTenPhongBan());
			lbl2.setText("Chức vụ:");
			lblContent2.setText(nv.getChucVu().getTenChucVu());
			lbl3.setText("Hệ số bảo hiểm xã hội:");
			lblContent3.setText(nv.getHESOBAOHIEMXAHOI() + "");
			lbl4.setText("Lương cơ bản:");
			lblContent4.setText(String.format("%,.2f VND", nv.getLUONGCOBAN() * nv.getChucVu().getHeSoLuong()));
			
		}
	}
}
