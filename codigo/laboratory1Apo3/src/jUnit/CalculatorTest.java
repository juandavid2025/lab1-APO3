package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Calculator;
import model.Polynomial;

class CalculatorTest {

	Calculator calculator;
	Polynomial polynomial10;
	Polynomial polynomial9;
	Polynomial polynomial8;
	Polynomial polynomial7;
	Polynomial polynomial6;
	Polynomial polynomial5;
	Polynomial polynomial4;
	Polynomial polynomial3;
	Polynomial polynomial2;
	Polynomial polynomial1;
	Polynomial polynomial0;
	
	
	@Test
	void setUpScene1() {
		double[] gradeTenArray = new double[11];
		double[] gradeNineArray = new double[10];			
		double[] gradeEightArray = new double[9];
		double[] gradeSeventArray = new double[8];
		double[] gradeSixtArray = new double[7];
		double[] gradeFiveArray = new double[6];
		double[] gradeFourArray = new double[5];
		double[] gradeThreeArray = new double[4];
		double[] gradeTwoArray = new double[3];
		double[] gradeOneArray = new double[2];
		double[] gradeConstantArray = new double[1];
		
		calculator = new Calculator();
		/*
		polynomial10= new Polynimial();
		polynomial9= new Polynimial();
		polynomial8= new Polynimial();
		polynomial7= new Polynimial();
		polynomial6= new Polynimial();
		polynomial5= new Polynimial();
		polynomial4= new Polynimial();
		polynomial3= new Polynimial();
		polynomial2= new Polynimial();
		polynomial1= new Polynimial();
		polynomial0= new Polynimial();
	*/
	}

	
	
}
