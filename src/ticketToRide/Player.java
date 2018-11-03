import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private static final int MAX_TRAINCARS = 45;
	
	private final String color;		// don't want to change after initialization
	private int carCount = MAX_TRAINCARS;
	private List<TrainCarCard> tcHand;
	private List<DestCard> dcHand;
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

    /*
        addTCCard && addDCCard are used in GameBoard & GameLogic
     */
    public void addTCCard(Card card) {
        tcHand.add((TrainCarCard)card);
    }

    public void addDCCard(Card card) {
        dcHand.add((DestCard) card);
    }

	public int getScore() {
		return score;
	}

	public String getColor() {
	    return color;
    }

    public int getCarCount() {
	    return carCount;
    }
}
