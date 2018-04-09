package opgave4;

public class Stars {
	final int MAX_ROWS = 10;
	final int MIN_ROWS = 1;

	public void starPicture() {
		for (int row = 1; row <= MAX_ROWS; row++) {
			for (int star = 1; star <= row; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void starPictureA() {
		// TODO
		for (int row = 10; row >= MIN_ROWS; row--) {
			for (int star = 1; star <= row; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void starPictureB() {
		// TODO
		String stjerneString = "           ";
		char[] stjerneArray = stjerneString.toCharArray();
		for (int row = 10; row >= MIN_ROWS; row--) {
			for (int star = 10; star >= row; star--) {
				stjerneArray[star] = '*';
			}
			System.out.println(stjerneArray);
		}
	}

	public void starPictureC() {
		// TODO
		String stjerneString = "**********";
		char[] stjerneArray = stjerneString.toCharArray();
		for (int star = 0; star <= MAX_ROWS - 1; star++) {
			System.out.println(stjerneArray);
			stjerneArray[star] = ' ';
		}
	}

	public void starPictureD() {
		// TODO
		String stjerneString = "      *       ";
		char[] stjerneArray = stjerneString.toCharArray();
		int starSub = 6;
		int starAdd = starSub;
		for (; starAdd <= 10; ++starAdd) {
			System.out.println(stjerneArray);
			starSub--;
			stjerneArray[starAdd + 1] = '*';
			stjerneArray[starSub] = '*';

		}
		System.out.println(stjerneArray);
		for (; starSub <= 10; starSub++) {
			System.out.println(stjerneArray);

			stjerneArray[starAdd] = ' ';
			stjerneArray[starSub] = ' ';
			starAdd--;
		}

	}
}
