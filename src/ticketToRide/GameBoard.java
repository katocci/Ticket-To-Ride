import java.util.LinkedList;
import java.util.*;


public class GameBoard {
	
	private LinkedList<Card> tcHand;
	private Deck tcDeck;
	private Deck dcDeck;
	private LinkedList<Player> players;

    private Random random = new Random(System.currentTimeMillis());
    private static String[] color = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK", "BLANK"};
    private final String[] carTypes = {"Box", "Passenger", "Tanker", "Reefer",
            "Freight", "Hopper", "Coal", "Caboose", "Locomotives"};
    //private Deck tcDeck;
    //private Deck dcDeck;
    private ArrayList<Routes> gameRoutes;
    private int min = 1;
    private int max = color.length;


    ////////////////////////////////////////////
    // A single route for testing isValidMove //

    private int route; // the size of a single route
    private String route_color; // the color of the route

    public GameBoard() {
        this.route = 0;
        this.route_color = "NULL";
    }

    // temporary- for testing isValidMove. Eventually going to make a Route class
    public GameBoard(int _route, String _route_color) {
        this.route = _route;
        this.route_color = _route_color;
    }

    public int getRouteSize() { return route; }

    public String getRouteColor() { return route_color; }

    ////////////////////////////////////////////
    class Routes {
        private int routeLength;
        private String routeColor;
        private String carTypeNeeded;

        public Routes() {
            this.routeLength = random.nextInt(max-min) + min;
            this.routeColor = color[random.nextInt(color.length)];
            this.carTypeNeeded = carTypes[random.nextInt(carTypes.length - min) + min];
        }

        public int getRouteLength() {
            return routeLength;
        }

        public String getCarTypeNeeded() {
            return carTypeNeeded;
        }

        public String getRouteColor() {
            return routeColor;
        }

        @Override
        public String toString(){
            return "Length: " + this.routeLength + " " +  "Color: " + this.routeColor;
        }
    }

}
