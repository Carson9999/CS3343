public class CmdListLeaves extends RecordedCommand {

	School co = School.getInstance();

	@Override
	public void execute(String[] cmdParts) {
		if (cmdParts.length > 1) {
			try {
				Teacher e = co.searchTeacher(cmdParts[1]);
				e.listAllLeaves();
			} catch (ExTeacherNotFound e) {
				System.out.println(e.getMessage());
			}
		} else
			co.listLeaves();
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
