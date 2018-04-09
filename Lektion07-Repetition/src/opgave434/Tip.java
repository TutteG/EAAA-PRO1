package opgave434;

public class Tip {
	private int rating;
	private double mealPrice;

	public Tip(int rating, double mealPrice) {
		this.rating = rating;
		this.mealPrice = mealPrice;

	}

	public double calculateTip() {
		if (rating == 1) {
			this.mealPrice = this.mealPrice * 1.2;
		} else if (rating == 2) {
			this.mealPrice = this.mealPrice * 1.15;
		} else if (rating == 3) {
			this.mealPrice = this.mealPrice * 1.1;
		} else {
			System.out.println("Rating invalid, Therefore no tip");
		}
		return mealPrice;
	}

}
