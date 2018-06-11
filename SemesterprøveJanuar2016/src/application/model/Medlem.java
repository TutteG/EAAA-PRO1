package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
	private String navn;
	private String mobil;
	private String mail;
	private ArrayList<Reservation> reservationer;

	public Medlem(String navn, String mobil, String mail) {
		this.navn = navn;
		this.mobil = mobil;
		this.mail = mail;
		this.reservationer = new ArrayList<Reservation>();
	}

	public String getMail() {
		return mail;
	}

	public String getMobil() {
		return mobil;
	}

	public String getNavn() {
		return navn;
	}

	public ArrayList<Reservation> getReservationer() {
		return reservationer;
	}

	public void addReservation(Reservation reservation) {
		reservationer.add(reservation);
	}

	public Reservation createReservation(LocalDate dato, LocalTime startTid, Bane bane, Medlem makker) {
		// TODO Auto-generated method stub
		Reservation reservation = new Reservation(dato, startTid, bane, this, makker);
		return reservation;
	}

	public boolean hasAktivReservation() {
		// TODO Auto-generated method stub
		for (Reservation reservation : reservationer) {
			if (LocalDate.now().isEqual(reservation.getDato())) {
				if (LocalTime.now().equals(reservation.getStartTid())
						|| (LocalTime.now().isAfter(reservation.getStartTid())
								&& LocalTime.now().isBefore(reservation.getStartTid().plusHours(1)))) {
					return true;
				}
			}
		}
		return false;
	}
}
