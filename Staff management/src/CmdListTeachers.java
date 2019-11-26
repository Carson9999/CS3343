public class CmdListTeachers extends RecordedCommand {

	@Override
	public void execute(String[] cmdParts) {
		School school = School.getInstance();
		school.listTeacher();
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
