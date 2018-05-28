package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {
	private String title;
	private LocalDate date;
	private LocalTime startTid;
	private LocalTime slutTid;
	private double price;

	public Arrangement(String title, LocalDate date, LocalTime startTid, LocalTime slutTid, double price) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.date = date;
		this.startTid = startTid;
		this.slutTid = slutTid;
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}

	public LocalTime getSlutTid() {
		return slutTid;
	}

	public LocalTime getStartTid() {
		return startTid;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return title + " " + date + " " + startTid + " " + slutTid;
	}
}
