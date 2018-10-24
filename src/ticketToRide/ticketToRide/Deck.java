package ticketToRide;

import java.util.*;

// This class holds the deck of cards. Will need functionality for the shuffle to pull from
// discard pile and, in some cases, to know whether or not a shuffle can be performed
// Probably want to create a file that builds the deck to avoid tons of setup code.
public class Deck {
	
	private LinkedList<Card> deck;
	private LinkedList<Card> discard;
	
	public Deck() {
		deck = new LinkedList<Card>();
		discard = new LinkedList<Card>();
	}
	
	public LinkedList<Card> getDeck(){
		return this.deck;
	}
	
	public LinkedList<Card> getDiscard(){
		return this.discard;
	}
	
	public void addDeck(Card card) {}
	
	public void addDiscard(Card card) {}
	
	public void shuffle() {}
	
	public boolean canShuffle() {
		return true;
	}

		
}
