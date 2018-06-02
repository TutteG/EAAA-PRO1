package storage;

import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Plads;
import application.model.Reservation;

public class Storage {
	public static ArrayList<Arrangement> arrangementer = new ArrayList<Arrangement>();
	public static ArrayList<Reservation> reservationer = new ArrayList<Reservation>();
	public static ArrayList<Plads> pladser = new ArrayList<Plads>();

	public static ArrayList<Arrangement> getArrangementer() {
		return new ArrayList<Arrangement>(arrangementer);
	}

	public static ArrayList<Plads> getPladser() {
		return new ArrayList<Plads>(pladser);
	}

	public static ArrayList<Reservation> getReservationer() {
		return new ArrayList<Reservation>(reservationer);
	}

	public static void addArrangement(Arrangement arrangement) {
		arrangementer.add(arrangement);
	}

	public static void addReservation(Reservation reservation) {
		reservationer.add(reservation);
	}

	public static void addPlads(Plads plads) {
		pladser.add(plads);
	}
}
