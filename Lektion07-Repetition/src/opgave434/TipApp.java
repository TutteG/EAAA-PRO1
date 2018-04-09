package opgave434;

public class TipApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tip tip = new Tip(1, 1000);
		System.out.println(tip.calculateTip());

		Tip tip2 = new Tip(2, 1000);
		System.out.println(tip2.calculateTip());

		Tip tip3 = new Tip(3, 1000);
		System.out.println(tip3.calculateTip());

		Tip tip4 = new Tip(0, 1000);
		System.out.println(tip4.calculateTip());

	}

}
