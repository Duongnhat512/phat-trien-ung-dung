package commons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class MyButton extends JButton{
	private boolean over;
	private Color color;
	private Color colorOver;
	private Color colorClick;
	private Color borderColor;
	private int radius = 0;
	
	public MyButton() {
		// Init color
		setColor(Color.WHITE);
		setBorderColor(Color.WHITE);
		setBorder(null);
		
		setContentAreaFilled(false);
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColorOver() {
		return colorOver;
	}

	public void setColorOver(Color colorOver) {
		this.colorOver = colorOver;
	}

	public Color getColorClick() {
		return colorClick;
	}

	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//paint border
		g2d.setColor(new Color(228, 228, 228));
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
		g2d.setColor(getBackground());
		// border set 2 pixel
		g2d.fillRoundRect(1, 1, getWidth() - 4, getHeight() - 4, radius, radius);
		super.paintComponent(g);
	}
	
}
