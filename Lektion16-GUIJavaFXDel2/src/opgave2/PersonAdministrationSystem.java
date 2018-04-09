package opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PersonAdministrationSystem extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Radiobutton Demo");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private Label lblName;
	private Label lblTitle;
	private Label lblPeople;
	private TextField txfName;
	private TextField txfTitle;
	private Button btnAddPerson;
	private CheckBox chbxSenior = new CheckBox();
	private ListView<Person> lstvPerson;
	private Person person;
	private Alert alarm;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
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

		btnAddPerson = new Button("Add Person");
		pane.add(btnAddPerson, 4, 3);

		lblPeople = new Label("People:");
		pane.add(lblPeople, 0, 4);

		// Indsæt listview
		lstvPerson = new ListView<>();
		pane.add(lstvPerson, 1, 4, 4, 1);

		btnAddPerson.setOnAction(event -> addPerson());
	}

	public void addPerson() {
		if (txfName.getText().length() > 0 && txfTitle.getText().length() > 0) {
			person = new Person(txfName.getText(), txfTitle.getText(), chbxSenior.isSelected());
			lstvPerson.getItems().add(person);
		} else {
			alarm = new Alert(AlertType.WARNING);
			alarm.setTitle("Information Error");
			alarm.setContentText("udfyld venligst alle informationer!");
			alarm.showAndWait();
		}

	}
}
