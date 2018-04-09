package opgave5;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
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
		pane.setPrefSize(350, 200);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private RadioButton rbtnBoys;
	private RadioButton rbtnGirls;
	private Button btnAddPerson;
	private ListView<Person> lstvPersons;
	private ArrayList<Person> arrPersonsBoys = new ArrayList<Person>();
	private ArrayList<Person> arrPersonsGirls = new ArrayList<Person>();
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
		// indsæt radiobuttons
		rbtnBoys = new RadioButton("Boys");
		rbtnGirls = new RadioButton("Girls");

		pane.add(rbtnBoys, 1, 0);
		pane.add(rbtnGirls, 2, 0);
		rbtnBoys.setSelected(true);

		// indsæt labels
		lblName = new Label("Name:");
		lblNames = new Label("Names:");

		pane.add(lblName, 0, 1);
		pane.add(lblNames, 0, 3);
		// Indsæt listview
		lstvPersons = new ListView<>();

		pane.add(lstvPersons, 1, 1, 4, 2);

		// indsæt textfield
		txfName = new TextField();
		pane.add(txfName, 1, 3);

		// indsæt button
		btnAddPerson = new Button("Add Name");
		pane.add(btnAddPerson, 2, 3);

		rbtnBoys.setOnAction(event -> this.boysTriggered());
		rbtnGirls.setOnAction(event -> this.girlsTriggered());
		btnAddPerson.setOnAction(event -> this.addName());
		txfName.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				this.addName();
			}
		});
	}

	public void addName() {
		if (!txfName.getText().isEmpty()) {
			if (rbtnBoys.isSelected()) {
				person = new Person(txfName.getText(), true);

				arrPersonsBoys.add(person);
				lstvPersons.getItems().setAll(arrPersonsBoys);
			} else if (rbtnGirls.isSelected()) {
				person = new Person(txfName.getText(), false);

				arrPersonsGirls.add(person);
				lstvPersons.getItems().setAll(arrPersonsGirls);
			}

			txfName.clear();
		} else {
			alarm = new Alert(AlertType.WARNING, "Please input a name!");
			alarm.showAndWait();
		}
	}

	private void boysTriggered() {
		rbtnBoys.setSelected(true);
		rbtnGirls.setSelected(false);
		switchList();
	}

	private void girlsTriggered() {
		rbtnGirls.setSelected(true);
		rbtnBoys.setSelected(false);
		switchList();
	}

	private void switchList() {
		if (rbtnBoys.isSelected() && !arrPersonsBoys.isEmpty()) {
			lstvPersons.getItems().setAll(arrPersonsBoys);
		} else if (rbtnGirls.isSelected() && !arrPersonsGirls.isEmpty()) {
			lstvPersons.getItems().setAll(arrPersonsGirls);
		}
		// else do nothing
	}

}
