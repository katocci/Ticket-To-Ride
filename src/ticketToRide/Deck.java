package ticketToRide;

import java.util.*; 


// This class holds the deck of cards. Will need functionality for the shuffle to pull from
// discard pile and, in some cases, to know whether or not a shuffle can be performed
// Probably want to create a file that builds the deck to avoid tons of setup code.
public class Deck {
	
	// Each deck consists of a deck and discard pile, although the discard pile is unimplemented for the Destination Cards
	// for them, if I'm remembering the rules correctly, they're discarded to the bottom of the deck. So maybe a little if
	// statement checking the card type (instanceof) to determine the proper outcome -KT
	private LinkedList<Card> deck;
	private LinkedList<Card> discard;
	
	
	public Deck() {
		deck = new LinkedList<Card>();
		discard = new LinkedList<Card>();
	}

	public Deck (Deck otherDeck) {
	    this.deck = otherDeck.deck;
	    this.discard = otherDeck.discard;
    }
	
	public LinkedList<Card> getDeck(){
		return this.deck;
	}
	
	public LinkedList<Card> getDiscard(){
		return this.discard;
	}
	
	// Adds a card to the deck
	public void add(Card card) {
		deck.add(card);
	}
	
	// adds a card to the discard pile 
	// player chooses cards to discard, likely sends the Card object here through pop or remove or something.
	public void discard(Card card) {
		discard.add(card);
	}
	
	// draws from the deck
	public Card draw() {
		return deck.pop();
	}
	
	// draws from discard (Only available for Train Car Cards)
	public Card pull() {
		return discard.pop();
	}
	
	// No check to see if I can shuffle here, because it will likely be done outside
	// during turn conditions to validate play.
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	// Need at least 2 cards to be able to shuffle
	// only the deck gets shuffled
	// this is essentially a size check that the board will perform to figure out logic
	public boolean canShuffle() {
		if(this.deck.size() > 1)
			return true;
		else
			return false;
	}

		
}
