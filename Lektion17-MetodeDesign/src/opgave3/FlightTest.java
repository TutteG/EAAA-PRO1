package opgave3;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlightTest {

	public static void main(String[] args) {
		Flight flight = new Flight("AY025", "Seoul");
		flight.createPassenger("Arnold", 31);
		flight.createPassenger("Bruce", 59);
		flight.createPassenger("Dolph", 24);
		flight.createPassenger("Linda", 59);
		flight.createPassenger("Jennifer", 65);

		System.out.println("Destination: 		" + flight.getDestination());
		System.out.println("Flightnumber: 		" + flight.getFlightNumber());
		LocalDateTime departDate = LocalDateTime.of(2018, 03, 18, 23, 30);
		LocalDateTime arrivalDate = LocalDateTime.of(2018, 03, 19, 02, 46);
		flight.setDepartDate(departDate);
		System.out.println("Departure: 		" + flight.getDepartDate());
		flight.setArrivalDate(arrivalDate);
		System.out.println("Arrival: 		" + flight.getArrivalDate());
		System.out.println("Estimated traveltime:	" + flight.flightDurationInHours());
		System.out.println("Midnight flight: " + flight.midnightFlight());
		Passenger passenger = new Passenger("Arnold", 31);
		System.out.println();
		ArrayList<Passenger> cloneList = flight.getPassengers();
		for (Passenger passenger2 : cloneList) {
			System.out.println("Name: " + passenger2.getName() + "\nAge: " + passenger2.getAge());
		}

		flight.removePassenger(passenger);
		System.out.println();

		for (Passenger passenger2 : cloneList) {
			System.out.println("Name: " + passenger2.getName() + "\nAge: " + passenger2.getAge());
		}
		System.out.println("Average age of passengers: " + flight.averageAgeOfPassengers());

	}

}
