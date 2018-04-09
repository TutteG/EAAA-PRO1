package dicegames;

import java.util.Scanner;

public class PlayPairOfDices {

	private Scanner sc;
	private int sides;

	public PlayPairOfDices() {
	}

	public void play() {

		sc = new Scanner(System.in);
		System.out.println("Go'daw og velkommen til Jysk Kasino");
		System.out.println("Her skal du kaste to terninger til du ikke gider mere, er det ikke fedt?");
		System.out.print("Hvor mange sider har dine terninger? ");
		sides = sc.nextInt();
		PairOfDices dices;
		if (sides < 4) {
			System.out.println("Du får en standard 6-sidet terning fordi " + sides + " er noget bullshit...");
			dices = new PairOfDices();
			sides = 6;
		} else {
			System.out.println("Du har nu en " + sides + "-sidet terning");
			dices = new PairOfDices(sides);
		}

		String spil = "";

		System.out.println("Sæt igang!");
		boolean playing = true;
		while (playing == true) {
			System.out.println("Ønsker de at kaste? JA/NEJ");
			spil = sc.next().toLowerCase();
			if (spil.equalsIgnoreCase("nej")) {
				System.out.println("ønske du at genstarte eller afslutte spillet GENSTART/AFSLUT");
				spil = sc.next().toLowerCase();
				if (spil.equalsIgnoreCase("genstart")) {
					dices.resetPairOfDices();
					System.out.flush();
					continue; // Start fra løkkens top
				} else if (spil.equalsIgnoreCase("afslut")) {
					break; // Stopper løkken
				} else {
					System.out.println("Spillet fortsætter");
				}
			}
			dices.rollBothDices();
			System.out.println("Terningerne kastes");
			System.out.println("Summen af terningerne er: " + dices.sumOfDices());
		}
		System.out.println("Der er kastet " + dices.getCounterRolls() + " antal gange");
		System.out.println("Det højeste kast har været " + dices.getBiggestRoll());
		System.out.println("Der er blevet kastet " + dices.getCounterPairs() + " par");
		for (int i = 0; i < sides; i++) {
			System.out.println("Der er blevet kastet " + dices.getEyeCounter(i) + " stk. " + (i + 1) + "'ere");
		}
		System.out.println("spillet er slut");
		sc.close();

	}

}
