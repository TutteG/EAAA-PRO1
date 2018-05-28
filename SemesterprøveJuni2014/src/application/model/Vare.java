package application.model;

import java.util.ArrayList;

public class Vare {

	private String navn;
	private String mærke;
	private double mængde;
	private double pris;
	private ArrayList<BestillingsLinje> bestillingsLinjer;

	public Vare(String navn, String mærke, double mængde, double pris) {
		// TODO Auto-generated constructor stub
		this.navn = navn;
		this.mærke = mærke;
		this.mængde = mængde;
		this.pris = pris;
		bestillingsLinjer = new ArrayList<BestillingsLinje>();
	}

	public double getMængde() {
		return mængde;
	}

	public String getMærke() {
		return mærke;
	}

	public String getNavn() {
		return navn;
	}

	public double getPris() {
		return pris;
	}

	public ArrayList<BestillingsLinje> getBestillingsLinjer() {
		return bestillingsLinjer;
	}
}
