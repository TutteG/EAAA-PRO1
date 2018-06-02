package gui;

import application.model.Område;
import application.service.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OpretPlads extends Stage {
	GridPane gridPane = new GridPane();

	public OpretPlads() {
		// TODO Auto-generated constructor stub
		Scene scene = new Scene(gridPane);
		this.setScene(scene);
		this.initContent(gridPane);
	}

	Label lblNummer, lblKonsoltype;
	TextField txfNummer, txfType;
	CheckBox chbSpillekonsol;
	Button btnCancel, btnOk;

	private void initContent(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// --------------------Collumn 0-----------------//
		lblNummer = new Label("Nummer");
		gridPane.add(lblNummer, 0, 0);

		// --------------------Collumn 1-----------------//
		txfNummer = GUITools.stdTextField();
		gridPane.add(txfNummer, 1, 0, 3, 1);

		chbSpillekonsol = new CheckBox("Med Spillekonsol");
		gridPane.add(chbSpillekonsol, 1, 1);

		lblKonsoltype = new Label("Konsoltype:");
		gridPane.add(lblKonsoltype, 1, 2);

		btnCancel = GUITools.stdButton("Cancel");
		gridPane.add(btnCancel, 1, 3);
		btnCancel.setOnAction(event -> this.close());

		// --------------------Collumn 2-----------------//
		txfType = GUITools.stdTextField();
		gridPane.add(txfType, 2, 2);
		btnOk = GUITools.stdButton("OK");
		gridPane.add(btnOk, 2, 3);
		btnOk.setOnAction(event -> opretPladsEvent());

	}

	private void opretPladsEvent() {
		// TODO Auto-generated method stub
		try {
			if (!chbSpillekonsol.isSelected()) {
				Service.createPlads(Integer.parseInt(txfNummer.getText()), Område.STANDARD);
			} else {
				Service.createKonsolplads(Integer.parseInt(txfNummer.getText()), Område.STANDARD, txfType.getText());
			}
			this.close();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Skriv venligst et tal i nummer boksen");
		}
	}
}
