package opgave1;

import java.util.ArrayList;

public class testApp {
	public static void main(String[] args) {
		Hund hund = new Hund("Niels", true, 50, Race.TERRIER);
		Hund hund1 = new Hund("Nuller", true, 50, Race.PUDDEL);
		Hund hund2 = new Hund("Niller", true, 50, Race.BOKSER);
		Hund hund3 = new Hund("Terry", true, 50, Race.TERRIER);
		Hund hund4 = new Hund("Nulle", true, 50, Race.BOKSER);
		Hund hund5 = new Hund("Mille", true, 50, Race.PUDDEL);
		Hund hund6 = new Hund("Milan", true, 50, Race.TERRIER);
		Hund hund7 = new Hund("Mulle", true, 50, Race.BOKSER);
		Hund hund8 = new Hund("Misse", true, 50, Race.TERRIER);
		Hund hund9 = new Hund("Maestro", true, 50, Race.PUDDEL);
		Hund hund10 = new Hund("Niels' bedste ven", true, 50, Race.TERRIER);
		Hund hund11 = new Hund("Niels' værste ven", true, 50, Race.TERRIER);
		ArrayList<Hund> hunde = new ArrayList<Hund>();
		hunde.add(hund);
		hunde.add(hund1);
		hunde.add(hund2);
		hunde.add(hund3);
		hunde.add(hund4);
		hunde.add(hund5);
		hunde.add(hund6);
		hunde.add(hund7);
		hunde.add(hund8);
		hunde.add(hund9);
		hunde.add(hund10);
		hunde.add(hund11);
		// hunde.add(hund12);
		System.out.println(samletPris(hunde, Race.BOKSER));
		System.out.println(samletPris(hunde, Race.PUDDEL));
		System.out.println(samletPris(hunde, Race.TERRIER));
	}

	public static int samletPris(ArrayList<Hund> hunde, Race race) {
		int samletpris = 0;
		for (Hund hund : hunde) {
			if (hund.getRace() == race) {
				samletpris += hund.getPrice();
			}
		}

		return samletpris;
	}
}
