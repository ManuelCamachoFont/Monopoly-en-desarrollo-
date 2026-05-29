package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEnd extends JPanel{

	JPanel panelNorth = new JPanel();
	JLabel endTitle = new JLabel("End Game");

	JPanel panelCenter = new JPanel();

	JPanel panelSouth = new JPanel();
	public PanelEnd() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 600));

	}
}
