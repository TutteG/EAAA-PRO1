package opgave4;

public abstract class Figur {
	private double x;
	private double y;
	private double size;

	public Figur(double x, double y, double size) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getSize() {
		return size;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getArea() {
		return -1;
	}
}
