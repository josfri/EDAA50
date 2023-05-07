
public class BankAccount {

	private Customer holder;
	private double saldo;
	private int accountNr;
	private static int nr = 1000;

	/**
	 * Skapar ett nytt bankkonto åt en innehavare med namn 'holderName' och id
	 * 'holderId'. Kontot tilldelas ett unikt kontonummer och innehåller
	 * inledningsvis 0 kr.
	 */
	public BankAccount(String holderName, long holderId) {

		holder = new Customer(holderName, holderId);
		saldo = 0;
		accountNr = nr;
		nr++;

	}

	/**
	 * Skapar ett nytt bankkonto med innehavare 'holder'. Kontot tilldelas ett unikt
	 * kontonummer och innehåller inledningsvis 0 kr.
	 */
	public BankAccount(Customer holder) {
		this.holder = holder;
		saldo = 0;
		accountNr = nr;
		nr++;
	}

	/** Tar reda på kontots innehavare. */
	public Customer getHolder() {
		return holder;
	}

	/** Tar reda på det kontonummer som identifierar detta konto. */
	public int getAccountNumber() {
		return accountNr;

	}

	/** Tar reda på hur mycket pengar som finns på kontot. */
	public double getAmount() {
		return saldo;

	}

	/** Sätter in beloppet 'amount' på kontot. */
	public void deposit(double amount) {
		saldo += amount;

	}

	/**
	 * Tar ut beloppet 'amount' från kontot. Om kontot saknar täckning blir saldot
	 * negativt.
	 */
	public void withdraw(double amount) {
		saldo -= amount;

	}

	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return "Konto " + getAccountNumber() + " (" + holder.toString() + "): " + saldo;

	}
}
