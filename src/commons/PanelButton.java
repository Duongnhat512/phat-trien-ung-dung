package commons;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ComponentUI;

import gui.Main_GUI;

public class PanelButton extends JPanel {
	private Color mainColor;
	private Color overColor;
	private Color clickColor;
	private boolean over;
	private boolean selected;
	private String name;
	private String icon;
	
	public PanelButton() {
		
	}
	public PanelButton(String name, String icon) {
		super();
		this.name = name;
		this.icon = icon;
		setButton(this.name, this.icon);
	}
	
	public void setButton(String name, String icon) {
		mainColor = new Color(0, 0, 0);
		overColor = new Color(236, 236, 236);
		
		setBorder(null);
		setLayout(null);
		setOpaque(false);
		setBackground(mainColor);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setForeground(Color.WHITE);
		
		JLabel lbl = new JLabel(name);
		lbl.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lbl.setBounds(100, 14, 122, 27);
		JLabel lblIcon = new JLabel();
		lblIcon.setIcon(new ImageIcon(this.getClass().getResource("/icon/" + icon + ".png")));
		lblIcon.setBounds(20, 8, 40, 40);
		add(lbl);
		add(lblIcon);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				over = true;
				repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				over = false;
				repaint();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selected = true;
				repaint();
			}
		});
	}
	
	public Color getMainColor() {
		return mainColor;
	}
	public void setMainColor(Color mainColor) {
		this.mainColor = mainColor;
	}
	public Color getOverColor() {
		return overColor;
	}
	public void setOverColor(Color overColor) {
		this.overColor = overColor;
	}
	public Color getClickColor() {
		return clickColor;
	}
	public void setClickColor(Color clickColor) {
		this.clickColor = clickColor;
	}
	public boolean isOver() {
		return over;
	}
	public void setOver(boolean flag) {
		this.over = flag;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
    protected void paintComponent(Graphics grphcs) {
        if (selected || over) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (selected) {
                g2.setColor(new Color(255, 255, 255, 80));
            } else {
                g2.setColor(new Color(255, 255, 255, 40));
            }
            g2.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
        }
        super.paintComponent(grphcs);
    }
}