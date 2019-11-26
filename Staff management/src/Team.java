import java.util.ArrayList;
import java.util.Collections;

public class Team implements Comparable<Team> {

	private String teamName;
	private Employee head;
	private Day dateSetup;
	private ArrayList<Employee> allMembers;

	public Team(String n, Employee hd) {
		this.teamName = n;
		this.head = hd;
		this.dateSetup = SystemDate.getInstance().clone();
		allMembers = new ArrayList<>();
	}

	public String getName() {
		return teamName;
	}

	public String getHeadName() {
		return head.getName();
	}

	public static void list(ArrayList<Team> list) {
		System.out.printf("%-30s%-10s%-13s\n", "Team Name", "Leader", "Setup Date");
		for (Team t : list)
			System.out.printf("%-30s%-10s%-13s\n", t.teamName, t.head.getName(), t.dateSetup.toString());
	}

	public void addTeamMember(Employee e) throws ExEmployeeAlreadyInTeam {
		for (Employee e1 : allMembers)
			if (e1.getName().equals(e.getName()))
				throw new ExEmployeeAlreadyInTeam();

		allMembers.add(e);
		e.addTeam(this);
		Collections.sort(allMembers);
	}

	public void removeTeamMember(Employee e) {
		allMembers.remove(e);
		e.removeTeam(this);
	}

	public void removeAllAssoTeamMember() {
		for (Employee e : allMembers)
			e.removeTeam(this);
	}

	public void listAllMembers() {
		for (Employee e : allMembers)
			if (e.getName().equals(getHeadName()))
				System.out.println(e.getName() + " (Head of Team)");
			else
				System.out.println(e.getName());
	}

	@Override
	public int compareTo(Team another) {
		return this.teamName.compareTo(another.teamName);
	}
}
