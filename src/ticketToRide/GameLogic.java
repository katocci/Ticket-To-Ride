package ticketToRide;

// Vast majority of functionality is going to go here. All rules for turns and all of game setup
public class GameLogic {
	
	private GameBoard board;
	
	public GameLogic() {
		this.board = new GameBoard();
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
	public boolean isValidMove(Player player, Gameboard route) {
        // Stuck on how to approach this. I can either:
        // 1) Create a placeCard function for Player & test the function itself
        // 2) Hardcode a set of TrainCarCards for a Player and just test
        // the amount of cards & color against a hardcoded route (as seen on GameBoard.java)
    }


}
