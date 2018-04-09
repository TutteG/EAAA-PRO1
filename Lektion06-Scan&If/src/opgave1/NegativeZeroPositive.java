package opgave1;

import java.util.Scanner;

public class NegativeZeroPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int etTal = sc.nextInt();

		if (etTal > 0) {
			System.out.println(etTal + " er positivt");
		} else if (etTal < 0) {
			System.out.println(etTal + " er negativt");
		} else {
			System.out.println(etTal + " er = 0");
		}
		sc.close();
	}

}
