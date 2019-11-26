public class CmdTakeLeave extends RecordedCommand {

	Company co = Company.getInstance();
	Employee e;
	LeaveRecord r;

	@Override
	public void execute(String[] cmdParts) {
		try {
			if (cmdParts.length < 4)
				throw new ExInsufficientArguments();

			e = co.searchEmployee(cmdParts[2]);
			r = new LeaveRecord(new Day(cmdParts[3]), new Day(cmdParts[4]));
			e.addLeave(r);

			addUndoCommand(this);
			clearRedoList();

			System.out.println(cmdParts[2] + " takes leave from " + cmdParts[3] + " to " + cmdParts[4] + ".(" + cmdParts[1] + ")");
		} catch (ExInsufficientArguments | ExEmployeeNotFound | ExOverlappedLeaves | ExDateHasAlreadyPassed | ExInsufficientBalance e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void undoMe() {
		e.removeLeave(r);
		addRedoCommand(this);
	}

	@Override
	public void redoMe() {
		try {
			e.addLeave(r);
			addUndoCommand(this);
		} catch (ExOverlappedLeaves | ExDateHasAlreadyPassed | ExInsufficientBalance e) {
			System.out.println(e.getMessage());
		}
	}
}