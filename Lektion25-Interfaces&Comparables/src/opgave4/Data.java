package opgave4;

public class Data {
	public Data() {
		// TODO Auto-generated constructor stub
	}

	public static double max(Measurable[] objects) {
		double max = Double.MIN_VALUE;
		for (int i = 0; i < objects.length; i++) {
			if (max < objects[i].getMeasure()) {
				max = objects[i].getMeasure();
			}
		}
		return max;
	}

	public static double avg(Measurable[] objects, Filter object) {
		double avg = 0;
		int numberOfMeasurement = 0;
		for (int i = 0; i < objects.length; i++) {
			if (object.accept(objects[i]) == true) {
				avg += objects[i].getMeasure();
				numberOfMeasurement++;
			}
		}
		return avg / numberOfMeasurement;
	}

}
