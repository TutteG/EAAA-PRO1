package opgave6;

import java.util.ArrayList;
import java.util.Collections;

public class FindTing {
	public static int Find(ArrayList<Integer> list, int n) {
		boolean found = false;
		int i = 0;
		while (!found && i < list.size()) {
			if (list.get(i) == n) {
				if (i != 0) {
					Collections.swap(list, i, i - 1);
					found = true;
				}
			} else {
				i++;
			}
		}
		if (found) {
			return i - 1;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(4);
		list.add(8);
		list.add(13);
		list.add(2);
		System.out.println(Find(list, 13));
		System.out.println(Find(list, 12));

	}
}
