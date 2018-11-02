/**
 * This interface provides an essentially emtpy generic Card type to allow
 * for a more generic Deck class that can be used for both types of cards necessary
 * to play Ticket to Ride
 */
public interface Card {
	/**
	 * Must override the toString method to format output for all classes that implement Card
	 * @return formatted string
	 */
	public String toString();
}
