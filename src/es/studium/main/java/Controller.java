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

public class Controller implements ActionListener, MouseListener
{

	private Model m;
	private View v;
	private int currentTurn = 0;
	private Player currentPlayer;
	private boolean rolledDices = false;
	private int saveMovement = 0;

	private int players = 0;
	private List<Player> playersList = new ArrayList<>();
	private List<Ranking> rankingMoney = new ArrayList<>();
	private List<Ranking> rankingProperties= new ArrayList<>();
	
	private HashMap<Integer, Square> squares;
	private List<Card> communityDeck = new ArrayList<>();
	private List<Card> luckDeck = new ArrayList<>();
	private DialogsManager dialogs;

	private final int[][] board = { { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 },
					{ 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32 }, { 19, -1, -1, -1, -3, -1, -1, -1, -1, -1, 33 },
					{ 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34 }, { 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35 },
					{ 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36 }, { 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37 },
					{ 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38 }, { 13, -1, -1, -1, -2, -1, -1, -1, -1, -1, 39 },
					{ 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40 }, { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 } };

	public Controller(Model model, View v) {
		this.m = model;
		this.v = v;
		this.squares = m.getSquares();
		this.dialogs = new DialogsManager(v.getFrame(), this.squares);
		// SoundOption.musicLoop(v.getFrame(),
		// "/es/studium/main/resources/sound/happy.wav");

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

		// Panel Board Buttons
		this.v.getPanelBoard().btnDices.addActionListener(this);
		this.v.getPanelBoard().btnBuy.addActionListener(this);
		this.v.getPanelBoard().btnTurn.addActionListener(this);

		// DIalog jail

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();

		// — HOME —
		if (src.equals(v.getPanelHome().btnGame)) {
			v.showPanel("START");
			return;
		}
		if (src.equals(v.getPanelHome().btnExit)) {
			System.exit(0);
		}
		if (src.equals(v.getPanelHome().btnOptions)) {
			v.showPanel("OPTIONS");
			return;
		}
		if (src.equals(v.getPanelHome().btnHelp)) {
			v.showPanel("HELP");
			return;
		}

		if (src.equals(v.getPanelHome().btnRank)) {
			updateRanking();
			return;
		}

		// — START —
		if (src.equals(v.getPanelStart().choPlayers)) {
			selectPlayers();
			return;
		}
		if (src.equals(v.getPanelStart().btnBack)) {
			v.showPanel("HOME");
			return;
		}
		if (src.equals(v.getPanelStart().btnPlay)) {
			initializeBoard();
			v.getFrame().pack();
			v.getFrame().setLocationRelativeTo(null);
			return;
		}

		// — OPTIONS —
		if (src.equals(v.getPanelOptions().btnBack)) {
			v.previousPanel();
			return;
		}
		if (src.equals(v.getPanelOptions().btnConfirm)) {
			applyOptions();
			return;
		}

		// — HELP / RANK —
		if (src.equals(v.getPanelHelp().btnBack)) {
			v.showPanel("HOME");
			return;
		}
		if (src.equals(v.getPanelRank().btnBack)) {
			v.showPanel("HOME");
			return;
		}

		// — BOARD —
		if (src.equals(v.getPanelBoard().btnDices)) {
			movePlayer();
			return;

		}
		if (src.equals(v.getPanelBoard().btnBuy)) {
			checkCanBuy();
			return;
		}
		if (src.equals(v.getPanelBoard().btnTurn)) {
			turnEnd();
			return;
		}

		// — JAIL DIALOG —
		if ("JAIL_PAY".equals(e.getActionCommand())) {
			handleJailPay();
			return;
		}
		if ("JAIL_CARD".equals(e.getActionCommand())) {
			handleJailCard();
			return;
		}

		// Activate END GAME SCreen
		// v.showPanel("END");
		// v.getFrame().pack();
		// v.getFrame().setLocationRelativeTo(null);
	}

