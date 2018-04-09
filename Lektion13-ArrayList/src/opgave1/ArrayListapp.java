package opgave1;

import java.util.ArrayList;

public class ArrayListapp {
	public static void main(String[] args) {
		ArrayList<String> listNames = new ArrayList<>();
		listNames.add("Hans");
		listNames.add("Viggo");
		listNames.add("Jens");
		listNames.add("Børge");
		listNames.add("Bent");

		System.out.println(listNames.size());
		listNames.add(2, "Jane");

		System.out.println(listNames);
		listNames.remove(1);
		listNames.add(0, "Pia");
		listNames.add("Ib");
		System.out.println(listNames.size());
		listNames.set(2, "Hansi");
		System.out.println(listNames.size());
		System.out.println(listNames);

		for (int i = 0; i < listNames.size(); i++) {
			System.out.println(listNames.get(i).length());
		}
		for (String string : listNames) {
			System.out.println(string.length());
		}

	}
}
