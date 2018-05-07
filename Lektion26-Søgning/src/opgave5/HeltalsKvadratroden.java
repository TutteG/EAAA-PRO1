package opgave5;

public class HeltalsKvadratroden {
	public static int LiniærStørsteHeltal(int n) {
		int i = 0;
		int r = 0;

		while (i < n) {
			if (r * r <= n && n > (r + 1) * (r + 1)) {
				r = i;
			}
			i++;
		}
		return r;
	}

	public static int BinærStørteHeltal(int n) {
		int left = 0;
		int right = n;
		int r = -1;
		boolean found = false;
		while (!found && left <= right) {
			r = (left + right) / 2;
			if (r * r <= n && (r + 1) * (r + 1) > n) {
				found = true;
			} else if (r * r > n) {
				right = r - 1;
			} else {
				left = r + 1;
			}
		}
		if (found) {
			return r;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		System.out.println(HeltalsKvadratroden.LiniærStørsteHeltal(111));
		System.out.println(HeltalsKvadratroden.BinærStørteHeltal(111));
	}
}
