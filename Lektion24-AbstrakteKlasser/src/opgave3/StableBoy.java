package opgave3;

public class StableBoy extends Ansat {
	private String jobDescription;

	public StableBoy(String name, String address, double payPerHour, int yearOfEmployment, int workWeek,
			String jobDescription) {
		// TODO Auto-generated constructor stub
		super(name, address, payPerHour, yearOfEmployment, workWeek);
		this.jobDescription = jobDescription;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

}
