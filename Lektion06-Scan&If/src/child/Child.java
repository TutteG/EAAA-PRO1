package child;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public String gender() {
		if (boy == true) {
			return "Gender: boy";
		} else if (boy == false) {
			return "Gender: girl";
		} else {
			return "Gender not available";
		}
	}

	public String team() {
		if (boy == true && age >= 0 && age < 8) {
			return "Young cubs";
		} else if (boy == true && age >= 8) {
			return "Cool cubs";
		} else if (boy == false && age >= 0 && age < 8) {
			return "Tumbling girls";
		} else if (boy == false && age >= 8) {
			return "Springy girls";
		} else {
			return "No team for you!";
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		if (age == 0) {
			return "Home ";
		} else if (age >= 1 && age <= 2) {
			return "Nursery ";
		} else if (age >= 3 && age <= 5) {
			return "Kindergarten";
		} else if (age >= 6 && age <= 16) {
			return "School";
		} else if (age >= 17) {
			return "Out of school";
		} else {
			return "age is out of scope";
		}
	}

}
