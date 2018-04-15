package opgave5;

public class Spiritus extends Vare {
	private double percentAlcohol;

	public Spiritus(double price, String name, String description, double percentAlcohol) {
		super(price, name, description);
		// TODO Auto-generated constructor stub
		this.percentAlcohol = percentAlcohol;
	}

	public double getPercentAlcohol() {
		return percentAlcohol;
	}

	public void setPercentAlcohol(double percentAlcohol) {
		this.percentAlcohol = percentAlcohol;
	}

	@Override
	public double getPricePlusVAT() {
		// TODO Auto-generated method stub
		if (getPrice() <= 90) {
			return super.getPrice() * 1.8;
		} else {
			return super.getPrice() * 2.2;
		}
	}
}
