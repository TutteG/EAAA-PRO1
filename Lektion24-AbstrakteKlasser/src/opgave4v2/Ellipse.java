package opgave4v2;

public class Ellipse extends Figur {
	private double radius1;
	private double radius2;

	public Ellipse(int x, int y, double radius1, double radius2) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.radius1 = radius1;
		this.radius2 = radius2;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius1 * radius2;
	}
}
