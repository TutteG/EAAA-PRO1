package opgave1dobbelarray;

public class DobbelArrayApp {

	public static void main(String[] args) {
		final int ROW = 8;
		final int COL = 8;
		int[][] values = new int[ROW][COL];

		// TODO udskriv values på tabel form
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(values[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		// TODO lav ændringer i values så der står 5 på alle pladser
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				values[i][j] = 5;
			}
		}
		// TODO udskriv values på tabel form
		System.out.println();
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(values[i][j]);
			}
			System.out.println();
		}
		// TODO lav ændringer i values så den har skiftende 0'er og 1'er som på et
		// skakbræt
		// for (int i = 0; i < ROW; i++) {
		// for (int j = 0; j < COL; j++) {
		// if (i % 2 == 0) {
		// if (j % 2 == 0) {
		// values[i][j] = 0;
		// } else {
		// values[i][j] = 1;
		// }
		// } else if (j % 2 != 0) {
		// values[i][j] = 0;
		// } else {
		// values[i][j] = 1;
		// }
		// }
		// }
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				values[i][j] = (i + j) % 2;
			}
		}

		// TODO udskriv values på tabel form
		System.out.println();
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(values[i][j]);
			}
			System.out.println();
		}
		// TODO lav ændringer så alle elementer i nederste og øverste række samt første
		// og sidste søjle er 5 og resten skal være 2.
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (i == 0 || i == 7) {
					values[i][j] = 5;
				} else if (j == 0 || j == 7) {
					values[i][j] = 5;
				} else {
					values[i][j] = 2;
				}
			}
		}
		// TODO udskriv values på tabel form
		System.out.println();
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(values[i][j]);
			}
			System.out.println();
		}
		// TODO beregn summen af alle tallene i values og udskriv denne.
		int sum = 0;
		System.out.println();
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				sum += values[i][j];
			}
		}
		System.out.println(sum);
	}

}
