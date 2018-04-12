package opgave3;

public class PercentDiscount extends Discount {
	private int percent;

	public PercentDiscount(double originalPrice, int percent) {
		// TODO Auto-generated constructor stub
		super(originalPrice);
		this.percent = percent;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	@Override
	public double getDiscountedPrice(double originalPrice) {
		double discount = (super.getDiscountedPrice(originalPrice) / 100) * percent;
		return super.getDiscountedPrice(originalPrice) - discount;
	}
}
