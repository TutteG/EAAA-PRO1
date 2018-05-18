package opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p104 {
	public static void main(String[] args) {
		try {

			File file = new File("tal.txt");
			Scanner sc = new Scanner(file);
			Scanner scl;
			double num;
			int line = 1;
			while (sc.hasNextLine()) {
				int i = 0;
				num = 0;
				scl = new Scanner(sc.nextLine());
				while (scl.hasNext()) {
					try {
						num += Double.parseDouble(scl.next());
						i++;
					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("NumberFormatException e");
					}
				}
				System.out.println("Line " + line + ": " + (num / i));
				line++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("file not found");
		}
	}
}
