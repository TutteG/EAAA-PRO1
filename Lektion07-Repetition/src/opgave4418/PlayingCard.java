package opgave4418;

public class PlayingCard {

	private String card;
	private String cardType;
	private String cardValue;

	public PlayingCard(String card) {
		this.card = card;
	}

	public String getCardType() {
		if (card.charAt(0) == 'D') {
			cardType = "Diamonds";
		} else if (card.charAt(0) == 'H') {
			cardType = "Hearts";
		} else if (card.charAt(0) == 'S') {
			cardType = "Spades";
		} else if (card.charAt(0) == 'C') {
			cardType = "Clubs";
		} else {
			cardType = "Invalid Type";
		}
		return cardType;
	}

	public String getCardValue() {
		if (card.charAt(1) == 'D') {
			cardValue = "Diamonds";
		} else if (card.charAt(1) == '1') {
			if (card.charAt(2) == '0') {
				cardValue = "10";
			} else {
				cardValue = "Ace";
			}
		} else if (card.charAt(1) == '2') {
			cardValue = "2";
		} else if (card.charAt(1) == '3') {
			cardValue = "3";
		} else if (card.charAt(1) == '4') {
			cardValue = "4";
		} else if (card.charAt(1) == '5') {
			cardValue = "5";
		} else if (card.charAt(1) == '6') {
			cardValue = "6";
		} else if (card.charAt(1) == '7') {
			cardValue = "7";
		} else if (card.charAt(1) == '8') {
			cardValue = "8";
		} else if (card.charAt(1) == '9') {
			cardValue = "9";
		} else if (card.charAt(1) == 'J') {
			cardValue = "Jack";
		} else if (card.charAt(1) == 'Q') {
			cardValue = "Queen";
		} else if (card.charAt(1) == 'K') {
			cardValue = "King";
		} else {
			cardValue = "Invalid Value";
		}
		return cardValue;
	}

	public void printCard() {
		System.out.println(getCardValue() + " Of " + getCardType());
	}
}
