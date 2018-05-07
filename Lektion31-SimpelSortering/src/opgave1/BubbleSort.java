package opgave1;

public class BubbleSort {
	public static String[] bubbleSort(String[] strings) {
		int n = strings.length;
		String temp;
		boolean swapped = true;

		while (swapped) {
			swapped = false;
			for (int i = 0; i < n - 1; i++) {
				if (strings[i].compareTo(strings[i + 1]) >= 1) {
					temp = strings[i];
					strings[i] = strings[i + 1];
					strings[i + 1] = temp;
					swapped = true;
				}
			}
		}

		return strings;
	}

	public static void main(String[] args) {
		String[] strings = { "Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove",
				"Poul", "Torkild" };

		String[] sorteret = BubbleSort.bubbleSort(strings);
		// sorteret = BubbleSort.bubbleSort(sorteret);
		for (int i = 0; i < sorteret.length; i++) {
			System.out.println(sorteret[i]);
		}
	}
}
