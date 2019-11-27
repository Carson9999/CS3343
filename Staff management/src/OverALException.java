
public class OverALException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OverALException(int days) {
		super("Insufficient balance. " + days + " days left only!");
	}

	public OverALException(String message) {
		super(message);
	}

}
