package yatzy;

/**
 * Models a game of Yatzy.
 */
public class Yatzy {
	/**
	 * Face values of the 5 dice. <br/>
	 * 1 <= values[i] <= 6.
	 */
	private int[] values = new int[5];

	/**
	 * Number of times the 5 dice have been thrown. <br/>
	 * 0 <= throwCount <= 3.
	 */
	private int throwCount = 0;

	/**
	 * Random number generator.
	 */
	private Rand random = new Rand(6, 1);

	/**
	 * Rolls the 5 dice. <br/>
	 * Only roll dice that are not hold. <br/>
	 * Requires: holds contain 5 boolean values.
	 */
	public void throwDice(boolean[] holds) {
		// TODO: Implement
		for (int i = 0; i < values.length; i++) {
			if (!holds[i]) {
				values[i] = random.randomInRange();
				System.out.println(values[i]);
			}

		}
		System.out.println();
		throwCount++;
	}

	/**
	 * Returns the number of times the five dice have been thrown.
	 */
	public int getThrowCount() {
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		throwCount = 0;
	}

	/**
	 * Get current dice values
	 */
	public int[] getValues() {
		return values;
	}

	/**
	 * Set the current dice values
	 */
	public void setValues(int[] values) {
		this.values = values;
	}

	/**
	 * Returns all results possible with the current face values. <br/>
	 * The order of the results is the same as on the score board.
	 */
	public int[] getPossibleResults() {
		int[] results = new int[15];
		for (int i = 0; i <= 5; i++) {
			results[i] = this.valueSpecificFace(i + 1);
		}
		results[6] = this.valueOnePair();
		results[7] = this.valueTwoPair();
		results[8] = this.valueThree();
		results[9] = this.valueFour();
		results[10] = this.valueFullHouse();
		results[11] = this.valueSmallStraight();
		results[12] = this.valueLargeStraight();
		results[13] = this.valueChance();
		results[14] = this.valueYatzy();
		return results;
	}

	/**
	 * Returns an int[7] containing the frequency of face values. <br/>
	 * Frequency at index v is the number of dice with the face value v, 1 <= v <=
	 * 6. <br/>
	 * Index 0 is not used.
	 */
	private int[] freqFaceValue() {
		// TODO: Implement
		int freq[] =
				// {0, 0, 0, 0, 0, 0, 0};
				new int[7];

		// for (int i = 1; i <= 6; i++) {
		for (int j = 0; j < values.length; j++) {
			if (values[j] == 1) {
				freq[1]++;
			} else if (values[j] == 2) {
				freq[2]++;
			} else if (values[j] == 3) {
				freq[3]++;
			} else if (values[j] == 4) {
				freq[4]++;
			} else if (values[j] == 5) {
				freq[5]++;
			} else if (values[j] == 6) {
				freq[6]++;
			}
		}

		return freq;
	}

	/**
	 * Returns the total value for the dice currently showing the given face value
	 *
	 * @param face
	 *            the face value to return values for
	 */
	public int valueSpecificFace(int face) {
		// TODO: Implement
		// Samlet sum af de terninger som viser face øjne.
		int sum = 0;

		for (int i = 0; i < values.length; i++) {
			if (face == values[i]) {
				sum += values[i];
			}
		}
		return sum;
	}

	/**
	 * Returns the maximum value for n-of-a-kind for the given n. <br/>
	 * For example, valueManyOfAKind(3) returns the maximum value for 3 of-a-kind.
	 * <br/>
	 * Requires: 1 <= faceValue and faceValue <= 6
	 *
	 * @param n
	 *            number of kind
	 */
	public int valueManyOfAKind(int n) {
		// TODO: Implement
		int sum = 0;
		int[] freq = freqFaceValue();

		for (int i = 1; i <= 6; i++) {
			if (freq[i] >= n && sum < (i * n)) {
				sum = i * n;
			}
		}

		return sum;
	}

	/**
	 * The current value if you try to score the current face values as Yatzy.
	 */
	public int valueYatzy() {
		// TODO: Implement
		int yatzy = 0;
		int[] freq = freqFaceValue();

		for (int i = 1; i <= 6; i++) {
			if (freq[i] == 5) {
				yatzy = 50;
			}
		}

		return yatzy;
	}

	/**
	 * Returns the current score if used as "chance".
	 */
	public int valueChance() {
		// TODO: Implement
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}

		return sum;
	}

	/**
	 * Returns the current score for one pair.
	 */
	public int valueOnePair() {
		// TODO: Implement

		return valueManyOfAKind(2);
	}

	/**
	 * Returns the current score for two pairs.
	 */
	public int valueTwoPair() {
		// TODO: Implement
		int[] freq = freqFaceValue();
		int counter = 0;
		int sum = 0;

		for (int i = 1; i <= 6; i++) {
			if (freq[i] >= 2) {
				counter++;
				sum += i * 2;
			}
		}
		if (counter == 2) {
			return sum;
		} else {
			return 0;
		}
	}

	/**
	 * Returns the current score for three of a kind.
	 */
	public int valueThree() {
		// TODO: Implement
		int[] freq = freqFaceValue();
		int sum = 0;

		for (int i = 1; i <= 6; i++) {
			if (freq[i] >= 3) {
				sum = 3 * i;
				// sum = valueManyOfAKind(3);
			}
		}
		return sum;
	}

	/**
	 * Returns the current score for four of a kind.
	 */
	public int valueFour() {
		// TODO: Implement
		int[] freq = freqFaceValue();
		// int counter = 4;
		int sum = 0;

		for (int i = 1; i <= 6; i++) {
			if (freq[i] >= 4) {
				sum = 4 * i;
			}
		}

		return sum;
	}

	/**
	 * Returns the value of a small straight with the current face values.
	 */
	public int valueSmallStraight() {
		// TODO: Implement
		int[] freq = freqFaceValue();
		boolean straight = true;
		int sum = 0;

		for (int i = 1; i <= 5; i++) {
			if (freq[i] == 1 && straight) {
				sum += i;
			} else {
				straight = false;
				sum = 0;
			}
		}

		return sum;
	}

	/**
	 * Returns the value of a large straight with the current face values.
	 */
	public int valueLargeStraight() {
		// TODO: Implement
		int[] freq = freqFaceValue();
		boolean straight = true;
		int sum = 0;

		for (int i = 2; i <= 6; i++) {
			if (freq[i] == 1 && straight) {
				sum += i;
			} else {
				straight = false;
				sum = 0;
			}
		}

		return sum;
	}

	/**
	 * Returns the value of a full house with the current face values.
	 */
	public int valueFullHouse() {
		// TODO: Implement
		int result = 0;
		int onePair = 0;
		int threeOfAKind = 0;
		for (int i = 0; i < freqFaceValue().length; i++) {
			if (freqFaceValue()[i] == 2) {
				onePair = i * 2;
			} else if (freqFaceValue()[i] == 3) {
				threeOfAKind = i * 3;
			}
		}
		if (threeOfAKind > 0 && onePair > 0) {
			result = onePair + threeOfAKind;
		}
		return result;
	}

}
