public class ExTeacherAlreadyInClub extends Exception {
	public ExTeacherAlreadyInClub() {
		super("Teacher has already joined the Club!");
	}

	public ExTeacherAlreadyInClub(String message) {
		super(message);
	}

}
