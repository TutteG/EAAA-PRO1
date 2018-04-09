package exercise3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	int windowX = 200;
	int windowY = 200;

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(windowX, windowY);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		double x1 = windowX / 10;
		// start point: (x1,y1)
		double y1 = windowY / 10;
		double x2 = windowX / 10;
		// end point: (x2,y2)
		double y2 = windowY / 1.1;
		while (x2 <= windowX / 0.9) {
			gc.strokeLine(x1, y1, x2, y2);
			x2 += windowX / 5;
			x1 += windowX / 5;
			x1 += -windowX * 0.9 / 9;
		}
	}

	/*
	 * private void drawShapes(GraphicsContext gc) { double x1 = windowX /
	 * 2.222222222222222; // start point: (x1,y1) double y1 = windowY / 10; double
	 * x2 = windowX / 1.1818181818181818; // end point: (x2,y2) double y2 = windowY
	 * / 10; while (y2 <= windowX / 0.9) { gc.strokeLine(x1, y1, x2, y2); y2 +=
	 * windowX / 5; y1 += windowX / 5; x1 -= windowX / 1.1; x2 += windowX / 1.1; //
	 * x1 += -windowX * 0.9 / 9; }
	 *
	 * }
	 */}
