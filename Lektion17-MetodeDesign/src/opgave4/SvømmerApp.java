package opgave4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SvømmerApp {
	public static void main(String[] args) {
		LocalDate tredjeApril = LocalDate.parse("1990-03-04");
		LocalDateTime date = LocalDateTime.parse("1990-03-04T23:00:30");
		System.out.println(date);
		ArrayList<Double> tider = new ArrayList<>();
		tider.add(12.4);
		tider.add(11.4);
		tider.add(18.4);
		tider.add(16.4);
		tider.add(100.4);
		tider.add(18.4);
		tider.add(19.4);
		tider.add(9.4);

		Svømmer svømmer = new Svømmer("Torben", "HOG", tredjeApril, tider);

		System.out.println("getNavn(): 		" + svømmer.getNavn());
		System.out.println("getÅrgang(): 		" + svømmer.getÅrgang());
		System.out.println("getKlub(): 		" + svømmer.getKlub());
		svømmer.setKlub("AGF");
		System.out.println("klubskifte(): 	");
		System.out.println("getKlub(): 		" + svømmer.getKlub());
		System.out.println("bedsteTid(): 		" + svømmer.bedsteTid());
		System.out.println("gennemsnitAfTid(): 	" + svømmer.gennemsnitAfTid());
		System.out.println("snitUdenDårligste(): 	" + svømmer.snitUdenDårligste());
	}
}
