package opgave4;

public class Rektangel extends Figur {
	private double s1, s2;

	public Rektangel(double x, double y, double size, double s1, double s2) {
		super(x, y, size);
		this.s1 = s1;
		this.s2 = s2;
	}

	public void setS1(double s1) {
		this.s1 = s1;
	}

	public void setS2(double s2) {
		this.s2 = s2;
	}

	public double getS1() {
		return s1;
	}

	public double getS2() {
		return s2;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return s1 * s2;
	}
}
