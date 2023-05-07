
public class Main {

	public static void main(String[] args) {
		
		VolunteerTaskList v = new VolunteerTaskList();
		
		v.add("i", 1, 1);
		v.add("k", 5, 2);
		v.add("j", 12, 3);
		v.add("ä", 4, 2);
		
		System.out.println(v.toSortedArray().toString());

	}

}
