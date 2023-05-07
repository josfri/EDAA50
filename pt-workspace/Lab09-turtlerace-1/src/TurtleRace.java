
import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {

		RaceWindow w = new RaceWindow(); // skapar ett racewindow

		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>(); // skapar en tom Array
		ArrayList<RaceTurtle> finishedTurtles = new ArrayList<RaceTurtle>(); // skapar en array för alla som gått i mål

		for (int i = 0; i < 8; i++) { // skapar alla RaceTurtles i Arrayen

			turtles.add(new RaceTurtle(w, i + 1));

		}

		w.waitForMouseClick(); // inväntar användarens startsignal

		while (!turtles.isEmpty()) {

			for (int i = 0; i < turtles.size(); i++) {

				if (turtles.get(i).getX() < RaceWindow.X_END_POS) {
					turtles.get(i).raceStep();
					RaceWindow.delay(8);
				} else if (turtles.contains(turtles.get(i))) {
					finishedTurtles.add(turtles.get(i));
					turtles.remove(turtles.get(i));
					i--;
				}
			}
		}

		System.out.println("På plats 1: " + finishedTurtles.get(0).toString()); // skriver ut resultat
		System.out.println("På plats 2: " + finishedTurtles.get(1).toString());
		System.out.println("På plats 3: " + finishedTurtles.get(2).toString());

	}

}
