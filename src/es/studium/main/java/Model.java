package es.studium.main.java;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public class Model {

	private Connection conexion;

	private DAOCards daoCards;
	private DAORanking daoRanking;
	private DAOSquares daoSquares;

	public Model()
	{
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


	public void setPlayers(int players) {
		// TODO Auto-generated method stub
		
	}
}
