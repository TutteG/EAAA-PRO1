package application.service;

import java.time.LocalDate;

import application.model.PraktikKontrakt;
import application.model.PraktikOpgave;
import application.model.PraktikVirksomhed;
import storage.Storage;

public class Service {
	public static PraktikVirksomhed createPraktikVirksomhed(String navn, String feedback, String kontaktperson) {
		PraktikVirksomhed praktikVirksomhed = new PraktikVirksomhed(navn, feedback, kontaktperson);
		Storage.addPraktikVirksomhed(praktikVirksomhed);
		return praktikVirksomhed;
	}

	public static PraktikKontrakt createPraktikKontrakt(String opgavebeskrivelse, int timerPerUge,
			LocalDate periodeStart, LocalDate periodeSlut) {
		PraktikKontrakt praktikKontrakt = new PraktikKontrakt(opgavebeskrivelse, timerPerUge, periodeStart,
				periodeSlut);
		Storage.addPraktikKontrakt(praktikKontrakt);
		return praktikKontrakt;
	}

	public static PraktikOpgave createAnalyseOpgave(String navn, int semester, String analyseModel,
			PraktikVirksomhed praktikVirksomhed) {
		PraktikOpgave praktikOpgave = praktikVirksomhed.createAnalyseOpgave(navn, semester, analyseModel);
		return praktikOpgave;
	}

	public static PraktikOpgave createTekniskOpgave(String navn, int semester, String programmeringSprog,
			PraktikVirksomhed praktikVirksomhed) {
		PraktikOpgave praktikOpgave = praktikVirksomhed.createTekniskOpgave(navn, semester, programmeringSprog);
		return praktikOpgave;
	}

	public static void addVirksomhedToKontrakt(PraktikVirksomhed praktikVirksomhed, PraktikKontrakt praktikKontrakt) {
		praktikVirksomhed.addPraktikKontrakt(praktikKontrakt);
		praktikKontrakt.setPraktikVirksomhed(praktikVirksomhed);
	}

	public static String getEftertragtetSemesterVirksomhed(int semester) {
		String navn = "Ingen virksomheder fundet";
		int antalpladser = 0;
		for (PraktikVirksomhed praktikVirksomhed : Storage.getPraktikVirksomheder()) {
			int pladserPåVirksomhed = 0;
			for (PraktikOpgave praktikOpgave : praktikVirksomhed.getOpgaver()) {
				if (praktikOpgave.getSemester() == semester) {
					pladserPåVirksomhed++;
				}
			}
			if (antalpladser < pladserPåVirksomhed) {
				antalpladser = pladserPåVirksomhed;
				navn = praktikVirksomhed.getNavn();
			}
		}
		return navn;
	}

	public static void initStorage() {
		PraktikVirksomhed praktikVirksomhed1 = createPraktikVirksomhed("Vestas", "Godt miljø", "Peter Justesen");
		PraktikVirksomhed praktikVirksomhed2 = createPraktikVirksomhed("Nilfisk", "Udfordrende", "Peter Justesen");
		PraktikVirksomhed praktikVirksomhed3 = createPraktikVirksomhed("POWER", "Energisk", "Margrethe Dybdahl");

		PraktikKontrakt praktikKontrakt1 = createPraktikKontrakt("Tester", 37, LocalDate.of(2018, 7, 1),
				LocalDate.of(2018, 9, 16));
		PraktikKontrakt praktikKontrakt2 = createPraktikKontrakt("Udvikler", 27, LocalDate.of(2018, 3, 14),
				LocalDate.of(2018, 5, 6));
		PraktikKontrakt praktikKontrakt3 = createPraktikKontrakt("Programmør", 15, LocalDate.of(2018, 2, 14),
				LocalDate.of(2018, 6, 6));
		PraktikKontrakt praktikKontrakt4 = createPraktikKontrakt("Analytiker", 12, LocalDate.of(2018, 2, 14),
				LocalDate.of(2018, 6, 6));

		addVirksomhedToKontrakt(praktikVirksomhed1, praktikKontrakt1);
		addVirksomhedToKontrakt(praktikVirksomhed1, praktikKontrakt3);
		addVirksomhedToKontrakt(praktikVirksomhed1, praktikKontrakt4);
		addVirksomhedToKontrakt(praktikVirksomhed2, praktikKontrakt2);

		PraktikOpgave praktikOpgave1 = createTekniskOpgave("Flowoptimering", 5, "Java", praktikVirksomhed1);
		PraktikOpgave praktikOpgave2 = createTekniskOpgave("Test i felten", 5, "C#", praktikVirksomhed1);
		PraktikOpgave praktikOpgave3 = createAnalyseOpgave("Risikoanalyse", 3, "MUST", praktikVirksomhed2);
		PraktikOpgave praktikOpgave4 = createTekniskOpgave("Simulering", 5, "Python", praktikVirksomhed3);

		// Test metoder
		praktikVirksomhed1.skrivTilFilKontrakter();

		System.out.println(praktikVirksomhed1.getKontrakter());
		praktikVirksomhed1.sorterKontrakter();
		System.out.println(praktikVirksomhed1.getKontrakter());

		System.out.println(praktikVirksomhed1.getTotalAntalUgentligeTimerPeriode(LocalDate.of(2018, 7, 1),
				LocalDate.of(2018, 9, 16)));

		System.out.println(getEftertragtetSemesterVirksomhed(5));
		System.out.println(getEftertragtetSemesterVirksomhed(3));
	}

}
