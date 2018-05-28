package opgave2;

public class Card implements Comparable<Card> {
	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		// TODO Auto-generated constructor stub
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card o) {
		// // TODO Auto-generated method stub
		// if (rank.compareTo(o.getRank()) < 0) {
		// return -1;
		// } else if (rank.compareTo(o.getRank()) > 0) {
		// return 1;
		// } else {
		// if (suit.compareTo(o.getSuit()) < 0) {
		// return -1;
		// } else if (suit.compareTo(o.getSuit()) > 0) {
		// return 1;
		// } else {
		// return 0;
		// }
		// }
		if (rank == o.getRank()) {
			return suit.compareTo(o.getSuit());
		}
		return rank.compareTo(o.getRank());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return rank + " " + suit;
	}
}
