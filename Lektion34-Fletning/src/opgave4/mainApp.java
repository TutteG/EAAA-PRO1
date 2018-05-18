package opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mainApp {

	public static boolean linFileSearch(String fileName, int target) {
		boolean found = false;
		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			while (sc.hasNext() && !found) {
				if (target == Integer.parseInt(sc.next())) {
					found = true;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File not found " + e.getMessage());
		}
		return found;
	}

	public static void main(String[] args) {
		System.out.println(linFileSearch("tal.txt", 5885));
		System.out.println(linFileSearch("tal.txt", 5886));
	}
}
