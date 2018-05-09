package opgave1;

import java.util.ArrayList;
import java.util.Collections;

public class Insert {
	public static void insertCustomer(ArrayList<Customer> customers, Customer customer) {
		boolean found = false;
		for (int i = 0; i < customers.size() && !found; i++) {
			if (customer.compareTo(customers.get(i)) < 0) {
				customers.add(i, customer);
				found = true;
				// break;
			}
		}
	}

	public static void insertionSort(ArrayList<Customer> customers) {
		for (int i = 1; i < customers.size(); i++) {
			Customer next = customers.get(i);

			int j = i;
			boolean found = false;
			while (!found && j > 0) {
				if (next.compareTo(customers.get(j - 1)) >= 0) {
					found = true;
				} else {
					Collections.swap(customers, j, j - 1);
					j--;
				}
			}
			customers.set(j, next);
		}
	}

	public static void main(String[] args) {
		System.out.println("her skal testes lort");
		Customer c1 = new Customer("Nielsen", "Torben", 28);
		Customer c2 = new Customer("Hansen", "Peter", 23);
		Customer c3 = new Customer("Faber", "Morten", 21);
		Customer c4 = new Customer("Berg", "Daniel", 29);
		Customer c5 = new Customer("Moeskjær", "Martin", 33);
		Customer c6 = new Customer("Sloth Stræde", "Frederik", 24);
		Customer c7 = new Customer("Steinmeier", "Tom", 27);

		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
		customers.add(c6);
		customers.add(c7);

		System.out.println(customers);

		Insert.insertionSort(customers);
		System.out.println(customers);
		Customer c8 = new Customer("Andersen", "Anders", 27);
		Insert.insertCustomer(customers, c8);
		System.out.println(customers);
	}
}
