package opgave4v2;

public class Kvadrat extends Rektangel {
	private double lenght;

	public Kvadrat(double length, int x, int y) {
		// TODO Auto-generated constructor stub
		super(x, y, length, length);
		this.setLenght(length);
	}

	/**
	 * @return the lenght
	 */
	public double getLenght() {
		return lenght;
	}

	/**
	 * @param lenght the lenght to set
	 */
	public void setLenght(double lenght) {
		this.lenght = lenght;
	}
}
