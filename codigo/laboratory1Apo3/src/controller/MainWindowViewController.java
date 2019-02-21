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
import model.Polynomial;
import threads.MethodsThread;

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

	    	try {
	    		
		    	 double[] coefficients = getCoefficients();
		    	 int grade = getGrade();
		    	
		    	
		    	 Polynomial p1 = new Polynomial(grade,invertArray(coefficients));
		    	 
		    	 MethodsThread mt=new MethodsThread(1,p1,this);
		    	 mt.start();
		    	 
		    	}
		    	catch(Exception e) {
		    		JOptionPane.showMessageDialog(null, "Please input valid type of data");
		    	}
	    	
	    }
	    
	    public void cleanBoxes() {
	    
	    	gradeTenTextField.setText("");
	    	gradeNineTextField.setText("");
	    	gradeEightTextField.setText("");
	    	gradeSeventTextField.setText("");
	    	gradeSixTextField.setText("");
	    	gradeFiveTextField.setText("");
	    	gradeFourTextField.setText("");
	    	gradethreeTextField.setText("");
	    	gradeTwoTextField.setText("");
	    	gradeOneTextField.setText("");
	    	constantTextField.setText("");
	    
	    }
	    
	    public int getGrade() {
	    	int grade=0;
	    	
	    	//System.out.println(gradeTenTextField.getText()!=null);
	    	//System.out.println(!(gradeTenTextField.getText().equals("")));
	    	
	    	    if(gradeTenTextField.getText()!=null && !(gradeTenTextField.getText().equals(""))) {
	    		    if(Integer.parseInt(gradeTenTextField.getText())!=0) {
	    			grade=10;
	    			
	    		 }
	    	    }
	    		else if(gradeNineTextField.getText()!=null && !(gradeNineTextField.getText().equals(""))) {
	    			if(Integer.parseInt(gradeNineTextField.getText())!=0) {
		    			grade=9;
		    			
		    		}
	    		}
	    		else if(gradeEightTextField.getText()!=null && !(gradeEightTextField.getText().equals(""))) {
	    			if(Integer.parseInt(gradeEightTextField.getText())!=0) {
		    			grade=8;
		    			
		    		}
	    		}
	    		else if(gradeSeventTextField.getText()!=null && !(gradeSeventTextField.getText().equals(""))) {
	    			if(Integer.parseInt(gradeSeventTextField.getText())!=0) {
		    			grade=7;
		    			
		    		}
	    		}
	    		else if(gradeSixTextField.getText()!=null && !(gradeSixTextField.getText().equals(""))) {
	    			if(Integer.parseInt(gradeSixTextField.getText())!=0) {
		    			grade=6;
		    		}
	    		}
	    		else if(gradeFiveTextField.getText()!=null && !(gradeFiveTextField.getText().equals(""))) {
	    			if(Integer.parseInt(gradeFiveTextField.getText())!=0) {
		    			grade=5;
		    		}
	    		}
	    		else if(gradeFourTextField.getText()!=null && !(gradeFourTextField.getText().equals(""))) {
	    			if(Integer.parseInt(gradeFourTextField.getText())!=0) {
		    			grade=4;
		    		}
	    		}
	    		else if(gradethreeTextField.getText()!=null && !(gradethreeTextField.getText().equals(""))) {
	    			if(Integer.parseInt(gradethreeTextField.getText())!=0) {
		    			grade=3;
		    		}
	    		}
	    		else if(gradeTwoTextField.getText()!=null && !(gradeTwoTextField.getText().equals(""))) {
	    			if(Integer.parseInt(gradeTwoTextField.getText())!=0) {
		    			grade=2;
		    		}
	    		}
	    		else if(gradeOneTextField.getText()!=null && !(gradeOneTextField.getText().equals(""))) {
	    			if(Integer.parseInt(gradeOneTextField.getText())!=0) {
		    			grade=1;
		    		}
	    		}
	    		else if(constantTextField.getText()!=null && !(constantTextField.getText().equals(""))) {
	    			if(Integer.parseInt(constantTextField.getText())!=0) {
		    			grade=0;
		    		}
	    		}
	    	    return grade;
	    }
	    	
	    	
	    
	    
	    public double[] getCoefficients() {
	    	double[] coefficients = new double[getGrade()+1];
	    	int position=0;
	    	int grade=getGrade();
	    	switch(grade){
	    	
	    	case 10:{
	    		if(gradeTenTextField.getText()!=null) {
	    			coefficients[position]=Integer.parseInt(gradeTenTextField.getText());
	    			position++;
	    		 }
	    		}
	    	case 9:{
	    		if(gradeNineTextField.getText()!=null && !(gradeNineTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(gradeNineTextField.getText());
	    			position++;
	    		 }
	    		else {
	    			coefficients[position]=0;
	    			position++;
	    		 }
	    		}
	    	case 8:{
	    		if(gradeEightTextField.getText()!=null && !(gradeEightTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(gradeEightTextField.getText());
	    			position++;
	    		 }
	    		else {
	    			coefficients[position]=0;
	    			position++;
	    		 }
	    		}
	    	case 7:{
	    		if(gradeSeventTextField.getText()!=null && !(gradeSeventTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(gradeSeventTextField.getText());
	    			position++;
	    		 }
	    		else {
	    			coefficients[position]=0;
	    			position++;
	    		 }
	    		}
	    	case 6:{
	    		if(gradeSixTextField.getText()!=null && !(gradeSixTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(gradeSixTextField.getText());
	    			position++;
	    		 }
	    		else {
	    			coefficients[position]=0;
	    			position++;
	    		 }
	    		}
	    	case 5:{
	    		if(gradeFiveTextField.getText()!=null && !(gradeFiveTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(gradeFiveTextField.getText());
	    			position++;
	    		 }
	    		else {
	    			coefficients[position]=0;
	    			position++;
	    		 }
	    		}
	    	case 4:{
	    		if(gradeFourTextField.getText()!=null && !(gradeFourTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(gradeFourTextField.getText());
	    			position++;
	    		 }
	    		else {
	    			coefficients[position]=0;
	    			position++;
	    		 }
	    		}
	    	case 3:{
	    		if(gradethreeTextField.getText()!=null && !(gradethreeTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(gradethreeTextField.getText());
	    		 }
	    		else {
	    			coefficients[position]=0;
	    		 }
	    		}
	    	case 2:{
	    		if(gradeTwoTextField.getText()!=null && !(gradeTwoTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(gradeTwoTextField.getText());
	    			position++;
	    		 }
	    		else {
	    			coefficients[position]=0;
	    			position++;
	    		 }
	    		}
	    	case 1:{
	    		if(gradeOneTextField.getText()!=null && !(gradeOneTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(gradeOneTextField.getText());
	    			position++;
	    		 }
	    		else {
	    			coefficients[position]=0;
	    			position++;
	    		 }
	    		}
	    	case 0:{
	    		if(constantTextField.getText()!=null && !(constantTextField.getText().equals(""))) {
	    			coefficients[position]=Integer.parseInt(constantTextField.getText());
	    			position++;
	    		 }
	    		else {
	    			coefficients[position]=0;
	    			position++;
	    		 }
	    	 }
	    	}
	    	
	    	
	    	
	    	return coefficients;
	    }
	    
	    public double[] invertArray(double[] arrayToInvert) {
	    	double[] invertedArray = new double[arrayToInvert.length];
	    	
	    	int j= arrayToInvert.length-1;
	    	
	    	for(int i=0;i<arrayToInvert.length;i++) {
	    		invertedArray[i]=arrayToInvert[j];
	    		j--;
	    	}
	    	
	    	return invertedArray;
	    }

	    @FXML
	    void ramdomClicked(ActionEvent event) {
           
	    	cleanBoxes();
	    	
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

	    	try {
		    	 double[] coefficients = getCoefficients();
		    	 int grade = getGrade();
		    	 Polynomial p1 = new Polynomial(grade,invertArray(coefficients));
		    	 
		    	 MethodsThread mt= new MethodsThread(2,p1,this);
		    	mt.start();
		    	 
		    	}
		    	catch(Exception e) {
		    		JOptionPane.showMessageDialog(null, "Please input valid type of data");
		    	}
	    	
	    }
	    
	    public void setTextArea(String  roots) {
	    	resultTextArea.setText(""+roots);
	    }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		world = new Calculator();
		
	}

}
