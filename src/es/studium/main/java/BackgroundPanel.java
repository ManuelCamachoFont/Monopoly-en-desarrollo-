package es.studium.main.java;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image backgroundImage;
	Color colorBackground = new Color( 20, 20, 25);
	Color colorForeground = new Color(255, 0, 127);

	public BackgroundPanel(String fileName) {
		setBackgroundImage(fileName);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (backgroundImage != null) {
			int panelWidth = getWidth();
			int panelHeight = getHeight();
			int imgWidth = backgroundImage.getWidth(this);
			int imgHeight = backgroundImage.getHeight(this);


			double widthRatio = (double) panelWidth / imgWidth;
			double heightRatio = (double) panelHeight / imgHeight;
			double ratio = Math.max(widthRatio, heightRatio);

			int widthResize = (int) (imgWidth * ratio);
			int heightResize = (int) (imgHeight * ratio);


			int x = (panelWidth - widthResize) / 2;
			int y = (panelHeight - heightResize) / 2;

			g.drawImage(backgroundImage, x, y, widthResize, heightResize, this);
		}
	}

	public void setBackgroundImage(String fileName) {
		String path = "/es/studium/main/resources/img/" + fileName;
		URL resourcePath = BackgroundPanel.class.getResource(path);

		if (resourcePath != null) {
			this.backgroundImage = new ImageIcon(resourcePath).getImage();
		} else {
			System.err.println("File not found: " + path);
			this.backgroundImage = null; 
			this.repaint(); 
		}
	}
	
	public void setButtonStyle(JButton button) {
		button.setBackground(colorBackground);
		button.setForeground(colorForeground);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createLineBorder(colorForeground, 2));
	}
}