package opgave5;

public class Copier {
	private int paper;
	private boolean paperStuck = false;

	public Copier() {

	}

	public Copier(int paper) {
		this.paper = paper;
	}

	public void insertPaper(int paper) {
		if (this.paper + paper <= 500) {
			this.paper += paper;
		} else {
			System.out.println("No mas papier!");
		}
	}

	public int getPaper() {
		return paper;
	}

	public void makeCopy(int paper) {

		if (paperStuck == true) {

			if (this.paper - paper > 0) {
				this.paper -= paper;
			} else {
				System.out.println("Please insert paper");
			}
		} else {
			System.out.println("You have a paperjam");
		}

	}

	public void makePaperJam() {
		this.paperStuck = false;
	}

	public void fixPaperJam() {
		this.paperStuck = true;
	}

}
