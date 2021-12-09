package wcs.blackjack.core;

import java.util.Scanner;

import wcs.blackjack.model.*;

public class Game {
	Scanner sc;
	Deck deck;
	public void begin() {
		
		sc = new Scanner(System.in);
		
		do {
			// Player 
			Player player = new Player(this.getPlayerName());
			Player croupier = new Player("Croupier");
			
			// Initialisation du Deck
			this.deck = new Deck();
			
			// initialisation des 2 cartes des joueurs		
			this.beginRound(player, croupier);
			
			// comportement du joueur.
			this.playerPlay(player);
			// cas de défaite immédiate
			if(!this.outOfRangeVictory(player)) {
				
				// comportement du croupier
				this.croupierPlay(croupier);
				
				// cas de défaite immédiate
				if(!this.outOfRangeVictory(croupier)) {
					this.getWinner(croupier, player);
				}
			}
		
		} while(this.playMore());
	}
	

	private void getWinner(Player croupier, Player player) {
		if(croupier.getPoints() > player.getPoints()) {
			System.out.println("La banque gagne");
		}
		else if (player.getPoints() > croupier.getPoints()) {
			System.out.printf("%s gagne haut la main !%n", player.getName());
		}
		else {
			System.out.println("Match nul !");
		}
		
	}


	private boolean outOfRangeVictory(Player player) {
		if(player.getPoints() > 21) {
			System.out.printf("%s a perdu en dépassant 21 !%n", player.getName());
			return true;
		}
		return false;
	}
	
	private boolean playerWantMore() {
		String answer;
		do {
			System.out.println("Voulez vous (T)irer une autre carte ou (R)ester?");
			answer = sc.next();
		} while(answer.isBlank() || (answer.charAt(0) != 'T' && answer.charAt(0) != 'R'));
		
		return answer.charAt(0) == 'T';
	}
	
	private void playerPlay(Player player) {
		while(player.getPoints() < 21 && player.getCards().size() < 4 && this.playerWantMore()) {
			player.addCard(deck.getNextCard());
			player.showCardAndPoints();
		}
	}
	
	private void croupierPlay(Player croupier) {
		while(croupier.getPoints() < 16 ) {
			croupier.addCard(deck.getNextCard());
			croupier.showCardAndPoints();
		}
	}
	
	public String getPlayerName() {
		String name;
		do {
			System.out.println("Quel est votre nom ?");
			name = sc.next();
		} while (name.isBlank());
		return name;
	}
	
	public void beginRound(Player player, Player croupier) {
		// On tire 2 cartes pour le joueur
		player.addCard(deck.getNextCard());
		player.addCard(deck.getNextCard());
		
		croupier.addCard(deck.getNextCard());
		croupier.addCard(deck.getNextCard());
		// on les affiche
		croupier.showCardAndPoints();
		player.showCardAndPoints();
	}
	
	private boolean playMore() {
		String answer;
		do {
			System.out.println("Voulez vous rejouer? (O)ui ou (N)on");
			answer = sc.next();
		} while(answer.isBlank() || (answer.charAt(0) != 'O' && answer.charAt(0) != 'N'));
		
		return answer.charAt(0) == 'O';
	}
	
}
