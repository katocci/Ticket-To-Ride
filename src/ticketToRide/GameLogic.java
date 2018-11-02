import java.util.List;

// Vast majority of functionality is going to go here. All rules for turns and all of game setup
public class GameLogic {
	
	private GameBoard board;
	
	public GameLogic() {

	}
	
	public void takeTurn() {

	}
	
	public boolean isWinner() {
		return false;
	}
	
	// this will perform all initial dealing of cards to players and set 5 face up
	// Train Car Cards on board.
	public void gameSetUp() {

	}

    ////////////////////////////////////////////
	// isValidMove tests a Player's cards against the board for:
    // 1) The correct color of TrainCarCards for a route
    // 2) The correct amount of TrainCarCards for a route
	public boolean isValidMove(Player player, GameBoard routes, String city1, String city2) {

		int num_of_cards = 0;
		Route route = routes.getRoute(city1, city2);

		List<TrainCarCard> player_hand = player.getTcHand();

		for(int i = 0; i < player_hand.size(); i++) {
			if(player_hand.get(i).getColor().equals(route.getRouteColor()))
				num_of_cards++;
		}

		System.out.println("You have " + num_of_cards + " " + route.getRouteColor() + " card(s) for the route.");

		if(num_of_cards == route.getRouteLength())
			return true;

		return false;
    }


}
