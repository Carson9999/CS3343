
public class RepeatedLeaveLeaves extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepeatedLeaveLeaves(RegisterLeave r) {
		super("This teacher has already took leave from " + r.toString() + "!");
	}

	public RepeatedLeaveLeaves(String message) {
		super(message);
	}

}