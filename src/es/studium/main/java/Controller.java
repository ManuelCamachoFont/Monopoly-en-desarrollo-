package es.studium.main.java;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Controller implements ActionListener{

	private Model m;
	private View v;
	private int players;
	private List<Player> playersList = new ArrayList<>();;
	private HashMap<Integer, Square> squaresMap;
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
	        	players = 2; 
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
		
		v.showPanel("BOARD");
	}
	
	private void initializeBoard() {
		HashMap<Integer, Square> squares = m.getSquares();
		v.getPanelBoard().createBoard(board, squares);
	}

}
