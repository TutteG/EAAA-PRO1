package opgave1;

public class Hund {
	private String name;
	private boolean stamtavle;
	private int price;
	private Race race;

	public Hund(String navn, boolean stamtavle, int pris, Race race) {
		// TODO Auto-generated constructor stub
		this.name = navn;
		this.stamtavle = stamtavle;
		this.price = pris;
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public Race getRace() {
		return race;
	}

	public boolean isStamtavle() {
		return stamtavle;
	}
}
