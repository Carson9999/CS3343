public class CmdAddClubMember extends RecordedCommand {

	School co = School.getInstance();
	Teacher e;
	Club t;

	@Override
	public void execute(String[] cmdParts) {
		try {
			if (cmdParts.length < 3)
				throw new ExInsufficientArguments();

			t = co.searchClub(cmdParts[1]);
			e = co.searchTeacher(cmdParts[2]);

			t.addClubMember(e);

			addUndoCommand(this);
			clearRedoList();

			System.out.println("Added " + cmdParts[2] + " to " + cmdParts[1] + ".");
		} catch (ExInsufficientArguments | ExTeacherNotFound | ExTeacherAlreadyInClub | ExClubNotFound e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void undoMe() {
		t.removeClubMember(e);
		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		try {
			t.addClubMember(e);
			addUndoCommand(this);
		} catch (ExTeacherAlreadyInClub e) {
			System.out.println(e.getMessage());
		}
	}
}