package opgave4;

public class Cirkel extends Figur {
	private int radius;

	public Cirkel(double x, double y, double size, int radius) {
		super(x, y, size);
		this.radius = radius;
		// TODO Auto-generated constructor stub
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radius, 2);
	}
}
