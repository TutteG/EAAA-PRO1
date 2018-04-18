package opgave1;

public class ChiliApp {
	public static void main(String[] args) {
		Chili chili1 = new Chili("Habanero", 2000000);
		Chili chili2 = new Chili("Jalapenos", 5000);
		Chili chili3 = new Chili("California Reaper", 2300000);

		Measurable[] chiliMeasurables = { chili1, chili2, chili3 };
		System.out.println(Data.avg(chiliMeasurables));
		System.out.println(Data.max(chiliMeasurables));

	}
}
