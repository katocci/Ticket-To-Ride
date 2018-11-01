import java.util.LinkedList;
import java.util.*;


public class GameBoard {
	
	private LinkedList<Card> tcHand;
	private Deck tcDeck;
	private Deck dcDeck;
	private LinkedList<Player> players;

    private Random random = new Random(System.currentTimeMillis());
    private static String[] color = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK", "BLANK"};
    //private Deck tcDeck;
    //private Deck dcDeck;
    //private HashMap<String[], ArrayList<Routes>> destinations;
    //private ArrayList<Routes> gameRoutes;
    private HashMap<String[], Routes> destinations;
    private int min = 1;
    private int max = color.length;


    public GameBoard() {
        /*
            Using an array for the keys/destinations since the routes are bi-directional.
            It's the same route regardless which end you start in.
         */
        destinations = new HashMap<>();
        destinations.put(new String[]{"LA", "SF"}, new Routes("RED", 3));
        destinations.put(new String[]{"SF", "NY"}, new Routes("BLUE", 5));
        destinations.put(new String[]{"LA", "SD"}, new Routes("BLACK", 2));
        destinations.put(new String[]{"SF", "LV"}, new Routes("BLANK", 4));
        destinations.put(new String[]{"NY", "DC"}, new Routes("GREEN", 4));

//        gameRoutes = new ArrayList<>();
//        gameRoutes.add(new Routes("RED", 4));
//        gameRoutes.add(new Routes("BLACK", 2));
//        gameRoutes.add(new Routes("BLANK", 4));
//        gameRoutes.add(new Routes("RED", 3));
    }

    class Routes {
        private int routeLength;
        private String routeColor;

        /*
             Default constructor is IF the user's want the gameboard to be randomized
             otherwise, we will just hard code the route length and color
         */
        public Routes() {
            this.routeLength = random.nextInt(max-min) + min;
            this.routeColor = color[random.nextInt(color.length)];
        }

        public Routes(String routeColor, int routeLength) {
            this.routeLength = routeLength;
            this.routeColor = routeColor ;
        }

        public int getRouteLength() {
            return routeLength;
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
