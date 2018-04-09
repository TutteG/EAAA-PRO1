package opgave1combinenames;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Opgave1FirstAndLastName extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Student Administration");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private Controller controller = new Controller();
	Button combine = new Button();
	Text firstName = new Text();
	Text lastName = new Text();
	TextField inFirstName = new TextField();
	TextField inLastName = new TextField();
	TextField combinedName = new TextField();

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		pane.add(firstName, 0, 0);
		pane.add(lastName, 2, 0);
		pane.add(inFirstName, 0, 1);
		pane.add(inLastName, 2, 1);
		pane.add(combinedName, 0, 2, 3, 1);
		pane.add(combine, 0, 3);
		combine.setText("Combine");
		firstName.setText("First name:");
		lastName.setText("Last name:");

		combine.setOnAction(event -> this.combineNames());
	}

	private void combineNames() {
		String combinedName = inFirstName.getText() + " " + inLastName.getText();
		this.combinedName.setText(combinedName);
	}

	/**
	 * This class controls access to the model in this application. In this case,
	 * the model is a single Student object.
	 */
	private class Controller {
	}

}
