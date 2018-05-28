package service;

import java.time.LocalDate;
import java.util.ArrayList;

import DAO.DAO;
import model.Bestilling;
import model.BestillingsLinje;
import model.Gæst;
import model.Vare;

public class Service {
	public static ArrayList<Gæst> getGæster() {
		// TODO Auto-generated method stub
		return DAO.getGæster();
	}

	public static Gæst createGæst(String navn, int værelsesNummer) {
		Gæst gæst = new Gæst(navn, værelsesNummer);
		DAO.addGæst(gæst);
		return gæst;
	}

	public static void updateGæst(String navn, int værelsesNummer, Gæst gæst) {
		gæst.setNavn(navn);
		gæst.setVærelsesNummer(værelsesNummer);
	}

	public static Vare createVare(String navn, String mærke, double mængde, double pris) {
		Vare vare = new Vare(navn, mærke, mængde, pris);
		DAO.addVare(vare);
		return vare;
	}

	public static Bestilling createBestilling(LocalDate dato) {
		Bestilling bestilling = new Bestilling(dato);
		return bestilling;
	}

	public static BestillingsLinje createBestillingsLinje(int antal, Vare vare, Bestilling bestilling) {
		BestillingsLinje bestillingsLinje = new BestillingsLinje(antal, vare, bestilling);
		bestilling.addBestillingsLinje(bestillingsLinje);
		return bestillingsLinje;
	}

	public static void createSomeObjects() {
		Vare v1 = createVare("Cola", "CocaCola", 0.5, 28);
		Vare v2 = createVare("Cola", "Pepsi", 0.5, 26);
		Vare v3 = createVare("Øl", "Tuborg", 0.33, 33);
		Vare v4 = createVare("Øl", "Carlsberg", 0.57, 48);

		Gæst g1 = createGæst("Ib", 17);
		createGæst("Eva", 12);
		createGæst("Lene", 8);

		Bestilling bestilling1 = createBestilling(LocalDate.of(2014, 6, 15));
		createBestillingsLinje(3, v3, bestilling1);
		createBestillingsLinje(2, v1, bestilling1);
		createBestillingsLinje(2, v2, bestilling1);

		Bestilling bestilling2 = createBestilling(LocalDate.of(2014, 6, 16));
		createBestillingsLinje(2, v3, bestilling2);
		createBestillingsLinje(3, v2, bestilling2);
		createBestillingsLinje(4, v4, bestilling2);

		bestilling2.setBetalt(true);
		g1.addBestilling(bestilling1);
		g1.addBestilling(bestilling2);

	}
}
