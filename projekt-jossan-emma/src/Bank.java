import java.util.ArrayList;

public class Bank {

	private ArrayList<BankAccount> bank;

	/** Skapar en ny bank utan konton. */
	public Bank() {
		bank = new ArrayList<BankAccount>();
	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
	 * givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	public int addAccount(String holderName, long idNr) {

		for (int i = 0; i < bank.size(); i++) {
			if (idNr == bank.get(i).getHolder().getIdNr()) {
				BankAccount b = new BankAccount(bank.get(i).getHolder());
				bank.add(b);
				return b.getAccountNumber();
			}
		}
		BankAccount b = new BankAccount(holderName, idNr);
		bank.add(b);
		return b.getAccountNumber();
	}

	/**
	 * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
	 * ingen sådan finns.
	 */
	public Customer findHolder(long idNr) {

		for (int i = 0; i < bank.size(); i++) {
			if (idNr == bank.get(i).getHolder().getIdNr()) {
				return bank.get(i).getHolder();
			}
		}
		return null;

	}

	/**
	 * Tar bort konto med nummer 'number' från banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	public boolean removeAccount(int number) {

		for (int i = 0; i < bank.size(); i++) {
			if (number == bank.get(i).getAccountNumber()) {
				bank.remove(i);
				return true;
			}
		}
		return false;

	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	public ArrayList<BankAccount> getAllAccounts() {

		ArrayList<BankAccount> sorted = new ArrayList<BankAccount>();

		for (int i = 0; i < bank.size(); i++) {
			sorted.add(bank.get(i));
		}

		for (int i = 0; i < sorted.size(); i++) {
			for (int k = i + 1; k < sorted.size(); k++) {
				BankAccount temp = new BankAccount("a", 1);
				String b1 = sorted.get(i).getHolder().getName();
				String b2 = sorted.get(k).getHolder().getName();

				if (b1.compareTo(b2) > 0) {
					temp = sorted.get(i);
					sorted.set(i, sorted.get(k));
					sorted.set(k, temp);

				}
			}
		}
		return sorted;

	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer 'accountNumber'.
	 * Returnerar null om inget sådant konto finns.
	 */
	public BankAccount findByNumber(int accountNumber) {

		for (int i = 0; i < bank.size(); i++) {
			if (accountNumber == bank.get(i).getAccountNumber()) {
				return bank.get(i);
			}
		}
		return null;

	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer 'idNr'. Kontona
	 * returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {

		ArrayList<BankAccount> c = new ArrayList<BankAccount>();

		for (int i = 0; i < bank.size(); i++) {
			if (idNr == bank.get(i).getHolder().getIdNr()) {
				c.add(bank.get(i));
			}
		}
		return c;

	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
	 * vars namn innehåller strängen 'namePart' inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan förekomma flera gånger i
	 * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
	 * på stora och små bokstäver.
	 */
	public ArrayList<Customer> findByPartofName(String namePart) {

		ArrayList<Customer> name = new ArrayList<Customer>();

		

		for (int i = 0; i < bank.size(); i++) {

			if (bank.get(i).getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {

				int repeat = 0;
				
				for (int k = 0; k < name.size(); k++) {

					if (bank.get(i).getHolder().getCustomerNr() == name.get(k).getCustomerNr()) {

						repeat++;
					}
				}
				if (repeat == 0) {
					name.add(bank.get(i).getHolder());
				}
			}
		}
		return name;

	}

	public BankAccount getLatestAccount() {

		return bank.get(bank.size() - 1);

	}

}
