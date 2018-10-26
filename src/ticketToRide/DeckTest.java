package ticketToRide;

import static org.junit.Assert.*;	

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	
	Deck d1,d2, d3;
	
	@Before
	public void setUp() {
		
		TrainCarCard card1 = new TrainCarCard("red");
		TrainCarCard card2 = new TrainCarCard("red");
		TrainCarCard card3 = new TrainCarCard("red");
		TrainCarCard card4 = new TrainCarCard("red");
		TrainCarCard card5 = new TrainCarCard("blue");
		
		d1 = new Deck();
		d2 = new Deck();
		d2 = new Deck();
		d3 = new Deck();
		
		d3.add(new TrainCarCard());
		
		d1.discard(new TrainCarCard());
		
		d1.add(card1);
		d1.add(card2);
		d1.add(card3);
		d1.add(card4);
		d1.add(card5);
		
		d2.add(card1);
		d2.add(card2);
		d2.add(card3);
		d2.add(card4);
		d2.add(card5);
		
		
	}
	
	// Check both branches of if statement for canShuffle() are working properly
	@Test
	public void shuffleCheck() {
		assertTrue(d1.canShuffle());
		assertFalse(d3.canShuffle());
	}
	
	// check get functions for both Lists in Deck
	@Test
	public void checkDeck() {
		assertTrue(d1.getDiscard().size() > 0);
		assertTrue(d1.getDeck().size() > 0);
	}

	// Create two Decks with identical deck lists, check that they're equal
	// shuffle one, then check that they are no longer equal.
	@Test
	public void shuffleTest() {
		assertNotEquals(d1, d2);
		assertTrue(d1.getDeck().equals(d2.getDeck()));
		d2.shuffle();
		assertFalse(d1.getDeck().equals(d2.getDeck()));
	}
	
	@Test
	public void testDiscard() {
		
		d2.discard(new TrainCarCard("red"));
		// check size is 1
		assertEquals(1, d2.getDiscard().size());
		
		d2.discard(new TrainCarCard("yellow"));
		// check size is 2
		assertEquals(2, d2.getDiscard().size());
	}
	
	// check that values match, then check length should be 4
	@Test
	public void testDraw() {
		Card temp = (TrainCarCard)d1.draw();
		assertEquals("red", ((TrainCarCard) temp).getColor());
		assertEquals(4, d1.getDeck().size());
	}
	
	// check values match, then check length
	@Test
	public void testPull() {
		d2.discard(new TrainCarCard("red"));
		d2.discard(new TrainCarCard("yellow"));
		Card temp = (TrainCarCard)d2.pull();
		assertEquals("red", ((TrainCarCard)temp).getColor());
		assertEquals(1, d1.getDiscard().size());
	}
	

}
