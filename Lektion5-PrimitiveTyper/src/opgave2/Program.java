package opgave2;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ord1 = "Datamatiker";
		String ord2 = "Uddannelsen";

		// a)
		System.out.println(ord1.toUpperCase());
		// b)
		System.out.println(ord2.toLowerCase());
		// c)
		System.out.println(ord1 + " " + ord2);
		// d)
		String ord3 = ord1 + ord2.toLowerCase();
		System.out.println(ord3);
		// e)
		System.out.println("længden af ord3 er: " + ord3.length());
		// f)
		System.out.println(ord1.substring(0, 7));
		// g)
		System.out.println(ord2.substring(2, 7));
		// h)
		System.out.println(ord3.substring(ord3.length() / 2));
	}

}
