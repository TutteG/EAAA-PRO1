package child;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(4, true);// boy 4 years old
		Child c2 = new Child(10, false);// girl 2 years old
		Child c3 = new Child(11, true);// girl 2 years old
		System.out.println("Et barn på " + c1.getAge());
		System.out.println("Barn 1 går i: " + c1.institution());
		System.out.println("barn 1 " + c1.gender());
		System.out.println("barn 2 " + c2.gender());

		System.out.println("Barn 2 går i: " + c2.institution());
		System.out.println("Barn 3 går i: " + c3.institution());

		System.out.println("Barn 1 :" + c1.team());
		System.out.println("Barn 2 :" + c2.team());
		System.out.println("Barn 3 :" + c3.team());
	}

}
