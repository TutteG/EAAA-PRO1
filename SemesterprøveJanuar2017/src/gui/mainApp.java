package gui;

import application.model.Område;
import application.model.Plads;
import application.service.Service;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

public class mainApp extends Application {
	public static void main(String[] args) {
		Service.initStorage();
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		GridPane gridPane = new GridPane();
		initGridPane(gridPane);
		pane.setCenter(gridPane);
		pane.setPadding(new Insets(10));
	}

	Label lblPladser, lblOmråde, lblNummer, lblFundetPlads;
	RadioButton rdbtnSTANDARD, rdbtnVIP, rdbtnBØRNE, rdbtnTURNERING;
	ListView<Plads> lvwPladser;
	Button btnOpretPlads, btnFindPlads;
	TextField txfNummer, txfFundetPlads;
	VBox vbRadioButtons;

	private void initGridPane(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setGridLinesVisible(false);

		// --------------------Collumn 0-----------------//
		lblPladser = new Label("Pladser:");
		gridPane.add(lblPladser, 0, 0);

		lvwPladser = new ListView<Plads>();
		lvwPladser.getItems().setAll(Storage.getPladser());
		gridPane.add(lvwPladser, 0, 1, 2, 1);

		lblOmråde = new Label("Område:");
		gridPane.add(lblOmråde, 0, 2);

		lblNummer = new Label("Nummer:");
		gridPane.add(lblNummer, 0, 3);

		lblFundetPlads = new Label("Fundet plads:");
		gridPane.add(lblFundetPlads, 0, 4);

		// --------------------Collumn 1-----------------//
		rdbtnSTANDARD = new RadioButton(Område.STANDARD.toString());
		rdbtnVIP = new RadioButton(Område.VIP.toString());
		rdbtnBØRNE = new RadioButton(Område.BØRNE.toString());
		rdbtnTURNERING = new RadioButton(Område.TURNERING.toString());

		vbRadioButtons = new VBox();
		vbRadioButtons.getChildren().add(rdbtnSTANDARD);
		vbRadioButtons.getChildren().add(rdbtnVIP);
		vbRadioButtons.getChildren().add(rdbtnBØRNE);
		vbRadioButtons.getChildren().add(rdbtnTURNERING);
		gridPane.add(vbRadioButtons, 1, 2);

		txfNummer = GUITools.stdTextField();
		gridPane.add(txfNummer, 1, 3);

		txfFundetPlads = GUITools.stdTextField();
		gridPane.add(txfFundetPlads, 1, 4);

		// --------------------Collumn 2-----------------//
		btnOpretPlads = GUITools.stdButton("Opret Plads");
		gridPane.add(btnOpretPlads, 2, 1);
		btnOpretPlads.setOnAction(event -> opretPladsAction());

		btnFindPlads = GUITools.stdButton("Find Plads");
		gridPane.add(btnFindPlads, 2, 3);
		btnFindPlads.setOnAction(event -> findPladsAction());
	}

	private void findPladsAction() {
		// TODO Auto-generated method stub
		try {
			if (rdbtnSTANDARD.isSelected()) {
				Plads plads = Service.findPlads(Område.STANDARD, Integer.parseInt(txfNummer.getText()));
				txfFundetPlads.setText("" + plads.getNr());

			} else if (rdbtnVIP.isSelected()) {
				Plads plads = Service.findPlads(Område.VIP, Integer.parseInt(txfNummer.getText()));
				txfFundetPlads.setText(plads.getNr() + "");
			} else if (rdbtnBØRNE.isSelected()) {
				Plads plads = Service.findPlads(Område.BØRNE, Integer.parseInt(txfNummer.getText()));
				txfFundetPlads.setText(plads.getNr() + "");
			} else if (rdbtnTURNERING.isSelected()) {
				Plads plads = Service.findPlads(Område.TURNERING, Integer.parseInt(txfNummer.getText()));
				txfFundetPlads.setText("" + plads.getNr());
			} else {
				// do nothing
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Objektet kan ikke findes " + e.getMessage());

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Skriv venligst et pladsnummer ind i textfeltet");
		}

	}

	private void opretPladsAction() {
		// TODO Auto-generated method stub
		OpretPlads opretPlads = new OpretPlads();
		opretPlads.showAndWait();
		lvwPladser.getItems().setAll(Storage.getPladser());
	}
}
