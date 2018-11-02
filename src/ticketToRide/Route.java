import java.util.Random;

public class Route {
    private int routeLength;
    private String routeColor;
    private Random random = new Random(System.currentTimeMillis());
    private int min = 1;
    private int max = color.length;
    private static String[] color = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK", "BLANK"};

    /*
         Default constructor is IF the user's want the gameboard to be randomized
         otherwise, we will just hard code the route length and color
     */
    public Route() {
        this.routeLength = random.nextInt(max-min) + min;
        this.routeColor = color[random.nextInt(color.length)];
    }

    public Route(String routeColor, int routeLength) {
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
