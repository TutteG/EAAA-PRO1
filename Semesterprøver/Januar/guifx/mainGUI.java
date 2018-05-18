package guifx;

import application.model.Kamp;
import application.service.Service;
import javafx.application.Application;
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
		lvKampe.getItems().setAll(Storage.getKampe());
		gridPane.add(lvKampe, 0, 1, 1, 4);

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

		gridPane.add(txfSpilleSted, 2, 0, 2, 1);
		gridPane.add(txfSpilleDato, 2, 1, 2, 1);
		gridPane.add(txfSpilleTid, 2, 2, 2, 1);
		gridPane.add(btnOpret, 2, 3);
		gridPane.add(btnLavFil, 2, 4);

		// --------------------Collumn 3-----------------//
		btnOpdater = GUITools.stdButton("Opdater");
		gridPane.add(btnOpdater, 3, 3);
	}
}
