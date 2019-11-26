public class CmdListClubs extends RecordedCommand {

	@Override
	public void execute(String[] cmdParts) {
		School school = School.getInstance();
		school.listClubs();
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
