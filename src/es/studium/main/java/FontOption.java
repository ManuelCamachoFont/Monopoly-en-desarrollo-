package es.studium.main.java;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.Collections;
import java.util.List;

import javax.swing.UIManager;

public class FontOption {

	// Need to revalidate some dialogs and may not be working on every new created component
	public static void changeFontFamily (Component component, String fontFamily) {
		List<Object> keys = Collections.list(UIManager.getDefaults().keys());
		for (Object key : keys) {
			Object value = UIManager.get(key);
			if (value instanceof Font f) {
				UIManager.put(key, new Font(fontFamily, f.getStyle(), f.getSize()));
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
