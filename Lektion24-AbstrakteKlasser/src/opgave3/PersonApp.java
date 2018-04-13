package opgave3;

import java.util.ArrayList;

public class PersonApp {
	public static void main(String[] args) {
		Person mortenFrom = new Person("Morten From", "Skanderborgvej");

		System.out.println(mortenFrom.getName());
		Ansat benjamin1 = new Mekaniker("Benjamen", "Engtoften", 2018, 120.0, 37);
		Ansat benjamin2 = new Mekaniker("Benjamen", "Engtoften", 2018, 120.0, 37);
		Ansat benjamin3 = new Mekaniker("Benjamen", "Engtoften", 2018, 120.0, 37);
		Ansat benjamin4 = new Mekaniker("Benjamen", "Engtoften", 2018, 120.0, 37);
		Ansat benjamin5 = new Mekaniker("Benjamen", "Engtoften", 2018, 120.0, 37);
		Ansat benjamin6 = new Mekaniker("Benjamen", "Engtoften", 2018, 120.0, 37);
		Ansat benjamin7 = new Mekaniker("Benjamen", "Engtoften", 2018, 120.0, 37);
		Ansat benjamin8 = new Mekaniker("Benjamen", "Engtoften", 2018, 120.0, 37);
		Ansat benjamin9 = new Mekaniker("Benjamen", "Engtoften", 2018, 120.0, 37);
		System.out.println(benjamin1.getName());
		System.out.println(benjamin1.getPayPerHour());

		Ansat torben = new Værkfører("Torben", "Rosenhøj", 120.0, 2015, 50.0, 37, 2012);
		System.out.println(torben.getAddress());

		System.out.println("Ugeløn for Benjamen " + benjamin1.getWeeklyPay());
		System.out.println("Ugeløn for Torben " + torben.getWeeklyPay());

		ArrayList<Ansat> ansatList = new ArrayList<>();
		ansatList.add(benjamin1);
		ansatList.add(benjamin2);
		ansatList.add(benjamin3);
		ansatList.add(benjamin4);
		ansatList.add(benjamin5);
		ansatList.add(benjamin6);
		ansatList.add(benjamin7);
		ansatList.add(benjamin8);
		ansatList.add(benjamin9);
		ansatList.add(torben);
		Synsmand peterH = new Synsmand("Benjamen", "Engtoften", 2018, 140.0, 37);
		peterH.synEnBil();
		peterH.synEnBil();

		ansatList.add(peterH);

		Ansat janBørkop = new StableBoy("Jan Børkop", "Skanderbronx", 60, 2018, 25, "Trækker dreng");
		ansatList.add(janBørkop);
		for (Ansat ansat : ansatList) {
			System.out.println(ansat.getWeeklyPay());
		}

		System.out.println(Ansat.beregnSamletLøn(ansatList));

	}
}
