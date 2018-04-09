package opgave2og4;

import java.util.ArrayList;

public class ArrayListMethodsApp {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(19);
		list.add(35);
		list.add(14);
		list.add(7);
		list.add(50);

		ArrayListMethods methods = new ArrayListMethods();
		System.out.println(list);
		methods.erstatLigeTalMedNul(list);
		System.out.println(list);
		// System.out.println(list);
		// System.out.println("Summen af tallene i listen (med for): " +
		// methods.sumListeFor(list));
		// System.out.println("Summen af tallene i listen (med forEach): " +
		// methods.sumListeForEach(list));
		// System.out.println("Indeks for det første lige tal: " +
		// methods.hasEvenAtIndex(list));
		// methods.sortListEvenUneven(list);
		// System.out.println(list);
		// System.out.println(methods.findNextHighestNumber(list));
		// System.out.println(methods.erSorteret(list));
		// Collections.sort(list);
		// System.out.println(methods.erSorteret(list));
		// System.out.println(methods.harDupletter(list));
		// list.add(19);
		// System.out.println(methods.harDupletter(list));
		// ArrayList<Integer> list2 = new ArrayList(list);
		// ArrayList<Integer> list3 = new ArrayList<Integer>();
		// list3.add(19);
		// list3.add(35);
		// list3.add(14);
		// list3.add(10);
		// list3.add(50);
		// list3.add(19);
		// System.out.println(methods.listerHarEnsElementer(list, list2));
		// System.out.println(methods.listerHarEnsElementer(list, list3));
		// list3.set(3, 7);
		// list3.set(0, 50);
		// list3.set(4, 19);

		// System.out.println(methods.listerHarEnsElementer(list2, list3));
	}

}
