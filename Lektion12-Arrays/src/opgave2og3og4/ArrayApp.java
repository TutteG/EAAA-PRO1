package opgave2og3og4;

public class ArrayApp {

	public static void main(String[] args) {
		String[] stringArray = new String[10];

		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = "String " + i;
		}

		ArrayMethods methods = new ArrayMethods();
		methods.printStringArray(stringArray);

		String[] stringArray2 = { "Hej", "Dav", "Halløj" };

		methods.printStringArray(stringArray2);

		int[] intArray1 = new int[] { 5, 1, 4, 5, 6 };
		System.out.println(methods.sum(intArray1));

		int[] intArray2 = new int[] { 2, 4, 6, 2, 8 };
		int[] intArray3 = methods.createSum(intArray1, intArray2);
		for (int i = 0; i < intArray3.length; i++) {
			System.out.print(intArray3[i] + " ");
		}
		System.out.println();
		System.out.println(methods.hasUneven(intArray1));
		System.out.println(methods.hasUneven(intArray2));

	}
}
