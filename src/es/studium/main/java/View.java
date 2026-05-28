package es.studium.main.java;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {

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

	public View() {
		mainFrame.setSize(600, 600);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel.add(panelHome,"HOME");
		mainPanel.add(panelOptions,"OPTIONS");
		mainPanel.add(panelHelp, "HELP");
		mainPanel.add(panelRank,"RANKING");
		mainPanel.add(panelStart, "START");
		mainPanel.add(panelBoard, "BOARD");
		mainPanel.add(panelPlayer, "PLAYER");
		mainPanel.add(panelEnd, "END");

		mainFrame.add(mainPanel);

		showPanel("HOME");

		mainFrame.setVisible(true);
	}

	public void showPanel(String name) {
    	panels.show(mainPanel, name);
    }
	
	public void previousPanel() {
		panels.previous(mainPanel);
	}

	public PanelHome getPanelHome() {
		return panelHome;
	}
	
	public PanelOptions getPanelOptions() {
		return panelOptions;
	}
	
	public PanelHelp getPanelHelp() {
		return panelHelp;
	}
	
	public PanelRank getPanelRank() {
		return panelRank;
	}
	
	public PanelStart getPanelStart() {
		return panelStart;
	}
	
	public PanelBoard getPanelBoard() {
		return panelBoard;
	}
	
	public PanelPlayer getPanelPlayer() {
		return panelPlayer;
	}
	
	public PanelEnd getPanelEnd() {
		return panelEnd;
	}
	
	// Prueba para diferentes tamaños
	public void updateFrame() {
		mainFrame.revalidate();
		mainFrame.repaint();
	}
}

