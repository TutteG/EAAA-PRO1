package exercise2;

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

	int windowX = 600;
	int windowY = 800;

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
		int x1 = windowX / 2; // start point: (x1,y1)
		int y1 = windowY / 2;
		int x2 = windowX / 10; // end point: (x2,y2)
		int y2 = windowY / 20;
		while (x2 <= windowX * 0.9) {
			gc.strokeLine(x1, y1, x2, y2);
			x2 += windowX * 0.9 / 9;
			// x1 += -windowX * 0.9 / 9;
		}
	}

}
