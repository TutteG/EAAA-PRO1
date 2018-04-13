package opgave3;

import java.util.ArrayList;

public abstract class Ansat extends Person {

	private double payPerHour;
	private int yearOfEmployment;
	private int workWeek;

	public Ansat(String name, String address, double payPerHour, int yearOfEmployment, int workWeek) {
		// TODO Auto-generated constructor stub
		super(name, address);
		this.payPerHour = payPerHour;
		this.yearOfEmployment = yearOfEmployment;
		this.workWeek = workWeek;
	}

	public void setPayPerHour(double payPerHour) {
		this.payPerHour = payPerHour;
	}

	public double getPayPerHour() {
		return payPerHour;
	}

	public void setYearOfEmployment(int yearOfEmployment) {
		this.yearOfEmployment = yearOfEmployment;
	}

	public int getYearOfEmployment() {
		return yearOfEmployment;
	}

	public void setWorkWeek(int workWeek) {
		this.workWeek = workWeek;
	}

	public int getWorkWeek() {
		return workWeek;
	}

	public double getWeeklyPay() {
		// TODO Auto-generated method stub
		return workWeek * payPerHour;
	}

	public static double beregnSamletLøn(ArrayList<Ansat> ansatList) {
		double samletLøn = 0.0;
		for (Ansat ansat : ansatList) {
			samletLøn += ansat.getWeeklyPay();
		}
		return samletLøn;

	}
}
