package opgave5;

public class Radiator {
	private int temperature;

	public Radiator() {
		this.temperature = 0;
	}

	public Radiator(int temperature) {
		this.temperature = temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getTemperature() {
		return temperature;
	}

	public void skruOp(int grader) {
		this.temperature += grader;
	}

	public void skruNed(int grader) {
		this.temperature -= grader;
	}
}
