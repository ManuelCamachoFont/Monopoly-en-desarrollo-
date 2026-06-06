package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelStart extends BackgroundPanel{

	JPanel panelNorth = new JPanel();
	JLabel startTitle = new JLabel("Players");

	JPanel panelCenter = new JPanel();
	JLabel lblPlayers = new JLabel("How many players will play?");
	String[] playersNumber = {"Select Players...", "2 Players", "3 Players", "4 Players"};
	// Add revalidate and repaint when selected change
	JComboBox<String> choPlayers = new JComboBox<String>(playersNumber);
	JPanel panelPlayers = new JPanel();

	// Player1
	JTextField txtPlayer1 = new JTextField("Player 1", 10);
	JLabel lblIcoPlayer1 = new JLabel();
	// Player2
	JTextField txtPlayer2 = new JTextField("Player 2", 10);
	JLabel lblIcoPlayer2 = new JLabel();
	// Player3
	JTextField txtPlayer3 = new JTextField("Player 3", 10);
	JLabel lblIcoPlayer3 = new JLabel();
	// Player 4
	JTextField txtPlayer4 = new JTextField("Player 4", 10);
	JLabel lblIcoPlayer4 = new JLabel();

	JPanel panelSouth = new JPanel();
	ImageIcon icoBack = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/back.png"));
	Image icoBackRedim = icoBack.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoBackR = new ImageIcon(icoBackRedim);
	JButton btnBack = new JButton("Back", icoBackR);

	ImageIcon icoPlay = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/confirm.png"));
	Image icoPlayRedim = icoPlay.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoPlayR = new ImageIcon(icoPlayRedim);
	JButton btnPlay = new JButton("Play", icoPlayR);

	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	GridBagLayout gridbagP = new GridBagLayout();
	GridBagConstraints gbcP = new GridBagConstraints();

	SpringLayout spring = new SpringLayout();
	
	Color colorBackground = new Color( 20, 20, 25);
	Color colorForeground = new Color(255, 0, 127);


	public PanelStart() {
		super("homeb_background2.png");
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(800, 800));

		// North Panel
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new EmptyBorder(110, 0, 0, 0));
		startTitle.setForeground(colorForeground);
		startTitle.setFont(getFont().deriveFont(62f));
		startTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		panelNorth.add(startTitle);
		panelNorth.setOpaque(false);
		add(panelNorth, BorderLayout.NORTH);

		// Center Panel
		panelCenter.setLayout(gridbag);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets (10, 10, 10, 10);
	
		lblPlayers.setForeground(colorForeground);
		lblPlayers.setFont(getFont().deriveFont(24f));
		panelCenter.add(lblPlayers, gbc);
		
		gbc.gridx = 1;
		choPlayers.setFont(getFont().deriveFont(24f));
		panelCenter.add(choPlayers, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weighty = 1.0;
		panelCenter.add(panelPlayers, gbc);
		gbc.gridwidth = 1;

		panelPlayers.setLayout(gridbagP);
		panelPlayers.setOpaque(false);
		gbcP.gridx = 0;
		gbcP.gridy = 0;
		gbcP.insets = new Insets (10, 10, 10, 10);

		
		// Player1
		txtPlayer1.setFont(getFont().deriveFont(2, 24f));
		panelPlayers.add(txtPlayer1, gbcP);
		gbcP.gridx = 1;
		Utilities.setIco(lblIcoPlayer1, "dog.png", 30, 30);
		panelPlayers.add(lblIcoPlayer1, gbcP);
		gbcP.gridx = 0;

		
		// Player2
		gbcP.gridy = 1;
		txtPlayer2.setFont(getFont().deriveFont(2, 24f));
		panelPlayers.add(txtPlayer2, gbcP);
		gbcP.gridx = 1;
		Utilities.setIco(lblIcoPlayer2, "iron.png", 30, 30);
		panelPlayers.add(lblIcoPlayer2, gbcP);
		gbcP.gridx = 0;

		
		// Player3
		gbcP.gridy = 2;
		txtPlayer3.setFont(getFont().deriveFont(2, 24f));
		panelPlayers.add(txtPlayer3, gbcP);
		gbcP.gridx = 1;
		Utilities.setIco(lblIcoPlayer3, "boots.png", 30, 30);
		panelPlayers.add(lblIcoPlayer3, gbcP);
		gbcP.gridx = 0;

		
		// Player4
		gbcP.gridy = 3;
		txtPlayer4.setFont(getFont().deriveFont(2, 24f));
		panelPlayers.add(txtPlayer4, gbcP);
		gbcP.gridx = 1;
		Utilities.setIco(lblIcoPlayer4, "thimble.png", 30, 30);
		panelPlayers.add(lblIcoPlayer4, gbcP);
		gbcP.gridx = 0;
		
		
		// Hide players
		Component[] components = panelPlayers.getComponents();
		for (int i = 0; i < components.length; i++) {
			components[i].setVisible(false);
		}

		panelCenter.setOpaque(false);
		add(panelCenter, BorderLayout.CENTER);

		// South Panel
		panelSouth.setLayout(spring);

		setButtonStyle(btnBack);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnBack);
		spring.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnBack, 10, SpringLayout.NORTH, panelSouth);
		spring.putConstraint(SpringLayout.SOUTH, panelSouth, 10, SpringLayout.SOUTH, btnBack);

		setButtonStyle(btnPlay);
		btnPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnPlay);
		spring.putConstraint(SpringLayout.EAST, btnPlay, -10, SpringLayout.EAST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnPlay, 10, SpringLayout.NORTH, panelSouth);

		panelSouth.setOpaque(false);
		add(panelSouth, BorderLayout.PAGE_END);
	}
	
	
	public void updatePlayers(int playersNumber) {
	    Component[] components = panelPlayers.getComponents();
	    
	    for (int i = 0; i < components.length; i++) {
	        int player = (i / 2) + 1; 
	        
	        if (player <= playersNumber) {
	            components[i].setVisible(true);
	        } else {
	            components[i].setVisible(false);
	        }
	    }
	    
	    panelPlayers.revalidate();
	    panelPlayers.repaint();
	}
	
	public JTextField getTxtPlayer1() { return txtPlayer1; }
	
	public JTextField getTxtPlayer2() { return txtPlayer2; }
	
	public JTextField getTxtPlayer3() { return txtPlayer3; }
	
	public JTextField getTxtPlayer4() { return txtPlayer4; }
	
	

}
