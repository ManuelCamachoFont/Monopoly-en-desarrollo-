package es.studium.main.java;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import javax.swing.UIManager;

public class FontOption {

	public static String registerCustomFont(String filename) {
		try {
			String path = "/es/studium/main/resources/fonts/" + filename;
			URL url = FontOption.class.getResource(path);
			if (url == null) {
				System.err.println("Error file not found: " + path);
				return null;
			}
			
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, url.openStream());
			
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
			
			return customFont.getFamily();
			
		} catch (Exception e) {
			System.err.println("Error loading font: " + e.getMessage());
			return null;
		}
	}
	
	public static void changeFontFamily (Component component, String fontFamily) {
		List<Object> keys = Collections.list(UIManager.getDefaults().keys());
		for (Object key : keys) {
			Object value = UIManager.get(key);
			if (value instanceof Font f) {
				UIManager.put(key, new Font(fontFamily, f.getStyle(),f.getSize()));
			}
		}
		
		executeFontChange(component, fontFamily);
		
	}
	
	private static void executeFontChange(Component component, String fontFamily) {
		Font f = component.getFont();
		if (f != null) {
			component.setFont(new Font(fontFamily, f.getStyle(), f.getSize()));
			if (component instanceof Container container) {
				for (Component child : container.getComponents()) {
					executeFontChange(child, fontFamily);
				}
			}
		}
	}
}
