package es.studium.main.java;

public class Square {

	private int id;
	private String name;
	private String type;
	private String color;
	private int group;
	private int price;
	private int rent;
	
	private String owner;
	private int houses;
	private boolean hotel;
	
	public Square(int id, String name, String type, String color, int group, int price, int rent) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.color = color;
		this.group = group;
		this.price = price;
		this.rent = rent;
		
		this.owner = null;
		this.houses = 0;
		this.hotel = false;
	}

	public int getId() { return id; }

	public String getName() { return name; }

	public String getType() { return type; }

	public String getColor() { return color; }

	public int getGroup() { return group; }

	public int getPrice() { return price; }

	public int getRent() { return rent; }

	
	public String getOwner() { return owner; }
	
	public void setOwner(String owner) { this.owner = owner; }
	
	public int getHouses() { return houses; }
	
	public boolean hasHotel() { return hotel; }
	
	
	public boolean hasOwner() {
		return this.owner != null;
	}
	
	public void buildHouse() {
		if (this.houses < 4) {
			this.houses++;
		}
		else if (this.houses == 4 && !this.hotel) {
			this.hotel = true;
			this.houses = 0;
		}
	}
	
	
}
