package cardreader;

public class TestProgram {

	public static void main(String[] args) {
		
		UserTable test = new UserTable();
		
		System.out.println(test.find(24073));
		System.out.println(test.find(24074));
		System.out.println(test.findByName("Jens Holmgren"));
		System.out.println(test.getNbrUsers());
		
		User u = new User(1234, "Josefine Emma"); //lägger till ny user
		test.add(u);
		System.out.println(test.find(1234));
		System.out.println(test.getNbrUsers()); // ser att den ökar +1
		
		System.out.println(test.testFind()); //ger värdet 0, därmed kan alla hittas
	}

}
