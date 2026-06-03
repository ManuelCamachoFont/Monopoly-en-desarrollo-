package es.studium.main.java;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Model
{

	private Connection conexion;

	private DAOCards daoCards;
	private DAORanking daoRanking;
	private DAOSquares daoSquares;

	public Model() {
		this.conexion = DB.DBConnect();
		if (this.conexion != null) {
			this.daoCards = new DAOCards(this.conexion);
			this.daoRanking = new DAORanking(this.conexion);
			this.daoSquares = new DAOSquares(this.conexion);
			System.out.println("Connected to the DB");
		} else {
			System.err.println("Connection error");
		}
	}

	public List<Card> getCards()
	{
		return this.daoCards.obtainCards();
	}

	public HashMap<Integer, Square> getSquares()
	{
		return this.daoSquares.obtainSquares();
	}
	
	public int throwingDices()
	{
		Random randomDices = new Random();
		int diceOne = randomDices.nextInt(6) + 1;
		int diceTwo = randomDices.nextInt(6) + 1;
		return diceOne + diceTwo;
	}

	public int throwingDices()
	{
		Random randomDices = new Random();
		int diceOne = randomDices.nextInt(6) + 1;
		int diceTwo = randomDices.nextInt(6) + 1;
		return diceOne + diceTwo;
	}
	
}
