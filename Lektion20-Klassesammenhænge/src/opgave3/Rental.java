package opgave3;

import java.util.ArrayList;

public class Rental {
	private int number; // bliver ikke brugt...
	private int days;
	private String date; // bliver ikke brugt...
	private ArrayList<Car> cars = new ArrayList<Car>();

	public Rental(int number, String date, int days) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.date = date;
		this.days = days;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		double price = 0;
		for (Car car : cars) {
			price += car.getDayPrice();
		}
		price *= days;
		return price;
	}

	public void addCar(Car car) {
		// TODO Auto-generated method stub
		cars.add(car);
	}

	public void removeCar(Car car) {
		// TODO Auto-generated method stub
		cars.remove(car);
	}

	public ArrayList<Car> getCars() {
		return new ArrayList<>(cars);
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getDays() {
		return days;
	}
}
