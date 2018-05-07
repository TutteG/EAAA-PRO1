package opgave2og3;

public class SortMethods {

	public static void bubbleSort(String[] array) {
		// TODO:
		int n = array.length;
		String temp;
		boolean swapped = true;

		while (swapped) {
			swapped = false;
			for (int i = 0; i < n - 1; i++) {
				if (array[i].compareTo(array[i + 1]) >= 1) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
		}

	}

	public static void insertionSort(String[] array) {
		// TODO:
		for (int i = 1; i < array.length; i++) {
			String key = array[i];
			int j = i;
			while (j > 0 && array[j - 1].compareTo(key) > 0) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = key;
		}
	}

	public static void selectionSort(String[] array) {
		// TODO:
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					String temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}
}
