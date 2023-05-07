import java.util.Scanner;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MainMaze {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int mazeNbr = scan.nextInt();

		Maze m = new Maze(mazeNbr);
		SimpleWindow w = new SimpleWindow(400, 400, "TurtleMaze");
		Turtle t = new Turtle(w, 0, 0);

		MazeWalker mw = new MazeWalker(t);

		m.draw(w);

		mw.walk(m, w);

	}

}
