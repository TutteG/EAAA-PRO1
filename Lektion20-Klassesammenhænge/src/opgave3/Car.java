package opgave3;

public class Car {
	private String license;
	private double pricePerDay;
	private int purchaseYear;

	public Car(String license, int year) {
		// TODO Auto-generated constructor stub
		this.license = license;
		this.purchaseYear = year;
	}

	public void setDayPrice(double price) {
		// TODO Auto-generated method stub
		this.pricePerDay = price;
	}

	public double getDayPrice() {
		// TODO Auto-generated method stub
		return pricePerDay;
	}

	public String getLicense() {
		return license;
	}

	public int getPurchaseYear() {
		return purchaseYear;
	}
}
