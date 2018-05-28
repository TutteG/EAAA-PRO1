package application.model;

import java.util.ArrayList;

public class Spiller {
	private String navn;
	private int årgang;

	private ArrayList<Deltagelse> deltagelser;

	public Spiller(String navn, int årgang) {
		// TODO Auto-generated constructor stub
		this.navn = navn;
		this.årgang = årgang;
		this.deltagelser = new ArrayList<Deltagelse>();
	}

	public double kampHonorar() {
		// TODO Auto-generated method stub
		int honorar = 0;
		for (Deltagelse deltagelse : deltagelser) {
			if (!deltagelse.isAfbud()) {
				honorar++;
			}
		}
		return honorar * 10;
	}

	public ArrayList<Deltagelse> getDeltagelser() {
		return deltagelser;
	}

	public void addDeltagelse(Deltagelse deltagelse) {
		// TODO Auto-generated method stub
		deltagelser.add(deltagelse);

	}

	public String getNavn() {
		return navn;
	}

	public int getÅrgang() {
		return årgang;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setÅrgang(int årgang) {
		this.årgang = årgang;
	}
}
