package model;

public class Lejlighed {
	private Værelse antal;

	public Lejlighed(Værelse antal) {
		// TODO Auto-generated constructor stub
		this.antal = antal;
	}

	public Værelse getAntal() {
		return antal;
	}

	public static void main(String[] args) {
		Lejlighed lejlighed = new Lejlighed(Værelse.ENKELT);
		System.out.println(lejlighed.getAntal());
	}
}
