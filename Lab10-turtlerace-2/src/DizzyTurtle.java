
import java.util.Random;

public class DizzyTurtle extends RaceTurtle {

	private int dizzyness;
	private Random rand;

	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		rand = new Random();
		
		this.dizzyness = rand.nextInt(5) + 1;
	}
	

	void raceStep() { 

		int newDir = rand.nextInt(51)-25; 
		
		super.left(newDir * dizzyness); // gånger yrselnivån
		super.raceStep();
		
		if (super.getDirection() <= -10 ||super.getDirection() >= -170 ) { // ser till att den inte vänder bakåt
			super.turnNorth();
			super.left(-90);
		}

	}
	
	@Override
	public String toString() {
		return super.toString() + " - DizzyTurtle (Yrsel: " + dizzyness + ")";
	}

}
