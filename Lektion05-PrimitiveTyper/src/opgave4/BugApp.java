package opgave4;

public class BugApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bug bugsy = new Bug(50);
		System.out.println(bugsy.getPosition());
		bugsy.move(6);
		System.out.println(bugsy.getPosition());
		bugsy.turn();
		bugsy.move(12);
		System.out.println(bugsy.getPosition());
	}

}
