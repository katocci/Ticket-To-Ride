
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameLogicTest {
	Player player1 = new Player();
	Player player2 = new Player();
	Player player3 = new Player();
	Player player4 = new Player();
	GameBoard gameboard = new GameBoard(3,"PINK");
	GameLogic gl = new GameLogic();


	@Before
	public void Initialize() {
		// An instance where Player has correct color and correct amount for board
		player1.add("PINK");
		player1.add("PINK");
		player1.add("PINK");

		// ...correct color, incorrect amount
		player2.add("PINK");
		player2.add("PINK");

		// ...incorrect color, and incorrect amount
		player3.add("BLUE");
		player3.add("YELLOW");

		// ...incorrect color, correct amount.
		player4.add("BLUE");
		player4.add("YELLOW");
		player4.add("PINK");
	}

	@Test
	public void Test1() {
		assertTrue("This instance is a valid move.", gl.isValidMove(player1, gameboard));
	}

	@Test
	public void Test2() {
		assertFalse("This instance is an invalid move.", gl.isValidMove(player2, gameboard));
	}

	@Test
	public void Test3() {
		assertFalse("This instance is an invalid move.", gl.isValidMove(player3, gameboard));
	}

	@Test
	public void Test4() {
		assertFalse("This instance is an invalid move.", gl.isValidMove(player4, gameboard));
	}
}


