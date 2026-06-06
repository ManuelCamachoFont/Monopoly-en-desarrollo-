package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

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
	
	private Image ico = new ImageIcon(View.class.getResource("/es/studium/main/resources/ico/frameIco.png")).getImage();
	 
	private JDialog dialog = new JDialog(mainFrame, "Info", true);
	private JLabel lblDialog = new JLabel();

	public View() {
		Utilities.setExactSize(mainFrame, 800, 800);
		FontOption.registerCustomFont("PixelOperator.ttf");
		FontOption.registerCustomFont("Micro5-Regular.ttf");

		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setIconImage(ico);

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
		
		
		// Dialog
		dialog.setUndecorated(true);
		dialog.setResizable(false);

		JPanel container = new JPanel();
		container.setLayout(new BorderLayout(15, 15));
		container.setBackground(new Color(25, 25, 25));
		container.setBorder(BorderFactory.createLineBorder(new Color(212, 175, 55), 3));
		lblDialog.setForeground(Color.WHITE); 
		lblDialog.setHorizontalAlignment(SwingConstants.CENTER);
		lblDialog.setFont(new Font("Pixel Operator", Font.PLAIN, 20)); 
		lblDialog.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		container.add(lblDialog, BorderLayout.CENTER);

		JButton btnClose = new JButton("OK");
		btnClose.setFont(new Font("Pixel Operator", Font.BOLD, 18));
		btnClose.setBackground(new Color(212, 175, 55));
		btnClose.setForeground(Color.BLACK);
		btnClose.setFocusPainted(false);
		btnClose.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		

		btnClose.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnClose.setBackground(new Color(244, 215, 94));
			}
			public void mouseExited(MouseEvent e) {
				btnClose.setBackground(new Color(212, 175, 55));
			}
		});
		
		
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});


		JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelButton.setOpaque(false); 
		panelButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		panelButton.add(btnClose);
		
		container.add(panelButton, BorderLayout.SOUTH);
		
		dialog.add(container);
		
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
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
}

