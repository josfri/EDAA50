import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class AnimatedSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(250, 250, 100);
		sq.draw(w);
		while (true) {
			int OldX = sq.getX();
			int OldY = sq.getY();
			w.waitForMouseClick();
			int x = w.getClickedX();
			int y = w.getClickedY();
			for (int i = 0; i < 10; i++) {
				SimpleWindow.delay(10);
				sq.erase(w);
				sq.move((x - OldX) / 10, (y - OldY) / 10); 
				sq.draw(w);
			}
		}
	}
}