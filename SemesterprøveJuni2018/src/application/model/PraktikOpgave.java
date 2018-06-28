package application.model;

public abstract class PraktikOpgave {
	private String navn;
	private int semester;

	public PraktikOpgave(String navn, int semester) {
		this.navn = navn;
		this.semester = semester;
	}

	public String getNavn() {
		return navn;
	}

	public int getSemester() {
		return semester;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return navn + " " + semester;
	}
}
