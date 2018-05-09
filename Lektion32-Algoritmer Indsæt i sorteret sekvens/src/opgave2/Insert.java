package opgave2;

import java.util.ArrayList;

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

	public static void insertionSort(Customer[] customers) {
		for (int i = 1; i < customers.length - 1 && customers[i] != null; i++) {
			Customer next = customers[i];

			int j = i;
			boolean found = false;
			while (!found && j > 0) {
				if (next.compareTo(customers[j - 1]) >= 0) {
					found = true;
				} else {
					Customer temp = customers[j];
					customers[j] = customers[j - 1];
					customers[j - 1] = temp;
					// Collections.swap(customers, j, j - 1);
					j--;
				}
			}
			customers[j] = next;
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

		Customer[] customers = { c1, c2, c3, c4, c5, c6, c7, null };
		for (int i = 0; i < customers.length; i++) {
			System.out.print(customers[i] + " ");
		}

		Insert.insertionSort(customers);
		System.out.println();
		for (int i = 0; i < customers.length; i++) {
			System.out.print(customers[i] + " ");
		}

		System.out.println(customers);
		Customer c8 = new Customer("Andersen", "Anders", 27);
		// Insert.insertCustomer(customers, c8);
		System.out.println(customers);
	}
}
