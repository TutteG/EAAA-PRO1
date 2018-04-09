package opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class opgave3counter extends Application {

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

	Button buttonUp = new Button();
	Button buttonDown = new Button();
	TextField number = new TextField();

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		pane.add(number, 0, 0, 2, 1);
		pane.add(buttonUp, 0, 2);
		pane.add(buttonDown, 1, 2);
		buttonUp.setText("Up");
		buttonDown.setText("Down");

		buttonUp.setOnAction(event -> this.addition());
		buttonDown.setOnAction(event -> this.subtraction());

	}

	private void addition() {
		if (number.getText().length() > 0) {
			try {
				int newnumber = Integer.parseInt(number.getText());
				newnumber++;
				number.setText("" + newnumber);

			} catch (NumberFormatException e) {
				// TODO: handle exception
				number.setText("Input a number please");
			}
		} else {
			number.setText("1");
		}

	}

	private void subtraction() {
		if (number.getText().length() > 0) {
			try {
				int newnumber = Integer.parseInt(number.getText());
				newnumber--;
				number.setText("" + newnumber);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				number.setText("Input a number please");
			}
		} else {
			number.setText("-1");
		}

	}

}
