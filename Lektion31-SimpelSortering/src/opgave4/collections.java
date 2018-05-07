package opgave4;

import java.util.ArrayList;
import java.util.Collections;

public class collections {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		String s1 = "Klaus";
		String s2 = "Niels";
		String s3 = "Elin";
		String s4 = "Mads";
		String s5 = "Jens";
		String s6 = "Martin";
		String s7 = "Jacob";
		String s8 = "Morten";

		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		list.add(s7);
		list.add(s8);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
