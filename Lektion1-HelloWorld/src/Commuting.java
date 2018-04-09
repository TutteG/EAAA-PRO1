import java.util.Scanner;

public class Commuting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int Distance = 15;
		double milesGallon = 4;
		double carMaintenance = 0.05;
		int ticketPrice = 150;
		double commuteprice = 0;

		System.out.println("Please type in traveldistance: ");
		Distance = sc.nextInt();
		commuteprice = Distance * (milesGallon + carMaintenance);
		sc.close();
		if (commuteprice < ticketPrice) {
			System.out.println("Take the car, it will only cost you: " + commuteprice);
		} else if (ticketPrice == commuteprice) {
			System.out.println("take whichever you want..");
		}

		else {
			System.out.println("Take the train, it will cost you: " + ticketPrice);
		}

	}

}
