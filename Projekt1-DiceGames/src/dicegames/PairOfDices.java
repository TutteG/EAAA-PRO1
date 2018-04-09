package dicegames;

/**
 * This class models one pair of dices. This is useful for games where you have
 * to throw two dice at once.
 */
public class PairOfDices {
	/**
	 * The first die in the pair.
	 */
	private Die die1;
	/**
	 * The second die in the pair.
	 */
	private Die die2;
	private int counterRoll;
	private int counterEyes[];
	private int counterPairs;
	private int biggestRoll;

	/**
	 * Constructor for objects of class PairOfDices
	 */
	// TODO: put the constructor here!
	public PairOfDices() {
		Die dice1 = new Die();
		this.die1 = dice1;
		Die dice2 = new Die();
		this.die2 = dice2;
		counterEyes = new int[6];
	}

	public PairOfDices(int sides) {
		Die dice1 = new Die(sides);
		this.die1 = dice1;
		Die dice2 = new Die(sides);
		this.die2 = dice2;
		counterEyes = new int[sides];

	}
	// Remember, the constructor should initialize die1 and die2.

	public void rollBothDices() {
		die1.roll();
		die2.roll();
		if (die1.getFaceValue() == die2.getFaceValue()) {
			counterPairs++;
		}
		if (biggestRoll < this.sumOfDices()) {
			biggestRoll = this.sumOfDices();
		}
		counterEyes[die1.getFaceValue() - 1]++;
		counterEyes[die2.getFaceValue() - 1]++;
		counterRoll++;

		// if (die1.getFaceValue() == 6) {
		// //counterSix++;
		//
		// }
		// if (die2.getFaceValue() == 6) {
		// //counterSix++;
		// }
	}

	public int sumOfDices() {
		return die1.getFaceValue() + die2.getFaceValue();
	}

	public int getEyeCounter(int eyes) {
		return counterEyes[eyes];
	}

	// WTF!?
	public int getCounterRolls() {
		return counterRoll;
	}

	public int getCounterPairs() {
		return counterPairs;
	}

	public int getBiggestRoll() {
		return biggestRoll;
	}

	public void resetPairOfDices() {
		counterPairs = 0;
		counterRoll = 0;
		biggestRoll = 0;
		die1 = new Die(die1.getSides());
		die2 = new Die(die2.getSides());
		counterEyes = new int[die1.getSides()];
	}
}
