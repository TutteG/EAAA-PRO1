package storage;

import java.util.ArrayList;

import application.model.Kamp;
import application.model.Spiller;

public class Storage {
	private static ArrayList<Kamp> kampe = new ArrayList<Kamp>();
	private static ArrayList<Spiller> spillere = new ArrayList<Spiller>();

	public static void addKamp(Kamp kamp) {
		kampe.add(kamp);
	}

	public static void addSpiller(Spiller spiller) {
		spillere.add(spiller);
	}

	public static ArrayList<Kamp> getKampe() {
		return kampe;
	}

	public static ArrayList<Spiller> getSpillere() {
		return spillere;
	}

}
