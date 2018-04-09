package afleveringfravaer;

public class FravaersSystem {
	/**
	 * Frafaldstallene udskrives på skærmen
	 *
	 * @param fravaer
	 */
	public void udskrivFravaer(int[][] fravaer) {
		// TODO
		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[i].length; j++) {
				System.out.print(fravaer[i][j] + "	");
			}
			System.out.println();
		}
	}

	/**
	 * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
	 * elevnr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public int samletFravaer(int[][] fravaer, int elevNr) {
		// TODO
		int sum = 0;
		for (int j = 0; j < fravaer[elevNr - 1].length; j++) {
			sum += fravaer[elevNr - 1][j];

		}
		return sum;
	}

	/**
	 * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
	 * elevNr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public double gennemsnit(int[][] fravaer, int elevNr) {
		// TODO
		double sum = 0;
		for (int j = 0; j < fravaer[elevNr - 1].length; j++) {
			sum += fravaer[elevNr - 1][j];

		}
		return sum / fravaer[elevNr - 1].length;
	}

	/**
	 * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
	 *
	 * @param fravaer
	 * @return
	 */
	public int antalUdenFravaer(int[][] fravaer) {
		// TODO
		int counter = 0;
		int udenFravaer = 0;
		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[i].length; j++) {
				counter += fravaer[i][j];
			}
			if (counter == 0) {
				udenFravaer++;
			}
			counter = 0;
		}
		return udenFravaer;
	}

	/**
	 * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
	 * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer for
	 * en af disse.
	 *
	 * @param fravaer
	 * @return
	 */
	public int mestFravaer(int[][] fravaer) {
		int elevNr = 0;
		int frav = 0;
		int maxFravaer = 0;
		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[i].length; j++) {
				frav += fravaer[i][j];
			}
			if (maxFravaer < frav) {
				maxFravaer = frav;
				elevNr = i + 1;
			}
			frav = 0;
		}
		return elevNr;
	}

	/**
	 * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
	 * måneder.
	 *
	 * @param fravaer
	 * @param elevNr
	 */
	public void nulstil(int[][] fravaer, int elevNr) {

		for (int i = 0; i < fravaer[elevNr - 1].length; i++) {
			fravaer[elevNr - 1][i] = 0;
		}

	}
}
