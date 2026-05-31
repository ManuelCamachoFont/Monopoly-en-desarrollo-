package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PanelBoard extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanel panelLeft = new JPanel();
	ImageIcon icoDices = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/dices.png"));
	Image icoDicesRedim = icoDices.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	ImageIcon icoDicesR = new ImageIcon(icoDicesRedim);
	JLabel lblDices = new JLabel(icoDicesR);
	JLabel lblTurn = new JLabel("Player 1 has the turn");
	JButton btnTurn = new JButton("End turn");

	JPanel panelRight = new JPanel();
	JButton btnDices = new JButton("Roll the Dices");
	JButton btnBuy = new JButton("Buy property");

	JPanel panelPlayers = new JPanel();
	JLabel lblPlayerTitle = new JLabel("Players");
	JPanel panelPlayersInfo = new JPanel();
	BoxLayout boxLayout = new BoxLayout(panelPlayersInfo, BoxLayout.Y_AXIS);
	JLabel lblPlayerName1 = new JLabel("Placeholder 1");
	JLabel lblPlayerMoney1 = new JLabel("1500€");
	JLabel lblPlayerName2 = new JLabel("Placeholder 2");
	JLabel lblPlayerMoney2 = new JLabel("1500€");
	JLabel lblPlayerName3 = new JLabel("Placeholder 3");
	JLabel lblPlayerMoney3 = new JLabel("1500€");
	JLabel lblPlayerName4 = new JLabel("Placeholder 4");
	JLabel lblPlayerMoney4 = new JLabel("1500€");

	JPanel panelLogs = new JPanel();
	JLabel lblLogTitle = new JLabel("Logs");
	JTextArea txtLogs = new JTextArea(10, 20);

	JPanel panelGame = new JPanel();
	
	Dimension boardSize = new Dimension(880, 880);

	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	BoxLayout box = new BoxLayout(panelLeft, BoxLayout.Y_AXIS);

	GridBagLayout gridbagB = new GridBagLayout();
	GridBagConstraints gbcB = new GridBagConstraints();

	Border borderColor = BorderFactory.createLineBorder(Color.BLACK, 2);
	Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	Border border = BorderFactory.createCompoundBorder(borderColor, padding);

	public PanelBoard() {
		setLayout(gridbag);
		setPreferredSize(new Dimension(1450, 900));

		panelLeft.setLayout(box);
		panelLeft.setBorder(new EmptyBorder(20, 20, 20, 20));

		panelPlayers.setLayout(new BorderLayout());
		panelPlayers.setBorder(border);
		lblPlayerTitle.setHorizontalAlignment(JLabel.CENTER);
		lblPlayerTitle.setFont(new Font("Arial", Font.BOLD, 14));
		panelPlayers.add(lblPlayerTitle, BorderLayout.NORTH);

		panelPlayersInfo.setLayout(boxLayout);
		panelPlayersInfo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		lblPlayerName1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPlayerMoney1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPlayerName2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPlayerMoney2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPlayerName3.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPlayerMoney3.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPlayerName4.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPlayerMoney4.setAlignmentX(Component.CENTER_ALIGNMENT);

		panelPlayersInfo.add(lblPlayerName1);
		panelPlayersInfo.add(lblPlayerMoney1);
		panelPlayersInfo.add(Box.createRigidArea(new Dimension(0, 10)));
		panelPlayersInfo.add(lblPlayerName2);
		panelPlayersInfo.add(lblPlayerMoney2);
		panelPlayersInfo.add(Box.createRigidArea(new Dimension(0, 10)));
		panelPlayersInfo.add(lblPlayerName3);
		panelPlayersInfo.add(lblPlayerMoney3);
		panelPlayersInfo.add(Box.createRigidArea(new Dimension(0, 10)));
		panelPlayersInfo.add(lblPlayerName4);
		panelPlayersInfo.add(lblPlayerMoney4);

		panelPlayers.add(panelPlayersInfo, BorderLayout.CENTER);
		panelLeft.add(panelPlayers);

		panelLeft.add(Box.createRigidArea(new Dimension(0, 20)));

		panelLogs.setLayout(new BorderLayout());
		panelLogs.setBorder(border);
		lblLogTitle.setHorizontalAlignment(JLabel.CENTER);
		lblLogTitle.setFont(new Font("Arial", Font.BOLD, 14));
		panelLogs.add(lblLogTitle, BorderLayout.NORTH);

		txtLogs.setBorder(new EmptyBorder(15, 15, 15, 15));
		txtLogs.setLineWrap(true);
		txtLogs.setWrapStyleWord(true);
		txtLogs.setEditable(false);
		panelLogs.add(txtLogs, BorderLayout.CENTER);
		panelLeft.add(panelLogs);

		panelLeft.add(Box.createRigidArea(new Dimension(0, 20)));

		panelLeft.add(lblTurn);

		panelLeft.add(Box.createRigidArea(new Dimension(0, 20)));

		panelLeft.add(btnTurn);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 4; 
		gbc.weighty = 1.0;
		gbc.weightx = 0.20;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		add(panelLeft, gbc);

		panelRight.setLayout(new BorderLayout());
		panelGame.setLayout(gridbagB);

		panelRight.add(panelGame, BorderLayout.CENTER);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.weightx = 0.80;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;

		add(panelRight, gbc);
	}
	
	
	
	

	public void createBoard(int[][] board, HashMap<Integer, Square> squaresMap) {

		panelGame.removeAll();
		gbcB.insets = new Insets(1, 1, 1, 1);

		boolean[][] occuppied = new boolean[11][11];

		for (int row = 0; row < 11; row++) {
			for (int column = 0; column < 11; column++) {

				if (!occuppied [row][column]) {

					int position = board[row][column];

					gbcB.gridx = column;
					gbcB.gridy = row;
					gbcB.gridwidth = 1; 
					gbcB.gridheight = 1;
					gbcB.fill = GridBagConstraints.BOTH;


					if (column == 0 || column == 10) { 
						gbcB.weightx = 1.6; 
					} 
					else { 
						gbcB.weightx = 1.0; 
					}
					if (row == 0 || row == 10) { 
						gbcB.weighty = 1.6; 
					} else { 
						gbcB.weighty = 1.0; 
					}

					if (position == -1) {
						JPanel emptyPanel = new JPanel();
						emptyPanel.setOpaque(false);
						panelGame.add(emptyPanel, gbcB);
					}

					else if (position == -2) {
						gbcB.gridwidth = 3;
						isOcuppied(occuppied, row, column, gbcB.gridwidth, gbcB.gridheight);

						btnBuy.setFont(new Font("Arial", Font.BOLD, 12));
						panelGame.add(btnBuy, gbcB);
					}

					else if (position == -3) {
						gbcB.gridwidth = 3;
						isOcuppied(occuppied, row, column, gbcB.gridwidth, gbcB.gridheight);

						btnDices.setFont(new Font("Arial", Font.BOLD, 12));
						panelGame.add(btnDices, gbcB);
					}

					else {
						Square squareItem = squaresMap.get(position);

						if (squareItem != null) {
							JPanel squarePanel = new JPanel(new BorderLayout());
							squarePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
							squarePanel.setBackground(new Color(205, 230, 208));

							if (squareItem.getType().equals("PROPIEDAD") && squareItem.getColor() != null) {
								JPanel colorPanel = new JPanel();
								colorPanel.setPreferredSize(new Dimension(0, 15));
								try {
									colorPanel.setBackground(Color.decode(squareItem.getColor()));
								} catch (NumberFormatException nfe) {
									colorPanel.setBackground(Color.GRAY);
								}
								squarePanel.add(colorPanel, BorderLayout.NORTH);
							}

							JLabel lblName = new JLabel(squareItem.getName(), JLabel.CENTER);
							lblName.setFont(new Font("Arial", Font.BOLD, 10));
							squarePanel.add(lblName, BorderLayout.CENTER);

							if (squareItem.getPrice() > 0) {
								JLabel lblPrice = new JLabel(squareItem.getPrice() + " €", JLabel.CENTER);
								lblPrice.setFont(new Font("Arial", Font.BOLD, 10));
								squarePanel.add(lblPrice, BorderLayout.SOUTH);
							}

							panelGame.add(squarePanel, gbcB);
						}
					}

				}
			}
		}

		panelGame.revalidate();
		panelGame.repaint();
	}


	private void isOcuppied(boolean[][] board, int row, int column, int width, int height) {
		for (int r = row; r < row + height; r++) {
			for (int c = column; c < column + width; c++) {
				if (r < 11 && c < 11) {
					board[r][c] = true;
				}
			}
		}
	}

} 

