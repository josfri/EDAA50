import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {

	// lista av attribut
	protected double x; // x-koord
	protected double y; // y-koord
	protected SimpleWindow w; // fönster
	private boolean isPenDown; // bestämmer om pennan är nere eller inte
	private int angle; // bestämmer vilken vinkel sköldpaddan kollar

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */

	public Turtle(SimpleWindow w, int x, int y) { // konstruktor + parametrar inom ()
		this.x = x;
		this.y = y;
		this.w = w;
		this.isPenDown = false; // pennan börjar lyft
		this.angle = 90; // sköldpaddan startar uppåt
	}

	/** Sänker pennan. */
	public void penDown() {
		isPenDown = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		isPenDown = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */

	public void forward(int n) {

		w.moveTo((int) Math.round(x), (int) Math.round(y)); // startpunkt

		// olika beroende på om pennan är nere eller inte

		if (isPenDown == true) {

			double x1 = x + n * Math.cos(Math.toRadians(angle)); // beräknar förflyttning // x1 är exempel på lokal variabel
			double y1 = y - n * Math.sin(Math.toRadians(angle));
			w.lineTo((int) Math.round(x1), (int) Math.round(y1)); // ritar

			x = x1; // ger koordinaterna nya värden
			y = y1;

		} else if (isPenDown == false) {

			double x1 = x + n * Math.cos(Math.toRadians(angle)); // beräknar
			double y1 = y - n * Math.sin(Math.toRadians(angle));
			w.moveTo((int) Math.round(x1), (int) Math.round(y1)); // flyttar

			x = x1; // nya värden
			y = y1;

		}

	}

	/** Vrider beta grader åt vänster runt pennan. */

	public void left(int beta) {
		angle += beta; // lägger till beta på ursprungliga vinkeln
	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */

	public void jumpTo(int newX, int newY) {
		w.moveTo(newX, newY);
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */

	public void turnNorth() {
		angle = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */

	public int getX() {
		return (int) Math.round(x);
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */

	public int getY() {
		return (int) Math.round(y);
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */

	public int getDirection() {
		return angle;
	}
}
