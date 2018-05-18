package opgave1;

import java.util.ArrayList;

public class mainApp {
	/**
	 * Returnerer en sorteret ArrayList der indeholder alle kunder fra både l1 og l2
	 * Krav: l1 og l2 er sorterede
	 */
	public static ArrayList<Customer> fletAlleKunder(ArrayList<Customer> l1, ArrayList<Customer> l2) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		int i1 = 0;
		int i2 = 0;

		while (i1 < l1.size() && i2 < l2.size()) {
			if (l1.get(i1).compareTo(l2.get(i2)) < 0) {
				customers.add(l1.get(i1));
				i1++;
			} else if (l1.get(i1).compareTo(l2.get(i2)) > 0) {
				customers.add(l2.get(i2));
				i2++;
			} else {
				customers.add(l1.get(i1));
				i1++;
				i2++;
			}
		}
		while (i1 < l1.size()) {
			customers.add(l1.get(i1));
			i1++;
		}
		while (i2 < l2.size()) {
			customers.add(l2.get(i2));
			i2++;
		}
		return customers;
	};

	public static void main(String[] args) {
		ArrayList<Customer> l1 = new ArrayList<Customer>();
		ArrayList<Customer> l2 = new ArrayList<Customer>();

		Customer c3 = new Customer("Faber", "Torben", 16);
		Customer c1 = new Customer("Jensen", "Torben", 16);
		Customer c4 = new Customer("Hansen", "Torben", 16);
		Customer c2 = new Customer("Nielsen", "Torben", 16);
		Customer c6 = new Customer("Moeskjær", "Torben", 16);
		Customer c5 = new Customer("Vrou", "Torben", 16);
		Customer c7 = new Customer("Sloth", "Torben", 16);
		l1.add(c3);
		l1.add(c1);
		l1.add(c2);
		l1.add(c5);

		l2.add(c4);
		l2.add(c1);
		l2.add(c6);
		l2.add(c5);
		l2.add(c7);

		System.out.println(l1);
		System.out.println(l2);

		ArrayList<Customer> list = fletAlleKunder(l1, l2);
		System.out.println(list);

	}
}
