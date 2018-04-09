package opgave3teatersal;

public class TeaterSal {
	private int[][] theaterSeats;

	public TeaterSal() {
		theaterSeats = new int[][] { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
				{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
				{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
				{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 }, { 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
				{ 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 }, { 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };
	}

	public void buyTicket(int ticketprice) {
		boolean koebt = false;
		for (int i = 0; i < theaterSeats.length; i++) {
			for (int j = 0; j < theaterSeats[i].length; j++) {
				if (ticketprice == theaterSeats[i][j]) {
					System.out.println("You have bought seat number: " + (i + 1) + (j + 1));
					theaterSeats[i][j] = 0;
					koebt = true;
				}
				if (koebt) {
					break;
				}
			}
			if (koebt) {
				break;
			}
		}
		if (!koebt) {
			System.out.println("No seats available in this price range!");
		}
	}

	public void buyTicket(int seatCol, int seatRow) {
		if (theaterSeats[seatCol - 1][seatRow - 1] != 0) {
			System.out.println("seat at row: " + seatCol + " seat: " + seatRow + " is yours now");
			theaterSeats[seatCol - 1][seatRow - 1] = 0;
		} else {
			System.out.println("Seat not available..");
		}

	}

}
