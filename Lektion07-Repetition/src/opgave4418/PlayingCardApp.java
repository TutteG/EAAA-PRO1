package opgave4418;

import java.util.Scanner;

public class PlayingCardApp {
	public static void main(String[] args) {

		String card;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a card value and it's type: ");
			card = sc.nextLine();
			PlayingCard card1 = new PlayingCard(card);
			card1.printCard();
			sc.close();
		}
	}
}
