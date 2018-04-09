package opgave5;

public class RadiatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Radiator rad1 = new Radiator();
		Radiator rad2 = new Radiator(20);
		System.out.println("Rad1 er: " + rad1.getTemperature());
		System.out.println("Rad2 er: " + rad2.getTemperature());

		rad1.skruOp(100);
		System.out.println("Rad1 er: " + rad1.getTemperature());
		rad2.skruNed(18);
		System.out.println("Rad2 er: " + rad2.getTemperature());

	}

}
