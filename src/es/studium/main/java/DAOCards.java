package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCards {

	private Connection conexion;

	public DAOCards(Connection connect)
	{
		this.conexion = connect;
	}
	
	public List<Card> obtainCards()
	{
		List<Card> listCards = new ArrayList<>();
		String sqlQuery = "SELECT * FROM cartas";
		try (PreparedStatement ps = conexion.prepareStatement(sqlQuery); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = (rs.getInt("idCarta"));
				String type = (rs.getString("tipoCarta"));
				String text = (rs.getString("textoCarta"));
				String action = (rs.getString("accionCarta"));
				int value = (rs.getInt("valorCarta"));
				int destination = (rs.getInt("destinoCarta"));
				Card c = new Card(id, type, text, action, value, destination);
				listCards.add(c);
			}
		} catch (SQLException sqle) {
			System.err.println("Error: " + sqle.getMessage());
		}
		return listCards;
	}
}
