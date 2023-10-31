package gui;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commons.MyButton;
import commons.MyMenu;
import form.ChamCongCongNhan_Form;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JLabel;

public class DemoPanel extends JFrame {

	private JPanel contentPane;
	private MyButton btn;
	private MyMenu menu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoPanel frame = new DemoPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DemoPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1800, 800);
//		setSize(Toolkit.getDefaultToolkit().getScreenSize());
//		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 154, 274, 599);
		panel.setBackground(new Color(18, 99, 63));
		contentPane.add(panel);
		panel.setLayout(null);
		
		menu = new MyMenu();
		menu.setBounds(0, 5, 264, 482);
		panel.add(menu);
	}
}
