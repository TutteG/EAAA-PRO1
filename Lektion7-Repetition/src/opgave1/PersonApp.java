package opgave1;

public class PersonApp {

	public static void main(String[] args) {
		Person p = new Person("Bent", "Janus", "Christensen", 27, 12, 1990);
		p.printPerson();
		System.out.println("Initialer: " + p.getInit());
		System.out.println("Username: " + p.getUserName());

		System.out.println("Age: " + p.age(12, 9, 2014));

		Person ep = new Person("Torben", "Nielsen", 3, 4, 1990);
		p.printPerson();
		System.out.println("Initialer: " + ep.getInit());
		System.out.println("Username: " + ep.getUserName());

		System.out.println("Age: " + ep.age(19, 2, 2018));
		// int year = 2014;
		// System.out.println("Er " + year + " skudår: " + p.leapYear(year));

	}
}
