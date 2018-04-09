package opgave3;

public class RentalApp {
	public static void main(String[] args) {
		Car car1 = new Car("asdf", 1996);
		Car car2 = new Car("ghjk", 1997);
		Car car3 = new Car("læø", 1998);
		Car car4 = new Car("zxcv", 1999);
		Car car5 = new Car("bnm", 2000);

		car1.setDayPrice(1000);
		car2.setDayPrice(2000);
		car3.setDayPrice(3000);
		car4.setDayPrice(4000);
		car5.setDayPrice(5000);

		Rental rental1 = new Rental(3, "10-03-2018", 10);
		Rental rental2 = new Rental(2, "20-03-2018", 10);

		rental1.addCar(car1);
		rental1.addCar(car2);
		rental1.addCar(car3);

		rental2.addCar(car4);
		rental2.addCar(car5);

		System.out.println("Total pris for udlejning: " + rental1.getPrice());
		System.out.println("Total pris for udlejning: " + rental2.getPrice());
	}
}
