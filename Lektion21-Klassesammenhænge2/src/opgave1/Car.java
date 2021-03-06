package opgave1;

import java.util.ArrayList;

class Car {
	private String license;
	private double pricePerDay;
	private int purchaseYear;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();

	public Car(String license, int year) {
		// TODO Auto-generated constructor stub
		this.license = license;
		this.purchaseYear = year;
	}

	public int getDaysRented() {
		int daysRented = Integer.MIN_VALUE;
		for (Rental rental : rentals) {
			if (daysRented < rental.getDays()) {
				daysRented = rental.getDays();
			}
		}
		return daysRented;
	}

	void addRental(Rental rental) {
		rentals.add(rental);
	}

	void removeRental(Rental rental) {
		rentals.remove(rental);
	}

	void setDayPrice(double price) {
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
