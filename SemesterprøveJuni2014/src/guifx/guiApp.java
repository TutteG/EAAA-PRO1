package guifx;

import application.model.Gæst;
import application.service.Service;
import javafx.application.Application;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import storage.Storage;

public class guiApp extends Application {
	public static void main(String[] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Hotel Bestillinger");
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

	ListView<String> lvIkkeBetalteBestillinger;
	ListView<Gæst> lvGæster;
	Label lblGæster, lblGæst, lblVærelse, lblIkkeBetalteBestillinger;
	Button btnOpret, btnOpdater, btnVis;
	TextField txfGæsteNavn, txfVærelsesNummer;
	HBox HbOpretOpdater;

	private void initGridPane(GridPane gridPane) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setGridLinesVisible(false);

		// --------------------Collumn 0-----------------//
		lblGæster = new Label("Gæster:");
		gridPane.add(lblGæster, 0, 0);

		lvGæster = new ListView<Gæst>();
		lvGæster.getItems().setAll(Service.getGæster());
		lvGæster.setMinHeight(300);
		gridPane.add(lvGæster, 0, 1, 1, 4);

		// --------------------Collumn 1-----------------//
		lblGæst = new Label("Gæst:");
		gridPane.add(lblGæst, 1, 0);

		lblVærelse = new Label("Værelse:");
		gridPane.add(lblVærelse, 1, 1);

		lblIkkeBetalteBestillinger = new Label("Ikke betalte bestillinger:");
		gridPane.add(lblIkkeBetalteBestillinger, 1, 3);

		// --------------------Collumn 2-----------------//
		txfGæsteNavn = GUITools.stdTextField();
		gridPane.add(txfGæsteNavn, 2, 0, 2, 1);

		txfVærelsesNummer = new TextField();
		txfVærelsesNummer.setMaxWidth(50);
		gridPane.add(txfVærelsesNummer, 2, 1);
		HbOpretOpdater = new HBox();

		btnOpret = GUITools.stdButton("Opret");
		HbOpretOpdater.getChildren().add(btnOpret);
		btnOpdater = GUITools.stdButton("Opdater");
		HbOpretOpdater.getChildren().add(btnOpdater);

		gridPane.add(HbOpretOpdater, 2, 2);

		btnVis = GUITools.stdButton("Vis");
		gridPane.add(btnVis, 2, 3);

		// --------------------Collumn 3-----------------//
		lvIkkeBetalteBestillinger = new ListView<String>();
		gridPane.add(lvIkkeBetalteBestillinger, 2, 4);

		// -----------------Eventhandlers----------------//

		btnOpret.setOnAction(event -> addGuest());
		btnOpdater.setOnAction(event -> updateGuest());
		btnVis.setOnAction(event -> showGuest());

	}

	private void addGuest() {
		try {
			System.out.println(Storage.getGæster());
			if (txfGæsteNavn.getText().length() > 0 || txfVærelsesNummer.getText().length() > 0) {
				Service.createGæst(txfGæsteNavn.getText(), Integer.parseInt(txfVærelsesNummer.getText()));
				lvGæster.getItems().setAll(Service.getGæster());
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Nullpointer Exception");
			alert.setContentText("Skriv venligst et tal i værelsesnummer - " + e.getMessage());
			alert.showAndWait();
		}
	}

	private void updateGuest() {
		try {
			if (txfGæsteNavn.getText().length() > 0 || txfVærelsesNummer.getText().length() > 0) {
				Service.updateGæst(txfGæsteNavn.getText(), Integer.parseInt(txfVærelsesNummer.getText()),
						lvGæster.getSelectionModel().getSelectedItem());
				lvGæster.getItems().setAll(Service.getGæster());
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Nullpointer Exception");
			alert.setContentText("Skriv venligst et tal i værelsesnummer - " + e.getMessage());
			alert.showAndWait();
		}
	}

	private void showGuest() {
		try {
			lvIkkeBetalteBestillinger.getItems()
					.setAll(lvGæster.getSelectionModel().getSelectedItem().ikkeBetalteBestillinger());
		} catch (NullPointerException e) {
			// TODO: handle exception
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Nullpointer Exception");
			alert.setContentText("Vælg venligst en gæst fra listen - " + e.getMessage());
			alert.showAndWait();
		}
	}
}
