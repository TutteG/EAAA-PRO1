package opgave6;

import java.util.Scanner;

public class DateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Type in month: ");
		int month = sc.nextInt();
		System.out.println("Type in day: ");
		int day = sc.nextInt();
		sc.close();
		Date date1 = new Date(month, day);
		System.out.println(date1.getSeason());
	}

}
