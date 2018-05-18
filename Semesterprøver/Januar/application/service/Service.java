package application.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import application.model.Deltagelse;
import application.model.Kamp;
import application.model.ProfSpiller;
import application.model.Spiller;
import storage.Storage;

public class Service {
	public static Spiller createSpiller(String navn, int årgang) {
		Spiller spiller = new Spiller(navn, årgang);
		Storage.addSpiller(spiller);
		return spiller;
	}

	public static ProfSpiller createProfSpiller(String navn, int årgang, double kampHonorar) {
		ProfSpiller spiller = new ProfSpiller(navn, årgang, kampHonorar);
		Storage.addSpiller(spiller);
		return spiller;
	}

	public static Kamp createKamp(String sted, LocalDate dato, LocalTime tid) {
		Kamp kamp = new Kamp(sted, dato, tid);
		Storage.addKamp(kamp);
		return kamp;
	}

	public static Deltagelse createDeltagelse(String begrundelse) {
		Deltagelse deltagelse = new Deltagelse(begrundelse);
		return deltagelse;
	}

	/**
	 * Opdaterer sammenhængen mellem spiller og deltagelse så de linker til hinanden
	 * Precondition: spiller != null og deltagelse != null
	 */
	public static void updateSpillerDeltager(Deltagelse deltagelse, Spiller spiller) {
		// TODO Auto-generated method stub
		if (spiller != null && deltagelse != null) {
			spiller.addDeltagelse(deltagelse);
			deltagelse.setSpiller(spiller);
		}
	}

	public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2) {
		ArrayList<Kamp> kampe = new ArrayList<Kamp>();
		int i1 = 0;
		int i2 = 0;
		while (i1 < list1.size() && i2 < list2.size()) {
			if (list1.get(i1).compareTo(list2.get(i2)) < 0) {
				kampe.add(list1.get(i1));
				i1++;
			} else if (list1.get(i1).compareTo(list2.get(i2)) > 0) {
				kampe.add(list2.get(i2));
				i2++;
			} else {
				kampe.add(list1.get(i1));
				i1++;
				i2++;
			}
		}
		while (i1 < list1.size()) {
			kampe.add(list1.get(i1));
			i1++;
		}
		while (i2 < list2.size()) {
			kampe.add(list2.get(i2));
			i2++;
		}
		return kampe;
	}

	public static void createSomeObjects() {
		Spiller sp1 = createSpiller("Jane Jensen", 1999);
		Spiller sp2 = createSpiller("Lene Hansen", 2000);
		Spiller sp3 = createSpiller("Mette Petersen", 1999);

		Spiller sp4 = createProfSpiller("Sofia Kjeldsen", 1999, 50);
		Spiller sp5 = createProfSpiller("Maria Nielsen", 2000, 55);

		Kamp k1 = createKamp("Herning", LocalDate.parse("2015-01-26"), LocalTime.parse("10:30:00"));
		Kamp k2 = createKamp("Ikast", LocalDate.parse("2015-01-27"), LocalTime.parse("13:30:00"));

		Deltagelse deltagelse1 = createDeltagelse("Moster Odas fødselsdag");
		deltagelse1.setAfbud(true);
		Deltagelse deltagelse2 = createDeltagelse("Hun er pisse doven!");
		deltagelse2.setAfbud(true);
		Deltagelse deltagelse3 = createDeltagelse("");
		Deltagelse deltagelse4 = createDeltagelse("");
		Deltagelse deltagelse5 = createDeltagelse("");
		Deltagelse deltagelse6 = createDeltagelse("");
		Deltagelse deltagelse7 = createDeltagelse("");
		Deltagelse deltagelse8 = createDeltagelse("");
		Deltagelse deltagelse9 = createDeltagelse("");
		Deltagelse deltagelse10 = createDeltagelse("");

		updateSpillerDeltager(deltagelse1, sp1);
		updateSpillerDeltager(deltagelse3, sp1);
		updateSpillerDeltager(deltagelse2, sp4);
		updateSpillerDeltager(deltagelse4, sp4);
		updateSpillerDeltager(deltagelse5, sp2);
		updateSpillerDeltager(deltagelse6, sp2);
		updateSpillerDeltager(deltagelse7, sp3);
		updateSpillerDeltager(deltagelse8, sp3);
		updateSpillerDeltager(deltagelse9, sp5);
		updateSpillerDeltager(deltagelse10, sp5);

		k1.addDeltagelse(deltagelse1);
		k1.addDeltagelse(deltagelse6);
		k1.addDeltagelse(deltagelse3);
		k1.addDeltagelse(deltagelse4);
		k1.addDeltagelse(deltagelse5);

		k2.addDeltagelse(deltagelse2);
		k2.addDeltagelse(deltagelse7);
		k2.addDeltagelse(deltagelse8);
		k2.addDeltagelse(deltagelse9);
		k2.addDeltagelse(deltagelse10);
		for (Deltagelse deltagelse : k1.getDeltagelser()) {
			System.out.println(deltagelse.getSpiller().getNavn());
		}
		k1.spillerHonorar("SpillerHonorar.txt");
	}

}
