package opgave2;

public class mainApp {
	/**
	 * Returnerer et sorteret array der indeholder alle elementer l1 og l2 har til
	 * fælles Krav: l1 og l2 er sorterede, indeholder ikke dubletter og indeholder
	 * ikke tomme pladser
	 */
	public static int[] fællesTal(int[] l1, int[] l2) {
		int[] array1 = new int[l1.length];
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		while (i1 < l1.length && i2 < l2.length) {
			if (l1[i1] == l2[i2]) {
				array1[i3] = l1[i1];
				i1++;
				i2++;
				i3++;
			} else if (l1[i1] < l2[i2]) {
				i1++;
			} else {
				i2++;
			}
		}
		return array1;
	}

	public static void main(String[] args) {
		int[] array1 = { 2, 4, 6, 8, 10, 12, 14 };
		int[] array2 = { 1, 2, 4, 5, 6, 9, 12, 17 };
		int[] array3 = fællesTal(array1, array2);
		for (int i = 0; i < array3.length; i++) {
			System.out.println(array3[i]);
		}
	}
}