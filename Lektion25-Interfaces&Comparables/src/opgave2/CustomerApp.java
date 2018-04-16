package opgave2;

public class CustomerApp {
	public static void main(String[] args) {
		Customer benjamin = new Customer("Benjamen", "Champen", 21);
		Customer morten = new Customer("Morten", "From", 24);
		Customer peter = new Customer("Dr.", "Hansen", 22);
		Customer torben = new Customer("Torbe", "Pro", 28);

		Customer[] customers = { benjamin, morten, peter, torben };
		Customer customer = Customer.lastCustomer(customers);

		// System.out.println(customer.getFirstName() + " " + customer.getLastName());

		Customer[] customers2 = Customer.afterCustomers(customers, torben);
		for (int i = 0; i < customers2.length; i++) {
			System.out.println(customers2[i].getFirstName() + " " + customers2[i].getLastName());
		}
	}
}
