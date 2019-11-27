
public class ArgException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArgException() {
		super("Insufficient command arguments!");
	}

	public ArgException(String message) {
		super(message);
	}

}
