package ticketToRide;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameBoardTest {

    GameBoard gameBoard;
    Player p1;

    @Before
    public void setUp() throws Exception {
        gameBoard = new GameBoard();
        p1 = new Player();
        for(int i = 0; i < 5; i++) {
            p1.add("GREEN");
            p1.add("RED");
            p1.add("GREEN");
            p1.add("GREEN");
            p1.add("GREEN");
        }

    }

    @Test
    public boolean testGameBoard(){
        ArrayList<GameBoard.Routes> list = gameBoard.getGameRoutes();
        List<TrainCarCard> carCards = p1.getTcHand();
        int numOfCards = 0;
        int index = 0;

        for(int i = 0; i < carCards.size(); i++) {
            if (list.get(i).getRouteColor().equals(carCards.get(i).getColor())) {
                index = i;
                break;
            }
        }

        for(int j = 0; j < list.size(); j++){
           if(carCards.get(j).getColor().equals(list.get(index).getRouteColor())){
               numOfCards++;
           }
        }

        if(numOfCards == list.get(index).getRouteLength()){
            return true;
        }

        return false;
    }

    @After
    public void tearDown() throws Exception {
    }
}