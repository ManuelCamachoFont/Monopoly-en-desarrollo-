package es.studium.main.java;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView {

	private JFrame mainFrame = new JFrame("Monopoly");
	private CardLayout panels = new CardLayout();
	private JPanel mainPanel = new JPanel(panels);

	private PanelHome panelHome = new PanelHome();
	private PanelOptions panelOptions = new PanelOptions();
	private PanelHelp panelHelp = new PanelHelp();
	private PanelRank panelRank = new PanelRank();
	private PanelStart panelStart = new PanelStart();
	private PanelBoard panelBoard = new PanelBoard();
	private PanelPlayer panelPlayer = new PanelPlayer();
	private PanelEnd panelEnd = new PanelEnd();

	public MainView() {
		mainFrame.setSize(600, 600);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel.add(panelHome,"HOME");
		mainPanel.add(panelOptions,"COMPRA");
		mainPanel.add(panelHelp, "RESUMEN");
		mainPanel.add(panelRank,"INFO");
		mainPanel.add(panelStart, "FIN");

		mainFrame.add(mainPanel);

		showPanel("HOME");

		mainFrame.setVisible(true);
	}

	public void showPanel(String nombre) {
    	panels.show(mainPanel, nombre);
    }

}

