package opgave3;

public class Mekaniker extends Ansat {
	private int yearOfGraduation;

	public Mekaniker(String name, String address, int yearOfGraduation, double payPerHour, int workWeek) {
		// TODO Auto-generated constructor stub
		super(name, address, payPerHour, yearOfGraduation, workWeek);
		this.yearOfGraduation = yearOfGraduation;

	}

	public void setYearOfGraduation(int yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}

	public int getYearOfGraduation() {
		return yearOfGraduation;
	}

}
