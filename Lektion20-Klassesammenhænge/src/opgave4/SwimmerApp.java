package opgave4;

import java.util.ArrayList;

public class SwimmerApp {

	public static void main(String[] args) {

		TrainingPlan trainingPlanA = new TrainingPlan('A', 16, 10);
		ArrayList<Double> lapTimes1 = new ArrayList<>();
		lapTimes1.add(1.02);
		lapTimes1.add(1.01);
		lapTimes1.add(0.99);
		lapTimes1.add(0.98);
		lapTimes1.add(1.02);
		lapTimes1.add(1.04);
		lapTimes1.add(0.99);
		// Swimmer s1 = new Swimmer("Jan", 1994, lapTimes1, "AGF");
		trainingPlanA.createSwimmer("Jan", 1990, lapTimes1, "AIA Tranbjerg");

		ArrayList<Double> lapTimes2 = new ArrayList<>();
		lapTimes2 = new ArrayList<>();
		lapTimes2.add(1.05);
		lapTimes2.add(1.01);
		lapTimes2.add(1.04);
		lapTimes2.add(1.06);
		lapTimes2.add(1.08);
		lapTimes2.add(1.04);
		lapTimes2.add(1.02);
		// Swimmer s2 = new Swimmer("Bo", 1995, lapTimes2, "Lyseng");
		trainingPlanA.createSwimmer("Bo", 1990, lapTimes2, "AIA Tranbjerg");

		ArrayList<Double> lapTimes3 = new ArrayList<>();
		lapTimes3 = new ArrayList<>();
		lapTimes3.add(1.03);
		lapTimes3.add(0.01);
		lapTimes3.add(1.02);
		lapTimes3.add(1.05);
		lapTimes3.add(1.03);
		lapTimes3.add(1.06);
		lapTimes3.add(1.03);
		// Swimmer s3 = new Swimmer("Mikkel", 1993, lapTimes3, "AIA-Tranbjerg");

		trainingPlanA.createSwimmer("Niels", 1990, lapTimes3, "AIA Tranbjerg");
		trainingPlanA.createSwimmer("Morten From", 1990, lapTimes3, "AIA Tranbjerg");
		ArrayList<Swimmer> swimmers = new ArrayList<>();
		// swimmers.add(s1);
		// swimmers.add(s2);
		// swimmers.add(s3);

		for (Swimmer s : swimmers) {
			System.out.println(s.getName() + " bedste tid: " + s.bestLapTime());
		}
		// TrainingPlan trainingPlanB = new TrainingPlan('B', 10, 6);
		// s1.setTrainingPlan(trainingPlanA);
		// s2.setTrainingPlan(trainingPlanB);
		// System.out.println(s1.getName() + "'s samlet ugentlige træningstid: " +
		// s1.allTrainingHours());
		// System.out.println(s2.getName() + "'s samlet ugentlige træningstid: " +
		// s2.allTrainingHours());
		ArrayList<Swimmer> swimmers2 = trainingPlanA.getSwimmers();
		for (Swimmer swimmer : swimmers2) {
			System.out.println(swimmer.getName());
			System.out.println(swimmer.bestLapTime());
		}
	}

}
