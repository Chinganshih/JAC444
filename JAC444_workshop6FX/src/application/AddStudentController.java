package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class AddStudentController implements Initializable {

	//Table
	@FXML
	private TableView<Student> tableView;
	
	//Column
	@FXML
	private TableColumn<Student, Number> IDcolumn;
	@FXML
	private TableColumn<Student, String> Lastcolumn;
	@FXML
	private TableColumn<Student, String> Firstcolumn;
	@FXML
	private TableColumn<Student, ArrayList<String>> Coursecolumn;
	
	//Text Input
	@FXML
	private TextField idInput;
	@FXML
	private TextField lastInput;
	@FXML
	private TextField firstInput;
	@FXML
	private TextField courseInput;

	//Button
	@FXML
	private Button addBtn;
	@FXML
	private Button saveBtn;
	@FXML
	private Button removeBtn;
	
	ArrayList<Student> std = new ArrayList<Student>();
	
	@Override
	public void initialize(URL url, ResourceBundle eb) {
		
		IDcolumn.setCellValueFactory(cellData -> new ReadOnlyIntegerWrapper(cellData.getValue().getStdID()));
		Lastcolumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLastName()));
		Firstcolumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getFirstName()));
		Coursecolumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<ArrayList<String>>(cellData.getValue().getCourses()));
		
		try {
			File f = new File("Studentfile.out");
			
			if(f.exists()) {
				FileInputStream fis = new FileInputStream("Studentfile.out");
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				std = (ArrayList) ois.readObject();
				fis.close();
					
				ObservableList<Student> students = tableView.getItems();
				for(Student student: std) {
					students.add(student);
				}
				tableView.setItems(students);
				
			}
			
		}catch(Throwable e) {
			System.err.println(e);
		}
		
		
	}
	
	public void inputValid() {
		
		if(idInput.getText().length() == 0) {
			idInput.setStyle("-fx-border-color: red; -fx-border-width: 2px ;");
		}else idInput.setStyle(null);
	
	
		if(lastInput.getText().length() == 0) {
			lastInput.setStyle("-fx-border-color: red; -fx-border-width: 2px ;");
		}else lastInput.setStyle(null);
		
		
		if(firstInput.getText().length() == 0) {
			firstInput.setStyle("-fx-border-color: red; -fx-border-width: 2px ;");
		}else firstInput.setStyle(null);
		
		if(courseInput.getText().length() == 0) {
			courseInput.setStyle("-fx-border-color: red; -fx-border-width: 2px ;");
		}else courseInput.setStyle(null);
		
		
	}
	
	//Add Student Button
	public void add(ActionEvent event) {
		
		inputValid();
		
		if(idInput.getText().length() > 0 && lastInput.getText().length() > 0 && firstInput.getText().length() > 0 && courseInput.getText().length() > 0) {
			ArrayList<String> courses = new ArrayList<String>(Arrays.asList(courseInput.getText().split(",")));
			Student student = new Student(Integer.parseInt(idInput.getText()), firstInput.getText(), lastInput.getText(), courses);
			ObservableList<Student> students = tableView.getItems();
			students.add(student);
			std.add(student);
			tableView.setItems(students);
			
			idInput.clear();
			lastInput.clear();
			firstInput.clear();
			courseInput.clear();
		}
		
	}
	
	//Remove Student data
	public void remove(ActionEvent event) {
		int selectID = tableView.getSelectionModel().getSelectedIndex();
		
		if(selectID < 0) {
			Alert alert = new Alert(AlertType.ERROR, "Please select a student to remove!");
			alert.showAndWait();
		}else {
			tableView.getItems().remove(selectID);
			std.remove(selectID);
		}
		
	}
	
	//Save Student data
	public void save(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.INFORMATION, "Save All Students' Info successfully!");
		alert.showAndWait();
				
		try {
			
			FileOutputStream fos = new FileOutputStream("Studentfile.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(std);
			oos.flush();
			fos.close();
			
		}catch(Throwable e) {
			System.err.println(e);
		}
	}
}
