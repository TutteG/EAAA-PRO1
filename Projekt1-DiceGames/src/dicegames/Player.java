package dicegames;

public class Player {
	private String name;
	private int score;

	public Player() {
		this.score = 0;
		this.name = "unknown";
	}

	public Player(String name) {
		this.score = 0;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	public void addToScore(int points) {
		this.score += points;
	}
}
