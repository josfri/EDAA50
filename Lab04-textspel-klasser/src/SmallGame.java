import java.util.Random;

public class SmallGame {

	Random rand = new Random();
	private int comp;

	public SmallGame() {
		choose();
	}

	public void choose() {
		comp = rand.nextInt(3);
		// 0 är sten, 1 är sax, 2 är påse
	}

	public int getChoice() {
		return comp;
	}
}
