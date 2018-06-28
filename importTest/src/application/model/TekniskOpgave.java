package application.model;

public class TekniskOpgave extends PraktikOpgave {
	private String programmeringSprog;

	public TekniskOpgave(String navn, int semester, String programmeringSprog) {
		super(navn, semester);
		this.programmeringSprog = programmeringSprog;
	}

	public String getProgrammeringSprog() {
		return programmeringSprog;
	}

	public void setProgrammeringSprog(String programmeringSprog) {
		this.programmeringSprog = programmeringSprog;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " " + programmeringSprog;
	}
}
