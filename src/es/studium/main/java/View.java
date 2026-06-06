package es.studium.main.java;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View {

	private JFrame mainFrame = new JFrame("Monopoly");
	private CardLayout panels = new CardLayout();
	private JPanel mainPanel = new JPanel(panels) {
	    @Override
	    public Dimension getPreferredSize() {
	        for (Component c : getComponents()) {
	            if (c.isVisible()) {
	                return c.getPreferredSize();
	            }
	        }
	        return super.getPreferredSize();
	    }
	};

	private PanelHome panelHome = new PanelHome();
	private PanelOptions panelOptions = new PanelOptions();
	private PanelHelp panelHelp = new PanelHelp();
	private PanelRank panelRank = new PanelRank();
	private PanelStart panelStart = new PanelStart();
	private PanelBoard panelBoard = new PanelBoard();
	private PanelEnd panelEnd = new PanelEnd();
	
	private JDialog dialog = new JDialog(mainFrame, "Dialog", true);
	private JLabel lblDialog = new JLabel();

	public View() {
		Utilities.setExactSize(mainFrame, 800, 800);
		FontOption.registerCustomFont("PixelOperator.ttf");
		FontOption.registerCustomFont("Micro5-Regular.ttf");

		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel.add(panelHome,"HOME");
		mainPanel.add(panelOptions,"OPTIONS");
		mainPanel.add(panelHelp, "HELP");
		mainPanel.add(panelRank,"RANKING");
		mainPanel.add(panelStart, "START");
		mainPanel.add(panelBoard, "BOARD");
		mainPanel.add(panelEnd, "END");

		mainFrame.add(mainPanel);

		showPanel("HOME");

		mainFrame.setVisible(true);
		
		
		dialog.setSize(200, 200);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setLayout(new FlowLayout());
		lblDialog.setFont(lblDialog.getFont().deriveFont(40f));
		dialog.add(lblDialog);
		
		FontOption.changeFontFamily(mainFrame, "Pixel Operator");
		
	}

	public void showPanel(String name) {
    	panels.show(mainPanel, name);
    	mainFrame.pack();
    	mainFrame.setLocationRelativeTo(null);
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
	
	public PanelEnd getPanelEnd() {
		return panelEnd;
	}
	
	// Prueba para diferentes tamaños
	public void updateFrame() {
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public JFrame getFrame() {
		return mainFrame;
	}
	
	public JDialog getDialog() {
		return dialog;
	}
	
	public void showDialog(String message) {
		lblDialog.setText(message);
		dialog.revalidate();
		dialog.pack();
		dialog.setVisible(true);
	}
}