	private void applyOptions()
	{
		Checkbox selectedFont = v.getPanelOptions().chkTextF.getSelectedCheckbox();
		if (selectedFont != null ) {
			String newFont = selectedFont.getLabel();
			FontOption.changeFontFamily(v.getFrame(), newFont);
			v.getFrame().revalidate();
		}
		
		Checkbox selectedBackground = v.getPanelOptions().chkBoard.getSelectedCheckbox();
		if(selectedBackground != null) {
			String newBackground = selectedBackground.getLabel() + ".png";
			v.getPanelBoard().setBackgroundImage(newBackground);
		}
		v.showPanel("HOME");
	}

	private void handleJailPay()
	{
		currentPlayer.updateMoney(-50);
		currentPlayer.setPrison(false);
		currentPlayer.setJailTurns(0);
		dialogs.hideDialogsInfo();
		v.getPanelBoard().updatePlayers(playersList);
		executeSaveMovement();
	}

	private void handleJailCard()
	{
		currentPlayer.setJailCards(currentPlayer.getJailCards() - 1);
		currentPlayer.setPrison(false);
		currentPlayer.setJailTurns(0);
		dialogs.hideDialogsInfo();
		executeSaveMovement();
	}

	private void checkCanBuy()
	{
		if (!rolledDices) {
			v.showDialog("¡You have to roll the dices first");
			return;
		}
		
		Square currentSquare = squares.get(currentPlayer.getPosition());

		if (currentSquare == null) return;
		
		String type = currentSquare.getType().toUpperCase();
		
		boolean isBuyable = type.equals("PROPIEDAD") || type.equals("ESTACION") || type.equals("SERVICIO");
		
		if (!isBuyable) {
	        v.showDialog("This place is not buyable.");
	        return;
	    }
		
		if (!currentSquare.hasOwner()) {
	        boolean bought = TurnManager.buyProperty(currentPlayer, currentSquare);
	        if (bought) {
	            v.getPanelBoard().updatePlayers(playersList);
	            updateLogs();
	            v.showDialog(currentPlayer.getName() + " ha comprado " + currentSquare.getName());
	        } else {
	            v.showDialog("No tienes suficiente dinero para comprar esta propiedad.");
	        }
	    }
		
		else if (currentSquare.getOwner().equals(currentPlayer.getName())) {
	        
	        if (!type.equals("PROPIEDAD")) {
	            v.showDialog("No puedes edificar casas en Estaciones o Servicios.");
	            return;
	        }
	        
	        if (currentSquare.hasHotel()) {
				v.showDialog("¡Ya has construido un Hotel aquí! No se puede edificar más.");
				return;
			}

	        int buildPrice = 50; 

	        if (currentPlayer.getMoney() < buildPrice) {
				v.showDialog("No tienes suficiente dinero para edificar (Coste: " + buildPrice + "€).");
				return;
			}

			currentPlayer.updateMoney(-buildPrice);
			currentSquare.buildHouse();
			
			if (currentSquare.hasHotel()) {
				Logger.saveLog(currentPlayer.getName() + " upgraded to a HOTEL in " + currentSquare.getName() + " for " + buildPrice + "€.", currentPlayer.getColor());
				v.showDialog("¡" + currentPlayer.getName() + " ha construido un HOTEL en " + currentSquare.getName() + "!");
			} else {
				Logger.saveLog(currentPlayer.getName() + " built house nº " + currentSquare.getHouses() + " in " + currentSquare.getName() + " for " + buildPrice + "€.", currentPlayer.getColor());
				v.showDialog(currentPlayer.getName() + " ha edificado la casa nº " + currentSquare.getHouses() + " en " + currentSquare.getName());
			}
			
			v.getPanelBoard().updatePlayers(playersList);
			updateLogs();
		} 
	
		else {
			v.showDialog("Esta propiedad pertenece a " + currentSquare.getOwner() + ". ¡Ya has pagado el alquiler de tu turno!");
		}
	}
	
