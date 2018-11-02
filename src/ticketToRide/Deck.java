
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
	
	// Default Constructor
	public Deck() {
		deck = new LinkedList<Card>();
		discard = new LinkedList<Card>();
	}

	// This constructor takes a filename and flag indicating what kind of Card is filling the deck
	public Deck(String filename, int flag){
		deck = new LinkedList<Card>();
		discard = new LinkedList<Card>();
		buildDeck(filename,flag);
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
	/**
     * The add() function adds a Card to the deck pile, this likely occurs through a reshuffle that involves
     * emptying the discard pile into the deck. It is also used to initialize the deck piles at the beginning
     * of the game
     * @param Card to be added to the deck pile
     */
	public void add(Card card) {
		deck.add(card);
	}
	/**
     * The discard() method takes a Card from the player and adds it to the top of the discard pile
     * @param Card sent from player
     */
	public void discard(Card card) {
		discard.add(card);
	}
	/**
     * The method draw() removes the first Card from the deck LinkedList and returns it
     * @return Card on top of deck pile
     */
	public Card draw() {
		return deck.pop();
	}
	/**
     * The method pull() removes the top card from the discard pile and return the Card object.
     * Note that this should only be used for TrainCarCards as there is no discard pile for DestCards.
     * @return Card on top of discard pile
     */
	public Card pull() {
		return discard.pop();
	}
	/**
     * Shuffle calles Collections.shuffle to randomly rearrange the Cards within
     * their LinkedList deck
     */
	public void shuffle() {
		Collections.shuffle(deck);
	}

	/**
     * canShuffle ensures that there are at least 2 card available to shuffle
     * @return true if there are at least 2 cards in the deck
     */
	public boolean canShuffle() {
		if(this.deck.size() > 1)
			return true;
		else
			return false;
	}
	/**
	 * This method creates a FileReader wrapped in a BufferedReader to automatically build a Deck of cards
	 * from some file name. This is generalized to avoid hardcoding over 100 cards for the full game.
	 * @param String name of file to be read
	 * @param int num tells what type of card is being built, 0 = TrainCarCard, 1 = DestCard
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
		}
		catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
	}
}
