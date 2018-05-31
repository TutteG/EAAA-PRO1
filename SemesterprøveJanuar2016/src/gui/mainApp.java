package gui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import application.model.Bane;
import application.service.Service;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

public class mainApp extends Application {
	public static void main(String[] args) {
		// Bane bane = new Bane(1, "Højdedraget");
		// System.out.println(bane.getLedigeTiderPaaDag(LocalDate.of(2017, 6, 30)));
		//
		// Medlem medlem1 = new Medlem("Jan", "320651", "asdf");
		// Medlem medlem2 = new Medlem("Peter", "320651", "asdf");
		// Reservation reservation = medlem1.createReservation(LocalDate.of(2017, 6,
		// 30), LocalTime.of(7, 0), bane,
		// medlem2);
		//
		// bane.addReservation(reservation);
		// System.out.println(bane.getLedigeTiderPaaDag(LocalDate.of(2017, 6, 30)));
		Service.initStorage();
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		stage.setTitle("Booking af tennisbaner");
		BorderPane pane = new BorderPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setMinHeight(160);
		stage.setMinWidth(330);
		stage.show();
	}

	private void initContent(BorderPane pane) {
		// TODO Auto-generated method stub
		GridPane gridPane = new GridPane();
		initGridPane(gridPane);
		pane.setCenter(gridPane);
		pane.setPadding(new Insets(10));

	}

	Label lblDato, lblBaner, lblLedigeTider;
	TextField txfDato;
	ListView<Bane> lvwBaner;
	ListView<LocalTime> lvwLedigeTider;
	Button btnOpretBane;

	private void initGridPane(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setGridLinesVisible(false);

		// --------------------Collumn 0-----------------//
		lblDato = new Label("Dato:");
		gridPane.add(lblDato, 0, 0);

		txfDato = GUITools.stdTextField();
		gridPane.add(txfDato, 0, 1);

		lblBaner = new Label("Baner:");
		gridPane.add(lblBaner, 0, 2);

		lvwBaner = new ListView<Bane>();
		lvwBaner.getItems().setAll(Storage.baner);
		gridPane.add(lvwBaner, 0, 3);
		ChangeListener<Bane> baneListener = (ov, oldValue, newValue) -> this.selectedBaneChanged();
		lvwBaner.getSelectionModel().selectedItemProperty().addListener(baneListener);

		btnOpretBane = GUITools.stdButton("Opret bane");
		gridPane.add(btnOpretBane, 0, 4);
		btnOpretBane.setOnAction(event -> opretNyBane());
		// --------------------Collumn 1-----------------//
		lblLedigeTider = new Label("Ledige tider:");
		gridPane.add(lblLedigeTider, 1, 0);

		lvwLedigeTider = new ListView<LocalTime>();
		gridPane.add(lvwLedigeTider, 1, 1, 1, 3);
	}

	private void opretNyBane() {
		// TODO Auto-generated method stub
		OpretBane opretBane = new OpretBane();
		opretBane.showAndWait();
		lvwBaner.getItems().setAll(Storage.baner);
	}

	private void selectedBaneChanged() {
		// TODO Auto-generated method stub
		Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
		if (bane != null) {
			try {
				lvwLedigeTider.getItems().setAll(bane.getLedigeTiderPaaDag(LocalDate.parse(txfDato.getText())));
			} catch (DateTimeParseException e) {
				// TODO: handle exception
				System.out.println("Skriv venligst korrekt datoformat: yyyy-mm-dd");
				System.out.println(e.getMessage());
			}
		}
	}
}
