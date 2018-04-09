package rand;

public class Rand {
	private int rangeMin;
	private int rangeMax;

	public Rand(int maxRange, int minRange) {
		rangeMax = maxRange;
		rangeMin = minRange;
	}

	public int randomInRange() {
		int range = (rangeMax - rangeMin) + 1;
		return (int) (Math.random() * range) + rangeMin;
	}

}
