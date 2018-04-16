package opgave4;

public class Chili implements Measurable {
	private String name;
	private double styrke;

	public Chili(String name, double styrke) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.styrke = styrke;
	}

	public String getName() {
		return name;
	}

	public double getStyrke() {
		return styrke;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStyrke(double styrke) {
		this.styrke = styrke;
	}

	@Override
	public double getMeasure() {
		// TODO Auto-generated method stub
		if (styrke < 1) {
			return 1;
		} else if (styrke > 2500000) {
			return 2500000;
		} else {
			return styrke;
		}

	}

}
