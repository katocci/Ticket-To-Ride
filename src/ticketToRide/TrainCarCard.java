package ticketToRide;

// Add better documentation here. Shouldn't need any additional functionality at this point.
public class TrainCarCard implements Card{
	
	private final String color;
	private final String carType;
	
	public TrainCarCard() {
		this.color = "null";
		this.carType = "null";
	}

	public TrainCarCard(String color){
		this.color = color;
		this.carType = "null";
	}
	
	public TrainCarCard(String color, String carType) {
		this.color = color;
		this.carType = carType;
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
