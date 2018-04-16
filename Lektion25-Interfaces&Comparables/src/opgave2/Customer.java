package opgave2;

import java.util.Arrays;

public class Customer implements Comparable<Customer> {
	private String firstName;
	private String lastName;
	private int age;

	public Customer(String firstName, String lastName, int age) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		if (this.lastName.compareTo(o.lastName) == 0) {
			if (this.firstName.compareTo(o.firstName) == 0) {
				return this.age - o.age;
			} else if (this.firstName.compareTo(o.firstName) < 0) {
				return -1;
			} else {
				return 1;
			}
		} else if (this.lastName.compareTo(o.lastName) < 0) {
			return -1;
		} else {
			return 1;
		}
	}

	public static Customer lastCustomer(Customer[] customers) {
		Customer customer = customers[0];
		for (int i = 1; i < customers.length; i++) {
			if (customer.compareTo(customers[i]) < 0) {
				customer = customers[i];
			} else {
				// do nothing
			}
		}
		return customer;
	}

	public static Customer[] afterCustomers(Customer[] customers, Customer customer) {
		Customer[] afterCustomers = customers.clone();
		Arrays.sort(afterCustomers);
		int after = 0;
		for (int i = 0; i < afterCustomers.length; i++) {
			if (afterCustomers[i].equals(customer)) {
				after = i + 1;
			}
		}
		return Arrays.copyOfRange(afterCustomers, after, afterCustomers.length);
	}
}
