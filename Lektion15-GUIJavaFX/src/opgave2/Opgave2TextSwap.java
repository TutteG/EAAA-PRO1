package opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave2TextSwap extends Application {

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

	// private Controller controller = new Controller();
	Button swap = new Button();
	TextField firstText = new TextField();
	TextField lastText = new TextField();

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		pane.add(firstText, 0, 0);
		pane.add(lastText, 0, 1);
		pane.add(swap, 0, 3);
		swap.setText("Swap");

		swap.setOnAction(event -> this.swapText());
	}

	private void swapText() {
		String text1 = lastText.getText();
		lastText.setText(firstText.getText());
		firstText.setText(text1);

	}

	/**
	 * This class controls access to the model in this application. In this case,
	 * the model is a single Student object.
	 */
	// private class Controller {
	// }

}
