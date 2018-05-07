package opgave1;

public class Soegning {

	public boolean findUlige(int[] tabel) {
		// TODO Opgave1
		int i = 0;
		boolean found = false;
		while (!found && i < tabel.length) {
			if (tabel[i] % 2 != 0) {
				found = true;
			} else {
				i++;
			}
		}
		return found;
	}

	// her skriver du metoder til opgaverne 2,3,5,6 og 7
}
