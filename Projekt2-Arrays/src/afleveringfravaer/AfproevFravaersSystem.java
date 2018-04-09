package afleveringfravaer;

public class AfproevFravaersSystem {

	public static void main(String[] args) {
		int[][] fravaer18V = { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
				{ 5, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0 } };

		FravaersSystem karakterSystem = new FravaersSystem();
		karakterSystem.udskrivFravaer(fravaer18V);
		System.out.println();
		System.out.println("Samlet fravær for en studerende: ");
		System.out.println(karakterSystem.samletFravaer(fravaer18V, 5));

		System.out.println("Gennemsnitligt fravær for en studerende: ");
		System.out.println(karakterSystem.gennemsnit(fravaer18V, 5));

		System.out.println("Antal elever uden fravær: ");
		System.out.println(karakterSystem.antalUdenFravaer(fravaer18V));

		System.out.println("Eleven med mest fravær: ");
		System.out.println(karakterSystem.mestFravaer(fravaer18V));

		System.out.println("Karakter nulstilles og udskrives: ");
		karakterSystem.nulstil(fravaer18V, 5);
		System.out.println(karakterSystem.samletFravaer(fravaer18V, 5));
	}
}
