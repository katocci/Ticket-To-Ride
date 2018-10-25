
package ticketToRide;

import java.util.*;


public class GameBoard {

    /*
        Added color and car types for the routes, along with their designated length since
        each routes will require a certain number of train cards that of the same type along with a
        a color.
        The routes are each randomly generated with a length, car type, and color
     */
    private Random random = new Random(System.currentTimeMillis());
    private static String[] color = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK", "BLANK"};
    private final String[] carTypes = {"Box", "Passenger", "Tanker", "Reefer",
            "Freight", "Hopper", "Coal", "Caboose", "Locomotives"};
	private Deck tcDeck;
	private Deck dcDeck;
	private ArrayList<Routes> gameRoutes;
	private int min = 1;
	private int max = color.length;

    public GameBoard(){

        gameRoutes = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            gameRoutes.add(new Routes());
        }
        tcDeck = null;
        dcDeck = null;
    }

    public ArrayList<Routes> getGameRoutes() {
        return gameRoutes;
    }

    /*
        Routes is an inner class of the GameBoard class because the routes are within the game board.
        We just have an array of Routes that the GameBoard can access. This way we don't have to externally
        make a Routes class and we can easily modify this inner class in any case that GameBoard or Routes changes.
     */
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
