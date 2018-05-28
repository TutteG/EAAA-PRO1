package guifx;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import application.model.Kamp;
import application.service.Service;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Administration af spiller deltagelse");
		BorderPane pane = new BorderPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setMinHeight(160);
		stage.setMinWidth(330);
		stage.show();
	}

	private void initContent(BorderPane pane) {
		Service.createSomeObjects();
		GridPane gridPane = new GridPane();
		initGridPane(gridPane);
		pane.setCenter(gridPane);
		pane.setPadding(new Insets(10));
	}

	Label lblKampe;
	ListView<Kamp> lvKampe;
	Label lblSpilleSted;
	Label lblSpilleDato;
	Label lblSpilleTid;
	TextField txfSpilleSted;
	TextField txfSpilleDato;
	TextField txfSpilleTid;
	Button btnOpret, btnOpdater, btnLavFil;

	private void initGridPane(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setGridLinesVisible(false);

		// --------------------Collumn 0-----------------//
		lblKampe = new Label("Kampe");
		gridPane.add(lblKampe, 0, 0);

		lvKampe = new ListView<Kamp>();
		// lvKampe.getItems().setAll(Storage.getKampe());
		updateKampListe();
		gridPane.add(lvKampe, 0, 1, 1, 4);
		ChangeListener<Kamp> kampListener = (ov, oldValue, newValue) -> this.selectedKampChanged();
		lvKampe.getSelectionModel().selectedItemProperty().addListener(kampListener);
		// --------------------Collumn 1-----------------//
		lblSpilleSted = new Label("Spillested:");
		lblSpilleDato = new Label("Spilledato:");
		lblSpilleTid = new Label("Spilletid:");

		gridPane.add(lblSpilleSted, 1, 0);
		gridPane.add(lblSpilleDato, 1, 1);
		gridPane.add(lblSpilleTid, 1, 2);

		// --------------------Collumn 2-----------------//
		txfSpilleSted = GUITools.stdTextField();
		txfSpilleDato = GUITools.stdTextField();
		txfSpilleTid = GUITools.stdTextField();
		btnOpret = GUITools.stdButton("Opret");
		btnLavFil = GUITools.stdButton("Lav fil");
		btnOpret.setOnAction(event -> opretAction());
		btnLavFil.setOnAction(event -> lavFilAction());

		gridPane.add(txfSpilleSted, 2, 0, 2, 1);
		gridPane.add(txfSpilleDato, 2, 1, 2, 1);
		gridPane.add(txfSpilleTid, 2, 2, 2, 1);
		gridPane.add(btnOpret, 2, 3);
		gridPane.add(btnLavFil, 2, 4);

		// --------------------Collumn 3-----------------//
		btnOpdater = GUITools.stdButton("Opdater");
		btnOpdater.setOnAction(event -> opdaterAction());
		gridPane.add(btnOpdater, 3, 3);

	}

	private void selectedKampChanged() {
		// TODO Auto-generated method stub
		Kamp kamp = lvKampe.getSelectionModel().getSelectedItem();
		if (kamp != null) {
			txfSpilleSted.setText(kamp.getSted());
			txfSpilleDato.setText(kamp.getDato().toString());
			txfSpilleTid.setText(kamp.getTid().toString());
		} else {
			txfSpilleDato.clear();
			txfSpilleSted.clear();
			txfSpilleTid.clear();
		}

	}

	private void opdaterAction() {
		// TODO Auto-generated method stub
		if (txfSpilleSted.getText().length() > 0 && txfSpilleDato.getText().length() > 0
				&& txfSpilleTid.getText().length() > 0) {
			try {
				Service.updateKamp(lvKampe.getSelectionModel().getSelectedItem(), txfSpilleSted.getText(),
						LocalDate.parse(txfSpilleDato.getText()), LocalTime.parse(txfSpilleTid.getText()));
				updateKampListe();
			} catch (NullPointerException e) {
				// TODO: handle exception
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Intet emne valgt");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			} catch (DateTimeParseException e) {
				// TODO: handle exception
				System.out.println("Fejl i formatering af dato eller tid " + e.getMessage());
			}
		}
	}

	private void lavFilAction() {
		// TODO Auto-generated method stub
		try {
			Service.lavSpillerHonorarFil(lvKampe.getSelectionModel().getSelectedItem());
		} catch (NullPointerException e) {
			// TODO: handle exception
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Intet emne valgt");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void opretAction() {
		// TODO Auto-generated method stub
		if (txfSpilleSted.getText().length() > 0 && txfSpilleDato.getText().length() > 0
				&& txfSpilleTid.getText().length() > 0) {
			try {
				Service.createKamp(txfSpilleSted.getText(), LocalDate.parse(txfSpilleDato.getText()),
						LocalTime.parse(txfSpilleTid.getText()));
				updateKampListe();
			} catch (DateTimeParseException e) {
				// TODO: handle exception
				System.out.println("Fejl i formatering af dato eller tid " + e.getMessage());
			}
		}
	}

	private void updateKampListe() {
		lvKampe.getItems().setAll(Storage.getKampe());
	}
}
