public class ExTeacherNotFound extends Exception {
	public ExTeacherNotFound() {
		super("Teacher not found!");
	}

	public ExTeacherNotFound(String message) {
		super(message);
	}

}
