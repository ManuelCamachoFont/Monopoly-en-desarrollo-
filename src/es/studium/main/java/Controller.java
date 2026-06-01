package es.studium.main.java;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTextField;


public class Controller implements ActionListener, MouseListener{

	private Model m;
	private View v;
	private int players;
	private List<Player> playersList = new ArrayList<>();
	private HashMap<Integer, Square> squares;
	private List<Card> cardsList;
	

	private final int[][] board = {
		    {21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31},
		    {20, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32},
		    {19, -1, -1, -1, -3, -1, -1, -1, -1, -1, 33},
		    {18, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34},
		    {17, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35},
		    {16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36},
		    {14, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37},
		    {14, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38},
		    {13, -1, -1, -1, -2, -1, -1, -1, -1, -1, 39},
		    {12, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40},
		    {11, 10,  9,  8,  7,  6,  5,  4,  3,  2,  1}
		};

	public Controller(Model model, View v) {
		this.m = model;
		this.v = v;

		// Panel Home Buttons
		this.v.getPanelHome().btnGame.addActionListener(this);
		this.v.getPanelHome().btnExit.addActionListener(this);
		this.v.getPanelHome().btnOptions.addActionListener(this);
		this.v.getPanelHome().btnHelp.addActionListener(this);
		this.v.getPanelHome().btnRank.addActionListener(this);

		// Panel Options Buttons
		this.v.getPanelOptions().btnBack.addActionListener(this);

		// Panel Start Buttons
		this.v.getPanelStart().choPlayers.addActionListener(this);
		this.v.getPanelStart().btnBack.addActionListener(this);
		this.v.getPanelStart().btnPlay.addActionListener(this);
		
		this.v.getPanelStart().getTxtPlayer1().addMouseListener(this);
		this.v.getPanelStart().getTxtPlayer2().addMouseListener(this);
		this.v.getPanelStart().getTxtPlayer3().addMouseListener(this);
		this.v.getPanelStart().getTxtPlayer4().addMouseListener(this);
		
		// Panel Help Buttons
		this.v.getPanelHelp().btnBack.addActionListener(this);
		this.v.getPanelHelp().btnMHelp.addActionListener(this);
		
		// Panel Ranking Buttons
		this.v.getPanelRank().btnBack.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Panel Home actions
		if (e.getSource().equals(v.getPanelHome().btnGame)) {
			v.showPanel("START");
		}
		else if (e.getSource().equals(v.getPanelHome().btnExit)) {
			System.exit(0);
		}
		else if (e.getSource().equals(v.getPanelHome().btnOptions)) {
			v.showPanel("OPTIONS");
		}
		else if (e.getSource().equals(v.getPanelHome().btnHelp)) {
			v.showPanel("HELP");
		}
		else if (e.getSource().equals(v.getPanelHome().btnRank)) {
			v.showPanel("RANKING");
		}
		
		// Panel Start actions
		else if (e.getSource().equals(v.getPanelStart().choPlayers)) {
			selectPlayers();
		}
		else if (e.getSource().equals(v.getPanelStart().btnBack)) {
			v.showPanel("HOME");
		}
		else if (e.getSource().equals(v.getPanelStart().btnPlay)) {
			// Check player name != Player X AND != isEmpty
			//m.addPlayer();
			initializeBoard();
			startGame();
			v.getFrame().pack();
			v.getFrame().setLocationRelativeTo(null);
		}
		
		// Panel Options actions
		else if (e.getSource().equals(v.getPanelOptions().btnBack)) {
			v.previousPanel();
		}
		else if (e.getSource().equals(v.getPanelOptions().btnConfirm)) {

		}
		
		// Panel Help actions
		else if(e.getSource().equals(v.getPanelHelp().btnBack)){
			v.showPanel("HOME");
		}
		else if (e.getSource().equals(v.getPanelHelp().btnMHelp)) {
			// Open htlm with rules
		}
		
		// Panel Rank actions
		else if(e.getSource().equals(v.getPanelRank().btnBack)) {
			v.showPanel("HOME");
		}
		
		// Activate END GAME SCreen
		//	v.showPanel("END");
		//	v.getFrame().pack();
		//	v.getFrame().setLocationRelativeTo(null);


	}

	private void selectPlayers() {

	    String selection = v.getPanelStart().choPlayers.getSelectedItem().toString();

	    players = 0;
	    switch(selection) {
	        case "2 Players": 
	        	players = 2; 
	        	break;
	        case "3 Players": 
	        	players = 3; 
	        	break;
	        case "4 Players": 
	        	players = 4; 
	        	break;
	        default:          
	        	players = 0; 
	        	break;
	    }

	    v.getPanelStart().updatePlayers(players);
	}
	
	private void startGame() {
		playersList.clear();
		
		for (int i = 1; i <= players; i++) {
			String playerName = "";
			if (i == 1) {
				playerName = v.getPanelStart().getTxtPlayer1().getText().trim();
			}
			else if (i == 2) {
				playerName = v.getPanelStart().getTxtPlayer2().getText().trim();
			}
			else if (i == 3) {
				playerName = v.getPanelStart().getTxtPlayer3().getText().trim();
			}
			else if (i == 4) {
				playerName = v.getPanelStart().getTxtPlayer4().getText().trim();
			}
			
			if (playerName.isEmpty()) {
				playerName = "Player " + i;
	        }
			
			Player newPlayer = new Player(playerName, 500);
			playersList.add(newPlayer);
		}
		v.getPanelBoard().updatePlayers(playersList);
		v.getPanelBoard().updatePlayersPosition(playersList);
		
		v.showPanel("BOARD");
	}

	
	private void initializeBoard() {
		HashMap<Integer, Square> squares = m.getSquares();
		v.getPanelBoard().createBoard(board, squares);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof JTextField) {
	       JTextField txtPulsado = (JTextField) e.getSource();       
	       txtPulsado.setText("");
	       txtPulsado.setFont(new Font("Arial", Font.BOLD, 12));
	       txtPulsado.setForeground(Color.BLACK);
	    }
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
