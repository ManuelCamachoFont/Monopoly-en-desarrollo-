package es.studium.main.java;


import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Controller implements ActionListener, MouseListener{

	private Model m;
	private View v;
	private int currentTurn = 0;
	private Player currentPlayer;
	private boolean rolledDices = false;
	private int players = 0;
	private List<Player> playersList = new ArrayList<>();
	private HashMap<Integer, Square> squares;
	private List<Card> communityDeck = new ArrayList<>();
	private List<Card> luckDeck = new ArrayList<>();
	private DialogsInfo dialogs;


	private final int[][] board = {
			{21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31},
			{20, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32},
			{19, -1, -1, -1, -3, -1, -1, -1, -1, -1, 33},
			{18, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34},
			{17, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35},
			{16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36},
			{15, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37},
			{14, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38},
			{13, -1, -1, -1, -2, -1, -1, -1, -1, -1, 39},
			{12, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40},
			{11, 10,  9,  8,  7,  6,  5,  4,  3,  2,  1}
	};

	public Controller(Model model, View v) {
		this.m = model;
		this.v = v;
		this.squares = m.getSquares();
		this.dialogs = new DialogsInfo(v.getFrame(), this.squares);
		SoundOption.musicLoop(v.getFrame(), "/es/studium/main/resources/sound/happy.wav");

		// Panel Home Buttons
		this.v.getPanelHome().btnGame.addActionListener(this);
		this.v.getPanelHome().btnExit.addActionListener(this);
		this.v.getPanelHome().btnOptions.addActionListener(this);
		this.v.getPanelHome().btnHelp.addActionListener(this);
		this.v.getPanelHome().btnRank.addActionListener(this);

		// Panel Options Buttons
		this.v.getPanelOptions().btnBack.addActionListener(this);
		this.v.getPanelOptions().btnConfirm.addActionListener(this);

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
		
		//Panel Board Buttons
		this.v.getPanelBoard().btnDices.addActionListener(this);
		this.v.getPanelBoard().btnBuy.addActionListener(this);
		this.v.getPanelBoard().btnTurn.addActionListener(this);
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
			initializeBoard();
			v.getFrame().pack();
			v.getFrame().setLocationRelativeTo(null);
		}

		// Panel Options actions
		else if (e.getSource().equals(v.getPanelOptions().btnBack)) {
			v.previousPanel();
		}
		else if (e.getSource().equals(v.getPanelOptions().btnConfirm)) {

			Checkbox selectedFont = v.getPanelOptions().chkTextF.getSelectedCheckbox();
			if (selectedFont != null ) {
				String newFont = selectedFont.getLabel();
				FontOption.changeFontFamily(v.getFrame(), newFont);
				v.getFrame().revalidate();
				System.out.println(newFont);
			}
			
			v.showPanel("HOME");
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
		
		// Panel Board actions
		else if(e.getSource().equals(v.getPanelBoard().btnDices)) {
			
			movePlayer();
			

			
			
		}
		
		else if (e.getSource().equals(v.getPanelBoard().btnBuy)) {
			
		}
		else if (e.getSource().equals(v.getPanelBoard().btnTurn)) {
			turnEnd();
		}

		// Activate END GAME SCreen
		//	v.showPanel("END");
		//	v.getFrame().pack();
		//	v.getFrame().setLocationRelativeTo(null);


	}
	
	private int rollDices()
	{
		DiceInfo dialog = new DiceInfo(v.getFrame(),10);
		int sumDices = m.throwingDices();
		dialog.resultDice.setText(""+ sumDices);
		dialog.resultDice.setVisible(true);
		return sumDices;
	}
	
	private void movePlayer() {
		if (rolledDices) {
			return;
		}
	 currentPlayer = playersList.get(currentTurn);
	 int movement = rollDices();
	 int newPosition = currentPlayer.getPosition() + movement;
	 
	 if (newPosition > 40) {
		 newPosition = newPosition - 40;
		 currentPlayer.updateMoney(200);
	 }
	 
	 currentPlayer.setPosition(newPosition);
	 rolledDices = true;
	 
	 v.getPanelBoard().updatePlayersPosition(playersList);
	 
	 squareEvent(newPosition, currentPlayer);
	 
	}
	
	private void squareEvent(int position, Player player) {
		Square square = squares.get(position);
		if (square == null) {
			return;
		}
		// Switch tipo de casillas
	}
	
	private void turnEnd(){
		if(!rolledDices) {
			return;
		}
		currentTurn++;
		if (currentTurn>= playersList.size()){
			currentTurn = 0;
		}
		rolledDices = false;
		v.getPanelBoard().lblTurn.setText(currentPlayer.getName() + " has the turn");
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
		v.getPanelBoard().updatePlayersPosition(playersList);
		currentTurn = 0;
		currentPlayer = playersList.get(currentTurn);
		v.getPanelBoard().lblTurn.setText(currentPlayer.getName() + " has the turn");

		v.showPanel("BOARD");
	}


	private void initializeBoard() {
		squares = m.getSquares();
		v.getPanelBoard().createBoard(board, squares);
		squaresListeners();
		labelsListeners();
		shuffleCards();
		startGame();
	}

	private void squaresListeners() {
		JPanel[] squaresBoard = v.getPanelBoard().getSquaresBoard(); 

		for (int i = 0; i < squaresBoard.length; i++) {
			JPanel squarePanel = squaresBoard[i];

			if (squarePanel != null) {
				squarePanel.setName(String.valueOf(i + 1));
				squarePanel.addMouseListener(this);
			}
		}
	}

	private void labelsListeners() {
		JLabel[] labels = v.getPanelBoard().getPlayerLbls();

		for(int i = 0; i < labels.length; i++) {
			JLabel lblPlayer = labels[i];
			if (lblPlayer != null) {
				lblPlayer.setName(String.valueOf(i));
				lblPlayer.addMouseListener(this);
			}
		}


	}
	
	
	private void shuffleCards() {
		List<Card> cardsDeck = m.getCards();

		for (Card card : cardsDeck) {
			if(("LUCK").equalsIgnoreCase(card.getType())){
				luckDeck.add(card);
			}
			else if(("COMMUNITY").equalsIgnoreCase(card.getType())) {
				communityDeck.add(card);
			}
		}
		Collections.shuffle(luckDeck);
		Collections.shuffle(communityDeck);
	}

	private void drawCard(String type) {
		Card obtainedCard = null;
		if(("LUCK").equalsIgnoreCase(type)){
			if(!luckDeck.isEmpty()){
				obtainedCard = luckDeck.remove(0);
			}
		}
		else if (("COMMUNITY").equalsIgnoreCase(type)){
			if(!communityDeck.isEmpty()) {
				obtainedCard = communityDeck.remove(0);
			}
		}
		CardInfo.showInfo(v.getFrame(), obtainedCard);
	}

	@Override
	public void mouseClicked(MouseEvent e) {


	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof JTextField) {
			JTextField txtClicked = (JTextField) e.getSource();       
			txtClicked.setText("");
			txtClicked.setFont(new Font("Arial", Font.BOLD, 12));
			txtClicked.setForeground(Color.BLACK);
		}
		else if (e.getSource() instanceof JPanel) {
			JPanel panelClicked = (JPanel) e.getSource();
			if (panelClicked.getName() != null) {
				try {
					int position = Integer.parseInt(panelClicked.getName());

					if (position >= 1 && position <= 40) {
						Square square = squares.get(position);

						if (square != null && (square.getType().equals("PROPIEDAD") || 
								square.getType().equals("ESTACION") || 
								square.getType().equals("SERVICIO"))) {


							dialogs.showPropertyInfo(square);;
						}
					}
				} catch (NumberFormatException nfe) {
					System.out.println("Empty Panel");
				}

			}
		}
		else if (e.getSource().equals(v.getPanelBoard().getPlayerLbl1())){
			dialogs.showPlayerInfo(playersList.get(0));
		}
		else if (e.getSource().equals(v.getPanelBoard().getPlayerLbl2())){
			dialogs.showPlayerInfo(playersList.get(1));
		}
		else if (e.getSource().equals(v.getPanelBoard().getPlayerLbl3())){
			dialogs.showPlayerInfo(playersList.get(2));
		}
		else if (e.getSource().equals(v.getPanelBoard().getPlayerLbl4())){
			dialogs.showPlayerInfo(playersList.get(3));
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
