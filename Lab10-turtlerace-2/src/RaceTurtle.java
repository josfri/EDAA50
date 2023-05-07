
import java.awt.Color;
import java.util.Random;

public class RaceTurtle extends Turtle {

	protected int nbr;
	private Random rand;
	private Color color;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		rand = new Random();
		penDown();
		left(-90);
		color = setColor();

	}

	void raceStep() {
		w.setLineColor(color);
		forward(rand.nextInt(6) + 1);
	}

	public String toString() {
		return "Nummer " + nbr;
	}

	private Color setColor() {
		Color[] colors = new Color[8];

		colors[0] = new Color(204, 20, 20);
		colors[1] = Color.RED;
		colors[2] = Color.ORANGE;
		colors[3] = Color.YELLOW;
		colors[4] = new Color(204, 255, 30);
		colors[5] = Color.GREEN;
		colors[6] = Color.BLUE;
		colors[7] = new Color(150, 30, 150);

		return colors[nbr - 1];

	}

}
