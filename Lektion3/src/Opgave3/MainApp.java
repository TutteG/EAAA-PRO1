package Opgave3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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

		int eyeRadius = 10;

		Circle faceCircle = new Circle(xCoor, yCoor, 100);
		pane.getChildren().add(faceCircle);
		faceCircle.setFill(Color.CORAL);
		faceCircle.setStroke(Color.BLACK);

		Circle leftEyeCircle = new Circle(170, 170, eyeRadius);
		pane.getChildren().add(leftEyeCircle);
		leftEyeCircle.setFill(Color.BLACK);
		leftEyeCircle.setStroke(Color.BLACK);

		Circle rightEyeCircle = new Circle(230, 170, eyeRadius);
		pane.getChildren().add(rightEyeCircle);
		rightEyeCircle.setFill(Color.BLACK);
		rightEyeCircle.setStroke(Color.BLACK);

		Line smilet = new Line(150, 220, 250, 220);
		pane.getChildren().add(smilet);
		smilet.setFill(Color.BLACK);
		smilet.setStroke(Color.BLACK);

	}
}
