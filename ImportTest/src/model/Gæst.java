package model;

import java.util.ArrayList;

public class Gæst {
	private String navn;
	private int værelsesNummer;
	private ArrayList<Bestilling> bestillinger;

	public Gæst(String navn, int værelsesNummer) {
		// TODO Auto-generated constructor stub
		this.navn = navn;
		this.værelsesNummer = værelsesNummer;
		this.bestillinger = new ArrayList<Bestilling>();
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void addBestilling(Bestilling bestilling) {
		// TODO Auto-generated method stub
		bestillinger.add(bestilling);
	}

	public String getNavn() {
		return navn;
	}

	public int getVærelsesNummer() {
		return værelsesNummer;
	}

	public void setVærelsesNummer(int værelsesNummer) {
		this.værelsesNummer = værelsesNummer;
	}

	public ArrayList<Bestilling> getBestillinger() {
		return bestillinger;
	}

	public double pris() {
		double price = 0;
		for (Bestilling bestilling : bestillinger) {
			price += bestilling.pris();
		}
		return price;
	}

	public ArrayList<String> ikkeBetalteBestillinger() {
		// TODO Auto-generated method stub
		int i = 0;
		ArrayList<String> ikkeBetalte = new ArrayList<String>();
		for (Bestilling bestilling : bestillinger) {
			if (!bestilling.isBetalt()) {
				String ikkeBetalt = "" + bestilling.getDato();
				ikkeBetalte.add(ikkeBetalt);
				for (BestillingsLinje bestillingsLinje : bestillinger.get(i).getBestillingsLinjer()) {
					// man skulle måske have lavet en toString metode.
					ikkeBetalt = bestillingsLinje.getAntal() + " " + bestillingsLinje.getVare().getNavn() + " "
							+ bestillingsLinje.getVare().getMærke() + " " + bestillingsLinje.getVare().getPris();
					ikkeBetalte.add(ikkeBetalt);
				}
			}
			i++;
		}
		return ikkeBetalte;
	}

	public boolean harBestilt(Vare vare) {
		boolean found = false;
		int i1 = 0;
		int i2 = 0;
		while (!found && i1 < bestillinger.size()) {
			while (!found && i2 < bestillinger.get(i1).getBestillingsLinjer().size()) {
				if (vare.equals(bestillinger.get(i1).getBestillingsLinjer().get(i2).getVare())) {
					found = true;
				} else {
					i2++;
				}
			}
			i1++;
		}
		return found;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return navn + " " + værelsesNummer;
	}
}
