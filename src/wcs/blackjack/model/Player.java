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
	
	public String getName() {
		return this.name;
	}
	
	public String showCardAndPoints() {
		// TODO : finir la fonction d'affichage
		return "TODO";
	}
}
