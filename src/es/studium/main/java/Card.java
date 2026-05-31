package es.studium.main.java;

public class Card {

	private int id;
	private String type;
	private String text;
	private String action;
	private int value;
	private int destination;
	
	public Card(int id, String type, String text, String action, int value, int destination) {
		this.id = id;
		this.type = type;
		this.text = text;
		this.action = action;
		this.value = value;
		this.destination = destination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return this.type + " - " + this.text;
	}
}
