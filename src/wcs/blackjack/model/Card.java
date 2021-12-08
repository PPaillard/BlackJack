package wcs.blackjack.model;

public class Card {
	private String value;
	private String color;
	private Integer points;
	
	public Card(String value, String color, Integer points) {
		this.value = value;
		this.color = color;
		this.points = points;
	}

	public String getValue() {
		return value;
	}

	public String getColor() {
		return color;
	}
	
	public Integer getPoints() {
		return points;
	}
}
