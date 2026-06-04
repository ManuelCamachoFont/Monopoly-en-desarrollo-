package es.studium.main.java;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private int id;
	private String name;
	private int money;
	private int position;
	private boolean prison;
	private ArrayList<Square> properties;
	
	public Player(int id, String name, int moneyStarting) {
		this.id = id;
        this.name = name;
        this.money = moneyStarting;
        this.position = 1;
        this.prison = false;
        this.properties = new ArrayList<>();
        
    }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public int getMoney() {	return money; }

	public void setMoney(int money) { this.money = money; }
	
	public int getPosition() { return position;}
	
	public void setPosition(int position) { this.position = position; }
	
	public void setPrison(boolean prison) { this.prison = prison; }
	
	public boolean getPrison() { return prison; }
	
	public ArrayList<Square> getProperties(){ return properties; }
	
	
	public void updateMoney (int updated) {
		this.money += updated;
	}
	
	
	public int getTotalHouses(List<Square> squares) {
		
		int totalHouses = 0;
		// Need fix
		for (Square s : this.properties) {
			Square sq = squares.get(id - 1);
			totalHouses += sq.getHouses();
		}
		
		return totalHouses;
	}
	
	public int getTotalHotels(List<Square> squares) {
	    int totalHotels = 0;
	    // Need fix
	    for (Square s : this.properties) {
	        Square sq = squares.get(id - 1);
	        if (sq.hasHotel()) {
	           totalHotels++;
	        }
	    }
	    
	    return totalHotels;
	}

	public int getJailCards() {
		
		return 0;
	}
	
}