package ticketToRide;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	
	Deck d1,d2;
	
	@Before
	public void setUp() {
		d1 = new Deck();
		d2 = d1;
	}

	// must be some way to 
	@Test
	public void shuffleTest() {
		assertFalse(d1.equals(d2.shuffle()));
	}

}
