
package es.studium.main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class TurnManager
{
	public static boolean jailCheckOptions(Player player)
	{
		if (!player.getPrison()) return false;
		//===================IMPORTANTE========================0
		//Esto me lo ha hecho la IA, hay que cambiarlo por los botones que tu has hecho en el dialogo
		
		ArrayList<String> opciones = new ArrayList<>();
		opciones.add("Tirar dados (Buscar dobles)");
		
		if (player.getMoney() >= 50) {
			opciones.add("Pagar fianza (50€)");
		}
		if (player.getJailCards() > 0) {
			opciones.add("Usar tarjeta 'Quedas libre'");
		}

		String[] ops = opciones.toArray(new String[0]);
		int seleccion = JOptionPane.showOptionDialog(
			null,
			player.getName() + " está en la cárcel. Selecciona cómo proceder:",
			"Turno en la Cárcel",
			JOptionPane.DEFAULT_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null, ops, ops[0]
		);

		if (seleccion == -1) seleccion = 0; // Si cierra la ventana, por defecto tira dados

		String eleccion = ops[seleccion];

		if (eleccion.equals("Pagar fianza (50€)")) {
			player.updateMoney(-50);
			player.setPrison(false);
			player.setJailTurns(0);
			JOptionPane.showMessageDialog(null, player.getName() + " pagó 50€ y sale de la cárcel.");
			return false; 
		} 
		else if (eleccion.equals("Usar tarjeta 'Quedas libre'")) {
			player.setJailCards(player.getJailCards() - 1);
			player.setPrison(false);
			player.setJailTurns(0);
			JOptionPane.showMessageDialog(null, player.getName() + " usó la tarjeta y sale de la cárcel.");
			return false;
		}

		return true; 
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
			propertySquare(player, square, allSquares, playersList);
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

	private static void propertySquare(Player player, Square square, HashMap<Integer, Square> allSquares, List<Player> playersList)
	{
		if (!square.hasOwner()) {
			System.out.println(player.getName() + " puede comprar " + square.getName() + " por " + square.getPrice() + "€.");
			if (player.getMoney() >= square.getPrice()) {
				return;			
			}
			else {
				System.out.println(player.getName()+"No tiene dinero suficiente");
			}
		} else if (!square.getOwner().equals(player.getName())) {
				int rentToPay = calculateRent(square, allSquares);
				player.updateMoney(-rentToPay);
				for (Player owner : playersList) {
					if (owner.getName().equals(square.getOwner())) {
						owner.updateMoney(rentToPay);
				System.out.println(player.getName() + "paga" + rentToPay+"a"+owner.getName());
					}
				}
			}
				
	}

	public static boolean buyProperty(Player player, Square square)
	{
		//Propiedad
		if (square.getType().equals("PROPIEDAD")) return false;
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