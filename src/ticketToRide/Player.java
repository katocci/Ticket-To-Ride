import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private static final int MAX_TRAINCARS = 45;
	
	private final String color;		// don't want to change after initialization
	private int carCount = MAX_TRAINCARS;
	protected List<TrainCarCard> tcHand;
	protected List<DestCard> dcHand;
	private int score;		// not sure if we want this here.
	
	public Player() {
		this.color = "blank";
		this.score = 0;
		this.tcHand = new ArrayList<TrainCarCard>();
	}
	
	public Player(String color) {
		this.color = color;
		this.score = 0;
		this.tcHand = new ArrayList<TrainCarCard>();
	}

    public List<TrainCarCard> getTcHand() {
        return tcHand;
    }

    public void add(String color) {
        tcHand.add(new TrainCarCard(color));
    }
}
