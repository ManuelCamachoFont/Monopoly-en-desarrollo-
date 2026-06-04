package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Component;
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

public class PanelStart extends JPanel{

	JPanel panelNorth = new JPanel();
	JLabel startTitle = new JLabel("Players");

	JPanel panelCenter = new JPanel();
	JLabel lblPlayers = new JLabel("How many persons want to play?");
	String[] playersNumber = {"Select Players...", "2 Players", "3 Players", "4 Players"};
	// Add revalidate and repaint when selected change
	JComboBox<String> choPlayers = new JComboBox<String>(playersNumber);
	JPanel panelPlayers = new JPanel();

	// Player1
	JTextField txtPlayer1 = new JTextField("Player 1", 20);
	JLabel lblIcoPlayer1 = new JLabel();
	// Player2
	JTextField txtPlayer2 = new JTextField("Player 2", 20);
	JLabel lblIcoPlayer2 = new JLabel();
	// Player3
	JTextField txtPlayer3 = new JTextField("Player 3", 20);
	JLabel lblIcoPlayer3 = new JLabel();
	// Player 4
	JTextField txtPlayer4 = new JTextField("Player 4", 20);
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

	SpringLayout spring = new SpringLayout();


	public PanelStart() {
		setLayout(new BorderLayout());

		// North Panel
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBorder(new EmptyBorder(80, 0, 0, 0));
		startTitle.setFont(new Font("Cooper Black", 1, 62));
		startTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		panelNorth.add(startTitle);
		add(panelNorth, BorderLayout.NORTH);

		// Center Panel
		panelCenter.setLayout(new FlowLayout());
		panelCenter.setBorder(new EmptyBorder(40, 0, 0, 0));
		panelCenter.add(lblPlayers);
		panelCenter.add(choPlayers);
		panelCenter.add(panelPlayers);

		panelPlayers.setLayout(gridbag);
		panelPlayers.setBorder(new EmptyBorder(20, 0, 0, 0));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets (10, 10, 10, 10);

		
		// Player1
		txtPlayer1.setFont(new Font("Arial", Font.ITALIC, 12));
		panelPlayers.add(txtPlayer1, gbc);
		gbc.gridx = 1;
		Utilities.setIco(lblIcoPlayer1, "dog.png", 30, 30);
		panelPlayers.add(lblIcoPlayer1, gbc);
		gbc.gridx = 0;

		
		// Player2
		gbc.gridy = 1;
		txtPlayer2.setFont(new Font("Arial", Font.ITALIC, 12));
		panelPlayers.add(txtPlayer2, gbc);
		gbc.gridx = 1;
		Utilities.setIco(lblIcoPlayer2, "iron.png", 30, 30);
		panelPlayers.add(lblIcoPlayer2, gbc);
		gbc.gridx = 0;

		
		// Player3
		gbc.gridy = 2;
		txtPlayer3.setFont(new Font("Arial", Font.ITALIC, 12));
		panelPlayers.add(txtPlayer3, gbc);
		gbc.gridx = 1;
		Utilities.setIco(lblIcoPlayer3, "boots.png", 30, 30);
		panelPlayers.add(lblIcoPlayer3, gbc);
		gbc.gridx = 0;

		
		// Player4
		gbc.gridy = 3;
		txtPlayer4.setFont(new Font("Arial", Font.ITALIC, 12));
		panelPlayers.add(txtPlayer4, gbc);
		gbc.gridx = 1;
		Utilities.setIco(lblIcoPlayer4, "thimble.png", 30, 30);
		panelPlayers.add(lblIcoPlayer4, gbc);
		gbc.gridx = 0;
		
		
		// Hide players
		Component[] components = panelPlayers.getComponents();
		for (int i = 0; i < components.length; i++) {
			components[i].setVisible(false);
		}


		add(panelCenter, BorderLayout.CENTER);

		// South Panel
		panelSouth.setLayout(spring);

		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnBack);
		spring.putConstraint(SpringLayout.WEST, btnBack, 10, SpringLayout.WEST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnBack, 10, SpringLayout.NORTH, panelSouth);
		spring.putConstraint(SpringLayout.SOUTH, panelSouth, 10, SpringLayout.SOUTH, btnBack);

		btnPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelSouth.add(btnPlay);
		spring.putConstraint(SpringLayout.EAST, btnPlay, -10, SpringLayout.EAST, panelSouth);
		spring.putConstraint(SpringLayout.NORTH, btnPlay, 10, SpringLayout.NORTH, panelSouth);

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
