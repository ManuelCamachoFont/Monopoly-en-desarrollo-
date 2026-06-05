
package es.studium.main.java;

import java.util.HashMap;
import java.util.List;

public class TurnManager{


//	public static boolean jailCheckOptions(Player player)
//	{
//		if (!player.getPrison()) return false;
//		//===================IMPORTANTE========================0
//		//Esto me lo ha hecho la IA, hay que cambiarlo por los botones que tu has hecho en el dialogo
//		
//		ArrayList<String> opciones = new ArrayList<>();
//		opciones.add("Tirar dados (Buscar dobles)");
//		
//		if (player.getMoney() >= 50) {
//			opciones.add("Pagar fianza (50€)");
//		}
//		if (player.getJailCards() > 0) {
//			opciones.add("Usar tarjeta 'Quedas libre'");
//		}
//
//		String[] ops = opciones.toArray(new String[0]);
//		int seleccion = JOptionPane.showOptionDialog(
//			null,
//			player.getName() + " está en la cárcel. Selecciona cómo proceder:",
//			"Turno en la Cárcel",
//			JOptionPane.DEFAULT_OPTION,
//			JOptionPane.QUESTION_MESSAGE,
//			null, ops, ops[0]
//		);
//
//		if (seleccion == -1) seleccion = 0; // Si cierra la ventana, por defecto tira dados
//
//		String eleccion = ops[seleccion];
//
//		if (eleccion.equals("Pagar fianza (50€)")) {
//			player.updateMoney(-50);
//			player.setPrison(false);
//			player.setJailTurns(0);
//			JOptionPane.showMessageDialog(null, player.getName() + " pagó 50€ y sale de la cárcel.");
//			return false; 
//		} 
//		else if (eleccion.equals("Usar tarjeta 'Quedas libre'")) {
//			player.setJailCards(player.getJailCards() - 1);
//			player.setPrison(false);
//			player.setJailTurns(0);
//			JOptionPane.showMessageDialog(null, player.getName() + " usó la tarjeta y sale de la cárcel.");
//			return false;
//		}
//
//		return true; 
//	}

	public static boolean handleJailRoll(Player player, boolean isDouble) {
	    if (isDouble) {
	        player.setPrison(false);
	        player.setJailTurns(0);
	        Logger.saveLog(player.getName() + " rolled double and got out of Prison.", player.getColor());
	        return false;
	    }
	    int turns = player.getJailTurns() + 1;
	    player.setJailTurns(turns);
	    Logger.saveLog(player.getName() + " didn't roll doubles. (Try " + turns + "/3.)", player.getColor());
	    if (turns >= 3) {
	        player.setPrison(false);
	        player.setJailTurns(0);
	        Logger.saveLog(player.getName() + " got released after 3 turns and is now free.", player.getColor());
	    }
	    return true;
	}
	public static boolean movementToSquare(Player player, int movement, boolean isDouble, HashMap<Integer, Square> squares, List<Player> playersList, Controller controller)
	{
		if(isDouble) {
			int consecutiveDoubles = player.getDoublesDices()+1;
			player.setDoublesDices(consecutiveDoubles);
			
			if(consecutiveDoubles >= 3) {
				player.setDoublesDices(0);
				goToJail(player);
				return !isDouble;
			}
			Logger.saveLog("¡" + player.getName() + " rolled DOUBLES", player.getColor());
		} else {
			player.setDoublesDices(0);
		}
		int newPosition = player.getPosition() + movement;
		if (newPosition > 40) {
			newPosition = newPosition - 40;
			player.updateMoney(200);
			Logger.saveLog("Bank gives 200€ to " + player.getName() + " after a full lap.", player.getColor());
		}
		player.setPosition(newPosition);

		Square square = squares.get(newPosition);
		if (square != null) {
			Logger.saveLog(player.getName() + " moves to " + square.getName() + ".", player.getColor());
			squareEvents(player, square, squares, playersList, controller, movement);
		}
		return !isDouble;
	}

