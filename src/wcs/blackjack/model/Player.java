package wcs.blackjack.model;

import java.util.ArrayList;

public class Player {
	private String name ;
	private ArrayList<Card> cards;
	private Integer points;
	
	public Player(String name) {
		this.name = name;
		this.reset();
	}
	
	public void reset() {
		this.cards = new ArrayList<>();
		this.points = 0;
	}
	
	public void addCard(Card card) {
		cards.add(card);
		points += card.getPoints();
	}
	
	public Integer getPoints() {
		return this.points;
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void showCardAndPoints() {
		System.out.printf("%s points. Les cartes du joueur %s sont : %n",this.getPoints(), this.name);
		for(Card card : this.getCards()) {
			System.out.printf("%s de %s%n", card.getValue(), card.getColor());
		}
		
	}
}
