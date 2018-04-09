package opgave4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Svømmer {
	private String navn;
	private String klub;
	private LocalDate fødselsdag;
	private ArrayList<Double> tider;

	/**
	 * Initialiserer en ny svømmer med navn, fødselsdag, klub og tider.
	 *
	 * @param navn
	 * @param klub
	 * @param fødselsdag
	 * @param tider
	 */
	public Svømmer(String navn, String klub, LocalDate fødselsdag, ArrayList<Double> tider) {
		this.navn = navn;
		this.klub = klub;
		this.fødselsdag = fødselsdag;
		this.tider = tider;
	}

	/**
	 * Returnerer svømmerens navn.
	 *
	 * @return navn
	 */
	public String getNavn() {
		return navn;
	}

	/**
	 * Returnerer svømmerens årgang.
	 *
	 * @return yearOfBirth
	 */
	public int getÅrgang() {
		return fødselsdag.getYear();
	}

	/**
	 * Returnerer svømmerens klub.
	 *
	 * @return
	 */
	public String getKlub() {
		return klub;
	}

	/**
	 * Registrerer svømmerens klub
	 *
	 * @param klub
	 */
	public void setKlub(String klub) {
		this.klub = klub;
	}

	/**
	 * Returnerer den hurtigste tid svømmeren har opnået
	 *
	 * @return tid
	 */
	public double bedsteTid() {
		if (!tider.isEmpty()) {
			double tid = Integer.MAX_VALUE;
			for (Double double1 : tider) {
				if (tid > double1) {
					tid = double1;
				}
			}
			return tid;
		}
		return -1; // TODO
	}

	/**
	 * Returnerer gennemsnittet af de tider svømmeren har opnået
	 *
	 * @return tid
	 */
	public double gennemsnitAfTid() {
		if (!tider.isEmpty()) {
			double tid = 0;
			for (Double double1 : tider) {

				tid += double1;
			}
			return tid / tider.size();
		}
		return -1; // TODO }
	}

	/**
	 * Returnerer gennemsnittet af de tider svømmeren har opnået idet den langsomste
	 * tid ikke er medregnet
	 *
	 * @return tid
	 */
	public double snitUdenDårligste() {
		if (!tider.isEmpty()) {

			ArrayList<Double> tiderKlon = (ArrayList<Double>) tider.clone();
			Collections.sort(tiderKlon);
			double tid = 0;
			for (int i = 0; i < tiderKlon.size() - 1; i++) {
				tid += tiderKlon.get(i);
			}
			return tid / (tiderKlon.size() - 1);
		}
		return -1; // TODO
	}
}
