public class ExTeacherAlreadyExists extends Exception {
	public ExTeacherAlreadyExists() {
		super("Teacher already exists!");
	}

	public ExTeacherAlreadyExists(String message) {
		super(message);
	}

}
