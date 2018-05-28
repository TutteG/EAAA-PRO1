package application.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Hold;
import application.model.Tutor;
import application.model.Uddannelse;
import storage.Storage;

public class Service {
	public static Uddannelse createUddannelse(String name) {
		Uddannelse uddannelse = new Uddannelse(name);
		Storage.addUddannelse(uddannelse);
		return uddannelse;
	}

	public static Hold createHold(String betegnelse, String holdleder, Uddannelse uddannelse) {
		Hold hold = uddannelse.createHold(betegnelse, holdleder);
		return hold;
	}

	public static Tutor createTutor(String navn, String email) {
		Tutor tutor = new Tutor(navn, email);
		Storage.addTutor(tutor);
		return tutor;
	}

	public static Arrangement createArrangement(String title, LocalDate date, LocalTime startTid, LocalTime slutTid,
			double price) {
		Arrangement arrangement = new Arrangement(title, date, startTid, slutTid, price);
		Storage.addArrangement(arrangement);
		return arrangement;
	}

	public static void linkArrangementToTutor(Tutor tutor, Arrangement arrangement) {
		for (Arrangement arrangement2 : tutor.getArrangementer()) {
			if (arrangement.getDate().compareTo(arrangement2.getDate()) == 0) {
				throw new RuntimeException("Arrangement Allerede oprettet i dette tidsrum");
			}
		}
		tutor.addArrangement(arrangement);

	}

	public static void removeArrangementFromTutor(Tutor tutor, Arrangement arrangement) {
		tutor.removeArrangement(arrangement);
	}

	public static void linkTutorToHold(Hold hold, Tutor tutor) {
		hold.addTutor(tutor);
		tutor.setHold(hold);
	}

	public static ArrayList<Hold> holdUdenTutorer() {
		ArrayList<Hold> holdudentutorer = new ArrayList<Hold>();
		for (Uddannelse uddannelse : Storage.getUddannelser()) {
			for (Hold hold : uddannelse.getHoldListe()) {
				if (hold.getTutors().isEmpty()) {
					holdudentutorer.add(hold);
				}
			}
		}
		return holdudentutorer;
	}

	public static void tutorOversigtTilFil(String filnavn) {
		try {
			File file = new File(filnavn);
			PrintWriter pw = new PrintWriter(file);
			for (Uddannelse uddannelse : Storage.getUddannelser()) {
				for (String string : uddannelse.tutorOversigt()) {
					pw.write(string + "\n");

				}
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File not found: " + e.getMessage());

		}
	}

	public static void initStorage() {
		Uddannelse uddannelse1 = createUddannelse("DMU");
		Uddannelse uddannelse2 = createUddannelse("FINØ");

		Hold hold1 = createHold("1dmE17S", "Margrethe Dybdahl", uddannelse1);
		Hold hold2 = createHold("1dmE17T", "Kristian Dorland", uddannelse1);
		Hold hold3 = createHold("1dmE17U", "Kell Ørhøj", uddannelse1);
		Hold hold4 = createHold("1fiE17B", "Karen Jensen", uddannelse2);

		Tutor tutor1 = createTutor("Anders Hansen", "aaa@students.eaaa.dk");
		Tutor tutor2 = createTutor("Peter Jensen", "ppp@students.eaaa.dk");
		Tutor tutor3 = createTutor("Niels Madsen", "nnn@students.eaaa.dk");
		Tutor tutor4 = createTutor("Lone Madsen", "lll@students.eaaa.dk");
		Tutor tutor5 = createTutor("Mads Miller", "mmm@students.eaaa.dk");

		Arrangement arrangement1 = createArrangement("Rusfest", LocalDate.of(2017, 8, 31), LocalTime.of(18, 0),
				LocalTime.of(23, 30), 250);
		Arrangement arrangement2 = createArrangement("Fodbold", LocalDate.of(2017, 8, 30), LocalTime.of(14, 0),
				LocalTime.of(17, 30), 100);
		Arrangement arrangement3 = createArrangement("Brætspil", LocalDate.of(2017, 8, 29), LocalTime.of(12, 0),
				LocalTime.of(16, 30), 25);
		Arrangement arrangement4 = createArrangement("Mindeparken", LocalDate.of(2017, 8, 30), LocalTime.of(18, 0),
				LocalTime.of(22, 00), 25);

		linkTutorToHold(hold1, tutor1);
		linkTutorToHold(hold1, tutor4);

		linkTutorToHold(hold3, tutor3);
		linkTutorToHold(hold3, tutor2);

		linkTutorToHold(hold4, tutor5);

		linkArrangementToTutor(tutor1, arrangement1);
		linkArrangementToTutor(tutor2, arrangement1);
		linkArrangementToTutor(tutor5, arrangement1);

		linkArrangementToTutor(tutor2, arrangement2);

		linkArrangementToTutor(tutor4, arrangement3);
		linkArrangementToTutor(tutor2, arrangement3);

		linkArrangementToTutor(tutor5, arrangement4);
		linkArrangementToTutor(tutor1, arrangement4);

	}
}
