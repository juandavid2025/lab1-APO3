package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Calculator;

public class MainWindowViewController implements Initializable{

	private Calculator world;
	
	 @FXML
	    private TextField gradeTenTextField;

	    @FXML
	    private TextField constantTextField;

	    @FXML
	    private TextField gradeTwoTextField;

	    @FXML
	    private TextField gradeSeventTextField;

	    @FXML
	    private TextField gradeOneTextField;

	    @FXML
	    private TextField gradethreeTextField;

	    @FXML
	    private TextField gradeSixTextField;

	    @FXML
	    private TextField gradeFourTextField;

	    @FXML
	    private TextField gradeFiveTextField;

	    @FXML
	    private TextField gradeEightTextField;

	    @FXML
	    private TextField gradeNineTextField;

	    @FXML
	    private TextArea resultTextArea;

	    @FXML
	    private Button newtonButton;

	    @FXML
	    private Button syntheticButton;

	    @FXML
	    private Button randomButton;

	    @FXML
	    void newtonClicked(ActionEvent event) {

	    }

	    @FXML
	    void ramdomClicked(ActionEvent event) {
           
	    	int[] coefficients = world.generateRandomPolynomial();
	    	
	    	int n = coefficients.length;
	    	
	    	switch(n) {
	    	
	    		case 11:{
	    		
	    			gradeTenTextField.setText(""+coefficients[10]);
	    			
	    	}
	    		case 10:{
	    		
	    			gradeNineTextField.setText(""+coefficients[9]);
	    			
	    	}
	    		case 9:{
	    		
	    			gradeEightTextField.setText(""+coefficients[8]);
	    			
	    	}
	    		case 8:{
            	
	    			gradeSeventTextField.setText(""+coefficients[7]);
	    			
            }
	    		case 7:{
            	
	    			gradeSixTextField.setText(""+coefficients[6]);
	    			
            }
	    		case 6:{
            	
	    			gradeFiveTextField.setText(""+coefficients[5]);
	    			
            }
	    		case 5:{
            	
	    			gradeFourTextField.setText(""+coefficients[4]);
	    			
            }
	    		case 4:{
            	
	    			gradethreeTextField.setText(""+coefficients[3]);
	    			
            }
	    		case 3:{
            	
	    			gradeTwoTextField.setText(""+coefficients[2]);
	    			
            }
	    		case 2:{
            	
	    			gradeOneTextField.setText(""+coefficients[1]);
	    			
            }
	    		case 1:{
	    			
	    			constantTextField.setText(""+coefficients[0]);
	    			
	    		}
	    	
	      }
	    	
	    }

	    @FXML
	    void syntheticClicked(ActionEvent event) {

	    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		world = new Calculator();
		
	}

}
