package model;

public class BestillingsLinje {
	private int antal;
	private Vare vare;
	private Bestilling bestilling;

	public BestillingsLinje(int antal, Vare vare, Bestilling bestilling) {
		// TODO Auto-generated constructor stub
		this.antal = antal;
		this.vare = vare;
		this.bestilling = bestilling;
	}

	public int getAntal() {
		return antal;
	}

	public Vare getVare() {
		return vare;
	}

	public Bestilling getBestilling() {
		return bestilling;
	}

	public double pris() {
		return vare.getPris() * antal;
	}
}
