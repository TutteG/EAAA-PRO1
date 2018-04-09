package opgave1;

public class BankAccountApp {
	public static void main(String[] args) {
		System.out.println(BankAccount.getId());
		BankAccount b1 = new BankAccount(100);
		System.out.println(b1.getBalance());

		System.out.println(BankAccount.getId());
	}
}
