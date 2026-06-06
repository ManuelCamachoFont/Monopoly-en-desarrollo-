package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DAOSquares {

	private Connection cnt;

	public DAOSquares(Connection connect)
	{
		this.cnt = connect;
	}
	
	public HashMap<Integer, Square> obtainSquares()
	{
		HashMap<Integer, Square> mapSquares = new HashMap<>();
		String sqlQuery = "SELECT * FROM casillas";
		try (PreparedStatement ps = cnt.prepareStatement(sqlQuery); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = (rs.getInt("idCasilla"));
				String name = (rs.getString("nombreCasilla"));
				String type = (rs.getString("tipoCasilla"));
				String color = (rs.getString("colorCasilla"));
				int group = (rs.getInt("grupoCasilla"));
				int price = (rs.getInt("precioCasilla"));
				int rent = (rs.getInt("alquilerCasilla"));
				Square s = new Square(id, name, type, color, group, price, rent);
				mapSquares.put(id, s);
			}
		} catch (SQLException sqle) {
			System.err.println("Error: " + sqle.getMessage());
		}
		return mapSquares;
	}
}