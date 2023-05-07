import java.util.Scanner;

public class BankApplication {

	private Scanner scan = new Scanner(System.in);
	private static Bank bank = new Bank();

	public static void main(String[] args) {

		BankApplication b = new BankApplication();
		b.runApplication();
	}

	private void runApplication() {

		getMenu();

		while (true) {

			int val = scan.nextInt();
			System.out.println("Val: " + val);

			if (val == 1) {
				valEtt();

			} else if (val == 2) {
				valTvå();

			} else if (val == 3) {
				valTre();

			} else if (val == 4) {
				valFyra();

			} else if (val == 5) {
				valFem();

			} else if (val == 6) {
				valSex();

			} else if (val == 7) {
				valSju();

			} else if (val == 8) {
				valÅtta();

			} else if (val == 9) {
				valNio();
				break;

			} else {
				System.out.println("Menyvalet finns inte. Vänligen ange en siffra mellan 1-9.");
			}
			System.out.println("Ange ett nytt val:");

		}

	}

	private void getMenu() {

		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. Sätt in");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
		System.out.println("9. Avsluta");

	}

	private void valEtt() {

		System.out.print("id:");
		long idNr = scan.nextLong();

		for (int i = 0; i < bank.findAccountsForHolder(idNr).size(); i++) {
			System.out.println(bank.findAccountsForHolder(idNr).get(i).toString());
		}

		if (bank.findAccountsForHolder(idNr).size() == 0) {
			System.out.println("Inget konto har registrerats med detta ID.");
		}
	}

	private void valTvå() {

		scan.nextLine();
		System.out.println("Ange ett namn / del av namn: ");
		String name = scan.nextLine();

		for (int i = 0; i < bank.findByPartofName(name).size(); i++) {
			System.out.println(bank.findByPartofName(name).get(i).toString());
		}

		if (bank.findByPartofName(name).size() == 0) {
			System.out.println("Inga konton med detta namn kunde hittas.");
		}
	}

	private void valTre() {

		System.out.println("Ange konto: ");
		int konto = scan.nextInt();

		if (!(bank.findByNumber(konto) == null)) {

			System.out.println("Ange belopp: ");
			double belopp = scan.nextDouble();

			if ((belopp >= 0)) {

				bank.findByNumber(konto).deposit(belopp);
				System.out.println(bank.findByNumber(konto).toString());
			} else {
				System.out.println("Beloppet du angett är negativt. Försök igen.");
			}

		} else {
			System.out.println("Kontot finns inte.");
		}
	}

	private void valFyra() {

		System.out.println("Ange konto: ");
		int konto = scan.nextInt();

		if (!(bank.findByNumber(konto) == null)) {

			System.out.println("Ange belopp: ");
			double belopp = scan.nextDouble();

			if (belopp > bank.findByNumber(konto).getAmount()) {
				System.out.println(
						"Uttaget misslyckades, endast " + bank.findByNumber(konto).getAmount() + " på kontot!");

			} else if (belopp < 0) {

				System.out.println("Beloppet du angett är negativt. Försök igen.");
			}

			else {
				bank.findByNumber(konto).withdraw(belopp);
				System.out.println(bank.findByNumber(konto).toString());
			}

		} else {
			System.out.println("Kontot finns inte.");
		}
	}

	private void valFem() {

		System.out.println("Från konto: ");
		int konto1 = scan.nextInt();

		System.out.println("Till konto: ");
		int konto2 = scan.nextInt();

		if (bank.findByNumber(konto1) == null && bank.findByNumber(konto2) == null) {

			System.out.println("Konto " + konto1 + " och " + konto2 + " finns inte. Försök igen.");
			
		} else if (bank.findByNumber(konto1) == null) {
			
			System.out.println("Konto " + konto1 + " finns inte. Försök igen.");
			
		} else if (bank.findByNumber(konto2) == null) {
			
			System.out.println("Konto " + konto2 + " finns inte. Försök igen.");
			
		} else {
		
			System.out.println("Ange belopp: ");
			double belopp = scan.nextDouble();

			if (belopp > bank.findByNumber(konto1).getAmount()) {
				System.out.println(
						"Överföringen misslyckades, endast " + bank.findByNumber(konto1).getAmount() + " på kontot!");
			} else {

				bank.findByNumber(konto1).withdraw(belopp);
				bank.findByNumber(konto2).deposit(belopp);
			}

			System.out.println(bank.findByNumber(konto1).toString());
			System.out.println(bank.findByNumber(konto2).toString());
		}
	}

	private void valSex() {

		scan.nextLine();
		System.out.println("Namn: ");
		String name = scan.nextLine();

		System.out.println("Id-nummer: ");
		long id = scan.nextLong();

		bank.addAccount(name, id);

		System.out.println("Nytt konto: " + bank.getLatestAccount().getAccountNumber());

	}

	private void valSju() {

		System.out.println("Välj konto att ta bort: ");
		int konto = scan.nextInt();

		if (!bank.removeAccount(konto)) {
			System.out.println("Felaktigt kontonummer!");
		} else {
			System.out.println("Kontot är nu raderat.");
		}

	}

	private void valÅtta() {

		for (int i = 0; i < bank.getAllAccounts().size(); i++) {
			System.out.println(bank.getAllAccounts().get(i).toString());
		}

		if (bank.getAllAccounts().size() == 0) {
			System.out.println("Banken har inga konton.");
		}
	}

	private void valNio() {

		System.out.println("Programmet avslutas.");

	}
}
