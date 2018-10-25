package ticketToRide;

import java.util.Random;

public class TrainCarCard implements Card{

    private final String[] carTypes = {"Box", "Passenger", "Tanker", "Reefer",
                                        "Freight", "Hopper", "Coal", "Caboose", "Locomotives"};
    private static String[] colors = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK"};
	private String color;
	private String carType;

    private Random random = new Random(System.currentTimeMillis());
    private int min = 1;
    private int max = carTypes.length;

	public TrainCarCard() {
		this.color = colors[random.nextInt(max - min) + min];
		this.carType = carTypes[random.nextInt(max - min) + min];
	}

	public TrainCarCard(String color){
		this.color = color;
		this.carType = "null";
	}

	public String getColor() {
		return this.color;
	}

	public String getCarType() {
		return carType;
	}



	public String toString() {
		return "TrainCarCard: " + this.color;
	}
}
