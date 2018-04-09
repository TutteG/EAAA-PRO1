package opgave4;

public class Bug {
	int position;
	// true = right, false = left
	Boolean facing;

	public Bug(int position) {
		this.position = position;
		this.facing = true;

	}

	public void turn() {
		if (facing == true) {
			facing = false;
		} else {
			facing = true;
		}
	}

	public void move(int position) {
		if (facing == true) {
			this.position += position;
		} else {
			this.position -= position;
		}
	}

	public int getPosition() {
		return position;
	}

}
