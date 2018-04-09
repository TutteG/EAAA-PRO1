package person;

public class PersonApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person per = new Person("Per");
		per.setAddress("Rosenhøj");
		per.setMonthlySalary(30000);
		per.addEmployment();
		per.addEmployment();
		per.printPerson();
	}

}
