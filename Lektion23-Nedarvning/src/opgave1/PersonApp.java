package opgave1;

public class PersonApp {
	public static void main(String[] args) {
		Person mortenFrom = new Person("Morten From", "Skanderborgvej");

		System.out.println(mortenFrom.getName());
		Mekaniker benjamin = new Mekaniker("Benjamen", "Engtoften", 2018, 25);
		System.out.println(benjamin.getName());
		System.out.println(benjamin.getPayPerHour());

		Værkfører torben = new Værkfører("Torben", "Rosenhøj", 800, 2014, 2016, 50);
		System.out.println(torben.getAddress());
		System.out.println(torben.getYearOfPromotion());
		System.out.println(torben.getFurtherPayment());

	}
}
