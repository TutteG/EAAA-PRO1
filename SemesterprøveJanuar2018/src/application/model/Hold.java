package application.model;

import java.util.ArrayList;

public class Hold {
	private String betegnelse;
	private String holdleder;
	private Uddannelse uddannelse;
	private ArrayList<Tutor> tutors;

	public Hold(String betegnelse, String holdleder, Uddannelse uddannelse) {
		// TODO Auto-generated constructor stub
		this.betegnelse = betegnelse;
		this.holdleder = holdleder;
		this.uddannelse = uddannelse;
		this.tutors = new ArrayList<Tutor>();
		uddannelse.addHold(this);
	}

	public ArrayList<Tutor> getTutors() {
		return tutors;
	}

	public double arrangementsPris() {
		double price = 0;
		for (Tutor tutor : tutors) {
			price += tutor.arrangementsPris();
		}
		return price;
	}

	public boolean harTidsOverlap(Arrangement arrangement) {
		// TODO Auto-generated method stub
		for (Tutor tutor : tutors) {
			for (Arrangement arrangement2 : tutor.getArrangementer()) {
				if (arrangement.getDate().compareTo(arrangement2.getDate()) == 0) {
					if ((arrangement.getStartTid().isBefore(arrangement2.getSlutTid())
							&& arrangement.getStartTid().isAfter(arrangement2.getStartTid())
							|| (arrangement.getSlutTid().isAfter(arrangement2.getStartTid())
									&& arrangement.getSlutTid().isBefore(arrangement2.getSlutTid())))
							|| (arrangement.getStartTid().isBefore(arrangement2.getStartTid())
									&& arrangement.getSlutTid().isAfter(arrangement2.getSlutTid()))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void addTutor(Tutor tutor) {
		// TODO Auto-generated method stub
		tutors.add(tutor);
		if (tutor.getHold() != null) {
			tutor.getHold().removeTutor(tutor);
		}
		tutor.setHold(this);
	}

	public void removeTutor(Tutor tutor) {
		// TODO Auto-generated method stub
		tutors.remove(tutor);
		tutor.setHold(null);
	}

	public String getBetegnelse() {
		return betegnelse;
	}

	public String getHoldleder() {
		return holdleder;
	}

	public Uddannelse getUddannelse() {
		return uddannelse;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hold: " + betegnelse + " Holdleder: " + holdleder;
	}
}
