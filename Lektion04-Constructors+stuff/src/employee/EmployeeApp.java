package employee;

public class EmployeeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee("Janus", "Andersen", 18);
		emp1.printEmployee();
		emp1.setTrainee(false);
		emp1.printEmployee();
		emp1.employeeBirthday();
		System.out.println(emp1.getAge());
		emp1.printEmployee();

	}

}
