package opgave4;

public class Kvadrat extends Figur {
	private double s;

	public Kvadrat(double x, double y, double size) {
		// TODO Auto-generated constructor stub
		super(x, y, size);
		this.s = size / 4;
	}

	public double getS() {
		return s;
	}

	private void setS(double s) {
		this.s = s / 4;
	}

	@Override
	/**
	 * Overrides super.setSize() and makes it call setS
	 */
	public void setSize(double size) {
		// TODO Auto-generated method stub
		super.setSize(size);
		setS(size);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.pow(s, 2);
	}
}
