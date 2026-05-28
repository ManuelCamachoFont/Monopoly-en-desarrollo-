package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

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
	ImageIcon icoPlayer1 = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/player1.png"));
	Image icoPlayer1Redim = icoPlayer1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoPlayer1R = new ImageIcon(icoPlayer1Redim);
	JLabel lblIcoPlayer1 = new JLabel(icoPlayer1R);
	// Player2
	JTextField txtPlayer2 = new JTextField("Player 2", 20);
	ImageIcon icoPlayer2 = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/player1.png"));
	Image icoPlayer2Redim = icoPlayer2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoPlayer2R = new ImageIcon(icoPlayer2Redim);
	JLabel lblIcoPlayer2 = new JLabel(icoPlayer2R);
	// Player3
	JTextField txtPlayer3 = new JTextField("Player 3", 20);
	ImageIcon icoPlayer3 = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/player1.png"));
	Image icoPlayer3Redim = icoPlayer3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoPlayer3R = new ImageIcon(icoPlayer3Redim);
	JLabel lblIcoPlayer3 = new JLabel(icoPlayer3R);
	// Player 4
	JTextField txtPlayer4 = new JTextField("Player 4", 20);
	ImageIcon icoPlayer4 = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/player1.png"));
	Image icoPlayer4Redim = icoPlayer4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoPlayer4R = new ImageIcon(icoPlayer4Redim);
	JLabel lblIcoPlayer4 = new JLabel(icoPlayer4R);

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
		panelPlayers.add(txtPlayer1, gbc);
		gbc.gridx = 1;
		panelPlayers.add(lblIcoPlayer1, gbc);
		gbc.gridx = 0;

		
		// Player2
		gbc.gridy = 1;
		panelPlayers.add(txtPlayer2, gbc);
		gbc.gridx = 1;
		panelPlayers.add(lblIcoPlayer2, gbc);
		gbc.gridx = 0;

		
		// Player3
		gbc.gridy = 2;
		panelPlayers.add(txtPlayer3, gbc);
		gbc.gridx = 1;
		panelPlayers.add(lblIcoPlayer3, gbc);
		gbc.gridx = 0;

		
		// Player4
		gbc.gridy = 3;
		panelPlayers.add(txtPlayer4, gbc);
		gbc.gridx = 1;
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
}
