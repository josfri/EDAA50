
import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String[] args) {

		RaceWindow w = new RaceWindow(); // skapar ett racewindow
		Random rand = new Random();

		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>(); // skapar en tom Array
		ArrayList<RaceTurtle> finishedTurtles = new ArrayList<RaceTurtle>(); // skapar en array för alla som gått i mål

		for (int i = 0; i < 8; i++) { // skapar alla RaceTurtles i Arrayen

			int type = rand.nextInt(3);

			if (type == 0) {
				turtles.add(new AbsentMindedTurtle(w, i + 1));

			} else if (type == 1) {
				turtles.add(new DizzyTurtle(w, i + 1));

			} else {
				turtles.add(new MoleTurtle(w, i + 1));

			}
			w.setLineWidth(7);

		}

		for (int i = 0; i < 8; i++) { // skapar alla RaceTurtles i Arrayen

			System.out.println(turtles.get(i).toString());
		}

		w.waitForMouseClick(); // inväntar användarens startsignal

		while (!turtles.isEmpty()) {

			for (int i = 0; i < turtles.size(); i++) {

				if (turtles.get(i).getX() < RaceWindow.X_END_POS) {
					turtles.get(i).raceStep();
					RaceWindow.delay(5);
				} else if (turtles.contains(turtles.get(i))) {
					finishedTurtles.add(turtles.get(i));
					turtles.remove(turtles.get(i));
					i--;
				}
			}
		}
		System.out.println();
		System.out.println("Resultatet blev:");
		System.out.println("På plats 1: " + finishedTurtles.get(0).toString()); // skriver ut resultat
		System.out.println("På plats 2: " + finishedTurtles.get(1).toString());
		System.out.println("På plats 3: " + finishedTurtles.get(2).toString());

	}

}
