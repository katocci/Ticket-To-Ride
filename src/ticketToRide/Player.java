package ticketToRide;

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
	}
	
	public Player(String color) {
		this.color = color;
		this.score = 0;
        this.tcHand = new ArrayList<>();
	}

    public List<TrainCarCard> getTcHand() {
        return tcHand;
    }

    public void add(String color){
	    TrainCarCard card = new TrainCarCard(color);
        tcHand.add(card);
    }
    // Setters and getters here
	
	// Thoughts on any testable methods? I've got nothing currently
	// will probably have to play around with functionality of the "hands" of cards. 

}
