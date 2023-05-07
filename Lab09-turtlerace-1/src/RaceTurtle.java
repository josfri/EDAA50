
import java.util.Random;

public class RaceTurtle extends Turtle {

	private int nbr;
	private Random rand;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		rand = new Random();
		penDown();
		left(-90);

	}

	void raceStep() {
		forward(rand.nextInt(6) + 1);
	}

	public String toString() {
		return "Nummer " + nbr;
	}

}
