
package ticketToRide;

import java.util.*;


public class GameBoard {
    private static Random random = new Random(System.currentTimeMillis());
    private static String[] color = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK", "BLANK"};
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

        public Routes() {
            this.routeLength = random.nextInt(max-min) + min;
            this.routeColor = color[random.nextInt(color.length)];
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
