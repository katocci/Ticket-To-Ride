package ticketToRide;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameLogicTest {
	
	GameLogic glTest;
	@Before
	public void setUp() {
		glTest = new GameLogic();
	}
	
	@Test
	public void endConditionTest() {
		assertTrue(glTest.isWinner());
	}

	@Test
	public void turnTest() {
		// might need something in depth here to test how a turn is taken. 
	}
	
}
