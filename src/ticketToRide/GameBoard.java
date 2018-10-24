
package ticketToRide;

import java.util.*;
//import java.util.LinkedList;


public class GameBoard {
    private static Random random = new Random();
    private static String[] color = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK"};
	private Deck tcDeck;
	private Deck dcDeck;
	private ArrayList<Routes> gameRoutes;

	// Not sure what functionality will be here. In my mind, this is just a reference point for
	// the actual game logic to reference so all of the different objects are in one place
	
	// Add constructors and getters/setters, clearly.

    private class Routes {
        private int routeLength;
        private String routeColor;

        public Routes() {
            this.routeLength = random.nextInt(5 + 1);
            this.routeColor = color[random.nextInt(color.length)];
        }

    }
}
