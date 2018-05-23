package DAO;

import java.util.ArrayList;

import model.Gæst;
import model.Vare;

public class DAO {
	public static ArrayList<Vare> varer = new ArrayList<Vare>();
	public static ArrayList<Gæst> gæster = new ArrayList<Gæst>();

	public static ArrayList<Vare> getVarer() {
		return new ArrayList<>(varer);
	}

	public static ArrayList<Gæst> getGæster() {
		return new ArrayList<>(gæster);
	}

	public static void addVare(Vare vare) {
		varer.add(vare);
	}

	public static void addGæst(Gæst gæst) {
		gæster.add(gæst);
	}
}
