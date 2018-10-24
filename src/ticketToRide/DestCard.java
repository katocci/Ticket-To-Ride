package ticketToRide;

public class DestCard implements Card{
	
	private final String dest;
	private final String origin;
	private final int value;
	
	public DestCard() {
		this.dest = "null";
		this.origin = "null";
		this.value = 0;
	}
	
	public DestCard(String dest, String origin, int value) {
		this.dest = dest;
		this.origin = origin;
		this.value = value;
	}
	
	public String getDest() {
		return this.dest;
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return "Destination Card: destination = " + this.dest + " origin = " + this.origin + "value = " + this.value;
	}

}
