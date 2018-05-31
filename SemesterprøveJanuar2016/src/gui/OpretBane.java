package gui;

import application.service.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OpretBane extends Stage {
	GridPane gridPane = new GridPane();

	public OpretBane() {
		// TODO Auto-generated constructor stub
		Scene scene = new Scene(gridPane);
		this.setScene(scene);
		this.initContent(gridPane);
	}

	Label lblNummer, lblInfo;
	TextField txfNummer, txfInfo;
	Button btnCancel, btnOk;

	private void initContent(GridPane gridPane) {
		// TODO Auto-generated method stub
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		// --------------------Collumn 0-----------------//
		lblNummer = new Label("Nummer:");
		gridPane.add(lblNummer, 0, 0);

		lblInfo = new Label("Info:");
		gridPane.add(lblInfo, 0, 1);

		btnCancel = GUITools.stdButton("Cancel");
		btnCancel.setOnAction(event -> close());
		gridPane.add(btnCancel, 0, 2);
		// --------------------Collumn 1-----------------//
		btnOk = GUITools.stdButton("OK");
		btnOk.setOnAction(event -> opretBane());
		gridPane.add(btnOk, 1, 2);
		// --------------------Collumn 2-----------------//

		txfNummer = GUITools.stdTextField();
		gridPane.add(txfNummer, 2, 0);

		txfInfo = GUITools.stdTextField();
		gridPane.add(txfInfo, 2, 1);
	}

	private void opretBane() {
		// TODO Auto-generated method stub
		try {
			if (txfNummer.getText().length() > 0 && txfInfo.getText().length() > 0) {
				Service.createBane(Integer.parseInt(txfNummer.getText()), txfInfo.getText());
				this.close();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Udfyld venligst banenumret med et tal");
			System.out.println(e.getMessage());
		}
	}
}
