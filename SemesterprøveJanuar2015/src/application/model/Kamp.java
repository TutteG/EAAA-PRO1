package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Kamp implements Comparable<Kamp> {
	private String sted;
	private LocalDate dato;
	private LocalTime tid;
	private ArrayList<Deltagelse> deltagelser;
	private ArrayList<String> afbud;

	public Kamp(String sted, LocalDate dato, LocalTime tid) {
		// TODO Auto-generated constructor stub
		this.sted = sted;
		this.dato = dato;
		this.tid = tid;
		this.deltagelser = new ArrayList<Deltagelse>();
		this.afbud = new ArrayList<String>();
	}

	public ArrayList<Deltagelse> getDeltagelser() {
		return deltagelser;
	}

	public void spillerHonorar(String tekstFil) {
		File file = new File(tekstFil);
		try {
			PrintWriter pw = new PrintWriter(file);
			for (Deltagelse deltagelse : deltagelser) {
				if (!deltagelse.isAfbud()) {
					pw.append(deltagelse.getSpiller().getNavn() + "\n");
				}
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File Not Found.." + e.getMessage());
		}
	}

	public void createDeltagelse() {
		// TODO Auto-generated method stub
		Deltagelse deltagelse = new Deltagelse("");
		this.deltagelser.add(deltagelse);

	}

	// Skal muligvis ikke være her...
	public void addDeltagelse(Deltagelse deltagelse) {
		this.deltagelser.add(deltagelse);
	}

	public void afbud() {
		// TODO Auto-generated method stub
		for (Deltagelse deltagelse : deltagelser) {
			if (deltagelse.isAfbud()) {
				this.afbud.add(deltagelse.getSpiller().getNavn() + ": " + deltagelse.getBegrundelse());
			}
		}
	}

	public LocalDate getDato() {
		return dato;
	}

	public String getSted() {
		return sted;
	}

	public LocalTime getTid() {
		return tid;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}

	public void setTid(LocalTime tid) {
		this.tid = tid;
	}

	@Override
	public int compareTo(Kamp o) {
		// TODO Auto-generated method stub
		if (this.getDato().compareTo(o.getDato()) < 0) {
			return -1;
		} else if (this.getDato().compareTo(o.getDato()) > 0) {
			return 1;
		} else {
			if (this.getTid().compareTo(o.getTid()) < 0) {
				return -1;
			} else if (this.getTid().compareTo(o.getTid()) > 0) {
				return 1;
			} else {
				if (this.getSted().compareTo(o.getSted()) < 0) {
					return -1;
				} else if (this.getSted().compareTo(o.getSted()) > 0) {
					return 1;
				} else {
					return 0;
				}
			}
		}
		// return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getSted() + "	" + getDato() + "	" + getTid();
	}
}
