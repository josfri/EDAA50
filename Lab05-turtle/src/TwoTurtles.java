import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class TwoTurtles {

	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(600, 600, "TwoTurtles");
		Random rand = new Random();
		Turtle t1 = new Turtle(w, 350, 350);
		Turtle t2 = new Turtle(w, 250, 250);
		t1.penDown();
		t2.penDown();

		int disX = Math.abs(t1.getX() - t2.getX());
		int disY = Math.abs(t1.getY() - t2.getY());
		double totDis = Math.sqrt(disX * disX + disY * disY);

		while (totDis >= 50) {
			t1.forward(rand.nextInt(10) + 1);
			t1.left(rand.nextInt(360 + 1) - 180);

			t2.forward(rand.nextInt(10) + 1);
			t2.left(rand.nextInt(360 + 1) - 180);

			SimpleWindow.delay(10);

			disX = Math.abs(t1.getX() - t2.getX());
			disY = Math.abs(t1.getY() - t2.getY());
			totDis = Math.sqrt(disX * disX + disY * disY);

		}

		// do {
		// t1.forward(rand.nextInt(10)+1);
		// t1.left(rand.nextInt(360 + 1)-180);

		// t2.forward(rand.nextInt(10)+1);
		// t2.left(rand.nextInt(360 + 1)-180);

		// SimpleWindow.delay(10);

		// } while (totDis >= 50); // metod 2

	}

}
