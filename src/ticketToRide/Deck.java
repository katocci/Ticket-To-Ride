
import java.util.*;
import java.io.*;

/**
 * This class holds both deck and discard piles of cards. It uses LinkedList functionality to add and
 * remove cards from the deck or discard. It has a shuffle functionality and can be built using a file. a simple
 * integer flag denotes what kind of card the Deck will consist of
 */
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
    /**
	 * Get fuction for deck portion of Deck.
	 * @return list of cards in the deck
	 */
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
	/**
	 * This method creates a FileReader wrapped in a BufferedReader to automatically build a Deck of cards
	 * from some file name. This is generalized to avoid hardcoding over 100 cards for the full game.
	 * param String name of file to be read
	 * param int num tells what type of card is being built, 0 = TrainCarCard, 1 = DestCard
	 */
	public void buildDeck(String fileName, int type) {
		String s;

		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			while((s = br.readLine()) != null) {
				if(type == 0) {
					this.add(new TrainCarCard(s));
				}

				else{
					String[] arr = s.split(" ");
					this.add(new DestCard(arr[0],arr[1], Integer.parseInt(arr[2])));
				}
			}
			this.shuffle(); // initial shuffle

		} catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
	}



}
