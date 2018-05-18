package opgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class mainApp {

	// jeg har lavet opgave 8 her...

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
					pw.append(tal1 + "\n");
					tal1 = Integer.parseInt(sc1.next());
					if (!sc1.hasNext()) {
						pw.append(tal1 + "\n");
					}
				} else if (tal1 > tal2) {
					pw.append(tal2 + "\n");
					tal2 = Integer.parseInt(sc2.next());
					if (!sc2.hasNext()) {
						pw.append(tal2 + "\n");
					}
				} else if (tal1 == tal2) {
					pw.append(tal1 + "\n" + tal2 + "\n");
					tal1 = Integer.parseInt(sc1.next());
					tal2 = Integer.parseInt(sc2.next());
					if (!sc1.hasNext() || !sc2.hasNext()) {
						if (tal1 < tal2) {
							pw.append(tal1 + "\n");
							pw.append(tal2 + "\n");
						} else {
							pw.append(tal2 + "\n");
							pw.append(tal1 + "\n");
						}
					}
				}
			}
			while (sc1.hasNext()) {
				tal1 = Integer.parseInt(sc1.next());
				pw.append(tal1 + "\n");
			}
			while (sc2.hasNext()) {
				tal2 = Integer.parseInt(sc2.next());
				pw.append(tal2 + "\n");
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
