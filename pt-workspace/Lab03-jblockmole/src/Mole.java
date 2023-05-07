
public class Mole {

	Graphics g = new Graphics(30, 50, 10);

	public static void main(String[] args) {
		// System.out.println("Keep on digging");

		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}

	// g.square();
	// g.block(20,10, Colors.SOIL);

	public void drawWorld() {
		g.rectangle(0, 4, 30, 50, Colors.SOIL);
		g.rectangle(0, 0, 30, 3, Colors.SKY);
		g.rectangle(0, 3, 30, 1, Colors.GRASS);
		g.rectangle(5, 0, 2, 1, Colors.CLOUD);
		g.rectangle(12, 1, 3, 1, Colors.CLOUD);
		g.rectangle(13, 0, 1, 1, Colors.CLOUD);
		g.rectangle(24, 1, 2, 1, Colors.CLOUD);
	}

	public void dig() {
		int x = g.getWidth() / 2;
		int y = g.getHeight() / 2;
		while (true) {

			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();

			if (key == 'w' && !(y < 5)) {
				g.block(x, y - 1, Colors.MOLE);
				g.block(x, y, Colors.TUNNEL);
				y = y - 1;
			} else if (key == 'w' && (y == 4)) {
				g.block(x, y - 1, Colors.MOLE);
				g.block(x, y, Colors.TUNNEL);
				y = y - 1;
			} else if (key == 'a' && y == 3) {
				g.block(x - 1, y, Colors.MOLE);
				g.block(x, y, Colors.GRASS);
				x = x - 1;
			} else if (key == 'd' && y == 3) {
				g.block(x + 1, y, Colors.MOLE);
				g.block(x, y, Colors.GRASS);
				x = x + 1;
			} else if (key == 's' && y == 3) {
				g.block(x, y + 1, Colors.MOLE);
				g.block(x, y, Colors.GRASS);
				y = y + 1;
			} else if (key == 'a' && !(x < 1)) {
				g.block(x - 1, y, Colors.MOLE);
				g.block(x, y, Colors.TUNNEL);
				x = x - 1;
			} else if (key == 's' && !(y > 48)) {
				g.block(x - 0, y + 1, Colors.MOLE);
				g.block(x, y, Colors.TUNNEL);
				y = y + 1;
			} else if (key == 'd' && !(x > 28)) {
				g.block(x + 1, y - 0, Colors.MOLE);
				g.block(x, y, Colors.TUNNEL);
				x = x + 1;

			}
		}
	}
}
