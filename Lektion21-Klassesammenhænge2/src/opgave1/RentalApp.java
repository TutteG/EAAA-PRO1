package opgave1;

public class RentalApp {
	public static void main(String[] args) {

		Rental rental1 = new Rental(3, "10-03-2018", 10);
		Rental rental2 = new Rental(2, "20-03-2018", 20);

		Car car1 = rental1.createCar("asdf", 1234);
		Car car2 = rental1.createCar("asdf", 1234);
		Car car3 = rental1.createCar("asdf", 1234);
		Car car4 = rental1.createCar("asdf", 1234);
		Car car5 = rental2.createCar("asdf", 1234);
		Car car6 = rental2.createCar("asdf", 1234);
		car1.setDayPrice(1000);
		car2.setDayPrice(2000);
		car3.setDayPrice(3000);
		car4.setDayPrice(4000);
		car5.setDayPrice(5000);
		car6.setDayPrice(5000);

		System.out.println("Total pris for udlejning: " + rental1.getPrice());
		System.out.println("Total pris for udlejning: " + rental2.getPrice());

		System.out.println(car1.getDaysRented());
		rental2.addCar(car1);

		System.out.println(car1.getDaysRented());

	}
}
