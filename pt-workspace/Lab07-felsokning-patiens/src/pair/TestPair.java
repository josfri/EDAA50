package pair;

public class TestPair {

	public static void main(String[] args) {
		
		PairSet p = new PairSet(4,13);
		
		
		for (int i = 0; i < 52; i++) {
		
		System.out.println(p.pick());
		System.out.println(p.more());
		System.out.println(i);
		}
		

	}

}
