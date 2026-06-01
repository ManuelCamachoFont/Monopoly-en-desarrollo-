package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAORanking {

	private Connection conexion;

	public DAORanking(Connection connect)
	{
		this.conexion = connect;
	}
	
	public int insertRanking(Player player, List<Square> squares)
	{
		String sqlUpdate = "INSERT INTO ranking (nombreJugadorRanking, dineroFinalRanking, casasFinalRanking, hotelesFinalRanking) VALUES (?, ?, ?, ?)";
		int id = -1;
		try (PreparedStatement ps = conexion.prepareStatement(sqlUpdate, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, player.getName());
			ps.setInt(2, player.getMoney());
			ps.setInt(3, player.getTotalHouses(squares));
			ps.setInt(4, player.getTotalHotels(squares));


			int insert = ps.executeUpdate();

			if (insert > 0) {
				try (ResultSet rsPK = ps.getGeneratedKeys()) {
					if (rsPK.next()) {
						id = rsPK.getInt(1);
					}
				}
			}
		} catch (SQLException sqle) {
			System.out.println("Error: " + sqle.getMessage());
		}
		return id;
	}
}
