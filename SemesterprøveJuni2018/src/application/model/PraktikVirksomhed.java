package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class PraktikVirksomhed {
	private String navn;
	private String feedback;
	private String kontaktperson;
	private ArrayList<PraktikKontrakt> kontrakter;
	private ArrayList<PraktikOpgave> opgaver;

	public PraktikVirksomhed(String navn, String feedback, String kontaktperson) {
		this.navn = navn;
		this.feedback = feedback;
		this.kontaktperson = kontaktperson;
		this.kontrakter = new ArrayList<PraktikKontrakt>();
		this.opgaver = new ArrayList<PraktikOpgave>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getKontaktperson() {
		return kontaktperson;
	}

	public void setKontaktperson(String kontaktperson) {
		this.kontaktperson = kontaktperson;
	}

	public ArrayList<PraktikKontrakt> getKontrakter() {
		return kontrakter;
	}

	public ArrayList<PraktikOpgave> getOpgaver() {
		return opgaver;
	}

	public PraktikOpgave createAnalyseOpgave(String navn, int semester, String analyseModel) {
		PraktikOpgave analyseOpgave = new AnalyseOpgave(navn, semester, analyseModel);
		addPraktikOpgave(analyseOpgave);
		return analyseOpgave;
	}

	public PraktikOpgave createTekniskOpgave(String navn, int semester, String programmeringsSprog) {
		PraktikOpgave tekniskOpgave = new TekniskOpgave(navn, semester, programmeringsSprog);
		addPraktikOpgave(tekniskOpgave);
		return tekniskOpgave;
	}

	public void addPraktikOpgave(PraktikOpgave praktikOpgave) {
		opgaver.add(praktikOpgave);
	}

	public void addPraktikKontrakt(PraktikKontrakt kontrakt) {
		kontrakter.add(kontrakt);
	}

	// arbejd videre med den her senere
	public ArrayList<PraktikKontrakt> sorterKontrakter() {
		for (int i = 0; i < kontrakter.size() - 1; i++) {
			for (int j = i + 1; j < kontrakter.size(); j++) {
				if (kontrakter.get(j).compareTo(kontrakter.get(i)) < 0) {
					Collections.swap(kontrakter, i, j);
				}
			}
		}
		return kontrakter;
	}

	public void skrivTilFilKontrakter() {
		try {
			System.out.println(kontrakter);
			File file = new File("kontrakter.txt");
			PrintWriter printWriter = new PrintWriter(file);
			for (PraktikKontrakt praktikKontrakt : kontrakter) {
				printWriter.write(praktikKontrakt.toString() + "\n");
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// Ikke færdig
	public int getTotalAntalUgentligeTimerPeriode(LocalDate start, LocalDate slut) {
		int timer = 0;
		for (PraktikKontrakt praktikKontrakt : kontrakter) {
			if (praktikKontrakt.getPeriodeStart().isBefore(slut) && praktikKontrakt.getPeriodeSlut().isAfter(start)) {
				timer += praktikKontrakt.getTimerPerUge();
			}
		}
		return timer;
	}

	public int antalAfPraktikanterPåSemester(int semester) {
		int antal = 0;
		for (PraktikOpgave praktikOpgave : opgaver) {
			if (praktikOpgave.getSemester() == semester) {
				antal++;
			}
		}
		return antal;
	}

	@Override
	public String toString() {
		return navn + " " + feedback + " " + kontaktperson;
	}
}
