package opgave1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mainApp {
	public static void main(String[] args) {
		int[] prim = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Hvilket nr. primtal skal vises?: ");
			int n = scan.nextInt();
			System.out.println("Primtal nr. " + n + " er " + prim[n - 1] + "\n");
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("InputMisMatch " + e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println("ArrayIndexOutOfBounds " + e.getMessage());
		}
	}
}
