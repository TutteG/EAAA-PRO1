package opgave3;

public class Synsmand extends Mekaniker {
	int antalSyn;
	int provisionsLøn;

	public Synsmand(String name, String address, int yearOfGraduation, double payPerHour, int workWeek) {
		// TODO Auto-generated constructor stub
		super(name, address, yearOfGraduation, payPerHour, workWeek);
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
