package application.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import application.model.Bane;
import application.model.Medlem;
import application.model.Reservation;
import storage.Storage;

public class Service {
	public static Bane createBane(int nummer, String baneInfo) {
		Bane bane = new Bane(nummer, baneInfo);
		Storage.addBane(bane);
		return bane;
	}

	public static Medlem createMedlem(String navn, String mobil, String mail) {
		Medlem medlem = new Medlem(navn, mobil, mail);
		Storage.addMedlem(medlem);
		return medlem;
	}

	public static Reservation createReservation(Medlem booker, Medlem makker, Bane bane, LocalDate dato,
			LocalTime startTid) {
		if (bane.isLedig(dato, startTid) && !(booker.hasAktivReservation() && makker.hasAktivReservation())) {
			Reservation reservation = booker.createReservation(dato, startTid, bane, makker);
			bane.addReservation(reservation);
			return reservation;
		}
		return null;
	}

	public static void writeLedigeTider(LocalDate dato, String filnavn) {
		try {
			File file = new File(filnavn);
			PrintWriter printWriter = new PrintWriter(file);
			printWriter.write("Ledige tider d. " + dato.toString());
			for (Bane bane : Storage.getBaner()) {
				printWriter.write("På bane nummer: " + bane.getNummer());
				for (LocalTime localTime : bane.getLedigeTiderPaaDag(dato)) {
					printWriter.write(localTime.toString());
				}
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File not found: " + e.getMessage());
		}
	}

	public static void initStorage() {
		// TODO Auto-generated method stub
		Medlem medlem1 = createMedlem("Lene Mikkelsen", "12345678", "lm@msn.com");
		Medlem medlem2 = createMedlem("Finn Jensen", "22331144", "fj@msn.com");

		Bane bane1 = createBane(1, "Nord/Syd vendt");
		Bane bane2 = createBane(2, "Under Egetræet");
		Bane bane3 = createBane(3, "Med tilskuerpladser");

	}
}
