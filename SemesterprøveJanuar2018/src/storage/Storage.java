package storage;

import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Tutor;
import application.model.Uddannelse;

public class Storage {
	public static ArrayList<Uddannelse> uddannelser = new ArrayList<Uddannelse>();
	public static ArrayList<Tutor> tutors = new ArrayList<Tutor>();
	public static ArrayList<Arrangement> arrangementer = new ArrayList<Arrangement>();

	public static void addUddannelse(Uddannelse uddannelse) {
		uddannelser.add(uddannelse);
	}

	public static void addTutor(Tutor tutor) {
		tutors.add(tutor);
	}

	public static void addArrangement(Arrangement arrangement) {
		arrangementer.add(arrangement);
	}

	public static ArrayList<Arrangement> getArrangementer() {
		return new ArrayList<>(arrangementer);
	}

	public static ArrayList<Tutor> getTutors() {
		return new ArrayList<>(tutors);
	}

	public static ArrayList<Uddannelse> getUddannelser() {
		return new ArrayList<>(uddannelser);
	}
}
