package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
	private LocalDateTime start;
	private LocalDateTime slut;
	private ArrayList<Plads> pladser;
	private Arrangement arrangement;

	public Reservation(LocalDateTime start, LocalDateTime slut) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.slut = slut;
		this.pladser = new ArrayList<Plads>();
	}

	public Reservation(LocalDateTime start, LocalDateTime slut, Arrangement arrangement) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.slut = slut;
		this.pladser = new ArrayList<Plads>();
		this.arrangement = arrangement;
		arrangement.addReservation(this);
	}

	public void addPlads(Plads plads) {
		this.pladser.add(plads);
	}

	public void setArrangement(Arrangement arrangement) {
		if (this.arrangement == null) {
			this.arrangement = arrangement;
			arrangement.addReservation(this);
		}
	}

	public Arrangement getArrangement() {
		return arrangement;
	}

	public ArrayList<Plads> getPladser() {
		return pladser;
	}

	public LocalDateTime getSlut() {
		return slut;
	}

	public LocalDateTime getStart() {
		return start;
	}
}
