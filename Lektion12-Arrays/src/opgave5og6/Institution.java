package opgave5og6;

public class Institution {
	private String name;
	private String address;
	private Child[] childArray;
	private int howManyChildren = 0;
	private double gennemsnitsalder = 0;

	public Institution(String name, String address) {
		this.name = name;
		this.address = address;
		childArray = new Child[howManyChildren];
	}

	public int getNumberOfChildren() {
		return childArray.length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	////////////////////////////////
	// Kig på det senere !!!!!!!! //
	// Der skal kopieres et array //
	////////////////////////////////
	public void addChild(Child child) {
		if (howManyChildren == 0) {
			childArray = new Child[++howManyChildren];
			childArray[0] = child;
		} else {
			Child[] tempArray = new Child[childArray.length];
			tempArray = childArray.clone();
			childArray = new Child[++howManyChildren];
			for (int i = 0; i < tempArray.length; i++) {
				childArray[i] = tempArray[i];
			}
			childArray[howManyChildren - 1] = child;
		}
	}

	public double gennemsnitsalder() {
		for (int i = 0; i < childArray.length; i++) {
			gennemsnitsalder += childArray[i].getAge();
		}
		return gennemsnitsalder / childArray.length;
	}

	public int girlsCount() {
		int count = 0;
		for (int i = 0; i < childArray.length; i++) {
			if (childArray[i].isBoy() == false) {
				count++;
			}
		}
		return count;
	}

	public int boysCount() {
		int count = 0;
		for (int i = 0; i < childArray.length; i++) {
			if (childArray[i].isBoy() == true) {
				count++;
			}
		}
		return count;
	}

}
