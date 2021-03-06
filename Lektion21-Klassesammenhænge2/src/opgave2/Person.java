package opgave2;

import java.util.ArrayList;

public class Person {
	private String name;
	private int age;
	private ArrayList<Gift> receivedGifts = new ArrayList<Gift>();

	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void receives(Gift gift) {
		// TODO Auto-generated method stub
		receivedGifts.add(gift);
	}

	public Gift gives(String description, double price, Person receiver) {
		Gift gift = new Gift(description, price);
		gift.setReceiver(receiver);
		gift.setGiver(this);
		return gift;
	}

	public Gift givesSame(Gift gift, Person receiver) {
		gift.setReceiver(receiver);
		gift.setGiver(this);
		removeGift(gift);
		return gift;
	}

	private void removeGift(Gift gift) {
		receivedGifts.remove(gift);
	}

	public double getTotalPriceOfGifts() {
		double totalPrice = 0;
		for (Gift gift : receivedGifts) {
			totalPrice += gift.getPrice();
		}
		return totalPrice;
	}

	public ArrayList<Person> getGivers() {
		ArrayList<Person> givers = new ArrayList<Person>();
		for (Gift gift : receivedGifts) {
			givers.add(gift.getGiver());
		}

		return givers;
	}
}
