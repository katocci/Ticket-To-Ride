import java.util.LinkedList;
import java.util.*;


public class GameBoard {
	
	private LinkedList<Card> tcHand;
	private Deck tcDeck;
	private Deck dcDeck;
	private LinkedList<Player> players;

    //private Deck tcDeck;
    //private Deck dcDeck;
    //private HashMap<String[], ArrayList<Routes>> destinations;
    //private ArrayList<Routes> gameRoutes;
    private HashMap<List<String>, Route> destinations;

    public GameBoard() {
        /*
            Using an array for the keys/destinations since the routes are bi-directional.
            It's the same route regardless which end you start in.
         */
        destinations = new HashMap<>();
        destinations.put(new ArrayList<>(Arrays.asList("LA", "SF")), new Route("RED", 3));
        destinations.put(new ArrayList<>(Arrays.asList("NY", "SF")), new Route("BLUE", 5));
        destinations.put(new ArrayList<>(Arrays.asList("LA", "SD")), new Route("BLACK", 2));
        destinations.put(new ArrayList<>(Arrays.asList("NY", "DC")), new Route("GREEN", 3));
        destinations.put(new ArrayList<>(Arrays.asList("SF", "LV")), new Route("YELLOW", 4));
        destinations.put(new ArrayList<>(Arrays.asList("LA", "LV")), new Route("BLANK", 3));
    }

    public Route getRoute(String city1, String city2) {
        ArrayList<String> cities = getKey(city1, city2);
        Route foundRoute;
        if (cities.contains(null) || cities.isEmpty()) {
            foundRoute = null;
        } else {
            foundRoute = new Route(destinations.get(cities).getRouteColor(), destinations.get(cities).getRouteLength());
        }
        return foundRoute;
    }

    /*
        Just a helper function for the getRouteLength().
        This ensures that the order of the cities being passed doesn't matter
     */
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

}
