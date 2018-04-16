package opgave4v2;

public class Rektangel extends Figur {
	private double length;
	private double width;

	public Rektangel(int x, int y, double length, double width) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.length = length;
		this.width = width;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.length * this.width;
	}
}
