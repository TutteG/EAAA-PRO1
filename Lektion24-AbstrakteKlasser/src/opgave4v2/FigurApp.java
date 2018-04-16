package opgave4v2;

public class FigurApp {
	public static void main(String[] args) {
		Figur kvadrat = new Kvadrat(10, 1, 1);
		System.out.println(kvadrat.getArea());
		Figur rektangel = new Rektangel(1, 1, 10, 5);

		System.out.println(rektangel.getArea());

		Figur ellipse = new Ellipse(1, 1, 15, 15);
		System.out.println(ellipse.getArea());

		Figur cirkel = new Cirkel(1, 1, 15);
		System.out.println(cirkel.getArea());
	}
}
