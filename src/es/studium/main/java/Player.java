package es.studium.main.java;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private int id;
	private String name;
	private int money;
	private int position;
	private boolean prison;
	private ArrayList<Integer> properties;
	
	public Player(String name, int moneyStarting) {
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
	
	public void setPosition(int position) { this.position = position % 40; }
	
	public void setPrison(boolean prison) { this.prison = prison; }
	
	public boolean getPrison() { return prison; }
	
	public ArrayList<Integer> getProperties(){ return properties; }
	
	
	
	public int getTotalHouses(List<Square> squares) {
		
		int totalHouses = 0;
		
		for (int id : this.properties) {
			Square s = squares.get(id - 1);
			totalHouses += s.getHouses();
		}
		
		return totalHouses;
	}
	
	public int getTotalHotels(List<Square> squares) {
	    int totalHotels = 0;
	  
	    for (int id : this.properties) {
	        Square s = squares.get(id - 1);
	        if (s.hasHotel()) {
	           totalHotels++;
	        }
	    }
	    
	    return totalHotels;
	}
	
}
