import java.util.*;

public class Main {

	private static Scanner command;

	public static void main(String[] args) {

		command = new Scanner(System.in);
		System.out.println("Welcome to the Club Management Software!");
        System.out.print("Enter a command: ");
        
		try {
			String cmdLine1 = command.nextLine();
			String[] cmdLine1Parts = cmdLine1.split("\\|");
			System.out.println("\n> " + cmdLine1);
			DateMain.createTheInstance(cmdLine1Parts[1]);
			System.out.print("\nEnter a command: ");

			while (command.hasNext()) {
				
				String cmdLine = command.nextLine().trim();
				if (cmdLine.equals(""))
					continue;

				System.out.println("\n> " + cmdLine);

				String[] cmdParts = cmdLine.split("\\|");
				switch (cmdParts[0]) {
					case "hire":
						(new NewTeacherCM()).run(cmdParts);
						break;
					case "setupClub":
						(new CreateClubCM()).run(cmdParts);
						break;
					case "startNewDay":
						(new StartNewDayCM()).run(cmdParts);
						break;
					case "listClubs":
						(new ListClubsCM()).run(cmdParts);
						break;
					case "listTeachers":
						(new ListTeachersCM()).run(cmdParts);
						break;
					case "takeLeave":
						(new TakeLeaveCM()).run(cmdParts);
						break;
					case "listLeaves":
						(new ListLeavesCM()).run(cmdParts);
						break;
					case "addClubTutor":
						(new AddClubTutorCM()).run(cmdParts);
						break;
					case "listRoles":
						(new ListRolesCM()).run(cmdParts);
						break;
					case "listClubTutors":
						(new ListClubTutorsCM()).run(cmdParts);
						break;
					case "undo":
						RecordedCommand.undoOneCommand();
						break;
					case "redo":
						RecordedCommand.redoOneCommand();
						break;
					default:
						throw new CommandNotFoundException();
				}
				System.out.print("\nEnter a command: ");
			}
		} catch (InputMismatchException e) {
			System.out.println("File content problem. Program terminated.");
		} catch ( CommandNotFoundException e) {
			System.out.println("Unknown command - ignored!");
		}
	}
}