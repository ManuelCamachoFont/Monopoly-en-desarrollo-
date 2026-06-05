
package es.studium.main.java;

import java.util.HashMap;
import java.util.List;

public class TurnManager{

	private String log = "";
	
	
	public String getLog() {
		return this.log;
	}

	public static boolean handleJailRoll(Player player, boolean isDouble) {
	    if (isDouble) {
	        player.setPrison(false);
	        player.setJailTurns(0);
	        return false;
	    }
	    int turns = player.getJailTurns() + 1;
	    player.setJailTurns(turns);
	    if (turns >= 3) {
	        player.setPrison(false);
	        player.setJailTurns(0);
	    }
	    return true;
	}
	public static boolean movementToSquare(Player player, int movement, boolean isDouble, HashMap<Integer, Square> squares, List<Player> playersList)
	{
		if(isDouble) {
			int consecutiveDoubles = player.getDoublesDices()+1;
			player.setDoublesDices(consecutiveDoubles);
			
			if(consecutiveDoubles >= 3) {
				player.setDoublesDices(0);
				goToJail(player);
			}
			System.out.println("DOBLES de"+player.getName());
		} else {
			player.setDoublesDices(0);
		}
		int newPosition = player.getPosition() + movement;
		if (newPosition > 40) {
			newPosition = newPosition - 40;
			player.updateMoney(200);
			System.out.println(player.getName() + "da una vuelta completa");
		}
		player.setPosition(newPosition);

		Square square = squares.get(newPosition);
		if (square != null) {
			squareEvents(player, square, squares, playersList);
		}
		return !isDouble;
	}

	public static void squareEvents(Player player, Square square, HashMap<Integer, Square> allSquares,
			List<Player> playersList)
	{
		String type = square.getType().toUpperCase();

		switch (type) {
		case ("PROPIEDAD"):
		case ("ESTACION"):
		case ("SERVICIO"):
			payRent(player, square, allSquares, playersList);
			break;
		case "IMPUESTO":
			taxSquare(player, square);
			break;
		case "ESPECIAL":
			if (square.getName().equals("Ir a la Cárcel"))
				goToJail(player);
			break;
		case "SUERTE":
			// TODO añadir el método para controlar lo que pasa en estas casillas
			break;
		case "COMUNIDAD":
			// TODO añadir el método para controlar lo que pasa en estas casillas
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

	private static void payRent(Player player, Square square, HashMap<Integer, Square> allSquares, List<Player> playersList) {
	    if (!square.hasOwner()) {
	        return;
	    }
	    if (!square.getOwner().equals(player.getName())) {
	        int rentToPay = calculateRent(square, allSquares);
	        player.updateMoney(-rentToPay);
	        for (Player owner : playersList) {
	            if (owner.getName().equals(square.getOwner())) {
	                owner.updateMoney(rentToPay);
	            }
	        }
	    }
	}

	public static boolean buyProperty(Player player, Square square) {
	    String type = square.getType();
	    if (!type.equals("PROPIEDAD") && !type.equals("ESTACION") && !type.equals("SERVICIO")) return false;
	    if (square.hasOwner()) return false;
	    if (player.getMoney() < square.getPrice()) return false;

	    player.updateMoney(-square.getPrice());
	    square.setOwner(player.getName());
	    player.getProperties().add(square);
	    return true;
	}

	private static int calculateRent(Square square, HashMap<Integer, Square> allSquares)
	{
		int rent = square.getRent();

		if (square.hasHotel()) {
			rent = rent * 5;
		} else if (square.getHouses() > 0) {
			rent = rent * square.getHouses();
		}

		return rent;
	}

}