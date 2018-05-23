package opgave3;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage {
	public PersonInputWindow(String title, Stage owner) {
		this.initOwner(owner);
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setMinHeight(100);
		this.setMinWidth(200);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	private Label lblName;
	private Label lblTitle;
	private Label lblPeople;
	private TextField txfName;
	private TextField txfTitle;
	private CheckBox chbxSenior = new CheckBox();
	private Person person;
	private Alert alarm;
	private Button btnOK;
	private Button btnCancel;
	// private PersonAdministrationSystem psnAdmin = new
	// PersonAdministrationSystem();

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		lblName = new Label("Name: ");
		pane.add(lblName, 0, 0);
		txfName = new TextField();
		pane.add(txfName, 1, 0, 4, 1);

		lblTitle = new Label("Title: ");
		pane.add(lblTitle, 0, 1);
		txfTitle = new TextField();
		pane.add(txfTitle, 1, 1, 4, 1);

		// Indsæt checkbox
		chbxSenior = new CheckBox("Senior");
		pane.add(chbxSenior, 0, 3);

		lblPeople = new Label("People:");
		pane.add(lblPeople, 0, 4);

		btnOK = new Button("OK");
		pane.add(btnOK, 0, 0);

		btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 1);

		btnOK.setOnAction(event -> addPerson());
		btnCancel.setOnAction(event -> closeWindow());

	}

	public Person addPerson() {

		if (txfName.getText().length() > 0 && txfTitle.getText().length() > 0) {
			person = new Person(txfName.getText(), txfTitle.getText(), chbxSenior.isSelected());
			this.close();
			return person;

		} else {
			alarm = new Alert(AlertType.WARNING);
			alarm.setTitle("Information Error");
			alarm.setContentText("udfyld venligst alle informationer!");
			alarm.showAndWait();
		}
		return null;
	}

	public void closeWindow() {
		this.close();
	}
}
