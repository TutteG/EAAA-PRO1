package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
	private LocalDate dato;
	private boolean betalt;
	private ArrayList<BestillingsLinje> bestillingsLinjer;

	public Bestilling(LocalDate dato) {
		// TODO Auto-generated constructor stub
		betalt = false;
		this.bestillingsLinjer = new ArrayList<BestillingsLinje>();
		this.dato = dato;
	}

	public void addBestillingsLinje(BestillingsLinje bestillingsLinje) {
		bestillingsLinjer.add(bestillingsLinje);
	}

	public LocalDate getDato() {
		return dato;
	}

	public boolean isBetalt() {
		return betalt;
	}

	public ArrayList<BestillingsLinje> getBestillingsLinjer() {
		return bestillingsLinjer;
	}

	public void setBetalt(boolean betalt) {
		this.betalt = betalt;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public double pris() {
		double price = 0;
		for (BestillingsLinje bestillingsLinje : bestillingsLinjer) {
			price += bestillingsLinje.pris();
		}
		return price;
	}

}
