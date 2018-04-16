package opgave4v2;

public class Cirkel extends Ellipse {
	private double radius;

	public Cirkel(int x, int y, double radius) {
		super(x, y, radius, radius);
		// TODO Auto-generated constructor stub
		this.setRadius(radius);
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

}
