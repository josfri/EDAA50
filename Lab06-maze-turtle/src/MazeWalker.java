import java.awt.Color;
import java.util.Random;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {

	private Turtle turtle;
	private int x; // x-koord
	private int y; // y-koord
	private int direction; 

	public MazeWalker(Turtle turtle) { // konstruktor
		this.direction = turtle.getDirection();
		this.x = turtle.getX();
		this.y = turtle.getY();
		this.turtle = turtle;
	}

	public void walk(Maze maze, SimpleWindow w) {

		x = maze.getXEntry();
		y = maze.getYEntry();
		
		turtle.jumpTo(x, y);
		turtle.penDown();
		int steps = 0;
		int turns = 0;

		do {
			
			Random rand = new Random();
			Color MIX = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
			w.setLineColor(MIX);

			if (maze.wallAtLeft(direction, x, y) == true && maze.wallInFront(direction, x, y) == false) {
				
				
				turtle.forward(1);
				x = turtle.getX();
				y = turtle.getY();
				SimpleWindow.delay(15);

			} else if (maze.wallAtLeft(direction, x, y) == false && maze.wallInFront(direction, x, y) == false) {

				turtle.left(90);
				turtle.forward(1);
				x = turtle.getX();
				y = turtle.getY();
				SimpleWindow.delay(15);
				direction = turtle.getDirection();
				
				turns ++;

			} else if (maze.wallAtLeft(direction, x, y) == true && maze.wallInFront(direction, x, y) == true) {

				turtle.left(270);
				turtle.forward(1);
				x = turtle.getX();
				y = turtle.getY();
				SimpleWindow.delay(15);
				direction = turtle.getDirection();
				
				turns ++;

			} else {
				
				turtle.forward(1);
				x = turtle.getX();
				y = turtle.getY();
				SimpleWindow.delay(15);
				
			} steps ++;
			

		} while (maze.atExit(x, y) == false);
		
		System.out.println("Sköldpaddan gick " + steps + " steg!");
		System.out.println("Sköldpaddan svängde " + turns + " gånger!");
		

	}
}
