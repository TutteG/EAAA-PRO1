package Opgave3Og4INoten;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Pane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("\\\\ Det Lille Hus På Prærien \\\\");
		stage.setScene(scene);
		stage.show();
	}

	private Pane initContent() {
		Pane pane = new Pane();
		pane.setPrefSize(400, 400);
		// Ændre baggrundsfarven senere

		this.drawShapes(pane);
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(Pane pane) {

		Rectangle airBase = new Rectangle(0, 0, 400, 300);
		pane.getChildren().add(airBase);
		airBase.setFill(Color.ANTIQUEWHITE);
		airBase.setStroke(Color.BLACK);

		Rectangle groundBase = new Rectangle(0, 300, 400, 100);
		pane.getChildren().add(groundBase);
		groundBase.setFill(Color.GREENYELLOW);
		groundBase.setStroke(Color.BLACK);

		Rectangle houseBase = new Rectangle(40, 230, 150, 150);
		pane.getChildren().add(houseBase);
		houseBase.setFill(Color.BURLYWOOD);

		Circle sun = new Circle(300, 100, 30);
		pane.getChildren().add(sun);
		sun.setFill(Color.YELLOW);
		sun.setStroke(Color.BLACK);

		Rectangle houseChimney = new Rectangle(85, 150, 10, 30);
		pane.getChildren().add(houseChimney);
		houseChimney.setFill(Color.BROWN);

		Polygon houseRoof = new Polygon();
		houseRoof.getPoints().addAll(new Double[] { 35.0, 230.0, 115.0, 130.0, 195.0, 230.0 });
		pane.getChildren().add(houseRoof);
		houseRoof.setFill(Color.DARKBLUE);

		Rectangle houseWindow = new Rectangle(60, 290, 30, 30);
		pane.getChildren().add(houseWindow);
		houseWindow.setFill(Color.AZURE);
		houseWindow.setStroke(Color.BLACK);

		Line windowLine1 = new Line(90, 305, 60, 305);
		pane.getChildren().add(windowLine1);
		windowLine1.setFill(Color.BLACK);

		Line windowLine2 = new Line(75, 290, 75, 320);
		pane.getChildren().add(windowLine2);
		windowLine2.setFill(Color.BLACK);

		Rectangle houseDoor = new Rectangle(120, 290, 40, 90);
		pane.getChildren().add(houseDoor);
		houseDoor.setFill(Color.BROWN);

		Circle doorknob = new Circle(130, 330, 2);
		pane.getChildren().add(doorknob);
		doorknob.setFill(Color.BLACK);
		doorknob.setStroke(Color.BLACK);

		/*
		 * Circle circle2 = new Circle(xCoor, yCoor, middleRadius);
		 * pane.getChildren().add(circle2); circle2.setFill(Color.WHITE);
		 * circle2.setStroke(Color.BLACK); circle2.setStrokeWidth(strokeWidth);
		 *
		 * Circle circle1 = new Circle(xCoor, yCoor, innerRadius);
		 * pane.getChildren().add(circle1); circle1.setFill(Color.WHITE);
		 * circle1.setStroke(Color.BLACK); circle1.setStrokeWidth(strokeWidth);
		 */
	}
}
