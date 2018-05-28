package gui;

import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Hold;
import application.model.Tutor;
import application.model.Uddannelse;
import application.service.Service;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

public class mainGUI extends Application {
	public static void main(String[] args) {
		Service.initStorage();

		ArrayList<Hold> hold = Service.holdUdenTutorer();
		System.out.println(hold);

		for (Uddannelse uddannelse : Storage.getUddannelser()) {
			System.out.println(uddannelse.tutorOversigt());
		}

		Service.tutorOversigtTilFil("TutorListe.txt");
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Administration af tutorer og arrangementer");
		BorderPane pane = new BorderPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setMinHeight(160);
		stage.setMinWidth(330);
		stage.show();
	}

	private void initContent(BorderPane pane) {
		GridPane gridPane = new GridPane();
		initGridPane(gridPane);
		pane.setCenter(gridPane);
		pane.setPadding(new Insets(10));
	}

	Label lblTutorer, lblNavn, lblEmail, lblArrangementer, lblAlleArrangementer;
	ListView<Tutor> lvwTutorer;
	ListView<Arrangement> lvwArrangementer;
	ListView<Arrangement> lvwAlleArrangementer;
	TextField txfNavn, txfEmail;
	Button btnfjern, btnTilføj;
	Button btnAddTutor;

	private void initGridPane(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setGridLinesVisible(false);

		// --------------------Collumn 0-----------------//
		lblTutorer = new Label("Tutorer");
		gridPane.add(lblTutorer, 0, 0);

		lvwTutorer = new ListView<>();
		updateTutorList();
		gridPane.add(lvwTutorer, 0, 1, 1, 5);
		ChangeListener<Tutor> tutorListener = (ov, oldValue, newValue) -> this.selectedTutorChanged();
		lvwTutorer.getSelectionModel().selectedItemProperty().addListener(tutorListener);
		// --------------------Collumn 1-----------------//
		lblNavn = new Label("Navn");
		gridPane.add(lblNavn, 1, 0);

		lblEmail = new Label("Email");
		gridPane.add(lblEmail, 1, 1);

		lblArrangementer = new Label("Arrangementer");
		GridPane.setValignment(lblArrangementer, VPos.TOP);
		gridPane.add(lblArrangementer, 1, 2);

		// --------------------Collumn 2-----------------//
		txfNavn = GUITools.stdTextField();
		gridPane.add(txfNavn, 2, 0);

		txfEmail = GUITools.stdTextField();
		gridPane.add(txfEmail, 2, 1);

		lvwArrangementer = new ListView<Arrangement>();
		gridPane.add(lvwArrangementer, 2, 2);

		btnfjern = GUITools.stdButton("Fjern");
		gridPane.add(btnfjern, 2, 3);
		btnfjern.setOnAction(event -> removeArrangement());

		// --------------------Collumn 3-----------------//
		btnAddTutor = GUITools.stdButton("Tilføj Tutor");
		gridPane.add(btnAddTutor, 3, 0);
		btnAddTutor.setOnAction(event -> addTutor());

		lblAlleArrangementer = new Label("Alle mulige former for arrangementer");
		gridPane.add(lblAlleArrangementer, 3, 1);

		lvwAlleArrangementer = new ListView<Arrangement>();
		lvwAlleArrangementer.getItems().setAll(Storage.getArrangementer());
		gridPane.add(lvwAlleArrangementer, 3, 2);

		btnTilføj = GUITools.stdButton("Tilføj");
		gridPane.add(btnTilføj, 3, 3);
		btnTilføj.setOnAction(event -> addArrangement());

	}

	private void selectedTutorChanged() {
		// TODO Auto-generated method stub
		Tutor tutor = lvwTutorer.getSelectionModel().getSelectedItem();
		if (tutor != null) {
			txfNavn.setText(tutor.getNavn());
			txfEmail.setText(tutor.getEmail());
			lvwArrangementer.getItems().setAll(tutor.getArrangementer());

		} else {
			txfNavn.clear();
			txfEmail.clear();
		}
	}

	private void addTutor() {
		if (txfNavn.getText().length() > 0 && txfEmail.getText().length() > 0) {
			Service.createTutor(txfNavn.getText(), txfEmail.getText());
			updateTutorList();
		}
	}

	private void removeArrangement() {
		try {
			Service.removeArrangementFromTutor(lvwTutorer.getSelectionModel().getSelectedItem(),
					lvwArrangementer.getSelectionModel().getSelectedItem());
			updateArrangementer();
		} catch (NullPointerException e) {
			// TODO: handle exception
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Nothing selected");
			alert.setContentText("Elementer ikke valgt " + e.getMessage());
			alert.showAndWait();
		}
	}

	private void addArrangement() {
		try {
			Service.linkArrangementToTutor(lvwTutorer.getSelectionModel().getSelectedItem(),
					lvwAlleArrangementer.getSelectionModel().getSelectedItem());
			updateArrangementer();
		} catch (NullPointerException e) {
			// TODO: handle exception
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Nothing selected");
			alert.setContentText("Elementer ikke valgt " + e.getMessage());
			alert.showAndWait();
		}
	}

	private void updateArrangementer() {
		lvwArrangementer.getItems().setAll(lvwTutorer.getSelectionModel().getSelectedItem().getArrangementer());
	}

	private void updateTutorList() {
		lvwTutorer.getItems().setAll(Storage.getTutors());
	}
}
