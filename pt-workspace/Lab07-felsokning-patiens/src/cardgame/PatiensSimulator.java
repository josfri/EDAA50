package cardgame;

import pair.PairSet;
import pair.Pair;

public class PatiensSimulator {

	private static final double NBR_ITERATIONS = 1000000;

	public static void main(String[] args) {

		// PairSet cardDeck = new PairSet(4, 13);

		double win = 0;

		for (int k = 0; k < NBR_ITERATIONS; k++) {

			PairSet cardDeck = new PairSet(4, 13);

			int i = 0;
			int loss = 0;

			while (cardDeck.more()) {

				Pair p = cardDeck.pick();

				if (i % 3 == p.second()) {
					loss++;
				}
				i++;
			}

			if (loss == 0) {
				win++;
			}

		}
		System.out.println((win / NBR_ITERATIONS));
	}
}
