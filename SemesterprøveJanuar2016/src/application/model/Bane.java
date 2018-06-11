package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
	private int nummer;
	private String baneInfo;
	private ArrayList<Reservation> reservationer;

	public Bane(int nummer, String baneInfo) {
		// TODO Auto-generated constructor stub
		this.nummer = nummer;
		this.baneInfo = baneInfo;
		this.reservationer = new ArrayList<Reservation>();
	}

	public ArrayList<Reservation> getReservationer() {
		return reservationer;
	}

	public boolean isLedig(LocalDate dato, LocalTime startTid) {
		boolean foundTid = true;
		int i = 0;
		while (foundTid & i < reservationer.size()) {
			if (reservationer.get(i).getDato().equals(dato) && reservationer.get(i).getStartTid().equals(startTid)) {
				foundTid = false;
			} else {
				i++;
			}
		}
		return foundTid;
	}

	public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato) {
		ArrayList<LocalTime> ledigeTider = new ArrayList<LocalTime>();
		ledigeTiderHjælpeMetode(ledigeTider);
		int i = 0;
		while (i < reservationer.size()) {
			if (reservationer.get(i).getDato().equals(dato)) {
				int i2 = 0;
				boolean found = false;
				while (!found && i2 < ledigeTider.size()) {
					if (reservationer.get(i).getStartTid().equals(ledigeTider.get(i2))) {
						ledigeTider.remove(i2);
						found = true;
					} else {
						i2++;
					}
				}
				i++;
			}
		}
		return ledigeTider;
	}

	private ArrayList<LocalTime> ledigeTiderHjælpeMetode(ArrayList<LocalTime> ledigeTider) {
		int i = 6;
		while (i < 23) {
			ledigeTider.add(LocalTime.of(i, 0));
			i++;
		}
		return ledigeTider;
	}

	public String getBaneInfo() {
		return baneInfo;
	}

	public int getNummer() {
		return nummer;
	}

	// public void addReservation(Reservation reservation) {
	// reservationer.add(reservation);
	// }

	public void addReservation(Reservation reservation) {
		if (reservationer.isEmpty() || reservation.compareTo(reservationer.get(reservationer.size() - 1)) > 0) {
			reservationer.add(reservation);
		} else {
			boolean found = false;
			int i = reservationer.size() - 1;
			while (!found && i >= 0) {
				if (reservation.compareTo(reservationer.get(i)) < 0
						|| reservation.compareTo(reservationer.get(i)) == 0) {
					reservationer.add(i, reservation);
					found = true;
				} else {
					i--;
				}
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nummer + "\t" + baneInfo;
	}

}
