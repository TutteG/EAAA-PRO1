package r432testapp;

import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double total = 0;
		int quarters;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of quarters: ");
		quarters = sc.nextInt();

		// Det her program er bullshit
		if (sc.hasNextInt()) {
			total = total + quarters * 0.25;
			System.out.println("Total: " + total);
		} else {
			System.out.println("Input error.");
		}
		sc.close();
	}
}
