
package ticketToRide;

import java.util.*;


public class GameBoard {
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
