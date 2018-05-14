package opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p102 {
	public static void main(String[] args) {
		try {
			File file = new File("hello.txt");
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {

				String input = sc.nextLine();
				System.out.println(input);
			}

			sc.close();
		} catch (

		FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("file not found " + e.getMessage());
		}

	}
}