	private void updateRanking() {
		rankingMoney = m.getRankingMoney();
	    rankingProperties = m.getRankingProperties();


	    for (int i = 0; i < rankingMoney.size(); i++) {
	        Ranking ranking = rankingMoney.get(i);
	        
	        v.getPanelRank().getLblMoneyName()[i].setText(ranking.getName());
	        v.getPanelRank().getLblMoney()[i].setText(""+ranking.getMoney());
	        // Could add visible true
	    }

	    for (int i = 0; i < rankingProperties.size(); i++) {
	        Ranking ranking = rankingProperties.get(i);
	        
	        v.getPanelRank().getLblPropertiesName()[i].setText(ranking.getName());
	        v.getPanelRank().getLblHouses()[i].setText(""+ranking.getHouses());
	        v.getPanelRank().getLblHotels()[i].setText(""+ranking.getHotels());
	    }
	    v.showPanel("RANKING");
	}

	private int rollDices()
	{
		int[] sumDices = m.throwingDices();
		int dice1 = sumDices[0];
		int dice2 = sumDices[1];
		dialogs.showDiceInfo(sumDices, currentPlayer.getName());
	
		return dice1+dice2;
	}
	
	private void updateLogs() {
		List<Logger.LogEntry> newLogs = Logger.readAndEmpty();
	    for (Logger.LogEntry entry : newLogs) {
	        v.getPanelBoard().writeLogs(entry.text, entry.color);
	    }
	}

	private void movePlayer()
	{
		if (rolledDices)
			return;

		currentPlayer = getPlayerById(currentTurn);

		if (currentPlayer.getPrison()) {
			saveMovement = rollDices();
			boolean isDouble = m.isDouble();
			boolean staysInJail = TurnManager.handleJailRoll(currentPlayer, isDouble);
			if (!staysInJail) {
				executeSaveMovement();
				updateLogs();
				return;
			}

			JailInfo jailWindow = this.dialogs.prepareJailInfo(currentPlayer);
			jailWindow.btnPay.addActionListener(this);
			jailWindow.btnCard.addActionListener(this);
			this.dialogs.showJailInfo();
			updateLogs();
			return;
		}

		saveMovement = rollDices();
		rolledDices = true;
		boolean isDouble = m.isDouble();
		
		Logger.saveLog(currentPlayer.getName() + " rolled the dices and got " + saveMovement + ".", currentPlayer.getColor());

		rolledDices = TurnManager.movementToSquare(currentPlayer, saveMovement, isDouble, squares, playersList, this);
		v.getPanelBoard().updatePlayersPosition(playersList);
		v.getPanelBoard().updatePlayers(playersList);
		
		if (currentPlayer.getMoney() < 0) {
			v.showDialog("¡" + currentPlayer.getName() + " get eliminated!");
			Logger.saveLog("¡" + currentPlayer.getName() + " GOT BANKRRUPT AND IS ELIMINATED!", currentPlayer.getColor());

			for (Square property : currentPlayer.getProperties()) {
				property.releaseProperty();
			}

			currentPlayer.getProperties().clear();
			playersList.remove(currentPlayer); 

			if (playersList.size() == 1) {
				endGame(playersList.get(0));
				return;
			}
			
			nextTurn();
		}
		
		v.getPanelBoard().updatePlayersPosition(playersList);
		v.getPanelBoard().updatePlayers(playersList);
		updateLogs();
	
	}
		
	private void endGame(Player player) {
		int houses = player.getTotalHouses();
		int hotels = player.getTotalHotels();
		int totalProperties = player.getProperties().size();
		v.getPanelEnd().setWinner(player.getName(), player.getMoney(), totalProperties,  houses, hotels);
		v.showPanel("END");
		resetGame();
	}
	
	private void resetGame() {
		playersList.clear();
	    rankingMoney.clear();
	    rankingProperties.clear();
	    
	    luckDeck.clear();
	    communityDeck.clear();
	    currentTurn = 1;
	    currentPlayer = null;
	    rolledDices = false;
	    saveMovement = 0;
	    players = 0;
	}

	private void executeSaveMovement()
	{
		rolledDices = true;
		TurnManager.movementToSquare(currentPlayer, saveMovement, false, squares, playersList, this);
		v.getPanelBoard().updatePlayersPosition(playersList);
		v.getPanelBoard().updatePlayers(playersList);

	}

	private void turnEnd()
	{
		if (!rolledDices) {
			return;
		}
		nextTurn();
		
	}
	
