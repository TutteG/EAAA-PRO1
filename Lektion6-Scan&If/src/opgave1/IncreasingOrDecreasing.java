package opgave1;

import java.util.Scanner;

public class IncreasingOrDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int etTal = sc.nextInt();
		int toTal = sc.nextInt();
		int treTal = sc.nextInt();

		if (etTal < toTal && toTal < treTal) {
			System.out.println("Tallene står i stigende orden");
		} else if (etTal > toTal && toTal > treTal) {
			System.out.println("Tallene står i faldende orden");
		} else {
			System.out.println("Tallene står ikke i orden");
		}
		sc.close();
	}

}
