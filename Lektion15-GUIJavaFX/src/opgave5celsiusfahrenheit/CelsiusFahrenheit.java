package opgave5celsiusfahrenheit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CelsiusFahrenheit extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("FUCK OFF!");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private Controller controller = new Controller();
	Button buttonUp = new Button();
	TextField number = new TextField();
	private boolean fahrenheit = false;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		pane.add(number, 0, 0, 2, 1);
		pane.add(buttonUp, 0, 2);

		buttonUp.setText("Convert");

		buttonUp.setOnAction(event -> this.convert());

	}

	private void convert() {
		double newnumber = Double.parseDouble(number.getText());
		if (!fahrenheit) {
			number.setText("" + ((newnumber * 1.8) + 32));
			fahrenheit = true;
		} else {

			number.setText("" + ((newnumber - 32) / 1.8));
			fahrenheit = false;
		}
	}

	/**
	 * This class controls access to the model in this application. In this case,
	 * the model is a single Student object.
	 */
	private class Controller {
	}

}
