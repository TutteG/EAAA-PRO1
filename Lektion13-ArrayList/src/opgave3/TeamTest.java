package opgave3;

public class TeamTest {
	public static void main(String[] args) {
		Player p1 = new Player("Niels", 21);
		Player p2 = new Player("Daniel", 23);
		Player p3 = new Player("Karl", 39);
		Player p4 = new Player("Oscar", 22);
		Player p5 = new Player("Peter", 25);
		Team t1 = new Team("Torbens Disciple");
		t1.addPlayer(p1);
		t1.addPlayer(p2);
		t1.addPlayer(p3);
		t1.addPlayer(p4);
		t1.addPlayer(p5);
		t1.printPlayers();
		System.out.println("Gennemsnitsalder på holdet: " + t1.calcAverageAge());
		p1.addScore(7);
		p3.addScore(4);
		System.out.println("Holdets totale score: " + t1.calcTotalScore());
		System.out.println(t1.calcOldPlayerScore(25));
		System.out.println("Højeste score på holdet: " + t1.maxScore());
		System.out.println("Holdets bedste spiller: " + t1.bestPlayer());

	}
}
