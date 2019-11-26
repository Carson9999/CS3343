public class CmdListClubMembers extends RecordedCommand {

	@Override
	public void execute(String[] cmdParts) {
		School co = School.getInstance();
		co.listClubMembers();
	}

	@Override
	public void undoMe() {
	}

	@Override
	public void redoMe() {
	}
}
