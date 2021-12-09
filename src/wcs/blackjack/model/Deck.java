package wcs.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	String[] colors = { "Coeur", "Carreau", "Trefle", "Pique" };
	String[] ranks = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi" };
	private ArrayList<Card> cards;

	public Deck() {
		this.generateCards();
	}

	public void generateCards() {
		this.cards = new ArrayList<>();
		for (String color : this.colors) {
			for (String rank : this.ranks) {
				cards.add(new Card(rank, color, getPoints(rank)));
			}
		}
		Collections.shuffle(this.cards);
	}

	public Card getNextCard() {
		return this.cards.remove(0);
	}

	private int getPoints(String rank) {
		int points = 0;
		switch (rank) {
		case "Valet", "Dame", "Roi":
			points = 10;
			break;
		case "As":
			points = 11;
			break;
		default:
			points = Integer.parseInt(rank);
		}
		return points;
	}
}
