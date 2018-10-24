package ticketToRide;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IsValidMoveTest {

    @Before
    public void Initialize() {
        Player player1 = new Player();
        Player player2 = new Player();
        Gameboard gameboard = new Gameboard();
        GameLogic gl = new GameLogic();
    }

    @Test
    public void Test() {
        assertTrue("This instance is a valid move.", gl.isValidMove(player1, gameboard));
        assertTrue("This instance is an invalid move.", gl.isValidMove(player2, gameboard));
    }

}