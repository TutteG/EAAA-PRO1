package opgave1;

/**
 *
 * @author Torben
 *
 */
public class BankAccount {
	private double balance;
	private int uniqueId;
	private static int Id;

	/**
	 * <pre>
	 *initialBalance must be &gt; -1
	 * </pre>
	 *
	 * @param initialBalance
	 *            The initial balance of bank account, uniqueId set to static Id
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
		uniqueId = Id;
		Id++;
	}

	/**
	 * <pre>
	 *amount must be &gt; 0
	 * </pre>
	 *
	 * @param amount
	 *            Amount that has been deposited
	 */
	public void deposit(double amount) {
		balance += amount;
	}

	/**
	 * <pre>
	 *balance must be &gt; 0 after withdrawal
	 * </pre>
	 *
	 * @param amount
	 *            amount that has been withdrawn
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}

	/**
	 *
	 * @return balance as double
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the uniqueId
	 */
	public int getUniqueId() {
		return uniqueId;
	}

	/**
	 * @return the Id
	 */
	public static int getId() {
		return Id;
	}

}
