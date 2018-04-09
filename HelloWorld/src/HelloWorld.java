import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please type in your name :)");
		System.out.println("Please type " + "in your name :)");

		Scanner sc = new Scanner(System.in);
		String Name = "";
		int alder = 0;
		Name = sc.nextLine();
		System.out.print("hello ");
		System.out.print(Name);
		System.out.println("!!!");
		System.out.println("Please type in your age");
		alder = sc.nextInt();
		System.out.print("So your name is ");
		System.out.println(Name);
		System.out.print("And your age is ");
		System.out.println(alder);
		sc.close();
	}

}
