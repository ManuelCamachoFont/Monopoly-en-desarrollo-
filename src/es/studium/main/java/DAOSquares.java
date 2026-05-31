package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOSquares {

	private Connection conexion;

	public DAOSquares(Connection connect)
	{
		this.conexion = connect;
	}
	
	public List<Square> obtainSquares()
	{
		List<Square> listSquares = new ArrayList<>();
		String sqlQuery = "SELECT * FROM casillas";
		try (PreparedStatement ps = conexion.prepareStatement(sqlQuery); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = (rs.getInt("idCasilla"));
				String name = (rs.getString("nombreCasilla"));
				String type = (rs.getString("tipoCasilla"));
				String color = (rs.getString("colorCasilla"));
				int group = (rs.getInt("grupoCasilla"));
				int price = (rs.getInt("precioCasilla"));
				int rent = (rs.getInt("alquilerCasilla"));
				Square s = new Square(id, name, type, color, group, price, rent);
				listSquares.add(s);
			}
		} catch (SQLException sqle) {
			System.err.println("Error: " + sqle.getMessage());
		}
		return listSquares;
	}
}