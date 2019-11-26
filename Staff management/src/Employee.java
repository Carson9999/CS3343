import java.util.ArrayList;
import java.util.Collections;

public class Employee implements Comparable<Employee> {

	private String name;
	private int yrLeavesEntitled;
	private ArrayList<LeaveRecord> allLeaveRecord;
	private ArrayList<Team> allTeam;

	public Employee(String n, int yle) {
		this.name = n;
		this.yrLeavesEntitled = yle;
		allLeaveRecord = new ArrayList<>();
		allTeam = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public int getYrLeavesEntitled() {
		return yrLeavesEntitled;
	}

	public static Employee searchEmployee(ArrayList<Employee> list, String nameToSearch) throws ExEmployeeNotFound {
		for (Employee aList : list)
			if (aList.getName().equals(nameToSearch))
				return aList;
		throw new ExEmployeeNotFound();
	}

	public void addLeave(LeaveRecord r) throws ExOverlappedLeaves, ExDateHasAlreadyPassed, ExInsufficientBalance {
		Day currentDay = SystemDate.getInstance().clone();
		if (r.getsDay() < currentDay.getIntDay())
			throw new ExDateHasAlreadyPassed(currentDay);

		for (LeaveRecord r1 : allLeaveRecord)
			if ((r.getsDay() > r1.getsDay() && r.getsDay() < r1.geteDay()) || (r.geteDay() > r1.getsDay() && r.geteDay() < r1.geteDay()))
				throw new ExOverlappedLeaves(r1);

		if (yrLeavesEntitled < r.daysBetween())
			throw new ExInsufficientBalance(yrLeavesEntitled);

		allLeaveRecord.add(r);
		yrLeavesEntitled -= r.daysBetween();
		Collections.sort(allLeaveRecord);
	}

	public void removeLeave(LeaveRecord r) {
		yrLeavesEntitled += r.daysBetween();
		allLeaveRecord.remove(r);
	}

	public void listAllLeaves() {
		if (allLeaveRecord.size() == 0)
			System.out.println("No leave record");

		for (LeaveRecord r : allLeaveRecord)
			System.out.println(r.toString());
	}

	public void addTeam(Team t) {
		allTeam.add(t);
		Collections.sort(allTeam);
	}

	public void removeTeam(Team t) {
		allTeam.remove(t);
	}

	public void listRoles() {
		if (allTeam.size() == 0)
			System.out.println("No role");

		for (Team t : allTeam)
			if (t.getHeadName().equals(name))
				System.out.println(t.getName() + " (Head of Team)");
			else
				System.out.println(t.getName());
	}

	@Override
	public int compareTo(Employee another) {
		return this.name.compareTo(another.name);
	}
}
