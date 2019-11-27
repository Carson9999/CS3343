

public class CommandNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandNotFoundException() {
		super("Wrong Command");
	}

	public CommandNotFoundException(String message) {
		super(message);
	}

}
