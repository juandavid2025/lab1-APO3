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
		calculator = new Calculator();
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
	}

	
	
}
