package opgave7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainApp {
	public static String linFileSearchPerson(String fileName, String target) {
		File file = new File(fileName);
		String fullName = "Not found";
		boolean found = false;
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine() && !found) {
				Scanner sc2 = new Scanner(sc.nextLine());
				// int id = Integer.parseInt(sc2.next());
				String firstName = sc2.next();
				String lastName = sc2.next();
				if (lastName.equals(target)) {
					fullName = firstName + " " + lastName;
					found = true;
					sc2.close();
				}
				sc2.close();
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File Not found" + e.getMessage());
		}

		return fullName;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();

		System.out.println(linFileSearchPerson("personer.txt", name));

		sc.close();
	}
}
