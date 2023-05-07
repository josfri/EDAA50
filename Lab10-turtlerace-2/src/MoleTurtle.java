import java.util.Random;

public class MoleTurtle extends RaceTurtle {

	private Random rand;

	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		rand = new Random();
	}

	void raceStep() {
		if (rand.nextInt(2) > 0) {
			super.raceStep();
			
		} else {
			super.penUp();
			super.raceStep();
			super.penDown();
		}
	}

	public String toString() {
		return super.toString() + " - MoleTurtle";
	}
}
