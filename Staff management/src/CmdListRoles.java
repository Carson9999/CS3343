public class CmdListRoles extends RecordedCommand {

	@Override
	public void execute(String[] cmdParts) {
		try {
			if (cmdParts.length < 2)
				throw new ExInsufficientArguments();

			School co = School.getInstance();
			Teacher e = co.searchTeacher(cmdParts[1]);

			e.listRoles();
		} catch (ExInsufficientArguments | ExTeacherNotFound e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
