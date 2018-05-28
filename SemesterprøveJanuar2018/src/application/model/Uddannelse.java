package application.model;

import java.util.ArrayList;

public class Uddannelse {
	private String name;
	private ArrayList<Hold> holdListe;

	public Uddannelse(String name) {
		this.name = name;
		this.holdListe = new ArrayList<Hold>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Hold> getHoldListe() {
		return holdListe;
	}

	public Hold createHold(String betegnelse, String holdleder) {
		Hold hold = new Hold(betegnelse, holdleder, this);
		return hold;
	}

	public void addHold(Hold hold) {
		holdListe.add(hold);
	}

	public ArrayList<String> tutorOversigt() {
		ArrayList<String> tutorListe = new ArrayList<String>();
		for (Hold hold : holdListe) {
			for (Tutor tutor : hold.getTutors()) {
				tutorListe.add(tutor.toString());
			}
		}
		return tutorListe;
	}
}
