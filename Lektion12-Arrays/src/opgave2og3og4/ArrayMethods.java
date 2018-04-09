package opgave2og3og4;

public class ArrayMethods {
	private int[] array;
	private int sum;
	private boolean uneven;

	public void printStringArray(String[] input) {

		input[2] = "En anden string";

		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}

	}

	// Opgave 2
	// Return Sum of intArray
	public int sum(int[] array) {
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	// Opgave 3
	// createSum
	public int[] createSum(int[] a, int[] b) {
		if (a.length > b.length) {
			array = new int[a.length];

		} else {
			array = new int[b.length];
		}
		System.out.println("Array lenght: " + array.length);
		for (int i = 0; i < array.length; i++) {
			array[i] = a[i] + b[i];
			// System.out.print(array[i] + " ");
		}

		return array;
	}

	// Opgave 4
	// hasUneven
	public boolean hasUneven(int[] t) {
		for (int i = 0; i < t.length; i++) {
			if (t[i] % 2 != 0) {
				uneven = true;
				break;
			} else {
				uneven = false;
			}
		}
		return uneven;
	}

}
