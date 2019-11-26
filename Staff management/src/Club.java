import java.util.ArrayList;
import java.util.Collections;

public class Club implements Comparable<Club> {

	private String ClubName;
	private Teacher head;
	private Day dateSetup;
	private ArrayList<Teacher> allMembers;

	public Club(String n, Teacher hd) {
		this.ClubName = n;
		this.head = hd;
		this.dateSetup = SystemDate.getInstance().clone();
		allMembers = new ArrayList<>();
	}

	public String getName() {
		return ClubName;
	}

	public String getHeadName() {
		return head.getName();
	}

	public static void list(ArrayList<Club> list) {
		System.out.printf("%-30s%-10s%-13s\n", "Club Name", "Leader", "Setup Date");
		for (Club t : list)
			System.out.printf("%-30s%-10s%-13s\n", t.ClubName, t.head.getName(), t.dateSetup.toString());
	}

	public void addClubMember(Teacher e) throws ExTeacherAlreadyInClub {
		for (Teacher e1 : allMembers)
			if (e1.getName().equals(e.getName()))
				throw new ExTeacherAlreadyInClub();

		allMembers.add(e);
		e.addClub(this);
		Collections.sort(allMembers);
	}

	public void removeClubMember(Teacher e) {
		allMembers.remove(e);
		e.removeClub(this);
	}

	public void removeAllAssoClubMember() {
		for (Teacher e : allMembers)
			e.removeClub(this);
	}

	public void listAllMembers() {
		for (Teacher e : allMembers)
			if (e.getName().equals(getHeadName()))
				System.out.println(e.getName() + " (Head of Club)");
			else
				System.out.println(e.getName());
	}

	@Override
	public int compareTo(Club another) {
		return this.ClubName.compareTo(another.ClubName);
	}
}
