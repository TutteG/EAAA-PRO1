package opgave2;

import java.time.LocalDate;

/**
 *
 * @author Torben
 *
 */
public class Rental {
	private int number;
	private int days;
	private LocalDate startDate;
	private double price;

	/**
	 *
	 * @param number
	 * @param days
	 * @param price
	 * @param startDate
	 */
	public Rental(int number, int days, double price, LocalDate startDate) {
		this.number = number;
		this.setDays(days);
		this.price = price;
		this.startDate = startDate;
	}

	/**
	 *
	 * @return roomnumber
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @param days
	 *            the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 *
	 * @return startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 *
	 * @return endDate
	 */
	public LocalDate getEndDate() {
		// TODO Auto-generated method stub
		return startDate.plusDays(days);
	}

	/**
	 *
	 * @return price per day
	 */
	public double getPricePrDay() {
		return price;
	}

	/**
	 *
	 * @return total price for staying
	 */
	public double getTotalPrice() {
		return price * days;
	}
}
