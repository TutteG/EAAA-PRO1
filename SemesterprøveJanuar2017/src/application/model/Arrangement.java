package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Arrangement {
	private String navn;
	private boolean offentlig;
	private ArrayList<Reservation> reservationer;

	public Arrangement(String navn, boolean offentlig) {
		// TODO Auto-generated constructor stub'
		this.navn = navn;
		this.offentlig = offentlig;
		this.reservationer = new ArrayList<Reservation>();
	}

	public ArrayList<Reservation> getReservationer() {
		return reservationer;
	}

	public void addReservation(Reservation reservation) {
		reservationer.add(reservation);
	}

	public Reservation createReservation(LocalDateTime start, LocalDateTime slut) {
		Reservation reservation = new Reservation(start, slut, this);
		return reservation;
	}

	public String getNavn() {
		return navn;
	}

	public boolean isOffentlig() {
		return offentlig;
	}

	public int antalLedigePladser() {
		int antal = 0;
		for (Reservation reservation : reservationer) {
			antal += reservation.getPladser().size();
		}
		return antal;
	}
}
