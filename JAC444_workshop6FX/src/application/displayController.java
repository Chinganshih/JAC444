package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class displayController implements Initializable {
	
	ArrayList<Student> stdList = new ArrayList<Student>();

    @FXML
    private HBox hBox;
    @FXML
    private GridPane stdContainer;
	
	@Override
	public void initialize(URL url, ResourceBundle eb) {
		int column = 0, row = 1;
		
		try {
			File f = new File("Studentfile.out");
			
			if(f.exists()) {
				FileInputStream fis = new FileInputStream("Studentfile.out");
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				stdList = (ArrayList) ois.readObject();
				fis.close();
				
				
				for(Student std: stdList) {
					
					FXMLLoader fxmlLoader = new FXMLLoader();
					fxmlLoader.setLocation(getClass().getResource("Student.fxml"));
					HBox stdBox = fxmlLoader.load();
					StudentController stdController = fxmlLoader.getController();
					stdController.setData(std);
					
					if(column == 2) {
						column = 0;
						++row;
					}
					
					stdContainer.add(stdBox, column++, row);
					
				}
			}
			
			
		}catch(Throwable e) {
			System.err.println(e);
		}
		
	}
	

}
