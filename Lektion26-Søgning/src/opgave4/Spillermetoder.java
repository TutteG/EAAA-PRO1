package opgave4;

import java.util.ArrayList;

public class Spillermetoder {
	public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
		// TODO Opgave 4.1
		boolean found = false;
		int i = 0;
		Spiller spiller = null;
		while (!found && i < spillere.size()) {
			spiller = spillere.get(i);
			if (spillere.get(i).getMaal() == score) {
				found = true;
			} else {
				i++;
			}
		}
		if (found) {
			return spiller;
		} else {
			return null;
		}
	}

	public Spiller findScoreBinærAscending(ArrayList<Spiller> spillere, int score) {
		boolean found = false;
		int left = 0;
		int right = spillere.size() - 1;
		int middle = -1;
		Spiller spiller = null;
		while (!found && left <= right) {
			middle = (left + right) / 2;
			spiller = spillere.get(middle);
			int comp = spiller.getMaal();
			if (comp == score) {
				found = true;
			} else if (comp > score) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		if (found) {
			return spiller;
		} else {
			return null;
		}
	}

	public Spiller findScoreBinærDescending(ArrayList<Spiller> spillere, int score) {
		boolean found = false;
		int left = 0;
		int right = spillere.size() - 1;
		int middle = -1;
		Spiller spiller = null;
		while (!found && left <= right) {
			middle = (left + right) / 2;
			spiller = spillere.get(middle);
			int comp = spiller.getMaal();
			if (comp == score) {
				found = true;
			} else if (comp < score) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		if (found) {
			return spiller;
		} else {
			return null;
		}
	}

	public String godSpiller(ArrayList<Spiller> spillere) {
		int i = 0;
		boolean found = false;
		Spiller spiller = null;
		while (!found && i < spillere.size()) {
			spiller = spillere.get(i);
			if (spiller.getHoejde() < 171 && spiller.getMaal() >= 50) {
				found = true;
			}
			i++;
		}
		if (found) {
			return spiller.toString();
		} else {
			return "ingen spiller fundet";
		}
	}

	// Her tilføjes metoder der løser opgve 4.2 og 4.3

	public static void main(String[] args) {
		Spillermetoder metoder = new Spillermetoder();

		// Her afprøves opgave 4.1
		ArrayList<Spiller> spillerListe = new ArrayList<>();
		spillerListe.add(new Spiller("Hans", 196, 99, 45));
		spillerListe.add(new Spiller("Bo", 203, 89, 60));
		spillerListe.add(new Spiller("Jens", 166, 109, 90));
		spillerListe.add(new Spiller("Finn", 194, 102, 12));
		spillerListe.add(new Spiller("Lars", 192, 86, 35));
		spillerListe.add(new Spiller("Mads", 150, 103, 60));

		System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
		System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));

		// Tilføj kode der afprøver opgaver 4.2 og 4.3

		ArrayList<Spiller> spillere = new ArrayList<>();
		spillere.add(new Spiller("Finn", 194, 102, 12));
		spillere.add(new Spiller("Jens", 188, 109, 32));
		spillere.add(new Spiller("Lars", 166, 86, 35));
		spillere.add(new Spiller("Mads", 200, 103, 37));
		spillere.add(new Spiller("Hans", 196, 99, 45));
		spillere.add(new Spiller("Bo", 203, 89, 60));

		System.out.println("opgave 4.2: Ascending order");
		System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreBinærAscending(spillere, 35));
		System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreBinærAscending(spillere, 30));

		System.out.println("Spiller der har scoret 12 mål: " + metoder.findScoreBinærAscending(spillere, 12));

		ArrayList<Spiller> spillerere = new ArrayList<>();
		spillerere.add(new Spiller("Bo", 203, 89, 60));
		spillerere.add(new Spiller("Hans", 196, 99, 45));
		spillerere.add(new Spiller("Mads", 200, 103, 37));
		spillerere.add(new Spiller("Lars", 192, 86, 35));
		spillerere.add(new Spiller("Jens", 188, 109, 32));
		spillerere.add(new Spiller("Finn", 194, 102, 12));

		System.out.println("opgave 4.2: Descending order");
		System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreBinærDescending(spillerere, 35));
		System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreBinærDescending(spillerere, 30));

		System.out.println("Spiller der har scoret 12 mål: " + metoder.findScoreBinærDescending(spillerere, 12));

		System.out.println("Test af godSpiller(): " + metoder.godSpiller(spillerListe));
	}

}
