package rand;

public class RandApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rand randNum = new Rand(100, 90);

		for (int i = 0; i < 20; i++) {
			System.out.println(randNum.randomInRange());
		}

	}

}
