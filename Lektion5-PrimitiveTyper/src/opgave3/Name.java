package opgave3;

public class Name {
	private String firstName;
	private String midName;
	private String lastName;

	public Name(String firstName, String midName, String lastName) {
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInit() {
		return firstName.substring(0, 1) + midName.substring(0, 1) + lastName.substring(0, 1);
	}

	public String getUsername() {
		return firstName.substring(0, 2) + midName.length()
				+ lastName.substring(lastName.length() - 2, lastName.length());
	}
}
