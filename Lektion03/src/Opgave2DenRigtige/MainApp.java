package Opgave2DenRigtige;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Pane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Opgave 2 den rigtige");
		stage.setScene(scene);
		stage.show();
	}

	private Pane initContent() {
		Pane pane = new Pane();
		pane.setPrefSize(400, 400);
		this.drawShapes(pane);
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(Pane pane) {
		// Variable
		// Preferred coordinates of box
		int xCoor = 100;
		int yCoor = 100;

		// String name
		String name = "Solo Jan";

		Rectangle rectangle = new Rectangle(xCoor, yCoor, 200, 80);
		pane.getChildren().add(rectangle);
		rectangle.setStroke(Color.CORAL);
		rectangle.setFill(Color.ALICEBLUE);
		Text nameText = new Text(name);
		nameText.setScaleX(2);
		nameText.setScaleY(2);
		nameText.setLayoutX(150);
		nameText.setLayoutY(150);

		pane.getChildren().add(nameText);

		/*
		 * // Make a circle object. Circle circle = new Circle(xCoor, yCoor, 100);
		 * pane.getChildren().add(circle); circle.setFill(Color.BURLYWOOD);
		 * circle.setStroke(Color.BLACK);
		 *
		 * // Make a line object. Line line1 = new Line(xCoor, yCoor, 100, 10);
		 * pane.getChildren().add(line1); line1.setFill(Color.BISQUE);
		 * line1.setStroke(Color.BROWN);
		 */
	}
}
