package es.studium.main.java;

import java.awt.Color;
import java.util.ArrayList;

public class Player
{

	private int id;
	private String name;
	private int money;
	private int position;
	private boolean prison;
	private int jailTurns = 0;
	private int jailCards = 0;
	private int doublesDices = 0;
	private ArrayList<Square> properties;
	private Color color;

	public Player(int id, String name, int moneyStarting, Color color) {
		this.id = id;
		this.name = name;
		this.money = moneyStarting;
		this.position = 1;
		this.prison = false;
		this.jailTurns = 0;
		this.jailCards = 0;
		this.doublesDices = 0;
		this.properties = new ArrayList<>();
		this.color = color;

	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getMoney()
	{
		return money;
	}

	public void setMoney(int money)
	{
		this.money = money;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public void setPrison(boolean prison)
	{
		this.prison = prison;
	}

	public boolean getPrison()
	{
		return prison;
	}
	
	public Color getColor() {
		return color;
	}

	public ArrayList<Square> getProperties()
	{
		return properties;
	}

	public void updateMoney(int updated)
	{
		this.money += updated;
	}

	public int getTotalHouses()
	{
		int totalHouses = 0;
		for (Square s : this.properties) {
			totalHouses += s.getHouses();
		}
		return totalHouses;
	}

	public int getTotalHotels()
	{
		int totalHotels = 0;
		for (Square s : this.properties) {
			if (s.hasHotel()) {
				totalHotels++;
			}
		}
		return totalHotels;
	}


	public int getJailTurns()
	{
		return jailTurns;
	}

	public void setJailTurns(int turnInJail)
	{
		this.jailTurns = turnInJail;
	}

	public int getJailCards()
	{
		return jailCards;
	}

	public void setJailCards(int jailCards)
	{
		this.jailCards = jailCards;

	}

	public int getDoublesDices()
	{
		return doublesDices;
	}

	public void setDoublesDices(int anotherDouble)
	{
		this.doublesDices = anotherDouble;

	}

}