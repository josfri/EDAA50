package pair;

import java.util.Random;

public class PairSet {

	private int n;
	private Pair[] pairs;
	private static Random rand = new Random();

	/**
	 * Skapar en mängd av alla talpar (a,b) sådana att 0 <= a < rows och 0 <= b <
	 * cols
	 */

	public PairSet(int rows, int cols) {

		n = rows * cols;
		pairs = new Pair[n];
		int r = 0;

		for (int i = 0; i < rows; i++) {

			for (int k = 0; k < cols; k++) {

				pairs[r] = new Pair(i, k);
				r++;
			}
		}
	}

	/** Undersöker om det finns fler par i mängden. */
	public boolean more() {
		if (n > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Hämtar ett slumpmässigt valt talpar ur mängden. Mängden blir ett element
	 * mindre. Om mängden är tom returneras null.
	 */
	public Pair pick() {
		int pick = rand.nextInt(n);
		Pair u = pairs[pick];
		pairs[pick] = pairs[n - 1];
		n--;

		return u;
	}
}
