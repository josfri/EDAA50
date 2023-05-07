
public class Customer {
	private String name;
	private long idNr;
	private int customerNr;
	private static int nr = 100;

	Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		customerNr = nr;
		nr++;

	}

	/** Tar reda på kundens namn. */
	public String getName() {
		return name;
	}

	/** Tar reda på kundens personnummer. */
	public long getIdNr() {
		return idNr;

	}

	/** Tar reda på kundens kundnummer. */
	public int getCustomerNr() {
		return customerNr;
	}

	/** Returnerar en strängbeskrivning av kunden. */
	public String toString() {
		return getName() + ", id " + getIdNr() + ", kundnr " + getCustomerNr();
	}
}
