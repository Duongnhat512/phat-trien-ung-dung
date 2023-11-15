package form;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.CongNhan_BUS;
import bus.NhanVien_BUS;
import commons.RoundPanel;
import connectDB.ConnectDB;
import entities.CongNhan;
import entities.NhanVien;
import gui.Main_GUI;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;



public class TrangChu_Form extends JPanel{
	private NhanVien_BUS nhanVien_BUS;
	private CongNhan_BUS congNhan_BUS;
	
	private int width = 1250;
	private int height = 725;
	private JLabel lbSLNV;
	private JLabel lbSLCN;
	private JLabel lbSLSP;
	 public TrangChu_Form(int width, int height) {
		 nhanVien_BUS = new NhanVien_BUS();
		 congNhan_BUS = new CongNhan_BUS();
		 try {
				ConnectDB.getInstance().connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.width = width;
			this.height= height;
			setLayout(null);
			
			
			initPanel();
		}
	private void initPanel() {
		// TODO Auto-generated method stub
		setPreferredSize(new Dimension(1250,777));
		RoundPanel panel = new RoundPanel();
		panel.setRound(20);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(64, 199, 312, 253);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("SỐ LƯỢNG NHÂN VIÊN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 128, 64));
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		 lbSLNV = new JLabel("25");
		lbSLNV.setFont(new Font("Tahoma", Font.BOLD, 40));
		lbSLNV.setBounds(127, 71, 60, 43);
		panel_4.add(lbSLNV);
		
		RoundPanel panel_1 = new RoundPanel();
		panel_1.setRound(20);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(484, 199, 312, 253);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2_1 = new JLabel("SỐ LƯỢNG CÔNG NHÂN");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_5.add(lblNewLabel_2_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 128, 255));
		panel_1.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(null);
		
		 lbSLCN = new JLabel("25");
		lbSLCN.setBounds(125, 57, 67, 65);
		lbSLCN.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_6.add(lbSLCN);
		
		RoundPanel panel_2 = new RoundPanel();
		panel_2.setRound(20);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(899, 199, 312, 253);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2_2 = new JLabel("SỐ LƯỢNG SẢN PHẨM");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel_7.add(lblNewLabel_2_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(128, 128, 255));
		panel_2.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(null);
		
		 lbSLSP = new JLabel("25");
		lbSLSP.setBounds(129, 58, 58, 56);
		lbSLSP.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_8.add(lbSLSP);
		
		JLabel lblNewLabel = new JLabel("PHẦN MỀM QUẢN LÝ LƯƠNG SẢN PHẨM");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setBounds(182, 35, 919, 136);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		Image logo = new ImageIcon(TrangChu_Form.class.getResource("/images/Trangchu.jpg")).getImage().getScaledInstance(1230, 1250,Image.SCALE_SMOOTH);
		ImageIcon logoIcon = new ImageIcon(logo);
		lblNewLabel_1.setIcon(logoIcon);
		lblNewLabel_1.setBounds(10, -21, 1230, 788);
		add(lblNewLabel_1);
		hienThiGiaoDien();
	}
	private void hienThiGiaoDien()
	{
		ArrayList<NhanVien> listNV = nhanVien_BUS.getdsNV();
		ArrayList<CongNhan> listCN = congNhan_BUS.getDanhSachCongNhan();
		
		lbSLNV.setText(listNV.size()+"");
		lbSLCN.setText(listCN.size()+"");
	}
	
}
