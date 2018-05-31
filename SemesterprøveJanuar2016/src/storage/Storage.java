package storage;

import java.util.ArrayList;

import application.model.Bane;
import application.model.Medlem;

public class Storage {
	public static ArrayList<Bane> baner = new ArrayList<Bane>();
	public static ArrayList<Medlem> medlemmer = new ArrayList<Medlem>();

	public static void addBane(Bane bane) {
		baner.add(bane);
	}

	public static void addMedlem(Medlem medlem) {
		medlemmer.add(medlem);
	}

	public static ArrayList<Bane> getBaner() {
		return new ArrayList<>(baner);
	}

	public static ArrayList<Medlem> getMedlemmer() {
		return new ArrayList<>(medlemmer);
	}
}
