
public class ArgException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArgException() {
		super("Lack of Argurment!");
	}

	public ArgException(String message) {
		super(message);
	}

}
