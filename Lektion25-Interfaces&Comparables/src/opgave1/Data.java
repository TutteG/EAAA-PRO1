package opgave1;

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

	public static double avg(Measurable[] objects) {
		double avg = 0;
		for (int i = 0; i < objects.length; i++) {
			avg += objects[i].getMeasure();
		}
		return avg / objects.length;
	}

}
