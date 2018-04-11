package opgave1;

public class Værkfører extends Mekaniker {
	private int yearOfPromotion;
	private int furtherPayment;

	public Værkfører(String name, String address, int payPerHour, int yearOfGraduation, int yearOfPromotion,
			int furtherPay) {
		// TODO Auto-generated constructor stub
		super(name, address, payPerHour, yearOfGraduation);
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

	public int getFurtherPayment() {
		return furtherPayment;
	}

}
