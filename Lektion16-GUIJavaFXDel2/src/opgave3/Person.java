package opgave3;

public class Person {
	private String name;
	private String title;
	private boolean senior;

	public Person(String name, String titel, boolean senior) {
		this.name = name;
		this.title = titel;
		this.senior = senior;
	}

	@Override
	public String toString() {
		String s = title + " " + name;
		if (senior) {
			s = s + " (senior)";
		}
		return s;
	}
}
