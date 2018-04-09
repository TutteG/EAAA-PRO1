package Opgave4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Pane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Her skal være en smiley");
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
		// Start koordinater
		int xCoor = 200;
		int yCoor = 200;

		int innerRadius = 10;
		int middleRadius = 50;
		int outerRadius = 90;
		int strokeWidth = 20;

		Circle circle3 = new Circle(xCoor, yCoor, outerRadius);
		pane.getChildren().add(circle3);
		circle3.setFill(Color.WHITE);
		circle3.setStroke(Color.BLACK);
		circle3.setStrokeWidth(strokeWidth);

		Circle circle2 = new Circle(xCoor, yCoor, middleRadius);
		pane.getChildren().add(circle2);
		circle2.setFill(Color.WHITE);
		circle2.setStroke(Color.BLACK);
		circle2.setStrokeWidth(strokeWidth);

		Circle circle1 = new Circle(xCoor, yCoor, innerRadius);
		pane.getChildren().add(circle1);
		circle1.setFill(Color.WHITE);
		circle1.setStroke(Color.BLACK);
		circle1.setStrokeWidth(strokeWidth);
	}
}
