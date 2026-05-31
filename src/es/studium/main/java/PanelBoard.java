package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PanelBoard extends JPanel{

	JPanel panelNorth = new JPanel();
	ImageIcon icoDices = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/dices.png"));
	Image icoDicesRedim = icoDices.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	ImageIcon icoDicesR = new ImageIcon(icoDicesRedim);
	JLabel lblDices = new JLabel(icoDicesR);
	JButton btnDices = new JButton("Roll the Dices");
	JButton btnBuy = new JButton("Buy property");

	JPanel panelCenter = new JPanel();

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
	JTextArea txtLogs = new JTextArea(10,20);

	JPanel panelGame = new JPanel();
	Dimension boardSize = new Dimension(770, 770);

	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	GridLayout grid = new GridLayout(11, 11, 1, 1);

	SpringLayout spring = new SpringLayout();
	
	Border borderColor = BorderFactory.createLineBorder(Color.BLACK, 2);
	Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	Border border = BorderFactory.createCompoundBorder(borderColor, padding);

	public PanelBoard() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1250, 900));

		panelNorth.setLayout(spring);
		panelNorth.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		panelNorth.add(lblDices);
		spring.putConstraint(SpringLayout.WEST, lblDices, 20, SpringLayout.WEST, panelNorth);
		spring.putConstraint(SpringLayout.NORTH,lblDices, 10, SpringLayout.NORTH, panelNorth);
		
		btnDices.setPreferredSize(new Dimension(200, 80));
		panelNorth.add(btnDices);
		spring.putConstraint(SpringLayout.WEST, btnDices, 100, SpringLayout.EAST, lblDices);
		spring.putConstraint(SpringLayout.NORTH, btnDices, 10, SpringLayout.NORTH, panelNorth);
		btnBuy.setPreferredSize(new Dimension(200, 80));
		panelNorth.add(btnBuy);
		spring.putConstraint(SpringLayout.WEST, btnBuy, 100, SpringLayout.EAST, btnDices);
		spring.putConstraint(SpringLayout.NORTH, btnBuy, 10, SpringLayout.NORTH, panelNorth);
		
		spring.putConstraint(SpringLayout.SOUTH, panelNorth, 10, SpringLayout.SOUTH, btnDices);

		add(panelNorth, BorderLayout.NORTH);

		panelCenter.setLayout(gridbag);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.25;
		gbc.weightx = 0.10;
		gbc.insets = new Insets (10, 10, 10, 10);

		panelPlayers.setLayout(new BorderLayout());
		panelPlayers.setBorder(border);
		panelPlayers.add(lblPlayerTitle, BorderLayout.NORTH);
		panelPlayers.add(panelPlayersInfo, BorderLayout.CENTER);
		panelPlayersInfo.setLayout(boxLayout);
		panelPlayersInfo.setBorder(border);
		panelPlayersInfo.add(lblPlayerName1);
		panelPlayersInfo.add(lblPlayerMoney1);
		panelPlayersInfo.add(lblPlayerName2);
		panelPlayersInfo.add(lblPlayerMoney2);
		panelPlayersInfo.add(lblPlayerName3);
		panelPlayersInfo.add(lblPlayerMoney3);
		panelPlayersInfo.add(lblPlayerName4);
		panelPlayersInfo.add(lblPlayerMoney4);
		panelCenter.add(panelPlayers, gbc);

		gbc.gridy = 1;
		panelLogs.setLayout(new BorderLayout());
		panelLogs.setBorder(border);
		panelLogs.add(lblLogTitle, BorderLayout.NORTH);
		txtLogs.setBorder(border);
		txtLogs.setEditable(false);
		panelLogs.add(txtLogs, BorderLayout.CENTER);
		panelCenter.add(panelLogs, gbc);


		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		
		gbc.weightx = 0.75;
		gbc.weighty = 1;
		
		gbc.fill = GridBagConstraints.BOTH;
		
		panelGame.setPreferredSize(boardSize);
		panelGame.setMinimumSize(boardSize);
		panelGame.setMaximumSize(boardSize);
		
		panelGame.setLayout(grid);
		
		panelCenter.add(panelGame, gbc);
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.NONE;

		add(panelCenter, BorderLayout.CENTER);
	}
	
	public void createBoard(int[][] board, List<Square> squares) {
	    panelGame.removeAll();
	    
	    for (int row = 0; row < 11; row++) {
	        for (int column = 0; column < 11; column++) {
	            
	            int idSquare = board[row][column];

	            if (idSquare == -1) {
	                JPanel emptyPanel = new JPanel();
	                emptyPanel.setOpaque(false);
	                panelGame.add(emptyPanel);
	            } 
	            else if (idSquare == -2) {
	                JPanel emptyPanel = new JPanel();
	                emptyPanel.setOpaque(false);
	                panelGame.add(emptyPanel);
	            }
	            else if (idSquare == -3) {
	                JPanel emptyPanel = new JPanel();
	                emptyPanel.setOpaque(false);
	                panelGame.add(emptyPanel);
	            }
	            else if (idSquare == -4) {
	                JPanel emptyPanel = new JPanel();
	                emptyPanel.setOpaque(false);
	                panelGame.add(emptyPanel);
	            }
	            else {

	                Square squareItem = squares.get(idSquare);

	                JPanel squarePanel = new JPanel();
	                squarePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	                
	                squarePanel.setBackground(new Color(205, 230, 208)); 

	                squarePanel.setLayout(new BorderLayout());
	                
	                if (squareItem.getType().equals("PROPIEDAD") && squareItem.getColor() != null) {
	                	
	                	JPanel colorPanel = new JPanel();
	                	colorPanel.setPreferredSize(new Dimension(0, 15));
	                	
	                	try {
	                		Color colorProperty = Color.decode(squareItem.getColor());
	                		colorPanel.setBackground(colorProperty);
	                	}
	                	catch (NumberFormatException nfe) {
	                		colorPanel.setBackground(Color.GRAY);
	                	}
	                	
	                	squarePanel.add(colorPanel, BorderLayout.NORTH);
	                }
	                
	                JLabel lblName = new JLabel(squareItem.getName(), JLabel.CENTER);
	                lblName.setFont(new Font("Arial", 1, 10));
	                squarePanel.add(lblName, BorderLayout.CENTER);
	                
	                if(squareItem.getPrice() > 0) {
	                	JLabel lblPrice = new JLabel(squareItem.getPrice() + " €", JLabel.CENTER);
	                	lblPrice.setFont(new Font("Arial", 1, 10));
	                	squarePanel.add(lblPrice, BorderLayout.SOUTH);
	                }
	                panelGame.add(squarePanel);
	                
	            }
	        }
	    }
	    panelGame.revalidate();
	    panelGame.repaint();
	}
}
