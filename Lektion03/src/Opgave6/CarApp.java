package Opgave6;

public class CarApp {

	public static void main(String[] args) {
		Car myCar = new Car("VW UP", "White");
		System.out.println(myCar.getBrand());
		myCar.setRegistrationNumber("AB 11 123");
		System.out.println(myCar.getRegistrationNumber());

		System.out.println("******************************");
		Car myOtherCar = new Car("C1 Cactus", "Lime-Green");
		System.out.print(myOtherCar.getBrand() + " ");

		System.out.println(myOtherCar.getColor());
		myOtherCar.setRegistrationNumber("ASDKMNOHW");
		myOtherCar.setKm(10000000);
		System.out.print(myOtherCar.getRegistrationNumber() + " ");
		System.out.println("Har kørt: " + myOtherCar.getKm());
		System.out.println("******************************");
	}

}
