package memory;

import javax.swing.JOptionPane;

import se.lth.cs.pt.window.SimpleWindow;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		String backFileName = "back.jpg";

		MemoryBoard bräde = new MemoryBoard(4, backFileName, frontFileNames);
		MemoryWindow w = new MemoryWindow(bräde);
		w.drawBoard();

		int tries = 0;

		while (bräde.hasWon() == false) {

			int felett = 0;
			int feltvå = 0;

			w.waitForMouseClick();
			int r1 = w.getMouseRow();
			int c1 = w.getMouseCol();

			if (bräde.frontUp(r1, c1)) {
				felett++;
			} else {

				bräde.turnCard(r1, c1);
				w.drawCard(r1, c1);
			}

			w.waitForMouseClick();
			int r2 = w.getMouseRow();
			int c2 = w.getMouseCol();

			if (bräde.frontUp(r2, c2)) {
				feltvå++;
			} else {

				bräde.turnCard(r2, c2);
				w.drawCard(r2, c2);
			}

			if (!bräde.same(r1, c1, r2, c2) && felett == 0 && feltvå == 0) {

				SimpleWindow.delay(500);

				bräde.turnCard(r1, c1);
				bräde.turnCard(r2, c2);
				w.drawCard(r1, c1);
				w.drawCard(r2, c2);
				
			} else if (felett == 1 && feltvå == 0) {
				SimpleWindow.delay(500);
				bräde.turnCard(r2, c2);
				w.drawCard(r2, c2);
				
			} else if (felett == 0 && feltvå == 1) {
				SimpleWindow.delay(500);
				bräde.turnCard(r1, c1);
				w.drawCard(r1, c1);
			}

			tries++;

		}
		

		JOptionPane.showMessageDialog(null,
				"Du använde " + tries + " stycken försök!",
				"Grattis, du vann!", JOptionPane.INFORMATION_MESSAGE);
		
		

	}
}
