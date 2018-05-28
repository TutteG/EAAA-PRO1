package opgave2;

public class testApp {
	public static void main(String[] args) {
		Card card = new Card(Rank.TWO, Suit.SPADE);
		Card card2 = new Card(Rank.TWO, Suit.SPADE);
		System.out.println(card.compareTo(card2));
	}
}
