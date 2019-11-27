public class TooMuchALException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TooMuchALException() {
		super("Too much Annual leaves (0-300)!");
	}

	public TooMuchALException(String message) {
		super(message);
	}

}
