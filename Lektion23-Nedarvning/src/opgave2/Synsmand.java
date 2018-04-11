package opgave2;

public class Synsmand extends Mekaniker {
	int antalSyn;
	int provisionsLøn;

	public Synsmand(String name, String address, int yearOfGraduation, double payPerHour) {
		// TODO Auto-generated constructor stub
		super(name, address, yearOfGraduation, payPerHour);
		this.antalSyn = 0;
		this.provisionsLøn = 250;
	}

	public int getAntalSyn() {
		return antalSyn;
	}

	public void synEnBil() {
		// TODO Auto-generated method stub
		this.antalSyn++;
	}

	@Override
	public double getWeeklyPay() {
		// TODO Auto-generated method stub
		return super.getWeeklyPay() + provisionsLøn * antalSyn;
	}
}
