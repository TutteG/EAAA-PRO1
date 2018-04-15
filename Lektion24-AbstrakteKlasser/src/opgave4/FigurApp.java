package opgave4;

public class FigurApp {
	public static void main(String[] args) {
		Figur kvadrat = new Kvadrat(10, 10, 10);

		System.out.println(kvadrat.getSize());
		kvadrat.setSize(15);
		System.out.println(kvadrat.getArea());

		Figur rektangen = new Rektangel(10, 10, 10, 10, 25);
		System.out.println(rektangen.getArea());

		Figur cirkel = new Cirkel(10, 10, 10, 5);
		System.out.println(cirkel.getArea());

		Figur ellipse = new Ellipse(10, 10, 10, 10, 15);
		System.out.println(ellipse.getArea());
	}
}
