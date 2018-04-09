package opgave3;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * A flight with an airline between airports.
 */
public class Flight {
	private String flightNumber;
	private String destination;
	private LocalDateTime departDate;
	private LocalDateTime arrivalDate;
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

	/**
	 * Constructor that creates a flight for an airline.
	 *
	 * @param flightNumber
	 *            the number of the flight
	 * @param destination
	 *            the destination of the flight
	 */
	public Flight(String flightNumber, String destination) {
		this.flightNumber = flightNumber;
		this.destination = destination;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination or null if not set
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Gets the flight number.
	 *
	 * @return the flight number
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * Gets the LocalDateTime when the flight will depart
	 *
	 * @return departure date, can be null
	 */
	public LocalDateTime getDepartDate() {
		return departDate;
	}

	/**
	 * Sets the LocalDateTime when the flight will depart. Precondition: cannot be
	 * later than the land time.
	 *
	 * @param departDate
	 */
	public void setDepartDate(LocalDateTime departDate) {
		this.departDate = departDate;
	}

	/**
	 * Gets the LocalDateTime for when the flight will land.
	 *
	 * @return arrival date, can be null
	 */
	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * Sets the LocalDateTime for when the flight will land. Precondition: cannot be
	 * before the depart time.
	 *
	 * @param landDate
	 *            arrival date
	 */
	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * Creates a passenger with name and age Precondition: name is not empty or null
	 * and age >= 0.
	 *
	 * @param name
	 *            name of the passenger
	 * @param age
	 *            the age of the passenger
	 * @return the newly created passenger object
	 */
	public Passenger createPassenger(String name, int age) {
		// TODO: implement!
		Passenger passenger = new Passenger(name, age);
		if (passenger.getName().length() > 0 && passenger.getAge() >= 0) {
			passengers.add(passenger);
			return passenger;
		} else {
			return null;
		}

	}

	/**
	 * Removes the passenger. Precondition: the passenger must exists on this
	 * flight.
	 *
	 * @param passenger
	 */
	public void removePassenger(Passenger passenger) {
		if (passengers.isEmpty()) {
			// do nothing
		} else {
			ArrayList<Passenger> cloneList = (ArrayList<Passenger>) passengers.clone();
			/*
			 * ArrayList<Passenger> cloneList = new ArrayList<Passenger>(); for (Passenger
			 * passenger2 : passengers) { cloneList.add(passenger2); }
			 */
			passengers.removeAll(passengers);
			for (Passenger passenger2 : cloneList) {
				if (!passenger.getName().equals(passenger2.getName()) && passenger.getAge() != passenger2.getAge()) {
					passengers.add(passenger2);
				}
			}
		}
	}

	/**
	 * Gets the current list of passengers on this flight
	 *
	 * @return list of passengers
	 */
	public ArrayList<Passenger> getPassengers() {

		return passengers;
	}

	/**
	 * The duration of the flight measured in hours Precondition: the depart and
	 * arrival dates must have been set
	 *
	 * @return how many hours
	 */
	public LocalTime flightDurationInHours() {
		long seconds = ChronoUnit.SECONDS.between(departDate, arrivalDate);
		LocalTime time = LocalTime.ofSecondOfDay(seconds);
		return time;
	}

	/**
	 * Returns true if the flight happens during midnight of the day of departure.
	 * Precondition: depart and arrival dates must have been set
	 *
	 * @return true if midnight is included in the flight period, otherwise false.
	 */
	public boolean midnightFlight() {
		// TODO: implement!
		LocalTime departTime = departDate.toLocalTime();
		LocalTime arrivalTime = arrivalDate.toLocalTime();
		if (departTime.isBefore(LocalTime.MIDNIGHT.minusSeconds(1)) && arrivalTime.isAfter(LocalTime.MIDNIGHT)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the average age of all the passengers Precondition: there must exists
	 * passengers on this flight
	 *
	 * @return average age of passengers
	 */
	public double averageAgeOfPassengers() {
		// TODO: implement!

		if (passengers.isEmpty()) {
			return -1;

		} else {
			double avgAge = 0;
			for (Passenger passenger : passengers) {
				avgAge += passenger.getAge();
			}
			return avgAge / passengers.size();
		}
	}

}
