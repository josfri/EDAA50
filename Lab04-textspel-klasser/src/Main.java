
import java.util.Scanner;
import se.lth.cs.pt.timer.Timer;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String answer;
		String yesno;
		int win = 0;
		int loss = 0;

		System.out.println("Datorn utmanar dig i sten, sax, påse!");
		Timer.delay(1000);

		do {

			SmallGame g = new SmallGame();

			System.out.println("Skriv in ditt val av sten, sax, eller påse.");
			answer = scan.next();

			if (answer.equalsIgnoreCase("sten") && g.getChoice() == 1) {
				System.out.println("Datorn valde sax");
				System.out.println("Du vann!");
				win++;

			} else if (answer.equalsIgnoreCase("sten") && g.getChoice() == 0) {
				System.out.println("Datorn valde sten");
				System.out.println("Ingen vann!");

			} else if (answer.equalsIgnoreCase("sten") && g.getChoice() == 2) {
				System.out.println("Datorn valde påse");
				System.out.println("Datorn vann!");
				loss++;
			} else if (answer.equalsIgnoreCase("sax") && g.getChoice() == 1) {
				System.out.println("Datorn valde sax");
				System.out.println("Ingen vann!");

			} else if (answer.equalsIgnoreCase("sax") && g.getChoice() == 0) {
				System.out.println("Datorn valde sten");
				System.out.println("Datorn vann!");
				loss++;

			} else if (answer.equalsIgnoreCase("sax") && g.getChoice() == 2) {
				System.out.println("Datorn valde påse");
				System.out.println("Du vann!");
				win++;
			} else if (answer.equalsIgnoreCase("påse") && g.getChoice() == 1) {
				System.out.println("Datorn valde sax");
				System.out.println("Datorn vann!");
				loss++;

			} else if (answer.equalsIgnoreCase("påse") && g.getChoice() == 0) {
				System.out.println("Datorn valde sten");
				System.out.println("Du vann!");
				win++;

			} else if (answer.equalsIgnoreCase("påse") && g.getChoice() == 2) {
				System.out.println("Datorn valde påse");
				System.out.println("Ingen vann!");

			}
			System.out.println("Vill du spela igen?");
			yesno = scan.next();

		} while (yesno.equalsIgnoreCase("ja"));

		System.out.println("Datorn vann " + loss + " gånger och du vann " + win + " gånger.");

		if (win > loss) {
			System.out.print("Grattis!");
		} else {
			System.out.print("Bättre lycka nästa gång!");
		}
	}
}