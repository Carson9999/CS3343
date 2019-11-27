
public class TeacherExistedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeacherExistedException() {
		super("Teacher already existed! Cannot repeat record.");
	}

	public TeacherExistedException(String message) {
		super(message);
	}

}
