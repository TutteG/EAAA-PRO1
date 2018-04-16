package opgave3;

public class AgeDiscount implements Discount {
	private double originalPrice;
	private double amount;
	private int age;

	public AgeDiscount(double originalPrice, int age) {
		// TODO Auto-generated constructor stub
		this.originalPrice = originalPrice;
		this.amount = 0;
		this.age = age;
	}

	public void setAmount() {
		this.amount = originalPrice / 100 * age;
	}

	@Override
	public double getDiscountedPrice(double originalPrice) {
		// TODO Auto-generated method stub
		setAmount();
		return originalPrice - amount;
	}

}
