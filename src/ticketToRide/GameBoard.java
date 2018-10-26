
package ticketToRide;

import java.util.*;


public class GameBoard {

    /*
        Added color and car types for the routes, along with their designated length since
        each routes will require a certain number of train cards that of the same type along with a
        a color.

        NOTE THIS IMPLEMENTATION HAS BEEN CHANGED: The routes are each randomly generated with a length, car type, and color

        UPDATED IMPLEMENTATION: Each route's length, color, and car type has been hard coded
                                since a randomized route can be harder to debug.
     */
/*    private Random random = new Random(System.currentTimeMillis());
    private static String[] color = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK", "BLANK"};
    private final String[] carTypes = {"Box", "Passenger", "Tanker", "Reefer",
            "Freight", "Hopper", "Coal", "Caboose", "Locomotives"};*/
	private Deck tcDeck;
	private Deck dcDeck;
	private ArrayList<Routes> gameRoutes;
/*	private int min = 1;
	private int max = color.length;*/

    /*public GameBoard(){

        gameRoutes = new ArrayList<>();
            gameRoutes.add(new Routes());
        }
        tcDeck = null;
        dcDeck = null;
    }*/

    public GameBoard(){
        gameRoutes = new ArrayList<>();
        gameRoutes.add(new Routes("RED", "Passenger", 4));
        gameRoutes.add(new Routes("BLUE", "Box", 6));
        gameRoutes.add(new Routes("BLANK", "", 5));
        gameRoutes.add(new Routes("RED", "Freight", 3));
        gameRoutes.add(new Routes("Yellow", "Passenger", 5));
        gameRoutes.add(new Routes("BLANK", "", 6));
        gameRoutes.add(new Routes("GREEN", "Hopper", 4));
        gameRoutes.add(new Routes("RED", "Coal", 3));
        gameRoutes.add(new Routes("BLACK", "Passenger", 1));
        gameRoutes.add(new Routes("YELLOW", "Tanker", 2));
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

        /*public Routes() {
            this.routeLength = random.nextInt(max-min) + min;
            this.routeColor = color[random.nextInt(color.length)];
            this.carTypeNeeded = carTypes[random.nextInt(carTypes.length - min) + min];
        }*/

        public Routes(String routeColor, String carTypeNeeded, int routeLength){
            this. routeColor = routeColor;
            this.routeLength = routeLength;
            this.carTypeNeeded = carTypeNeeded;
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
