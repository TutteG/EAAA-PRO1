package application.model;

public class ProfSpiller extends Spiller {
	private double kampHonorar;

	public ProfSpiller(String navn, int årgang, double kampHonorar) {
		// TODO Auto-generated constructor stub
		super(navn, årgang);
		this.kampHonorar = kampHonorar;
	}

	public double getKampHonorar() {
		return kampHonorar;
	}

	@Override
	public double kampHonorar() {
		// TODO Auto-generated method stub
		int kampeSpillet = 0;
		int kampe = 0;
		for (Deltagelse deltagelse : super.getDeltagelser()) {
			if (!deltagelse.isAfbud()) {
				kampeSpillet++;
			}
			kampe++;
		}
		double procentdelSpillet = kampeSpillet / kampe;
		return kampHonorar * procentdelSpillet;
	}
}
