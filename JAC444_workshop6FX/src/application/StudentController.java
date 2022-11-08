package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StudentController {

	 @FXML
	    private Label courseLabel;

	    @FXML
	    private Label firstLabel;

	    @FXML
	    private Label idLabel;

	    @FXML
	    private Label lastLabel;
	    
	    @FXML
	    private ImageView imageView;
	    
	public void setData(Student std) {
		
		Image image = new Image(getClass().getResourceAsStream("/application/image/people.png"));
		imageView.setImage(image);
		idLabel.setText(String.valueOf(std.getStdID()));
		lastLabel.setText(std.getLastName());
		firstLabel.setText(std.getFirstName());
		courseLabel.setText(std.getCourses().toString());
	}
	
}
