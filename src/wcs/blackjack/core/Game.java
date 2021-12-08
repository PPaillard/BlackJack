package wcs.blackjack.core;

import java.util.Scanner;

import wcs.blackjack.model.*;

public class Game {
	Scanner sc;
	
	public void begin() {
		
		sc = new Scanner(System.in);
		// Player 
		System.out.println("Quel est votre nom ?");
		String name = sc.next();
		Player player = new Player(name);
		Player croupier = new Player("Croupier");
		
		// Deck
		Deck deck = new Deck();
		
		// On tire 2 cartes pour le joueur
		player.addCard(deck.getNextCard());
		player.addCard(deck.getNextCard());
		
		croupier.addCard(deck.getNextCard());
		croupier.addCard(deck.getNextCard());
		
		// TODO : Finir fonctionnalité
	}
	
}
