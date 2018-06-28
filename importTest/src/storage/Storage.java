package storage;

import java.util.ArrayList;

import application.model.PraktikKontrakt;
import application.model.PraktikVirksomhed;

public class Storage {
	public static ArrayList<PraktikVirksomhed> praktikVirksomheder = new ArrayList<PraktikVirksomhed>();
	public static ArrayList<PraktikKontrakt> praktikKontrakter = new ArrayList<PraktikKontrakt>();

	public static void addPraktikVirksomhed(PraktikVirksomhed praktikVirksomhed) {
		praktikVirksomheder.add(praktikVirksomhed);
	}

	public static void addPraktikKontrakt(PraktikKontrakt praktikKontrakt) {
		praktikKontrakter.add(praktikKontrakt);
	}

	public static ArrayList<PraktikKontrakt> getPraktikKontrakter() {
		return new ArrayList<PraktikKontrakt>(praktikKontrakter);
	}

	public static ArrayList<PraktikVirksomhed> getPraktikVirksomheder() {
		return new ArrayList<PraktikVirksomhed>(praktikVirksomheder);
	}
}
