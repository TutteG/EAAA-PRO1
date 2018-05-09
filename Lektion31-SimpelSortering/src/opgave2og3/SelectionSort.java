package opgave2og3;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
	public static String[] stringSelectionSort(String[] strings) {
		for (int i = 0; i < strings.length - 1; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				if (strings[i].compareTo(strings[j]) > 0) {
					String temp = strings[j];
					strings[j] = strings[i];
					strings[i] = temp;
				}
			}
		}
		return strings;
	}

	public static ArrayList<Customer> customerSelectionSort(ArrayList<Customer> customers) {
		for (int i = 0; i < customers.size() - 1; i++) {
			for (int j = i + 1; j < customers.size(); j++) {
				if (customers.get(i).compareTo(customers.get(j)) > 0) {
					// Customer temp = customers.get(j);
					// customers.set(j, customers.get(i));
					// customers.set(i, temp);

					Collections.swap(customers, i, j);
				}
			}
		}

		return customers;
	}

	public static void main(String[] args) {
		String[] strings = { "Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove",
				"Poul", "Torkild" };

		String[] sorteret = stringSelectionSort(strings);
		for (int i = 0; i < sorteret.length; i++) {
			System.out.println(sorteret[i]);
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		Customer c1 = new Customer("Jensen", "Torben", 16);
		Customer c2 = new Customer("Nielsen", "Torben", 16);
		Customer c3 = new Customer("Faber", "Torben", 16);
		Customer c4 = new Customer("Hansen", "Torben", 16);
		Customer c5 = new Customer("Vrou", "Torben", 16);
		Customer c6 = new Customer("Moeskjær", "Torben", 16);
		Customer c7 = new Customer("Sloth", "Torben", 16);

		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
		customers.add(c6);
		customers.add(c7);

		System.out.println(customers);
		for (Customer customer : customers) {
			System.out.println(customer.getLastName());
		}

		customers = customerSelectionSort(customers);

		System.out.println(customers);

		for (Customer customer : customers) {

			System.out.println(customer.getLastName() + "	" + customer.getFirstName());
		}

	}
}
