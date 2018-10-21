package ticketToRide;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	
	Deck d1,d2;
	
	@Before
	public void setUp() {
		d1 = new Deck();
		d2 = new Deck(d1);
	}

	// must be some way to 
	@Test
	public void shuffleTest() {
		assertNotEquals(d1, d2);
	}

}
