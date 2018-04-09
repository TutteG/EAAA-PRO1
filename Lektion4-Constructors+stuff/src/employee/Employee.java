package employee;

public class Employee {
	private String name;
	private boolean trainee;
	private int age;
	private String lastName;

	public Employee(String inputName, String inputLastName, int inputAge) {
		name = inputName;
		lastName = inputLastName;
		trainee = true;
		age = inputAge;
	}

	// Get metoder/accessors
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean isTrainee() {
		return trainee;
	}

	// set metoder / mutators
	public void employeeBirthday() {
		age++;
		// age = age + 1
	}

	public void setAge(int inputAge) {
		age = inputAge;
	}

	public void setName(String inputName) {
		name = inputName;
	}

	public void setLastName(String inputName) {
		lastName = inputName;
	}

	public void setTrainee(boolean traineeStatus) {
		trainee = traineeStatus;
	}

	public void printEmployee() {
		System.out.println("***************");
		System.out.println("Employee name: " + name);
		System.out.println("Employee last name: " + lastName);
		System.out.println("Employee age: " + age);
		System.out.println("Trainee status: " + trainee);
		System.out.println("***************");
	}

}
