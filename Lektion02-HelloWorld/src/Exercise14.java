
public class Exercise14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int balance = 1000;
		double plusInterest = 0;
		double interest = 0.05;

		plusInterest = balance + (balance * interest);
		for (int i = 1; i <= 3; i++) {

			System.out.println(plusInterest);
			plusInterest = plusInterest + (plusInterest * interest);
		}

	}

}
