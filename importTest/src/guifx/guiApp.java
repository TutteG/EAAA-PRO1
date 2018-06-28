package guifx;

import application.model.PraktikVirksomhed;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

public class guiApp extends Application {
	public static void main(String[] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Administration af praktikvirksomheder");
		BorderPane pane = new BorderPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setMinHeight(160);
		stage.setMinWidth(330);
		stage.show();
	}

	private void initContent(BorderPane pane) {
		Service.initStorage();
		// skrivTilFil køres fra service, da jeg ikke har et objekt af virksomhed her.
		// sorterKontrakter testes også fra Service
		// getTotalAntalUgentligeTimer testes fra Service
		// getEfterTragtetVirksomhed testes fra Service
		GridPane gridPane = new GridPane();
		initGridPane(gridPane);
		pane.setCenter(gridPane);
		pane.setPadding(new Insets(10));
	}

	private Label lblNavn, lblFeedback, lblKontakt, lblPraktiksVirksomhed, lblPraktikVirksomheder;
	private Button btnAdd, btnUpdate;
	private VBox vbButtons;
	private TextField txfNavn, txfFeedback, txfKontakt;
	private ListView<PraktikVirksomhed> lvPraktikVirksomheder;

	private void initGridPane(GridPane gridPane) {
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setGridLinesVisible(false);

		// --------------------Collumn 0-----------------//
		lblNavn = new Label("Navn:");
		gridPane.add(lblNavn, 0, 1);

		lblFeedback = new Label("Feedback");
		gridPane.add(lblFeedback, 0, 2);

		lblKontakt = new Label("Kontakt");
		gridPane.add(lblKontakt, 0, 3);

		vbButtons = new VBox();
		gridPane.add(vbButtons, 0, 5);

		btnAdd = GUITools.stdButton("Add");
		vbButtons.getChildren().add(btnAdd);

		btnAdd.setOnAction(event -> this.addVirksomhed());

		btnUpdate = GUITools.stdButton("Update");
		vbButtons.getChildren().add(btnUpdate);

		btnUpdate.setOnAction(event -> this.updateVirksomhed());
		// --------------------Collumn 1-----------------//
		lblPraktiksVirksomhed = new Label("Praktikvirksomhed");
		gridPane.add(lblPraktiksVirksomhed, 1, 0);

		txfNavn = GUITools.stdTextField();
		gridPane.add(txfNavn, 1, 1);

		txfFeedback = GUITools.stdTextField();
		gridPane.add(txfFeedback, 1, 2);

		txfKontakt = GUITools.stdTextField();
		gridPane.add(txfKontakt, 1, 3);

		// --------------------Collumn 2-----------------//
		lblPraktikVirksomheder = new Label("Praktikvirksomheder");
		gridPane.add(lblPraktikVirksomheder, 2, 0);

		lvPraktikVirksomheder = new ListView<PraktikVirksomhed>();
		lvPraktikVirksomheder.getItems().addAll(Storage.getPraktikVirksomheder());
		gridPane.add(lvPraktikVirksomheder, 2, 1, 1, 5);
		ChangeListener<PraktikVirksomhed> praktikListener = (ov, oldValue, newValue) -> this
				.selectedPraktikPladsChanged();
		lvPraktikVirksomheder.getSelectionModel().selectedItemProperty().addListener(praktikListener);
	}

	private void updateVirksomhed() {
		// TODO Auto-generated method stub
		try {
			if (txfNavn.getText().length() > 0 && txfFeedback.getText().length() > 0
					&& txfKontakt.getText().length() > 0) {
				lvPraktikVirksomheder.getSelectionModel().getSelectedItem().setNavn(txfNavn.getText());
				lvPraktikVirksomheder.getSelectionModel().getSelectedItem().setFeedback(txfFeedback.getText());
				lvPraktikVirksomheder.getSelectionModel().getSelectedItem().setKontaktperson(txfKontakt.getText());
				lvPraktikVirksomheder.getItems().setAll(Storage.getPraktikVirksomheder());

			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl");
			alert.setContentText("Vælg venligst en virksomhed fra listen");
			alert.showAndWait();

		}

	}

	private void addVirksomhed() {
		if (txfNavn.getText().length() > 0 && txfFeedback.getText().length() > 0 && txfKontakt.getText().length() > 0) {

			Service.createPraktikVirksomhed(txfNavn.getText(), txfFeedback.getText(), txfKontakt.getText());
			lvPraktikVirksomheder.getItems().setAll(Storage.getPraktikVirksomheder());
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Fejl");
			alert.setContentText("Udfyld venligst alle tekstfelter");
			alert.showAndWait();
		}
	}

	private void selectedPraktikPladsChanged() {
		// TODO Auto-generated method stub
		PraktikVirksomhed praktikVirksomhed = lvPraktikVirksomheder.getSelectionModel().getSelectedItem();
		if (praktikVirksomhed != null) {
			txfNavn.setText(praktikVirksomhed.getNavn());
			txfFeedback.setText(praktikVirksomhed.getFeedback());
			txfKontakt.setText(praktikVirksomhed.getKontaktperson());
		} else {
			txfNavn.clear();
			txfFeedback.clear();
			txfKontakt.clear();
		}
	}
}
