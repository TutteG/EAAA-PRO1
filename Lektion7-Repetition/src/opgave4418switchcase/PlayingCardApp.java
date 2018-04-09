package opgave4418switchcase;

import java.util.Scanner;

public class PlayingCardApp {
	public static void main(String[] args) {

		String card;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a card type followed by its value: ");
			System.out.println("In syntax of SQ = Queen Of Spades, or h10 = 10 Of Hearts");
			card = sc.nextLine().toUpperCase();
			PlayingCard card1 = new PlayingCard(card);
			card1.setCardValue(card);
			card1.setCardType(card);
			card1.printCard();
			sc.close();
		}
	}
}
