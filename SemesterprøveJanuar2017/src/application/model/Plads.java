package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Plads implements Comparable<Plads> {
	private int nr;
	private Område område;
	private ArrayList<Reservation> reservationer;
	public static double standardTimePris = 50;

	public Plads(int nr, Område område) {
		// TODO Auto-generated constructor stub
		this.nr = nr;
		this.område = område;
		this.reservationer = new ArrayList<Reservation>();
	}

	public static double getStandardTimePris() {
		return standardTimePris;
	}

	public static void setStandardTimePris(double standardTimePris) {
		Plads.standardTimePris = standardTimePris;
	}

	public double pris(int timer) {
		if (område.equals(Område.VIP)) {
			return (timer * standardTimePris) * 1.25;
		} else if (område.equals(Område.BØRNE)) {
			return (timer * standardTimePris) * 0.8;
		} else if (område.equals(Område.TURNERING)) {
			return (timer * standardTimePris) * 1.2;
		} else {
			return timer * standardTimePris;
		}
	}

	public int getNr() {
		return nr;
	}

	public ArrayList<Reservation> getReservationer() {
		return reservationer;
	}

	public void addReservation(Reservation reservation) {
		this.reservationer.add(reservation);
	}

	public Område getOmråde() {
		return område;
	}

	public int samletReservationstid(LocalDateTime fra, LocalDateTime til) {
		int samletTid = 0;
		for (Reservation reservation : reservationer) {
			if (reservation.getStart().isEqual(fra) && reservation.getSlut().isEqual(til)) {
				samletTid += til.getHour() - fra.getHour();
			} else if (reservation.getStart().isBefore(fra) && reservation.getSlut().isEqual(til)) {
				// Fuck this method....
			}
		}

		return samletTid;
	}

	@Override
	public int compareTo(Plads o) {
		// TODO Auto-generated method stub
		if (område.compareTo(o.getOmråde()) == 0) {
			if (nr < o.getNr()) {
				return -1;
			} else if (nr > o.getNr()) {
				return 1;
			} else {
				return 0;
			}
		}
		return område.compareTo(o.getOmråde());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Plads: [" + nr + "," + område.toString() + "]";
	}
}
