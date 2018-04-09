package opgave3app;

import java.util.ArrayList;

import opgave3.Swimmer;
import opgave3.TrainingPlan;

public class SwimmerApp {

	public static void main(String[] args) {

		ArrayList<Double> lapTimes = new ArrayList<>();
		lapTimes.add(1.02);
		lapTimes.add(1.01);
		lapTimes.add(0.99);
		lapTimes.add(0.98);
		lapTimes.add(1.02);
		lapTimes.add(1.04);
		lapTimes.add(0.99);
		Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");

		lapTimes = new ArrayList<>();
		lapTimes.add(1.05);
		lapTimes.add(1.01);
		lapTimes.add(1.04);
		lapTimes.add(1.06);
		lapTimes.add(1.08);
		lapTimes.add(1.04);
		lapTimes.add(1.02);
		Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");

		lapTimes = new ArrayList<>();
		lapTimes.add(1.03);
		lapTimes.add(1.01);
		lapTimes.add(1.02);
		lapTimes.add(1.05);
		lapTimes.add(1.03);
		lapTimes.add(1.06);
		lapTimes.add(1.03);
		Swimmer s3 = new Swimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

		ArrayList<Swimmer> swimmers = new ArrayList<>();
		swimmers.add(s1);
		swimmers.add(s2);
		swimmers.add(s3);

		for (Swimmer s : swimmers) {
			System.out.println(s.getName() + " bedste tid: " + s.bestLapTime());
		}
		TrainingPlan trainingPlanA = new TrainingPlan('A', 16, 10);
		// TrainingPlan trainingPlanB = new TrainingPlan('B', 10, 6);
		// s1.setTrainingPlan(trainingPlanA);
		// s2.setTrainingPlan(trainingPlanB);
		// System.out.println(s1.getName() + "'s samlet ugentlige træningstid: " +
		// s1.allTrainingHours());
		// System.out.println(s2.getName() + "'s samlet ugentlige træningstid: " +
		// s2.allTrainingHours());
		trainingPlanA.addSwimmer(s1);
		trainingPlanA.addSwimmer(s2);
		trainingPlanA.addSwimmer(s3);
		ArrayList<Swimmer> swimmers2 = trainingPlanA.getSwimmers();
		for (Swimmer swimmer : swimmers2) {
			System.out.println(swimmer.getName());
			System.out.println(swimmer.bestLapTime());
		}
	}

}
