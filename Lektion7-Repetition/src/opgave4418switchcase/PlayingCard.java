package opgave4418switchcase;

public class PlayingCard {

	private String card;
	private String cardType;
	private String cardValue;

	public PlayingCard(String card) {
		this.card = card;
	}

	public void setCardType(String type) {
		switch (type.charAt(0)) {
		case 'D':
			cardType = "Diamonds";
			break;
		case 'H':
			cardType = "Hearts";
			break;
		case 'S':
			cardType = "Spades";
			break;
		case 'C':
			cardType = "Clubs";
			break;
		default:
			cardType = "Invalids ";
			break;
		}
	}

	public void setCardValue(String value) {

		switch (value.charAt(1)) {
		case '1':
			if (card.length() == 3 && card.charAt(2) == '0') {
				cardValue = "10";
			} else if (card.length() == 2) {
				cardValue = "Ace";
			} else {
				cardValue = "Invalid";
			}
			break;
		case '2':
			cardValue = "2";
			break;
		case '3':
			cardValue = "3";
			break;
		case '4':
			cardValue = "4";
			break;
		case '5':
			cardValue = "5";
			break;
		case '6':
			cardValue = "6";
			break;
		case '7':
			cardValue = "7";
			break;
		case '8':
			cardValue = "8";
			break;
		case '9':
			cardValue = "9";
			break;
		case 'J':
			cardValue = "Jack";
			break;
		case 'Q':
			cardValue = "Queen";
			break;
		case 'K':
			cardValue = "King";
			break;

		default:
			cardValue = "Invalid";
			break;
		}
	}

	public void printCard() {
		System.out.println(cardValue + " Of " + cardType);
	}
}
