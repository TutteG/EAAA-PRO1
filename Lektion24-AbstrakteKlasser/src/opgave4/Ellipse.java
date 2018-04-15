package opgave4;

public class Ellipse extends Figur {
	private double rad1;
	private double rad2;

	public Ellipse(double x, double y, double size, double rad1, double rad2) {
		super(x, y, size);
		this.rad1 = rad1;
		this.rad2 = rad2;
	}

	public double getRad1() {
		return rad1;
	}

	public double getRad2() {
		return rad2;
	}

	public void setRad1(double rad1) {
		this.rad1 = rad1;
	}

	public void setRad2(double rad2) {
		this.rad2 = rad2;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * rad1 * rad2;
	}
}