	private void nextTurn() {
		rolledDices = false;
		boolean found = false;
		
		while (!found) {
			currentTurn++;
			if (currentTurn > players) {
				currentTurn = 1;
			}
			Player nextPlayer = getPlayerById(currentTurn);
			

			if (nextPlayer != null) {
				currentPlayer = nextPlayer;
				found = true;
			}
		}
		
		v.getPanelBoard().lblTurn.setText(currentPlayer.getName() + " has the turn");
	}

	private void selectPlayers()
	{
		String selection = v.getPanelStart().choPlayers.getSelectedItem().toString();

		switch (selection) {
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

	private void startGame()
	{
		playersList.clear();

		Color[] colors = {
		        new Color(220, 53, 69),
		        new Color(0, 123, 255),
		        new Color(40, 167, 69),
		        new Color(253, 126, 20)
		    };
		
		for (int i = 1; i <= players; i++) {
			String playerName = "";
			if (i == 1) {
				playerName = v.getPanelStart().getTxtPlayer1().getText().trim();
			} else if (i == 2) {
				playerName = v.getPanelStart().getTxtPlayer2().getText().trim();
			} else if (i == 3) {
				playerName = v.getPanelStart().getTxtPlayer3().getText().trim();
			} else if (i == 4) {
				playerName = v.getPanelStart().getTxtPlayer4().getText().trim();
			}

			if (playerName.isEmpty()) {
				playerName = "Player " + i;
			}

			Color colorPlayer = colors[i-1];
			
			Player newPlayer = new Player(i, playerName, 500, colorPlayer);
			playersList.add(newPlayer);
		}
		v.getPanelBoard().updatePlayers(playersList);
		v.getPanelBoard().updatePlayersPosition(playersList);
		currentTurn = 1;
		currentPlayer = getPlayerById(currentTurn);
		v.getPanelBoard().lblTurn.setText(currentPlayer.getName() + " has the turn");
		v.showPanel("BOARD");
	}
	
	private Player getPlayerById(int id) {
		for (Player p : playersList) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	private void initializeBoard()
	{
		squares = m.getSquares();
		v.getPanelBoard().createBoard(board, squares);
		squaresListeners();
		labelsListeners();
		shuffleCards();
		startGame();
	}

	private void squaresListeners()
	{
		JPanel[] squaresBoard = v.getPanelBoard().getSquaresBoard();

		for (int i = 0; i < squaresBoard.length; i++) {
			JPanel squarePanel = squaresBoard[i];

			if (squarePanel != null) {
				squarePanel.setName(String.valueOf(i + 1));
				squarePanel.addMouseListener(this);
			}
		}
	}

	private void labelsListeners()
	{
		JLabel[] labels = v.getPanelBoard().getPlayerLbls();

		for (int i = 0; i < labels.length; i++) {
			JLabel lblPlayer = labels[i];
			if (lblPlayer != null) {
				lblPlayer.setName(String.valueOf(i));
				lblPlayer.addMouseListener(this);
			}
		}

	}

	private void shuffleCards()
	{
		List<Card> cardsDeck = m.getCards();

		for (Card card : cardsDeck) {

			if(("SUERTE").equalsIgnoreCase(card.getType())){
				luckDeck.add(card);
			}
			else if(("COMUNIDAD").equalsIgnoreCase(card.getType())) {


				communityDeck.add(card);
			}
		}
		Collections.shuffle(luckDeck);
		Collections.shuffle(communityDeck);
	
	}

	public void drawCard(String type)
	{
		Card obtainedCard = null;
		if(("SUERTE").equalsIgnoreCase(type)){
			if(!luckDeck.isEmpty()){
				obtainedCard = luckDeck.remove(0);
			}
		}
		else if (("COMUNIDAD").equalsIgnoreCase(type)){
			if(!communityDeck.isEmpty()) {
				obtainedCard = communityDeck.remove(0);
			}
		}
		
		if (obtainedCard!= null) {
			applyCard(obtainedCard);
			if (!"SALIR_CARCEL".equalsIgnoreCase(obtainedCard.getAction())) {
				
				if (("SUERTE").equalsIgnoreCase(type)) {
					luckDeck.add(obtainedCard);
					Collections.shuffle(luckDeck);
				} 
				else if (("COMUNIDAD").equalsIgnoreCase(type)) {
					communityDeck.add(obtainedCard); 
					Collections.shuffle(communityDeck);
				}
			}

			dialogs.showCardInfo(obtainedCard);
		
		}
	}
	
	private void applyCard(Card card) {
		if(card == null) return;
		
		String action = card.getAction().toUpperCase();
		int value = card.getValue();
		int position = card.getDestination();
		
		switch (action) {
		case "COBRAR":
			currentPlayer.updateMoney(value);
			break;
		case "PAGAR":
			currentPlayer.updateMoney(-value);
			break;
		case "MOVER":
			currentPlayer.setPosition(position);
			if (card.getText().contains("200€") && (currentPlayer.getPosition()>position)) {
				currentPlayer.updateMoney(value);
			}
			Square square = squares.get(currentPlayer.getPosition());
			if (square != null) {
				TurnManager.squareEvents(currentPlayer, square, squares, playersList, this);
			}
			break;
		case "MOVER_ATRAS":
			int playerPosition = currentPlayer.getPosition();
			int newPosition = playerPosition - value;
			if (newPosition <= 0) {
				newPosition = 40 + newPosition;
			}
			currentPlayer.setPosition(newPosition);
			Square tile = squares.get(newPosition);
			if (tile != null) {
				TurnManager.squareEvents(currentPlayer, tile, squares, playersList, this);
			}
			break;
		case "IR_A_CARCEL":
			currentPlayer.setPrison(true);
			currentPlayer.setPosition(11);
			currentPlayer.setJailTurns(0);
			currentPlayer.setDoublesDices(0);
		case "SALIR_CARCEL":
			currentPlayer.setJailCards(currentPlayer.getJailCards() + 1);
			break;
		case "CUMPLEANOS":
			int collectedMoney = 0;
			for (Player p : playersList) {
				if (p.getId() != currentPlayer.getId()) {
					p.updateMoney(-value);
					collectedMoney += value;
				}
			}
			currentPlayer.updateMoney(collectedMoney);
			break;
		case "REPARAR_CASAS":
			int priceHouse = value;
			int priceHotel = value * 4;
			
			int totalPriceHouses = currentPlayer.getTotalHouses() * priceHouse;
			int totalPriceHotels = currentPlayer.getTotalHotels() * priceHotel;
			int total = totalPriceHouses + totalPriceHotels;
			
			currentPlayer.updateMoney(-total);
			
			break;
		default:
			System.err.println("Carta desconocida");
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (e.getSource() instanceof JTextField) {
			JTextField txtClicked = (JTextField) e.getSource();
			txtClicked.setText("");
			txtClicked.setFont(txtClicked.getFont().deriveFont(Font.BOLD));
			txtClicked.setForeground(Color.BLACK);
		} else if (e.getSource() instanceof JPanel) {
			JPanel panelClicked = (JPanel) e.getSource();
			if (panelClicked.getName() != null) {
				try {
					int position = Integer.parseInt(panelClicked.getName());

					if (position >= 1 && position <= 40) {
						Square square = squares.get(position);

						if (square != null && (square.getType().equals("PROPIEDAD")
								|| square.getType().equals("ESTACION") || square.getType().equals("SERVICIO"))) {

							dialogs.showPropertyInfo(square);
							;
						}
					}
				} catch (NumberFormatException nfe) {
					System.out.println("Empty Panel");
				}

			}
		} else if (e.getSource().equals(v.getPanelBoard().getPlayerLbl1())) {
			dialogs.showPlayerInfo(playersList.get(0));
		} else if (e.getSource().equals(v.getPanelBoard().getPlayerLbl2())) {
			dialogs.showPlayerInfo(playersList.get(1));
		} else if (e.getSource().equals(v.getPanelBoard().getPlayerLbl3())) {
			dialogs.showPlayerInfo(playersList.get(2));
		} else if (e.getSource().equals(v.getPanelBoard().getPlayerLbl4())) {
			dialogs.showPlayerInfo(playersList.get(3));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

}