package opgave4v2;

public abstract class Figur {
	private int x;
	private int y;

	public Figur(int x, int y) {
		// TODO Auto-generated constructor stub
		this.setX(x);
		this.setY(y);
	}

	public abstract double getArea();

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}
