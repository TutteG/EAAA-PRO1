package opgave2;

import java.util.ArrayList;

public class PersonApp {
	public static void main(String[] args) {
		Person mortenFrom = new Person("Morten From", "Skanderborgvej");

		System.out.println(mortenFrom.getName());
		Mekaniker benjamin1 = new Mekaniker("Benjamen", "Engtoften", 2018, 10);
		Mekaniker benjamin2 = new Mekaniker("Benjamen", "Engtoften", 2018, 10);
		Mekaniker benjamin3 = new Mekaniker("Benjamen", "Engtoften", 2018, 10);
		Mekaniker benjamin4 = new Mekaniker("Benjamen", "Engtoften", 2018, 10);
		Mekaniker benjamin5 = new Mekaniker("Benjamen", "Engtoften", 2018, 10);
		Mekaniker benjamin6 = new Mekaniker("Benjamen", "Engtoften", 2018, 10);
		Mekaniker benjamin7 = new Mekaniker("Benjamen", "Engtoften", 2018, 10);
		Mekaniker benjamin8 = new Mekaniker("Benjamen", "Engtoften", 2018, 10);
		Mekaniker benjamin9 = new Mekaniker("Benjamen", "Engtoften", 2018, 10);
		System.out.println(benjamin1.getName());
		System.out.println(benjamin1.getPayPerHour());

		Værkfører torben = new Værkfører("Torben", "Rosenhøj", 10.0, 2014, 2016, 10.0);
		System.out.println(torben.getAddress());
		System.out.println(torben.getYearOfPromotion());
		System.out.println(torben.getFurtherPayment());

		System.out.println("Ugeløn for Benjamen " + benjamin1.getWeeklyPay());
		System.out.println("Ugeløn for Torben " + torben.getWeeklyPay());

		ArrayList<Mekaniker> mekanikerList = new ArrayList<>();
		mekanikerList.add(benjamin1);
		mekanikerList.add(benjamin2);
		mekanikerList.add(benjamin3);
		mekanikerList.add(benjamin4);
		mekanikerList.add(benjamin5);
		mekanikerList.add(benjamin6);
		mekanikerList.add(benjamin7);
		mekanikerList.add(benjamin8);
		mekanikerList.add(benjamin9);
		mekanikerList.add(torben);
		Synsmand peterH = new Synsmand("Benjamen", "Engtoften", 2018, 10);
		peterH.synEnBil();
		peterH.synEnBil();

		mekanikerList.add(peterH);
		for (Mekaniker mekaniker : mekanikerList) {
			System.out.println(mekaniker.getWeeklyPay());
		}

		System.out.println(Mekaniker.beregnSamletLøn(mekanikerList));

	}
}
