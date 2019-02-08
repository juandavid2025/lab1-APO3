package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.World;

public class MainWindowViewController implements Initializable{

	private World world;
	
	 @FXML
	    private Button randomPolynomialButton;

	    @FXML
	    private Button newtonMethodButton;

	    @FXML
	    void newtonMethodClicked(ActionEvent event) {

	    }

	    @FXML
	    void randomPolymialClicked(ActionEvent event) {

	    	int [] coefficients = world.generateRandomPolynomial();
	    	
	    	int grade = coefficients.length;
	    	
	    	
	    	
	    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		world = new World();
		
	}

}
