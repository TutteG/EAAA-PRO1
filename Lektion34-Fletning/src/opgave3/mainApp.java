package opgave3;

import java.util.ArrayList;
import java.util.Collections;

public class mainApp {

	/**
	 * Returnerer en sorteret ArrayList der indeholder alle customers fra l1 der
	 * ikke er i l2 Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
	 * indeholder ikke tomme pladser
	 */
	public static ArrayList<Customer> goodCustomers(ArrayList<Customer> l1, Customer[] l2) {
		int i1 = 0;
		int i2 = 0;
		ArrayList<Customer> goodCustomers = new ArrayList<Customer>();
		while (i1 < l1.size() && i2 < l2.length) {
			if (l1.get(i1).compareTo(l2[i2]) < 0) {
				goodCustomers.add(l1.get(i1));
				i1++;
			} else if (l1.get(i1).compareTo(l2[i2]) == 0) {
				i1++;
				i2++;
			} else {
				i2++;
			}
		}
		while (i1 < l1.size()) {
			goodCustomers.add(l1.get(i1));
			i1++;
		}
		return goodCustomers;
	}

	public static void main(String[] args) {
		ArrayList<Customer> l1 = new ArrayList<Customer>();

		Customer c1 = new Customer("Jensen", "Torben", 16);
		Customer c2 = new Customer("Nielsen", "Torben", 16);
		Customer c3 = new Customer("Faber", "Torben", 16);
		Customer c4 = new Customer("Hansen", "Torben", 16);
		Customer c5 = new Customer("Vrou", "Torben", 16);
		Customer c6 = new Customer("Moeskjær", "Torben", 16);
		Customer c7 = new Customer("Sloth", "Torben", 16);
		Customer c8 = new Customer("Jönsson", "Torben", 16);
		Customer c9 = new Customer("August", "Torben", 16);

		l1.add(c1);
		l1.add(c2);
		l1.add(c3);
		l1.add(c4);
		l1.add(c5);
		l1.add(c6);
		l1.add(c7);
		Collections.sort(l1);
		System.out.println(l1);

		Customer[] customers = new Customer[l1.size()];
		for (int i = 0; i < customers.length; i++) {
			customers[i] = l1.get(i);
		}
		for (int i = 0; i < customers.length; i++) {
			System.out.print(customers[i] + " ");
		}
		System.out.println();
		l1.add(c8);
		l1.add(c9);
		Collections.sort(l1);
		System.out.println(goodCustomers(l1, customers));
	}
}
