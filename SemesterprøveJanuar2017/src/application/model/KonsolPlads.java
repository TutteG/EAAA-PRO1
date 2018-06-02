package application.model;

public class KonsolPlads extends Plads {
	private String type;

	public KonsolPlads(int nr, Område område, String type) {
		super(nr, område);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	@Override
	public double pris(int timer) {
		// TODO Auto-generated method stub
		if (getOmråde().equals(Område.BØRNE)) {
			return super.pris(timer) * 1.1;
		} else {
			return super.pris(timer) * 1.25;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "KonsolPlads[" + getNr() + "," + getOmråde().toString() + "], " + type;
	}
}
