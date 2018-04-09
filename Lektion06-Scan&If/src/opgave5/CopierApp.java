package opgave5;

public class CopierApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Copier cop = new Copier(10);
		System.out.println("papir i maskinen: " + cop.getPaper());
		cop.makeCopy(5);
		System.out.println("papir i maskinen: " + cop.getPaper());
		cop.makeCopy(20);
		System.out.println("papir i maskinen: " + cop.getPaper());
		cop.insertPaper(500);
		cop.insertPaper(46);
		System.out.println("papir i maskinen: " + cop.getPaper());
		cop.makePaperJam();
		cop.makeCopy(5);
		System.out.println("papir i maskinen: " + cop.getPaper());
		cop.fixPaperJam();
		cop.makeCopy(5);
		System.out.println("papir i maskinen: " + cop.getPaper());

	}

}
