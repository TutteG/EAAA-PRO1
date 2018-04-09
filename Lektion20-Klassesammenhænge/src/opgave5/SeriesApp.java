package opgave5;

import java.util.ArrayList;

public class SeriesApp {
	public static void main(String[] args) {
		ArrayList<String> cast = new ArrayList<String>();
		cast.add("Simon Kvam");
		cast.add("Esben Pretzman");
		cast.add("Rune Tolsgaard");

		Series series = new Series("Drengene fra Angora", cast);

		ArrayList<String> guestActors = new ArrayList<String>();
		guestActors.add("Morten From");
		guestActors.add("Peter Hansen");
		guestActors.add("Champen over alle champs!");
		ArrayList<String> guestActors2 = new ArrayList<String>();
		guestActors2.add("Solo Jan");
		guestActors2.add("Doktor Hansen");
		guestActors2.add("Champen over alle champs!");
		Episode ep1 = series.createEpisode(1, guestActors, 20);
		Episode ep2 = series.createEpisode(2, guestActors2, 24);

		System.out.println(series.getTitle());
		System.out.println(series.totalLenght());
		System.out.println(series.getGuestActors());
		System.out.println(series.getGuestActorSingleEpisode(ep1));
		System.out.println(series.getGuestActorSingleEpisode(ep2));

	}
}
