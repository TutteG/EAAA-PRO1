package opgave5;

import java.util.ArrayList;

public class Episode {
	private int number;
	private ArrayList<String> guestActors = new ArrayList<String>();
	private int lengthMinutes;

	Episode(int number, ArrayList<String> guestActors, int length) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.guestActors = guestActors;
		this.lengthMinutes = length;
	}

	public int getNumber() {
		return number;
	}

	public int getLenght() {
		return lengthMinutes;
	}

	public ArrayList<String> getGuestActors() {
		return this.guestActors;
	}

}