	public static void squareEvents(Player player, Square square, HashMap<Integer, Square> allSquares,
			List<Player> playersList, Controller controller, int diceRoll)
	{
		String type = square.getType().toUpperCase();

		switch (type) {
		case ("PROPIEDAD"):
		case ("ESTACION"):
		case ("SERVICIO"):
			propertySquare(player, square, allSquares, playersList, diceRoll);
			break;
		case "IMPUESTO":
			taxSquare(player, square);
			break;
		case "ESPECIAL":
			if (square.getName().equals("Ir a la Cárcel"))
				goToJail(player);
			break;
		case "SUERTE":
			controller.drawCard("SUERTE");
			break;
		case "COMUNIDAD":
			controller.drawCard("COMUNIDAD");
			break;
		default:
			System.out.println("Casilla sin acción especial (Salida, Parking, visita al a cárcel...).");
			break;
		}
	}

	private static void taxSquare(Player player, Square square)
	{
		int tax = square.getPrice();
		player.updateMoney(-tax);
		System.out.println(player.getName() + "pagó" + tax);

	}

	private static void goToJail(Player player)
	{
		player.setPrison(true);
		player.setPosition(11);
		player.setJailTurns(0);
		player.setDoublesDices(0);
		System.out.println(player.getName() + "va a la cárcel");

	}

	private static void propertySquare(Player player, Square square, HashMap<Integer, Square> allSquares, List<Player> playersList, int diceRoll)
	{
		String currentOwner = square.getOwner();

		if (currentOwner != null && !currentOwner.isEmpty()) {
			
			if (!currentOwner.equals(player.getName())) {
				int rentToPay = calculateRent(square, allSquares, diceRoll);
				player.updateMoney(-rentToPay);
				
				for (Player owner : playersList) {
					if (owner.getName().equals(currentOwner)) {
						owner.updateMoney(rentToPay);
						Logger.saveLog(player.getName() + " pays " + rentToPay + "€ of rent/tariff to " + owner.getName() + ".", player.getColor());
					}
				}
			}
		}
	}
	
	public static boolean hasMonopoly(Player player, Square currentSquare, HashMap<Integer, Square> allSquares) {
	
		if (player == null || currentSquare == null || allSquares == null || player.getProperties() == null) {
			return false;
		}

		int targetGroup = currentSquare.getGroup();
		

		if (targetGroup <= 0) {
			return false;
		}


		int totalSquaresInGroup = 0;
		for (Square s : allSquares.values()) {

			if (s != null && s.getGroup() == targetGroup) {
				totalSquaresInGroup++;
			}
		}

		int playerSquaresInGroup = 0;
		for (Square s : player.getProperties()) {
			if (s != null && s.getGroup() == targetGroup) {
				playerSquaresInGroup++;
			}
		}

		return playerSquaresInGroup == totalSquaresInGroup;
	}

	public static boolean buyProperty(Player player, Square square)
	{
		String type = square.getType();
		if (!type.toUpperCase().equals("PROPIEDAD") && !type.toUpperCase().equals("ESTACION") && !type.toUpperCase().equals("SERVICIO")) return false;
		if (square.hasOwner()) return false;
		if (player.getMoney() < square.getPrice()) return false;
		
		player.updateMoney(-square.getPrice());
		square.setOwner(player.getName());
		player.getProperties().add(square);
		Logger.saveLog(player.getName() + " bought " + square.getName() + " for " + square.getPrice() + "€.", player.getColor());
		return true;
	}

	private static int calculateRent(Square square, HashMap<Integer, Square> allSquares, int diceRoll)
	{
		String type = square.getType().toUpperCase();
		String ownerName = square.getOwner();
		int rent = square.getRent();

		if (type.equals("PROPIEDAD")) {
			if (square.hasHotel()) {
				rent = rent * 5;
			} else if (square.getHouses() > 0) {
				rent = rent * square.getHouses();
			}
			return rent;
		}

		if (type.equals("ESTACION")) {
			int ownedStations = 0;
			for (Square s : allSquares.values()) {
				if (s != null && s.getType().toUpperCase().equals("ESTACION") && ownerName.equals(s.getOwner())) {
					ownedStations++;
				}
			}
			switch (ownedStations) {
				case 1: 
					return 25;
				case 2: 
					return 50;
				case 3: 
					return 100;
				case 4: 
					return 200;
				default: 
					return 25;
			}
		}

		if (type.equals("SERVICIO")) {
			int ownedServices = 0;
			for (Square s : allSquares.values()) {
				if (s != null && s.getType().toUpperCase().equals("SERVICIO") && ownerName.equals(s.getOwner())) {
					ownedServices++;
				}
			}

			if (ownedServices == 2) {
				return diceRoll * 10;
			} else {
				return diceRoll * 4;
			}
		}

		return rent;
	}

}