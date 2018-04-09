package opgave6;

public class Date {
	private int month;
	private int day;

	public Date(int month, int day) {
		this.day = day;
		this.month = month;
	}

	public String getSeason() {
		if (month >= 1 && month <= 3) {
			if (month == 3 && day >= 21) {
				return month + "is in spring";
			}

			else {
				return month + " is in winter";
			}
		} else if (month >= 4 && month <= 6) {
			if (month == 3 && day >= 21) {
				return month + " is in summer";
			}

			else {
				return month + " is in spring";
			}

		} else if (month >= 7 && month <= 9) {
			if (month == 3 && day >= 21) {
				return month + " is in fall";
			}

			else {
				return month + " is in summer";
			}

		} else if (month >= 10 && month <= 12) {

			if (month == 3 && day >= 21) {
				return month + " is in winter";
			}

			else {
				return month + " is in fall";
			}

		} else {
			return "Month " + month + " is out of scope";
		}

	}
}
