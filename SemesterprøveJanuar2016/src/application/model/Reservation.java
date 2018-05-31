package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Comparable<Reservation> {
	private LocalDate dato;
	private LocalTime startTid;
	private Bane bane;
	private Medlem booker;
	private Medlem makker;

	Reservation(LocalDate dato, LocalTime startTid, Bane bane, Medlem booker, Medlem makker) {
		// TODO Auto-generated constructor stub
		this.dato = dato;
		this.startTid = startTid;
		this.bane = bane;
		this.booker = booker;
		this.makker = makker;
		booker.addReservation(this);
		makker.addReservation(this);
	}

	public Bane getBane() {
		return bane;
	}

	public LocalDate getDato() {
		return dato;
	}

	public LocalTime getStartTid() {
		return startTid;
	}

	public Medlem getBooker() {
		return booker;
	}

	public Medlem getMakker() {
		return makker;
	}

	@Override
	public int compareTo(Reservation o) {
		// TODO Auto-generated method stub
		if (dato.compareTo(o.getDato()) == 0) {
			if (startTid.compareTo(o.getStartTid()) == 0) {
				if (bane.getNummer() == o.getBane().getNummer()) {
					return 0;
				}
			} else {
				return startTid.compareTo(o.getStartTid());
			}
		}
		return dato.compareTo(o.getDato());
	}
}