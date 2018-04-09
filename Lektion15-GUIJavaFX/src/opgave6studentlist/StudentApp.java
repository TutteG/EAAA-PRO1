package opgave6studentlist;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentApp extends Application {

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

	// -------------------------------------------------------------------------

	private ArrayList<Student> arrayStudent = new ArrayList<Student>();
	private TextField txfName;
	private TextField txfAge;
	private CheckBox chkActive;
	private TextArea txAInf;
	// private ComboBox<Student> cmbStudent;

	private Button btnAdd;
	private Button btnSave;
	private Button btnGet;
	private Button btnDelete;
	private Button btnBirthday;

	private Controller controller = new Controller();

	private void initContent(GridPane pane) {

		// show or hide grid lines
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(25));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		txAInf = new TextArea();
		txAInf.setEditable(false);
		txAInf.setPrefWidth(230);
		txAInf.setPrefHeight(60);
		pane.add(txAInf, 0, 0, 5, 1);
		// cmbStudent = new ComboBox<>();
		// pane.add(cmbStudent, 0, 0, 2, 2);

		Label lblName = new Label("Navn");
		pane.add(lblName, 0, 1);
		Label lblActive = new Label("Aktiv");
		pane.add(lblActive, 0, 4);

		txfName = new TextField();
		pane.add(txfName, 1, 1, 4, 1);

		Label lblAge = new Label("Age");
		pane.add(lblAge, 0, 2);
		txfAge = new TextField();
		pane.add(txfAge, 1, 2);

		chkActive = new CheckBox();
		pane.add(chkActive, 1, 4);

		// add a buttons to the pane
		btnAdd = new Button("Create");
		pane.add(btnAdd, 0, 5);
		btnSave = new Button("Save");
		btnSave.setDisable(true);
		pane.add(btnSave, 1, 5);
		btnGet = new Button("Load");
		btnGet.setDisable(true);
		pane.add(btnGet, 2, 5);
		btnDelete = new Button("Delete");
		pane.add(btnDelete, 3, 5);
		btnDelete.setDisable(true);
		btnBirthday = new Button("BIRTHDAY!");
		pane.add(btnBirthday, 4, 5);

		// connect a method to the button
		btnAdd.setOnAction(event -> this.controller.addAction());
		btnSave.setOnAction(event -> this.controller.saveAction());
		btnGet.setOnAction(event -> this.controller.getAction());
		btnDelete.setOnAction(event -> this.controller.deleteAction());
		btnBirthday.setOnAction(event -> this.controller.birthdayAction());

	}

	/**
	 * This class controls access to the model in this application. In this case,
	 * the model is a single Student object.
	 */
	private class Controller {
		private Student studerende = null;

		private void birthdayAction() {
			studerende.increaseAge();
			txAInf.setText(getDescription());
		}

		private void addAction() {
			// if (studerende == null) {
			studerende = new Student(txfName.getText().trim(), Integer.parseInt(txfAge.getText()),
					chkActive.isSelected());
			clearFields();
			arrayStudent.add(studerende);
			txAInf.setText(getDescription());
			arrayStudent.add(studerende);
			btnGet.setDisable(false);
			btnAdd.setDisable(false);

			// }
		}

		private void saveAction() {
			if (studerende != null) {
				studerende.setName(txfName.getText().trim());
				studerende.setActive(chkActive.isSelected());
				studerende.setAge(Integer.parseInt(txfAge.getText()));
				clearFields();
				txAInf.setText(getDescription());
				btnSave.setDisable(false);
				btnDelete.setDisable(false);
				btnGet.setDisable(false);

			}
		}

		private void getAction() {
			for (Student student : arrayStudent) {
				if (student.getName().contentEquals(txfName.getText())) {
					txfName.setText(student.getName());
					txfAge.setText("" + student.getAge());
					chkActive.setSelected(student.isActive());
					txAInf.setText(getDescription());
					btnSave.setDisable(false);
					btnDelete.setDisable(false);
					btnGet.setDisable(false);
					break;
				}

			}
		}

		private void deleteAction() {
			if (studerende != null) {
				studerende = null;
				clearFields();
				txAInf.clear();
				btnDelete.setDisable(true);
				btnSave.setDisable(true);
				btnGet.setDisable(true);
				btnAdd.setDisable(false);
			}
		}

		private void clearFields() {
			txfName.clear();
			txfAge.clear();
			chkActive.setSelected(false);
		}

		private String getDescription() {
			String result = "Ingen studerende gemt";

			if (studerende != null) {
				result = studerende.toString();
			}
			return result;
		}
	}
}
