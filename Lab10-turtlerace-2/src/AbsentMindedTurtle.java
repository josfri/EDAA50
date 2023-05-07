import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {

	private int procent;
	private Random rand;

	public AbsentMindedTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		rand = new Random();
		this.procent = rand.nextInt(100); //ej 101 för är den 100% frånvarande går den inte
		
	}

	void raceStep() {
		if (rand.nextInt(101) > procent) {
			super.raceStep();
		}
	}

	public String toString() {
		return super.toString() + " - AbsentMindedTurtle (" + procent + "% Frånvarande)";
	}
}
