package application.model;

import java.time.LocalDate;

public class PraktikKontrakt implements Comparable<PraktikKontrakt> {
	private String opgavebeskrivelse;
	private int timerPerUge;
	private LocalDate periodeStart;
	private LocalDate periodeSlut;
	private PraktikVirksomhed praktikVirksomhed;

	public PraktikKontrakt(String opgavebeskrivelse, int timerPerUge, LocalDate periodeStart, LocalDate periodeSlut) {
		this.opgavebeskrivelse = opgavebeskrivelse;
		this.timerPerUge = timerPerUge;
		this.periodeStart = periodeStart;
		this.periodeSlut = periodeSlut;
		this.praktikVirksomhed = null;
	}

	public String getOpgavebeskrivelse() {
		return opgavebeskrivelse;
	}

	public int getTimerPerUge() {
		return timerPerUge;
	}

	public LocalDate getPeriodeSlut() {
		return periodeSlut;
	}

	public LocalDate getPeriodeStart() {
		return periodeStart;
	}

	public PraktikVirksomhed getPraktikVirksomhed() {
		return praktikVirksomhed;
	}

	public void setPraktikVirksomhed(PraktikVirksomhed praktikVirksomhed) {
		this.praktikVirksomhed = praktikVirksomhed;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return opgavebeskrivelse + " " + timerPerUge + " " + periodeStart.toString() + " " + periodeSlut.toString();
	}

	@Override
	public int compareTo(PraktikKontrakt o) {
		// TODO Auto-generated method stub
		if (periodeStart.compareTo(o.periodeStart) == 0) {
			return opgavebeskrivelse.compareTo(o.getOpgavebeskrivelse());
		}
		return periodeStart.compareTo(o.getPeriodeStart());
	}
}
