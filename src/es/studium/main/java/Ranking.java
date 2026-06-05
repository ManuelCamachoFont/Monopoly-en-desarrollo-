package es.studium.main.java;

public class Ranking {

	private int id;
	private String name;
	private int money;
	private int houses;
	private int hotels;
	
	public Ranking(String playerName, int playerMoney) {
		this.name = playerName;
		this.money = playerMoney;
	}
	
	public Ranking(String playerName, int playerHouses, int playerHotels) {
		this.name = playerName;
		this.houses = playerHouses;
		this.hotels = playerHotels;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getHouses() {
		return houses;
	}

	public void setHouses(int houses) {
		this.houses = houses;
	}

	public int getHotels() {
		return hotels;
	}

	public void setHotels(int hotels) {
		this.hotels = hotels;
	}
}
