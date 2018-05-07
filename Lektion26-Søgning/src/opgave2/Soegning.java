package opgave2;

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
	public int findFørsteTal(int[] tabel) {
		int i = 0;
		boolean found = false;

		while (!found && i < tabel.length) {
			if (tabel[i] > 9 && tabel[i] < 16) {
				found = true;
				return tabel[i];
			}
			i++;
		}
		return -1;
	}
}
