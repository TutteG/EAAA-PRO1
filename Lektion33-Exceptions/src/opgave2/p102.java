package opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class p102 {
	public static void main(String[] args) {
		try {
			File file = new File("hello.txt");
			File file2 = new File("mary.txt");
			Scanner sc = new Scanner(file);
			PrintWriter pw = new PrintWriter(new FileOutputStream(file2));
			int lineNum = 0;

			while (sc.hasNextLine()) {
				lineNum++;
				String something = "/*" + lineNum + "*/";
				String input = sc.nextLine() + "\n";
				pw.append(something + " " + input);
			}

			pw.close();
			sc.close();
		} catch (

		FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("file not found " + e.getMessage());
		}

	}
}
