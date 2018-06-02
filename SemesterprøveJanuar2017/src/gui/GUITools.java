package gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GUITools {
	public static final double WIDTH = 190;
	public static final double MINWIDTH = 70;

	public static Button stdButton(String tekst) {
		Button btn = new Button(tekst);
		btn.setMinWidth(MINWIDTH);
		return btn;

	}

	public static TextField stdTextField() {
		TextField txf = new TextField();
		txf.setMinWidth(WIDTH);
		txf.setMaxWidth(WIDTH);

		return txf;
	}
}
