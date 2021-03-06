package opgave5;

import java.util.ArrayList;

public class Series {
	String title;
	ArrayList<String> cast = new ArrayList<String>();
	ArrayList<Episode> episodes = new ArrayList<Episode>();

	public Series(String title, ArrayList<String> cast) {
		this.title = title;
		this.cast = cast;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<String> getCast() {
		return cast;
	}

	public Episode createEpisode(int number, ArrayList<String> guestActors, int length) {
		// TODO Auto-generated method stub
		Episode episode = new Episode(number, guestActors, length);
		episodes.add(episode);
		return episode;
	}

	public void removeEpisode(Episode episode) {
		// TODO Auto-generated method stub
		episodes.remove(episode);
	}

	public ArrayList<Episode> getEpisodes() {
		return new ArrayList<>(episodes);
	}

	public int totalLenght() {
		// TODO Auto-generated method stub
		int totalLenght = 0;
		for (Episode episode : episodes) {
			totalLenght += episode.getLenght();
		}
		return totalLenght;
	}

	public ArrayList<String> getGuestActors() {
		ArrayList<String> guestActors = new ArrayList<String>();
		for (Episode episode : episodes) {
			guestActors.addAll(episode.getGuestActors());
		}
		return guestActors;
	}

	public ArrayList<String> getGuestActorSingleEpisode(Episode episode) {
		// TODO Auto-generated method stub
		return episode.getGuestActors();

	}

}
