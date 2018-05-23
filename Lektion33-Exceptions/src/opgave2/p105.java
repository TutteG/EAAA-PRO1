package opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class p105 {
	public static void main(String[] args) {
		boolean found = false;
		while (!found) {
			System.out.print("Hvad søger du? ");
			String filename = "";
			Scanner in = new Scanner(System.in);
			filename = in.next();
			System.out.println("Du har søgt på: 		" + filename);
			try {
				File file = new File(filename);
				Scanner sc = new Scanner(file);
				int lines = 0;
				while (sc.hasNextLine()) {
					lines++;
					String input = sc.nextLine();
					System.out.println(input);
				}
				sc.close();
				String chars = "";

				sc = new Scanner(file);
				while (sc.hasNext()) {
					chars += sc.next();
				}
				System.out.println("Antal karakterer i fil: 	" + chars.length());
				sc.close();
				sc = new Scanner(file);
				ArrayList<String> words = new ArrayList<String>();
				while (sc.hasNext()) {
					words.add(sc.next());
				}
				System.out.println("Antal ord i fil: 		" + words.size());
				System.out.println("Antal linjer i fil: 		" + lines);
				found = true;
				sc.close();
				in.close();
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				System.out.println("file not found " + e.getMessage());
			}

		}
	}
}
