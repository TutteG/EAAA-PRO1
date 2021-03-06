package opgave2;

public class Gift {
	private String description;
	private double price;
	private Person receiver;
	private Person giver;

	Gift(String description, double price) {
		// TODO Auto-generated constructor stub
		this.description = description;
		this.price = price;

	}

	public String getDescription() {
		return description;
	}

	void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setReceiver(Person person) {
		this.receiver = person;
		person.receives(this);
	}

	public Person getReceiver() {
		return receiver;
	}

	public void setGiver(Person person) {
		this.giver = person;
	}

	public Person getGiver() {
		return giver;
	}
}
