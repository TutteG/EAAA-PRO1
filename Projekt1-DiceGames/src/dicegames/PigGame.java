package dicegames;

import java.util.Scanner;

public class PigGame {

	private Scanner sc = new Scanner(System.in);
	private Player[] player;
	private int currentPlayer;
	private Die dice;
	private int currentScore;
	private int endGameScore;
	private boolean keepPlaying = true;

	public PigGame() {
		player = new Player[2];
		player[0] = new Player();
		player[1] = new Player();
		currentPlayer = 0;
		dice = new Die();
		endGameScore = 100;
	}

	public void startGame() {

		System.out.println("Velkommen til Jysk Kasino Grise spil, det er her vi hygger");
		System.out.println("Spillet kræver 2 spillere");
		System.out.println("Indtast spiller 1's navn herunder:");
		player[0].setName(sc.next());
		System.out.println("Indtast spiller 2's navn herunder:");
		player[1].setName(sc.next());
		System.out.println("hvor mange point ønsker i at spille til?");
		int score = sc.nextInt();
		if (score < 10) {
			endGameScore = 100;
			System.out.println("Sårn fungere det ikke, vi spiller mindst til 10 her i Jysk Kasino");
		} else {
			endGameScore = score;
			System.out.println("Spillet spilles til " + endGameScore + " point");
			;
		}

		System.out.println(player[0].getName() + " gør dig klar til at spille pig");
		takeTurn();
	}

	private void takeTurn() {
		while (keepPlaying == true) {
			dice.roll();
			System.out.println(player[currentPlayer].getName() + " du har slået " + dice.getFaceValue());

			if (player[currentPlayer].getScore() + currentScore + dice.getFaceValue() >= endGameScore
					&& dice.getFaceValue() != 1) {
				// spillet er slut
				player[currentPlayer].addToScore(currentScore + dice.getFaceValue());
				keepPlaying = false;
				// winTheGame();
				// breakTheGame();
			} else if (dice.getFaceValue() > 1) {
				currentScore += dice.getFaceValue();
				System.out.println("Ønsker de at fortsætte? y/n");
				if (sc.next().equalsIgnoreCase("n")) {
					player[currentPlayer].addToScore(currentScore);
					keepPlaying = false;
				} else {
					keepPlaying = true;
				}
			} else {
				// currentScore resettes
				currentScore = 0;
				keepPlaying = false;
			}

			// else do nothing

		}
		currentScore = 0;
		System.out.println(
				player[currentPlayer].getName() + " din score er nu: " + player[currentPlayer].getScore() + " point.");

		if (player[currentPlayer].getScore() < endGameScore) {
			// skifter tur til anden spiller
			if (currentPlayer == 0) {
				currentPlayer = 1;
			} else {
				currentPlayer = 0;
			}
			keepPlaying = true;
			takeTurn();
		} else if (player[currentPlayer].getScore() >= endGameScore) {
			winTheGame();
			sc.close();
		}

	}

	public void winTheGame() {
		System.out.println(player[currentPlayer].getName() + " har vundet spillet \nTILLYKKE!!!!");
		keepPlaying = false;
	}
}
