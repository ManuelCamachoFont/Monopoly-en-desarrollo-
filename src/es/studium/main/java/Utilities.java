package es.studium.main.java;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Utilities {

	public static void setIco(JLabel label, String file, int width, int height) {
		Dimension size = new Dimension(width, height);
		label.setPreferredSize(size);
		label.setMinimumSize(size);
		label.setMaximumSize(size);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		String path = "/es/studium/main/resources/ico/" + file;
		URL resourcePath = Utilities.class.getResource(path);
		
		ImageIcon icon = new ImageIcon(resourcePath);
		int icoWidth = icon.getIconWidth();
		int icoHeight = icon.getIconHeight();
		
		double widthRatio = (double) width / icoWidth;
		double heightRatio = (double) height / icoHeight;
		double ratio = Math.min(widthRatio, heightRatio);
		
		int widthResize = (int) (icoWidth * ratio);
		int heightResize = (int) (icoHeight * ratio);
		
		Image imgResize = icon.getImage().getScaledInstance(widthResize, heightResize, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(imgResize));
	}
	
	public static void setExactSize(JFrame mainFrame, int widthInner, int heightInner) {

	    mainFrame.setVisible(true); 

	    Insets insets = mainFrame.getInsets();

	    int widthTotal = widthInner + insets.left + insets.right;
	    int heightTotal = heightInner + insets.top + insets.bottom;
	    
	    mainFrame.setSize(widthTotal, heightTotal);
	}
}
