package application.model;

public class Deltagelse {
	private boolean afbud;
	private String begrundelse;
	private Spiller spiller;

	public Deltagelse(String begrundelse) {
		// TODO Auto-generated constructor stub
		this.afbud = false;
		this.begrundelse = begrundelse;
		this.spiller = null;
	}

	public Spiller getSpiller() {
		return spiller;
	}

	public void setSpiller(Spiller spiller) {
		this.spiller = spiller;
	}

	public String getBegrundelse() {
		return begrundelse;
	}

	public boolean isAfbud() {
		return afbud;
	}

	public void setAfbud(boolean afbud) {
		this.afbud = afbud;
	}

	public void setBegrundelse(String begrundelse) {
		this.begrundelse = begrundelse;
	}
}
