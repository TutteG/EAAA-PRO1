package opgave3;

public class FixedDiscount extends Discount {
	double amount;

	public FixedDiscount(double originalPrice, double amount) {
		// TODO Auto-generated constructor stub
		super(originalPrice);
		this.amount = amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public double getDiscountedPrice(double originalPrice) {
		// TODO Auto-generated method stub
		return super.getDiscountedPrice(originalPrice) - amount;
	}
}
