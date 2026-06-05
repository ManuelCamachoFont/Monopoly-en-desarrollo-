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
	
	private boolean lastRollWasDouble = false;

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
	
	public List<Ranking> getRankingMoney(){
		return this.daoRanking.obtainRankingMoney();
	}
	
	public List<Ranking> getRankingProperties(){
		return this.daoRanking.obtainRankingProperties();
	}
	
	public void registerRanking(Player player, List<Square> squares) {
		this.daoRanking.insertRanking(player, squares);
	}
	
	public int[] throwingDices()
	{
		Random randomDices = new Random();
		int diceOne = randomDices.nextInt(6) + 1;
		int diceTwo = randomDices.nextInt(6) + 1;
		return new int[] {diceOne, diceTwo};

	}
	private boolean checkDouble(int diceOne, int diceTwo) {
		return diceOne == diceTwo;
	}
	public boolean isDouble() {
		return this.lastRollWasDouble;
	}
}
