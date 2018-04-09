package dicegames;

import java.util.Scanner;

public class CrapsPlay {

	private Die die1;
	private Die die2;
	private boolean win;
	private boolean isFirstThrow = true;
	private int rememberFirstThrow;
	private int score;
	private Scanner sc = new Scanner(System.in);
	private int counterLose;
	private int counterWin;

	public CrapsPlay() {
		die1 = new Die();
		die2 = new Die();
	}

	public void welcomeToGame() {
		System.out.println("Velkommen til spillet Craps, Kast terningerne");
		startGame();
	}

	private void gameOver() {
		if (win != true) {
			System.out.println("Du har tabt spillet, tillykke med det!");
			counterLose++;
		} else {
			System.out.println("Du har vundet spillet, tillykke med det!");
			counterWin++;
		}
		System.out.println("Vil du gentage spillet? JA/NEJ");
		if (!sc.next().equalsIgnoreCase("nej")) {
			resetGame();
		} else {
			System.out.println("Tak for spillet!");
			System.out.println("Du har vundet: " + counterWin + ". Gange");
			System.out.println("Du har tabt: " + counterLose + ". Gange");
		}
	}

	private void resetGame() {
		isFirstThrow = true;
		startGame();
	}

	private void takeTurn() {
		die1.roll();
		System.out.println("Du har kastet med terning 1: " + die1.getFaceValue());
		die2.roll();
		System.out.println("Du har kastet med terning 2: " + die2.getFaceValue());
		System.out.println("Du har slået:" + (die1.getFaceValue() + die2.getFaceValue()));
		if (isFirstThrow == true) {
			if (die1.getFaceValue() + die2.getFaceValue() == 7 || die1.getFaceValue() + die2.getFaceValue() == 11) {
				win = true;
				gameOver();
			} else if (die1.getFaceValue() + die2.getFaceValue() == 2 || die1.getFaceValue() + die2.getFaceValue() == 3
					|| die1.getFaceValue() + die2.getFaceValue() == 12) {
				win = false;
				gameOver();
			} else {
				rememberFirstThrow = die1.getFaceValue() + die2.getFaceValue();
				isFirstThrow = false;
				startGame(); // startGame()
			}

		} else {
			System.out.println("Du skal slå " + rememberFirstThrow);
			score = die1.getFaceValue() + die2.getFaceValue();
			if (score == 7) {
				win = false;
				gameOver();
			} else if (score == rememberFirstThrow) {
				win = true;
				gameOver();
			} else {
				startGame();// startGame()
			}
		}
	}

	private void startGame() {
		System.out.println("Vil du kaste terningerne? JA/NEJ");
		if (sc.next().equalsIgnoreCase("ja")) {
			System.out.println("Du kaster nu begge terninger!");
			takeTurn();
		} else {
			win = false;
			gameOver();
		}
	}

}
