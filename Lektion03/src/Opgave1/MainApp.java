package Opgave1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle; // Circle library
import javafx.scene.shape.Line; // Line library
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Pane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Shapes");
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

		// Make a circle object.
		Circle circle = new Circle(70, 70, 30);
		pane.getChildren().add(circle);
		circle.setFill(Color.BURLYWOOD);
		circle.setStroke(Color.BLACK);

		// Make a line object.
		Line line1 = new Line(200, 250, 100, 10);
		pane.getChildren().add(line1);
		line1.setFill(Color.BISQUE);
		line1.setStroke(Color.BROWN);
	}
}
