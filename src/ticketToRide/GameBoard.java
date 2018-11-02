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
    private HashMap<List<String>, Routes> destinations;
    private int min = 1;
    private int max = color.length;


    public GameBoard() {
        /*
            Using an array for the keys/destinations since the routes are bi-directional.
            It's the same route regardless which end you start in.
         */
        destinations = new HashMap<>();
        destinations.put(new ArrayList<>(Arrays.asList("LA", "SF")), new Routes("RED", 3));
        destinations.put(new ArrayList<>(Arrays.asList("NY", "SF")), new Routes("BLUE", 5));
        destinations.put(new ArrayList<>(Arrays.asList("LA", "SD")), new Routes("BLACK", 2));
        destinations.put(new ArrayList<>(Arrays.asList("NY", "DC")), new Routes("GREEN", 3));
        destinations.put(new ArrayList<>(Arrays.asList("SF", "LV")), new Routes("YELLOW", 4));
        destinations.put(new ArrayList<>(Arrays.asList("LA", "LV")), new Routes("BLANK", 3));
    }

    public int getRouteLength(String city1, String city2) {
        ArrayList<String> cities = getKey(city1, city2);
        Routes foundRoute;
        if (cities.contains(null) || cities.isEmpty()) {
            //foundRoute = null;
            return 0;
        } //else {
        //foundRoute = new Routes(destinations.get(cities).getRouteColor(), destinations.get(cities).getRouteLength());
        //}
        return destinations.get(cities).getRouteLength();
    }

    private ArrayList getKey(String c1, String c2){
        Set keySet = destinations.keySet();

        for(Iterator itr = keySet.iterator(); itr.hasNext();){
            ArrayList<String> keys = (ArrayList<String>) itr.next();
            if(keys.contains(c1) && keys.contains(c2)){
                return keys;
            }
        }
        return null;
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
