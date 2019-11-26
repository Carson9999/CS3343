public class ExClubAlreadyExists extends Exception {
	public ExClubAlreadyExists() {
		super("Club already exists!");
	}

	public ExClubAlreadyExists(String message) {
		super(message);
	}

}
