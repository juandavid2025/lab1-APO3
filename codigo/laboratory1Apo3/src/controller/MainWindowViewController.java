package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
	    
	    
	    public int getGrade() {
	    	int grade=0;
	    	
	    	    if(gradeTenTextField.getText()!=null) {
	    		    if(Integer.parseInt(gradeTenTextField.getText())!=0) {
	    			grade=10;
	    		}
	    		else if(gradeNineTextField.getText()!=null) {
	    			if(Integer.parseInt(gradeNineTextField.getText())!=0) {
		    			grade=9;
		    		}
	    		}
	    		else if(gradeEightTextField.getText()!=null) {
	    			if(Integer.parseInt(gradeEightTextField.getText())!=0) {
		    			grade=8;
		    		}
	    		}
	    		else if(gradeSeventTextField.getText()!=null) {
	    			if(Integer.parseInt(gradeSeventTextField.getText())!=0) {
		    			grade=7;
		    		}
	    		}
	    		else if(gradeSixTextField.getText()!=null) {
	    			if(Integer.parseInt(gradeSixTextField.getText())!=0) {
		    			grade=6;
		    		}
	    		}
	    		else if(gradeFiveTextField.getText()!=null) {
	    			if(Integer.parseInt(gradeFiveTextField.getText())!=0) {
		    			grade=5;
		    		}
	    		}
	    		else if(gradeFourTextField.getText()!=null) {
	    			if(Integer.parseInt(gradeFourTextField.getText())!=0) {
		    			grade=4;
		    		}
	    		}
	    		else if(gradethreeTextField.getText()!=null) {
	    			if(Integer.parseInt(gradethreeTextField.getText())!=0) {
		    			grade=3;
		    		}
	    		}
	    		else if(gradeTwoTextField.getText()!=null) {
	    			if(Integer.parseInt(gradeTwoTextField.getText())!=0) {
		    			grade=2;
		    		}
	    		}
	    		else if(gradeOneTextField.getText()!=null) {
	    			if(Integer.parseInt(gradeOneTextField.getText())!=0) {
		    			grade=1;
		    		}
	    		}
	    		else if(constantTextField.getText()!=null) {
	    			if(Integer.parseInt(constantTextField.getText())!=0) {
		    			grade=0;
		    		}
	    		}
	    	}
	    	
	    	return grade;
	    }
	    
	    public int[] getCoefficients() {
	    	/*
	    	try {
	    	 getGrade();
	    	}
	    	catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, "Please imput valid type of data");
	    	}
	    	*/
	    	int[] coefficients = new int[getGrade()+1];
	    	
	    	int grade=getGrade();
	    	switch(grade){
	    	
	    	case 10:{
	    		if(gradeTenTextField.getText()!=null) {
	    			coefficients[10]=Integer.parseInt(gradeTenTextField.getText());
	    		 }
	    		}
	    	case 9:{
	    		if(gradeNineTextField.getText()!=null) {
	    			coefficients[9]=Integer.parseInt(gradeNineTextField.getText());
	    		 }
	    		else {
	    			coefficients[9]=0;
	    		 }
	    		}
	    	case 8:{
	    		if(gradeEightTextField.getText()!=null) {
	    			coefficients[8]=Integer.parseInt(gradeEightTextField.getText());
	    		 }
	    		else {
	    			coefficients[8]=0;
	    		 }
	    		}
	    	case 7:{
	    		if(gradeSeventTextField.getText()!=null) {
	    			coefficients[7]=Integer.parseInt(gradeSeventTextField.getText());
	    		 }
	    		else {
	    			coefficients[7]=0;
	    		 }
	    		}
	    	case 6:{
	    		if(gradeSixTextField.getText()!=null) {
	    			coefficients[6]=Integer.parseInt(gradeSixTextField.getText());
	    		 }
	    		else {
	    			coefficients[6]=0;
	    		 }
	    		}
	    	case 5:{
	    		if(gradeFiveTextField.getText()!=null) {
	    			coefficients[5]=Integer.parseInt(gradeFiveTextField.getText());
	    		 }
	    		else {
	    			coefficients[5]=0;
	    		 }
	    		}
	    	case 4:{
	    		if(gradeFourTextField.getText()!=null) {
	    			coefficients[4]=Integer.parseInt(gradeFourTextField.getText());
	    		 }
	    		else {
	    			coefficients[4]=0;
	    		 }
	    		}
	    	case 3:{
	    		if(gradethreeTextField.getText()!=null) {
	    			coefficients[3]=Integer.parseInt(gradethreeTextField.getText());
	    		 }
	    		else {
	    			coefficients[3]=0;
	    		 }
	    		}
	    	case 2:{
	    		if(gradeTwoTextField.getText()!=null) {
	    			coefficients[2]=Integer.parseInt(gradeTwoTextField.getText());
	    		 }
	    		else {
	    			coefficients[2]=0;
	    		 }
	    		}
	    	case 1:{
	    		if(gradeOneTextField.getText()!=null) {
	    			coefficients[1]=Integer.parseInt(gradeOneTextField.getText());
	    		 }
	    		else {
	    			coefficients[1]=0;
	    		 }
	    		}
	    	case 0:{
	    		if(constantTextField.getText()!=null) {
	    			coefficients[0]=Integer.parseInt(constantTextField.getText());
	    		 }
	    		else {
	    			coefficients[0]=0;
	    		 }
	    	 }
	    	}
	    	
	    	
	    	
	    	return coefficients;
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
