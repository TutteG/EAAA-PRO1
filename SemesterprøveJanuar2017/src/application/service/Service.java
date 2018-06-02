package application.service;

import java.time.LocalDateTime;

import application.model.Arrangement;
import application.model.KonsolPlads;
import application.model.Område;
import application.model.Plads;
import application.model.Reservation;
import storage.Storage;

public class Service {
	public static Arrangement createArrangement(String navn, boolean offentlig) {
		Arrangement arrangement = new Arrangement(navn, offentlig);
		Storage.addArrangement(arrangement);
		return arrangement;
	}

	public static Reservation createReservation(LocalDateTime start, LocalDateTime slut) {
		Reservation reservation = new Reservation(start, slut);
		Storage.addReservation(reservation);
		return reservation;
	}

	public static Plads createPlads(int nr, Område område) {
		Plads plads = new Plads(nr, område);
		Storage.addPlads(plads);
		return plads;
	}

	public static Plads createKonsolplads(int nr, Område område, String type) {
		// TODO Auto-generated method stub
		Plads plads = new KonsolPlads(nr, område, type);
		Storage.addPlads(plads);
		return plads;

	}

	public static void linkReservationOgArrangement(Reservation reservation, Arrangement arrangement) {
		reservation.setArrangement(arrangement);
		arrangement.addReservation(reservation);
	}

	public static void linkReservationOgPlads(Reservation reservation, Plads plads) {
		reservation.addPlads(plads);
		plads.addReservation(reservation);
	}

	public static Plads findPlads(Område område, int nr) {
		boolean found = false;
		int left = 0;
		int right = Storage.getPladser().size() - 1;
		Plads plads = null;
		while (!found && left <= right) {
			int middle = (left + right) / 2;
			plads = Storage.getPladser().get(middle);
			int comp = plads.compareTo(new Plads(nr, område));
			if (comp == 0) {
				found = true;
			} else if (comp > 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		if (found) {
			return plads;
		} else {
			return null;
		}
	}

	public static void initStorage() {
		Plads plads1 = createPlads(1, Område.TURNERING);
		Plads plads2 = createPlads(2, Område.TURNERING);
		Plads plads3 = createPlads(3, Område.STANDARD);
		Plads plads4 = createPlads(4, Område.STANDARD);
		Plads plads5 = createPlads(5, Område.BØRNE);

		Plads konsolplads1 = createKonsolplads(1, Område.TURNERING, "Playstation 4");
		Plads konsolplads2 = createKonsolplads(2, Område.TURNERING, "Xbox One");

		Arrangement arrangement1 = createArrangement("Dota 2 tournament", true);
		Arrangement arrangement2 = createArrangement("CS:GO tournament", false);

		Reservation reservation1 = createReservation(LocalDateTime.of(2017, 8, 12, 20, 0),
				LocalDateTime.of(2017, 8, 12, 23, 0));
		linkReservationOgPlads(reservation1, plads1);
		linkReservationOgPlads(reservation1, plads2);
		linkReservationOgArrangement(reservation1, arrangement1);
		Reservation reservation2 = createReservation(LocalDateTime.of(2017, 8, 13, 19, 0),
				LocalDateTime.of(2017, 8, 14, 6, 0));
		linkReservationOgPlads(reservation2, plads3);
		linkReservationOgPlads(reservation2, plads4);

		Reservation reservation3 = createReservation(LocalDateTime.of(2017, 8, 14, 19, 0),
				LocalDateTime.of(2017, 8, 15, 6, 0));
		linkReservationOgPlads(reservation3, konsolplads2);
	}
}
