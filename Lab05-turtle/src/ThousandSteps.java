import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class ThousandSteps {
	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(600, 600, "ThousandSteps");
		Random rand = new Random();
		Turtle t = new Turtle(w, 300, 300);
		t.penDown();

		int totSteps = 0;

		do {
			int steps = rand.nextInt(10) + 1;
			t.forward(steps);
			t.left(rand.nextInt(360 + 1) - 180);
			totSteps += steps;

			// SimpleWindow.delay(10);

		} while (totSteps < 1000);

	}
}
