package application.model;

import java.util.ArrayList;

public class Tutor {
	private String navn;
	private String email;
	private Hold hold;
	private ArrayList<Arrangement> arrangementer;

	public Tutor(String navn, String email) {
		// TODO Auto-generated constructor stub
		this.navn = navn;
		this.email = email;
		this.hold = null;
		this.arrangementer = new ArrayList<Arrangement>();
	}

	public void addArrangement(Arrangement arrangement) {
		arrangementer.add(arrangement);
	}

	public void removeArrangement(Arrangement arrangement) {
		// TODO Auto-generated method stub
		arrangementer.remove(arrangement);
	}

	public double arrangementsPris() {
		double price = 0;
		for (Arrangement arrangement : arrangementer) {
			price += arrangement.getPrice();
		}
		return price;
	}

	public ArrayList<Arrangement> getArrangementer() {
		return arrangementer;
	}

	public String getEmail() {
		return email;
	}

	public String getNavn() {
		return navn;
	}

	public void setHold(Hold hold) {
		this.hold = hold;
	}

	public Hold getHold() {
		return hold;
	}

	public String getUddannelse() {
		// TODO Auto-generated method stub
		return getHold().getUddannelse().getName();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (hold != null) {

			return getNavn() + "\t" + getUddannelse() + "\t" + getHold().getBetegnelse() + "\t" + getEmail() + "\t"
					+ getHold().getHoldleder();
		} else {
			return getNavn() + "\t" + "\t" + getEmail();

		}
	}
}
