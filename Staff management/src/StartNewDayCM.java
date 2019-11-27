public class StartNewDayCM extends RecordedCommand {

	Date oDay, nDay;

	@Override
	public void run(String[] cmdParts) {
		oDay = DateMain.getInstance().clone();
		DateMain.getInstance().set(cmdParts[1]);

		addUndoCommand(this);
		clearRedoList();

		System.out.println("Done.");
	}

	@Override
	public void undoMe() {
		nDay = DateMain.getInstance().clone();
		DateMain.getInstance().set(oDay.toString());

		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		DateMain.getInstance().set(nDay.toString());

		addUndoCommand(this);
	}
}
