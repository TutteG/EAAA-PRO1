package opgave1;

public class Mekaniker extends Person {
	private int yearOfGraduation;
	private int payPerHour;

	public Mekaniker(String name, String address, int yearOfGraduation, int payPerHour) {
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

	public int getPayPerHour() {
		return payPerHour;
	}
}
