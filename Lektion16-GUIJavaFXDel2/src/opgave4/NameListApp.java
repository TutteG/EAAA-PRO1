package opgave4;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NameListApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Namel List App");
		GridPane pane = new GridPane();
		this.initContent(pane);
		pane.setPrefSize(425, 200);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private Button btnAddPerson;
	private ListView<Person> lstvPerson;
	private ArrayList<Person> arrPerson = new ArrayList<Person>();
	private Person person;
	private Alert alarm;
	private TextField txfName;
	private Label lblName;
	private Label lblNames;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// indsæt labels
		lblName = new Label("Name:");
		lblNames = new Label("Names:");

		pane.add(lblName, 0, 0);
		pane.add(lblNames, 0, 2);
		// Indsæt listview
		lstvPerson = new ListView<>();
		pane.add(lstvPerson, 1, 0);

		// indsæt textfield
		txfName = new TextField();
		pane.add(txfName, 1, 2);

		// indsæt button
		btnAddPerson = new Button("Add Name");
		pane.add(btnAddPerson, 2, 2);

		btnAddPerson.setOnAction(event -> this.addName());
		txfName.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				this.addName();
			}
		});
	}

	public void addName() {
		if (!txfName.getText().isEmpty()) {
			person = new Person(txfName.getText(), true);

			arrPerson.add(person);
			lstvPerson.getItems().setAll(arrPerson);
			txfName.clear();
		} else {
			alarm = new Alert(AlertType.WARNING, "Please input a name!");
			alarm.showAndWait();
		}
	}

}
