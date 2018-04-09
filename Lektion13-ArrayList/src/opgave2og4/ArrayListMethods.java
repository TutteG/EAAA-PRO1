package opgave2og4;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMethods {

	// opgave 2
	// Returnere det mindste til i listen

	public int min(ArrayList<Integer> list) {
		int min = Integer.MAX_VALUE;
		for (Integer integer : list) {
			if (integer < min) {
				min = integer;
			}
		}
		return min;
	}

	// Returnere gennemsnittet af tallene i en liste.
	public double gennemsnit(ArrayList<Integer> list) {
		double gennemsnit = 0;
		for (Integer integer : list) {
			gennemsnit += integer;
		}
		return gennemsnit / list.size();
	}

	// Returner antallet af 0'er i listen
	public int antalNuller(ArrayList<Integer> list) {
		int nuller = 0;
		for (Integer integer : list) {
			if (integer == 0) {
				nuller++;
			}
		}
		return nuller;
	}

	// Erstat lige tal med 0
	public void erstatLigeTalMedNul(ArrayList<Integer> list) {
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j) % 2 == 0) {
				list.set(j, 0);
			}
		}
	}

	// Returnere en ny liste indeholdende alle de lige tal fra list
	public ArrayList<Integer> enLigeListe(ArrayList<Integer> list) {
		ArrayList<Integer> nyListe = new ArrayList<Integer>();
		for (Integer integer : nyListe) {
			if (integer % 2 == 0) {
				nyListe.add(integer);
			}
		}
		return nyListe;
	}

	// Opgave 4
	// Returnere en sorteret liste hvor lige tal er sat foran ulige
	public ArrayList<Integer> sortListEvenUneven(ArrayList<Integer> list) {
		int plads = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				list.add(plads, list.get(i));
				list.remove(i + 1);
				plads++;
			}
		}
		return list;
	}

	// returnere det næsthøjeste element
	public int findNextHighestNumber(ArrayList<Integer> list) {
		ArrayList<Integer> copyList = new ArrayList<>(list);
		Collections.sort(copyList);
		return copyList.get(copyList.size() - 2);
	}

	// Returnere true hvis listen er sorteret
	// Returnere false hvis listen er usorteret
	public boolean erSorteret(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) < list.get(i + 1)) {

			} else {
				return false;
			}
		}
		return true;
	}

	public boolean harDupletter(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int temp = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (temp == list.get(j)) {
					return true;
				}
			}
		}
		return false;

	}

	// gør noget fedt
	public boolean listerHarEnsElementer(ArrayList<Integer> list1, ArrayList<Integer> list2) {

		if (sumListeFor(list1) != sumListeFor(list2)) {
			return false;
		}
		for (int i = 0; i < list1.size(); i++) {
			int temp = list1.get(i);
			boolean ens = false;
			for (int j = 0; j < list2.size(); j++) {
				if (temp == list2.get(j)) {
					ens = true;
				}
			}
			if (ens == false) {
				return false;
			}

		}
		return true;

	}

	/**
	 * Sums the numbers in the list using a for loop each
	 */
	public int sumListeForEach(ArrayList<Integer> list) {
		int resultat = 0;
		for (int tal : list) {
			resultat = resultat + tal;
		}
		return resultat;
	}

	/**
	 * Sums the numbers in the list using a for loop
	 */
	public int sumListeFor(ArrayList<Integer> list) {
		int resultat = 0;
		for (int i = 0; i < list.size(); i++) {
			resultat = resultat + list.get(i);
		}
		return resultat;
	}

	/**
	 * Returns the index of the first even number
	 */
	public int hasEvenAtIndex(ArrayList<Integer> list) {
		int index = -1;
		int i = 0;
		while (index == -1 && i < list.size()) {
			if (list.get(i) % 2 == 0) {
				index = i;
			}
			i++;
		}
		return index;
	}

}
