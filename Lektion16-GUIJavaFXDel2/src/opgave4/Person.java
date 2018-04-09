package opgave4;

public class Person {
	private String name;
	private boolean Boy;

	public Person(String name, boolean boy) {
		this.name = name;
		this.Boy = boy;
	}

	@Override
	public String toString() {
		String s = name;
		if (Boy) {
			s = s + "";
		}
		return s;
	}
}
