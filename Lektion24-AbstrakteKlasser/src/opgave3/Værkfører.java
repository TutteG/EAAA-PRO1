package opgave3;

public class Værkfører extends Ansat {
	private double furtherPayment;
	private int yearOfGraduation;

	public Værkfører(String name, String address, double payPerHour, int yearOfEmployment, double furtherPay,
			int workWeek, int yearOfGraduation) {
		// TODO Auto-generated constructor stub
		super(name, address, payPerHour, yearOfEmployment, workWeek);
		this.furtherPayment = furtherPay;
		this.yearOfGraduation = yearOfGraduation;

	}

	public int getYearOfGraduation() {
		return yearOfGraduation;
	}

	public void setYearOfGraduation(int yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
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
