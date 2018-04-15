package opgave5;

public class ElArtikel extends Vare {
	private double averagePowerConsumptionPerHour;

	public ElArtikel(double price, String name, String description, double averagePowerConsumptionPerHour) {
		super(price, name, description);
		this.averagePowerConsumptionPerHour = averagePowerConsumptionPerHour;
		// TODO Auto-generated constructor stub
	}

	public double getAveragePowerConsumptionPerHour() {
		return averagePowerConsumptionPerHour;
	}

	public void setAveragePowerConsumptionPerHour(double averagePowerConsumptionPerHour) {
		this.averagePowerConsumptionPerHour = averagePowerConsumptionPerHour;
	}

	@Override
	public double getPricePlusVAT() {
		// TODO Auto-generated method stub
		double minimum = super.getPrice() * 1.30 - super.getPrice();
		if (minimum < 3) {
			return super.getPrice() + 3;
		} else {
			return super.getPrice() * 1.30;
		}
	}
}
