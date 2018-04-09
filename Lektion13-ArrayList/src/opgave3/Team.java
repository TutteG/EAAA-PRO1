package opgave3;

import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> listPlayer;

	public Team(String name) {
		this.name = name;
		listPlayer = new ArrayList<Player>();
	}

	public String getName() {
		return name;
	}

	public void addPlayer(Player player) {
		listPlayer.add(player);
	}

	public void printPlayers() {
		for (Player player : listPlayer) {
			System.out.println("Spillernavn: " + player.getName() + "	Alder: " + player.getAge() + "	Score: "
					+ player.getScore());
		}
	}

	public double calcAverageAge() {
		double averageAge = 0;
		for (Player player : listPlayer) {
			averageAge += player.getAge();
		}
		return averageAge / listPlayer.size();
	}

	public int calcTotalScore() {
		int score = 0;
		for (Player player : listPlayer) {
			score += player.getScore();
		}
		return score;
	}

	public int calcOldPlayerScore(int ageLimit) {
		int score = 0;

		for (Player player : listPlayer) {
			if (player.getAge() > ageLimit) {
				score += player.getScore();
			}
		}
		return score;
	}

	public int maxScore() {
		int score = 0;
		for (Player player : listPlayer) {
			if (score < player.getScore()) {
				score = player.getScore();
			}
		}
		return score;
	}

	public String bestPlayer() {
		String bestPlayer = "";
		int score = 0;
		for (Player player : listPlayer) {
			if (score < player.getScore()) {
				bestPlayer = player.getName();
			}
		}
		return bestPlayer;
	}
}
