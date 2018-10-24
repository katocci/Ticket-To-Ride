package ticketToRide;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	
	Deck d1,d2;
	
	@Before
	public void setUp() {
		
		System.out.println("Testing the test");
		TrainCarCard card1 = new TrainCarCard("red");
		TrainCarCard card2 = new TrainCarCard("red");
		TrainCarCard card3 = new TrainCarCard("red");
		TrainCarCard card4 = new TrainCarCard("red");
		TrainCarCard card5 = new TrainCarCard("blue");
		
		DestCard card6 = new DestCard("LA","SF", 5 );
		DestCard card6 = new DestCard("DC","Boston", 4 );
		DestCard card6 = new DestCard("ABQ","Seattle", 7 );
		
		d1 = new Deck();
		d2 = new Deck();
		
		d2.add(card1);
		d2.add(card2);
		d2.add(card3);
		d2.add(card4);
		d2.add(card5);
		
	}
	
	@Test
	public void addCards() {
		d1.add(card1);
		d1.add(card2);
		assertTrue(d1.size() > 0);
	}

	// must be some way to 
	@Test
	public void shuffleTest() {
		d1.add(card3);
		d1.add(card4);
		d1.add(card5);
		assertTrue(d1.equals(d2));
		assertFalse(d1.equals(d2.shuffle()));
	}

}
