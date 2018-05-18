package opgave6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class mainApp {

	/**
	 * Laver en sorteret fil i fileNameNy der indeholder alle heltal fra fileName1
	 * og fileName2 (MAX_VALUE skal ikke i resultatet) Krav: filename1 og filename2
	 * er navne på to sorterede filer.
	 */
	public static void fletAlleHeltal(String fileName1, String fileName2, String fileNameNy) {
		File file1 = new File(fileName1);
		File file2 = new File(fileName2);
		File file3 = new File(fileNameNy);
		try {
			Scanner sc1 = new Scanner(file1);
			Scanner sc2 = new Scanner(file2);
			PrintWriter pw = new PrintWriter(file3);

			int tal1 = Integer.parseInt(sc1.next());
			int tal2 = Integer.parseInt(sc2.next());
			while (sc1.hasNext() && sc2.hasNext()) {
				if (tal1 < tal2) {
					tal1 = Integer.parseInt(sc1.next());

				} else if (tal1 > tal2) {
					tal2 = Integer.parseInt(sc2.next());

				} else if (tal1 == tal2) {
					pw.append(tal1 + "\n");
					tal1 = Integer.parseInt(sc1.next());
					if (!sc1.hasNext() || !sc2.hasNext()) {
						if (tal1 == tal2) {
							pw.append(tal1 + "\n");
						}
					}
				}
			}

			sc1.close();
			sc2.close();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		fletAlleHeltal("tal.txt", "tal2.txt", "tal3.txt");
	}
}
