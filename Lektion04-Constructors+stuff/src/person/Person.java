package person;

public class Person {

	private String name;
	private String address;
	private double monthlySalary;
	// annualSalary skal ikke gemmes
	// private double annualSalary;
	private double vacationBonus = 1.025;
	public int earlierEmployment = 0;

	public Person(String inputName) {
		name = inputName;
	}

	public void setName(String inputName) {
		name = inputName;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String inputAddress) {
		address = inputAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setMonthlySalary(double inputMonthlySalary) {
		monthlySalary = inputMonthlySalary;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public double getAnnualSalary() {
		// vacationBonus = (monthlySalary * 12) * 0.025;
		// annualSalary = monthlySalary * 12 + vacationBonus;
		// return annualSalary;
		return monthlySalary * 12 * vacationBonus;
	}

	public void addEmployment() {
		earlierEmployment++;
	}

	public void printPerson() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Monthly salary: " + monthlySalary);
		System.out.println("Annual salary: " + getAnnualSalary());
		System.out.println("Earlier employments: " + earlierEmployment);
	}
}
