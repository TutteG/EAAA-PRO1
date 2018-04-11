package opgave2;

public class Værkfører extends Mekaniker {
	private int yearOfPromotion;
	private double furtherPayment;

	public Værkfører(String name, String address, double payPerHour, int yearOfGraduation, int yearOfPromotion,
			double furtherPay) {
		// TODO Auto-generated constructor stub
		super(name, address, yearOfGraduation, payPerHour);
		this.furtherPayment = furtherPay;
		this.yearOfPromotion = yearOfPromotion;
	}

	public void setYearOfPromotion(int yearOfPromotion) {
		this.yearOfPromotion = yearOfPromotion;
	}

	public int getYearOfPromotion() {
		return yearOfPromotion;
	}

	public void setFurtherPayment(int furtherPayment) {
		this.furtherPayment = furtherPayment;
	}

	public double getFurtherPayment() {
		return furtherPayment;
	}

	@Override
	public double getWeeklyPay() {
		// TODO Auto-generated method stub
		return super.getWeeklyPay() + (furtherPayment * getWorkWeek());
	}
}
