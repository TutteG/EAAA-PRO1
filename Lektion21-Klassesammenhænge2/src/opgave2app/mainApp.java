package opgave2app;

import java.util.ArrayList;

import opgave2.Gift;
import opgave2.Person;

public class mainApp {
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Person person1 = new Person("Ole", 21);
		Person person2 = new Person("Niller", 18);

		Gift gift1 = person2.gives("Nintendo Switch", 2700, person1);
		/* Gift gift2 = */person1.gives("Transformer", 500, person2);
		System.out.println(person1.getTotalPriceOfGifts());
		System.out.println(person2.getTotalPriceOfGifts());

		ArrayList<Person> givers = new ArrayList<Person>(person1.getGivers());

		for (Person person : givers) {
			System.out.println(person.getName());
		}

		person1.givesSame(gift1, person2);

		givers = new ArrayList<>(person2.getGivers());
		for (Person person : givers) {
			System.out.println(person.getName());
		}
		givers = new ArrayList<>(person1.getGivers());
		for (Person person : givers) {
			System.out.println(person.getName());
		}

	}

}
