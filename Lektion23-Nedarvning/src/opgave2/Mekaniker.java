package opgave2;

import java.util.ArrayList;

public class Mekaniker extends Person {
	private int yearOfGraduation;
	private double payPerHour;
	private int workWeek = 37;

	public Mekaniker(String name, String address, int yearOfGraduation, double payPerHour) {
		// TODO Auto-generated constructor stub
		super(name, address);
		this.yearOfGraduation = yearOfGraduation;
		this.payPerHour = payPerHour;
	}

	public void setYearOfGraduation(int yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}

	public int getYearOfGraduation() {
		return yearOfGraduation;
	}

	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}

	public double getPayPerHour() {
		return payPerHour;
	}

	public int getWorkWeek() {
		return workWeek;
	}

	public double getWeeklyPay() {
		return payPerHour * workWeek;
	}

	public static double beregnSamletLøn(ArrayList<Mekaniker> mekanikerList) {
		double samletLøn = 0.0;
		for (Mekaniker mekaniker : mekanikerList) {
			samletLøn += mekaniker.getWeeklyPay();
		}
		return samletLøn;

	}

}
