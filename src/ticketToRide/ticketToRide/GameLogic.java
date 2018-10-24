package ticketToRide;

import java.util.ArrayList;
import java.util.List;

// Vast majority of functionality is going to go here. All rules for turns and all of game setup
public class GameLogic {
	
	private GameBoard board;
	
	public GameLogic() {
		//this.board = new GameBoard();
	}
	
	public void takeTurn() {}
	
	public boolean isWinner() {
		return false;
	}
	
	// this will perform all initial dealing of cards to players and set 5 face up
	// Train Car Cards on board.
	public void gameSetUp() {}

    ////////////////////////////////////////////
	// isValidMove tests a Player's cards against the board for:
    // 1) The correct color of TrainCarCards for a route
    // 2) The correct amount of TrainCarCards for a route
	public boolean isValidMove(Player player, GameBoard route) {
		int route_length = route.getRouteSize();
		String route_color = route.getRouteColor();

		int num_of_cards = 0;

		List<TrainCarCard> a = player.getTcHand();

		for(int i = 0; i < a.size(); i++){
			if(a.get(i).getColor() == route_color)
				num_of_cards++;
		}

		System.out.println("You have " + num_of_cards + " " + route_color + " card(s) for the route.");

		if(num_of_cards == route_length)
			return true;

		return false;
    }


}
