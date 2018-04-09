package opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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

		pInWin = new PersonInputWindow("Tilføj Person", stage);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// private Label lblName;
	// private Label lblTitle;
	// private Label lblPeople;
	// private TextField txfName;
	// private TextField txfTitle;
	private Button btnAddPerson;
	// private CheckBox chbxSenior = new CheckBox();
	private ListView<Person> lstvPerson;
	private Person person;
	private Alert alarm;
	private Button btnOK;
	private Button btnCancel;
	private PersonInputWindow pInWin;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		btnAddPerson = new Button("Add Person");
		pane.add(btnAddPerson, 4, 3);

		// Indsæt listview
		lstvPerson = new ListView<>();
		pane.add(lstvPerson, 1, 4, 4, 1);

		btnAddPerson.setOnAction(event -> this.addPersonWindow());
	}

	public void addPersonWindow() {

		pInWin.showAndWait();
		if (pInWin.addPerson() != null) {
			lstvPerson.getItems().add(pInWin.addPerson());
		}
		// else nothing
	}

}
