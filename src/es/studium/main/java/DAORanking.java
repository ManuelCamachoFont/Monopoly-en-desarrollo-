package es.studium.main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAORanking {

	private Connection conexion;

	public DAORanking(Connection connect)
	{
		this.conexion = connect;
	}
	
	public void insertRanking(Player player, List<Square> squares)
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

	}
	
	public List<Ranking> obtainRankingMoney() {
        List<Ranking> list = new ArrayList<>();
        String sqlQuery= "SELECT nombreJugadorRanking, dineroFinalRanking FROM ranking ORDER BY dineroFinalRanking DESC LIMIT 5";

        try (PreparedStatement ps = conexion.prepareStatement(sqlQuery); ResultSet rs = ps.executeQuery()){
          
            while (rs.next()) {
                String name = rs.getString("nombreJugadorRanking");
                int money = rs.getInt("dineroFinalRanking");
                list.add(new Ranking(name, money));
            }

        } catch (SQLException e) {
            e.printStackTrace(); 

        }
        return list;
    }
	
	public List<Ranking> obtainRankingProperties() {
        List<Ranking> list = new ArrayList<>();
        String sqlQuery= "SELECT nombreJugadorRanking, casasFinalRanking, hotelesFinalRanking FROM ranking ORDER BY 3, 2 DESC  LIMIT 5 ";

        try (PreparedStatement ps = conexion.prepareStatement(sqlQuery); ResultSet rs = ps.executeQuery()){
          
            while (rs.next()) {
                String name = rs.getString("nombreJugadorRanking");
                int houses = rs.getInt("casasFinalRanking");
                int hotel = rs.getInt("hotelesFinalRanking");
                list.add(new Ranking(name, houses, hotel));
            }

        } catch (SQLException e) {
            e.printStackTrace(); 

        }
        return list;
    }
}
