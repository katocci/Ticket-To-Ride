package ticketToRide;

import java.util.LinkedList;
import java.util.List;

public class GameBoard {
	
	private LinkedList<Card> tcHand;
	private Deck tcDeck;
	private Deck dcDeck;
	private LinkedList<Player> players;
	
	// Not sure what functionality will be here. In my mind, this is just a reference point for
	// the actual game logic to reference so all of the different objects are in one place
	
	// Add constructors and getters/setters, clearly.


    ////////////////////////////////////////////
    // A single route for testing isValidMove //

    private int route; // the size of a single route
    private String route_color // the color of the route

    public GameBoard(int _route, String _route_color) {
        this.route = _route;
        this.route_color = _route_color;
    }

    public int getRouteSize() { return route; }

    public String getRouteColor{ return route_color; }

    ////////////////////////////////////////////

}
