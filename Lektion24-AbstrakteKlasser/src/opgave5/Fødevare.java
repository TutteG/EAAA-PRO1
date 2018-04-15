package opgave5;

import java.time.LocalDate;

public class Fødevare extends Vare {
	private LocalDate lastUsageDate;

	public Fødevare(double price, String name, String description, LocalDate lastUsageDate) {
		super(price, name, description);
		this.lastUsageDate = lastUsageDate;
		// TODO Auto-generated constructor stub
	}

	public LocalDate getLastUsageDate() {
		return lastUsageDate;
	}

	public void setLastUsageDate(LocalDate lastUsageDate) {
		this.lastUsageDate = lastUsageDate;
	}

	@Override
	public double getPricePlusVAT() {
		// TODO Auto-generated method stub
		return super.getPrice() * 1.05;
	}
}
