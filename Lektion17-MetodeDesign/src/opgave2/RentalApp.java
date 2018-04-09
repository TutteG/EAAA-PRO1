package opgave2;

import java.time.LocalDate;

public class RentalApp {
	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.of(2018, 4, 1);

		Rental rental1 = new Rental(1, 10, 1000, ld1);
		System.out.println(rental1.getDays());
		System.out.println(rental1.getPricePrDay());
		System.out.println(rental1.getEndDate());
		System.out.println(rental1.getTotalPrice());

		LocalDate ld2 = LocalDate.now().plusMonths(10);

		Rental rental2 = new Rental(1, 10, 1000, ld2);
		System.out.println(rental2.getDays());
		System.out.println(rental2.getPricePrDay());
		System.out.println(rental2.getEndDate());
		System.out.println(rental2.getTotalPrice());
		System.out.println(rental2.getStartDate());
		System.out.println(rental2.getStartDate().minusDays(1));
	}
}
