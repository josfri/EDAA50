package memory;

import pair.Pair;
import pair.PairSet;

public class MemoryBoard {

	private int size;
	private MemoryCardImage[][] kort;
	private boolean[][] turned;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		kort = new MemoryCardImage[size][size];
		turned = new boolean[size][size];
		createCards(backFileName, frontFileNames);
	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {

		PairSet p = new PairSet(4, 4);

		for (int k = 0; k < frontFileNames.length; k++) {

			Pair place1 = p.pick();
			Pair place2 = p.pick();

			kort[place1.first()][place1.second()] = new MemoryCardImage(frontFileNames[k], backFileName);
			kort[place2.first()][place2.second()] = kort[place1.first()][place1.second()];

		}

	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {
		return kort[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if (turned[r][c] == true) {
			turned[r][c] = false;

		} else  {
			turned[r][c] = true;

		}
	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		if (turned[r][c] == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {

		if (kort[r1][c1] == kort[r2][c2]) {
			return true;
		} else {
			return false;
		}
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		int win = 0;
		for (int r = 0; r < size; r++) {

			for (int c = 0; c < size; c++) {

				if (frontUp(r, c)) {
					win++;
				}

			}
		}
		if (win == size * size) {
			return true;
		} else {
			return false;
		}
	}

}
