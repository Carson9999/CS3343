public class ExClubNotFound extends Exception {
	public ExClubNotFound() {
		super("Club not found!");
	}

	public ExClubNotFound(String message) {
		super(message);
	}

}
