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
    private ArrayList<Routes> gameRoutes;
    private int min = 1;
    private int max = color.length;


    public GameBoard() {
        gameRoutes = new ArrayList<>();
        gameRoutes.add(new Routes("RED", 4));
        gameRoutes.add(new Routes("BLACK", 2));
        gameRoutes.add(new Routes("BLANK", 4));
        gameRoutes.add(new Routes("RED", 3));
    }

    class Routes {
        private int routeLength;
        private String routeColor;
        private String carTypeNeeded;

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
