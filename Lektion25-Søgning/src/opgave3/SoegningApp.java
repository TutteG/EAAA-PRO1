package opgave3;

public class SoegningApp {

	public static void main(String[] args) {
		Soegning s = new Soegning();

		// Kode til afprøvning af opgave 1
		int[] talArray = { 2, 4, 8, 2, 4, 8, 8 };

		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));

		// Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7

		talArray[4] = 10;
		System.out.println("Det første tal mellem 10 og 15? " + s.findFørsteTal(talArray));
		System.out.println("Find to venner i samme array ? " + s.findToDubletVenner(talArray));

		talArray[6] = 5;
		System.out.println("Find to venner i samme array ? " + s.findToDubletVenner(talArray));

	}

}
