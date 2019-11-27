public class ClubExistedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClubExistedException() {
		super("This Club existed! Cannot create one more.");
	}

	public ClubExistedException(String message) {
		super(message);
	}

}
