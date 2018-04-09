package opgave3;

public class NameApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Name navn1 = new Name("Torben", "Grove", "Nielsen");

		System.out.println(navn1.getInit());
		System.out.println(navn1.getFirstName());
		System.out.println(navn1.getMidName());
		System.out.println(navn1.getLastName());
		System.out.println(navn1.getUsername());

	}

}
