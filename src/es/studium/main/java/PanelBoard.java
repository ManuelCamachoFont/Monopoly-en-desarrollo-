package es.studium.main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	JLabel lblPlayerName1 = new JLabel();
	JLabel lblPlayerMoney1 = new JLabel();
	JLabel lblPlayerName2 = new JLabel();
	JLabel lblPlayerMoney2 = new JLabel();
	JLabel lblPlayerName3 = new JLabel();
	JLabel lblPlayerMoney3 = new JLabel();
	JLabel lblPlayerName4 = new JLabel();
	JLabel lblPlayerMoney4 = new JLabel();
	ImageIcon icoPlayer1 = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/car.png"));
	Image icoPlayer1Redim = icoPlayer1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoPlayer1R = new ImageIcon(icoPlayer1Redim);
	JLabel lblIcon1 = new JLabel(icoPlayer1R);
	ImageIcon icoPlayer2 = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/player1.png"));
	Image icoPlayer2Redim = icoPlayer2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoPlayer2R = new ImageIcon(icoPlayer2Redim);
	JLabel lblIcon2 = new JLabel(icoPlayer2R);
	ImageIcon icoPlayer3 = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/player1.png"));
	Image icoPlayer3Redim = icoPlayer3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoPlayer3R = new ImageIcon(icoPlayer3Redim);
	JLabel lblIcon3 = new JLabel(icoPlayer3R);
	ImageIcon icoPlayer4 = new ImageIcon(getClass().getResource("/es/studium/main/resources/ico/player1.png"));
	Image icoPlayer4Redim = icoPlayer4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	ImageIcon icoPlayer4R = new ImageIcon(icoPlayer4Redim);
	JLabel lblIcon4 = new JLabel(icoPlayer4R);
	JLabel[] lblName = new JLabel[4];
	JLabel[] lblMoney = new JLabel[4];
	JLabel[] lblIcon = new JLabel[4];
	Component[] margin = new Component[3];


	
	JPanel panelLogs = new JPanel();
	JLabel lblLogTitle = new JLabel("Logs");
	JTextArea txtLogs = new JTextArea(10, 20);
	JScrollPane scrollLogs = new JScrollPane(txtLogs, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JPanel panelGame = new JPanel();
	JPanel[] squaresBoard = new JPanel[40];
	JPanel[][] playersPosition = new JPanel[40][4];
	
	Dimension boardSize = new Dimension(880, 880);

	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	BoxLayout box = new BoxLayout(panelLeft, BoxLayout.Y_AXIS);

	GridBagLayout gridbagB = new GridBagLayout();
	GridBagConstraints gbcB = new GridBagConstraints();

	Border borderColor = BorderFactory.createLineBorder(Color.BLACK, 2);
	Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	Border border = BorderFactory.createCompoundBorder(borderColor, padding);
	
	Border southBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
	Border borderTitle = BorderFactory.createCompoundBorder(southBorder, padding);

	public PanelBoard() {
		setLayout(gridbag);
		setPreferredSize(new Dimension(1450, 900));

		panelLeft.setLayout(box);
		panelLeft.setBorder(new EmptyBorder(20, 20, 20, 20));

		panelPlayers.setLayout(new BorderLayout());
		panelPlayers.setBorder(border);
		lblPlayerTitle.setBorder(borderTitle);
		lblPlayerTitle.setHorizontalAlignment(JLabel.CENTER);
		lblPlayerTitle.setFont(new Font("Arial", Font.BOLD, 14));
		panelPlayers.add(lblPlayerTitle, BorderLayout.NORTH);

		panelPlayersInfo.setLayout(boxLayout);
		panelPlayersInfo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		lblName[0] = lblPlayerName1;
	    lblName[1] = lblPlayerName2;
	    lblName[2] = lblPlayerName3;
	    lblName[3] = lblPlayerName4;

	    lblMoney[0] = lblPlayerMoney1;
	    lblMoney[1] = lblPlayerMoney2;
	    lblMoney[2] = lblPlayerMoney3;
	    lblMoney[3] = lblPlayerMoney4;
	    
	    lblIcon[0] = lblIcon1;
	    lblIcon[1] = lblIcon2;
	    lblIcon[2] = lblIcon3;
	    lblIcon[3] = lblIcon4;

	    for (int i = 0; i < 4; i++) {
	        lblName[i].setAlignmentX(Component.CENTER_ALIGNMENT);
	        lblMoney[i].setAlignmentX(Component.CENTER_ALIGNMENT);
	        
	        lblName[i].setFont(new Font("Arial", Font.BOLD, 24));
	        lblMoney[i].setFont(new Font("Arial", Font.PLAIN, 20));
	        
	        lblName[i].setBorder(BorderFactory.createEmptyBorder(4, 0, 4, 0));
	        lblMoney[i].setBorder(BorderFactory.createEmptyBorder(2, 0, 6, 0));
	    }

	    margin[0] = Box.createRigidArea(new Dimension(0, 10));
	    margin[1] = Box.createRigidArea(new Dimension(0, 10));
	    margin[2] = Box.createRigidArea(new Dimension(0, 10));

	    panelPlayersInfo.add(Box.createRigidArea(new Dimension(0, 15)));
	    
	    panelPlayersInfo.add(lblName[0]);
	    panelPlayersInfo.add(lblMoney[0]);
	    panelPlayersInfo.add(margin[0]);
	    
	    panelPlayersInfo.add(lblName[1]);
	    panelPlayersInfo.add(lblMoney[1]);
	    panelPlayersInfo.add(margin[1]);
	    
	    panelPlayersInfo.add(lblName[2]);
	    panelPlayersInfo.add(lblMoney[2]);
	    panelPlayersInfo.add(margin[2]);
	    
	    panelPlayersInfo.add(lblName[3]);
	    panelPlayersInfo.add(lblMoney[3]);

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
		panelLogs.add(scrollLogs, BorderLayout.CENTER);
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
	
	
	public  void updatePlayers(List<Player> playersList) {
		int players =  playersList.size();
		
		for (int i = 0; i < 4; i++) {
			boolean showInfo = (i < players);
			
			lblName[i].setVisible(showInfo);
			lblMoney[i].setVisible(showInfo);
			lblIcon[i].setVisible(showInfo);
			
			if (showInfo) {
				Player p = playersList.get(i);
				lblName[i].setText(p.getName());
				lblMoney[i].setText(p.getMoney() + " €");
			}
			
			if (i< 3) {
				margin[i].setVisible(i + 1 < players);
			}
		}
		
		panelPlayersInfo.revalidate();
		panelPlayersInfo.repaint();
		panelGame.revalidate();
		panelGame.repaint();
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
					        
					        if ((position - 1) >= 0 && (position - 1) < squaresBoard.length) {
					            squaresBoard[position - 1] = squarePanel;
					        }
					       
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

					        JPanel playerContainer = new JPanel(new GridBagLayout());
					        playerContainer.setOpaque(false); 

					        GridBagConstraints gbcContainer = new GridBagConstraints();
					        gbcContainer.fill = GridBagConstraints.BOTH;
					        gbcContainer.weightx = 1.0;
					        gbcContainer.weighty = 1.0;

					        for (int players = 0; players < 4; players++) {
					            JPanel playerPanel = new JPanel(new BorderLayout());
					            playerPanel.setOpaque(false); 
					            playerPanel.setPreferredSize(new Dimension(25, 25));

					            playersPosition[position - 1][players] = playerPanel;

					            gbcContainer.gridx = players % 2;
					            gbcContainer.gridy = players / 2;
					            
					            playerContainer.add(playerPanel, gbcContainer);
					        }
					        squarePanel.add(playerContainer, BorderLayout.CENTER);

					        JPanel panelPropertyName = new JPanel(new java.awt.GridLayout(2, 1));
					        panelPropertyName.setOpaque(false);

					        JLabel lblName = new JLabel(squareItem.getName(), JLabel.CENTER);
					        lblName.setFont(new Font("Arial", Font.BOLD, 9));
					        panelPropertyName.add(lblName);

					        if (squareItem.getPrice() > 0) {
					            JLabel lblPrice = new JLabel(squareItem.getPrice() + " €", JLabel.CENTER);
					            lblPrice.setFont(new Font("Arial", Font.BOLD, 9));
					            panelPropertyName.add(lblPrice);
					        }

					        squarePanel.add(panelPropertyName, BorderLayout.SOUTH);

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

	public void updatePlayersPosition(List<Player> playersList) {

	    for (int i = 0; i < playersList.size(); i++) {
	        if (lblIcon[i].getParent() != null) {
	            lblIcon[i].getParent().remove(lblIcon[i]);
	        }
	    }

	    for (int i = 0; i < playersList.size(); i++) {
	        Player p = playersList.get(i);
	        int position = p.getPosition();

	        int squareIndex = position - 1; 

	        if (squareIndex >= 0 && squareIndex < playersPosition.length) {
	            JPanel playerPanel = playersPosition[squareIndex][i];

	            if (playerPanel != null) {
	                lblIcon[i].setVisible(true);
	                lblIcon[i].setMinimumSize(new Dimension(30, 30));
	                lblIcon[i].setPreferredSize(new Dimension(30, 30));

	                playerPanel.add(lblIcon[i], BorderLayout.CENTER);
	            }
	        }
	    }

	    this.revalidate();
	    this.repaint();
	}


} 

