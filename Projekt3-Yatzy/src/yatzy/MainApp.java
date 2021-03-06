package yatzy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Torben Grove Nielsen & Rasmus Træholt
 *
 */
public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	/**
	 * Initialize Yatzy window
	 */
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------
	// The Yatzy game object
	private Yatzy yatzy = new Yatzy();
	// Shows the face values of the 5 dice.
	private TextField[] txfValues;
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds;
	private TextField[] txfResults;
	private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
	private Label lblRolled;
	private Button btnRoll;
	private Label[] lblScore;
	private String[] stringScore;

	private Alert gameOver;

	private boolean[] disableResult;
	private boolean bonusAchieved;
	int gameOverCount;

	/**
	 * Setting up main window
	 *
	 * @param pane
	 */
	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// TODO: initialize txfValues, chbHolds, btnRoll and lblRolled

		txfValues = new TextField[5];
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i] = new TextField();
			txfValues[i].setDisable(true);
			txfValues[i].setFont(Font.font(25));
			txfValues[i].setAlignment(Pos.CENTER);
			txfValues[i].setMinSize(60, 60);
			txfValues[i].setMaxSize(60, 60);
			dicePane.add(txfValues[i], i, 0, 1, 1);
		}

		chbHolds = new CheckBox[5];
		for (int i = 0; i < chbHolds.length; i++) {
			chbHolds[i] = new CheckBox("Hold");
			dicePane.add(chbHolds[i], i, 1, 1, 1);
		}

		btnRoll = new Button("Roll");
		dicePane.add(btnRoll, 3, 2);

		lblRolled = new Label("Rolled: 0");
		dicePane.add(lblRolled, 4, 2);
		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");

		disableResult = new boolean[15];
		for (int i = 0; i < disableResult.length; i++) {
			disableResult[i] = false;
		}
		// TODO: Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.

		stringScore = new String[] { "1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One pair", "Two pair", "Three same",
				"Four same", "Full house", "Small straight", "Large straight", "Chance", "Yatzy" };

		lblScore = new Label[15];
		for (int i = 0; i < lblScore.length; i++) {
			lblScore[i] = new Label(stringScore[i]);
			scorePane.add(lblScore[i], 0, i, 1, 1);
		}

		txfResults = new TextField[15];
		for (int i = 0; i < txfResults.length; i++) {
			txfResults[i] = new TextField("0");
			txfResults[i].setDisable(true);
			txfResults[i].setMinSize(50, 25);
			txfResults[i].setMaxSize(50, 25);
			scorePane.add(txfResults[i], 1, i, 1, 1);
		}

		Label lblSumSames = new Label("Sum:");
		scorePane.add(lblSumSames, 2, 5);

		Label lblSumTotal = new Label("Sum:");
		scorePane.add(lblSumTotal, 2, 14);

		txfSumSame = new TextField("0");
		txfSumSame.setDisable(true);
		txfSumSame.setMaxWidth(50);
		scorePane.add(txfSumSame, 3, 5);

		txfSumOther = new TextField("0");
		txfSumOther.setDisable(true);
		txfSumOther.setMaxWidth(50);
		scorePane.add(txfSumOther, 3, 14);

		Label lblBonus = new Label("Bonus:");
		scorePane.add(lblBonus, 4, 5);

		Label lblTotal = new Label("Total:");
		scorePane.add(lblTotal, 4, 14);

		txfBonus = new TextField("0");
		txfBonus.setDisable(true);
		txfBonus.setMaxWidth(50);
		scorePane.add(txfBonus, 5, 5);

		txfTotal = new TextField("0");
		txfTotal.setDisable(true);
		txfTotal.setMaxWidth(50);
		scorePane.add(txfTotal, 5, 14);

		for (int i = 0; i < chbHolds.length; i++) {
			chbHolds[i].setDisable(true);
		}
		btnRoll.setOnAction(event -> this.buttonRoll());

		for (int i = 0; i < txfResults.length; i++) {
			int j = i; // Kan ikke videregive int i til metoden???
			txfResults[i].setOnMouseClicked(event -> addScore(j));
		}

	}

	// -------------------------------------------------------------------------

	// TODO: Create a method for btnRoll's action.
	// Hint: Create small helper methods to be used in the action method.
	/**
	 * calls diceroll and sets dicefacevalues to txfValues accordingly Furthermore
	 * it gets the values of possible results and sets txfResults accordingly
	 */
	private void buttonRoll() {
		// TODO Auto-generated method stub
		this.disableResults(disableResult);
		boolean[] arrholds = new boolean[chbHolds.length];
		for (int i = 0; i < chbHolds.length; i++) {
			chbHolds[i].setDisable(false);
		}
		for (int i = 0; i < arrholds.length; i++) {
			arrholds[i] = chbHolds[i].isSelected();
		}

		yatzy.throwDice(arrholds);
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i].setText("" + yatzy.getValues()[i]);
		}

		lblRolled.setText("Rolled: " + yatzy.getThrowCount());

		for (int i = 0; i < txfResults.length; i++) {
			if (!txfResults[i].isDisabled()) {
				txfResults[i].setText("" + yatzy.getPossibleResults()[i]);
			}

		}
		if (yatzy.getThrowCount() == 3) {

			btnRoll.setDisable(true);
		}

	}
	// -------------------------------------------------------------------------

	// TODO: Create a method for mouse click on one of the text fields in
	// txfResults.
	// Hint: Create small helper methods to be used in the mouse click method.
	/**
	 * adds to score to txfsumSames and sumOthers, checks if gameOverCover >= 15
	 * method calls gameOver()
	 *
	 * @param scoreIndex
	 */
	private void addScore(int scoreIndex) {
		// TODO Auto-generated method stub
		int sumSame = Integer.parseInt(txfSumSame.getText());
		txfResults[scoreIndex].setDisable(true);
		if (scoreIndex >= 0 && scoreIndex <= 5) {
			sumSame += Integer.parseInt(txfResults[scoreIndex].getText());
			txfSumSame.setText("" + sumSame);
		}
		int sumOther = Integer.parseInt(txfSumOther.getText());
		if (scoreIndex >= 5 && scoreIndex <= 14) {
			sumOther += Integer.parseInt(txfResults[scoreIndex].getText());
			txfSumOther.setText("" + sumOther);
		}
		calculateBonus();
		setTotalScore();
		for (int i = 0; i < txfResults.length; i++) {
			txfResults[i].setDisable(true);
		}
		disableResult[scoreIndex] = true;

		for (int i = 0; i < chbHolds.length; i++) {
			chbHolds[i].setSelected(false);
			txfValues[i].setText("");
		}
		btnRoll.setDisable(false);
		yatzy.resetThrowCount();
		lblRolled.setText("Rolled: 0");
		if (gameOverCount >= 15) {
			gameOver();
		}

	}

	/**
	 * Calculates whether a bonus can be achieved, sumSame >= 63 to achieve bonus
	 */
	private void calculateBonus() {
		// TODO Auto-generated method stub
		if (!bonusAchieved && Integer.parseInt(txfSumSame.getText()) >= 63) {
			txfBonus.setText("50");
			bonusAchieved = true;
		}
	}

	/**
	 * sets txfTotalScore as a summation of txfSumSame, txfSumOther and txfBonus
	 */
	private void setTotalScore() {
		// TODO Auto-generated method stub
		int sumSame = Integer.parseInt(txfSumSame.getText());
		int sumOther = Integer.parseInt(txfSumOther.getText());
		int sumBonus = Integer.parseInt(txfBonus.getText());
		txfTotal.setText("" + (sumSame + sumOther + sumBonus));
	}

	/**
	 * Checks whether a txfResult textfield should be enabled or disabled and
	 * Increments gameOverCount
	 *
	 * @param disableResult
	 */
	private void disableResults(boolean[] disableResult) {
		// TODO Auto-generated method stub
		for (int i = 0; i < txfResults.length; i++) {
			txfResults[i].setDisable(disableResult[i]);

		}
		gameOverCount++;

	}

	/**
	 * shows an Alert showing a Gameover Screen with final score, calls resetGame()
	 * when Alert is closed
	 */
	private void gameOver() {
		// TODO Auto-generated method stub
		gameOver = new Alert(AlertType.INFORMATION);
		gameOver.setTitle("YATZY!");
		gameOver.setHeaderText("WINNER!!");
		gameOver.setContentText("Congratulations you received a total score of: " + txfTotal.getText());
		gameOver.showAndWait();
		resetGame();
	}

	/**
	 * resets all values to their base values, so the game resets.
	 */
	private void resetGame() {
		// TODO Auto-generated method stub
		txfBonus.setText("0");
		txfSumSame.setText("0");
		txfSumOther.setText("0");
		txfTotal.setText("0");
		txfBonus.setText("0");
		btnRoll.setDisable(false);
		for (int i = 0; i < disableResult.length; i++) {
			disableResult[i] = false;
		}
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i].setText("");
		}
		gameOverCount = 0;

	}
}
